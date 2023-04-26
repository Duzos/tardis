package com.duzo.tardis.tardis.item.impl;

import com.duzo.tardis.tardis.exteriors.TARDISExteriorSchema;
import com.duzo.tardis.tardis.exteriors.TARDISExteriors;
import com.duzo.tardis.tardis.item.TARDISSpawnItem;

public class ThirdTARDISSpawnItem extends TARDISSpawnItem {
    public ThirdTARDISSpawnItem(Properties properties) {
        super(properties);
    }

    @Override
    protected TARDISExteriorSchema<?> getExterior() {
        return TARDISExteriors.get("third");
    }
}
