package com.duzo.tardis.tardis.consoles.impl.models;// Made with Blockbench 4.7.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.duzo.tardis.tardis.consoles.ConsoleModelSchema;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class BorealisConsoleModel extends ConsoleModelSchema {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("ait", "borealisconsolemodel"), "main");
	public final ModelPart base_console;
	public final ModelPart rotor;
	public final ModelPart glow;
	public final ModelPart NORTH;
	public final ModelPart NORTH_WEST;
	public final ModelPart SOUTH_WEST;
	public final ModelPart SOUTH;
	public final ModelPart SOUTH_EAST;
	public final ModelPart NORTH_EAST;

	public BorealisConsoleModel(ModelPart root) {
		this.base_console = root.getChild("base_console");
		this.rotor = root.getChild("rotor");
		this.glow = root.getChild("glow");
		this.NORTH = root.getChild("NORTH");
		this.NORTH_WEST = root.getChild("NORTH_WEST");
		this.SOUTH_WEST = root.getChild("SOUTH_WEST");
		this.SOUTH = root.getChild("SOUTH");
		this.SOUTH_EAST = root.getChild("SOUTH_EAST");
		this.NORTH_EAST = root.getChild("NORTH_EAST");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition base_console = partdefinition.addOrReplaceChild("base_console", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition panels = base_console.addOrReplaceChild("panels", CubeListBuilder.create(), PartPose.offset(0.0F, -30.0F, 0.0F));

		PartDefinition bone25 = panels.addOrReplaceChild("bone25", CubeListBuilder.create().texOffs(0, 0).addBox(-15.0F, 1.774F, -2.9235F, 30.0F, 1.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -27.8F, 0.48F, 0.0F, 0.0F));

		PartDefinition bone38 = panels.addOrReplaceChild("bone38", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone44 = bone38.addOrReplaceChild("bone44", CubeListBuilder.create().texOffs(0, 0).addBox(-15.0F, 1.774F, -2.9235F, 30.0F, 1.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -27.8F, 0.48F, 0.0F, 0.0F));

		PartDefinition bone56 = bone38.addOrReplaceChild("bone56", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone152 = bone56.addOrReplaceChild("bone152", CubeListBuilder.create().texOffs(0, 0).addBox(-15.0F, 1.774F, -2.9235F, 30.0F, 1.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -27.8F, 0.48F, 0.0F, 0.0F));

		PartDefinition bone153 = bone56.addOrReplaceChild("bone153", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone154 = bone153.addOrReplaceChild("bone154", CubeListBuilder.create().texOffs(0, 0).addBox(-15.0F, 1.774F, -2.9235F, 30.0F, 1.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -27.8F, 0.48F, 0.0F, 0.0F));

		PartDefinition bone155 = bone153.addOrReplaceChild("bone155", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone156 = bone155.addOrReplaceChild("bone156", CubeListBuilder.create().texOffs(0, 0).addBox(-15.0F, 1.774F, -2.9235F, 30.0F, 1.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -27.8F, 0.48F, 0.0F, 0.0F));

		PartDefinition bone157 = bone155.addOrReplaceChild("bone157", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone158 = bone157.addOrReplaceChild("bone158", CubeListBuilder.create().texOffs(0, 0).addBox(-15.0F, 1.774F, -2.9235F, 30.0F, 1.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -27.8F, 0.48F, 0.0F, 0.0F));

		PartDefinition collar = base_console.addOrReplaceChild("collar", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone86 = collar.addOrReplaceChild("bone86", CubeListBuilder.create().texOffs(96, 130).addBox(-2.0F, -2.0F, -14.3F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -44.5F, 0.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition bone87 = bone86.addOrReplaceChild("bone87", CubeListBuilder.create().texOffs(96, 130).addBox(-2.0F, -2.0F, -14.3F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone88 = bone87.addOrReplaceChild("bone88", CubeListBuilder.create().texOffs(96, 130).addBox(-2.0F, -2.0F, -14.3F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone89 = bone88.addOrReplaceChild("bone89", CubeListBuilder.create().texOffs(96, 130).addBox(-2.0F, -2.0F, -14.3F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone90 = bone89.addOrReplaceChild("bone90", CubeListBuilder.create().texOffs(96, 130).addBox(-2.0F, -2.0F, -14.3F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone91 = bone90.addOrReplaceChild("bone91", CubeListBuilder.create().texOffs(96, 130).addBox(-2.0F, -2.0F, -14.3F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone92 = collar.addOrReplaceChild("bone92", CubeListBuilder.create().texOffs(123, 27).addBox(-5.0F, -2.0F, -12.3F, 10.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(128, 20).addBox(-5.5F, -2.975F, -13.275F, 11.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -43.5F, 0.0F));

		PartDefinition bone93 = bone92.addOrReplaceChild("bone93", CubeListBuilder.create().texOffs(123, 27).addBox(-5.0F, -2.0F, -12.3F, 10.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(128, 20).addBox(-5.5F, -2.975F, -13.275F, 11.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone94 = bone93.addOrReplaceChild("bone94", CubeListBuilder.create().texOffs(123, 27).addBox(-5.0F, -2.0F, -12.3F, 10.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(128, 20).addBox(-5.5F, -2.975F, -13.275F, 11.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone95 = bone94.addOrReplaceChild("bone95", CubeListBuilder.create().texOffs(123, 27).addBox(-5.0F, -2.0F, -12.3F, 10.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(128, 20).addBox(-5.5F, -2.975F, -13.275F, 11.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone96 = bone95.addOrReplaceChild("bone96", CubeListBuilder.create().texOffs(123, 27).addBox(-5.0F, -2.0F, -12.3F, 10.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(128, 20).addBox(-5.5F, -2.975F, -13.275F, 11.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone97 = bone96.addOrReplaceChild("bone97", CubeListBuilder.create().texOffs(123, 27).addBox(-5.0F, -2.0F, -12.3F, 10.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(128, 20).addBox(-5.5F, -2.975F, -13.275F, 11.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone104 = collar.addOrReplaceChild("bone104", CubeListBuilder.create().texOffs(70, 92).addBox(2.0F, 1.0F, -13.05F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(70, 92).addBox(-4.0F, 1.0F, -13.05F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -45.5F, 0.0F));

		PartDefinition bone105 = bone104.addOrReplaceChild("bone105", CubeListBuilder.create().texOffs(70, 92).addBox(2.0F, 1.0F, -13.05F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(70, 92).addBox(-4.0F, 1.0F, -13.05F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone106 = bone105.addOrReplaceChild("bone106", CubeListBuilder.create().texOffs(70, 92).addBox(2.0F, 1.0F, -13.05F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(70, 92).addBox(-4.0F, 1.0F, -13.05F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone107 = bone106.addOrReplaceChild("bone107", CubeListBuilder.create().texOffs(70, 92).addBox(2.0F, 1.0F, -13.05F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(70, 92).addBox(-4.0F, 1.0F, -13.05F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone108 = bone107.addOrReplaceChild("bone108", CubeListBuilder.create().texOffs(70, 92).addBox(2.0F, 1.0F, -13.05F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(70, 92).addBox(-4.0F, 1.0F, -13.05F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone109 = bone108.addOrReplaceChild("bone109", CubeListBuilder.create().texOffs(70, 92).addBox(2.0F, 1.0F, -13.05F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(70, 92).addBox(-4.0F, 1.0F, -13.05F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone98 = collar.addOrReplaceChild("bone98", CubeListBuilder.create().texOffs(112, 119).addBox(-6.0F, 2.0F, -13.3F, 12.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -43.5F, 0.0F));

		PartDefinition bone99 = bone98.addOrReplaceChild("bone99", CubeListBuilder.create().texOffs(112, 119).addBox(-6.0F, 2.0F, -13.3F, 12.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone100 = bone99.addOrReplaceChild("bone100", CubeListBuilder.create().texOffs(112, 119).addBox(-6.0F, 2.0F, -13.3F, 12.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone101 = bone100.addOrReplaceChild("bone101", CubeListBuilder.create().texOffs(112, 119).addBox(-6.0F, 2.0F, -13.3F, 12.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone102 = bone101.addOrReplaceChild("bone102", CubeListBuilder.create().texOffs(112, 119).addBox(-6.0F, 2.0F, -13.3F, 12.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone103 = bone102.addOrReplaceChild("bone103", CubeListBuilder.create().texOffs(112, 119).addBox(-6.0F, 2.0F, -13.3F, 12.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition lower_dividers = base_console.addOrReplaceChild("lower_dividers", CubeListBuilder.create(), PartPose.offset(0.0F, -28.0F, 0.0F));

		PartDefinition bone32 = lower_dividers.addOrReplaceChild("bone32", CubeListBuilder.create().texOffs(0, 75).addBox(-17.0F, -0.5858F, -2.5858F, 34.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -27.8F, -0.7854F, 0.0F, 0.0F));

		PartDefinition bone26 = lower_dividers.addOrReplaceChild("bone26", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone27 = bone26.addOrReplaceChild("bone27", CubeListBuilder.create().texOffs(0, 75).addBox(-17.0F, -0.5858F, -2.5858F, 34.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -27.8F, -0.7854F, 0.0F, 0.0F));

		PartDefinition bone28 = bone26.addOrReplaceChild("bone28", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone29 = bone28.addOrReplaceChild("bone29", CubeListBuilder.create().texOffs(0, 75).addBox(-17.0F, -0.5858F, -2.5858F, 34.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -27.8F, -0.7854F, 0.0F, 0.0F));

		PartDefinition bone30 = bone28.addOrReplaceChild("bone30", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone33 = bone30.addOrReplaceChild("bone33", CubeListBuilder.create().texOffs(0, 75).addBox(-17.0F, -0.5858F, -2.5858F, 34.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -27.8F, -0.7854F, 0.0F, 0.0F));

		PartDefinition bone34 = bone30.addOrReplaceChild("bone34", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone35 = bone34.addOrReplaceChild("bone35", CubeListBuilder.create().texOffs(0, 75).addBox(-17.0F, -0.5858F, -2.5858F, 34.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -27.8F, -0.7854F, 0.0F, 0.0F));

		PartDefinition bone36 = bone34.addOrReplaceChild("bone36", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone37 = bone36.addOrReplaceChild("bone37", CubeListBuilder.create().texOffs(0, 75).addBox(-17.0F, -0.5858F, -2.5858F, 34.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -27.8F, -0.7854F, 0.0F, 0.0F));

		PartDefinition dividers2 = base_console.addOrReplaceChild("dividers2", CubeListBuilder.create().texOffs(67, 44).addBox(-2.0F, -2.0F, -36.3F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -30.5F, 0.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition bone40 = dividers2.addOrReplaceChild("bone40", CubeListBuilder.create().texOffs(67, 44).addBox(-2.0F, -2.0F, -36.3F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone39 = bone40.addOrReplaceChild("bone39", CubeListBuilder.create().texOffs(67, 44).addBox(-2.0F, -2.0F, -36.3F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone41 = bone39.addOrReplaceChild("bone41", CubeListBuilder.create().texOffs(67, 44).addBox(-2.0F, -2.0F, -36.3F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone42 = bone41.addOrReplaceChild("bone42", CubeListBuilder.create().texOffs(67, 44).addBox(-2.0F, -2.0F, -36.3F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone43 = bone42.addOrReplaceChild("bone43", CubeListBuilder.create().texOffs(67, 44).addBox(-2.0F, -2.0F, -36.3F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition dividers = base_console.addOrReplaceChild("dividers", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -30.5F, 0.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition bone50 = dividers.addOrReplaceChild("bone50", CubeListBuilder.create().texOffs(55, 75).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 4.0F, 22.0F, new CubeDeformation(0.0F))
		.texOffs(81, 0).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 4.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -34.3F, 0.4363F, 0.0F, 0.0F));

		PartDefinition bone45 = dividers.addOrReplaceChild("bone45", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone46 = bone45.addOrReplaceChild("bone46", CubeListBuilder.create().texOffs(55, 75).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 4.0F, 22.0F, new CubeDeformation(0.0F))
		.texOffs(81, 0).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 4.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -34.3F, 0.4363F, 0.0F, 0.0F));

		PartDefinition bone47 = bone45.addOrReplaceChild("bone47", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone48 = bone47.addOrReplaceChild("bone48", CubeListBuilder.create().texOffs(55, 75).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 4.0F, 22.0F, new CubeDeformation(0.0F))
		.texOffs(81, 0).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 4.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -34.3F, 0.4363F, 0.0F, 0.0F));

		PartDefinition bone49 = bone47.addOrReplaceChild("bone49", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone51 = bone49.addOrReplaceChild("bone51", CubeListBuilder.create().texOffs(55, 75).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 4.0F, 22.0F, new CubeDeformation(0.0F))
		.texOffs(81, 0).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 4.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -34.3F, 0.4363F, 0.0F, 0.0F));

		PartDefinition bone52 = bone49.addOrReplaceChild("bone52", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone53 = bone52.addOrReplaceChild("bone53", CubeListBuilder.create().texOffs(55, 75).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 4.0F, 22.0F, new CubeDeformation(0.0F))
		.texOffs(81, 0).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 4.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -34.3F, 0.4363F, 0.0F, 0.0F));

		PartDefinition bone54 = bone52.addOrReplaceChild("bone54", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone55 = bone54.addOrReplaceChild("bone55", CubeListBuilder.create().texOffs(55, 75).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 4.0F, 22.0F, new CubeDeformation(0.0F))
		.texOffs(81, 0).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 4.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -34.3F, 0.4363F, 0.0F, 0.0F));

		PartDefinition bone122 = base_console.addOrReplaceChild("bone122", CubeListBuilder.create().texOffs(106, 0).addBox(-0.5F, -4.0F, -7.3F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -44.5F, 0.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition bone123 = bone122.addOrReplaceChild("bone123", CubeListBuilder.create().texOffs(106, 0).addBox(-0.5F, -4.0F, -7.3F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone124 = bone123.addOrReplaceChild("bone124", CubeListBuilder.create().texOffs(106, 0).addBox(-0.5F, -4.0F, -7.3F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone125 = bone124.addOrReplaceChild("bone125", CubeListBuilder.create().texOffs(106, 0).addBox(-0.5F, -4.0F, -7.3F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone126 = bone125.addOrReplaceChild("bone126", CubeListBuilder.create().texOffs(106, 0).addBox(-0.5F, -4.0F, -7.3F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone127 = bone126.addOrReplaceChild("bone127", CubeListBuilder.create().texOffs(106, 0).addBox(-0.5F, -4.0F, -7.3F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone110 = base_console.addOrReplaceChild("bone110", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -44.5F, 0.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition bone116 = bone110.addOrReplaceChild("bone116", CubeListBuilder.create().texOffs(0, 84).addBox(-1.0F, -7.0F, 0.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -12.3F, -1.0472F, 0.0F, 0.0F));

		PartDefinition bone111 = bone110.addOrReplaceChild("bone111", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone112 = bone111.addOrReplaceChild("bone112", CubeListBuilder.create().texOffs(0, 84).addBox(-1.0F, -7.0F, 0.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -12.3F, -1.0472F, 0.0F, 0.0F));

		PartDefinition bone113 = bone111.addOrReplaceChild("bone113", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone114 = bone113.addOrReplaceChild("bone114", CubeListBuilder.create().texOffs(0, 84).addBox(-1.0F, -7.0F, 0.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -12.3F, -1.0472F, 0.0F, 0.0F));

		PartDefinition bone115 = bone113.addOrReplaceChild("bone115", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone117 = bone115.addOrReplaceChild("bone117", CubeListBuilder.create().texOffs(0, 84).addBox(-1.0F, -7.0F, 0.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -12.3F, -1.0472F, 0.0F, 0.0F));

		PartDefinition bone118 = bone115.addOrReplaceChild("bone118", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone119 = bone118.addOrReplaceChild("bone119", CubeListBuilder.create().texOffs(0, 84).addBox(-1.0F, -7.0F, 0.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -12.3F, -1.0472F, 0.0F, 0.0F));

		PartDefinition bone120 = bone118.addOrReplaceChild("bone120", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone121 = bone120.addOrReplaceChild("bone121", CubeListBuilder.create().texOffs(0, 84).addBox(-1.0F, -7.0F, 0.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -12.3F, -1.0472F, 0.0F, 0.0F));

		PartDefinition bone84 = base_console.addOrReplaceChild("bone84", CubeListBuilder.create().texOffs(106, 10).addBox(-6.5F, -23.5F, -22.8F, 13.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		PartDefinition bone85 = bone84.addOrReplaceChild("bone85", CubeListBuilder.create().texOffs(86, 75).addBox(-5.5F, -3.0F, -4.5F, 11.0F, 7.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.5F, -20.3F, 0.4363F, 0.0F, 0.0F));

		PartDefinition bone148 = bone84.addOrReplaceChild("bone148", CubeListBuilder.create().texOffs(106, 10).addBox(-6.5F, -23.5F, -22.8F, 13.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -2.0944F, 0.0F));

		PartDefinition bone149 = bone148.addOrReplaceChild("bone149", CubeListBuilder.create().texOffs(86, 75).addBox(-5.5F, -3.0F, -4.5F, 11.0F, 7.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.5F, -20.3F, 0.4363F, 0.0F, 0.0F));

		PartDefinition bone166 = bone149.addOrReplaceChild("bone166", CubeListBuilder.create().texOffs(120, 71).addBox(-4.5F, -5.0F, 0.0F, 9.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -4.5F, 0.6545F, 0.0F, 0.0F));

		PartDefinition bone150 = bone148.addOrReplaceChild("bone150", CubeListBuilder.create().texOffs(106, 10).addBox(-6.5F, -23.5F, -22.8F, 13.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -2.0944F, 0.0F));

		PartDefinition bone151 = bone150.addOrReplaceChild("bone151", CubeListBuilder.create().texOffs(86, 75).addBox(-5.5F, -3.0F, -4.5F, 11.0F, 7.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.5F, -20.3F, 0.4363F, 0.0F, 0.0F));

		PartDefinition bone62 = base_console.addOrReplaceChild("bone62", CubeListBuilder.create().texOffs(73, 126).addBox(-2.5F, -18.5F, -17.8F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone81 = bone62.addOrReplaceChild("bone81", CubeListBuilder.create().texOffs(0, 44).addBox(-17.0803F, -9.0F, -12.65F, 5.0F, 9.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(74, 116).addBox(-18.0803F, -10.0F, -13.65F, 7.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(14.5803F, -13.5F, -10.15F));

		PartDefinition bone63 = bone62.addOrReplaceChild("bone63", CubeListBuilder.create().texOffs(73, 126).addBox(-2.5F, -18.5F, -17.8F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -2.0944F, 0.0F));

		PartDefinition bone64 = bone63.addOrReplaceChild("bone64", CubeListBuilder.create().texOffs(0, 44).addBox(-17.0803F, -9.0F, -12.65F, 5.0F, 9.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(74, 116).addBox(-18.0803F, -10.0F, -13.65F, 7.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(14.5803F, -13.5F, -10.15F));

		PartDefinition bone82 = bone63.addOrReplaceChild("bone82", CubeListBuilder.create().texOffs(73, 126).addBox(-2.5F, -18.5F, -17.8F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -2.0944F, 0.0F));

		PartDefinition bone83 = bone82.addOrReplaceChild("bone83", CubeListBuilder.create().texOffs(0, 44).addBox(-17.0803F, -9.0F, -12.65F, 5.0F, 9.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(74, 116).addBox(-18.0803F, -10.0F, -13.65F, 7.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(14.5803F, -13.5F, -10.15F));

		PartDefinition bone60 = base_console.addOrReplaceChild("bone60", CubeListBuilder.create(), PartPose.offset(0.0F, -26.0F, 0.0F));

		PartDefinition bone61 = bone60.addOrReplaceChild("bone61", CubeListBuilder.create().texOffs(0, 22).addBox(-15.0F, -1.226F, 0.0765F, 30.0F, 1.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -30.8F, -0.2182F, 0.0F, 0.0F));

		PartDefinition bone65 = bone60.addOrReplaceChild("bone65", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone66 = bone65.addOrReplaceChild("bone66", CubeListBuilder.create().texOffs(0, 22).addBox(-15.0F, -1.226F, 0.0765F, 30.0F, 1.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -30.8F, -0.2182F, 0.0F, 0.0F));

		PartDefinition bone67 = bone65.addOrReplaceChild("bone67", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone68 = bone67.addOrReplaceChild("bone68", CubeListBuilder.create().texOffs(0, 22).addBox(-15.0F, -1.226F, 0.0765F, 30.0F, 1.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -30.8F, -0.2182F, 0.0F, 0.0F));

		PartDefinition bone69 = bone67.addOrReplaceChild("bone69", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone70 = bone69.addOrReplaceChild("bone70", CubeListBuilder.create().texOffs(0, 22).addBox(-15.0F, -1.226F, 0.0765F, 30.0F, 1.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -30.8F, -0.2182F, 0.0F, 0.0F));

		PartDefinition bone144 = bone69.addOrReplaceChild("bone144", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone145 = bone144.addOrReplaceChild("bone145", CubeListBuilder.create().texOffs(0, 22).addBox(-15.0F, -1.226F, 0.0765F, 30.0F, 1.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -30.8F, -0.2182F, 0.0F, 0.0F));

		PartDefinition bone146 = bone144.addOrReplaceChild("bone146", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone147 = bone146.addOrReplaceChild("bone147", CubeListBuilder.create().texOffs(0, 22).addBox(-15.0F, -1.226F, 0.0765F, 30.0F, 1.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -30.8F, -0.2182F, 0.0F, 0.0F));

		PartDefinition bone58 = base_console.addOrReplaceChild("bone58", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -28.5F, 0.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition bone59 = bone58.addOrReplaceChild("bone59", CubeListBuilder.create().texOffs(65, 44).addBox(-2.0F, -6.0F, 0.0F, 4.0F, 6.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -34.3F, -0.3927F, 0.0F, 0.0F));

		PartDefinition bone71 = bone58.addOrReplaceChild("bone71", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone72 = bone71.addOrReplaceChild("bone72", CubeListBuilder.create().texOffs(65, 44).addBox(-2.0F, -6.0F, 0.0F, 4.0F, 6.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -34.3F, -0.3927F, 0.0F, 0.0F));

		PartDefinition bone73 = bone71.addOrReplaceChild("bone73", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone74 = bone73.addOrReplaceChild("bone74", CubeListBuilder.create().texOffs(65, 44).addBox(-2.0F, -6.0F, 0.0F, 4.0F, 6.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -34.3F, -0.3927F, 0.0F, 0.0F));

		PartDefinition bone75 = bone73.addOrReplaceChild("bone75", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone76 = bone75.addOrReplaceChild("bone76", CubeListBuilder.create().texOffs(65, 44).addBox(-2.0F, -6.0F, 0.0F, 4.0F, 6.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -34.3F, -0.3927F, 0.0F, 0.0F));

		PartDefinition bone77 = bone75.addOrReplaceChild("bone77", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone78 = bone77.addOrReplaceChild("bone78", CubeListBuilder.create().texOffs(65, 44).addBox(-2.0F, -6.0F, 0.0F, 4.0F, 6.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -34.3F, -0.3927F, 0.0F, 0.0F));

		PartDefinition bone79 = bone77.addOrReplaceChild("bone79", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone80 = bone79.addOrReplaceChild("bone80", CubeListBuilder.create().texOffs(65, 44).addBox(-2.0F, -6.0F, 0.0F, 4.0F, 6.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -34.3F, -0.3927F, 0.0F, 0.0F));

		PartDefinition bone13 = base_console.addOrReplaceChild("bone13", CubeListBuilder.create().texOffs(23, 130).addBox(-1.0F, -16.0F, -15.6832F, 2.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition bone14 = bone13.addOrReplaceChild("bone14", CubeListBuilder.create().texOffs(23, 130).addBox(-1.0F, -16.0F, -15.6832F, 2.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone15 = bone14.addOrReplaceChild("bone15", CubeListBuilder.create().texOffs(23, 130).addBox(-1.0F, -16.0F, -15.6832F, 2.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone16 = bone15.addOrReplaceChild("bone16", CubeListBuilder.create().texOffs(23, 130).addBox(-1.0F, -16.0F, -15.6832F, 2.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone17 = bone16.addOrReplaceChild("bone17", CubeListBuilder.create().texOffs(23, 130).addBox(-1.0F, -16.0F, -15.6832F, 2.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone18 = bone17.addOrReplaceChild("bone18", CubeListBuilder.create().texOffs(23, 130).addBox(-1.0F, -16.0F, -15.6832F, 2.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone19 = base_console.addOrReplaceChild("bone19", CubeListBuilder.create().texOffs(0, 110).addBox(-6.0F, -20.0F, -11.8F, 12.0F, 20.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		PartDefinition bone20 = bone19.addOrReplaceChild("bone20", CubeListBuilder.create().texOffs(0, 110).addBox(-6.0F, -20.0F, -11.8F, 12.0F, 20.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 22).addBox(-3.0F, -11.0F, -13.8F, 6.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone21 = bone20.addOrReplaceChild("bone21", CubeListBuilder.create().texOffs(0, 110).addBox(-6.0F, -20.0F, -11.8F, 12.0F, 20.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(128, 132).addBox(-3.5F, -10.0F, -12.8F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone132 = bone21.addOrReplaceChild("bone132", CubeListBuilder.create().texOffs(137, 143).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(82, 44).addBox(2.5F, -3.0F, 0.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -9.5F, -12.3F, 0.3491F, 0.0F, 0.0F));

		PartDefinition bone22 = bone21.addOrReplaceChild("bone22", CubeListBuilder.create().texOffs(0, 110).addBox(-6.0F, -20.0F, -11.8F, 12.0F, 20.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 34).addBox(-3.0F, -6.0F, -14.8F, 6.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(81, 0).addBox(-3.0F, -11.0F, -12.05F, 6.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(61, 130).addBox(-1.0F, -14.0F, -14.3F, 2.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone23 = bone22.addOrReplaceChild("bone23", CubeListBuilder.create().texOffs(0, 110).addBox(-6.0F, -20.0F, -11.8F, 12.0F, 20.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone24 = bone23.addOrReplaceChild("bone24", CubeListBuilder.create().texOffs(0, 110).addBox(-6.0F, -20.0F, -11.8F, 12.0F, 20.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-3.0F, -11.0F, -13.8F, 6.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(16, 44).addBox(-2.0F, -9.0F, -14.8F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(98, 16).addBox(-0.5F, -4.75F, -14.8F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone7 = base_console.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(83, 138).addBox(-1.0F, -4.0F, -17.6832F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition bone8 = bone7.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(83, 138).addBox(-1.0F, -4.0F, -17.6832F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone9 = bone8.addOrReplaceChild("bone9", CubeListBuilder.create().texOffs(83, 138).addBox(-1.0F, -4.0F, -17.6832F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone10 = bone9.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(83, 138).addBox(-1.0F, -4.0F, -17.6832F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone11 = bone10.addOrReplaceChild("bone11", CubeListBuilder.create().texOffs(83, 138).addBox(-1.0F, -4.0F, -17.6832F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone12 = bone11.addOrReplaceChild("bone12", CubeListBuilder.create().texOffs(83, 138).addBox(-1.0F, -4.0F, -17.6832F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone = base_console.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(47, 102).addBox(-8.0F, -4.0F, -15.8F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone2 = bone.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(47, 102).addBox(-8.0F, -4.0F, -15.8F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone3 = bone2.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(47, 102).addBox(-8.0F, -4.0F, -15.8F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone4 = bone3.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(47, 102).addBox(-8.0F, -4.0F, -15.8F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone5 = bone4.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(47, 102).addBox(-8.0F, -4.0F, -15.8F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone6 = bone5.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(47, 102).addBox(-8.0F, -4.0F, -15.8F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone208 = base_console.addOrReplaceChild("bone208", CubeListBuilder.create().texOffs(81, 27).addBox(-7.0F, -1.0F, -11.8F, 14.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone209 = bone208.addOrReplaceChild("bone209", CubeListBuilder.create().texOffs(81, 27).addBox(-7.0F, -1.0F, -11.8F, 14.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone210 = bone209.addOrReplaceChild("bone210", CubeListBuilder.create().texOffs(81, 27).addBox(-7.0F, -1.0F, -11.8F, 14.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone211 = bone210.addOrReplaceChild("bone211", CubeListBuilder.create().texOffs(81, 27).addBox(-7.0F, -1.0F, -11.8F, 14.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone212 = bone211.addOrReplaceChild("bone212", CubeListBuilder.create().texOffs(81, 27).addBox(-7.0F, -1.0F, -11.8F, 14.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone213 = bone212.addOrReplaceChild("bone213", CubeListBuilder.create().texOffs(81, 27).addBox(-7.0F, -1.0F, -11.8F, 14.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition rotor = partdefinition.addOrReplaceChild("rotor", CubeListBuilder.create().texOffs(0, 44).addBox(-11.0F, -42.0F, -11.0F, 22.0F, 1.0F, 22.0F, new CubeDeformation(0.0F))
		.texOffs(52, 111).addBox(-3.5F, -53.5F, -3.5F, 7.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(27, 110).addBox(-3.0F, -55.0F, -3.0F, 6.0F, 13.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(135, 48).addBox(-2.0F, -56.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(52, 111).addBox(-3.5F, -47.5F, -3.5F, 7.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(52, 111).addBox(-3.5F, -50.5F, -3.5F, 7.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bone138 = rotor.addOrReplaceChild("bone138", CubeListBuilder.create().texOffs(81, 27).addBox(-1.5F, -7.475F, -8.775F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(97, 0).addBox(-0.5F, -8.975F, -7.775F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -43.5F, 0.0F));

		PartDefinition bone139 = bone138.addOrReplaceChild("bone139", CubeListBuilder.create().texOffs(81, 27).addBox(-1.5F, -7.475F, -8.775F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(97, 0).addBox(-0.5F, -8.975F, -7.775F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone140 = bone139.addOrReplaceChild("bone140", CubeListBuilder.create().texOffs(81, 27).addBox(-1.5F, -7.475F, -8.775F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(97, 0).addBox(-0.5F, -8.975F, -7.775F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone141 = bone140.addOrReplaceChild("bone141", CubeListBuilder.create().texOffs(81, 27).addBox(-1.5F, -7.475F, -8.775F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(97, 0).addBox(-0.5F, -8.975F, -7.775F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone142 = bone141.addOrReplaceChild("bone142", CubeListBuilder.create().texOffs(81, 27).addBox(-1.5F, -7.475F, -8.775F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(97, 0).addBox(-0.5F, -8.975F, -7.775F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone143 = bone142.addOrReplaceChild("bone143", CubeListBuilder.create().texOffs(81, 27).addBox(-1.5F, -7.475F, -8.775F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(97, 0).addBox(-0.5F, -8.975F, -7.775F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition glow = partdefinition.addOrReplaceChild("glow", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition NORTH2 = glow.addOrReplaceChild("NORTH2", CubeListBuilder.create(), PartPose.offset(0.0F, -30.0F, 0.0F));

		PartDefinition bone31 = NORTH2.addOrReplaceChild("bone31", CubeListBuilder.create().texOffs(145, 54).addBox(-9.5F, 0.524F, -0.4235F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(145, 54).addBox(-6.75F, 0.524F, -0.4235F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(145, 54).addBox(7.5F, 0.524F, -0.4235F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(145, 54).addBox(4.75F, 0.524F, -0.4235F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 140).addBox(1.0F, 1.024F, 0.5765F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 140).addBox(-2.0F, 1.024F, 0.5765F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -27.8F, 0.48F, 0.0F, 0.0F));

		PartDefinition bone178 = bone31.addOrReplaceChild("bone178", CubeListBuilder.create(), PartPose.offsetAndRotation(-9.0F, 0.524F, 0.0765F, 0.6109F, 0.0F, 0.0F));

		PartDefinition bone179 = bone31.addOrReplaceChild("bone179", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.25F, 0.524F, 0.0765F, 0.6109F, 0.0F, 0.0F));

		PartDefinition bone180 = bone31.addOrReplaceChild("bone180", CubeListBuilder.create(), PartPose.offsetAndRotation(5.25F, 0.524F, 0.0765F, 0.6109F, 0.0F, 0.0F));

		PartDefinition bone181 = bone31.addOrReplaceChild("bone181", CubeListBuilder.create(), PartPose.offsetAndRotation(8.0F, 0.524F, 0.0765F, 0.6109F, 0.0F, 0.0F));

		PartDefinition bone182 = bone31.addOrReplaceChild("bone182", CubeListBuilder.create().texOffs(37, 98).addBox(0.0F, -0.75F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.75F, 1.274F, 6.0765F, 0.0F, 0.0F, 0.6109F));

		PartDefinition bone183 = bone31.addOrReplaceChild("bone183", CubeListBuilder.create().texOffs(37, 98).mirror().addBox(-1.0F, -0.75F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.75F, 1.274F, 6.0765F, 0.0F, 0.0F, -0.6109F));

		PartDefinition bone184 = bone31.addOrReplaceChild("bone184", CubeListBuilder.create().texOffs(79, 138).addBox(0.0F, -0.75F, -2.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.75F, 1.274F, 6.0765F, 0.0F, 0.0F, 0.6109F));

		PartDefinition bone185 = bone31.addOrReplaceChild("bone185", CubeListBuilder.create().texOffs(79, 138).mirror().addBox(-1.0F, -0.75F, -2.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.75F, 1.274F, 6.0765F, 0.0F, 0.0F, -0.6109F));

		PartDefinition NORTH_WEST2 = glow.addOrReplaceChild("NORTH_WEST2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -30.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone186 = NORTH_WEST2.addOrReplaceChild("bone186", CubeListBuilder.create().texOffs(144, 136).addBox(8.5F, -0.226F, 0.0765F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -27.8F, 0.48F, 0.0F, 0.0F));

		PartDefinition bone187 = bone186.addOrReplaceChild("bone187", CubeListBuilder.create().texOffs(52, 121).addBox(-1.0F, -1.0F, -4.25F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.274F, 6.0765F, -0.9163F, 0.0F, 0.0F));

		PartDefinition bone189 = bone186.addOrReplaceChild("bone189", CubeListBuilder.create().texOffs(94, 119).addBox(-4.0F, 0.0F, -5.0F, 4.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.024F, 6.0765F, 0.0F, 0.0F, 0.3927F));

		PartDefinition bone190 = bone186.addOrReplaceChild("bone190", CubeListBuilder.create().texOffs(94, 119).mirror().addBox(0.0F, 0.0F, -5.0F, 4.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 1.024F, 6.0765F, 0.0F, 0.0F, -0.3927F));

		PartDefinition SOUTH_WEST2 = glow.addOrReplaceChild("SOUTH_WEST2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -30.0F, 0.0F, 0.0F, -2.0944F, 0.0F));

		PartDefinition bone188 = SOUTH_WEST2.addOrReplaceChild("bone188", CubeListBuilder.create().texOffs(136, 37).addBox(-10.0F, 1.274F, 3.0765F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(86, 81).addBox(-1.0F, 1.024F, 1.5765F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(98, 42).addBox(1.0F, 1.024F, 9.0765F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(9, 132).addBox(-1.5F, 0.024F, 9.0765F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(98, 42).addBox(-2.0F, 1.024F, 9.0765F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(16, 59).addBox(4.0F, 0.774F, 4.0765F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 59).addBox(-5.0F, 0.774F, 4.0765F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(144, 61).addBox(-9.5F, 1.024F, 3.5765F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(144, 61).addBox(-7.25F, 1.024F, 7.5765F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(136, 37).addBox(-7.75F, 1.274F, 7.0765F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(144, 61).mirror().addBox(5.25F, 1.024F, 7.5765F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(136, 37).mirror().addBox(4.75F, 1.274F, 7.0765F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(144, 61).mirror().addBox(7.5F, 1.024F, 3.5765F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(136, 37).mirror().addBox(7.0F, 1.274F, 3.0765F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -4.0F, -27.8F, 0.48F, 0.0F, 0.0F));

		PartDefinition SOUTH2 = glow.addOrReplaceChild("SOUTH2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -30.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition bone191 = SOUTH2.addOrReplaceChild("bone191", CubeListBuilder.create().texOffs(98, 61).addBox(-6.5F, 1.524F, 10.0765F, 13.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(32, 130).addBox(-5.0F, 0.274F, 10.5765F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(32, 130).addBox(-1.0F, 0.274F, 10.5765F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(32, 130).addBox(3.0F, 0.274F, 10.5765F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 140).addBox(-2.0F, 1.024F, 3.5765F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 140).addBox(1.0F, 1.024F, 3.5765F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(46, 111).addBox(-9.0F, 1.024F, 0.0765F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -27.8F, 0.48F, 0.0F, 0.0F));

		PartDefinition bone192 = bone191.addOrReplaceChild("bone192", CubeListBuilder.create(), PartPose.offsetAndRotation(-7.5F, 1.274F, 1.5765F, 0.0F, -0.7854F, 0.0F));

		PartDefinition SOUTH_EAST2 = glow.addOrReplaceChild("SOUTH_EAST2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -30.0F, 0.0F, 0.0F, 2.0944F, 0.0F));

		PartDefinition bone193 = SOUTH_EAST2.addOrReplaceChild("bone193", CubeListBuilder.create().texOffs(123, 37).addBox(-6.0F, 1.274F, 7.5765F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(101, 94).addBox(2.0F, 0.524F, 7.5765F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(45, 98).addBox(3.0F, 0.024F, 10.5765F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(98, 47).addBox(-5.0F, 0.524F, 10.5765F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(86, 94).addBox(-4.5F, 0.274F, 11.0765F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(131, 86).addBox(5.0F, 1.024F, -0.4235F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(131, 86).addBox(8.0F, 1.024F, -0.4235F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(11, 138).addBox(0.5F, 1.024F, 0.5765F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(131, 86).addBox(-6.0F, 1.024F, -0.4235F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(131, 86).addBox(-9.0F, 1.024F, -0.4235F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -27.8F, 0.48F, 0.0F, 0.0F));

		PartDefinition bone194 = bone193.addOrReplaceChild("bone194", CubeListBuilder.create(), PartPose.offsetAndRotation(3.5F, 0.024F, 11.0765F, 0.6109F, 0.0F, 0.0F));

		PartDefinition bone195 = bone193.addOrReplaceChild("bone195", CubeListBuilder.create(), PartPose.offsetAndRotation(2.5F, 0.524F, 7.8265F, 0.6109F, 0.0F, 0.0F));

		PartDefinition bone196 = bone193.addOrReplaceChild("bone196", CubeListBuilder.create(), PartPose.offsetAndRotation(4.0F, 1.024F, 8.8265F, 0.7854F, 0.0F, 0.0F));

		PartDefinition bone197 = bone193.addOrReplaceChild("bone197", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.75F, 1.774F, 2.5765F, 0.0F, 0.0F, -0.7854F));

		PartDefinition NORTH_EAST2 = glow.addOrReplaceChild("NORTH_EAST2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -30.0F, 0.0F, 0.0F, 1.0472F, 0.0F));

		PartDefinition bone198 = NORTH_EAST2.addOrReplaceChild("bone198", CubeListBuilder.create().texOffs(0, 98).addBox(8.5F, 0.774F, 1.0765F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(86, 75).addBox(6.5F, 0.774F, 0.0765F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(96, 116).addBox(3.5F, 0.524F, 11.5765F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(106, 0).addBox(-5.5F, 0.524F, 1.0765F, 11.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(45, 98).addBox(-1.0F, 0.024F, 11.5765F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -27.8F, 0.48F, 0.0F, 0.0F));

		PartDefinition bone199 = bone198.addOrReplaceChild("bone199", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 0.774F, 3.0765F, 0.7854F, 0.0F, 0.0F));

		PartDefinition bone200 = bone198.addOrReplaceChild("bone200", CubeListBuilder.create().texOffs(12, 12).addBox(2.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 1.524F, 10.8265F, 0.7854F, 0.0F, 0.0F));

		PartDefinition bone201 = bone198.addOrReplaceChild("bone201", CubeListBuilder.create(), PartPose.offsetAndRotation(3.5F, 0.024F, 12.0765F, 0.6109F, 0.0F, 0.0F));

		PartDefinition bone202 = glow.addOrReplaceChild("bone202", CubeListBuilder.create().texOffs(41, 68).addBox(-5.0F, 1.0F, -12.55F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -44.5F, 0.0F));

		PartDefinition bone203 = bone202.addOrReplaceChild("bone203", CubeListBuilder.create().texOffs(41, 68).addBox(-5.0F, 1.0F, -12.55F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone204 = bone203.addOrReplaceChild("bone204", CubeListBuilder.create().texOffs(41, 68).addBox(-5.0F, 1.0F, -12.55F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone205 = bone204.addOrReplaceChild("bone205", CubeListBuilder.create().texOffs(41, 68).addBox(-5.0F, 1.0F, -12.55F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone206 = bone205.addOrReplaceChild("bone206", CubeListBuilder.create().texOffs(41, 68).addBox(-5.0F, 1.0F, -12.55F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone207 = bone206.addOrReplaceChild("bone207", CubeListBuilder.create().texOffs(41, 68).addBox(-5.0F, 1.0F, -12.55F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition NORTH = partdefinition.addOrReplaceChild("NORTH", CubeListBuilder.create(), PartPose.offset(0.0F, -6.0F, 0.0F));

		PartDefinition bone136 = NORTH.addOrReplaceChild("bone136", CubeListBuilder.create().texOffs(130, 108).addBox(4.0F, 1.274F, -0.9235F, 6.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(130, 108).addBox(-10.0F, 1.274F, -0.9235F, 6.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(41, 92).addBox(-6.0F, 1.274F, 3.0765F, 12.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(103, 111).addBox(-5.0F, 0.774F, 7.0765F, 10.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(81, 16).addBox(-3.5F, 0.274F, 10.5765F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(45, 138).addBox(-3.0F, 0.774F, 8.5765F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(145, 141).addBox(-0.5F, 0.524F, 8.0765F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(41, 84).addBox(-5.0F, 1.274F, 7.0765F, 10.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(81, 11).addBox(-3.0F, 1.274F, 0.0765F, 6.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(117, 143).addBox(-9.0F, 1.274F, 3.0765F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(8, 144).addBox(-8.0F, 1.274F, 6.0765F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(117, 143).mirror().addBox(7.0F, 1.274F, 3.0765F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(8, 144).mirror().addBox(7.0F, 1.274F, 6.0765F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -4.0F, -27.8F, 0.48F, 0.0F, 0.0F));

		PartDefinition door_control = bone136.addOrReplaceChild("door_control", CubeListBuilder.create().texOffs(96, 142).addBox(-2.5F, -4.476F, -28.7235F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 29.8F));

		PartDefinition bone137 = bone136.addOrReplaceChild("bone137", CubeListBuilder.create().texOffs(67, 44).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 0.524F, 0.0765F, 0.6109F, 0.0F, 0.0F));

		PartDefinition bone159 = bone136.addOrReplaceChild("bone159", CubeListBuilder.create().texOffs(67, 44).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.25F, 0.524F, 0.0765F, 0.6109F, 0.0F, 0.0F));

		PartDefinition bone160 = bone136.addOrReplaceChild("bone160", CubeListBuilder.create().texOffs(67, 44).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.25F, 0.524F, 0.0765F, 0.6109F, 0.0F, 0.0F));

		PartDefinition bone161 = bone136.addOrReplaceChild("bone161", CubeListBuilder.create().texOffs(67, 44).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.524F, 0.0765F, 0.6109F, 0.0F, 0.0F));

		PartDefinition bone162 = bone136.addOrReplaceChild("bone162", CubeListBuilder.create(), PartPose.offsetAndRotation(-7.75F, 1.274F, 6.0765F, 0.0F, 0.0F, 0.6109F));

		PartDefinition bone163 = bone136.addOrReplaceChild("bone163", CubeListBuilder.create(), PartPose.offsetAndRotation(7.75F, 1.274F, 6.0765F, 0.0F, 0.0F, -0.6109F));

		PartDefinition bone164 = bone136.addOrReplaceChild("bone164", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.75F, 1.274F, 6.0765F, 0.0F, 0.0F, 0.6109F));

		PartDefinition bone165 = bone136.addOrReplaceChild("bone165", CubeListBuilder.create(), PartPose.offsetAndRotation(8.75F, 1.274F, 6.0765F, 0.0F, 0.0F, -0.6109F));

		PartDefinition NORTH_WEST = partdefinition.addOrReplaceChild("NORTH_WEST", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone57 = NORTH_WEST.addOrReplaceChild("bone57", CubeListBuilder.create().texOffs(0, 84).addBox(-7.0F, 1.024F, 0.0765F, 14.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 12).addBox(8.0F, 0.524F, -0.9235F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(76, 102).addBox(3.0F, 1.024F, 0.0765F, 4.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(133, 101).addBox(-2.5F, -0.976F, 8.5765F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -27.8F, 0.48F, 0.0F, 0.0F));

		PartDefinition bone128 = bone57.addOrReplaceChild("bone128", CubeListBuilder.create().texOffs(100, 94).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(98, 42).addBox(-4.5F, -4.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(70, 138).addBox(4.0F, -2.0F, -2.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(36, 138).addBox(-6.0F, -2.0F, -2.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.274F, 6.0765F, -0.9163F, 0.0F, 0.0F));

		PartDefinition bone131 = bone57.addOrReplaceChild("bone131", CubeListBuilder.create().texOffs(68, 84).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.5F, 1.274F, 4.0765F, 0.7854F, 0.0F, 0.0F));

		PartDefinition bone129 = bone57.addOrReplaceChild("bone129", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.0F, 1.024F, 6.0765F, 0.0F, 0.0F, 0.3927F));

		PartDefinition bone130 = bone57.addOrReplaceChild("bone130", CubeListBuilder.create(), PartPose.offsetAndRotation(4.0F, 1.024F, 6.0765F, 0.0F, 0.0F, -0.3927F));

		PartDefinition SOUTH_WEST = partdefinition.addOrReplaceChild("SOUTH_WEST", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0F, -2.0944F, 0.0F));

		PartDefinition bone133 = SOUTH_WEST.addOrReplaceChild("bone133", CubeListBuilder.create().texOffs(0, 68).addBox(-9.0F, 1.524F, -0.9235F, 18.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(126, 42).addBox(-5.0F, 1.274F, 1.0765F, 10.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(145, 129).addBox(-4.0F, 0.274F, 1.5765F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(137, 5).addBox(-3.0F, 1.524F, 6.0765F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(116, 125).addBox(-4.5F, 1.024F, 8.0765F, 9.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(125, 94).addBox(-4.5F, 1.524F, 8.0765F, 9.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(134, 138).addBox(-1.5F, -0.976F, 9.0765F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(106, 143).addBox(-7.75F, 1.524F, 4.0765F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(106, 143).mirror().addBox(5.75F, 1.524F, 4.0765F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 44).addBox(-6.75F, -0.976F, 8.0765F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 44).mirror().addBox(5.75F, -0.976F, 8.0765F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -4.0F, -27.8F, 0.48F, 0.0F, 0.0F));

		PartDefinition bone134 = bone133.addOrReplaceChild("bone134", CubeListBuilder.create().texOffs(111, 132).addBox(-2.5F, -0.5F, -2.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.524F, 5.0765F, 0.7854F, 0.0F, 0.0F));

		PartDefinition bone135 = bone133.addOrReplaceChild("bone135", CubeListBuilder.create().texOffs(145, 129).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.774F, 2.5765F, 0.0F, -0.829F, 0.0F));

		PartDefinition SOUTH = partdefinition.addOrReplaceChild("SOUTH", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition bone167 = SOUTH.addOrReplaceChild("bone167", CubeListBuilder.create().texOffs(121, 138).addBox(-1.5F, 1.024F, 10.0765F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(108, 138).addBox(-5.5F, 1.024F, 10.0765F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(108, 138).mirror().addBox(2.5F, 1.024F, 10.0765F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(41, 87).mirror().addBox(1.5F, 1.024F, 11.0765F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(41, 87).addBox(-2.5F, 1.024F, 11.0765F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(81, 11).addBox(-3.0F, 1.274F, 3.0765F, 6.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 59).addBox(5.0F, 1.274F, -0.9235F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(137, 0).addBox(6.0F, 0.774F, 0.0765F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 59).addBox(-10.0F, 1.274F, -0.9235F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(41, 84).addBox(-8.0F, 0.274F, 1.0765F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(67, 62).addBox(-4.0F, 1.524F, 0.0765F, 8.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(41, 92).addBox(-6.0F, 1.274F, 6.0765F, 12.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -27.8F, 0.48F, 0.0F, 0.0F));

		PartDefinition XYZmod = bone167.addOrReplaceChild("XYZmod", CubeListBuilder.create().texOffs(96, 142).addBox(-2.5F, -4.476F, -28.7235F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 32.8F));

		PartDefinition randomiser = bone167.addOrReplaceChild("randomiser", CubeListBuilder.create().texOffs(138, 10).addBox(-1.5F, -0.5F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.5F, 1.274F, 1.5765F, 0.0F, -0.7854F, 0.0F));

		PartDefinition land_type = bone167.addOrReplaceChild("land_type", CubeListBuilder.create().texOffs(143, 69).addBox(-2.0F, -3.226F, -29.7235F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 12).addBox(-1.0F, -3.726F, -29.7235F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 2.5F, 30.8F));

		PartDefinition SOUTH_EAST = partdefinition.addOrReplaceChild("SOUTH_EAST", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0F, 2.0944F, 0.0F));

		PartDefinition bone169 = SOUTH_EAST.addOrReplaceChild("bone169", CubeListBuilder.create().texOffs(120, 81).addBox(-5.5F, 1.024F, 10.0765F, 11.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(140, 125).addBox(1.0F, 1.024F, 7.0765F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(45, 71).addBox(-6.0F, 1.524F, 7.0765F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(52, 121).addBox(4.0F, 1.274F, -0.9235F, 6.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(135, 54).addBox(0.0F, 1.274F, 0.0765F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 59).addBox(0.5F, 0.024F, 2.5765F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(67, 47).addBox(-1.5F, 0.774F, 7.5765F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(140, 86).addBox(-2.0F, 1.274F, 0.5765F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 132).addBox(-3.5F, 1.274F, -0.4235F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 132).addBox(2.5F, 1.274F, -0.4235F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(52, 121).addBox(-10.0F, 1.274F, -0.9235F, 6.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -27.8F, 0.48F, 0.0F, 0.0F));

		PartDefinition handbrake = bone169.addOrReplaceChild("handbrake", CubeListBuilder.create().texOffs(136, 113).addBox(-2.5F, -4.0F, -0.5F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, 1.524F, 2.5765F, -1.309F, 0.0F, 0.0F));

		PartDefinition throttle = bone169.addOrReplaceChild("throttle", CubeListBuilder.create().texOffs(96, 142).addBox(4.5F, -4.476F, -32.7235F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 32.8F));

		PartDefinition bone173 = bone169.addOrReplaceChild("bone173", CubeListBuilder.create().texOffs(128, 143).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, 1.774F, 2.5765F, 0.0F, 0.0F, -0.7854F));

		PartDefinition bone171 = bone169.addOrReplaceChild("bone171", CubeListBuilder.create().texOffs(67, 44).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 0.024F, 11.0765F, 0.6109F, 0.0F, 0.0F));

		PartDefinition bone172 = bone169.addOrReplaceChild("bone172", CubeListBuilder.create().texOffs(67, 44).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 0.524F, 7.8265F, 0.6109F, 0.0F, 0.0F));

		PartDefinition bone170 = bone169.addOrReplaceChild("bone170", CubeListBuilder.create().texOffs(0, 103).addBox(-2.0F, -0.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 1.024F, 8.8265F, 0.7854F, 0.0F, 0.0F));

		PartDefinition NORTH_EAST = partdefinition.addOrReplaceChild("NORTH_EAST", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0F, 1.0472F, 0.0F));

		PartDefinition bone174 = NORTH_EAST.addOrReplaceChild("bone174", CubeListBuilder.create().texOffs(0, 98).addBox(-6.5F, 1.024F, 0.0765F, 13.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(36, 130).addBox(-10.5F, 1.024F, -0.9235F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(49, 141).addBox(-9.5F, 0.274F, 0.0765F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(125, 61).addBox(4.5F, 1.024F, -0.9235F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(67, 57).addBox(-5.5F, 0.774F, 11.0765F, 7.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(143, 119).addBox(-5.0F, 0.274F, 11.5765F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(143, 15).addBox(3.0F, 0.774F, 11.0765F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -27.8F, 0.48F, 0.0F, 0.0F));

		PartDefinition bone175 = bone174.addOrReplaceChild("bone175", CubeListBuilder.create().texOffs(0, 103).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 0.774F, 3.0765F, 0.7854F, 0.0F, 0.0F));

		PartDefinition bone176 = bone174.addOrReplaceChild("bone176", CubeListBuilder.create().texOffs(0, 103).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 1.524F, 10.8265F, 0.7854F, 0.0F, 0.0F));

		PartDefinition bone177 = bone174.addOrReplaceChild("bone177", CubeListBuilder.create().texOffs(67, 44).addBox(-4.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 0.024F, 12.0765F, 0.6109F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(Entity p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_, float p_102623_) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		base_console.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		//rotor.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		//glow.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		NORTH.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		NORTH_WEST.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		SOUTH_WEST.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		SOUTH.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		SOUTH_EAST.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		NORTH_EAST.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}