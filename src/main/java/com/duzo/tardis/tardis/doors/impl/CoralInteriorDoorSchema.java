package com.duzo.tardis.tardis.doors.impl;

import com.duzo.tardis.tardis.doors.TARDISInteriorDoorModelSchema;
import com.duzo.tardis.tardis.doors.TARDISInteriorDoorSchema;
import com.duzo.tardis.tardis.doors.impl.models.CoralInteriorDoorModel;
import net.minecraft.client.Minecraft;

public class CoralInteriorDoorSchema extends TARDISInteriorDoorSchema {
    public CoralInteriorDoorSchema() {
        super("coral", "door.tardis.coral");
    }

    @Override
    protected TARDISInteriorDoorModelSchema model() {
        return new CoralInteriorDoorModel(Minecraft.getInstance().getEntityModels().bakeLayer(CoralInteriorDoorModel.LAYER_LOCATION));
    }
}
