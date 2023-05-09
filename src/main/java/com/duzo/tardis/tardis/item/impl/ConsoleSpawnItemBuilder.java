package com.duzo.tardis.tardis.item.impl;

import com.duzo.tardis.tardis.builder.TARDISBuilder;
import com.duzo.tardis.tardis.consoles.ConsoleSchema;
import com.duzo.tardis.tardis.consoles.Consoles;
import com.duzo.tardis.tardis.exteriors.TARDISExteriorSchema;
import com.duzo.tardis.tardis.exteriors.TARDISExteriors;
import com.duzo.tardis.tardis.interiors.TARDISInteriorSchema;
import com.duzo.tardis.tardis.interiors.TARDISInteriors;
import com.duzo.tardis.tardis.item.ConsoleSpawnItem;
import net.minecraft.world.item.Item;

public class ConsoleSpawnItemBuilder extends ConsoleSpawnItem {
    private String console;

    public ConsoleSpawnItemBuilder(Properties properties, String console, String interior) {
        super(properties);
        this.console = console;
    }
    public ConsoleSpawnItemBuilder(Properties properties) {
        super(properties);
        this.console = TARDISBuilder.DEFAULT_INTERIOR;
    }

    public ConsoleSpawnItemBuilder console(String console) {
        this.console = console;
        return this;
    }

    @Override
    protected ConsoleSchema getConsole() {
        return Consoles.get(this.console);
    }
}
