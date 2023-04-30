package com.duzo.tardis.tardis.exteriors;

import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.tardis.TARDIS;
import com.duzo.tardis.tardis.exteriors.TARDISExteriorSchema;
import com.duzo.tardis.tardis.exteriors.blocks.entities.ExteriorBlockEntity;
import com.duzo.tardis.tardis.manager.TARDISManager;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class ExteriorRenderer implements BlockEntityRenderer<ExteriorBlockEntity> {
    public ExteriorRenderer(BlockEntityRendererProvider.Context ctx) {}

    @Override
    public void render(ExteriorBlockEntity entity, float partialTick, PoseStack stack, MultiBufferSource source, int packedLight, int packedOverlay) {
        Direction direction = (entity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING));

        stack.mulPose(Vector3f.YP.rotationDegrees(direction.toYRot()));

        TARDIS tardis = TARDISManager.getInstance().findTARDIS(new AbsoluteBlockPos(entity.getLevel(),entity.getBlockPos()));

        if (tardis == null) {return;}

//        tardis.logDebug();

        TARDISExteriorSchema<?> schema = tardis.getExteriorSchema();

        ResourceLocation texture = schema.getTexture();

        schema.render(entity,stack, source.getBuffer(RenderType.entityTranslucentCull(texture)), LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY);
    }

    @Override
    public boolean shouldRenderOffScreen(ExteriorBlockEntity p_112306_) {
        return true;
    }
}
