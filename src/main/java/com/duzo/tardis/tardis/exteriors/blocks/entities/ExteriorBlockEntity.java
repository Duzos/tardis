package com.duzo.tardis.tardis.exteriors.blocks.entities;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.core.init.BlockEntityInit;
import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.tardis.TARDIS;
import com.duzo.tardis.tardis.manager.TARDISManager;
import com.duzo.tardis.tardis.io.TeleportHelper;
import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.slf4j.Logger;

import java.util.UUID;

public class ExteriorBlockEntity extends BlockEntity {
    private UUID tardisUUID;

    public ExteriorBlockEntity(BlockPos pos, BlockState state) {
        this(BlockEntityInit.TARDIS_BLOCK_ENTITY.get(), pos, state);
    }
    public ExteriorBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public void setTARDIS(TARDIS tardis) {
        this.tardisUUID = tardis.getUuid();
    }
    public void setTARDIS(UUID uuid) {
        this.tardisUUID = uuid;
    }

    public TARDIS getTARDIS() {
        return TARDISManager.getInstance().findTARDIS(this.tardisUUID);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        if (this.tardisUUID != null) {
            tag.putUUID("tardisUUID", this.tardisUUID);
        }
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);

        try {
            this.tardisUUID = tag.getUUID("tardisUUID");
        } catch (Exception error) {
            Logger logger = LogUtils.getLogger();
            logger.error(error.toString());
            logger.error("Failed to load data for TARDIS Exterior block! Pulling from TARDISManager instead!");
            TARDIS tardis = TARDISManager.getInstance().findTARDIS(new AbsoluteBlockPos(this.level,this.worldPosition));
            this.setTARDIS(tardis);
        }
    }

    public void use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide || hand != InteractionHand.MAIN_HAND) {return;}


        if (this.getTARDIS() == null) {
            TARDISManager.getInstance().findTARDIS(new AbsoluteBlockPos(level,pos)).updateBlockEntity();
        }
        this.getTARDIS().teleportToDoor(player);
    }
}
