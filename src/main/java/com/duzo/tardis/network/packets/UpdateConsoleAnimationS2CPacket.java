package com.duzo.tardis.network.packets;

import com.duzo.tardis.tardis.animation.ConsoleAnimation;
import com.duzo.tardis.tardis.animation.ExteriorAnimation;
import com.duzo.tardis.tardis.animation.impl.BorealisAnimation;
import com.duzo.tardis.tardis.animation.impl.ClassicAnimation;
import com.duzo.tardis.tardis.consoles.blocks.entities.ConsoleBlockEntity;
import com.duzo.tardis.tardis.exteriors.blocks.entities.ExteriorBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class UpdateConsoleAnimationS2CPacket {
    public boolean messageIsValid;

    private float ticking;
    private BlockPos pos;
    private boolean firstRun;

    public UpdateConsoleAnimationS2CPacket(BlockPos pos, float ticking, boolean firstRun) {
        this.pos = pos;
        this.ticking = ticking;
        this.firstRun = firstRun;
        this.messageIsValid = true;
    }
    public UpdateConsoleAnimationS2CPacket(BlockPos pos, float ticking) {
        this.pos = pos;
        this.ticking = ticking;
        this.firstRun = false;
        this.messageIsValid = true;
    }
    public UpdateConsoleAnimationS2CPacket() {
        this.messageIsValid = false;
    }

    public static UpdateConsoleAnimationS2CPacket decode(FriendlyByteBuf buf) {
        UpdateConsoleAnimationS2CPacket packet = new UpdateConsoleAnimationS2CPacket();

        try {
            BlockPos pos = buf.readBlockPos();

            packet.ticking = buf.readFloat();
            packet.pos = pos;
            packet.firstRun = buf.readBoolean();
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            System.out.println("Exception while reading Packet: " + e);
            return packet;
        }

        packet.messageIsValid = true;
        return packet;
    }

    public void encode(FriendlyByteBuf buf) {
        if (!this.messageIsValid) return;

        buf.writeBlockPos(this.pos);
        buf.writeFloat(this.ticking);
        buf.writeBoolean(this.firstRun);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // Make sure it's only executed on the physical client
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
                Level level = Minecraft.getInstance().level;

                if (level == null) {return;}

                ConsoleBlockEntity entity = (ConsoleBlockEntity) level.getBlockEntity(this.pos);
                if (entity == null) {return;}

                ConsoleAnimation animation = entity.getAnimation();
                animation.setTicking(this.ticking);

                if (animation instanceof BorealisAnimation borealis) {
                    borealis.setFirstRun(this.firstRun);
                }
            });
        });
        return true;
    }
}
