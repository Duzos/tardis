package com.duzo.tardis.tardis.controls;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.tardis.controls.blocks.ControlBlockEntity;
import com.duzo.tardis.tardis.doors.TARDISInteriorDoorModelSchema;
import com.duzo.tardis.tardis.doors.TARDISInteriorDoorSchema;
import com.duzo.tardis.tardis.doors.TARDISInteriorDoors;
import com.duzo.tardis.tardis.doors.blocks.InteriorDoorBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.AnimationState;

public abstract class TARDISControlSchema<T extends TARDISControlModelSchema> {
    private final String id;
    private final Component name;

    public TARDISControlSchema(String id, String translation) {
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
    public AnimationState getAnimationToBeRan(ControlBlockEntity control) {return null;}

    public void render(ControlBlockEntity entity, PoseStack stack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay) {
        this.model().renderWithEntity(entity, stack, vertexConsumer, packedLight, packedOverlay, 1, 1, 1, 1);
    }

    public ResourceLocation getTexture() {
        return new ResourceLocation(TARDISMod.MODID, "textures/tardis/controls/" + this.getID() + ".png");
    }

    public static class Serializer {
        public void serialize(CompoundTag nbt, TARDISControlSchema<?> control) {
            nbt.putString("id", control.id);
        }

        public TARDISControlSchema<?> deserialize(CompoundTag nbt) {
            return TARDISControls.get(nbt.getString("id"));
        }
    }
}
