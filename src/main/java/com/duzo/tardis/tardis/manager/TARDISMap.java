package com.duzo.tardis.tardis.manager;

import com.duzo.tardis.tardis.TARDIS;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class TARDISMap extends HashMap<UUID, TARDIS> {
    // icl i copied most of this from AIT but dont tell anyone pretty please
    // i meann its not thaaat bad if i work for them, right?
    private final List<UUID> reference = new ArrayList<>();

    @Override
    public TARDIS put(UUID key, TARDIS value) {
        this.reference.add(key);
        return super.put(key,value);
    }

    public TARDIS put(TARDIS value) {
        return this.put(value.getUuid(), value);
    }

    public List<UUID> getReference() {return reference;}

    /**
     * Empties the current map and copies the content of the provided map into this one
     * @param map The map to copy from
     */
    public void set(TARDISMap map) {
        this.clear();
        this.reference.clear();

        this.putAll(map);
        this.reference.addAll(map.reference);
    }

    public static class Serializer {
        private static final TARDIS.Serializer TARDIS_SERIALIZER = new TARDIS.Serializer();

        public void serialize(CompoundTag tag, TARDISMap map) {
            ListTag tardisNBTs = new ListTag();
            map.forEach(((uuid, tardis) -> tardisNBTs.add(TARDIS_SERIALIZER.serialize(tardis))));

            ListTag referenceNBTs = new ListTag();
            map.getReference().forEach(uuid -> {
                CompoundTag compound = new CompoundTag();
                compound.putUUID("uuid",uuid);

                referenceNBTs.add(compound);
            });

            tag.put("tardises", tardisNBTs);
            tag.put("refererences",referenceNBTs);
        }
        public TARDISMap deserialize(CompoundTag nbt) {
            TARDISMap map = new TARDISMap();
            nbt.getList("tardises", CompoundTag.TAG_COMPOUND)
                    .forEach(inbt -> map.put(TARDIS_SERIALIZER.deserialize((CompoundTag) inbt)));
            nbt.getList("references", CompoundTag.TAG_COMPOUND)
                    .forEach(inbt -> map.getReference().add(((CompoundTag) inbt).getUUID("uuid")));

            return map;
        }
    }
}
