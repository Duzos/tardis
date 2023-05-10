package com.duzo.tardis.tardis.consoles.blocks.entities;

import com.duzo.tardis.core.init.BlockEntityInit;
import com.duzo.tardis.core.init.EntityInit;
import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.tardis.TARDIS;
import com.duzo.tardis.tardis.animation.ConsoleAnimation;
import com.duzo.tardis.tardis.animation.impl.BorealisAnimation;
import com.duzo.tardis.tardis.consoles.EnumRotorState;
import com.duzo.tardis.tardis.controls.control_entities.ControlEntitySchema;
import com.duzo.tardis.tardis.manager.TARDISManager;
import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
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
    //protected ConsoleSchema<?> schema;
    //protected ConsoleSchema.Serializer SCHEMA_SERIALIZER = new ConsoleSchema.Serializer();

    public ConsoleBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public ConsoleBlockEntity(BlockPos blockPos, BlockState blockState) {
        this(BlockEntityInit.CONSOLE_BLOCK_ENTITY.get(), blockPos, blockState);
    }

    //public ConsoleSchema<?> getSchema() {
    //    return this.schema;
    //}

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
        //SCHEMA_SERIALIZER.serialize(tag, this.getSchema());
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
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

    public void onPlace(BlockState state, Level level, BlockPos pos) {
        if(this.getTARDIS() != null) {
            ControlEntitySchema control = new ControlEntitySchema(EntityInit.BASIC_CONTROL_ENTITY.get(), level, this.getTARDIS().getUuid(), "Throttle");
            this.level.addFreshEntity(control);
            System.out.println(control + "|@#@#|");
            control.setPos(pos.getX() + 0.65, pos.getY() + 0.5, pos.getZ() + 0.25);
        }
    }
}
