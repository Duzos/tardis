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
import com.duzo.tardis.tardis.consoles.impl.BorealisConsoleSchema;
import com.duzo.tardis.tardis.controls.control_entities.ControlEntitySchema;
import com.duzo.tardis.tardis.controls.control_entities.impl.*;
import com.duzo.tardis.tardis.doors.blocks.InteriorDoorBlockEntity;
import com.duzo.tardis.tardis.io.TARDISTravel;
import com.duzo.tardis.tardis.manager.TARDISManager;
import com.duzo.tardis.tardis.util.TARDISUtil;
import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.ArrayList;
import java.util.List;

public class ConsoleBlockEntity extends BlockEntity {
    private TARDIS tardis;
    public float rotorTick;
    public float rotorSpin;
    public EnumRotorState rotorState = EnumRotorState.UP;
    private ConsoleAnimation animation;
    public boolean isTARDISInFlight;
    protected ConsoleSchema<?> schema;
    protected ConsoleSchema.Serializer SCHEMA_SERIALIZER = new ConsoleSchema.Serializer();
    protected TARDISTravel.STATE previousState;
    protected TARDISTravel.STATE state;
    private List<ControlEntitySchema> controlEntities = new ArrayList<>();
    SharedValues sharedValues = SharedValues.getInstance();
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
            this.animation = new BorealisAnimation(this); // @TODO animations changing based on console unit
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

        // Rotor sound code
        if (level.isClientSide) {return;}
        if (level != TARDISUtil.getTARDISLevel()) {return;}

        ((ConsoleBlockEntity) entity).updateState();
    }

    public boolean isInFlight() {
        return this.isTARDISInFlight;
    }

    public void setTARDISInFlight(boolean bool, boolean update) {
        if(this.getTARDIS().getTravel().getState() == TARDISTravel.STATE.LANDED) return;

        this.isTARDISInFlight = bool;

        if(update) {
            Network.sendToAll(new UpdateFlightStateS2CPacket(this.getBlockPos(), bool));
        }
    }

    public ControlEntitySchema addControlEntity(ControlEntitySchema schema) {
        this.controlEntities.add(schema);
        schema.setCustomNameVisible(true);
        this.level.addFreshEntity(schema);
        return schema;
    }

    private void removeControls() {
        for (ControlEntitySchema entity : this.controlEntities) {
            entity.setRemoved(Entity.RemovalReason.DISCARDED);
        }
    }

    public void runControlSpawn(Level level, BlockPos pos) {
        float multipleOfX = 1;
        float multipleOfZ = 1;
        float addSubX = 0;
        float addSubZ = 0;
        Direction direction = this.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);
        if(this.getTARDIS() == null) return;

        if(direction.equals(Direction.NORTH)) {
            multipleOfX = multipleOfX * 1f;
            multipleOfZ = multipleOfZ * 1f;
            addSubX = 0;
            addSubZ = 0;
        }
        /*if(direction.equals(Direction.EAST)) {
            multipleOfX = multipleOfX * 1f;
            multipleOfZ = multipleOfZ * -1f;
            addSubX = -0.5f;
            addSubZ = 0.5f;
        }*/
        if(direction.equals(Direction.SOUTH)) {
            multipleOfX = multipleOfX * -1f;
            multipleOfZ = multipleOfZ * -1f;
            addSubX = 1f;
            addSubZ = 1f;
        }
        /*if(direction.equals(Direction.WEST)) {
            multipleOfX = multipleOfX * 1f;
            multipleOfZ = multipleOfZ * -1f;
            addSubX = 1f;
            addSubZ = 1f;
        }*/

        this.addControlEntity(new ThrottleControlEntity(EntityInit.THROTTLE_CONTROL_ENTITY.get(), level, this.getTARDIS().getUuid(), "Throttle", pos)).setPos(pos.getX() + (1.3 * multipleOfX) + addSubX, pos.getY() + 1.05, pos.getZ() + (0.7225 * multipleOfZ) + addSubZ);
        this.addControlEntity(new HandbrakeControlEntity(EntityInit.HANDBRAKE_CONTROL_ENTITY.get(), level, this.getTARDIS().getUuid(), "Handbrake", pos)).setPos(pos.getX() + (1.08 * multipleOfX) + addSubX, pos.getY() + 1.05, pos.getZ() + (1.08 * multipleOfZ) + addSubZ);
        this.addControlEntity(new XCoordinateControlEntity(EntityInit.X_CONTROL_ENTITY.get(), level, this.getTARDIS().getUuid(), "X", pos)).setPos(pos.getX() + (0.375 * multipleOfX) + addSubX, pos.getY() + 1.15, pos.getZ() + (1.05 * multipleOfZ) + addSubZ);
        this.addControlEntity(new YCoordinateControlEntity(EntityInit.Y_CONTROL_ENTITY.get(), level, this.getTARDIS().getUuid(), "Y", pos)).setPos(pos.getX() + (0.5 * multipleOfX) + addSubX, pos.getY() + 1.15, pos.getZ() + (1.05 * multipleOfZ) + addSubZ);
        this.addControlEntity(new ZCoordinateControlEntity(EntityInit.Z_CONTROL_ENTITY.get(), level, this.getTARDIS().getUuid(), "Z", pos)).setPos(pos.getX() + (0.625 * multipleOfX) + addSubX, pos.getY() + 1.15, pos.getZ() + (1.05 * multipleOfZ) + addSubZ);
        this.addControlEntity(new IncrementCoordinateControlEntity(EntityInit.INCREMENT_CONTROL_ENTITY.get(), level, this.getTARDIS().getUuid(), "Increment", pos)).setPos(pos.getX() + (0.5 * multipleOfX) + addSubX, pos.getY() + 1.05, pos.getZ() + (1.2 * multipleOfZ) + addSubZ);
        this.addControlEntity(new DoorControlEntity(EntityInit.DOOR_CONTROL_ENTITY.get(), level, this.getTARDIS().getUuid(), "Door Control", pos)).setPos(pos.getX() + (0.5 * multipleOfX) + addSubX, pos.getY() + 1.05, pos.getZ() - (0.3 * multipleOfZ) + addSubZ);
        this.addControlEntity(new MonitorControlEntity(EntityInit.MONITOR_CONTROL_ENTITY.get(), level, this.getTARDIS().getUuid(), "Monitor", pos)).setPos(pos.getX() - (0.15 * multipleOfX) + addSubX, pos.getY() + 1.05, pos.getZ() + (0.125 * multipleOfZ) + addSubZ);
    }

    public ControlEntitySchema getControl(String controlName) {
        for (ControlEntitySchema entity : this.controlEntities) {
            if (entity.getControlName().equals(controlName)) {
                return entity;
            }
        }
        return null;
    }

    /*public ControlEntitySchema getControl(Class<ControlEntitySchema> schema) {
        for (ControlEntitySchema entity : this.controlEntities) {
            if (schema.isInstance(entity)) {
                return entity;
            }
        }
        return null;
    }*/

    public int getIncrement() {
        return this.getControl("Increment").getIncrementValue();
    }

    @Override
    public void setRemoved() {
        this.removeControls();
        super.setRemoved();
    }

    public void onPlace(BlockState state, Level level, BlockPos pos) {
        this.runControlSpawn(level, pos);
        this.setHandbrake(true);
        this.setThrottle();
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

    private void runHopLanding() {
        this.level.playSound(null,this.getBlockPos(), SoundsInit.HOP_LAND.get(), SoundSource.BLOCKS, 1f,1f);
    }

    private void runHopTakeoff() {
        this.level.playSound(null,this.getBlockPos(), SoundsInit.HOP_TAKEOFF.get(), SoundSource.BLOCKS, 1f,1f);
    }
    private void runFailTakeoff() {
        this.level.playSound(null,this.getBlockPos(), SoundsInit.FAIL_TAKEOFF.get(), SoundSource.BLOCKS, 1f,1f);
    }

    private void updateState() {
        if (this.getTARDIS() == null) return;

        TARDISTravel travel = this.getTARDIS().getTravel();

        if (travel.getState() == this.state) {return;}

        this.previousState = this.state;
        this.state = travel.getState();

        if (this.state == TARDISTravel.STATE.DEMAT) {
            this.runDematerialise();
        }
        else if (this.state == TARDISTravel.STATE.MAT) {
            this.runMaterialise();
        } else if (this.state == TARDISTravel.STATE.HOP_TAKEOFF) {
            this.runHopTakeoff();
        } else if (this.state == TARDISTravel.STATE.HOP_MAT) {
            this.runHopLanding();
        } else if (this.state == TARDISTravel.STATE.FAIL_TAKEOFF) {
            this.runFailTakeoff();
        } else if (this.state != TARDISTravel.STATE.LANDED) {
            this.setTARDISInFlight(true, true);
        }

        System.out.println(this.state);
    }

    public static class SharedValues {

        private static SharedValues sharedValues = new SharedValues();
        public static SharedValues getInstance(){return sharedValues;}

        private boolean handbrakeEnabled;
        private boolean throttleEnabled;
        private boolean doorControlEnabled;

        public void setHandbrakeEnabled(boolean bool){this.handbrakeEnabled = bool;}
        public void setThrottleEnabled(boolean bool){this.throttleEnabled = bool;}
        public void setDoorControlEnabled(boolean bool){this.doorControlEnabled = bool;}

        public boolean getHandbrakeEnabled(){return this.handbrakeEnabled;}
        public boolean getThrottleEnabled(){return this.throttleEnabled;}
        public boolean getDoorControlEnabled(){return this.doorControlEnabled;}
    }

    public void setHandbrake(Boolean shouldSetToFalse) {
        if(this.getTARDIS() == null) {return;}
        if(shouldSetToFalse) {
            sharedValues.setHandbrakeEnabled(false);
        } else {
            sharedValues.setHandbrakeEnabled(this.getTARDIS().getTravel().getHandbrake());
        }
    }

    public void setThrottle() {
        if(this.getTARDIS() == null) {return;}
        sharedValues.setThrottleEnabled(this.getTARDIS().getTravel().getState() != TARDISTravel.STATE.LANDED);
    }

    public void setDoorControl() {
        if(this.getTARDIS() == null) {return;}
        if(this.getTARDIS().getInterior().getInteriorDoorPos() == null) {return;}
        InteriorDoorBlockEntity door = (InteriorDoorBlockEntity) this.level.getBlockEntity(this.getTARDIS().getInterior().getInteriorDoorPos());
        sharedValues.setDoorControlEnabled(door.doorOpen());
    }
}
