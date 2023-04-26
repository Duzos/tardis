package com.duzo.tardis.tardis;

import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.core.world.dimension.DimensionsInit;
import com.duzo.tardis.nbt.NBTSerializers;
import com.duzo.tardis.tardis.builder.TARDISBuilder;
import com.duzo.tardis.tardis.doors.blocks.InteriorDoorBlock;
import com.duzo.tardis.tardis.doors.blocks.InteriorDoorBlockEntity;
import com.duzo.tardis.tardis.exteriors.TARDISExteriorSchema;
import com.duzo.tardis.tardis.exteriors.TARDISExteriors;
import com.duzo.tardis.tardis.interiors.TARDISInteriors;
import com.duzo.tardis.tardis.io.TARDISTravel;
import com.duzo.tardis.tardis.io.TeleportHelper;
import com.duzo.tardis.tardis.manager.TARDISManager;
import com.duzo.tardis.tardis.structures.TARDISStructureGenerator;
import com.duzo.tardis.tardis.interiors.TARDISInterior;
import com.duzo.tardis.tardis.util.TARDISUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class TARDIS {
    private TARDISExteriorSchema<?> exteriorSchema;
    private AbsoluteBlockPos pos;
    private List<AbsoluteBlockPos> interiorCornerPositions;
    private BlockPos interiorDoorPos;
    private TARDISTravel travel;
    private UUID uuid;
    private TARDISInterior interior;
    @Deprecated
    private boolean hasInterior;

    public TARDIS(UUID uuid, AbsoluteBlockPos pos, TARDISTravel travel, TARDISExteriorSchema<?> exteriorSchema, TARDISInterior interior) {
        this.pos = pos;
        this.travel = travel;
        this.uuid = uuid;
        this.exteriorSchema = exteriorSchema;
        this.interior = interior;
    }

    public TARDIS(UUID uuid, AbsoluteBlockPos pos, TARDISExteriorSchema<?> exteriorSchema, TARDISInterior interior) {
        this(uuid,pos,new TARDISTravel(null),exteriorSchema,interior);
        this.travel.setTARDIS(this);
    }

    public TARDIS(UUID uuid, AbsoluteBlockPos pos, TARDISExteriorSchema<?> exteriorSchema) {
        this(uuid, pos, new TARDISTravel(null), exteriorSchema, TARDISInteriors.get(TARDISBuilder.DEFAULT_INTERIOR));
        this.travel.setTARDIS(this);
    }
    public TARDIS(UUID uuid, AbsoluteBlockPos pos) {
        this(uuid,pos, TARDISExteriors.get(TARDISBuilder.DEFAULT_EXTERIOR));
    }


    public void generateInterior() {
        this.generateInterior(this.getInterior());
    }
    public void generateInterior(TARDISInterior interior) {
        this.interiorCornerPositions = TARDISManager.getInstance().getNextAvailableInteriorSpot();

        System.out.println(this.interiorCornerPositions);

        TARDISStructureGenerator.InteriorGenerator generator = new TARDISStructureGenerator.InteriorGenerator(this, (ServerLevel) this.getInteriorDimension(), interior);
        generator.placeStructure((ServerLevel) this.getInteriorDimension(), this.interiorCornerPositions.get(0), Direction.SOUTH);
    }
    @Deprecated
    public void generateInteriorDEPRECATED() {
        this.getInterior().place((ServerLevel) this.getInteriorDimension(),new BlockPos(0,0,0));
        this.hasInterior = true;
    }

    /**
     * Demats this TARDIS and remats it at the specified position
     * @param pos The position to go to
     * @param withAirCheck Whether to land at the nearest available space if the pos is blocked
     */
    public void to(AbsoluteBlockPos pos, boolean withAirCheck) {
        this.getTravel().setDestination(pos,withAirCheck);
        this.getTravel().dematerialise(true);
    }

    public void teleportToDoor(Player player) {
        if (this.needsInterior()) {
            this.generateInterior();
        }

        TeleportHelper helper = new TeleportHelper(player.getUUID(),new AbsoluteBlockPos(this.getInteriorDimension(),this.getOffsetDoorPosition()));
        helper.teleport((ServerLevel) player.getLevel());
    }

    public TARDISTravel getTravel() {
        return this.travel;
    }

    public Level getLevel() {
        return this.pos.getDimension();
    }

    public void setPosition(AbsoluteBlockPos pos) {
        this.pos = pos;
    }

    public AbsoluteBlockPos getPosition() {
        return this.pos;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public TARDISInterior getInterior() {
        return this.interior;
    }

    public void setInterior(TARDISInterior interior) {
        this.interior = interior;
    }

    public boolean needsInterior() {
//        return !this.hasInterior;
        return this.interiorCornerPositions == null;
    }

    public Level getInteriorDimension() {
        return this.getLevel().getServer().getLevel(DimensionsInit.TARDIS_DIM_KEY);
    }

    public BlockPos getInteriorDoorPos() {
        if (this.interiorDoorPos != null) {return this.interiorDoorPos;}

        return this.searchForDoorPosAndUpdate();
    }
    private BlockPos searchForDoorPosAndUpdate() {
        BlockPos doorPos = this.interiorCornerPositions.get(0).offset(this.getInterior().getDoorPosition());
        System.out.println(doorPos);

        if (!(this.getInteriorDimension().getBlockState(doorPos).getBlock() instanceof InteriorDoorBlock)) {
            doorPos = TARDISManager.getInstance().searchForDoorBlock(this.interiorCornerPositions);
        }

        InteriorDoorBlockEntity door = (InteriorDoorBlockEntity) this.getInteriorDimension().getBlockEntity(doorPos);
        assert door != null;
        door.setTARDIS(this);

        return doorPos;
    }
    private BlockPos getOffsetDoorPosition() {
        BlockPos doorPos = this.getInteriorDoorPos();
        BlockPos adjustedPos = doorPos;
        Direction doorDirection = this.getInteriorDimension()
                .getBlockState(
                        doorPos)
                .getValue(BlockStateProperties.HORIZONTAL_FACING);
        switch(doorDirection) {
            case NORTH -> adjustedPos = doorPos.north(1);
            case SOUTH -> adjustedPos = doorPos.south(1);
            case EAST -> adjustedPos = doorPos.east(1);
            case WEST -> adjustedPos = doorPos.west(1);
        }
        return adjustedPos;
    }


    public TARDISExteriorSchema<?> getExteriorSchema() {return this.exteriorSchema;}
    public void setExteriorSchema(TARDISExteriorSchema<?> exterior) {this.exteriorSchema = exterior;}
    public List<AbsoluteBlockPos> getInteriorCornerPositions() {
        return this.interiorCornerPositions;
    }
    public void setInteriorCornerPositions(List<AbsoluteBlockPos> list) {
        this.interiorCornerPositions = list;
    }
    public static class Serializer {
        private static final NBTSerializers.AbsolutePosition ABSOLUTE_POSITION_SERIALIZER = new NBTSerializers.AbsolutePosition();
        private static final TARDISTravel.Serializer TRAVEL_SERIALIZER = new TARDISTravel.Serializer();
        public CompoundTag serialize(TARDIS tardis) {
            CompoundTag tag = new CompoundTag();
            this.serialize(tag,tardis);
            return tag;
        }
        public void serialize(CompoundTag nbt, TARDIS tardis) {
            nbt.putUUID("uuid", tardis.getUuid());
            nbt.putString("exteriorSchema", tardis.getExteriorSchema().getID());
            nbt.putString("interiorID", tardis.getInterior().getID());
            ABSOLUTE_POSITION_SERIALIZER.serialize(nbt,tardis.pos);
            if (tardis.interiorCornerPositions != null) {
                nbt.put("bottomLeft", NbtUtils.writeBlockPos(tardis.interiorCornerPositions.get(0)));
                nbt.put("topRight", NbtUtils.writeBlockPos(tardis.interiorCornerPositions.get(1)));
            }

            nbt.put("tardisTravel",TRAVEL_SERIALIZER.serialize(tardis.getTravel()));
        }

        public TARDIS deserialize(CompoundTag nbt) {
            TARDIS tardis = new TARDIS(nbt.getUUID("uuid"), ABSOLUTE_POSITION_SERIALIZER.deserialize(nbt), TARDISExteriors.get(nbt.getString("exteriorSchema")), TARDISInteriors.get(nbt.getString("interiorID")));

            AbsoluteBlockPos bottomLeft = new AbsoluteBlockPos(TARDISUtil.getTARDISLevel(), NbtUtils.readBlockPos(nbt.getCompound("bottomRight")));
            AbsoluteBlockPos topRight = new AbsoluteBlockPos(TARDISUtil.getTARDISLevel(), NbtUtils.readBlockPos(nbt.getCompound("topRight")));
            List<AbsoluteBlockPos> list = new ArrayList<>();
            list.add(bottomLeft);
            list.add(topRight);
            tardis.setInteriorCornerPositions(list);

            tardis.travel = TRAVEL_SERIALIZER.deserialize(nbt.getCompound("tardisTravel"));
            tardis.travel.setTARDIS(tardis);

            System.out.println(tardis);

            return tardis;
        }
    }
}