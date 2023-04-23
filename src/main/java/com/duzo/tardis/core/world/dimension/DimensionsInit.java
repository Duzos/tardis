package com.duzo.tardis.core.world.dimension;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.tardis.TARDIS;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class DimensionsInit {
    public static final ResourceKey<Level> TARDIS_DIM_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(TARDISMod.MODID, "tardis_dim"));
    public static final ResourceKey<DimensionType> TARDIS_DIM_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, TARDIS_DIM_KEY.registry());

    public static void register() {

    }
}
