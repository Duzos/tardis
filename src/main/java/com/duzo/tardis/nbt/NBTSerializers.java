package com.duzo.tardis.nbt;

import com.duzo.tardis.core.util.AbsoluteBlockPos;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.RegistryObject;

public class NBTSerializers {

    public static class Dimension {

        public void serialize(CompoundTag nbt, ResourceKey<Level> registryKey) {
            CompoundTag dimension = new CompoundTag();
            dimension.putString("name", registryKey.registry().toString());
            dimension.putString("location", registryKey.location().toString());

            nbt.put("dimension", dimension);
        }

        public ResourceKey<Level> deserialize(CompoundTag nbt) {
            CompoundTag dimension = nbt.getCompound("dimension");

            return ResourceKey.create(
                    ResourceKey.createRegistryKey(new ResourceLocation(dimension.getString("name"))),
                    new ResourceLocation(dimension.getString("location")));
        }
    }

    public static class Position {

        public void serialize(CompoundTag nbt, BlockPos pos) {
            this.serialize(nbt, "Pos", pos);
        }

        /**
         * This method is only used internally by {@link AbsolutePosition} to avoid code duplication.
         *
         * @param nbt NBT that this position will serialize to.
         * @param id id that will be used to store the position.
         * @param pos position that will be serialized.
         */
        private void serialize(CompoundTag nbt, String id, BlockPos pos) {
            nbt.put(id, NbtUtils.writeBlockPos(pos));
        }

        public BlockPos deserialize(CompoundTag nbt) {
            return this.unserialize(nbt, "Pos");
        }

        /**
         * This method is only used internally by {@link AbsolutePosition} to avoid code duplication.
         *
         * @param nbt NBT that this position will deserialize to.
         * @param id id that will be used to get the position.
         */
        private BlockPos unserialize(CompoundTag nbt, String id) {
            return NbtUtils.readBlockPos(nbt.getCompound(id));
        }
    }

    public static class AbsolutePosition {
        private static final NBTSerializers.Dimension DIMENSION_SERIALIZER = new NBTSerializers.Dimension();
        private static final NBTSerializers.Position POSITION_SERIALIZER = new NBTSerializers.Position();

        public void serialize(CompoundTag nbt, AbsoluteBlockPos pos) {
            CompoundTag absolutePos = new CompoundTag();
            POSITION_SERIALIZER.serialize(absolutePos, "at", pos);
            DIMENSION_SERIALIZER.serialize(absolutePos, pos.getResourceKeyLevel());

            nbt.put("Pos", absolutePos);
        }

        public AbsoluteBlockPos deserialize(CompoundTag nbt) {
            return new AbsoluteBlockPos(
                    DIMENSION_SERIALIZER.deserialize(nbt), POSITION_SERIALIZER.unserialize(nbt, "at"));
        }
    }
}
