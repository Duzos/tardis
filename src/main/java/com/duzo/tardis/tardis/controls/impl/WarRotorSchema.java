package com.duzo.tardis.tardis.controls.impl;

import com.duzo.tardis.tardis.controls.TARDISControlSchema;
import com.duzo.tardis.tardis.controls.impl.models.CoralRotorModelSchema;
import com.duzo.tardis.tardis.controls.impl.models.WarRotorModelSchema;
import net.minecraft.client.Minecraft;

public class WarRotorSchema extends TARDISControlSchema<WarRotorModelSchema> {
    public WarRotorSchema() {
        super("war_rotor", "controls.tardis.war_rotor");
    }

    @Override
    protected WarRotorModelSchema model() {
        return new WarRotorModelSchema(Minecraft.getInstance().getEntityModels().bakeLayer(WarRotorModelSchema.LAYER_LOCATION));
    }
}
