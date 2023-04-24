//package com.duzo.tardis.tardis.blocks.rotors;
//
//import com.duzo.tardis.core.init.BlockEntityInit;
//import com.duzo.tardis.core.init.RotorInit;
//import net.minecraft.core.BlockPos;
//import net.minecraft.world.level.block.BaseEntityBlock;
//import net.minecraft.world.level.block.RenderShape;
//import net.minecraft.world.level.block.entity.BlockEntity;
//import net.minecraft.world.level.block.state.BlockState;
//import org.jetbrains.annotations.Nullable;
//
//public class RotorBlock extends BaseEntityBlock {
//    public RotorBlock(Properties properties) {
//        super(properties);
//    }
//
//    public RenderShape getRenderShape(BlockState p_49232_) {
//        return RenderShape.MODEL;
//    }
//    @Nullable
//    @Override
//    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
//        return RotorInit.ROTOR_BLOCK_ENTITY.get().create(pos, state);
//    }
//}
