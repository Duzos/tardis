package com.duzo.tardis.tardis.exteriors.impl;

import com.duzo.tardis.tardis.exteriors.TARDISExteriorSchema;
import com.duzo.tardis.tardis.exteriors.impl.models.ThirdTARDISExteriorModel;
import net.minecraft.client.Minecraft;

public class SecondExteriorSchema extends TARDISExteriorSchema<ThirdTARDISExteriorModel> {
    public SecondExteriorSchema() {
        super("second","exterior.tardis.second");
    }

    @Override
    protected ThirdTARDISExteriorModel model() {
        return new ThirdTARDISExteriorModel(Minecraft.getInstance().getEntityModels().bakeLayer(ThirdTARDISExteriorModel.LAYER_LOCATION));
    }
}
