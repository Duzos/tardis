package com.duzo.tardis.tardis.exteriors;

import com.duzo.tardis.tardis.exteriors.impl.BakerExteriorSchema;
import com.duzo.tardis.tardis.exteriors.impl.ClassicExteriorSchema;
import com.duzo.tardis.tardis.exteriors.impl.OriginalExteriorSchema;
import com.duzo.tardis.tardis.exteriors.impl.ThirdExteriorSchema;

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
        TARDISExteriors.register(new ThirdExteriorSchema());
        TARDISExteriors.register(new BakerExteriorSchema());
    }
    public static void register(TARDISExteriorSchema<?> exterior) {exteriors.put(exterior.getID(),exterior);}
    public static TARDISExteriorSchema<?> get(String id) {
        System.out.println(exteriors);
        return exteriors.get(id);}
}
