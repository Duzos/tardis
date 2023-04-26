package com.duzo.tardis.tardis.exteriors.impl;

import com.duzo.tardis.tardis.exteriors.TARDISExteriorSchema;
import com.duzo.tardis.tardis.exteriors.impl.models.OriginalTARDISExteriorModel;
import com.duzo.tardis.tardis.exteriors.impl.models.ThirdTARDISExteriorModel;
import net.minecraft.client.Minecraft;

public class ThirdExteriorSchema extends TARDISExteriorSchema<ThirdTARDISExteriorModel> {
    public ThirdExteriorSchema() {
        super("third","exterior.tardis.third");
    }

    @Override
    protected ThirdTARDISExteriorModel model() {
        return new ThirdTARDISExteriorModel(Minecraft.getInstance().getEntityModels().bakeLayer(ThirdTARDISExteriorModel.LAYER_LOCATION));
    }
}
