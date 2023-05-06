package com.duzo.tardis.tardis.controls.impl;

import com.duzo.tardis.tardis.controls.TARDISControlSchema;
import com.duzo.tardis.tardis.controls.impl.models.CopperDematLeverModelSchema;
import com.duzo.tardis.tardis.controls.impl.models.CoralDematLeverModelSchema;
import net.minecraft.client.Minecraft;

public class CopperDematLeverSchema extends TARDISControlSchema<CopperDematLeverModelSchema> {
    public CopperDematLeverSchema() {
        super("copper_demat", "controls.tardis.copper_demat");
    }

    @Override
    protected CopperDematLeverModelSchema model() {
        return new CopperDematLeverModelSchema(Minecraft.getInstance().getEntityModels().bakeLayer(CopperDematLeverModelSchema.LAYER_LOCATION));
    }
}

