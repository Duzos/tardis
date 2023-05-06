package com.duzo.tardis.tardis.io;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.config.TARDISModCommonConfigs;
import com.duzo.tardis.core.init.BlockInit;
import com.duzo.tardis.core.init.SoundsInit;
import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.nbt.NBTSerializers;
import com.duzo.tardis.tardis.TARDIS;
import com.duzo.tardis.tardis.exteriors.blocks.ExteriorBlock;
import com.duzo.tardis.tardis.exteriors.blocks.entities.ExteriorBlockEntity;
import com.duzo.tardis.tardis.manager.TARDISManager;
import com.duzo.tardis.tardis.util.TARDISUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class TARDISTravel {
    private final int DEMAT_AUDIO_LENGTH = 8;
    private int MAT_AUDIO_LENGTH = 10;
    private final long SECONDS = 1000L;
    private final long MINUTES = SECONDS * 60;
    private TARDIS tardis;
    private STATE state;
    private AbsoluteBlockPos destination;
    private boolean handbrakeOn;
    public TARDISTravel(TARDIS tardis) {
        this.tardis = tardis;
        this.handbrakeOn = false;
    }
    public static BlockPos searchForNearestAirBlock(Level level,BlockPos pos, Direction direction) {
        if (direction != Direction.UP && direction != Direction.DOWN) {direction = Direction.UP;}

        BlockPos testingPos = pos;

        if (direction == Direction.UP) {
            while (level.getBlockState(testingPos).getBlock() != Blocks.AIR) {
                testingPos = testingPos.above();
            }
        } else {
            while (level.getBlockState(testingPos).getBlock() != Blocks.AIR) {
                testingPos = testingPos.below();
            }
        }

        return testingPos;
    }

    public static BlockPos checkForNearestNonAirBlock(Level level, BlockPos pos, Direction direction) {
        if (direction != Direction.UP && direction != Direction.DOWN) {direction = Direction.UP;}

        BlockPos testingPos = pos;

        if (direction == Direction.UP) {
            while (level.getBlockState(testingPos).getBlock() == Blocks.AIR) {
                testingPos = testingPos.above();
            }
        } else {
            while (level.getBlockState(testingPos).getBlock() == Blocks.AIR) {
                testingPos = testingPos.below();
            }
        }

        return testingPos.above();
    }

    public static BlockPos getRandomPosInRange(BlockPos pos, int range) {
        Random random = new Random();

        int xChange = random.nextInt(-range, range);
        int yChange = random.nextInt(-range, range);
        int zChange = random.nextInt(-range, 0);

        return new BlockPos(pos.getX() + xChange, pos.getY() + yChange, pos.getZ() + zChange);
    }

    public void setDestination(AbsoluteBlockPos pos, boolean withChecks) {
        if (withChecks) {
            pos = new AbsoluteBlockPos(pos.getDimension(),pos.getDirection(),
                    checkForNearestNonAirBlock(pos.getDimension(),
                    searchForNearestAirBlock(pos.getDimension(),pos, Direction.UP),
                            Direction.DOWN)
            );
        }
        this.destination = pos;
    }
    public AbsoluteBlockPos getDestination() {
        return this.destination;
    }
    private boolean canTakeoff() {
        return (this.state == STATE.LANDED) && !(this.handbrakeOn);
    }
    private boolean runHandbrakeChecks() {
        if (this.handbrakeOn && this.state == STATE.LANDED) {
            this.state = STATE.FAIL_TAKEOFF;
            this.tardis.getLevel().playSound(null, this.tardis.getPosition(), SoundsInit.FAIL_TAKEOFF.get(), SoundSource.BLOCKS, 1f,1f);
            this.runAnimations();
            this.startHopping();

            // making sure that it does land
            TARDISTravel travel = this;
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    travel.state = STATE.LANDED;
                }
            }, MAT_AUDIO_LENGTH * SECONDS);

            return true;
        }
        return false;
    }

    private void runAnimations() {
        Level level = this.tardis.getLevel();
        level.getChunkAt(this.tardis.getPosition());
        BlockEntity entity = level.getBlockEntity(this.tardis.getPosition());
        if (entity instanceof ExteriorBlockEntity) {
            ((ExteriorBlockEntity) entity).getAnimation().setupAnimation(this.state);
        }
    }

    public void startHopping() {
        Random random = new Random();
        TARDISTravel travel = this;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                travel.__hopTakeoff();
            }
        }, random.nextInt(1,5) * MINUTES);
    }

    private void __hopTakeoff() {
        if (this.tardis.getLevel().isClientSide) {return;}

        if (this.runHandbrakeChecks()) {
            return;
        }

        if (!(this.canTakeoff())) {
            this.startHopping();
            return;
        }

        this.state = STATE.HOP_TAKEOFF;

        Level level = this.tardis.getLevel();

        level.playSound(null,this.tardis.getPosition(), SoundsInit.HOP_TAKEOFF.get(), SoundSource.BLOCKS, 1f,1f);

        this.runAnimations();

        this.setDestination(new AbsoluteBlockPos(this.tardis.getPosition().getDimension(),getRandomPosInRange(this.tardis.getPosition(), 10)),true);

        // Timer code for waiting for sound to finish
        TARDISTravel travel = this;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // Delete the block and rematerialise if needed.
//                ForgeChunkManager.forceChunk((ServerLevel) level, TARDISMod.MODID, travel.tardis.getPosition(),0, 0,true,true);
                travel.state = STATE.FLIGHT;
                level.getChunkAt(travel.destination);

                level.removeBlock(travel.tardis.getPosition(), false);

                travel.__hopLand();
            }
        }, 11 * SECONDS);
    }

    private void __hopLand() {
        if (this.destination == null || this.destination.getDimension().isClientSide) {
            return;
        }

        this.state = STATE.HOP_LAND;

        Level level = this.destination.getDimension();

        level.getChunkAt(this.destination);

        ExteriorBlock block = (ExteriorBlock) BlockInit.TARDIS_BLOCK.get();
        BlockState state = block.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, this.destination.getDirection());
        level.setBlockAndUpdate(this.destination, state);
        level.setBlockEntity(new ExteriorBlockEntity(this.destination, state));
        level.playSound(null, this.destination, SoundsInit.HOP_LAND.get(), SoundSource.BLOCKS, 1f, 1f);

        this.tardis.setPosition(this.destination);
        this.tardis.updateBlockEntity();

        this.runAnimations();
        this.startHopping();

        // making sure that it does land
        TARDISTravel travel = this;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                travel.state = STATE.LANDED;
            }
        }, MAT_AUDIO_LENGTH * SECONDS);
    }

    public void dematerialise() {
        this.dematerialise(false);
    }
    public void dematerialise(boolean withRemat) {
        if (this.tardis.getLevel().isClientSide) {return;}

        Level level = this.tardis.getLevel();

        if (this.runHandbrakeChecks()) {
            return;
        }

        if (!(this.canTakeoff())) {
            return;
        }

        this.state = STATE.DEMAT;

        level.playSound(null,this.tardis.getPosition(), SoundsInit.DEMATERIALISE.get(), SoundSource.BLOCKS, 1f,1f);

        this.runAnimations();

        // Timer code for waiting for sound to finish
        TARDISTravel travel = this;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // Delete the block and rematerialise if needed.
//                ForgeChunkManager.forceChunk((ServerLevel) level, TARDISMod.MODID, travel.tardis.getPosition(),0, 0,true,true);
                travel.state = STATE.FLIGHT;
                level.getChunkAt(travel.destination);

                level.removeBlock(travel.tardis.getPosition(), false);

                if (withRemat) {
                    travel.materialise();
                }
            }
        }, DEMAT_AUDIO_LENGTH * SECONDS);
    }

    public void materialise() {
        if (this.destination == null || this.destination.getDimension().isClientSide) {return;}

        this.state = STATE.MAT;

        Level level = this.destination.getDimension();

//        ForgeChunkManager.forceChunk((ServerLevel) level, TARDISMod.MODID, this.destination,0, 0,true,true);
        level.getChunkAt(this.destination);
        if (level == TARDISUtil.getTARDISLevel()) {
            if (TARDISModCommonConfigs.CAN_LAND_IN_TARDIS_DIM.get()) {
                level.playSound(null, this.destination, SoundsInit.EMERGENCY_LAND.get(), SoundSource.BLOCKS, 1f,1f);
                MAT_AUDIO_LENGTH = 16;
            } else {
                level.playSound(null, this.destination, SoundsInit.FAIL_LAND.get(), SoundSource.BLOCKS, 1f,1f);
                this.setDestination(this.tardis.getPosition(),false);

                if (this.tardis.getPosition().getDimension() == TARDISUtil.getTARDISLevel()) {
                    this.setDestination(new AbsoluteBlockPos(TARDISMod.server.overworld(), this.tardis.getPosition()),false);
                }

                this.materialise();
                return;
            }
        } else {
            level.playSound(null, this.destination, SoundsInit.MATERIALISE.get(), SoundSource.BLOCKS, 1f, 1f);
            MAT_AUDIO_LENGTH = 10;
        }

        // Timer code for waiting for sound to finish
        TARDISTravel travel = this;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                travel.__materialise();
            }
        }, MAT_AUDIO_LENGTH * SECONDS);
    }

    private void __materialise() {
        if (this.destination.getDimension().isClientSide) {return;}

        Level level = this.destination.getDimension();

//        ForgeChunkManager.forceChunk((ServerLevel) level, TARDISMod.MODID, this.destination,0, 0,true,true);
        level.getChunkAt(this.destination);

        ExteriorBlock block = (ExteriorBlock) BlockInit.TARDIS_BLOCK.get();
        BlockState state = block.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, this.destination.getDirection());
        level.setBlockAndUpdate(this.destination, state);
        level.setBlockEntity(new ExteriorBlockEntity(this.destination, state));

        this.tardis.setPosition(this.destination);
        this.tardis.updateBlockEntity();

        this.runAnimations();

        // making sure that it does land
        TARDISTravel travel = this;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                travel.state = STATE.LANDED;
            }
        }, MAT_AUDIO_LENGTH * SECONDS);
    }

    public boolean inFlight() {
        return this.state == STATE.FLIGHT;
    }
    public boolean isMaterialising() {return this.state == STATE.MAT;}
    public boolean isDematerialising() {return this.state == STATE.DEMAT;}
    public STATE getState() {
        return this.state;
    }
    public void setState(STATE state) {
        this.state = state;
    }
    public void setTARDIS(TARDIS tardis) {
        this.tardis = tardis;
    }

    public void changeHandbrake() {
        this.handbrakeOn = !this.handbrakeOn;
    }

    public static class Serializer {
        private static final NBTSerializers.AbsolutePosition ABSOLUTE_POSITION_SERIALIZER = new NBTSerializers.AbsolutePosition();

        public CompoundTag serialize(TARDISTravel travel) {
            CompoundTag tag = new CompoundTag();
            this.serialize(tag,travel);
            return tag;
        }
        public void serialize(CompoundTag nbt, TARDISTravel travel) {
            nbt.putUUID("uuid",travel.tardis.getUuid());
            ABSOLUTE_POSITION_SERIALIZER.serialize(nbt,travel.destination);
//            nbt.put("destination", NbtUtils.writeBlockPos(travel.destination));
        }
        public TARDISTravel deserialize(CompoundTag nbt) {
            TARDISTravel travel = new TARDISTravel(TARDISManager.getInstance().findTARDIS(nbt.getUUID("uuid")));
//            travel.destination = NbtUtils.readBlockPos(nbt.getCompound("destination"));
            travel.destination = ABSOLUTE_POSITION_SERIALIZER.deserialize(nbt);
            return travel;
        }
    }


    public enum STATE {
        FAIL_TAKEOFF,
        HOP_TAKEOFF,
        HOP_LAND,
        DEMAT,
        MAT,
        LANDED,
        FLIGHT
    }
}
