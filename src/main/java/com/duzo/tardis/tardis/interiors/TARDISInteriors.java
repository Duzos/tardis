package com.duzo.tardis.tardis.interiors;

import com.duzo.tardis.tardis.interiors.impl.BakerInterior;
import com.duzo.tardis.tardis.interiors.impl.CoralInterior;
import com.duzo.tardis.tardis.interiors.impl.EighthInterior;

import java.util.HashMap;
import java.util.Map;

public class TARDISInteriors {
    private static final Map<String, TARDISInterior> interiors = new HashMap<>();

    /**
     * TARDIS Interiors are registered here:
     */
    public static void init() {
        TARDISInteriors.register(new CoralInterior());
        TARDISInteriors.register(new EighthInterior());
        TARDISInteriors.register(new BakerInterior());
    }
    public static void register(TARDISInterior interior) {interiors.put(interior.getID(),interior);}
    public static TARDISInterior get(String id) {
        return interiors.get(id);}
}
