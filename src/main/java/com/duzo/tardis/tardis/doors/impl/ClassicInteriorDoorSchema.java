package com.duzo.tardis.tardis.doors.impl;

import com.duzo.tardis.tardis.doors.TARDISInteriorDoorModelSchema;
import com.duzo.tardis.tardis.doors.TARDISInteriorDoorSchema;
import com.duzo.tardis.tardis.doors.impl.models.ClassicInteriorDoorModel;
import net.minecraft.client.Minecraft;

public class ClassicInteriorDoorSchema extends TARDISInteriorDoorSchema {
    public ClassicInteriorDoorSchema() {
        super("classic", "door.tardis.classic");
    }

    @Override
    protected TARDISInteriorDoorModelSchema model() {
        return new ClassicInteriorDoorModel(Minecraft.getInstance().getEntityModels().bakeLayer(ClassicInteriorDoorModel.LAYER_LOCATION));
    }
}
