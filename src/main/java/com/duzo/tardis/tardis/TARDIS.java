package com.duzo.tardis.tardis;

import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.core.world.dimension.DimensionsInit;
import com.duzo.tardis.nbt.NBTSerializers;
import com.duzo.tardis.tardis.io.TARDISTravel;
import com.duzo.tardis.tardis.structures.TARDISStructureGenerator;
import com.duzo.tardis.tardis.structures.interiors.TARDISInterior;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import org.checkerframework.checker.units.qual.C;

import java.util.UUID;

public class TARDIS {
    private AbsoluteBlockPos pos;
    private TARDISTravel travel;
    private UUID uuid;
    private TARDISInterior interior;

    public TARDIS(UUID uuid, AbsoluteBlockPos pos, TARDISTravel travel) {
        this.pos = pos;
        this.travel = travel;
        this.uuid = uuid;
    }

    public TARDIS(UUID uuid, AbsoluteBlockPos pos) {
        this(uuid, pos, new TARDISTravel(null));
        this.travel.setTARDIS(this);
    }

    public void generateInterior(TARDISInterior interior) {
        TARDISStructureGenerator.InteriorGenerator generator = new TARDISStructureGenerator.InteriorGenerator(this, (ServerLevel) this.getInteriorDimension(), interior);
        generator.placeStructure((ServerLevel) this.getInteriorDimension(), new BlockPos(0, 0, 0), Direction.SOUTH);
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
        return this.interior == null;
    }

    public Level getInteriorDimension() {
        return this.getLevel().getServer().getLevel(DimensionsInit.TARDIS_DIM_KEY);
    }

    public static class Serializer {
        private static final NBTSerializers.AbsolutePosition ABSOLUTE_POSITION_SERIALIZER = new NBTSerializers.AbsolutePosition();
        public CompoundTag serialize(TARDIS tardis) {
            CompoundTag tag = new CompoundTag();
            this.serialize(tag,tardis);
            return tag;
        }
        public void serialize(CompoundTag nbt, TARDIS tardis) {
            nbt.putUUID("uuid", tardis.getUuid());
            ABSOLUTE_POSITION_SERIALIZER.serialize(nbt,tardis.pos);
        }

        public TARDIS deserialize(CompoundTag nbt) {
            return new TARDIS(nbt.getUUID("uuid"), ABSOLUTE_POSITION_SERIALIZER.deserialize(nbt));
        }
    }
}