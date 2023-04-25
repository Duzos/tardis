package com.duzo.tardis.tardis.structures;

import com.duzo.tardis.tardis.TARDIS;
import com.duzo.tardis.tardis.interiors.TARDISInterior;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

public class TARDISStructureGenerator {
    public static class InteriorGenerator extends TARDISStructureGenerator {
        private TARDIS tardis;
        private TARDISInterior interior;
        public InteriorGenerator(TARDIS tardis, ServerLevel level, TARDISInterior interior) {
            super(level,interior);
            this.tardis = tardis;
            this.interior = interior;
        }

        @Override
        public void placeStructure(ServerLevel level, BlockPos pos, Direction direction) {
            super.placeStructure(level, pos, direction);
            this.tardis.setInterior(this.interior);
        }
    }
    private TARDISStructure structure;
    private String structureName;
    private StructureTemplate template;

    public TARDISStructureGenerator(ServerLevel level, TARDISStructure structure) {
        this.structure = structure;
        this.structureName = structure.getStructureName();
        this.template = level.getStructureManager().getOrCreate(this.structure.getLocation());
    }

    public void placeStructure(ServerLevel level, BlockPos pos, Direction direction) {
        this.template.placeInWorld(level,pos,pos,new StructurePlaceSettings().setRotation(this.directionToRotation(direction)),level.getRandom(),2);
    }

    private Rotation directionToRotation(Direction direction) {
        return switch (direction) {
            default -> Rotation.NONE;
            case NORTH -> Rotation.CLOCKWISE_180;
            case SOUTH -> Rotation.NONE;
            case EAST -> Rotation.COUNTERCLOCKWISE_90;
            case WEST -> Rotation.CLOCKWISE_90;
        };
    }

    public static Direction rotationToDirection(Rotation rotation) {
        return switch(rotation) {
            case NONE -> Direction.NORTH;
            case CLOCKWISE_180 -> Direction.SOUTH;
            case CLOCKWISE_90 -> Direction.WEST;
            case COUNTERCLOCKWISE_90 -> Direction.EAST;
        };
    }
}
