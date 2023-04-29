package com.duzo.tardis.tardis.doors;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.tardis.doors.blocks.InteriorDoorBlockEntity;
import com.duzo.tardis.tardis.doors.TARDISInteriorDoorSchema;
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
    public static final ResourceLocation DOOR = new ResourceLocation(TARDISMod.MODID, "textures/tardis/interior/door/classic.png");

    public InteriorDoorRenderer(BlockEntityRendererProvider.Context ctx) {}
    @Override
    public void render(InteriorDoorBlockEntity entity, float partialTick, PoseStack stack, MultiBufferSource source, int packedLight, int packedOverlay) {

        // Switcheroo as for some reason the direction gets bugged out for east and west
        Direction direction = (entity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING));

        if (direction == Direction.WEST) {direction = Direction.EAST;}
        else if (direction == Direction.EAST) {direction = Direction.WEST;}

        stack.mulPose(Vector3f.YP.rotationDegrees(direction.toYRot()));

        TARDISInteriorDoorSchema<?> schema = entity.getSchema();

        ResourceLocation texture = schema.getTexture();

        schema.render(entity,stack, source.getBuffer(RenderType.entityTranslucent(texture)), LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY);
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
