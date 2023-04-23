package com.duzo.tardis.tardis.structures.interiors;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.tardis.structures.TARDISStructure;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;

public abstract class TARDISInterior extends TARDISStructure {
    protected BlockPos entrancePos;
    public TARDISInterior(String structureName) {
        this(structureName, new BlockPos(0,0,0));
    }
    public TARDISInterior(String structureName, BlockPos blockpos) {
        super(structureName);
        this.location = new ResourceLocation(TARDISMod.MODID,"interiors/" + structureName);
        this.entrancePos = blockpos;
    }
    public TARDISInterior(ResourceLocation location, String structurename) {
        super(location,structurename);
        this.entrancePos = new BlockPos(0,0,0);
    }

    public BlockPos getEntrancePos() {
        return this.entrancePos;
    }
}
