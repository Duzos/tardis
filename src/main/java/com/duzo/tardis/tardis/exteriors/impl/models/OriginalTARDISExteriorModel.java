package com.duzo.tardis.tardis.exteriors.impl.models;// Made with Blockbench 4.7.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.tardis.exteriors.TARDISExteriorModelSchema;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class OriginalTARDISExteriorModel extends TARDISExteriorModelSchema {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(TARDISMod.MODID, "original_exterior"), "main");
	private final ModelPart frame;
	private final ModelPart doors;

	public OriginalTARDISExteriorModel(ModelPart root) {
		this.frame = root.getChild("frame");
		this.doors = root.getChild("doors");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition frame = partdefinition.addOrReplaceChild("frame", CubeListBuilder.create().texOffs(52, 33).addBox(-13.0F, -28.0F, 13.0F, 14.0F, 32.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(1.0F, -28.0F, -2.0F, 1.0F, 32.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(18, 32).addBox(-14.0F, -28.0F, -2.0F, 1.0F, 32.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(35, 1).addBox(-13.0F, 3.0F, -2.0F, 14.0F, 1.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(36, 17).addBox(-13.0F, -28.0F, -2.0F, 14.0F, 1.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 20.0F, -6.0F));

		PartDefinition doors = partdefinition.addOrReplaceChild("doors", CubeListBuilder.create().texOffs(52, 66).addBox(0.0F, -31.0F, -8.0F, 7.0F, 30.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 48).addBox(-7.0F, -31.0F, -8.0F, 7.0F, 30.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}


	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		frame.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		doors.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public void setupAnim(Entity p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_, float p_102623_) {

	}
}