package com.duzo.tardis.client.models.renderers.blockentities;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.client.models.blockentities.exteriors.DefaultExteriorModel;
import com.duzo.tardis.client.models.blockentities.ExteriorModel;
import com.duzo.tardis.tardis.blocks.entities.ExteriorBlockEntity;
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
    private final ExteriorModel model;
    public static final ResourceLocation EXTERIOR = new ResourceLocation(TARDISMod.MODID, "textures/tardis/exterior/default.png");

    public ExteriorRenderer(BlockEntityRendererProvider.Context ctx) {
        this.model = new DefaultExteriorModel(ctx.bakeLayer(DefaultExteriorModel.LAYER_LOCATION));
    }

    @Override
    public void render(ExteriorBlockEntity entity, float partialTick, PoseStack stack, MultiBufferSource source, int packedLight, int packedOverlay) {
        // Switcheroo as for some reason the direction gets bugged out for east and west
        Direction direction = (entity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING));

        if (direction == Direction.WEST) {direction = Direction.EAST;}
        else if (direction == Direction.EAST) {direction = Direction.WEST;}

        stack.mulPose(Vector3f.YP.rotationDegrees(direction.toYRot()));
        this.model.renderWithEntity(entity,stack, source.getBuffer(RenderType.entitySmoothCutout(EXTERIOR)), LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY,1,1,1,1);
    }

    @Override
    public boolean shouldRenderOffScreen(ExteriorBlockEntity p_112306_) {
        return true;
    }
}
