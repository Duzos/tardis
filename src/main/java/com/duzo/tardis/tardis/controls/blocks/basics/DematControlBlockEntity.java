package com.duzo.tardis.tardis.controls.blocks.basics;

import com.duzo.tardis.core.init.SoundsInit;
import com.duzo.tardis.tardis.controls.blocks.ControlBlockEntity;
import com.duzo.tardis.tardis.io.TARDISTravel;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class DematControlBlockEntity extends ControlBlockEntity {
    public DematControlBlockEntity(BlockEntityType<?> p_155228_, BlockPos p_155229_, BlockState p_155230_) {
        super(p_155228_, p_155229_, p_155230_);
    }

    @Override
    protected SoundEvent getSound() {
        return SoundsInit.DEMAT_LEVER_PULL.get();
    }

    @Override
    protected void run(Player player) {
        this.playSound();

        TARDISTravel travel = this.getTARDIS().getTravel();
        if (travel.isMaterialising() || travel.isDematerialising()) {return;}

        if (travel.inFlight()) {
            travel.materialise();
        } else {
            travel.dematerialise();
        }
    }
}
