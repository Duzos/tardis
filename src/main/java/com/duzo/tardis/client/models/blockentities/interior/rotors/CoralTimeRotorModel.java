package com.duzo.tardis.client.models.blockentities.interior.rotors;// Made with Blockbench 4.7.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.client.models.blockentities.interior.rotors.RotorModel;
import com.duzo.tardis.tardis.blocks.rotors.entities.RotorBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class CoralTimeRotorModel extends RotorModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(TARDISMod.MODID, "coral_time_rotor"), "main");
	private final ModelPart rotorbottomstrips;
	private final ModelPart rotorbottomstrips2;
	private final ModelPart bb_main;

	public CoralTimeRotorModel(ModelPart root) {
		this.rotorbottomstrips = root.getChild("rotorbottomstrips");
		this.rotorbottomstrips2 = root.getChild("rotorbottomstrips2");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition rotorbottomstrips = partdefinition.addOrReplaceChild("rotorbottomstrips", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = rotorbottomstrips.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(54, 36).addBox(-7.0F, -24.0F, -1.0F, 2.0F, 35.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, 0.0F, 0.25F, 0.0F, -2.618F, 0.0F));

		PartDefinition cube_r2 = rotorbottomstrips.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(63, 34).addBox(5.0F, -24.0F, -1.0F, 2.0F, 35.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, 0.0F, -0.25F, 0.0F, -2.618F, 0.0F));

		PartDefinition cube_r3 = rotorbottomstrips.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(70, 70).addBox(5.0F, -24.0F, -1.0F, 2.0F, 35.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, 0.0F, 0.25F, 0.0F, 2.618F, 0.0F));

		PartDefinition cube_r4 = rotorbottomstrips.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(72, 0).addBox(-7.0F, -24.0F, -1.0F, 2.0F, 35.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, 0.0F, -0.25F, 0.0F, 2.618F, 0.0F));

		PartDefinition cube_r5 = rotorbottomstrips.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(61, 72).addBox(5.0F, -24.0F, -1.0F, 2.0F, 35.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.25F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r6 = rotorbottomstrips.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 74).addBox(-7.0F, -24.0F, -1.0F, 2.0F, 35.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -0.25F, 0.0F, 1.5708F, 0.0F));

		PartDefinition rotorringbottom2 = rotorbottomstrips.addOrReplaceChild("rotorringbottom2", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, 0.0F));

		PartDefinition cube_r7 = rotorringbottom2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(104, 60).addBox(-7.75F, -15.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(104, 70).addBox(-0.25F, -15.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -2.618F, 0.0F));

		PartDefinition cube_r8 = rotorringbottom2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(10, 21).addBox(7.75F, -15.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition cube_r9 = rotorringbottom2.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 21).addBox(7.75F, -15.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, -3.1416F));

		PartDefinition cube_r10 = rotorringbottom2.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(5, 21).addBox(-8.75F, -15.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r11 = rotorringbottom2.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 24).addBox(7.75F, -15.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(5, 24).addBox(-8.75F, -15.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -2.0944F, 0.0F));

		PartDefinition cube_r12 = rotorringbottom2.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(10, 24).addBox(7.75F, -15.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 2.0944F, 0.0F));

		PartDefinition cube_r13 = rotorringbottom2.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(104, 80).addBox(-0.25F, -15.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(104, 90).addBox(-7.75F, -15.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 2.618F, 0.0F));

		PartDefinition cube_r14 = rotorringbottom2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(104, 100).addBox(-0.25F, -15.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(106, 2).addBox(-7.75F, -15.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition rotorringbottom3 = rotorbottomstrips.addOrReplaceChild("rotorringbottom3", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition cube_r15 = rotorringbottom3.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(97, 30).addBox(-7.75F, -15.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(97, 40).addBox(-0.25F, -15.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -2.618F, 0.0F));

		PartDefinition cube_r16 = rotorringbottom3.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 12).addBox(7.75F, -15.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition cube_r17 = rotorringbottom3.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(5, 12).addBox(7.75F, -15.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, -3.1416F));

		PartDefinition cube_r18 = rotorringbottom3.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(10, 12).addBox(-8.75F, -15.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r19 = rotorringbottom3.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(0, 18).addBox(7.75F, -15.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(5, 18).addBox(-8.75F, -15.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -2.0944F, 0.0F));

		PartDefinition cube_r20 = rotorringbottom3.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(10, 18).addBox(7.75F, -15.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 2.0944F, 0.0F));

		PartDefinition cube_r21 = rotorringbottom3.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(97, 50).addBox(-0.25F, -15.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(79, 98).addBox(-7.75F, -15.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 2.618F, 0.0F));

		PartDefinition cube_r22 = rotorringbottom3.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(34, 102).addBox(-0.25F, -15.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(1, 104).addBox(-7.75F, -15.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition rotorbottomstrips2 = partdefinition.addOrReplaceChild("rotorbottomstrips2", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r23 = rotorbottomstrips2.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(0, 36).addBox(-7.0F, -11.0F, -1.0F, 2.0F, 35.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, -48.0F, 0.25F, 0.0F, -2.618F, 0.0F));

		PartDefinition cube_r24 = rotorbottomstrips2.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(9, 36).addBox(5.0F, -11.0F, -1.0F, 2.0F, 35.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, -48.0F, -0.25F, 0.0F, -2.618F, 0.0F));

		PartDefinition cube_r25 = rotorbottomstrips2.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(18, 36).addBox(5.0F, -11.0F, -1.0F, 2.0F, 35.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, -48.0F, 0.25F, 0.0F, 2.618F, 0.0F));

		PartDefinition cube_r26 = rotorbottomstrips2.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(27, 36).addBox(-7.0F, -11.0F, -1.0F, 2.0F, 35.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, -48.0F, -0.25F, 0.0F, 2.618F, 0.0F));

		PartDefinition cube_r27 = rotorbottomstrips2.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(36, 36).addBox(5.0F, -11.0F, -1.0F, 2.0F, 35.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -48.0F, 0.25F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r28 = rotorbottomstrips2.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(45, 36).addBox(-7.0F, -11.0F, -1.0F, 2.0F, 35.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -48.0F, -0.25F, 0.0F, 1.5708F, 0.0F));

		PartDefinition rotorringbottom4 = rotorbottomstrips2.addOrReplaceChild("rotorringbottom4", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, 0.0F));

		PartDefinition cube_r29 = rotorringbottom4.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(81, 0).addBox(-7.75F, 14.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(81, 10).addBox(-0.25F, 14.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -50.0F, 0.0F, 0.0F, -2.618F, 0.0F));

		PartDefinition cube_r30 = rotorringbottom4.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(0, 9).addBox(7.75F, 14.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -50.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition cube_r31 = rotorringbottom4.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(5, 9).addBox(7.75F, 14.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -50.0F, 0.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r32 = rotorringbottom4.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(10, 0).addBox(-8.75F, 14.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -50.0F, 0.0F, 3.1416F, 0.0F, -3.1416F));

		PartDefinition cube_r33 = rotorringbottom4.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(10, 3).addBox(7.75F, 14.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(10, 6).addBox(-8.75F, 14.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -50.0F, 0.0F, 0.0F, -2.0944F, 0.0F));

		PartDefinition cube_r34 = rotorringbottom4.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(10, 9).addBox(7.75F, 14.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -50.0F, 0.0F, 0.0F, 2.0944F, 0.0F));

		PartDefinition cube_r35 = rotorringbottom4.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(81, 20).addBox(-0.25F, 14.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(9, 84).addBox(-7.75F, 14.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -50.0F, 0.0F, 0.0F, 2.618F, 0.0F));

		PartDefinition cube_r36 = rotorringbottom4.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(79, 88).addBox(-0.25F, 14.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(9, 94).addBox(-7.75F, 14.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -50.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition rotorringbottom5 = rotorbottomstrips2.addOrReplaceChild("rotorringbottom5", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition cube_r37 = rotorringbottom5.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(72, 38).addBox(-7.75F, 14.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(72, 48).addBox(-0.25F, 14.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -60.0F, 0.0F, 0.0F, -2.618F, 0.0F));

		PartDefinition cube_r38 = rotorringbottom5.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(0, 0).addBox(7.75F, 14.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -60.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition cube_r39 = rotorringbottom5.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(0, 3).addBox(7.75F, 14.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -60.0F, 0.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r40 = rotorringbottom5.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(5, 0).addBox(-8.75F, 14.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -60.0F, 0.0F, 3.1416F, 0.0F, -3.1416F));

		PartDefinition cube_r41 = rotorringbottom5.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(5, 3).addBox(7.75F, 14.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 6).addBox(-8.75F, 14.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -60.0F, 0.0F, 0.0F, -2.0944F, 0.0F));

		PartDefinition cube_r42 = rotorringbottom5.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(5, 6).addBox(7.75F, 14.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -60.0F, 0.0F, 0.0F, 2.0944F, 0.0F));

		PartDefinition cube_r43 = rotorringbottom5.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(72, 58).addBox(-0.25F, 14.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(9, 74).addBox(-7.75F, 14.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -60.0F, 0.0F, 0.0F, 2.618F, 0.0F));

		PartDefinition cube_r44 = rotorringbottom5.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(79, 68).addBox(-0.25F, 14.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(79, 78).addBox(-7.75F, 14.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -60.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 18).addBox(-8.0F, -1.0F, -8.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-8.0F, -48.0F, -8.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(160, 13).addBox(-9.0F, -47.0F, -9.0F, 18.0F, 46.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(15, 15).addBox(-9.0F, -48.0F, 8.0F, 18.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(8.0F, -48.0F, -8.0F, 1.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-9.0F, -48.0F, -8.0F, 1.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(15, 15).addBox(-9.0F, -48.0F, -9.0F, 18.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(15, 15).addBox(-9.0F, -1.0F, 8.0F, 18.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(8.0F, -1.0F, -8.0F, 1.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-9.0F, -1.0F, -8.0F, 1.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(15, 15).addBox(-9.0F, -1.0F, -9.0F, 18.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderToBuffer(PoseStack stack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		stack.pushPose();

		stack.translate(0.5,3,-0.5);

		rotorbottomstrips.render(stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rotorbottomstrips2.render(stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		stack.popPose();
	}

	@Override
	public void setupAnim(Entity p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_, float p_102623_) {

	}
}