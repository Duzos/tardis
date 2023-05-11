package com.duzo.tardis.tardis.doors.blocks;

import com.duzo.tardis.core.init.BlockEntityInit;
import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.network.Network;
import com.duzo.tardis.network.packets.UpdateExteriorDoorS2CPacket;
import com.duzo.tardis.network.packets.UpdateInteriorDoorS2CPacket;
import com.duzo.tardis.tardis.TARDIS;
import com.duzo.tardis.tardis.doors.TARDISInteriorDoorModelSchema;
import com.duzo.tardis.tardis.doors.TARDISInteriorDoorSchema;
import com.duzo.tardis.tardis.io.TeleportHelper;
import com.duzo.tardis.tardis.manager.TARDISManager;
import com.duzo.tardis.tardis.util.TARDISUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.checkerframework.checker.units.qual.A;

public abstract class InteriorDoorBlockEntity extends BlockEntity {
    private TARDIS tardis;
    protected TARDISInteriorDoorSchema<?> schema;
    private boolean doorOpened = false;
    public boolean doorLocked = false;
    protected TARDISInteriorDoorSchema.Serializer SCHEMA_SERIALIZER = new TARDISInteriorDoorSchema.Serializer();

    public InteriorDoorBlockEntity(BlockEntityType<?> p_155228_, BlockPos p_155229_, BlockState p_155230_) {
        super(p_155228_, p_155229_, p_155230_);
    }

    public boolean doorOpen() {
        return this.doorOpened;
    }

    public void setDoorLocked(boolean bool, boolean updateClient) {
        this.doorLocked = bool;

        if(updateClient) {
            Network.sendToAll(new UpdateInteriorDoorS2CPacket(this.getBlockPos(),bool));
        }
    }

    public void setDoorOpened(boolean bool, boolean updateClient) {
        this.doorOpened = bool;

        if (updateClient) {
            Network.sendToAll(new UpdateInteriorDoorS2CPacket(this.getBlockPos(),bool));

            if (this.level == TARDISUtil.getTARDISLevel()) {
                Network.sendToAll(new UpdateExteriorDoorS2CPacket(this.getTARDIS().getPosition(), bool));
            }
        }
    }

    public void setDoorOpened(boolean bool) {
        this.setDoorOpened(bool,false);
    }

    public void setDoorLocked(boolean bool) {
        this.setDoorLocked(bool, false);
    }


    public void setTARDIS(TARDIS tardis) {
        this.tardis = tardis;
    }
    protected void updateTARDIS(AbsoluteBlockPos pos) {
        this.setTARDIS(
                TARDISManager.getInstance().findTARDISFromInteriorCoordinate(pos)
        );
    }
    public TARDIS getTARDIS() {
        if (this.tardis == null) {
            this.updateTARDIS(new AbsoluteBlockPos(this.level,this.getBlockPos()));
        }

        return this.tardis;
    }

    public TARDISInteriorDoorSchema<?> getSchema() {
        return this.schema;
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putBoolean("doorOpened", this.doorOpened);

        SCHEMA_SERIALIZER.serialize(tag,this.getSchema());
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.doorOpened = tag.getBoolean("doorOpened");

        this.schema = SCHEMA_SERIALIZER.deserialize(tag);
    }

    public void use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        this.setDoorOpened(!this.doorOpened,true);
    }

    public void entityInside(BlockState state, Level level, BlockPos pos, Entity player) {
        if (level.isClientSide) {return;}

        if (this.getTARDIS() == null && this.level == (TARDISUtil.getTARDISLevel())) {
            TARDISManager.getInstance().findTARDISFromInteriorCoordinate(new AbsoluteBlockPos(level,pos)).updateBlockEntity();
        }

        if(player instanceof Player && this.doorOpen() && this.level == TARDISUtil.getTARDISLevel()) {
            TeleportHelper helper = new TeleportHelper(player.getUUID(), this.getTARDIS().getPositionForTeleporting());
            helper.teleport((ServerLevel) player.getLevel());
        }
    }
}