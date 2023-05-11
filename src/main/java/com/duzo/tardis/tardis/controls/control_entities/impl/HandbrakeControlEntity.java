package com.duzo.tardis.tardis.controls.control_entities.impl;

import com.duzo.tardis.tardis.consoles.blocks.entities.ConsoleBlockEntity;
import com.duzo.tardis.tardis.controls.control_entities.ControlEntitySchema;
import com.duzo.tardis.tardis.io.TARDISTravel;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.UUID;

public class HandbrakeControlEntity extends ControlEntitySchema {
    public HandbrakeControlEntity(EntityType<? extends AmbientCreature> p_i50290_1_, Level p_i50290_2_) {
        super(p_i50290_1_, p_i50290_2_);
    }

    public HandbrakeControlEntity(EntityType<? extends AmbientCreature> entity, Level level, UUID tardisID, String name, BlockPos consoleBlockPos) {
        super(entity, level, tardisID, name, consoleBlockPos);
    }

    @Override
    public void runInteractions(Player pSource) {
        super.runInteractions(pSource);
        if (pSource.level.isClientSide) return;
        if(!this.getControlName().equals("Handbrake")) return;
        if(this.consolePosition == null) return;

        ConsoleBlockEntity console = (ConsoleBlockEntity) level.getBlockEntity(this.consolePosition);
        TARDISTravel travel = console.getTARDIS().getTravel();

        travel.changeHandbrake();
        this.level.playSound(null, this.blockPosition(), SoundEvents.LEVER_CLICK, SoundSource.MASTER, 1f, 5f);
        this.setPulled(!this.pulled(), true);
    }
}
