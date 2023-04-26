package com.duzo.tardis.tardis.interiors.impl;

import com.duzo.tardis.tardis.interiors.TARDISInterior;
import com.duzo.tardis.tardis.structures.TARDISStructure;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;

public class BakerInterior extends TARDISInterior {
    public BakerInterior(ResourceLocation location, String id) {
        super(location,id);
    }
    public BakerInterior(String id) {
        super(id);
    }
    public BakerInterior() {
        this("baker");
    }
    private static final Codec<TARDISStructure> CODEC = RecordCodecBuilder.create(instance -> {
        return instance.group(
                ResourceLocation.CODEC.fieldOf("structure").forGetter(TARDISStructure::getLocation),
                Codec.STRING.orElse("Placeholder").fieldOf("name_component").forGetter(TARDISStructure::getStructureName)
        ).apply(instance, CoralInterior::new);
    });
}
