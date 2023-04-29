package com.duzo.tardis.tardis.controls.impl;

import com.duzo.tardis.tardis.controls.TARDISControlModelSchema;
import com.duzo.tardis.tardis.controls.TARDISControlSchema;
import com.duzo.tardis.tardis.controls.impl.models.CoralDematLeverModelSchema;
import com.duzo.tardis.tardis.controls.impl.models.CoralRotorModelSchema;
import net.minecraft.client.Minecraft;

public class CoralRotorSchema extends TARDISControlSchema<CoralRotorModelSchema> {
    public CoralRotorSchema() {
        super("coral_rotor", "controls.tardis.coral_rotor");
    }

    @Override
    protected CoralRotorModelSchema model() {
        return new CoralRotorModelSchema(Minecraft.getInstance().getEntityModels().bakeLayer(CoralRotorModelSchema.LAYER_LOCATION));
    }
}
