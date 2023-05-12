package com.duzo.tardis.tardis.consoles.impl;

import com.duzo.tardis.tardis.consoles.ConsoleSchema;
import com.duzo.tardis.tardis.consoles.impl.models.BorealisConsoleModel;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.Vec3;

public class BorealisConsoleSchema extends ConsoleSchema<BorealisConsoleModel> {
    public BorealisConsoleSchema() {
        super("borealis_console", "console.tardis.borealis_console");
    }

    @Override
    protected BorealisConsoleModel model() {
        return new BorealisConsoleModel(Minecraft.getInstance().getEntityModels().bakeLayer(BorealisConsoleModel.LAYER_LOCATION));
    }

    @Override
    public Vec3 positionFor(String controlName, BlockPos pos, Direction direction) {
        float multipleOfX = 1;
        float multipleOfZ = 1;
        float addSubX = 0;
        float addSubZ = 0;
        int getX = pos.getX();
        int getZ = pos.getZ();

        if(direction.equals(Direction.NORTH)) {
            multipleOfX = multipleOfX * 1f;
            multipleOfZ = multipleOfZ * 1f;
            addSubX = 0;
            addSubZ = 0;
        }
        if(direction.equals(Direction.EAST)) {
            multipleOfX = multipleOfX * -1f;
            multipleOfZ = multipleOfZ * 1f;
            addSubX = 1f;
            addSubZ = 0f;
        }
        if(direction.equals(Direction.SOUTH)) {
            multipleOfX = multipleOfX * -1f;
            multipleOfZ = multipleOfZ * -1f;
            addSubX = 1f;
            addSubZ = 1f;
        }
        if(direction.equals(Direction.WEST)) {
            multipleOfX = multipleOfX * 1f;
            multipleOfZ = multipleOfZ * -1f;
            addSubX = 0f;
            addSubZ = 1f;
        }


        if (controlName.equals("Throttle")) {
            return new Vec3(getX + (1.3 * multipleOfX) + addSubX, pos.getY() + 1.05, getZ + (0.7225 * multipleOfZ) + addSubZ);
        } else if (controlName.equals("Handbrake")) {
            return new Vec3(getX + (1.08 * multipleOfX) + addSubX, pos.getY() + 1.05, getZ + (1.08 * multipleOfZ) + addSubZ);
        }
        return null;
    }
}
