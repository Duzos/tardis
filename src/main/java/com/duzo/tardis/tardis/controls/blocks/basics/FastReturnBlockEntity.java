package com.duzo.tardis.tardis.controls.blocks.basics;

import com.duzo.tardis.common.items.RemoteItem;
import com.duzo.tardis.config.TARDISModCommonConfigs;
import com.duzo.tardis.core.init.SoundsInit;
import com.duzo.tardis.core.util.AbsoluteBlockPos;
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
import net.minecraft.world.phys.BlockHitResult;

public abstract class FastReturnBlockEntity extends ControlBlockEntity {
    protected TARDISTravel.STATE previousState;
    protected TARDISTravel.STATE state;
    protected AbsoluteBlockPos pos;
    public FastReturnBlockEntity(BlockEntityType<?> p_155228_, BlockPos p_155229_, BlockState p_155230_) {
        super(p_155228_, p_155229_, p_155230_);
    }

    @Override
    protected void run(Player player, BlockHitResult hit) {
        this.getTARDIS().to(this.pos,false);
    }

    private void updateState() {
        if (this.getTARDIS() == null) return;

        TARDISTravel travel = this.getTARDIS().getTravel();

        if (travel.getState() == this.state) {return;}

        this.previousState = this.state;
        this.state = travel.getState();

        if (this.state == TARDISTravel.STATE.DEMAT && !this.pos.equals(this.getTARDIS().getPosition())) {
            this.pos = this.getTARDIS().getPosition();
        }
    }


    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, FastReturnBlockEntity pBlockEntity) {
        if (pLevel.isClientSide) {return;}
        if (pLevel != TARDISUtil.getTARDISLevel()) {return;}

        pBlockEntity.updateState();
    }
}
