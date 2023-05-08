package com.duzo.tardis.tardis.doors.blocks;

import com.duzo.tardis.tardis.exteriors.blocks.entities.ExteriorBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public abstract class InteriorDoorBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public static final VoxelShape NORTH_AABB = Block.box(0, 0, -0.1, 16, 32, 16);
    public static final VoxelShape EAST_AABB = Block.box(0, 0, 0, 16.1, 32, 16);
    public static final VoxelShape SOUTH_AABB = Block.box(0, 0, 0, 16, 32, 16.1);
    public static final VoxelShape WEST_AABB = Block.box(-0.1, 0, 0, 16, 32, 16);

    public InteriorDoorBlock(Properties p_49224_) {
        super(p_49224_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));

    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        switch (state.getValue(FACING)) {
            case NORTH:
                return NORTH_AABB;
            case EAST:
                return EAST_AABB;
            case SOUTH:
                return SOUTH_AABB;
            case WEST:
                return WEST_AABB;
            default:
                throw new RuntimeException("Invalid facing direction in getShape() " +
                        "//This is Duzo's code. If it breaks it's an L."); // ;)
        }
    }

    public BlockState getStateForPlacement(BlockPlaceContext p_48689_) {
        return this.defaultBlockState().setValue(FACING, p_48689_.getHorizontalDirection().getOpposite());
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    public @NotNull RenderShape getRenderShape(BlockState p_49232_) {
        return RenderShape.MODEL;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide) {
            InteriorDoorBlockEntity blockEntity = (InteriorDoorBlockEntity) level.getBlockEntity(pos);
            blockEntity.use(state,level,pos,player,hand,hit);
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity player) {
        if (!level.isClientSide) {
            InteriorDoorBlockEntity blockEntity = (InteriorDoorBlockEntity) level.getBlockEntity(pos);
            blockEntity.entityInside(state,level,pos,player);
        }
        super.entityInside(state, level, pos, player);
    }
}
