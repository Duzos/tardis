package com.duzo.tardis.client.models;

import com.duzo.tardis.tardis.exteriors.blocks.entities.ExteriorBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.world.level.block.entity.BlockEntity;

public abstract class GenericModel extends EntityModel {
    public void renderWithEntity(BlockEntity entity, PoseStack stack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.renderToBuffer(stack,vertexConsumer,packedLight,packedOverlay,red,green,blue,alpha);
    }
}
