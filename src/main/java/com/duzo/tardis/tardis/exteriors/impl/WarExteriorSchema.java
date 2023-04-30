package com.duzo.tardis.tardis.exteriors.impl;

import com.duzo.tardis.tardis.exteriors.TARDISExteriorSchema;
import com.duzo.tardis.tardis.exteriors.impl.models.ThirdTARDISExteriorModel;
import com.duzo.tardis.tardis.exteriors.impl.models.WarTARDISExteriorModel;
import net.minecraft.client.Minecraft;

public class WarExteriorSchema extends TARDISExteriorSchema<WarTARDISExteriorModel> {
    public WarExteriorSchema() {
        super("war","exterior.tardis.war");
    }

    @Override
    protected WarTARDISExteriorModel model() {
        return new WarTARDISExteriorModel(Minecraft.getInstance().getEntityModels().bakeLayer(WarTARDISExteriorModel.LAYER_LOCATION));
    }
}
