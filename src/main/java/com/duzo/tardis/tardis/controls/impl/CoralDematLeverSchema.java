package com.duzo.tardis.tardis.controls.impl;

import com.duzo.tardis.tardis.controls.TARDISControlModelSchema;
import com.duzo.tardis.tardis.controls.TARDISControlSchema;
import com.duzo.tardis.tardis.controls.TARDISControls;
import com.duzo.tardis.tardis.controls.impl.models.CoralDematLeverModelSchema;
import com.duzo.tardis.tardis.doors.impl.models.ClassicInteriorDoorModel;
import net.minecraft.client.Minecraft;

public class CoralDematLeverSchema extends TARDISControlSchema {
    public CoralDematLeverSchema() {
        super("coral_demat", "controls.tardis.coral_demat");
    }

    @Override
    protected TARDISControlModelSchema model() {
        return new CoralDematLeverModelSchema(Minecraft.getInstance().getEntityModels().bakeLayer(CoralDematLeverModelSchema.LAYER_LOCATION));
    }
}
