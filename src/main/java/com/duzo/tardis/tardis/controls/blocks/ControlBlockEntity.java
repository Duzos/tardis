package com.duzo.tardis.tardis.controls.blocks;

import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.tardis.TARDIS;
import com.duzo.tardis.tardis.controls.TARDISControlModelSchema;
import com.duzo.tardis.tardis.controls.TARDISControlSchema;
import com.duzo.tardis.tardis.doors.TARDISInteriorDoorSchema;
import com.duzo.tardis.tardis.manager.TARDISManager;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.checkerframework.checker.units.qual.A;

public abstract class ControlBlockEntity extends BlockEntity {
    private TARDIS tardis;
    protected TARDISControlSchema<?> schema;

    public ControlBlockEntity(BlockEntityType<?> p_155228_, BlockPos p_155229_, BlockState p_155230_) {
        super(p_155228_, p_155229_, p_155230_);
    }

    public void setTARDIS(TARDIS tardis) {
        this.tardis = tardis;
    }

    public TARDIS getTARDIS() {
        if (this.tardis == null) {this.updateTARDIS(this.getLevel(),this.getBlockPos());}

        return this.tardis;
    }

    protected void updateTARDIS(Level level, BlockPos pos) {
        this.updateTARDIS(new AbsoluteBlockPos(level, pos));
    }

    protected void updateTARDIS(AbsoluteBlockPos pos) {
        this.setTARDIS(
                TARDISManager.getInstance().findTARDISFromInteriorCoordinate(pos)
        );
    }

    public TARDISControlSchema<?> getSchema() {
        return this.schema;
    }

    protected void run(Player player) {}

    public void use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide && hand == InteractionHand.MAIN_HAND) {
            this.run(player);
        }
    }
}
