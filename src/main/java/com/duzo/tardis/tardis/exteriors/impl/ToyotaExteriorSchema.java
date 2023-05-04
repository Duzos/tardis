package com.duzo.tardis.tardis.exteriors.impl;

import com.duzo.tardis.tardis.exteriors.TARDISExteriorSchema;
import com.duzo.tardis.tardis.exteriors.impl.models.CopperTARDISExteriorModel;
import net.minecraft.client.Minecraft;

public class ToyotaExteriorSchema extends TARDISExteriorSchema<CopperTARDISExteriorModel> {
    public ToyotaExteriorSchema() {
        super("toyota", "exterior.tardis.toyota");
    }

    @Override
    protected CopperTARDISExteriorModel model() {
        return new CopperTARDISExteriorModel(Minecraft.getInstance().getEntityModels().bakeLayer(CopperTARDISExteriorModel.LAYER_LOCATION));
    }
}
