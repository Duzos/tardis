package com.duzo.tardis.tardis.consoles.impl;

import com.duzo.tardis.tardis.consoles.ConsoleSchema;
import com.duzo.tardis.tardis.consoles.impl.models.BorealisConsoleModel;
import com.duzo.tardis.tardis.consoles.impl.models.HudolinConsoleModel;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.Vec3;

import java.util.HashMap;

public class HudolinConsoleSchema extends ConsoleSchema<HudolinConsoleModel> {
    private final HashMap<String, HashMap<Direction, Vec3>> positions = new HashMap<>();

    public HudolinConsoleSchema() {
        super("hudolin_console", "console.tardis.hudolin_console");
    }

    @Override
    protected HudolinConsoleModel model() {
        return new HudolinConsoleModel(Minecraft.getInstance().getEntityModels().bakeLayer(HudolinConsoleModel.LAYER_LOCATION));
    }

    private void generatePositions() {
        HashMap<Direction, Vec3> map = new HashMap<>();
        float multipleOfX = 1;
        float multipleOfZ = 1;
        float addSubX = 0;
        float addSubZ = 0;

        // North multiples @TODO These exist because it's the only good way to do it right now, I know a different way but that requires a few days of work - Loqor
        float multipleOfX_NORTH = multipleOfX * 1f;
        float multipleOfZ_NORTH = multipleOfZ * 1f;
        float addSubX_NORTH = 0;
        float addSubZ_NORTH = 0;

        // South multiples
        float multipleOfX_SOUTH = multipleOfX * -1f;
        float multipleOfZ_SOUTH = multipleOfZ * -1f;
        float addSubX_SOUTH = 1f;
        float addSubZ_SOUTH = 1f;

        // East multiples
        float multipleOfX_EAST = multipleOfX * 1f;
        float multipleOfZ_EAST = multipleOfZ * -1f;
        float addSubX_EAST = 0f;
        float addSubZ_EAST = 1f;

        // West multiples
             float multipleOfX_WEST = multipleOfX * -1f;
        float multipleOfZ_WEST = multipleOfZ * 1f;
        float addSubX_WEST = 1f;
        float addSubZ_WEST = 0f;

        // Throttle
        map.put(Direction.NORTH, new Vec3((1.3 * multipleOfX_NORTH) + addSubX_NORTH,1.05,0.7225 * multipleOfZ_NORTH + addSubZ_NORTH));
        map.put(Direction.SOUTH, new Vec3((1.3 * multipleOfX_SOUTH) + addSubX_SOUTH,1.05,0.7225 * multipleOfZ_SOUTH + addSubZ_SOUTH));
        map.put(Direction.WEST, new Vec3((0.7225 * multipleOfX_WEST) + addSubX_WEST,1.05,1.3 * multipleOfZ_WEST + addSubZ_WEST));
        map.put(Direction.EAST, new Vec3((0.7225 * multipleOfX_EAST) + addSubX_EAST,1.05,1.3 * multipleOfZ_EAST + addSubZ_EAST));
        this.positions.put("Throttle",map);

        // Handbrake
        map = new HashMap<>();
        map.put(Direction.NORTH, new Vec3((0.2335 * multipleOfX_NORTH) + addSubX_NORTH,0.95,-(0.375 * multipleOfZ_NORTH + addSubZ_NORTH)));
        map.put(Direction.SOUTH, new Vec3((0.5 * multipleOfX_SOUTH) + addSubX_SOUTH,1,-0.3 * multipleOfZ_SOUTH + addSubZ_SOUTH));
        map.put(Direction.WEST, new Vec3(-(0.3 * multipleOfX_WEST) + addSubX_WEST,1,0.5 * multipleOfZ_WEST + addSubZ_WEST));
        map.put(Direction.EAST, new Vec3(-(0.3 * multipleOfX_EAST) + addSubX_EAST,1,0.5 * multipleOfZ_EAST + addSubZ_EAST));
        this.positions.put("Handbrake",map);

        // X Coordinate
        map = new HashMap<>();
        map.put(Direction.NORTH, new Vec3((0.375 * multipleOfX_NORTH) + addSubX_NORTH,1.15,1.05 * multipleOfZ_NORTH + addSubZ_NORTH));
        map.put(Direction.SOUTH, new Vec3((0.375 * multipleOfX_SOUTH) + addSubX_SOUTH,1.15,1.05 * multipleOfZ_SOUTH + addSubZ_SOUTH));
        map.put(Direction.WEST, new Vec3((1.05 * multipleOfX_WEST) + addSubX_WEST,1.15,0.375 * multipleOfZ_WEST + addSubZ_WEST));
        map.put(Direction.EAST, new Vec3((1.05 * multipleOfX_EAST) + addSubX_EAST,1.15,0.375 * multipleOfZ_EAST + addSubZ_EAST));
        this.positions.put("X",map);

        // Y Coordinate
        map = new HashMap<>();
        map.put(Direction.NORTH, new Vec3((0.5 * multipleOfX_NORTH) + addSubX_NORTH,1.15,1.05 * multipleOfZ_NORTH + addSubZ_NORTH));
        map.put(Direction.SOUTH, new Vec3((0.5 * multipleOfX_SOUTH) + addSubX_SOUTH,1.15,1.05 * multipleOfZ_SOUTH + addSubZ_SOUTH));
        map.put(Direction.WEST, new Vec3((1.05 * multipleOfX_WEST) + addSubX_WEST,1.15,0.5 * multipleOfZ_WEST + addSubZ_WEST));
        map.put(Direction.EAST, new Vec3((1.05 * multipleOfX_EAST) + addSubX_EAST,1.15,0.5 * multipleOfZ_EAST + addSubZ_EAST));
        this.positions.put("Y",map);

        // Z Coordinate
        map = new HashMap<>();
        map.put(Direction.NORTH, new Vec3((0.625 * multipleOfX_NORTH) + addSubX_NORTH,1.15,1.05 * multipleOfZ_NORTH + addSubZ_NORTH));
        map.put(Direction.SOUTH, new Vec3((0.625 * multipleOfX_SOUTH) + addSubX_SOUTH,1.15,1.05 * multipleOfZ_SOUTH + addSubZ_SOUTH));
        map.put(Direction.WEST, new Vec3((1.05 * multipleOfX_WEST) + addSubX_WEST,1.15,0.625 * multipleOfZ_WEST + addSubZ_WEST));
        map.put(Direction.EAST, new Vec3((1.05 * multipleOfX_EAST) + addSubX_EAST,1.15,0.625 * multipleOfZ_EAST + addSubZ_EAST));
        this.positions.put("Z",map);

        // Increment
        map = new HashMap<>();
        map.put(Direction.NORTH, new Vec3((0.5 * multipleOfX_NORTH) + addSubX_NORTH,1.05,1.2 * multipleOfZ_NORTH + addSubZ_NORTH));
        map.put(Direction.SOUTH, new Vec3((0.5 * multipleOfX_SOUTH) + addSubX_SOUTH,1.05,1.2 * multipleOfZ_SOUTH + addSubZ_SOUTH));
        map.put(Direction.WEST, new Vec3((1.2 * multipleOfX_WEST) + addSubX_WEST,1.05,0.5 * multipleOfZ_WEST + addSubZ_WEST));
        map.put(Direction.EAST, new Vec3((1.2 * multipleOfX_EAST) + addSubX_EAST,1.05,0.5 * multipleOfZ_EAST + addSubZ_EAST));
        this.positions.put("Increment",map);

        // Door Control
        map = new HashMap<>();
        map.put(Direction.NORTH, new Vec3((1.08 * multipleOfX_NORTH) + addSubX_NORTH,1.05,1.08 * multipleOfZ_NORTH + addSubZ_NORTH));
        map.put(Direction.SOUTH, new Vec3((1.08 * multipleOfX_SOUTH) + addSubX_SOUTH,1.05,1.08 * multipleOfZ_SOUTH + addSubZ_SOUTH));
        map.put(Direction.WEST, new Vec3((1.08 * multipleOfX_WEST) + addSubX_WEST,1.05,1.08 * multipleOfZ_WEST + addSubZ_WEST));
        map.put(Direction.EAST, new Vec3((1.08 * multipleOfX_EAST) + addSubX_EAST,1.05,1.08 * multipleOfZ_EAST + addSubZ_EAST));
        this.positions.put("Door Control",map);

        // Monitor
        map = new HashMap<>();
        map.put(Direction.NORTH, new Vec3(-(0.15 * multipleOfX_NORTH) + addSubX_NORTH,1.05,(0.125 * multipleOfZ_NORTH + addSubZ_NORTH)));
        map.put(Direction.SOUTH, new Vec3(-(0.15 * multipleOfX_SOUTH) + addSubX_SOUTH,1.05,0.125 * multipleOfZ_SOUTH + addSubZ_SOUTH));
        map.put(Direction.WEST, new Vec3((0.125 * multipleOfX_WEST) + addSubX_WEST,1.05,-0.15 * multipleOfZ_WEST + addSubZ_WEST));
        map.put(Direction.EAST, new Vec3((0.125 * multipleOfX_EAST) + addSubX_EAST,1.05,-0.15 * multipleOfZ_EAST + addSubZ_EAST));
        this.positions.put("Monitor",map);

        // Randomizer
        map = new HashMap<>();
        map.put(Direction.NORTH, new Vec3((0.265 * multipleOfX_NORTH) + addSubX_NORTH,1,1.3 * multipleOfZ_NORTH + addSubZ_NORTH));
        map.put(Direction.SOUTH, new Vec3((0.265 * multipleOfX_SOUTH) + addSubX_SOUTH,1,1.3 * multipleOfZ_SOUTH + addSubZ_SOUTH));
        map.put(Direction.WEST, new Vec3((1.3 * multipleOfX_WEST) + addSubX_WEST,1,0.265 * multipleOfZ_WEST + addSubZ_WEST));
        map.put(Direction.EAST, new Vec3((1.3 * multipleOfX_EAST) + addSubX_EAST,1,0.265 * multipleOfZ_EAST + addSubZ_EAST));
        this.positions.put("Randomizer",map);

        // Exterior Facing
        map = new HashMap<>();
        map.put(Direction.NORTH, new Vec3((0.735 * multipleOfX_NORTH) + addSubX_NORTH,1,1.3 * multipleOfZ_NORTH + addSubZ_NORTH));
        map.put(Direction.SOUTH, new Vec3((0.735 * multipleOfX_SOUTH) + addSubX_SOUTH,1,1.3 * multipleOfZ_SOUTH + addSubZ_SOUTH));
        map.put(Direction.WEST, new Vec3((1.3 * multipleOfX_WEST) + addSubX_WEST,1,0.735 * multipleOfZ_WEST + addSubZ_WEST));
        map.put(Direction.EAST, new Vec3((1.3 * multipleOfX_EAST) + addSubX_EAST,1,0.735 * multipleOfZ_EAST + addSubZ_EAST));
        this.positions.put("Exterior Facing",map);
    }

    @Override
    public Vec3 positionFor(String controlName, BlockPos pos, Direction direction) {
        if (this.positions.isEmpty()) {
            this.generatePositions();
        }

        Vec3 position = this.positions.get(controlName).get(direction);

        if (position == null) {
            this.positions.clear(); // Since we know its fucked, just regenerate it lol
            return null;
        }

        return position.add(new Vec3(pos.getX(),pos.getY(),pos.getZ()));
    }
}
