package com.duzo.tardis.core.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.RegistryObject;

public class AbsoluteBlockPos extends BlockPos {
    // Saw Theo do this in AIT, thought it was a great idea
    private final Level dimension;
    private final Direction direction;
    public AbsoluteBlockPos(Level dimension, Direction direction, int x, int y, int z) {
        super(x,y,z);

        this.direction = direction;
        this.dimension = dimension;
    }
    public AbsoluteBlockPos(Level dimension,Direction direction, BlockPos pos) {
        this(dimension,direction, pos.getX(), pos.getY(), pos.getZ());
    }
    public AbsoluteBlockPos(Level dimension, BlockPos pos) {
        this(dimension, Direction.NORTH, pos);
    }

    public Level getDimension() {
        return this.dimension;
    }
    public Direction getDirection() {return this.direction;}
}
