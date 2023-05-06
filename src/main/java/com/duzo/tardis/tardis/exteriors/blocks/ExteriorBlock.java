package com.duzo.tardis.tardis.exteriors.blocks;


import com.duzo.tardis.core.init.BlockEntityInit;
import com.duzo.tardis.tardis.controls.blocks.ControlsInit;
import com.duzo.tardis.tardis.controls.blocks.basics.RotorControlBlockEntity;
import com.duzo.tardis.tardis.exteriors.blocks.entities.ExteriorBlockEntity;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.function.ToIntFunction;

public class ExteriorBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    private static final VoxelShape BOUNDING_BOX = Block.box(0, 0, 0, 16, 32, 16);
    public static final VoxelShape NORTH_AABB = Block.box(0, 0, 0.1, 16, 32, 16);
    public static final VoxelShape EAST_AABB = Block.box(0, 0, 0, 0.1, 32, 16);
    public static final VoxelShape SOUTH_AABB = Block.box(0, 0, 0, 16, 32, 0.1);
    public static final VoxelShape WEST_AABB = Block.box(0.1, 0, 0, 16, 32, 16);

    public ExteriorBlock(Properties p_49795_) {
        super(p_49795_);
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
                        "//This is Loqor's code. If it breaks it's an L.");
        }
    }

    public BlockState getStateForPlacement(BlockPlaceContext p_48689_) {
        return this.defaultBlockState().setValue(FACING, p_48689_.getHorizontalDirection().getOpposite());
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
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

    public BlockState rotate(BlockState p_48722_, Rotation p_48723_) {
        return p_48722_.setValue(FACING, p_48723_.rotate(p_48722_.getValue(FACING)));
    }

    public BlockState mirror(BlockState p_48719_, Mirror p_48720_) {
        return p_48719_.rotate(p_48720_.getRotation(p_48719_.getValue(FACING)));
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity player) {
        if (!level.isClientSide) {
            ExteriorBlockEntity blockEntity = (ExteriorBlockEntity) level.getBlockEntity(pos);
            blockEntity.entityInside(state,level,pos,player);
        }
        super.entityInside(state, level, pos, player);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_153212_, BlockState p_153213_, BlockEntityType<T> type) {
        return type == BlockEntityInit.TARDIS_BLOCK_ENTITY.get() ? ExteriorBlockEntity::tick : null;
    }
//    @Override
//    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
//        if (level.getBlockEntity(pos) instanceof ExteriorBlockEntity entity) {
//            return Math.round(15 * entity.getAlpha());
////            return 15;
//        } else {
//            return 15;
//        }
//    }
    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide) {
            ExteriorBlockEntity blockEntity = (ExteriorBlockEntity) level.getBlockEntity(pos);
            blockEntity.use(state,level,pos,player,hand,hit);
        }
        return InteractionResult.SUCCESS;
    }
}
