package com.duzo.tardis.network.packets;

import com.duzo.tardis.tardis.exteriors.blocks.entities.ExteriorBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class UpdateExteriorDataS2CPacket {
    public boolean messageIsValid;

    private float alpha;
    private BlockPos pos;

    public UpdateExteriorDataS2CPacket(BlockPos pos, float alpha) {
        this.pos = pos;
        this.alpha = alpha;
        this.messageIsValid = true;
//        System.out.println("created new update exterior data packet with info + " + alpha + " " + pos);
    }
    public UpdateExteriorDataS2CPacket() {
        this.messageIsValid = false;
    }

    public static UpdateExteriorDataS2CPacket decode(FriendlyByteBuf buf) {
        UpdateExteriorDataS2CPacket packet = new UpdateExteriorDataS2CPacket();

        try {
            BlockPos pos = buf.readBlockPos();

            packet.alpha = buf.readFloat();
            packet.pos = pos;
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
        buf.writeFloat(this.alpha);
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

                entity.getAnimation().setAlpha(this.alpha);
            });
        });
        return true;
    }
}
