package com.duzo.tardis.tardis.controls;

import com.duzo.tardis.tardis.controls.impl.CoralDematLeverSchema;
import com.duzo.tardis.tardis.controls.impl.CoralRotorSchema;
import com.duzo.tardis.tardis.controls.impl.VanillaDematLeverSchema;
import com.duzo.tardis.tardis.doors.TARDISInteriorDoorSchema;
import com.duzo.tardis.tardis.doors.TARDISInteriorDoors;
import com.duzo.tardis.tardis.doors.blocks.DoorsInit;
import com.duzo.tardis.tardis.doors.impl.ClassicInteriorDoorSchema;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TARDISControls {
    private static final Map<String, TARDISControlSchema<?>> controls = new HashMap<>();

    /**
     * TARDIS Controls are registered here:
     */
    public static void init() {
        TARDISControls.register(new CoralDematLeverSchema());
        TARDISControls.register(new VanillaDematLeverSchema());
        TARDISControls.register(new CoralRotorSchema());
    }

    public static void register(TARDISControlSchema<?> control) {
        controls.put(control.getID(), control);
    }

    public static TARDISControlSchema<?> get(String id) {
        return controls.get(id);
    }
}
