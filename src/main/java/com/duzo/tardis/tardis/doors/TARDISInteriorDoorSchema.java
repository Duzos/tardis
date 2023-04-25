package com.duzo.tardis.tardis.doors;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.tardis.doors.blocks.InteriorDoorBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public abstract class TARDISInteriorDoorSchema<T extends TARDISInteriorDoorModelSchema> {
    private final String id;
    private final Component name;

    public TARDISInteriorDoorSchema(String id, String translation) {
        this.id = id;
        this.name = Component.translatable(translation);
    }

    protected abstract T model();

    public String getID() {
        return this.id;
    }

    public String getName() {
        return this.getName();
    }

    public void render(InteriorDoorBlockEntity entity, PoseStack stack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay) {
        this.model().renderWithEntity(entity, stack, vertexConsumer, packedLight, packedOverlay, 1, 1, 1, 1);
    }

    public ResourceLocation getTexture() {
        return new ResourceLocation(TARDISMod.MODID, "textures/tardis/interior/door/" + this.getID() + ".png");
    }

    public static class Serializer {
        public void serialize(CompoundTag nbt, TARDISInteriorDoorSchema<?> door) {
            nbt.putString("id", door.id);
        }

        public TARDISInteriorDoorSchema<?> deserialize(CompoundTag nbt) {
            return TARDISInteriorDoors.get(nbt.getString("id"));
        }
    }
}
