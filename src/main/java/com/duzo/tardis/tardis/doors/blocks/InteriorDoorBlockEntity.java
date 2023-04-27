package com.duzo.tardis.tardis.doors.blocks;

import com.duzo.tardis.core.init.BlockEntityInit;
import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.tardis.TARDIS;
import com.duzo.tardis.tardis.doors.TARDISInteriorDoorSchema;
import com.duzo.tardis.tardis.io.TeleportHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public abstract class InteriorDoorBlockEntity extends BlockEntity {
    private TARDIS tardis;
    protected TARDISInteriorDoorSchema<?> schema;

    public InteriorDoorBlockEntity(BlockEntityType<?> p_155228_, BlockPos p_155229_, BlockState p_155230_) {
        super(p_155228_, p_155229_, p_155230_);
    }

    public void setTARDIS(TARDIS tardis) {
        this.tardis = tardis;
    }
    public TARDIS getTARDIS() {
        return this.tardis;
    }

    public TARDISInteriorDoorSchema<?> getSchema() {
        return this.schema;
    }

    public void use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (this.getTARDIS() == null) {
            return;
        }

        TeleportHelper helper = new TeleportHelper(player.getUUID(), this.getTARDIS().getPositionForTeleporting());
        helper.teleport((ServerLevel) player.getLevel());
    }
}