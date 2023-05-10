package com.duzo.tardis.tardis.consoles;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.tardis.consoles.blocks.entities.ConsoleBlockEntity;
import com.duzo.tardis.tardis.consoles.impl.models.BorealisConsoleModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class ConsoleRenderer implements BlockEntityRenderer<ConsoleBlockEntity> {

    public ModelPart model;

    public float twirlAmount;

    private static final ResourceLocation texture = new ResourceLocation(TARDISMod.MODID, "textures/tardis/console/borealis_console.png");

    public ConsoleRenderer(BlockEntityRendererProvider.Context ctx) {
        model = ctx.bakeLayer(BorealisConsoleModel.LAYER_LOCATION);
    }

    @Override
    public void render(ConsoleBlockEntity entity, float partialTick, PoseStack stack, MultiBufferSource source, int packedLight, int packedOverlay) {
        stack.pushPose();
        Direction direction = (entity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING));
        stack.mulPose(Vector3f.YP.rotationDegrees(direction.toYRot()));

        ConsoleSchema<?> schema = entity.getSchema();

        if (schema == null) return;

        ResourceLocation texture = schema.getTexture();

        schema.render(entity,stack, source.getBuffer(RenderType.entityCutout(texture)), packedLight, OverlayTexture.NO_OVERLAY);
        stack.popPose();
    }

    @Override
    public boolean shouldRenderOffScreen(ConsoleBlockEntity console) {
        return true;
    }
}
