package com.duzo.tardis.client.models.blockentities;

import com.duzo.tardis.tardis.blocks.entities.ExteriorBlockEntity;
import com.duzo.tardis.tardis.blocks.entities.InteriorDoorBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.world.entity.Entity;

public abstract class InteriorDoorModel<T extends Entity> extends EntityModel<T> {
    public void renderWithEntity(InteriorDoorBlockEntity entity, PoseStack stack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.renderToBuffer(stack,vertexConsumer,packedLight,packedOverlay,red,green,blue,alpha);
    }
}
