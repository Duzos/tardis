package com.duzo.tardis.tardis.consoles;

import com.duzo.tardis.tardis.consoles.impl.BorealisConsoleSchema;
import com.duzo.tardis.tardis.consoles.impl.HudolinConsoleSchema;

import java.util.HashMap;
import java.util.Map;

public class Consoles {
    private static final Map<String, ConsoleSchema<?>> consoles = new HashMap<>();

    /**
     * TARDIS consoles are registered here:
     */
    public static void init() {
        register(new BorealisConsoleSchema());
        register(new HudolinConsoleSchema());
    }
    public static void register(ConsoleSchema<?> console) {consoles.put(console.getID(),console);}
    public static ConsoleSchema<?> get(String id) {
        return consoles.get(id);}
}
