package com.duzo.tardis.tardis.structures.interiors;

import com.duzo.tardis.tardis.structures.TARDISStructure;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;

public class CoralInterior extends TARDISInterior {
    public CoralInterior(ResourceLocation resourceLocation, String structureName) {
        super(resourceLocation,structureName);
        this.entrancePos = new BlockPos(17,1,30);
    }
    public CoralInterior(String structureName) {
        super(structureName);
        this.entrancePos = new BlockPos(17,1,30);
    }
    public CoralInterior() {
        this("coral_interior");
    }
    private static final Codec<TARDISStructure> CODEC = RecordCodecBuilder.create(instance -> {
        return instance.group(
                ResourceLocation.CODEC.fieldOf("structure").forGetter(TARDISStructure::getLocation),
                Codec.STRING.orElse("Placeholder").fieldOf("name_component").forGetter(TARDISStructure::getStructureName)
        ).apply(instance, CoralInterior::new);
    });
}
