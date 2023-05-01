package com.duzo.tardis.tardis;

import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.core.world.dimension.DimensionsInit;
import com.duzo.tardis.nbt.NBTSerializers;
import com.duzo.tardis.tardis.animation.ExteriorAnimation;
import com.duzo.tardis.tardis.animation.impl.ClassicAnimation;
import com.duzo.tardis.tardis.builder.TARDISBuilder;
import com.duzo.tardis.tardis.doors.blocks.InteriorDoorBlock;
import com.duzo.tardis.tardis.doors.blocks.InteriorDoorBlockEntity;
import com.duzo.tardis.tardis.exteriors.TARDISExteriorSchema;
import com.duzo.tardis.tardis.exteriors.TARDISExteriors;
import com.duzo.tardis.tardis.exteriors.blocks.entities.ExteriorBlockEntity;
import com.duzo.tardis.tardis.interiors.TARDISInterior;
import com.duzo.tardis.tardis.interiors.TARDISInteriorSchema;
import com.duzo.tardis.tardis.interiors.TARDISInteriors;
import com.duzo.tardis.tardis.io.TARDISTravel;
import com.duzo.tardis.tardis.io.TeleportHelper;
import com.duzo.tardis.tardis.manager.TARDISManager;
import com.duzo.tardis.tardis.structures.TARDISStructureGenerator;
import com.duzo.tardis.tardis.util.TARDISUtil;
import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TARDIS {
    private TARDISExteriorSchema<?> exteriorSchema;
    private AbsoluteBlockPos pos;
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

        this.getInterior().link(this);

        System.out.println(this.exteriorSchema);
        this.logDebug();
    }

    public TARDIS(UUID uuid, AbsoluteBlockPos pos, TARDISExteriorSchema<?> exteriorSchema, TARDISInterior interior) {
        this(uuid,pos,new TARDISTravel(null),exteriorSchema,interior);
        this.travel.setTARDIS(this);
    }

    public TARDIS(UUID uuid, AbsoluteBlockPos pos, TARDISExteriorSchema<?> exteriorSchema) {
        this(uuid, pos, new TARDISTravel(null), exteriorSchema, new TARDISInterior(TARDISInteriors.get(TARDISBuilder.DEFAULT_INTERIOR)));
        this.travel.setTARDIS(this);
    }
    public TARDIS(UUID uuid, AbsoluteBlockPos pos) {
        this(uuid,pos, TARDISExteriors.get(TARDISBuilder.DEFAULT_EXTERIOR));
    }

//    @Deprecated
//    public void generateInteriorDEPRECATED() {
//        this.getInterior().place((ServerLevel) this.getInteriorDimension(),new BlockPos(0,0,0));
//        this.hasInterior = true;
//    }

    public void logDebug() {
        Logger logger = LogUtils.getLogger();
        logger.debug(this.toString());
        logger.debug(this.pos.toString());
        logger.debug(this.travel.toString());
        logger.debug(this.uuid.toString());
        logger.debug(this.exteriorSchema.getID());
    }

    /**
     * Demats this TARDIS and remats it at the specified position
     * @param pos The position to go to
     * @param withAirCheck Whether to land at the nearest available space if the pos is blocked
     */
    public void to(AbsoluteBlockPos pos, boolean withAirCheck) {
        this.getTravel().setDestination(pos,withAirCheck);

        if (this.getTravel().inFlight()) {
            this.getTravel().materialise();
        } else {
            this.getTravel().dematerialise(true);
        }
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
    public AbsoluteBlockPos getPositionForTeleporting() {
        BlockPos doorPos = this.getPosition();
        BlockPos adjustedPos = doorPos;
        Direction doorDirection = this.getPosition().getDimension()
                .getBlockState(
                        doorPos)
                .getValue(BlockStateProperties.HORIZONTAL_FACING);

        switch(doorDirection) {
            case NORTH -> adjustedPos = doorPos.north(1);
            case SOUTH -> adjustedPos = doorPos.south(1);
            case EAST -> adjustedPos = doorPos.east(1);
            case WEST -> adjustedPos = doorPos.west(1);
        }
        return new AbsoluteBlockPos(this.getPosition().getDimension(),adjustedPos);
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
        return this.getInterior().needsGeneration();
    }

    public void updateBlockEntity() {
        if (this.getLevel().isClientSide) {return;}

        BlockEntity entity = this.getLevel().getBlockEntity(this.getPosition());

        if (!(entity instanceof ExteriorBlockEntity)) {
            LogUtils.getLogger().error("Could not find Exterior Block Entity at " + this.pos.toString() + " when trying to update!\nInstead got: " + entity);
            return;
        }

        ((ExteriorBlockEntity) entity).setTARDIS(this);
    }

    public TARDISExteriorSchema<?> getExteriorSchema() {return this.exteriorSchema;}
    public void setExteriorSchema(TARDISExteriorSchema<?> exterior) {this.exteriorSchema = exterior;}

    public ExteriorAnimation getExteriorAnimation() {
        return new ClassicAnimation((ExteriorBlockEntity) this.getLevel().getBlockEntity(this.getPosition()));
    }

    public static class Serializer {
        private static final NBTSerializers.AbsolutePosition ABSOLUTE_POSITION_SERIALIZER = new NBTSerializers.AbsolutePosition();
        private static final TARDISTravel.Serializer TRAVEL_SERIALIZER = new TARDISTravel.Serializer();
        private static final TARDISExteriorSchema.Serializer EXTERIOR_SERIALIZER = new TARDISExteriorSchema.Serializer();
        private static final TARDISInterior.Serializer INTERIOR_SERIALIZER = new TARDISInterior.Serializer();


        public CompoundTag serialize(TARDIS tardis) {
            CompoundTag tag = new CompoundTag();
            this.serialize(tag,tardis);
            return tag;
        }
        public void serialize(CompoundTag nbt, TARDIS tardis) {
            nbt.putUUID("uuid", tardis.getUuid());
            EXTERIOR_SERIALIZER.serialize(nbt,tardis.getExteriorSchema());
            INTERIOR_SERIALIZER.serialize(nbt,tardis.getInterior());
            ABSOLUTE_POSITION_SERIALIZER.serialize(nbt,tardis.pos);
            TRAVEL_SERIALIZER.serialize(nbt,tardis.getTravel());
        }

        public TARDIS deserialize(CompoundTag nbt) {
            TARDIS tardis = new TARDIS(
                    nbt.getUUID("uuid"),
                    ABSOLUTE_POSITION_SERIALIZER.deserialize(nbt),
                    EXTERIOR_SERIALIZER.deserialize(nbt),
                    INTERIOR_SERIALIZER.deserialize(nbt)
                );

            tardis.travel = TRAVEL_SERIALIZER.deserialize(nbt);
            tardis.travel.setTARDIS(tardis);

            System.out.println(tardis);

            return tardis;
        }
    }
}