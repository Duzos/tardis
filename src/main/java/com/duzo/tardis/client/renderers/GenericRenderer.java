package com.duzo.tardis.client.renderers;

import com.duzo.tardis.client.models.GenericModel;
import com.duzo.tardis.common.blocks.entities.GenericBlockEntity;
import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.tardis.TARDIS;
import com.duzo.tardis.tardis.exteriors.TARDISExteriorSchema;
import com.duzo.tardis.tardis.exteriors.blocks.entities.ExteriorBlockEntity;
import com.duzo.tardis.tardis.manager.TARDISManager;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;

public class GenericRenderer implements BlockEntityRenderer<GenericBlockEntity> {
    public GenericRenderer(BlockEntityRendererProvider.Context ctx) {}

    @Override
    public void render(GenericBlockEntity entity, float partialTick, PoseStack stack, MultiBufferSource source, int packedLight, int packedOverlay) {
        Direction direction = (entity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING));

        stack.mulPose(Vector3f.YP.rotationDegrees(direction.toYRot()));

        GenericModel schema = entity.model();

        ResourceLocation texture = entity.texture();

        schema.renderWithEntity(entity,stack, source.getBuffer(RenderType.entityTranslucentCull(texture)), packedLight, OverlayTexture.NO_OVERLAY,1,1,1,1);
    }

    @Override
    public boolean shouldRenderOffScreen(GenericBlockEntity p_112306_) {
        return true;
    }

    @Override
    public boolean shouldRender(GenericBlockEntity p_173568_, Vec3 p_173569_) {
        return true;
    }
}
