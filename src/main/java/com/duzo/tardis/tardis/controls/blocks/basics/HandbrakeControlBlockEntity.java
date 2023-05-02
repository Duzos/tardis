package com.duzo.tardis.tardis.controls.blocks.basics;

import com.duzo.tardis.core.init.SoundsInit;
import com.duzo.tardis.tardis.controls.blocks.ControlBlockEntity;
import com.duzo.tardis.tardis.io.TARDISTravel;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class HandbrakeControlBlockEntity extends ControlBlockEntity {
    public HandbrakeControlBlockEntity(BlockEntityType<?> p_155228_, BlockPos p_155229_, BlockState p_155230_) {
        super(p_155228_, p_155229_, p_155230_);
    }

    @Override
    protected SoundEvent getSound() {
        return SoundsInit.HANDBRAKE_PULL.get();
    }

    @Override
    protected void run(Player player) {
        TARDISTravel travel = this.getTARDIS().getTravel();

        travel.changeHandbrake();
        this.playSound();
    }
}
