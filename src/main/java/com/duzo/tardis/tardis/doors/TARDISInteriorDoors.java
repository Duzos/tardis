package com.duzo.tardis.tardis.doors;

import com.duzo.tardis.tardis.doors.blocks.DoorsInit;
import com.duzo.tardis.tardis.doors.impl.CoralInteriorDoorSchema;
import com.duzo.tardis.tardis.doors.impl.WarInteriorDoorSchema;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TARDISInteriorDoors {
    private static final Map<String, TARDISInteriorDoorSchema<?>> doors = new HashMap<>();
    // A list of locations for the doors
    @Deprecated
    public static final String[] INTERIOR_DOOR_BLOCK_ID_LIST = new String[]{
            "tardis:coral_door_block"
    };
    public static final List<Block> INTERIOR_DOOR_BLOCK_LIST = List.of(new Block[]{
            DoorsInit.CORAL_DOOR_BLOCK.get(),
            DoorsInit.WAR_DOOR_BLOCK.get()
    });

    /**
     * TARDIS Doors are registered here:
     */
    public static void init() {
        TARDISInteriorDoors.register(new CoralInteriorDoorSchema());
        TARDISInteriorDoors.register(new WarInteriorDoorSchema());
    }

    public static void register(TARDISInteriorDoorSchema<?> exterior) {
        doors.put(exterior.getID(), exterior);
    }

    public static TARDISInteriorDoorSchema<?> get(String id) {
        return doors.get(id);
    }
}