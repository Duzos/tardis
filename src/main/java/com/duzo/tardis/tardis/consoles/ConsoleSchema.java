package com.duzo.tardis.tardis.consoles;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.tardis.consoles.ConsoleModelSchema;
import com.duzo.tardis.tardis.consoles.blocks.entities.ConsoleBlockEntity;
import com.duzo.tardis.tardis.exteriors.TARDISExteriorSchema;
import com.duzo.tardis.tardis.exteriors.TARDISExteriors;
import com.duzo.tardis.tardis.exteriors.blocks.entities.ExteriorBlockEntity;
import com.duzo.tardis.tardis.interiors.TARDISInterior;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public abstract class ConsoleSchema<T extends ConsoleModelSchema> {
    private final String id;
    private final Component name;

    public ConsoleSchema(String id, String translation) {
        this.id = id;
        this.name = Component.translatable(translation);
    }

    protected abstract T model();

    public String getID() {return this.id;}
    public String getName() {return this.getName();}

    public void render(ConsoleBlockEntity entity, PoseStack stack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay) {
//        System.out.println(entity.getLevel().isClientSide);
//        System.out.println(entity.getAlpha());
        this.model().renderWithEntity(entity, stack,vertexConsumer,packedLight,packedOverlay,1,1,1,1);
    }

    public ResourceLocation getTexture() {
        return new ResourceLocation(TARDISMod.MODID, "textures/tardis/console/" + this.getID() + ".png");
    }
    public ResourceLocation getEmission() {
        return new ResourceLocation(TARDISMod.MODID, "textures/tardis/console/" + this.getID() + "_emission.png");
    }

    public static class Serializer {
        public void serialize(CompoundTag nbt, ConsoleSchema<?> console) {
            nbt.putString("id", console.id);
        }
        public ConsoleSchema<?> deserialize(CompoundTag nbt) {
            return Consoles.get(nbt.getString("id"));
        }
    }
}
