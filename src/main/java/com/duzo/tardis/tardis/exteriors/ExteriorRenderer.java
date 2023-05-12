package com.duzo.tardis.tardis.exteriors;

import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.tardis.TARDIS;
import com.duzo.tardis.tardis.exteriors.TARDISExteriorSchema;
import com.duzo.tardis.tardis.exteriors.blocks.entities.ExteriorBlockEntity;
import com.duzo.tardis.tardis.manager.TARDISManager;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.awt.font.FontRenderContext;

public class ExteriorRenderer implements BlockEntityRenderer<ExteriorBlockEntity> {

    private final Font font;

    public ExteriorRenderer(BlockEntityRendererProvider.Context ctx) {
        this.font = ctx.getFont();
    }

    @Override
    public void render(ExteriorBlockEntity entity, float partialTick, PoseStack stack, MultiBufferSource source, int packedLight, int packedOverlay) {
        Direction direction = (entity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING));

        stack.mulPose(Vector3f.YP.rotationDegrees(direction.toYRot()));

        TARDIS tardis = TARDISManager.getInstance().findTARDIS(new AbsoluteBlockPos(entity.getLevel(),entity.getBlockPos()));

        if (tardis == null) {return;}

//        tardis.logDebug();

        TARDISExteriorSchema<?> schema = tardis.getExteriorSchema();

        ResourceLocation texture = schema.getTexture();
        ResourceLocation emission = schema.getEmission();


        stack.pushPose();
        stack.translate(-1, 0, -1);
        ppcbText(stack, source);
        stack.popPose();
        schema.render(entity,stack, source.getBuffer(RenderType.entityTranslucentCull(texture)), packedLight, OverlayTexture.NO_OVERLAY);
        schema.render(entity,stack, source.getBuffer(RenderType.entityTranslucentEmissive(emission,false)), LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY);
    }

    @Override
    public boolean shouldRenderOffScreen(ExteriorBlockEntity p_112306_) {
        return true;
    }

    public void ppcbText(PoseStack stack, MultiBufferSource Buffer) {
        float f = 0.31f;
        float f1 = 2.595f;
        float f2 = 0.0925f;
        String ppcb = "POLICE -=- BOX";
        stack.pushPose();
        stack.translate(f2 * 10, f1, -f);
        stack.scale(0.0125f, 0.0125f, 0.0125f);
        stack.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        stack.mulPose(Vector3f.YP.rotationDegrees(180.0f));
        this.font.drawInBatch(ppcb, -5, 5, 16777215, false, stack.last().pose(), Buffer, false, 0, 15728880);
        stack.popPose();
        stack.pushPose();
        stack.translate(1 + f, f1, f2 * 10);
        stack.scale(0.0125f, 0.0125f, 0.0125f);
        stack.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        stack.mulPose(Vector3f.YP.rotationDegrees(-90.0f));
        this.font.drawInBatch(ppcb, -5, 5, 16777215, false, stack.last().pose(), Buffer, false, 0, 15728880);
        stack.popPose();
        stack.pushPose();
        stack.translate(-f, f1, f2);
        stack.scale(0.0125f, 0.0125f, 0.0125f);
        stack.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        stack.mulPose(Vector3f.YP.rotationDegrees(90.0f));
        this.font.drawInBatch(ppcb, -5, 5, 16777215, false, stack.last().pose(), Buffer, false, 0, 15728880);
        stack.popPose();
        stack.pushPose();
        stack.translate(f2, f1, 1 + f);
        stack.scale(0.0125f, 0.0125f, 0.0125f);
        stack.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        this.font.drawInBatch(ppcb, -5, 5, 16777215, false, stack.last().pose(), Buffer, false, 0, 15728880);
        stack.popPose();
    }
}
