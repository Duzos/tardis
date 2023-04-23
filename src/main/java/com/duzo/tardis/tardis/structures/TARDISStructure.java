package com.duzo.tardis.tardis.structures;

import com.duzo.tardis.TARDISMod;
import net.minecraft.resources.ResourceLocation;

public abstract class TARDISStructure {
    private final String structureName;
    protected ResourceLocation location;
    public TARDISStructure(String structureName) {
        this(new ResourceLocation(TARDISMod.MODID,structureName),structureName);
    }
    public TARDISStructure(ResourceLocation location, String structureName) {
        this.location = location;
        this.structureName = structureName;
    }

    public String getStructureName() {
        return this.structureName;
    }
    public ResourceLocation getLocation() {return this.location;}
}
