package com.duzo.tardis.tardis.controls.control_entities;

import com.duzo.tardis.TARDISMod;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class ControlEntityRenderer extends EntityRenderer<ControlEntitySchema> {

    private static final ResourceLocation texture = new ResourceLocation(TARDISMod.MODID, "textures/tardis/console/borealis_console.png");

    @Override
    public void render(ControlEntitySchema entitySchema, float p_114486_, float p_114487_, PoseStack p_114488_, MultiBufferSource p_114489_, int p_114490_) {
        //entitySchema.setInvisible(true);
        super.render(entitySchema, p_114486_, p_114487_, p_114488_, p_114489_, p_114490_);
    }

    public ControlEntityRenderer(EntityRendererProvider.Context p_174008_) {
        super(p_174008_);
    }

    @Override
    public ResourceLocation getTextureLocation(ControlEntitySchema p_114482_) {
        return texture;
    }
}
