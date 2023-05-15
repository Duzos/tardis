package com.duzo.tardis.tardis.structures;

import com.duzo.tardis.tardis.TARDIS;
import com.duzo.tardis.tardis.doors.TARDISInteriorDoors;
import com.duzo.tardis.tardis.interiors.TARDISInteriorSchema;
import com.google.common.collect.Lists;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.blocks.BlockInput;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.commands.FillCommand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Clearable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class TARDISStructureGenerator {
    public static class InteriorGenerator extends TARDISStructureGenerator {
        private TARDIS tardis;
        private TARDISInteriorSchema interior;
        public InteriorGenerator(TARDIS tardis, ServerLevel level, TARDISInteriorSchema interior) {
            super(level,interior);
            this.tardis = tardis;
            this.interior = interior;
        }

        @Override
        public void placeStructure(ServerLevel level, BlockPos pos, Direction direction) {
            super.placeStructure(level, pos, direction);
            this.interior.setDoorPosition(findTargetBlockPosInTemplate(this.template,pos,direction, TARDISInteriorDoors.INTERIOR_DOOR_BLOCK_LIST).get(0));
            this.tardis.getInterior().setSchema(this.interior);

//            this.tardis.setInterior(this.interior);
        }
    }
    private TARDISStructure structure;
    private String structureName;
    protected StructureTemplate template;

    public TARDISStructureGenerator(ServerLevel level, TARDISStructure structure) {
        this.structure = structure;
        this.structureName = structure.getStructureName();
        this.template = level.getStructureManager().getOrCreate(this.structure.getLocation());
    }

    public void placeStructure(ServerLevel level, BlockPos pos, Direction direction) {
        this.template.placeInWorld(level,pos,pos,new StructurePlaceSettings(),level.getRandom(),2); // .setRotation(this.directionToRotation(direction))
    }

    protected BlockPos findTargetBlockPosInTemplate(StructureTemplate template,BlockPos pos, Direction direction, Block targetBlock) {
        List<StructureTemplate.StructureBlockInfo> list = template.filterBlocks(
                pos, new StructurePlaceSettings().setRotation(directionToRotation(direction)), targetBlock);

        if (list.size() == 0) {
            return new BlockPos(0,0,0);
        }

        return list.get(0).pos;
    }

    /**
     * Recommended usage is for finding the first door pos etc
     *
     * @param targetBlocks Blocks to search for
     * @return A list of blockpos' for the FIRST instance of each block
     */
    protected List<BlockPos> findTargetBlockPosInTemplate(StructureTemplate template, BlockPos pos, Direction direction, List<Block> targetBlocks) {
        List<BlockPos> posList = new ArrayList<>();
        for (Block block : targetBlocks) {
            BlockPos foundPos = this.findTargetBlockPosInTemplate(template,pos,direction,block);
            if (foundPos != null) {
                posList.add(foundPos);
            }
        }
        return posList;
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
