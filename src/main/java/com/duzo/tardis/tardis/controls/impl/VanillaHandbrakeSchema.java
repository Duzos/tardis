package com.duzo.tardis.tardis.controls.impl;

import com.duzo.tardis.tardis.controls.TARDISControlSchema;
import com.duzo.tardis.tardis.controls.impl.models.VanillaHandbrakeModelSchema;
import net.minecraft.client.Minecraft;

public class VanillaHandbrakeSchema extends TARDISControlSchema<VanillaHandbrakeModelSchema> {

    public VanillaHandbrakeSchema() {
        super("vanilla_handbrake", "controls.tardis.vanilla_handbrake");
    }

    @Override
    protected VanillaHandbrakeModelSchema model() {
        return new VanillaHandbrakeModelSchema(Minecraft.getInstance().getEntityModels().bakeLayer(VanillaHandbrakeModelSchema.LAYER_LOCATION));
    }
}
