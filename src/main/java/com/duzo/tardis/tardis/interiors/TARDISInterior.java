package com.duzo.tardis.tardis.interiors;

import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.core.world.dimension.DimensionsInit;
import com.duzo.tardis.tardis.TARDIS;
import com.duzo.tardis.tardis.doors.blocks.InteriorDoorBlock;
import com.duzo.tardis.tardis.doors.blocks.InteriorDoorBlockEntity;
import com.duzo.tardis.tardis.io.TeleportHelper;
import com.duzo.tardis.tardis.manager.TARDISManager;
import com.duzo.tardis.tardis.structures.TARDISStructureGenerator;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.ArrayList;
import java.util.List;

public class TARDISInterior {
    private TARDISInteriorSchema schema;
    private TARDIS tardis;
    private List<AbsoluteBlockPos> interiorCornerPositions;
    private BlockPos interiorDoorPos;

    public TARDISInterior(TARDISInteriorSchema schema) {this.schema =schema;}
    public TARDISInterior(CompoundTag tag,TARDISInteriorSchema schema) {
        this.schema = schema;
        this.loadCorners(tag);
    }

    public void link(TARDIS tardis) {
        this.tardis = tardis;
    }

    public TARDISInteriorSchema getSchema() {return this.schema;}

    public Level getInteriorDimension() {
        return this.tardis.getLevel().getServer().getLevel(DimensionsInit.TARDIS_DIM_KEY);
    }

    public BlockPos getInteriorDoorPos() {
        if (this.interiorDoorPos != null && this.getInteriorDimension().getBlockEntity(this.interiorDoorPos) instanceof InteriorDoorBlockEntity) {return this.interiorDoorPos;}

        return this.searchForDoorPosAndUpdate();
    }
    private BlockPos searchForDoorPosAndUpdate() {
        BlockPos doorPos = this.interiorCornerPositions.get(0).offset(this.getSchema().getDoorPosition());
        System.out.println(doorPos);

        if (!(this.getInteriorDimension().getBlockState(doorPos).getBlock() instanceof InteriorDoorBlock)) {
            doorPos = TARDISManager.getInstance().searchForDoorBlock(this.interiorCornerPositions);
        }

        InteriorDoorBlockEntity door = (InteriorDoorBlockEntity) this.getInteriorDimension().getBlockEntity(doorPos);
        assert door != null;
        door.setTARDIS(this.tardis);

        this.interiorDoorPos = doorPos;

        return doorPos;
    }
    private BlockPos getOffsetDoorPosition() {
        BlockPos doorPos = this.getInteriorDoorPos();
        BlockPos adjustedPos = new BlockPos(0,0,0);
        Direction doorDirection = this.getInteriorDimension()
                .getBlockState(
                        doorPos)
                .getValue(BlockStateProperties.HORIZONTAL_FACING);
        switch(doorDirection) {
            case NORTH -> adjustedPos = new BlockPos(doorPos.getX() + 0.5,doorPos.getY(),doorPos.getZ() - 1.5);
            case SOUTH -> adjustedPos =new BlockPos(doorPos.getX() + 0.5,doorPos.getY(),doorPos.getZ() + 1.5);
            case EAST -> adjustedPos = new BlockPos(doorPos.getX() + 1.5,doorPos.getY(),doorPos.getZ() + 0.5);
            case WEST -> adjustedPos = new BlockPos(doorPos.getX() - 1.5,doorPos.getY(),doorPos.getZ() + 0.5);
        }
        return adjustedPos;
    }

    public List<AbsoluteBlockPos> getInteriorCornerPositions() {
        return this.interiorCornerPositions;
    }
    public void setInteriorCornerPositions(List<AbsoluteBlockPos> list) {
        this.interiorCornerPositions = list;
    }

    public void teleportToDoor(Player player) {
        if (this.needsGeneration()) {
            this.generate();
        }

        Direction doorDirection = this.getInteriorDimension()
                .getBlockState(
                        this.getInteriorDoorPos())
                .getValue(BlockStateProperties.HORIZONTAL_FACING);

        TeleportHelper helper = new TeleportHelper(player.getUUID(),new AbsoluteBlockPos(this.getInteriorDimension(),doorDirection,this.getOffsetDoorPosition()));
        helper.teleport((ServerLevel) player.getLevel());
    }

    public void delete() {
        TARDISStructureGenerator.InteriorGenerator generator = new TARDISStructureGenerator.InteriorGenerator(this.tardis, (ServerLevel) this.getInteriorDimension(),this.getSchema());
        generator.deleteInterior();
        this.interiorCornerPositions = null;
    }

    public void generate() {
        this.generate(this.getSchema());
    }
    public void generate(TARDISInteriorSchema interior) {
        this.interiorCornerPositions = TARDISManager.getInstance().getNextAvailableInteriorSpot();

        TARDISStructureGenerator.InteriorGenerator generator = new TARDISStructureGenerator.InteriorGenerator(this.tardis, (ServerLevel) this.getInteriorDimension(), interior);
        generator.placeStructure((ServerLevel) this.getInteriorDimension(), this.interiorCornerPositions.get(0), Direction.SOUTH);
    }

    public boolean needsGeneration() {
        return this.interiorCornerPositions == null;
    }

    public void setSchema(TARDISInteriorSchema schema) {
        this.schema = schema;
    }

    private void loadCorners(CompoundTag tag) {
        AbsoluteBlockPos bottomLeft = new AbsoluteBlockPos(this.getInteriorDimension(),NbtUtils.readBlockPos(tag.getCompound("bottomLeft")));
        AbsoluteBlockPos topRight = new AbsoluteBlockPos(this.getInteriorDimension(),NbtUtils.readBlockPos(tag.getCompound("topRight")));

        this.interiorCornerPositions.set(0, bottomLeft);
        this.interiorCornerPositions.set(1, topRight);
    }

    public static class Serializer {
        private static final TARDISInteriorSchema.Serializer SCHEMA_SERIALIZER = new TARDISInteriorSchema.Serializer();

        public void serialize(CompoundTag tag, TARDISInterior interior) {
            CompoundTag schema = new CompoundTag();
            SCHEMA_SERIALIZER.serialize(schema, interior.schema);

            tag.put("doorPos",NbtUtils.writeBlockPos(interior.interiorDoorPos));

            tag.put("bottomLeft", NbtUtils.writeBlockPos(interior.interiorCornerPositions.get(0)));
            tag.put("topRight", NbtUtils.writeBlockPos(interior.interiorCornerPositions.get(1)));

            tag.put("schema", schema);
        }
        public TARDISInterior deserialize(CompoundTag nbt) {
            return new TARDISInterior(nbt,SCHEMA_SERIALIZER.deserialize(nbt.getCompound("schema")));
        }

    }
}
