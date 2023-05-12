package com.duzo.tardis.tardis.consoles;

import com.duzo.tardis.tardis.consoles.blocks.entities.ConsoleBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;

public abstract class ConsoleModelSchema extends EntityModel {
    public void renderWithEntity(ConsoleBlockEntity entity, PoseStack stack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.renderToBuffer(stack,vertexConsumer,packedLight,packedOverlay,red,green,blue,alpha);
    }
}
