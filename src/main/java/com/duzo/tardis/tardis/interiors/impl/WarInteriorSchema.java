package com.duzo.tardis.tardis.interiors.impl;

import com.duzo.tardis.tardis.interiors.TARDISInteriorSchema;
import com.duzo.tardis.tardis.structures.TARDISStructure;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;

public class WarInteriorSchema extends TARDISInteriorSchema {
    public WarInteriorSchema(String structureName) {
        super(structureName);
    }
    public WarInteriorSchema(ResourceLocation location, String structurename) {
        super(location, structurename);
    }
    public WarInteriorSchema() {
        this("war");
    }

    private static final Codec<TARDISStructure> CODEC = RecordCodecBuilder.create(instance -> {
        return instance.group(
                ResourceLocation.CODEC.fieldOf("structure").forGetter(TARDISStructure::getLocation),
                Codec.STRING.orElse("Placeholder").fieldOf("name_component").forGetter(TARDISStructure::getStructureName)
        ).apply(instance, WarInteriorSchema::new);
    });
}