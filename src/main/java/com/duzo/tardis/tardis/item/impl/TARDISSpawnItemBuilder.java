package com.duzo.tardis.tardis.item.impl;

import com.duzo.tardis.tardis.builder.TARDISBuilder;
import com.duzo.tardis.tardis.exteriors.TARDISExteriorSchema;
import com.duzo.tardis.tardis.exteriors.TARDISExteriors;
import com.duzo.tardis.tardis.interiors.TARDISInteriorSchema;
import com.duzo.tardis.tardis.interiors.TARDISInteriors;
import com.duzo.tardis.tardis.item.TARDISSpawnItem;

public class TARDISSpawnItemBuilder extends TARDISSpawnItem {
    private String interior;
    private String exterior;

    public TARDISSpawnItemBuilder(Properties properties, String exterior, String interior) {
        super(properties);
        this.interior = interior;
        this.exterior = exterior;
    }
    public TARDISSpawnItemBuilder(Properties properties) {
        super(properties);
        this.interior = TARDISBuilder.DEFAULT_INTERIOR;
        this.exterior = TARDISBuilder.DEFAULT_EXTERIOR;
    }

    public TARDISSpawnItemBuilder interior(String interior) {
        this.interior = interior;
        return this;
    }
    public TARDISSpawnItemBuilder exterior(String exterior) {
        this.exterior = exterior;
        return this;
    }

    @Override
    protected TARDISExteriorSchema<?> getExterior() {
        return TARDISExteriors.get(this.exterior);
    }

    @Override
    protected TARDISInteriorSchema getInterior() {
        return TARDISInteriors.get(this.interior);
    }
}
