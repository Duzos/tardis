package com.duzo.tardis.tardis.exteriors.impl;

import com.duzo.tardis.tardis.exteriors.TARDISExteriorSchema;
import com.duzo.tardis.tardis.exteriors.impl.models.BasicBoxExteriorModel;
import net.minecraft.client.Minecraft;

public class BasicBoxExteriorSchema extends TARDISExteriorSchema<BasicBoxExteriorModel> {
    public BasicBoxExteriorSchema() {
        super("basic_box", "exterior.tardis.basic_box");
    }

    @Override
    protected BasicBoxExteriorModel model() {
        return new BasicBoxExteriorModel(Minecraft.getInstance().getEntityModels().bakeLayer(BasicBoxExteriorModel.LAYER_LOCATION));
    }
}
