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
        TARDISExteriors.register(new WarExteriorSchema());
        TARDISExteriors.register(new CopperExteriorSchema());
        TARDISExteriors.register(new ToyotaExteriorSchema());
        TARDISExteriors.register(new HellBentExteriorSchema());
        TARDISExteriors.register(new HartnellTTExteriorSchema());
        TARDISExteriors.register(new HartnellExteriorSchema());
    }
    public static void register(TARDISExteriorSchema<?> exterior) {exteriors.put(exterior.getID(),exterior);}
    public static TARDISExteriorSchema<?> get(String id) {
        return exteriors.get(id);}
}
