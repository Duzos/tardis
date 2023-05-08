package com.duzo.tardis.tardis.doors.impl;

import com.duzo.tardis.tardis.doors.TARDISInteriorDoorModelSchema;
import com.duzo.tardis.tardis.doors.TARDISInteriorDoorSchema;
import com.duzo.tardis.tardis.doors.impl.models.BasicBoxDoorModelSchema;
import net.minecraft.client.Minecraft;

public class BasicBoxDoorSchema extends TARDISInteriorDoorSchema {
    public BasicBoxDoorSchema() {
        super("basic_box", "door.ait.basic_box");
    }

    @Override
    protected TARDISInteriorDoorModelSchema model() {
        return new BasicBoxDoorModelSchema(Minecraft.getInstance().getEntityModels().bakeLayer(BasicBoxDoorModelSchema.LAYER_LOCATION));
    }
}