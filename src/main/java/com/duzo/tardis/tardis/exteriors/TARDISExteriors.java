package com.duzo.tardis.tardis.exteriors;

import com.duzo.tardis.tardis.exteriors.impl.*;

import java.util.HashMap;
import java.util.Map;

public class TARDISExteriors {
    private static final Map<String, TARDISExteriorSchema<?>> exteriors = new HashMap<>();

    /**
     * TARDIS Exteriors are registered here:
     */
    public static void init() {
        TARDISExteriors.register(new CoralExteriorSchema());
        TARDISExteriors.register(new OriginalExteriorSchema());
        TARDISExteriors.register(new ThirdExteriorSchema());
        TARDISExteriors.register(new SecondExteriorSchema());
        TARDISExteriors.register(new BakerExteriorSchema());
    }
    public static void register(TARDISExteriorSchema<?> exterior) {exteriors.put(exterior.getID(),exterior);}
    public static TARDISExteriorSchema<?> get(String id) {
        System.out.println(exteriors);
        return exteriors.get(id);}
}
