package com.duzo.tardis.tardis.controls.control_entities.impl;

import com.duzo.tardis.tardis.consoles.blocks.entities.ConsoleBlockEntity;
import com.duzo.tardis.tardis.controls.control_entities.ControlEntitySchema;
import com.duzo.tardis.tardis.io.TARDISTravel;
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

public class FacingControlEntity extends ControlEntitySchema {
    public FacingControlEntity(EntityType<? extends AmbientCreature> p_i50290_1_, Level p_i50290_2_) {
        super(p_i50290_1_, p_i50290_2_);
    }

    public FacingControlEntity(EntityType<? extends AmbientCreature> entity, Level level, UUID tardisID, String name, BlockPos consoleBlockPos) {
        super(entity, level, tardisID, name, consoleBlockPos);
    }

    @Override
    public void runInteractions(Player pSource) {
        if (pSource.level.isClientSide) return;

        if (!this.getControlName().equals("Exterior Facing")) return;

        if (this.consolePosition != null) {
            ConsoleBlockEntity console = (ConsoleBlockEntity) level.getBlockEntity(this.consolePosition);
            console.getTARDIS().getTravel().setDirection(console.getTARDIS().getTravel().getDirection().getClockWise(), true,null);
            pSource.displayClientMessage(Component.translatable("Facing: " + console.getTARDIS().getTravel().getDirection().toString().toUpperCase()).setStyle(Style.EMPTY), true);
            this.level.playSound(null, this.blockPosition(), SoundEvents.NOTE_BLOCK_COW_BELL, SoundSource.MASTER, 1.25f, 5f);
        }
    }
}