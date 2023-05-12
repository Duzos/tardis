package com.duzo.tardis.network.packets;

import com.duzo.tardis.tardis.consoles.blocks.entities.ConsoleBlockEntity;
import com.duzo.tardis.tardis.doors.blocks.InteriorDoorBlockEntity;
import com.duzo.tardis.tardis.exteriors.blocks.entities.ExteriorBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class UpdateInteriorDoorS2CPacket {
    public boolean messageIsValid;
    private boolean doorOpened;
    private BlockPos pos;

    public UpdateInteriorDoorS2CPacket(BlockPos doorPos, boolean doorOpened) {
        this.doorOpened = doorOpened;
        this.pos = doorPos;
        this.messageIsValid = true;
    }
    public UpdateInteriorDoorS2CPacket() {
        this.messageIsValid = false;
    }

    public static UpdateInteriorDoorS2CPacket decode(FriendlyByteBuf buf) {
        UpdateInteriorDoorS2CPacket packet = new UpdateInteriorDoorS2CPacket();

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

                InteriorDoorBlockEntity entity = (InteriorDoorBlockEntity) level.getBlockEntity(this.pos);
                if (entity == null) {return;}

                entity.setDoorOpened(this.doorOpened);
            });
        });
        return true;
    }
}
