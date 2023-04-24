package com.duzo.tardis.tardis.exteriors.impl;

import com.duzo.tardis.tardis.exteriors.impl.models.ClassicTARDISExteriorModel;
import com.duzo.tardis.tardis.exteriors.TARDISExteriorSchema;
import net.minecraft.client.Minecraft;

public class ClassicExteriorSchema extends TARDISExteriorSchema<ClassicTARDISExteriorModel> {
    public ClassicExteriorSchema() {
        super("classic", "exterior.tardis.classic");
    }

    @Override
    protected ClassicTARDISExteriorModel model() {
        return new ClassicTARDISExteriorModel(Minecraft.getInstance().getEntityModels().bakeLayer(ClassicTARDISExteriorModel.LAYER_LOCATION));
    }
}
