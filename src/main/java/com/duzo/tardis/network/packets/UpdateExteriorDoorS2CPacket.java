package com.duzo.tardis.network.packets;

import com.duzo.tardis.tardis.animation.ExteriorAnimation;
import com.duzo.tardis.tardis.animation.impl.ClassicAnimation;
import com.duzo.tardis.tardis.exteriors.blocks.entities.ExteriorBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class UpdateExteriorDoorS2CPacket {
    public boolean messageIsValid;
    private boolean doorOpened;
    private BlockPos pos;

    public UpdateExteriorDoorS2CPacket(BlockPos exteriorPos,boolean doorOpened) {
        this.doorOpened = doorOpened;
        this.pos = exteriorPos;
        this.messageIsValid = true;
    }
    public UpdateExteriorDoorS2CPacket() {
        this.messageIsValid = false;
    }

    public static UpdateExteriorDoorS2CPacket decode(FriendlyByteBuf buf) {
        UpdateExteriorDoorS2CPacket packet = new UpdateExteriorDoorS2CPacket();

        try {
            packet.doorOpened = buf.readBoolean();
            packet.pos = buf.readBlockPos();
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            System.out.println("Exception while reading Packet: " + e);
            return packet;
        }

        packet.messageIsValid = true;
        return packet;
    }

    public void encode(FriendlyByteBuf buf) {
        if (!this.messageIsValid) return;

        buf.writeBoolean(this.doorOpened);
        buf.writeBlockPos(this.pos);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // Make sure it's only executed on the physical client
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
                Level level = Minecraft.getInstance().level;

                if (level == null) {return;}

                ExteriorBlockEntity entity = (ExteriorBlockEntity) level.getBlockEntity(this.pos);
                if (entity == null) {return;}

                entity.setDoorOpened(this.doorOpened);
            });
        });
        return true;
    }
}
