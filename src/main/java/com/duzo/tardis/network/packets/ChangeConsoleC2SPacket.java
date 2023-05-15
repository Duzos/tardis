package com.duzo.tardis.network.packets;

import com.duzo.tardis.tardis.animation.ConsoleAnimation;
import com.duzo.tardis.tardis.animation.impl.BorealisAnimation;
import com.duzo.tardis.tardis.consoles.ConsoleModelSchema;
import com.duzo.tardis.tardis.consoles.ConsoleSchema;
import com.duzo.tardis.tardis.consoles.Consoles;
import com.duzo.tardis.tardis.consoles.blocks.entities.ConsoleBlockEntity;
import com.duzo.tardis.tardis.consoles.impl.BorealisConsoleSchema;
import com.duzo.tardis.tardis.consoles.impl.models.BorealisConsoleModel;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;

import java.util.UUID;
import java.util.function.Supplier;

public class ChangeConsoleC2SPacket {
    public boolean messageIsValid;

    private UUID tardisID;
    private BlockPos consolePosition;
    private boolean isUp;

    public ChangeConsoleC2SPacket(BlockPos pos, UUID tardisID, Boolean isUp) {
        this.consolePosition = pos;
        this.tardisID = tardisID;
        this.isUp = isUp;
        this.messageIsValid = true;
    }
    public ChangeConsoleC2SPacket() {
        this.messageIsValid = false;
    }

    public static ChangeConsoleC2SPacket decode(FriendlyByteBuf buf) {
        ChangeConsoleC2SPacket packet = new ChangeConsoleC2SPacket();

        try {
            BlockPos pos = buf.readBlockPos();

            packet.tardisID = buf.readUUID();
            packet.consolePosition = pos;
            packet.isUp = buf.readBoolean();
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            System.out.println("Exception while reading Packet: " + e);
            return packet;
        }

        packet.messageIsValid = true;
        return packet;
    }

    public void encode(FriendlyByteBuf buf) {
        if (!this.messageIsValid) return;

        buf.writeBlockPos(this.consolePosition);
        buf.writeUUID(this.tardisID);
        buf.writeBoolean(this.isUp);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // Make sure it's only executed on the physical client
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
                Level level = Minecraft.getInstance().level;

                if (level == null) {return;}

                ConsoleBlockEntity entity = (ConsoleBlockEntity) level.getBlockEntity(this.consolePosition);
                if (entity == null) {return;}

                ConsoleSchema<?> schema = entity.getSchema();

                if(schema == Consoles.get("borealis_console")) {
                    entity.setSchema(Consoles.get("hudolin_console"));
                } else {
                    entity.setSchema(Consoles.get("borealis_console"));
                }
            });
        });
        return true;
    }
}
