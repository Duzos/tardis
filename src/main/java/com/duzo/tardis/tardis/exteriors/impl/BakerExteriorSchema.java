package com.duzo.tardis.tardis.exteriors.impl;

import com.duzo.tardis.tardis.exteriors.TARDISExteriorSchema;
import com.duzo.tardis.tardis.exteriors.impl.models.BakerTARDISExteriorModel;
import net.minecraft.client.Minecraft;

public class BakerExteriorSchema extends TARDISExteriorSchema<BakerTARDISExteriorModel> {
    public BakerExteriorSchema() {
        super("baker", "exterior.tardis.baker");
    }

    @Override
    protected BakerTARDISExteriorModel model() {
        return new BakerTARDISExteriorModel(Minecraft.getInstance().getEntityModels().bakeLayer(BakerTARDISExteriorModel.LAYER_LOCATION));
    }
}
