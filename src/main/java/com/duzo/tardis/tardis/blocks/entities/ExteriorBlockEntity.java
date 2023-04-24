package com.duzo.tardis.tardis.blocks.entities;

import com.duzo.tardis.core.init.BlockEntityInit;
import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.tardis.TARDIS;
import com.duzo.tardis.tardis.manager.TARDISManager;
import com.duzo.tardis.tardis.io.TeleportHelper;
import com.duzo.tardis.tardis.structures.interiors.CoralInterior;
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
import org.checkerframework.checker.units.qual.C;

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
    public CompoundTag serializeNBT() {
        CompoundTag tag = super.serializeNBT();
        if (this.tardisUUID != null) {
            tag.putUUID("tardisUUID", this.tardisUUID);
        }
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        this.tardisUUID = nbt.getUUID("tardisUUID");
    }

    public void use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        TARDIS tardis = TARDISManager.getInstance().findTARDIS(new AbsoluteBlockPos(level,pos));
        tardis.generateInterior(new CoralInterior());
        if (tardis.needsInterior()) {
            tardis.generateInterior(new CoralInterior());
        }
        TeleportHelper helper = new TeleportHelper(player.getUUID(),new AbsoluteBlockPos(tardis.getInteriorDimension(),tardis.getInterior().getEntrancePos()));
        helper.teleport((ServerLevel) player.getLevel());
    }
}
