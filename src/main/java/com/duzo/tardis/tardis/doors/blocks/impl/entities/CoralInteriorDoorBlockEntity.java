package com.duzo.tardis.tardis.doors.blocks.impl.entities;

import com.duzo.tardis.tardis.doors.TARDISInteriorDoors;
import com.duzo.tardis.tardis.doors.blocks.DoorsInit;
import com.duzo.tardis.tardis.doors.blocks.InteriorDoorBlockEntity;
import com.duzo.tardis.tardis.doors.TARDISInteriorDoorSchema;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class CoralInteriorDoorBlockEntity extends InteriorDoorBlockEntity {
    public CoralInteriorDoorBlockEntity(BlockEntityType<?> p_155228_, BlockPos p_155229_, BlockState p_155230_) {
        super(p_155228_, p_155229_, p_155230_);
    }
    public CoralInteriorDoorBlockEntity(BlockPos pos, BlockState state) {
        this(DoorsInit.CORAL_DOOR_ENTITY.get(),pos,state);
    }

    @Override
    public TARDISInteriorDoorSchema<?> getSchema() {
        return TARDISInteriorDoors.get("coral");
    }
}
