package com.duzo.tardis.tardis.exteriors.impl;

import com.duzo.tardis.tardis.exteriors.TARDISExteriorSchema;
import com.duzo.tardis.tardis.exteriors.impl.models.CopperTARDISExteriorModel;
import com.duzo.tardis.tardis.exteriors.impl.models.CoralTARDISExteriorModel;
import net.minecraft.client.Minecraft;

public class CopperExteriorSchema extends TARDISExteriorSchema<CopperTARDISExteriorModel> {
    public CopperExteriorSchema() {
        super("copper", "exterior.tardis.copper");
    }

    @Override
    protected CopperTARDISExteriorModel model() {
        return new CopperTARDISExteriorModel(Minecraft.getInstance().getEntityModels().bakeLayer(CopperTARDISExteriorModel.LAYER_LOCATION));
    }
}
