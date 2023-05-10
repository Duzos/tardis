package com.duzo.tardis.tardis.consoles.blocks.entities;

import com.duzo.tardis.config.TARDISModCommonConfigs;
import com.duzo.tardis.core.init.BlockEntityInit;
import com.duzo.tardis.core.init.EntityInit;
import com.duzo.tardis.core.init.SoundsInit;
import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.network.Network;
import com.duzo.tardis.network.packets.UpdateFlightStateS2CPacket;
import com.duzo.tardis.tardis.TARDIS;
import com.duzo.tardis.tardis.animation.ConsoleAnimation;
import com.duzo.tardis.tardis.animation.impl.BorealisAnimation;
import com.duzo.tardis.tardis.consoles.ConsoleSchema;
import com.duzo.tardis.tardis.consoles.EnumRotorState;
import com.duzo.tardis.tardis.consoles.blocks.ConsoleBlock;
import com.duzo.tardis.tardis.consoles.impl.BorealisConsoleSchema;
import com.duzo.tardis.tardis.controls.control_entities.ControlEntitySchema;
import com.duzo.tardis.tardis.io.TARDISTravel;
import com.duzo.tardis.tardis.manager.TARDISManager;
import com.duzo.tardis.tardis.util.TARDISUtil;
import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class ConsoleBlockEntity extends BlockEntity {
    private TARDIS tardis;
    public float rotorTick;
    public float rotorSpin;
    public EnumRotorState rotorState = EnumRotorState.UP;
    private ConsoleAnimation animation;
    public boolean isTARDISInFlight;
    protected ConsoleSchema<?> schema;
    protected ConsoleSchema.Serializer SCHEMA_SERIALIZER = new ConsoleSchema.Serializer();

    public ConsoleBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public ConsoleBlockEntity(BlockPos blockPos, BlockState blockState) {
        this(BlockEntityInit.CONSOLE_BLOCK_ENTITY.get(), blockPos, blockState);
    }

    public ConsoleSchema<?> getSchema() {
        return new BorealisConsoleSchema();
    }

    public void setTARDIS(TARDIS tardis) {
        this.tardis = tardis;
    }

    public float getRotorTicking() {
        return this.getAnimation().getTick();
    }

    protected void updateTARDIS(AbsoluteBlockPos pos) {
        this.setTARDIS(
                TARDISManager.getInstance().findTARDISFromInteriorCoordinate(pos)
        );
    }

    public TARDIS getTARDIS() {
        if (this.tardis == null) this.updateTARDIS(new AbsoluteBlockPos(this.level,this.getBlockPos()));

        return this.tardis;
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putBoolean("isTARDISInFlight", this.isTARDISInFlight);
        //SCHEMA_SERIALIZER.serialize(tag, this.getSchema());
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.isTARDISInFlight = tag.getBoolean("isTARDISInFlight");
        //this.schema = SCHEMA_SERIALIZER.deserialize(tag);
    }

    public ConsoleAnimation getAnimation() {
        if (this.animation == null) {
            this.animation = new BorealisAnimation(this);
            LogUtils.getLogger().debug("Created new BOREALIS ANIMATION for " + this);
        }
        return this.animation;
    }

    public static <T extends BlockEntity> void tick(Level level, BlockPos pos, BlockState state, T entity) {
        if (!(entity instanceof ConsoleBlockEntity console)) {return;}

        console.getAnimation().tick();
        if(console.getTARDIS() != null) {
            if (console.getTARDIS().getTravel().inFlight()) {
                console.getAnimation().setupAnimation(console.getTARDIS().getTravel().getState());
            }
        }
    }

    public boolean isInFlight() {
        return this.isTARDISInFlight;
    }

    public void setTARDISInFlight(boolean bool, boolean update) {
        if(this.getTARDIS().getTravel().getState() != TARDISTravel.STATE.LANDED) {
            this.isTARDISInFlight = bool;
            if(update) {
                Network.sendToAll(new UpdateFlightStateS2CPacket(this.getBlockPos(), bool));
            }
        }
    }

    public void runControlSpawn(Level level, BlockPos pos) {
        if(this.getTARDIS() != null) {
            ControlEntitySchema throttle = new ControlEntitySchema(EntityInit.BASIC_CONTROL_ENTITY.get(), level, this.getTARDIS().getUuid(), "Throttle", pos);
            ControlEntitySchema handbrake = new ControlEntitySchema(EntityInit.BASIC_CONTROL_ENTITY.get(), level, this.getTARDIS().getUuid(), "Handbrake", pos);
            throttle.setCustomNameVisible(true);
            handbrake.setCustomNameVisible(true);
            this.level.addFreshEntity(throttle);
            this.level.addFreshEntity(handbrake);
            throttle.setPos(pos.getX() + 0.8, pos.getY() + 1.4, pos.getZ() + 0.25);
            handbrake.setPos(pos.getX() - 0.8, pos.getY() + 1.4, pos.getZ() + 0.25);
        }
    }

    public void onPlace(BlockState state, Level level, BlockPos pos) {
        this.runControlSpawn(level, pos);
    }
}
