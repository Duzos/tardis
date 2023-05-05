package com.duzo.tardis.tardis.exteriors.impl;

import com.duzo.tardis.tardis.exteriors.TARDISExteriorSchema;
import com.duzo.tardis.tardis.exteriors.impl.models.HartnellTARDISExteriorModel;
import com.duzo.tardis.tardis.exteriors.impl.models.HartnellTTTARDISExteriorModel;
import net.minecraft.client.Minecraft;

public class HartnellExteriorSchema extends TARDISExteriorSchema<HartnellTARDISExteriorModel> {
    public HartnellExteriorSchema() {
        super("hartnell", "exterior.tardis.hartnell");
    }

    @Override
    protected HartnellTARDISExteriorModel model() {
        return new HartnellTARDISExteriorModel(Minecraft.getInstance().getEntityModels().bakeLayer(HartnellTARDISExteriorModel.LAYER_LOCATION));
    }
}
