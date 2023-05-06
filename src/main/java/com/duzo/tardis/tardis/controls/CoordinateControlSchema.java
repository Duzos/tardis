package com.duzo.tardis.tardis.controls;

import com.duzo.tardis.tardis.controls.TARDISControlSchema;
import net.minecraft.core.Direction;

import java.util.ArrayList;
import java.util.List;

public abstract class CoordinateControlSchema<T extends TARDISControlModelSchema> extends TARDISControlSchema<T> {
    public CoordinateControlSchema(String id, String translation) {
        super(id, translation);
    }

    /**
     *
     * @param direction Direction to get values for
     * @return A list with doubles (in this order) represent: X,Y,Z,Width,Height
     */
    public abstract List<Double> getXButtonPositions(Direction direction);
    /**
     *
     * @param direction Direction to get values for
     * @return A list with doubles (in this order) represent: X,Y,Z,Width,Height
     */
    public abstract List<Double> getYButtonPositions(Direction direction);
    /**
     *
     * @param direction Direction to get values for
     * @return A list with doubles (in this order) represent: X,Y,Z,Width,Height
     */
    public abstract List<Double> getZButtonPositions(Direction direction);
}
