package com.duzo.tardis.network.packets;

import com.duzo.tardis.tardis.controls.blocks.ControlBlockEntity;
import com.duzo.tardis.tardis.controls.blocks.basics.DematControlBlockEntity;
import com.duzo.tardis.tardis.controls.blocks.basics.HandbrakeControlBlockEntity;
import com.duzo.tardis.tardis.exteriors.blocks.entities.ExteriorBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class UpdateLeverPulledS2CPacket {
    public boolean messageIsValid;
    private boolean pulled;
    private BlockPos pos;

    public UpdateLeverPulledS2CPacket(BlockPos exteriorPos,boolean pulled) {
        this.pulled = pulled;
        this.pos = exteriorPos;
        this.messageIsValid = true;
    }
    public UpdateLeverPulledS2CPacket() {
        this.messageIsValid = false;
    }

    public static UpdateLeverPulledS2CPacket decode(FriendlyByteBuf buf) {
        UpdateLeverPulledS2CPacket packet = new UpdateLeverPulledS2CPacket();

        try {
            packet.pulled = buf.readBoolean();
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

        buf.writeBoolean(this.pulled);
        buf.writeBlockPos(this.pos);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // Make sure it's only executed on the physical client
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
                Level level = Minecraft.getInstance().level;

                if (level == null) {return;}

                if (!(level.getBlockEntity(this.pos) instanceof DematControlBlockEntity entity || level.getBlockEntity(this.pos) instanceof HandbrakeControlBlockEntity)) {
                    return;
                }

                ControlBlockEntity entity = (ControlBlockEntity) level.getBlockEntity(this.pos);
                if (entity == null) {return;}

                if (entity instanceof DematControlBlockEntity) {
                    ((DematControlBlockEntity) entity).setPulled(this.pulled);
                }
                else if (entity instanceof HandbrakeControlBlockEntity) {
                    ((HandbrakeControlBlockEntity) entity).setPulled(this.pulled);
                }
            });
        });
        return true;
    }
}
