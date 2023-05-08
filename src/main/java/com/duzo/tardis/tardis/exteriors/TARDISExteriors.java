package com.duzo.tardis.tardis.exteriors;

import java.util.HashMap;
import java.util.Map;

public class TARDISExteriors {
    private static final Map<String, TARDISExteriorSchema<?>> exteriors = new HashMap<>();

    /**
     * TARDIS Exteriors are registered here:
     */
    public static void init() {

    }
    public static void register(TARDISExteriorSchema<?> exterior) {exteriors.put(exterior.getID(),exterior);}
    public static TARDISExteriorSchema<?> get(String id) {
        return exteriors.get(id);}
}
