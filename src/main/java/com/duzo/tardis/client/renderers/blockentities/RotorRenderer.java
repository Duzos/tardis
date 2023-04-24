package com.duzo.tardis.client.renderers.blockentities;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.client.models.blockentities.exteriors.DefaultExteriorModel;
import com.duzo.tardis.client.models.blockentities.exteriors.ExteriorModel;
import com.duzo.tardis.client.models.blockentities.interior.rotors.CoralTimeRotorModel;
import com.duzo.tardis.client.models.blockentities.interior.rotors.RotorModel;
import com.duzo.tardis.tardis.blocks.doors.entities.InteriorDoorBlockEntity;
import com.duzo.tardis.tardis.blocks.rotors.entities.RotorBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class RotorRenderer implements BlockEntityRenderer<RotorBlockEntity> {
    private final RotorModel model;
    public static final ResourceLocation ROTOR = new ResourceLocation(TARDISMod.MODID, "textures/tardis/interior/rotor/coral.png");

    public RotorRenderer(BlockEntityRendererProvider.Context ctx) {
        this.model = new CoralTimeRotorModel(ctx.bakeLayer(CoralTimeRotorModel.LAYER_LOCATION));
    }
    @Override
    public void render(RotorBlockEntity entity, float partialTick, PoseStack stack, MultiBufferSource source, int packedLight, int packedOverlay) {
        this.model.renderToBuffer(stack, source.getBuffer(RenderType.entitySmoothCutout(ROTOR)), packedLight, OverlayTexture.NO_OVERLAY,1,1,1,1);
    }
}
