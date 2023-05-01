package com.duzo.tardis.tardis.controls;

import com.duzo.tardis.tardis.controls.impl.*;

import java.util.HashMap;
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
        TARDISControls.register(new WarRotorSchema());
        TARDISControls.register(new EighthRotorSchema());
    }

    public static void register(TARDISControlSchema<?> control) {
        controls.put(control.getID(), control);
    }

    public static TARDISControlSchema<?> get(String id) {
        return controls.get(id);
    }
}
