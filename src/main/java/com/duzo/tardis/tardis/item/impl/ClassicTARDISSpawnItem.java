package com.duzo.tardis.tardis.item.impl;

import com.duzo.tardis.tardis.exteriors.TARDISExteriorSchema;
import com.duzo.tardis.tardis.exteriors.TARDISExteriors;
import com.duzo.tardis.tardis.interiors.TARDISInterior;
import com.duzo.tardis.tardis.interiors.TARDISInteriors;
import com.duzo.tardis.tardis.item.TARDISSpawnItem;

public class ClassicTARDISSpawnItem extends TARDISSpawnItem {
    public ClassicTARDISSpawnItem(Properties properties) {
        super(properties);
    }

    @Override
    protected TARDISExteriorSchema<?> getExterior() {
        return TARDISExteriors.get("classic");
    }

    @Override
    protected TARDISInterior getInterior() {
        return TARDISInteriors.get("coral");
    }
}
