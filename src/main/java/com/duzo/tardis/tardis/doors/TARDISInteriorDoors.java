package com.duzo.tardis.tardis.doors;

import com.duzo.tardis.tardis.doors.impl.ClassicInteriorDoorSchema;
import com.duzo.tardis.tardis.exteriors.TARDISExteriorSchema;

import java.util.HashMap;
import java.util.Map;

public class TARDISInteriorDoors {
    private static final Map<String, TARDISInteriorDoorSchema<?>> doors = new HashMap<>();

    /**
     * TARDIS Doors are registered here:
     */
    public static void init() {
        TARDISInteriorDoors.register(new ClassicInteriorDoorSchema());
    }

    public static void register(TARDISInteriorDoorSchema<?> exterior) {
        doors.put(exterior.getID(), exterior);
    }

    public static TARDISInteriorDoorSchema<?> get(String id) {
        return doors.get(id);
    }
}