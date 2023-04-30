package com.duzo.tardis.tardis.io;

import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.tardis.structures.TARDISStructure;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.slf4j.Logger;

import java.util.UUID;
import java.util.logging.Level;

public class TeleportHelper {
    private static final Logger LOGGER = LogUtils.getLogger();
    public final UUID entityUUID;
    public final AbsoluteBlockPos destination;
    public TeleportHelper(UUID uuid, AbsoluteBlockPos destination) {
        this.entityUUID = uuid;
        this.destination = destination;
    }

    public void teleport(ServerLevel origin) {
        Entity entity = origin.getEntity(this.entityUUID);
        this.destination.getDimension().getChunkAt(this.destination);

        if (entity instanceof ServerPlayer player) {
            player.teleportTo((ServerLevel) this.destination.getDimension(), this.destination.getX(), this.destination.getY(), this.destination.getZ(),0,player.getXRot());
        }
        else if (!(entity instanceof Player)) {
            entity.changeDimension((ServerLevel) this.destination.getDimension());
        }
        LOGGER.info("Teleported " + entity + " to " + this.destination);
    }
}
