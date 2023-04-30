package com.duzo.tardis.tardis.exteriors.impl;

import com.duzo.tardis.tardis.exteriors.impl.models.CoralTARDISExteriorModel;
import com.duzo.tardis.tardis.exteriors.TARDISExteriorSchema;
import net.minecraft.client.Minecraft;

public class CoralExteriorSchema extends TARDISExteriorSchema<CoralTARDISExteriorModel> {
    public CoralExteriorSchema() {
        super("coral", "exterior.tardis.coral");
    }

    @Override
    protected CoralTARDISExteriorModel model() {
        return new CoralTARDISExteriorModel(Minecraft.getInstance().getEntityModels().bakeLayer(CoralTARDISExteriorModel.LAYER_LOCATION));
    }
}
