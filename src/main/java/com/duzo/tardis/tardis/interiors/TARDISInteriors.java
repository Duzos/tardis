package com.duzo.tardis.tardis.interiors;

import java.util.HashMap;
import java.util.Map;

public class TARDISInteriors {
    private static final Map<String, TARDISInteriorSchema> interiors = new HashMap<>();

    /**
     * TARDIS Interiors are registered here:
     */
    public static void init() {

    }
    public static void register(TARDISInteriorSchema interior) {interiors.put(interior.getID(),interior);}
    public static TARDISInteriorSchema get(String id) {
        return interiors.get(id);}
}
