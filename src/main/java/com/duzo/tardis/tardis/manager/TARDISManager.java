package com.duzo.tardis.tardis.manager;

import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.tardis.TARDIS;
import com.duzo.tardis.tardis.builder.TARDISBuilder;
import com.duzo.tardis.tardis.doors.blocks.InteriorDoorBlock;
import com.duzo.tardis.tardis.exteriors.TARDISExteriorSchema;
import com.duzo.tardis.tardis.interiors.TARDISInterior;
import com.duzo.tardis.tardis.nbt.TARDISSavedData;
import com.duzo.tardis.tardis.util.TARDISUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.INBTSerializable;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class TARDISManager implements INBTSerializable<CompoundTag> {
    private static final TARDISManager instance = new TARDISManager();
    private final TARDISMap tardisMap = new TARDISMap();
    private final TARDISSavedData savedData = new TARDISSavedData();
    private static final TARDISMap.Serializer MAP_SERIALIZER = new TARDISMap.Serializer();

    public static TARDISManager getInstance() {
        return instance;
    }

    /**
     * Creates a TARDIS
     * @param pos position and dimension where the TARDIS will be created
     * @param exteriorSchema The exterior schema to use | can be null and will use a default
     * @return the new TARDIS
     */
    public TARDIS create(AbsoluteBlockPos pos, @Nullable TARDISExteriorSchema<?> exteriorSchema, @Nullable TARDISInterior interior) {
        TARDIS tardis = new TARDISBuilder(UUID.randomUUID())
                .at(pos)
                .exterior(exteriorSchema)
                .interior(interior)
                .build();

        this.tardisMap.put(tardis);

        return tardis;
    }

    public TARDISMap getTARDISMap() {
        return this.tardisMap;
    }
    public TARDISSavedData getSavedData() {return this.savedData;}

    /**
     * Find TARDIS from its uuid
     * @param uuid
     * @return
     */
    public TARDIS findTARDIS(UUID uuid) {return this.tardisMap.get(uuid);}

    /**
     * Find TARDIS from its exterior position
     * @param pos
     * @return
     */
    public TARDIS findTARDIS(AbsoluteBlockPos pos) {
        for (TARDIS tardis : tardisMap.values()) {
            if (tardis.getPosition().equals(pos)) {
                return tardis;
            }
        }
        return null;
    }

    /**
     * Find TARDIS from its interior positions
     * @param cornerPositions
     * @return
     */
    public TARDIS findTARDIS(List<AbsoluteBlockPos> cornerPositions) {
        for (TARDIS tardis : tardisMap.values()) {
            if (tardis.getInteriorCornerPositions().equals(cornerPositions)) {
                return tardis;
            }
        }
        return null;
    }

    /**
     * Find a TARDIS from a position in the interior dimension
     * @param pos
     * @return
     */
    public TARDIS findTARDISFromInteriorCoordinate(AbsoluteBlockPos pos) {
        if (pos.getDimension() != TARDISUtil.getTARDISLevel()) {return null;}

        for (TARDIS tardis : tardisMap.values()) {
            if (tardis.getInteriorCornerPositions().contains(pos)) {
                return tardis;
            }
        }
        return null;
    }

    public List<AbsoluteBlockPos> getNextAvailableInteriorSpot() {
        List<AbsoluteBlockPos> list = new ArrayList<>();

        AbsoluteBlockPos bottomLeft = generateRandomPosInTARDISDim();
        AbsoluteBlockPos topRight = new AbsoluteBlockPos(TARDISUtil.getTARDISLevel(), bottomLeft.offset(256,0,256));

        list.add(bottomLeft);
        list.add(topRight);

        return list;
    }
    private AbsoluteBlockPos generateRandomPosInTARDISDim() {
        Random random = new Random();

        int x = random.nextInt(100000);
        int z = random.nextInt(100000);
        AbsoluteBlockPos pos = new AbsoluteBlockPos(TARDISUtil.getTARDISLevel(),new BlockPos(x,0,z));
        return pos;
    }

    @Override
    public CompoundTag serializeNBT() {
        System.out.println("Serialising NBT");
        CompoundTag nbt = new CompoundTag();
        MAP_SERIALIZER.serialize(nbt, this.getTARDISMap());
        this.getSavedData().setDirty(false);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        System.out.println("Deserialising NBT");
        TARDISManager manager = TARDISManager.getInstance();

        manager.getTARDISMap().set(MAP_SERIALIZER.deserialize(tag));
        manager.getSavedData().setDirty(false);
    }

    /**
     * Incredibly under-optimised its actually crazy
     * @param interiorCornerPositions
     * @return
     */
    public BlockPos searchForDoorBlock(List<AbsoluteBlockPos> interiorCornerPositions) {
        BlockPos bottomLeft = interiorCornerPositions.get(0);
        BlockPos topRight = interiorCornerPositions.get(1);
        BlockPos checkPos = bottomLeft;
        Level level = interiorCornerPositions.get(0).getDimension();

        // We want to check each row of these coordinates until we find a door block (hopefully)
        for (int y = bottomLeft.getY(); y < 256; y++) {
            for (int z = bottomLeft.getZ(); z <= topRight.getZ();z++) {
                for (int x = bottomLeft.getX(); x <= topRight.getX();x++) {
                    checkPos = new BlockPos(x,y,z);

                    if (level.getBlockState(checkPos).getBlock() instanceof InteriorDoorBlock) {
                        return checkPos;
                    }
                }
            }
        }

        return null;
    }

    public static class Serializer {
        private static final TARDISMap.Serializer MAP_SERIALIZER = new TARDISMap.Serializer();

        public void serialize(CompoundTag tag, TARDISManager manager) {
            MAP_SERIALIZER.serialize(tag, manager.getTARDISMap());
            manager.getSavedData().setDirty(false);
        }

        public TARDISManager deserialize(CompoundTag tag) {
            TARDISManager manager = TARDISManager.getInstance();

            manager.getTARDISMap().set(MAP_SERIALIZER.deserialize(tag));
            manager.getSavedData().setDirty(false);
            return manager;
        }
    }
}
