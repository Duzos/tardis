package com.duzo.tardis.tardis.controls;

import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.tardis.TARDIS;
import com.duzo.tardis.tardis.controls.blocks.ControlBlock;
import com.duzo.tardis.tardis.controls.blocks.ControlBlockEntity;
import com.duzo.tardis.tardis.doors.TARDISInteriorDoorSchema;
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

public class ControlRenderer implements BlockEntityRenderer<ControlBlockEntity> {
    public ControlRenderer(BlockEntityRendererProvider.Context ctx) {}

    @Override
    public void render(ControlBlockEntity entity, float partialTick, PoseStack stack, MultiBufferSource source, int packedLight, int packedOverlay) {
        // Switcheroo as for some reason the direction gets bugged out for east and west
        Direction direction = (entity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING));

        if (direction == Direction.WEST) {direction = Direction.EAST;}
        else if (direction == Direction.EAST) {direction = Direction.WEST;}

        stack.mulPose(Vector3f.YP.rotationDegrees(direction.toYRot()));

        TARDISControlSchema<?> schema = entity.getSchema();

        ResourceLocation texture = schema.getTexture();

        schema.render(entity,stack, source.getBuffer(RenderType.entityTranslucent(texture)), LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY);
    }
}
