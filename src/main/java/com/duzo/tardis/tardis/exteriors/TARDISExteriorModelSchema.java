package com.duzo.tardis.tardis.exteriors;

import com.duzo.tardis.tardis.exteriors.blocks.entities.ExteriorBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;

public abstract class TARDISExteriorModelSchema extends EntityModel {
    public void renderWithEntity(ExteriorBlockEntity entity,PoseStack stack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.renderToBuffer(stack,vertexConsumer,packedLight,packedOverlay,red,green,blue,alpha);
    }
}
