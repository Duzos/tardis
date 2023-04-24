package com.duzo.tardis.tardis.nbt;

import com.duzo.tardis.tardis.manager.TARDISManager;
import com.duzo.tardis.tardis.structures.TARDISStructure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.storage.DimensionDataStorage;

//public class TARDISSavedData extends SavedData {
//    private static final TARDISManager.Serializer MANAGER_SERIALIZER = new TARDISManager.Serializer();
//    @Override
//    public CompoundTag save(CompoundTag tag) {
//        MANAGER_SERIALIZER.serialize(tag, TARDISManager.getInstance());
//        return tag;
//    }
//
//    public static TARDISSavedData create() {
//        return new TARDISSavedData();
//    }
//
//    public static TARDISSavedData load(CompoundTag tag) {
//        TARDISSavedData data = create();
//        MANAGER_SERIALIZER.deserialize(tag);
//        return data;
//    }
//    /*
//     * #server-side ONLY
//     * Gets current instance of the saved data
//     * Return new instance when on client
//     */
//    public static TARDISSavedData getInstance(LevelAccessor level) {
//        MinecraftServer server = level.getServer();
//        if (server == null) {
//            return create();
//        }
//        return server.overworld().getDataStorage().computeIfAbsent(TARDISSavedData::load, TARDISSavedData::create, "tardis-data");
//    }
//}
