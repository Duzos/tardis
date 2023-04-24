package com.duzo.tardis.tardis.manager;

import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.tardis.TARDIS;
import com.duzo.tardis.tardis.builder.TARDISBuilder;
import com.duzo.tardis.tardis.exteriors.TARDISExteriorSchema;
import com.duzo.tardis.tardis.exteriors.TARDISExteriors;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.util.INBTSerializable;
import org.checkerframework.checker.units.qual.C;

import javax.annotation.Nullable;
import java.util.UUID;

public class TARDISManager implements INBTSerializable<CompoundTag> {
    private static final TARDISManager instance = new TARDISManager();
    private final TARDISMap tardisMap = new TARDISMap();
//    private final TARDISSavedData savedData = new TARDISSavedData();
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
    public TARDIS create(AbsoluteBlockPos pos, @Nullable TARDISExteriorSchema<?> exteriorSchema) {
        TARDIS tardis = new TARDISBuilder(UUID.randomUUID()).at(pos).exterior(exteriorSchema).build();

        this.tardisMap.put(tardis);

        return tardis;
    }

    public TARDISMap getTARDISMap() {
        return this.tardisMap;
    }
//    public TARDISSavedData getSavedData() {return this.savedData;}

    public TARDIS findTARDIS(UUID uuid) {return this.tardisMap.get(uuid);}
    public TARDIS findTARDIS(AbsoluteBlockPos pos) {
        for (TARDIS tardis : tardisMap.values()) {
            if (tardis.getPosition().equals(pos)) {
                return tardis;
            }
        }
        return null;
    }

    @Override
    public CompoundTag serializeNBT() {
        System.out.println("Serialising NBT");
        CompoundTag nbt = new CompoundTag();
        MAP_SERIALIZER.serialize(nbt, this.getTARDISMap());
//        this.getSavedData().setDirty(false);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        System.out.println("Deserialising NBT");
        TARDISManager manager = TARDISManager.getInstance();

        manager.getTARDISMap().set(MAP_SERIALIZER.deserialize(tag));
//        manager.getSavedData().setDirty(false);
    }

//    public static class Serializer {
//        private static final TARDISMap.Serializer MAP_SERIALIZER = new TARDISMap.Serializer();
//
//        @Override
//        public void serializeNBT(CompoundTag tag, TARDISManager manager) {
//            MAP_SERIALIZER.serialize(tag, manager.getTARDISMap());
//            manager.getSavedData().setDirty(false);
//        }
//
//        public TARDISManager deserialize(CompoundTag tag) {
//            TARDISManager manager = TARDISManager.getInstance();
//
//            manager.getTARDISMap().set(MAP_SERIALIZER.deserialize(tag));
//            manager.getSavedData().setDirty(false);
//            return manager;
//        }
//    }
}
