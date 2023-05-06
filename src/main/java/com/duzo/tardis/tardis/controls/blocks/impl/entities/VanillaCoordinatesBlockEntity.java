package com.duzo.tardis.tardis.controls.blocks.impl.entities;

import com.duzo.tardis.tardis.controls.CoordinateControlSchema;
import com.duzo.tardis.tardis.controls.TARDISControls;
import com.duzo.tardis.tardis.controls.blocks.ControlsInit;
import com.duzo.tardis.tardis.controls.blocks.basics.CoordinateControlBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class VanillaCoordinatesBlockEntity extends CoordinateControlBlockEntity {
    public VanillaCoordinatesBlockEntity(BlockEntityType<?> p_155228_, BlockPos p_155229_, BlockState p_155230_) {
        super(p_155228_, p_155229_, p_155230_);
    }
    public VanillaCoordinatesBlockEntity(BlockPos pos, BlockState state) {
        this(ControlsInit.VANILLA_COORDINATES_ENTITY.get(),pos,state);
    }

    @Override
    public CoordinateControlSchema<?> getSchema() {
        if (TARDISControls.get("vanilla_coordinates") instanceof CoordinateControlSchema<?> schema) {
            return schema;
        }
        return null;
    }
}
