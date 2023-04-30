package com.duzo.tardis.tardis.doors.blocks.impl;

import com.duzo.tardis.tardis.doors.blocks.DoorsInit;
import com.duzo.tardis.tardis.doors.blocks.InteriorDoorBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class CoralInteriorDoorBlock extends InteriorDoorBlock {
    public CoralInteriorDoorBlock(Properties p_49224_) {
        super(p_49224_);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return DoorsInit.CORAL_DOOR_ENTITY.get().create(pos,state);
    }
}
