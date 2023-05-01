package com.duzo.tardis.tardis.controls.blocks.basics;

import com.duzo.tardis.common.items.RemoteItem;
import com.duzo.tardis.config.TARDISModCommonConfigs;
import com.duzo.tardis.core.init.SoundsInit;
import com.duzo.tardis.tardis.TARDIS;
import com.duzo.tardis.tardis.controls.blocks.ControlBlockEntity;
import com.duzo.tardis.tardis.io.TARDISTravel;
import com.duzo.tardis.tardis.util.TARDISUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class RotorControlBlockEntity extends ControlBlockEntity {
    protected TARDISTravel.STATE previousState;
    protected TARDISTravel.STATE state;
    public RotorControlBlockEntity(BlockEntityType<?> p_155228_, BlockPos p_155229_, BlockState p_155230_) {
        super(p_155228_, p_155229_, p_155230_);
    }

    @Override
    protected void run(Player player) {
        if (player.getItemInHand(InteractionHand.MAIN_HAND).getItem() instanceof RemoteItem) {
            ItemStack stack = player.getItemInHand(InteractionHand.MAIN_HAND);
            RemoteItem item = (RemoteItem) stack.getItem();
            item.link(stack, this.getTARDIS());
        }
    }

    private static void runDematerialise(Level level, BlockPos pos) {
        level.playSound(null,pos, SoundsInit.DEMATERIALISE.get(), SoundSource.BLOCKS, 1f,1f);
    }
    private void runDematerialise() {
        runDematerialise(this.getLevel(),this.getBlockPos());
    }

    private static void runMaterialise(TARDIS tardis, Level level, BlockPos pos) {
        if (tardis.getTravel().getDestination().getDimension() == TARDISUtil.getTARDISLevel()) {
            if (TARDISModCommonConfigs.CAN_LAND_IN_TARDIS_DIM.get()) {
                level.playSound(null, pos, SoundsInit.EMERGENCY_LAND.get(), SoundSource.BLOCKS, 1f,1f);
            } else {
                level.playSound(null, pos, SoundsInit.FAIL_LAND.get(), SoundSource.BLOCKS, 1f,1f);
            }
        } else {
            level.playSound(null, pos, SoundsInit.MATERIALISE.get(), SoundSource.BLOCKS, 1f, 1f);
        }
    }
    private void runMaterialise() {
        runMaterialise(this.getTARDIS(),this.getLevel(),this.getBlockPos());
    }

    private void updateState() {
        TARDISTravel travel = this.getTARDIS().getTravel();

        if (travel.getState() == this.state) {return;}

        this.previousState = this.state;
        this.state = travel.getState();

        if (this.state == TARDISTravel.STATE.DEMAT) {
            this.runDematerialise();
        }
        else if (this.state == TARDISTravel.STATE.MAT) {
            this.runMaterialise();
        }
    }


    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, RotorControlBlockEntity pBlockEntity) {
        if (pLevel.isClientSide) {return;}
        if (pLevel != TARDISUtil.getTARDISLevel()) {return;}

        pBlockEntity.updateState();
    }
}
