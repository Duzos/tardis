package com.duzo.tardis.tardis.structures;

import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class AreaDeletionThread implements Runnable {
    private List<AbsoluteBlockPos> area;

    public AreaDeletionThread(List<AbsoluteBlockPos> area) {
        this.area = area;
    }

    public AreaDeletionThread(AbsoluteBlockPos firstCorner,  AbsoluteBlockPos secondCorner) {
        this(List.of(firstCorner,secondCorner));
    }

    @Override
    public void run() {
        AbsoluteBlockPos firstCorner = this.area.get(0);
        AbsoluteBlockPos secondCorner = this.area.get(1);
        Level level = firstCorner.getDimension();

        // Work out which direction to do movements in (only doing this because i know some schizo like loqor is going to use the way id rather do it incorrectly somehow and then blame everything on me so ill just make the code gooder than usual just this once, + reusability ini)
        List<Direction> directions = workOutDirectionsFromCoordinates(this.area);
        System.out.println("Directions are " + directions);
        // Let the while loops begin
        // @TODO there has to be a better way, right??

/*        if (directions.get(0) == Direction.NORTH) {
            if (directions.get(1) == Direction.EAST) {
                while (!currentPos.equals(secondCorner.north())) {
                    level.removeBlock(currentPos, false);
                    System.out.println("deleting " + currentPos);

                    if (currentPos.getZ() == secondCorner.getZ()) {
                        if (currentPos.getX() == secondCorner.getX()) {
                            currentPos = new BlockPos(firstCorner.getX(), currentPos.above().getY(), firstCorner.getZ());
                        } else {
                            currentPos = new BlockPos(currentPos.east().getX(), currentPos.getY(), firstCorner.getZ());
                        }
                    }
                    currentPos = currentPos.north();
                }
            } else if (directions.get(1) == Direction.WEST) {
                while (!currentPos.equals(secondCorner.north())) {
                    level.removeBlock(currentPos,false);
                    System.out.println("deleting " + currentPos);

                    if (currentPos.getZ() == secondCorner.getZ()) {
                        if (currentPos.getX() == secondCorner.getX()) {
                            currentPos = new BlockPos(firstCorner.getX(),currentPos.above().getY(),firstCorner.getZ());
                        } else {
                            currentPos = new BlockPos(currentPos.west().getX(), currentPos.getY(), firstCorner.getZ());
                        }
                    }
                    currentPos = currentPos.north();
                }
            }
        } else if (directions.get(0) == Direction.SOUTH) {
            if (directions.get(1) == Direction.EAST) {
                while (!currentPos.equals(secondCorner.south())) {
                    level.removeBlock(currentPos, false);
                    System.out.println("deleting " + currentPos);

                    if (currentPos.getZ() == secondCorner.getZ()) {
                        System.out.println(secondCorner.getX());
                        if (currentPos.getX() == secondCorner.getX()) {
                            currentPos = new BlockPos(firstCorner.getX(), currentPos.above().getY(), firstCorner.getZ());
                        } else {
                            currentPos = new BlockPos(currentPos.east().getX(), currentPos.getY(), firstCorner.getZ());
                        }
                    }
                    currentPos = currentPos.south();
                }
            } else if (directions.get(1) == Direction.WEST) {
                while (!currentPos.equals(secondCorner.south())) {
                    level.removeBlock(currentPos,false);
                    System.out.println("deleting " + currentPos);

                    if (currentPos.getZ() == secondCorner.getZ()) {
                        if (currentPos.getX() == secondCorner.getX()) {
                            currentPos = new BlockPos(firstCorner.getX(),currentPos.above().getY(),firstCorner.getZ());
                        } else {
                            currentPos = new BlockPos(currentPos.west().getX(), currentPos.getY(), firstCorner.getZ());
                        }
                    }
                    currentPos = currentPos.south();
                }
            }
        }
*/

        // Okay, the while loops kinda crashed my computer
        // Maybe a for loop?
        // @TODO possibly replace all the if statements with one simple method to check for direction where the "x--" stuff is
        int x = firstCorner.getX();
        int y = firstCorner.getY();
        int z = firstCorner.getZ();

        if (directions.get(0) == Direction.NORTH) {
            if (directions.get(1) == Direction.EAST) {
                for (x = x; x <= secondCorner.getX(); x++) {
                    y = firstCorner.getY();
                    for (y = y; y <= secondCorner.getY(); y++) {
                        z = firstCorner.getZ();
                        for (z = z; z >= secondCorner.getZ(); z--) {
                            if (level.getBlockState(new BlockPos(x,y,z)).isAir()) continue;
                            level.removeBlock(new BlockPos(x,y,z),false);
                        }
                    }
                }
            } else if (directions.get(1) == Direction.WEST) {
                for (x = x; x >= secondCorner.getX(); x--) {
                    y = firstCorner.getY();
                    for (y = y; y <= secondCorner.getY(); y++) {
                        z = firstCorner.getZ();
                        for (z = z; z >= secondCorner.getZ(); z--) {
                            if (level.getBlockState(new BlockPos(x,y,z)).isAir()) continue;
                            level.removeBlock(new BlockPos(x,y,z),false);
                        }
                    }
                }
            }
        } else if (directions.get(0) == Direction.SOUTH) {
            if (directions.get(1) == Direction.EAST) {
                for (x = x; x <= secondCorner.getX(); x++) {
                    y = firstCorner.getY();
                    for (y = y; y <= secondCorner.getY(); y++) {
                        z = firstCorner.getZ();
                        for (z = z; z <= secondCorner.getZ(); z++) {
                            if (level.getBlockState(new BlockPos(x,y,z)).isAir()) continue;
                            level.removeBlock(new BlockPos(x,y,z),false);
                        }
                    }
                }
            } else if (directions.get(1) == Direction.WEST) {
                for (x = x; x >= secondCorner.getX(); x--) {
                    y = firstCorner.getY();
                    for (y = y; y <= secondCorner.getY(); y++) {
                        z = firstCorner.getZ();
                        for (z = z; z <= secondCorner.getZ(); z++) {
                            if (level.getBlockState(new BlockPos(x,y,z)).isAir()) continue;
                            level.removeBlock(new BlockPos(x,y,z),false);
                        }
                    }
                }
            }
        }

        Logger logger = LogUtils.getLogger();
        logger.info("Deleted area " + this.area);
    }

    private static double whichIsCloser(int a, int b, int c) {
        if (Math.abs(c - a) < Math.abs(c - b)) {
            return a;
        } else {
            return b;
        }
    }

    private static List<Direction> workOutDirectionsFromCoordinates(List<AbsoluteBlockPos> area) {
        AbsoluteBlockPos firstCorner = area.get(0);
        AbsoluteBlockPos secondCorner = area.get(1);

        // North = -Z
        // South = +Z
        // Checks the position north of the first corner and if its closer than the original position its north, otherwise its south
        double closest   = whichIsCloser(firstCorner.getZ(),firstCorner.north().getZ(),secondCorner.getZ());
        Direction northSouth;
        if (closest == firstCorner.getZ()) {
            northSouth = Direction.SOUTH;
        } else {
            northSouth = Direction.NORTH;
        }

        // West = -X
        // East = +X
        // Checks the position north of the first corner and if its closer than the original position its west, otherwise its east
        double closest2 = whichIsCloser(firstCorner.getX(),firstCorner.west().getX(),secondCorner.getX());
        Direction eastWest;
        if (closest2 == firstCorner.getX()) {
            eastWest = Direction.EAST;
        } else {
            eastWest = Direction.WEST;
        }

        return List.of(northSouth,eastWest);
    }


//    private static List<Direction> workOutDirectionsFromCoordinates(List<AbsoluteBlockPos> area) {
//        AbsoluteBlockPos firstCorner = area.get(0);
//        AbsoluteBlockPos secondCorner = area.get(1);
//
//        Direction northSouth = workOutDirectionFromTwoPoints(0,0, secondCorner.getZ(), firstCorner.getZ());
//        Direction eastWest = workOutDirectionFromTwoPoints(0,0,secondCorner.getX(),firstCorner.getX());
//
//        System.out.println(northSouth);
//        System.out.println(eastWest);
//
//        return List.of(northSouth,eastWest);
//    }
//    private static Direction workOutDirectionFromTwoPoints(int x1,int y1, int x2, int y2) {
//        double rad = Math.atan2(x2-x1,y2-y1);
//        double degrees = Math.toDegrees(rad);
//        System.out.println(degrees);
//        return Direction.fromYRot(degrees);
//    }
}
