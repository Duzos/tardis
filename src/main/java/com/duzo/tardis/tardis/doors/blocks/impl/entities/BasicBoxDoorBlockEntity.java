package com.duzo.tardis.tardis.doors.blocks.impl.entities;

import com.duzo.tardis.tardis.doors.TARDISInteriorDoorSchema;
import com.duzo.tardis.tardis.doors.TARDISInteriorDoors;
import com.duzo.tardis.tardis.doors.blocks.DoorsInit;
import com.duzo.tardis.tardis.doors.blocks.InteriorDoorBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class BasicBoxDoorBlockEntity extends InteriorDoorBlockEntity {
    public BasicBoxDoorBlockEntity(BlockEntityType<?> p_155228_, BlockPos p_155229_, BlockState p_155230_) {
        super(p_155228_, p_155229_, p_155230_);
    }
    public BasicBoxDoorBlockEntity(BlockPos pos, BlockState state) {
        this(DoorsInit.BASIC_DOOR_ENTITY.get(),pos,state);
    }

    @Override
    public TARDISInteriorDoorSchema<?> getSchema() {
        return TARDISInteriorDoors.get("basic_box");
    }
}