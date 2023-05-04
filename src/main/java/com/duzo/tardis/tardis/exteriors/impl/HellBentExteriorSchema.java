package com.duzo.tardis.tardis.exteriors.impl;

import com.duzo.tardis.tardis.exteriors.TARDISExteriorSchema;
import com.duzo.tardis.tardis.exteriors.impl.models.CoralTARDISExteriorModel;
import com.duzo.tardis.tardis.exteriors.impl.models.HellBentTARDISExteriorModel;
import net.minecraft.client.Minecraft;

public class HellBentExteriorSchema extends TARDISExteriorSchema<HellBentTARDISExteriorModel> {
    public HellBentExteriorSchema() {
        super("hellbent", "exterior.tardis.hellbent");
    }

    @Override
    protected HellBentTARDISExteriorModel model() {
        return new HellBentTARDISExteriorModel(Minecraft.getInstance().getEntityModels().bakeLayer(HellBentTARDISExteriorModel.LAYER_LOCATION));
    }
}
