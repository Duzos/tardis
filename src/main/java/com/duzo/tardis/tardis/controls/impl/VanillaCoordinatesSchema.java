package com.duzo.tardis.tardis.controls.impl;

import com.duzo.tardis.tardis.controls.CoordinateControlSchema;
import com.duzo.tardis.tardis.controls.impl.models.VanillaCoordinatesModelSchema;
import com.duzo.tardis.tardis.controls.impl.models.VanillaDematLeverModelSchema;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;

import java.util.ArrayList;
import java.util.List;

public class VanillaCoordinatesSchema extends CoordinateControlSchema<VanillaCoordinatesModelSchema> {
    public VanillaCoordinatesSchema() {
        super("vanilla_coordinates", "controls.tardis.vanilla_coordinates");
    }

    @Override
    public List<Double> getXButtonPositions(Direction direction) {
        List<Double> positions = new ArrayList<>();

        switch (direction) {
            case NORTH:
                positions.add(-0.2d);
                positions.add(0d);
                positions.add(-0.3d);
                positions.add(0.3d);
                positions.add(0.1d);
        }

        return positions;
    }

    @Override
    public List<Double> getYButtonPositions(Direction direction) {
        List<Double> positions = new ArrayList<>();

        switch (direction) {
            case NORTH:
                positions.add(-1.5d);
                positions.add(0d);
                positions.add(-4d);
                positions.add(3d);
                positions.add(1d);
        }

        return positions;
    }

    @Override
    public List<Double> getZButtonPositions(Direction direction) {
        List<Double> positions = new ArrayList<>();

        switch (direction) {
            case NORTH:
                positions.add(3d);
                positions.add(0d);
                positions.add(-5.25);
                positions.add(3d);
                positions.add(1d);
        }

        return positions;
    }

    @Override
    protected VanillaCoordinatesModelSchema model() {
        return new VanillaCoordinatesModelSchema(Minecraft.getInstance().getEntityModels().bakeLayer(VanillaCoordinatesModelSchema.LAYER_LOCATION));
    }
}
