package com.duzo.tardis.tardis.exteriors.impl;

import com.duzo.tardis.tardis.exteriors.TARDISExteriorSchema;
import com.duzo.tardis.tardis.exteriors.impl.models.OriginalTARDISExteriorModel;
import net.minecraft.client.Minecraft;

public class OriginalExteriorSchema extends TARDISExteriorSchema<OriginalTARDISExteriorModel> {
    public OriginalExteriorSchema() {
        super("original","exterior.tardis.original");
    }

    @Override
    protected OriginalTARDISExteriorModel model() {
        return new OriginalTARDISExteriorModel(Minecraft.getInstance().getEntityModels().bakeLayer(OriginalTARDISExteriorModel.LAYER_LOCATION));
    }
}
