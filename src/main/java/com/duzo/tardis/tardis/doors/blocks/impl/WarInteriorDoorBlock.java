package com.duzo.tardis.tardis.doors.blocks.impl;

import com.duzo.tardis.tardis.doors.blocks.DoorsInit;
import com.duzo.tardis.tardis.doors.blocks.InteriorDoorBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class WarInteriorDoorBlock extends InteriorDoorBlock {
    public WarInteriorDoorBlock(Properties p_49224_) {
        super(p_49224_);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return DoorsInit.WAR_DOOR_ENTITY.get().create(pos,state);
    }
}
