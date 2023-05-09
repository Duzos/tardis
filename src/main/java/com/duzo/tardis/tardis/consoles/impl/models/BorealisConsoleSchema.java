package com.duzo.tardis.tardis.consoles.impl.models;

import com.duzo.tardis.tardis.consoles.ConsoleSchema;
import com.duzo.tardis.tardis.exteriors.TARDISExteriorSchema;
import com.duzo.tardis.tardis.exteriors.impl.models.BasicBoxExteriorModel;
import net.minecraft.client.Minecraft;

public class BorealisConsoleSchema extends ConsoleSchema<BorealisConsoleModel> {
    public BorealisConsoleSchema() {
        super("borealis_console", "console.tardis.borealis_console");
    }

    @Override
    protected BorealisConsoleModel model() {
        return new BorealisConsoleModel(Minecraft.getInstance().getEntityModels().bakeLayer(BorealisConsoleModel.LAYER_LOCATION));
    }
}
