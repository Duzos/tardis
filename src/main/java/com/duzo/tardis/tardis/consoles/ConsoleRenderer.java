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
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class ConsoleRenderer implements BlockEntityRenderer<ConsoleBlockEntity> {

    public ModelPart model;

    private static final ResourceLocation texture = new ResourceLocation(TARDISMod.MODID, "textures/tardis/console/borealis_console.png");

    public ConsoleRenderer(BlockEntityRendererProvider.Context ctx) {
        model = ctx.bakeLayer(BorealisConsoleModel.LAYER_LOCATION);
    }

    @Override
    public void render(ConsoleBlockEntity entity, float partialTick, PoseStack stack, MultiBufferSource source, int packedLight, int packedOverlay) {
        Direction direction = (entity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING));

        stack.mulPose(Vector3f.YP.rotationDegrees(direction.toYRot()));
        stack.mulPose(Vector3f.XP.rotationDegrees(180f));
        stack.translate(-0.5, -0.75, 0.5);
        stack.scale(0.5f, 0.5f, 0.5f);

        //ConsoleSchema<?> schema = entity.getSchema();

        //ResourceLocation texture = schema.getTexture();
        //ResourceLocation emission = schema.getEmission();

        BorealisConsoleModel consoleModel = new BorealisConsoleModel(model);

        /*if(entity.rotorTick <= 0) {
            entity.rotorTick++;
        } else if(entity.rotorTick >= 150) {
            entity.rotorTick--;
        }*/

        if (entity.rotorState == EnumRotorState.DOWN) {
            if (entity.rotorTick < 0f/*1.5f*/) {
                entity.rotorTick += 0.0015f;
            } else {
                entity.rotorTick = 0f/*1.5f*/;
                entity.rotorState = EnumRotorState.UP;
            }
        }
        if (entity.rotorState == EnumRotorState.UP) {
            if (entity.rotorTick > -0.45f) {
                entity.rotorTick -= 0.0015f;
            } else {
                entity.rotorTick = -0.45f;
                entity.rotorState = EnumRotorState.DOWN;
            }
        }

        stack.pushPose();
        consoleModel.rotor.yRot = (float) Math.toRadians(entity.getRotorTicking());
        //consoleModel.rotor.y = entity.rotorTick / 1.25f;
        stack.translate(0, -entity.rotorTick / 1.25f, 0);
        //stack.mulPose(Vector3f.YP.rotationDegrees(entity.getRotorTicking()));
        consoleModel.rotor.render(stack, source.getBuffer(RenderType.entityTranslucentCull(texture)), packedLight, packedOverlay, 1, 1, 1, 1);
        stack.popPose();
        //schema.render(entity,stack, source.getBuffer(RenderType.entityTranslucentCull(texture)), packedLight, OverlayTexture.NO_OVERLAY);
        //schema.render(entity,stack, source.getBuffer(RenderType.entityTranslucentEmissive(emission,false)), LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY);
        consoleModel.renderToBuffer(stack, source.getBuffer(RenderType.entityTranslucentCull(texture)), packedLight, packedOverlay, 1, 1, 1, 1);
    }

    @Override
    public boolean shouldRenderOffScreen(ConsoleBlockEntity console) {
        return true;
    }
}
