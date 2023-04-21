package com.duzo.tardis.tardis.blocks;

import com.duzo.tardis.core.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEventListener;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class TARDISBlock extends BaseEntityBlock {
    public TARDISBlock(Properties p_49795_) {
        super(p_49795_);
    }

    private static BlockPos getRandomPosInRange(BlockPos pos, int range) {
        Random random = new Random();

        int xChange = random.nextInt(-range, range);
        int yChange = random.nextInt(-range, range);
        int zChange = random.nextInt(-range, range);

        return new BlockPos(pos.getX() + xChange, pos.getY() + yChange, pos.getZ() + zChange);
    }

    private static BlockPos searchForNearestAirBlock(Level level,BlockPos pos, Direction direction) {
        if (direction != Direction.UP && direction != Direction.DOWN) {direction = Direction.UP;}

        BlockPos testingPos = pos;

        if (direction == Direction.UP) {
            while (level.getBlockState(testingPos).getBlock() != Blocks.AIR) {
                testingPos = testingPos.above();
            }
        } else {
            while (level.getBlockState(testingPos).getBlock() != Blocks.AIR) {
                testingPos = testingPos.below();
            }
        }

        return testingPos;
    }

    @Override
    public RenderShape getRenderShape(BlockState p_49232_) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return BlockEntityInit.TARDIS_BLOCK_ENTITY.get().create(pos, state);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide) {
            BlockPos newPos = searchForNearestAirBlock(level,getRandomPosInRange(pos, 2), Direction.UP);
            level.setBlockAndUpdate(newPos, state);
            level.removeBlock(pos, false);
            player.sendSystemMessage(Component.translatable("Moved TARDIS to " + newPos));
        }
        return InteractionResult.SUCCESS;
    }
}
