package com.duzo.tardis.tardis.io;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.core.init.BlockInit;
import com.duzo.tardis.core.init.SoundsInit;
import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.tardis.TARDIS;
import com.duzo.tardis.tardis.blocks.TARDISBlock;
import com.duzo.tardis.tardis.blocks.entities.TARDISBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.world.ForgeChunkManager;
import org.apache.logging.log4j.core.jmx.Server;

import java.lang.reflect.Method;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static net.minecraftforge.common.world.ForgeChunkManager.*;

public class TARDISTravel {
    private final int DEMAT_AUDIO_LENGTH = 8;
    private final int MAT_AUDIO_LENGTH = 10;
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

    public void setDestination(AbsoluteBlockPos pos) {
        this.destination = pos;
    }



    public void dematerialise(boolean withRemat) {
        if (this.tardis.getLevel().isClientSide) {return;}

        Level level = this.tardis.getLevel();

        level.playSound(null,this.tardis.getPosition(), SoundsInit.DEMATERIALISE.get(), SoundSource.BLOCKS, 1f,1f);

        this.state = STATE.DEMAT;

        // Timer code for waiting for sound to finish
        TARDISTravel travel = this;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // Delete the block and rematerialise if needed.
                ForgeChunkManager.forceChunk((ServerLevel) level, TARDISMod.MODID, travel.tardis.getPosition(),0, 0,true,true);

                level.removeBlock(travel.tardis.getPosition(), false);
                travel.state = STATE.FLIGHT;

                if (withRemat) {
                    travel.materialise();
                }
            }
        }, DEMAT_AUDIO_LENGTH * 1000L);
    }

    public void materialise() {
        if (this.destination == null || this.destination.getDimension().isClientSide) {return;}

        Level level = this.destination.getDimension();

        ForgeChunkManager.forceChunk((ServerLevel) level, TARDISMod.MODID, this.destination,0, 0,true,true);
        level.playSound(null,this.tardis.getPosition(), SoundsInit.MATERIALISE.get(), SoundSource.BLOCKS, 1f,1f);

        this.state = STATE.MAT;

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

        ForgeChunkManager.forceChunk((ServerLevel) level, TARDISMod.MODID, this.destination,0, 0,true,true);

        TARDISBlock block = (TARDISBlock) BlockInit.TARDIS_BLOCK.get();
        BlockState state = block.defaultBlockState().setValue(TARDISBlock.FACING, this.destination.getDirection());
        level.setBlockAndUpdate(this.destination, state);
        level.setBlockEntity(new TARDISBlockEntity(this.destination, state));

        TARDISBlockEntity tardisBlockEntity = (TARDISBlockEntity) this.destination.getDimension().getBlockEntity(this.destination);
        if (tardisBlockEntity != null) {tardisBlockEntity.setTARDIS(this.tardis);}

        this.tardis.setPosition(this.destination);
        this.state = STATE.LANDED;
    }


    public void setTARDIS(TARDIS tardis) {
        this.tardis = tardis;
    }

    public enum STATE {
        DEMAT,
        MAT,
        LANDED,
        FLIGHT
    }
}
