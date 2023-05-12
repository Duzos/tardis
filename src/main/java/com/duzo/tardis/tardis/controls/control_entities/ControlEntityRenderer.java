package com.duzo.tardis.tardis.controls.control_entities;

import com.duzo.tardis.TARDISMod;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class ControlEntityRenderer extends EntityRenderer<ControlEntitySchema> {

    private static final ResourceLocation texture = new ResourceLocation(TARDISMod.MODID, "textures/tardis/console/borealis_console.png");

    @Override
    public void render(ControlEntitySchema entitySchema, float p_114486_, float p_114487_, PoseStack p_114488_, MultiBufferSource p_114489_, int p_114490_) {
        //entitySchema.setInvisible(true);
        super.render(entitySchema, p_114486_, p_114487_, p_114488_, p_114489_, p_114490_);
    }

    @Override
    protected void renderNameTag(ControlEntitySchema p_114498_, Component p_114499_, PoseStack stack, MultiBufferSource p_114501_, int p_114502_) {
        stack.pushPose();
        stack.scale(0.25f, 0.25f, 0.25f);
        if(p_114498_.getControlName().equals("Monitor")) {
            stack.translate(0, 0.5, 0);
        }
        super.renderNameTag(p_114498_, p_114499_, stack, p_114501_, 15728880);
        stack.popPose();
    }

    public ControlEntityRenderer(EntityRendererProvider.Context p_174008_) {
        super(p_174008_);
    }

    @Override
    public ResourceLocation getTextureLocation(ControlEntitySchema p_114482_) {
        return texture;
    }
}
