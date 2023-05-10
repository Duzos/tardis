package com.duzo.tardis.network.packets;

import com.duzo.tardis.tardis.consoles.blocks.entities.ConsoleBlockEntity;
import com.duzo.tardis.tardis.controls.blocks.ControlBlockEntity;
import com.duzo.tardis.tardis.controls.blocks.basics.DematControlBlockEntity;
import com.duzo.tardis.tardis.controls.blocks.basics.HandbrakeControlBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class UpdateFlightStateS2CPacket {
    public boolean messageIsValid;
    private boolean inFlight;
    private BlockPos pos;

    public UpdateFlightStateS2CPacket(BlockPos consolePos, boolean inFlight) {
        this.inFlight = inFlight;
        this.pos = consolePos;
        this.messageIsValid = true;
    }
    public UpdateFlightStateS2CPacket() {
        this.messageIsValid = false;
    }

    public static UpdateFlightStateS2CPacket decode(FriendlyByteBuf buf) {
        UpdateFlightStateS2CPacket packet = new UpdateFlightStateS2CPacket();

        try {
            packet.inFlight = buf.readBoolean();
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

        buf.writeBoolean(this.inFlight);
        buf.writeBlockPos(this.pos);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // Make sure it's only executed on the physical client
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
                Level level = Minecraft.getInstance().level;

                if (level == null) {return;}

                if (!(level.getBlockEntity(this.pos) instanceof ConsoleBlockEntity entity)) {
                    return;
                }
                if (entity == null) {return;}

                if (entity instanceof ConsoleBlockEntity) {
                    ((ConsoleBlockEntity) entity).setTARDISInFlight(this.inFlight, false);
                }
            });
        });
        return true;
    }
}
