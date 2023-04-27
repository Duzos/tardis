package com.duzo.tardis.tardis.controls.blocks.impl.entities;

import com.duzo.tardis.tardis.controls.TARDISControlSchema;
import com.duzo.tardis.tardis.controls.TARDISControls;
import com.duzo.tardis.tardis.controls.blocks.ControlsInit;
import com.duzo.tardis.tardis.controls.blocks.basics.DematControlBlockEntity;
import com.duzo.tardis.tardis.doors.blocks.DoorsInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class CoralDematLeverBlockEntity extends DematControlBlockEntity {
    public CoralDematLeverBlockEntity(BlockEntityType<?> p_155228_, BlockPos p_155229_, BlockState p_155230_) {
        super(p_155228_, p_155229_, p_155230_);
    }

    public CoralDematLeverBlockEntity(BlockPos pos, BlockState state) {
        this(ControlsInit.CORAL_DEMAT_LEVER_ENTITY.get(),pos,state);
    }

    @Override
    public TARDISControlSchema<?> getSchema() {
        return TARDISControls.get("coral_demat");
    }
}
