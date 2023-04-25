package com.duzo.tardis.tardis.exteriors;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.tardis.exteriors.blocks.entities.ExteriorBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public abstract class TARDISExteriorSchema<T extends TARDISExteriorModelSchema> {
    private final String id;
    private final Component name;

    public TARDISExteriorSchema(String id, String translation) {
        this.id = id;
        this.name = Component.translatable(translation);
    }

    protected abstract T model();

    public String getID() {return this.id;}
    public String getName() {return this.getName();}
    public void render(ExteriorBlockEntity entity, PoseStack stack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay) {
        this.model().renderWithEntity(entity,stack,vertexConsumer,packedLight,packedOverlay,1,1,1,1);
    }

    public ResourceLocation getTexture() {
        return new ResourceLocation(TARDISMod.MODID, "textures/tardis/exterior/" + this.getID() + ".png");
    }

    public static class Serializer {
        public void serialize(CompoundTag nbt, TARDISExteriorSchema<?> exterior) {
            nbt.putString("id", exterior.id);
        }
        public TARDISExteriorSchema<?> deserialize(CompoundTag nbt) {
            return TARDISExteriors.get(nbt.getString("id"));
        }
    }
}
