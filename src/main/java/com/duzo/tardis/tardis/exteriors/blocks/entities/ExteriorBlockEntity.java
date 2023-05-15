package com.duzo.tardis.tardis.exteriors.blocks.entities;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.core.init.BlockEntityInit;
import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.network.Network;
import com.duzo.tardis.network.packets.UpdateExteriorAnimationS2CPacket;
import com.duzo.tardis.network.packets.UpdateExteriorDoorS2CPacket;
import com.duzo.tardis.network.packets.UpdateInteriorDoorS2CPacket;
import com.duzo.tardis.tardis.TARDIS;
import com.duzo.tardis.tardis.animation.ExteriorAnimation;
import com.duzo.tardis.tardis.animation.impl.ClassicAnimation;
import com.duzo.tardis.tardis.exteriors.blocks.ExteriorBlock;
import com.duzo.tardis.tardis.manager.TARDISManager;
import com.duzo.tardis.tardis.io.TeleportHelper;
import com.mojang.logging.LogUtils;
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
import net.minecraftforge.client.event.RenderHighlightEvent;
import org.slf4j.Logger;

import javax.annotation.Nonnull;
import java.util.UUID;

public class ExteriorBlockEntity extends BlockEntity {
    private UUID tardisUUID;
    private ExteriorAnimation animation;
    private boolean doorOpened = false;
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
        TARDIS tardis = TARDISManager.getInstance().findTARDIS(this.tardisUUID);
        this.syncToClient();
        if (tardis == null) {
            tardis = TARDISManager.getInstance().findTARDIS(new AbsoluteBlockPos(this.level, this.worldPosition));
            this.tardisUUID = tardis.getUuid();
            return tardis;
        } else {
            return tardis;
        }
    }

    public boolean doorOpen() {
        return this.doorOpened;
    }

    public void setDoorOpened(boolean bool, boolean updateClient) {
        this.doorOpened = bool;

        if (updateClient) {
            Network.sendToAll(new UpdateExteriorDoorS2CPacket(this.getBlockPos(),bool));
            Network.sendToAll(new UpdateInteriorDoorS2CPacket(this.getTARDIS().getInterior().getInteriorDoorPos(),bool));
            this.syncToClient();
        }
    }

    public void setDoorOpened(boolean bool) {
        this.setDoorOpened(bool,false);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putFloat("alpha",this.getAlpha());
        tag.putBoolean("doorOpened", this.doorOpened);

        if (this.tardisUUID != null) {
            tag.putUUID("tardisUUID", this.tardisUUID);
        }
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.getAnimation().setAlpha(tag.getFloat("alpha"));
        this.doorOpened = tag.getBoolean("doorOpened");

        try {
            this.tardisUUID = tag.getUUID("tardisUUID");
        } catch (Exception error) {
            Logger logger = LogUtils.getLogger();
            logger.error(error.toString());
        }
    }

    public void use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        this.setDoorOpened(!this.doorOpened,true);
        if (level.isClientSide || hand != InteractionHand.MAIN_HAND) {return;}


        if (this.getTARDIS() == null) {
            TARDISManager.getInstance().findTARDIS(new AbsoluteBlockPos(level,pos)).updateBlockEntity();
        }
    }

    public float getAlpha() {
        return this.getAnimation().getAlpha();
    }
    public ExteriorAnimation getAnimation() {
        if (this.animation == null) {
//            this.animation = this.getTARDIS().getExteriorAnimation();
            this.animation = new ClassicAnimation(this);
            LogUtils.getLogger().debug("Created new CLASSIC ANIMATION for " + this);
        }
        return this.animation;
    }

    public static <T extends BlockEntity> void tick(Level level, BlockPos pos, BlockState state, T entity) {
        if (!(entity instanceof ExteriorBlockEntity exterior)) {return;}

        exterior.getAnimation().tick();
    }

    public void entityInside(BlockState state, Level level, BlockPos pos, Entity player) {
        if (level.isClientSide) {return;}

        if (this.getTARDIS() == null) {
            TARDISManager.getInstance().findTARDIS(this.tardisUUID).updateBlockEntity();
        }

        if(player instanceof Player && this.doorOpen()) {
            this.getTARDIS().getInterior().teleportToDoor((Player) player);
        }
        this.syncToClient();
    }

    public void syncToClient() {
        assert level != null;
        level.setBlocksDirty(worldPosition, level.getBlockState(worldPosition), level.getBlockState(worldPosition));
        level.sendBlockUpdated(worldPosition, level.getBlockState(worldPosition), level.getBlockState(worldPosition), 3);
        setChanged();
    }
}
