package com.duzo.tardis.tardis.blocks.entities;

import com.duzo.tardis.core.init.BlockEntityInit;
import com.duzo.tardis.core.init.BlockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class TARDISBlockEntity extends BlockEntity {

    public TARDISBlockEntity(BlockPos pos, BlockState state) {
        this(BlockEntityInit.TARDIS_BLOCK_ENTITY.get(), pos, state);
    }
    public TARDISBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
}
