package com.duzo.tardis.tardis.controls.impl;

import com.duzo.tardis.tardis.controls.TARDISControlSchema;
import com.duzo.tardis.tardis.controls.impl.models.CoralRotorModelSchema;
import com.duzo.tardis.tardis.controls.impl.models.EighthRotorModelSchema;
import net.minecraft.client.Minecraft;

public class EighthRotorSchema extends TARDISControlSchema<EighthRotorModelSchema> {
    public EighthRotorSchema() {
        super("eighth_rotor", "controls.tardis.eighth_rotor");
    }

    @Override
    protected EighthRotorModelSchema model() {
        return new EighthRotorModelSchema(Minecraft.getInstance().getEntityModels().bakeLayer(EighthRotorModelSchema.LAYER_LOCATION));
    }
}
