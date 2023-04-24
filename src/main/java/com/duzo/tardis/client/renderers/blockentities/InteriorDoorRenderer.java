package com.duzo.tardis.client.renderers.blockentities;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.client.models.blockentities.interior.doors.InteriorDoorModel;
import com.duzo.tardis.client.models.blockentities.interior.doors.DefaultInteriorDoorModel;
import com.duzo.tardis.tardis.blocks.doors.entities.InteriorDoorBlockEntity;
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
import net.minecraft.world.phys.Vec3;

public class InteriorDoorRenderer implements BlockEntityRenderer<InteriorDoorBlockEntity> {
    private final InteriorDoorModel model;
    public static final ResourceLocation DOOR = new ResourceLocation(TARDISMod.MODID, "textures/tardis/interior/door/default.png");

    public InteriorDoorRenderer(BlockEntityRendererProvider.Context ctx) {
        this.model = new DefaultInteriorDoorModel(ctx.bakeLayer(DefaultInteriorDoorModel.LAYER_LOCATION));
    }
    @Override
    public void render(InteriorDoorBlockEntity entity, float partialTick, PoseStack stack, MultiBufferSource source, int packedLight, int packedOverlay) {
        // Switcheroo as for some reason the direction gets bugged out for east and west
        Direction direction = (entity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING));

        if (direction == Direction.WEST) {direction = Direction.EAST;}
        else if (direction == Direction.EAST) {direction = Direction.WEST;}

        stack.mulPose(Vector3f.YP.rotationDegrees(direction.toYRot()));
        this.model.renderWithEntity(entity,stack, source.getBuffer(RenderType.entitySmoothCutout(DOOR)), LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY,1,1,1,1);
    }

    @Override
    public boolean shouldRenderOffScreen(InteriorDoorBlockEntity p_112306_) {
        return true;
    }

    @Override
    public boolean shouldRender(InteriorDoorBlockEntity p_173568_, Vec3 p_173569_) {
        return true;
    }
}
