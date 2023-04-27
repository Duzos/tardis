package com.duzo.tardis.tardis.io;

import com.duzo.tardis.config.TARDISModCommonConfigs;
import com.duzo.tardis.core.init.BlockInit;
import com.duzo.tardis.core.init.SoundsInit;
import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.core.world.dimension.DimensionsInit;
import com.duzo.tardis.nbt.NBTSerializers;
import com.duzo.tardis.tardis.TARDIS;
import com.duzo.tardis.tardis.exteriors.blocks.ExteriorBlock;
import com.duzo.tardis.tardis.exteriors.blocks.entities.ExteriorBlockEntity;
import com.duzo.tardis.tardis.manager.TARDISManager;
import com.duzo.tardis.tardis.util.TARDISUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class TARDISTravel {
    private final int DEMAT_AUDIO_LENGTH = 8;
    private int MAT_AUDIO_LENGTH = 10;
    private TARDIS tardis;
    private STATE state;
    private AbsoluteBlockPos destination;
    public TARDISTravel(TARDIS tardis) {
        this.tardis = tardis;
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

    public static BlockPos getRandomPosInRange(BlockPos pos, int range) {
        Random random = new Random();

        int xChange = random.nextInt(-range, range);
        int yChange = random.nextInt(-range, range);
        int zChange = random.nextInt(-range, range);

        return new BlockPos(pos.getX() + xChange, pos.getY() + yChange, pos.getZ() + zChange);
    }

    public void setDestination(AbsoluteBlockPos pos, boolean withAirCheck) {
        if (withAirCheck) {
            pos = new AbsoluteBlockPos(pos.getDimension(),searchForNearestAirBlock(pos.getDimension(),pos, Direction.UP));
        }
        this.destination = pos;
    }

    public void dematerialise() {
        this.dematerialise(false);
    }
    public void dematerialise(boolean withRemat) {
        if (this.tardis.getLevel().isClientSide) {return;}
        this.state = STATE.DEMAT;

        Level level = this.tardis.getLevel();

        level.playSound(null,this.tardis.getPosition(), SoundsInit.DEMATERIALISE.get(), SoundSource.BLOCKS, 1f,1f);

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
        }, DEMAT_AUDIO_LENGTH * 1000L);
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
                this.setDestination(tardis.getPosition(),false);
                this.materialise();
                return;
            }
        } else {
            level.playSound(null, this.destination, SoundsInit.MATERIALISE.get(), SoundSource.BLOCKS, 1f, 1f);
            MAT_AUDIO_LENGTH = 8;
        }

        // Timer code for waiting for sound to finish
        TARDISTravel travel = this;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                travel.__materialise();
            }
        }, MAT_AUDIO_LENGTH * 1000L);
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
        this.state = STATE.LANDED;
        this.tardis.updateBlockEntity();

//        if (this.tileNBT == null) {
//            this.tileNBT = new CompoundTag();
//        }
//
//        ExteriorBlockEntity tardisBlockEntity = (ExteriorBlockEntity) level.getBlockEntity(this.destination);
//        tardisBlockEntity.load(this.tileNBT);
//        System.out.println(this.tardis);
//        System.out.println(tardisBlockEntity);
//        if (tardisBlockEntity != null && this.tardis != null) {
//            System.out.println(this.tardis.getUuid());
//            tardisBlockEntity.setTARDIS(this.tardis.getUuid());
//        }
    }

    public boolean inFlight() {
        return this.state == STATE.FLIGHT;
    }
    public boolean isMaterialising() {return this.state == STATE.MAT;}
    public boolean isDematerialising() {return this.state == STATE.DEMAT;}

    public void setTARDIS(TARDIS tardis) {
        this.tardis = tardis;
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
        DEMAT,
        MAT,
        LANDED,
        FLIGHT
    }
}
