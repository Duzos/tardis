package com.duzo.tardis.tardis.controls.blocks.impl;

import com.duzo.tardis.tardis.controls.blocks.ControlsInit;
import com.duzo.tardis.tardis.controls.blocks.basics.DematControlBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class VanillaDematLeverBlock extends DematControlBlock {
    public VanillaDematLeverBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
        return ControlsInit.VANILLA_DEMAT_LEVER_ENTITY.get().create(p_153215_,p_153216_);
    }
}
