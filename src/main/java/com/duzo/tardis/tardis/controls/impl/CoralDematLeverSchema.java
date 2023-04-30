package com.duzo.tardis.tardis.controls.impl;

import com.duzo.tardis.tardis.controls.TARDISControlSchema;
import com.duzo.tardis.tardis.controls.impl.models.CoralDematLeverModelSchema;
import net.minecraft.client.Minecraft;

public class CoralDematLeverSchema extends TARDISControlSchema<CoralDematLeverModelSchema> {
    public CoralDematLeverSchema() {
        super("coral_demat", "controls.tardis.coral_demat");
    }

    @Override
    protected CoralDematLeverModelSchema model() {
        return new CoralDematLeverModelSchema(Minecraft.getInstance().getEntityModels().bakeLayer(CoralDematLeverModelSchema.LAYER_LOCATION));
    }
}
