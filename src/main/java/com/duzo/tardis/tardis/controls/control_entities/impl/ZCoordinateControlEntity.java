package com.duzo.tardis.tardis.controls.control_entities.impl;

import com.duzo.tardis.tardis.controls.control_entities.ControlEntitySchema;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.UUID;

public class ZCoordinateControlEntity extends ControlEntitySchema {
    public ZCoordinateControlEntity(EntityType<? extends AmbientCreature> p_i50290_1_, Level p_i50290_2_) {
        super(p_i50290_1_, p_i50290_2_);
    }

    public ZCoordinateControlEntity(EntityType<? extends AmbientCreature> entity, Level level, UUID tardisID, String name, BlockPos consoleBlockPos) {
        super(entity, level, tardisID, name, consoleBlockPos);
    }

    @Override
    public void runInteractions(Player pSource) {
        if (pSource.level.isClientSide) return;

        if (!this.getControlName().equals("Z")) return;

        this.updateCoordinates();

        if (!pSource.isCrouching()) {
            this.z += this.incrementValue;
        } else {
            this.z -= this.incrementValue;
        }

        pSource.displayClientMessage(Component.translatable(" X: " + this.x + " Y: " + this.y + " Z: " + this.z).setStyle(Style.EMPTY), true);
        this.level.playSound(null, this.blockPosition(), SoundEvents.NOTE_BLOCK_BIT, SoundSource.MASTER, 1.5f, 5f);

        this.setDest();
    }
}
