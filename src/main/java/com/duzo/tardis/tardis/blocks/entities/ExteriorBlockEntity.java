package com.duzo.tardis.tardis.blocks.entities;

import com.duzo.tardis.core.init.BlockEntityInit;
import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.tardis.TARDIS;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class ExteriorBlockEntity extends BlockEntity {
    private TARDIS tardis;

    public ExteriorBlockEntity(BlockPos pos, BlockState state) {
        this(BlockEntityInit.TARDIS_BLOCK_ENTITY.get(), pos, state);
    }
    public ExteriorBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public void setTARDIS(TARDIS tardis) {
        this.tardis = tardis;
    }

    public TARDIS getTARDIS() {
        if (this.tardis == null) {
            this.setTARDIS(new TARDIS(
                    new AbsoluteBlockPos(this.getLevel(),this.getBlockPos()))
            );
        }
        return this.tardis;
    }

    public void use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
//        TARDISTravel travel = this.getTARDIS().getTravel();
//
//        BlockPos newPos = searchForNearestAirBlock(level,getRandomPosInRange(pos,2), Direction.UP);
//        travel.setDestination(new AbsoluteBlockPos(level, newPos));
//
//        travel.dematerialise(true);
    }
}
