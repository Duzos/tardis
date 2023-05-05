package com.duzo.tardis.tardis.exteriors.impl;

import com.duzo.tardis.tardis.exteriors.TARDISExteriorSchema;
import com.duzo.tardis.tardis.exteriors.impl.models.HartnellTTTARDISExteriorModel;
import com.duzo.tardis.tardis.exteriors.impl.models.HellBentTARDISExteriorModel;
import net.minecraft.client.Minecraft;

public class HartnellTTExteriorSchema extends TARDISExteriorSchema<HartnellTTTARDISExteriorModel> {
    public HartnellTTExteriorSchema() {
        super("hartnell_tt", "exterior.tardis.hartnell_tt");
    }

    @Override
    protected HartnellTTTARDISExteriorModel model() {
        return new HartnellTTTARDISExteriorModel(Minecraft.getInstance().getEntityModels().bakeLayer(HartnellTTTARDISExteriorModel.LAYER_LOCATION));
    }
}
