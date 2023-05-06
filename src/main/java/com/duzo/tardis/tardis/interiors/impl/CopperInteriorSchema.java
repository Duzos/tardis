package com.duzo.tardis.tardis.interiors.impl;

import com.duzo.tardis.tardis.interiors.TARDISInteriorSchema;
import com.duzo.tardis.tardis.structures.TARDISStructure;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;

public class CopperInteriorSchema extends TARDISInteriorSchema {
    public CopperInteriorSchema(ResourceLocation location, String id) {
        super(location,id);
    }
    public CopperInteriorSchema(String id) {
        super(id);
    }
    public CopperInteriorSchema() {
        this("copper");
    }
    private static final Codec<TARDISStructure> CODEC = RecordCodecBuilder.create(instance -> {
        return instance.group(
                ResourceLocation.CODEC.fieldOf("structure").forGetter(TARDISStructure::getLocation),
                Codec.STRING.orElse("Placeholder").fieldOf("name_component").forGetter(TARDISStructure::getStructureName)
        ).apply(instance, CopperInteriorSchema::new);
    });
}
