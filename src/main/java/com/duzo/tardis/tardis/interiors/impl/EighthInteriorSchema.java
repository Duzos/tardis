package com.duzo.tardis.tardis.interiors.impl;

import com.duzo.tardis.tardis.interiors.TARDISInteriorSchema;
import com.duzo.tardis.tardis.structures.TARDISStructure;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;

public class EighthInteriorSchema extends TARDISInteriorSchema {
    public EighthInteriorSchema(String structureName) {
        super(structureName);
    }
    public EighthInteriorSchema(ResourceLocation location, String structurename) {
        super(location, structurename);
    }
    public EighthInteriorSchema() {
        this("eighth");
    }

    private static final Codec<TARDISStructure> CODEC = RecordCodecBuilder.create(instance -> {
        return instance.group(
                ResourceLocation.CODEC.fieldOf("structure").forGetter(TARDISStructure::getLocation),
                Codec.STRING.orElse("Placeholder").fieldOf("name_component").forGetter(TARDISStructure::getStructureName)
        ).apply(instance, EighthInteriorSchema::new);
    });
}
