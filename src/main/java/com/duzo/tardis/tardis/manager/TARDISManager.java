package com.duzo.tardis.tardis.manager;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.tardis.TARDIS;
import com.duzo.tardis.tardis.builder.TARDISBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;

import java.util.UUID;

public class TARDISManager {
    private static final TARDISManager instance = new TARDISManager();
    private final TARDISMap tardisMap = new TARDISMap();

    public static TARDISManager getInstance() {
        return instance;
    }

    /**
     * Creates a TARDIS
     * @param pos position and dimension where the TARDIS will be created
     * @return the new TARDIS
     */
    public TARDIS create(AbsoluteBlockPos pos) {
        TARDIS tardis = new TARDISBuilder(UUID.randomUUID()).at(pos).build();

        this.tardisMap.put(tardis);

        return tardis;
    }

    public TARDISMap getTARDISMap() {
        return this.tardisMap;
    }

    public TARDIS findTARDIS(UUID uuid) {return this.tardisMap.get(uuid);}
    public TARDIS findTARDIS(AbsoluteBlockPos pos) {
        for (TARDIS tardis : tardisMap.values()) {
            if (tardis.getPosition() == pos) {
                return tardis;
            }
        }
        return null;
    }

    public static class Serializer {
        private static final TARDISMap.Serializer MAP_SERIALIZER = new TARDISMap.Serializer();

        public void serialize(CompoundTag tag, TARDISManager manager) {
            MAP_SERIALIZER.serialize(tag, manager.getTARDISMap());
        }

        public TARDISManager deserialize(CompoundTag tag) {
            TARDISManager manager = TARDISManager.getInstance();

            manager.getTARDISMap().set(MAP_SERIALIZER.deserialize(tag));
            return manager;
        }
    }
}
