package com.duzo.tardis.tardis.controls.impl;

import com.duzo.tardis.tardis.controls.TARDISControlSchema;
import com.duzo.tardis.tardis.controls.impl.models.VanillaDematLeverModelSchema;
import net.minecraft.client.Minecraft;

public class VanillaDematLeverSchema extends TARDISControlSchema<VanillaDematLeverModelSchema> {

    public VanillaDematLeverSchema() {
        super("vanilla_demat", "controls.tardis.vanilla_demat");
    }

    @Override
    protected VanillaDematLeverModelSchema model() {
        return new VanillaDematLeverModelSchema(Minecraft.getInstance().getEntityModels().bakeLayer(VanillaDematLeverModelSchema.LAYER_LOCATION));
    }
}
