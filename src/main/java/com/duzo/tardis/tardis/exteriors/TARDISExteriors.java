package com.duzo.tardis.tardis.exteriors;

import com.duzo.tardis.tardis.exteriors.impl.ClassicExteriorSchema;
import com.duzo.tardis.tardis.exteriors.impl.OriginalExteriorSchema;

import java.util.HashMap;
import java.util.Map;

public class TARDISExteriors {
    private static final Map<String, TARDISExteriorSchema<?>> exteriors = new HashMap<>();

    /**
     * TARDIS Exteriors are registered here:
     */
    public static void init() {
        TARDISExteriors.register(new ClassicExteriorSchema());
        TARDISExteriors.register(new OriginalExteriorSchema());
    }
    public static void register(TARDISExteriorSchema<?> exterior) {exteriors.put(exterior.getID(),exterior);}
    public static TARDISExteriorSchema<?> get(String id) {
        System.out.println(exteriors);
        return exteriors.get(id);}
}
