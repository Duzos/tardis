package com.duzo.tardis.core.util;

import com.duzo.tardis.TARDISMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.server.ServerLifecycleHooks;

import java.util.Iterator;

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

    public AbsoluteBlockPos(ResourceKey<Level> dimension, BlockPos pos) {
         this(TARDISMod.server.getLevel(dimension),pos);
    }

    public Level getDimension() {
        return this.dimension;
    }
    public ResourceKey<Level> getResourceKeyLevel() {
        // Find the resource key from the server and grab that if it exists
        if (!TARDISMod.server.levelKeys().contains(this.dimension)) {return null;}

        for (Iterator<ResourceKey<Level>> it = TARDISMod.server.levelKeys().iterator(); it.hasNext(); ) {
            ResourceKey<Level> key = it.next();
            if (TARDISMod.server.getLevel(key) == this.dimension) {
                return key;
            }
        }
        return null;
    }
    public Direction getDirection() {return this.direction;}
}
