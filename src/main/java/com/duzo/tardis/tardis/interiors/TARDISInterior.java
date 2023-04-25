package com.duzo.tardis.tardis.interiors;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.core.world.dimension.DimensionsInit;
import com.duzo.tardis.tardis.structures.TARDISStructure;
import com.duzo.tardis.tardis.util.TARDISUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import java.util.Random;

public abstract class TARDISInterior extends TARDISStructure {
    protected BlockPos entrancePos;
    protected String id;
    protected StructureTemplate template;
    public TARDISInterior(String structureName) {
        this(structureName, new BlockPos(0,0,0));
    }
    public TARDISInterior(String structureName, BlockPos blockpos) {
        this(new ResourceLocation(TARDISMod.MODID,"interiors/" + structureName), structureName,blockpos);
    }
    public TARDISInterior(ResourceLocation location, String id, BlockPos pos) {
        super(id);
        this.location = location;
        this.entrancePos = pos;
        this.id = id;
    }
    public TARDISInterior(ResourceLocation location, String structurename) {
        this(location,structurename,new BlockPos(0,0,0));
    }
    @Deprecated
    public void place(ServerLevel level, BlockPos pos) {
        this.template.placeInWorld(level,pos,pos,new StructurePlaceSettings(), RandomSource.create(),2);
    }

    @Deprecated
    /**
     * This is to be ran when the TARDIS level loads so that the TARDIS level isnt returned as null
     */
    public void generateTemplate() {
        this.template = TARDISUtil.getTARDISLevel().getStructureManager().getOrCreate(location);
    }

    public BlockPos getEntrancePos() {
        return this.entrancePos;
    }
    public String getID() {return this.id;}
}
