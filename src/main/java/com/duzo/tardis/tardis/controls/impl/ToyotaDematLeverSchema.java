package com.duzo.tardis.tardis.controls.impl;

import com.duzo.tardis.tardis.controls.TARDISControlSchema;
import com.duzo.tardis.tardis.controls.impl.models.CopperDematLeverModelSchema;
import com.duzo.tardis.tardis.controls.impl.models.ToyotaDematLeverModelSchema;
import net.minecraft.client.Minecraft;

public class ToyotaDematLeverSchema extends TARDISControlSchema<ToyotaDematLeverModelSchema> {
    public ToyotaDematLeverSchema() {
        super("toyota_demat", "controls.tardis.toyota_demat");
    }

    @Override
    protected ToyotaDematLeverModelSchema model() {
        return new ToyotaDematLeverModelSchema(Minecraft.getInstance().getEntityModels().bakeLayer(ToyotaDematLeverModelSchema.LAYER_LOCATION));
    }
}

