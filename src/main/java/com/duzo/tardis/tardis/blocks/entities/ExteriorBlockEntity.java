package com.duzo.tardis.tardis.blocks.entities;

import com.duzo.tardis.core.init.BlockEntityInit;
import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.tardis.TARDIS;
import com.duzo.tardis.tardis.manager.TARDISManager;
import com.duzo.tardis.tardis.io.TeleportHelper;
import com.duzo.tardis.tardis.structures.interiors.CoralInterior;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
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
        return this.tardis;
    }

    public void use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        this.getTARDIS().generateInterior(new CoralInterior());
        if (this.getTARDIS().needsInterior()) {
            this.getTARDIS().generateInterior(new CoralInterior());
        }
        TeleportHelper helper = new TeleportHelper(player.getUUID(),new AbsoluteBlockPos(this.getTARDIS().getInteriorDimension(),this.getTARDIS().getInterior().getEntrancePos()));
        helper.teleport((ServerLevel) player.getLevel());
    }
}
