package com.duzo.tardis.tardis.controls.blocks.impl.entities;

import com.duzo.tardis.tardis.controls.TARDISControlSchema;
import com.duzo.tardis.tardis.controls.TARDISControls;
import com.duzo.tardis.tardis.controls.blocks.ControlsInit;
import com.duzo.tardis.tardis.controls.blocks.basics.RotorControlBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class EighthRotorBlockEntity extends RotorControlBlockEntity {
    public EighthRotorBlockEntity(BlockEntityType<?> p_155228_, BlockPos p_155229_, BlockState p_155230_) {
        super(p_155228_, p_155229_, p_155230_);
    }

    public EighthRotorBlockEntity(BlockPos pos, BlockState state) {
        this(ControlsInit.EIGHTH_ROTOR_ENTITY.get(),pos,state);
    }

    @Override
    public TARDISControlSchema<?> getSchema() {
        return TARDISControls.get("eighth_rotor");
    }
}