package com.duzo.tardis.tardis.controls.impl;

import com.duzo.tardis.tardis.controls.TARDISControlModelSchema;
import com.duzo.tardis.tardis.controls.TARDISControlSchema;
import com.duzo.tardis.tardis.controls.impl.models.CoralDematLeverModelSchema;
import com.duzo.tardis.tardis.controls.impl.models.VanillaDematLeverModelSchema;
import net.minecraft.client.Minecraft;

public class VanillaDematLeverSchema extends TARDISControlSchema {

    public VanillaDematLeverSchema() {
        super("vanilla_demat", "controls.tardis.vanilla_demat");
    }

    @Override
    protected TARDISControlModelSchema model() {
        return new VanillaDematLeverModelSchema(Minecraft.getInstance().getEntityModels().bakeLayer(VanillaDematLeverModelSchema.LAYER_LOCATION));
    }
}
