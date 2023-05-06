package com.duzo.tardis.tardis.interiors;

import com.duzo.tardis.tardis.interiors.impl.*;

import java.util.HashMap;
import java.util.Map;

public class TARDISInteriors {
    private static final Map<String, TARDISInteriorSchema> interiors = new HashMap<>();

    /**
     * TARDIS Interiors are registered here:
     */
    public static void init() {
        TARDISInteriors.register(new CoralInteriorSchema());
        TARDISInteriors.register(new EighthInteriorSchema());
        TARDISInteriors.register(new BakerInteriorSchema());
        TARDISInteriors.register(new WarInteriorSchema());
        TARDISInteriors.register(new ToyotaInteriorSchema());
        TARDISInteriors.register(new CopperInteriorSchema());
    }
    public static void register(TARDISInteriorSchema interior) {interiors.put(interior.getID(),interior);}
    public static TARDISInteriorSchema get(String id) {
        return interiors.get(id);}
}
