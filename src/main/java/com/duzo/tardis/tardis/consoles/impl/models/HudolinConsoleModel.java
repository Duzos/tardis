package com.duzo.tardis.tardis.consoles.impl.models;// Made with Blockbench 4.7.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.duzo.tardis.tardis.consoles.ConsoleModelSchema;
import com.duzo.tardis.tardis.consoles.EnumRotorState;
import com.duzo.tardis.tardis.consoles.blocks.entities.ConsoleBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class HudolinConsoleModel extends ConsoleModelSchema {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("ait", "hudolinconsolemodel"), "main");
	private final ModelPart console_plinth_one;
	private final ModelPart console_plinth_two;
	private final ModelPart console_plinth_three;
	private final ModelPart clawlegs;
	private final ModelPart clawlegs2;
	private final ModelPart clawlegs3;
	private final ModelPart under_console_struts;
	private final ModelPart console_corners;
	private final ModelPart console_collar_one;
	private final ModelPart console_collar_two;
	private final ModelPart panel;
	private final ModelPart panel2;
	private final ModelPart panel3;
	private final ModelPart panel4;
	private final ModelPart panel5;
	private final ModelPart panel6;
	private final ModelPart bone2;
	private final ModelPart bone3;
	private final ModelPart bone4;
	private final ModelPart bone;
	private final ModelPart base;
	private final ModelPart bottom_rotor;
	private final ModelPart top_rotor;
	private final ModelPart upper_console_one;
	private final ModelPart upper_console_two;
	private final ModelPart ConsoleCollarTwo3;
	private final ModelPart ConsoleCollarOne6;
	private final ModelPart panel_two_glowies;
	private final ModelPart panel_three_lights;
	private final ModelPart bone5;
	private final ModelPart bone6;
	private final ModelPart crank_lever;
	private final ModelPart bone7;
	private final ModelPart buttons;
	private final ModelPart control_two;
	private final ModelPart control_three;
	private final ModelPart control_four;
	private final ModelPart bone8;
	private final ModelPart bone9;
	private final ModelPart bone10;
	private final ModelPart useless_ass_panel;
	private final ModelPart lamp;
	private final ModelPart throttle;
	private final ModelPart handbrake;
	private final ModelPart x;
	private final ModelPart y;
	private final ModelPart z;
	private final ModelPart increment;
	private final ModelPart randomiser;
	private final ModelPart communicator;
	private final ModelPart monitor;
	private final ModelPart refuller;
	private final ModelPart door_control;
	private final ModelPart dimension_changer;
	private final ModelPart exterior_facing;
	private final ModelPart fast_return_switch;
	private final ModelPart bb_main;

	ConsoleBlockEntity.SharedValues sharedValues = ConsoleBlockEntity.SharedValues.getInstance();

	public HudolinConsoleModel(ModelPart root) {
		this.console_plinth_one = root.getChild("console_plinth_one");
		this.console_plinth_two = root.getChild("console_plinth_two");
		this.console_plinth_three = root.getChild("console_plinth_three");
		this.clawlegs = root.getChild("clawlegs");
		this.clawlegs2 = root.getChild("clawlegs2");
		this.clawlegs3 = root.getChild("clawlegs3");
		this.under_console_struts = root.getChild("under_console_struts");
		this.console_corners = root.getChild("console_corners");
		this.console_collar_one = root.getChild("console_collar_one");
		this.console_collar_two = root.getChild("console_collar_two");
		this.panel = root.getChild("panel");
		this.panel2 = root.getChild("panel2");
		this.panel3 = root.getChild("panel3");
		this.panel4 = root.getChild("panel4");
		this.panel5 = root.getChild("panel5");
		this.panel6 = root.getChild("panel6");
		this.bone2 = root.getChild("bone2");
		this.bone3 = root.getChild("bone3");
		this.bone4 = root.getChild("bone4");
		this.bone = root.getChild("bone");
		this.base = root.getChild("base");
		this.bottom_rotor = root.getChild("bottom_rotor");
		this.top_rotor = root.getChild("top_rotor");
		this.upper_console_one = root.getChild("upper_console_one");
		this.upper_console_two = root.getChild("upper_console_two");
		this.ConsoleCollarTwo3 = root.getChild("ConsoleCollarTwo3");
		this.ConsoleCollarOne6 = root.getChild("ConsoleCollarOne6");
		this.panel_two_glowies = root.getChild("panel_two_glowies");
		this.panel_three_lights = root.getChild("panel_three_lights");
		this.bone5 = root.getChild("bone5");
		this.bone6 = root.getChild("bone6");
		this.crank_lever = root.getChild("crank_lever");
		this.bone7 = root.getChild("bone7");
		this.buttons = root.getChild("buttons");
		this.control_two = root.getChild("control_two");
		this.control_three = root.getChild("control_three");
		this.control_four = root.getChild("control_four");
		this.bone8 = root.getChild("bone8");
		this.bone9 = root.getChild("bone9");
		this.bone10 = root.getChild("bone10");
		this.useless_ass_panel = root.getChild("useless_ass_panel");
		this.lamp = root.getChild("lamp");
		this.throttle = root.getChild("throttle");
		this.handbrake = root.getChild("handbrake");
		this.x = root.getChild("x");
		this.y = root.getChild("y");
		this.z = root.getChild("z");
		this.increment = root.getChild("increment");
		this.randomiser = root.getChild("randomiser");
		this.communicator = root.getChild("communicator");
		this.monitor = root.getChild("monitor");
		this.refuller = root.getChild("refuller");
		this.door_control = root.getChild("door_control");
		this.dimension_changer = root.getChild("dimension_changer");
		this.exterior_facing = root.getChild("exterior_facing");
		this.fast_return_switch = root.getChild("fast_return_switch");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition console_plinth_one = partdefinition.addOrReplaceChild("console_plinth_one", CubeListBuilder.create(), PartPose.offset(0.0F, -15.8F, 0.0F));

		PartDefinition corner_one_r1 = console_plinth_one.addOrReplaceChild("corner_one_r1", CubeListBuilder.create().texOffs(162, 37).addBox(-0.093F, -1.817F, 9.9186F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0799F, 40.624F, 0.1534F, 0.0F, -0.576F, 0.0F));

		PartDefinition corner_one_r2 = console_plinth_one.addOrReplaceChild("corner_one_r2", CubeListBuilder.create().texOffs(162, 5).addBox(-0.343F, -1.817F, -11.2564F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0799F, 40.624F, 0.1534F, 0.0F, -0.4887F, 0.0F));

		PartDefinition corner_one_r3 = console_plinth_one.addOrReplaceChild("corner_one_r3", CubeListBuilder.create().texOffs(105, 167).addBox(-0.093F, -1.817F, 9.9186F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0799F, 40.624F, 0.1534F, 0.0F, 1.5272F, 0.0F));

		PartDefinition corner_one_r4 = console_plinth_one.addOrReplaceChild("corner_one_r4", CubeListBuilder.create().texOffs(163, 18).addBox(-0.043F, -1.817F, -11.2564F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0799F, 40.624F, 0.1534F, -3.1416F, 1.5272F, 3.1416F));

		PartDefinition corner_one_r5 = console_plinth_one.addOrReplaceChild("corner_one_r5", CubeListBuilder.create().texOffs(110, 167).addBox(-0.093F, -1.817F, 9.9186F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0799F, 40.624F, 0.1534F, 0.0F, 0.48F, 0.0F));

		PartDefinition corner_one_r6 = console_plinth_one.addOrReplaceChild("corner_one_r6", CubeListBuilder.create().texOffs(133, 167).addBox(-0.043F, -1.817F, -11.2564F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0799F, 40.624F, 0.1534F, 0.0F, 0.5672F, 0.0F));

		PartDefinition cube_r1 = console_plinth_one.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(55, 52).addBox(-4.9363F, -3.279F, -10.0349F, 10.0F, 1.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 42.064F, 0.0F, -3.1416F, 1.0472F, 3.1416F));

		PartDefinition cube_r2 = console_plinth_one.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 72).addBox(-4.9363F, -3.279F, -10.0349F, 10.0F, 1.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 42.064F, 0.0F, -3.1416F, -1.0472F, 3.1416F));

		PartDefinition cube_r3 = console_plinth_one.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(41, 88).addBox(-4.9363F, -3.279F, -10.0349F, 10.0F, 1.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 42.064F, 0.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition console_plinth_two = partdefinition.addOrReplaceChild("console_plinth_two", CubeListBuilder.create(), PartPose.offset(0.0F, -0.7F, 0.0F));

		PartDefinition corner_one_r7 = console_plinth_two.addOrReplaceChild("corner_one_r7", CubeListBuilder.create().texOffs(161, 53).addBox(-0.45F, -1.0F, -9.0121F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.0626F, 22.575F, 0.0698F, 0.0F, -0.5236F, 0.0F));

		PartDefinition corner_one_r8 = console_plinth_two.addOrReplaceChild("corner_one_r8", CubeListBuilder.create().texOffs(162, 0).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-8.3255F, 23.075F, 0.0198F, 0.0F, 1.5708F, 0.0F));

		PartDefinition corner_one_r9 = console_plinth_two.addOrReplaceChild("corner_one_r9", CubeListBuilder.create().texOffs(25, 162).addBox(-0.55F, -1.0F, -8.7621F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0874F, 22.575F, 0.0698F, 0.0F, -1.5708F, 0.0F));

		PartDefinition corner_one_r10 = console_plinth_two.addOrReplaceChild("corner_one_r10", CubeListBuilder.create().texOffs(120, 25).addBox(-0.45F, -1.0F, -8.9871F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0624F, 22.575F, 0.1198F, 0.0F, 0.5236F, 0.0F));

		PartDefinition corner_one_r11 = console_plinth_two.addOrReplaceChild("corner_one_r11", CubeListBuilder.create().texOffs(69, 163).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(4.17F, 23.075F, 7.2307F, 0.0F, -2.618F, 0.0F));

		PartDefinition corner_one_r12 = console_plinth_two.addOrReplaceChild("corner_one_r12", CubeListBuilder.create().texOffs(91, 163).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-4.1862F, 23.075F, 7.3157F, 0.0F, 2.618F, 0.0F));

		PartDefinition cube_r4 = console_plinth_two.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(33, 138).addBox(-4.044F, -2.218F, -7.996F, 8.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 23.7F, 0.0F, -3.1416F, 1.0472F, 3.1416F));

		PartDefinition cube_r5 = console_plinth_two.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(138, 81).addBox(-4.044F, -2.218F, -7.996F, 8.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 23.7F, 0.0F, -3.1416F, -1.0472F, 3.1416F));

		PartDefinition cube_r6 = console_plinth_two.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 142).addBox(-4.044F, -2.218F, -7.996F, 8.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 23.7F, 0.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition console_plinth_two2 = console_plinth_two.addOrReplaceChild("console_plinth_two2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition corner_one_r13 = console_plinth_two2.addOrReplaceChild("corner_one_r13", CubeListBuilder.create().texOffs(35, 162).addBox(-1.19F, -1.21F, -7.7259F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.0563F, 20.3175F, 0.0628F, 0.0F, -0.6109F, 0.0F));

		PartDefinition corner_one_r14 = console_plinth_two2.addOrReplaceChild("corner_one_r14", CubeListBuilder.create().texOffs(163, 25).addBox(-0.56F, -1.66F, -0.44F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-7.493F, 20.7675F, 0.0178F, 0.0F, 1.5708F, 0.0F));

		PartDefinition corner_one_r15 = console_plinth_two2.addOrReplaceChild("corner_one_r15", CubeListBuilder.create().texOffs(132, 81).addBox(0.42F, -1.21F, -7.4759F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0787F, 20.3175F, 0.0628F, 0.0F, -1.4399F, 0.0F));

		PartDefinition corner_one_r16 = console_plinth_two2.addOrReplaceChild("corner_one_r16", CubeListBuilder.create().texOffs(159, 139).addBox(-1.265F, -1.21F, -7.8034F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0562F, 20.3175F, 0.1078F, 0.0F, 0.4363F, 0.0F));

		PartDefinition corner_one_r17 = console_plinth_two2.addOrReplaceChild("corner_one_r17", CubeListBuilder.create().texOffs(40, 162).addBox(-0.46F, -1.66F, -0.29F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(3.753F, 20.7675F, 6.5076F, 0.0F, -2.618F, 0.0F));

		PartDefinition corner_one_r18 = console_plinth_two2.addOrReplaceChild("corner_one_r18", CubeListBuilder.create().texOffs(161, 9).addBox(-0.46F, -1.66F, -0.34F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-3.7676F, 20.7675F, 6.5842F, 0.0F, 2.6616F, 0.0F));

		PartDefinition cube_r7 = console_plinth_two2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(152, 44).addBox(-3.5396F, -2.2962F, -7.1964F, 7.0F, 3.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.33F, 0.0F, -3.1416F, 1.0472F, 3.1416F));

		PartDefinition cube_r8 = console_plinth_two2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(153, 0).addBox(-3.4396F, -2.2962F, -6.9214F, 7.0F, 3.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.33F, 0.0F, -3.1416F, -1.0472F, 3.1416F));

		PartDefinition cube_r9 = console_plinth_two2.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(35, 158).addBox(-3.4396F, -2.2962F, -7.0964F, 7.0F, 3.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.33F, 0.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition bone11 = console_plinth_two2.addOrReplaceChild("bone11", CubeListBuilder.create().texOffs(125, 33).addBox(-2.7F, -2.0F, 6.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(125, 33).addBox(-0.6F, -2.0F, 6.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(125, 33).addBox(1.5F, -2.0F, 6.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 21.675F, 0.0F));

		PartDefinition bone12 = console_plinth_two2.addOrReplaceChild("bone12", CubeListBuilder.create().texOffs(125, 33).addBox(-2.7F, -2.0F, 6.05F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(125, 33).addBox(-0.6F, -2.0F, 6.05F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(125, 33).addBox(1.5F, -2.0F, 6.05F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 21.675F, -0.1F, 0.0F, 2.0944F, 0.0F));

		PartDefinition bone13 = console_plinth_two2.addOrReplaceChild("bone13", CubeListBuilder.create().texOffs(125, 33).addBox(-2.425F, -2.0F, 6.15F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(125, 33).addBox(-0.325F, -2.0F, 6.15F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(125, 33).addBox(1.775F, -2.0F, 6.15F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 21.675F, -0.1F, 0.0F, -2.0944F, 0.0F));

		PartDefinition bone14 = console_plinth_two2.addOrReplaceChild("bone14", CubeListBuilder.create().texOffs(125, 33).addBox(1.675F, -2.0F, 6.05F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(125, 33).addBox(-2.425F, -2.0F, 6.05F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 21.675F, 0.3F, 0.0F, 1.0472F, 0.0F));

		PartDefinition bone15 = console_plinth_two2.addOrReplaceChild("bone15", CubeListBuilder.create().texOffs(125, 33).addBox(1.675F, -2.0F, 6.05F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(125, 33).addBox(-2.425F, -2.0F, 6.05F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.1F, 21.675F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition bone16 = console_plinth_two2.addOrReplaceChild("bone16", CubeListBuilder.create().texOffs(125, 33).addBox(1.675F, -2.0F, 6.45F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(125, 33).addBox(-2.425F, -2.0F, 6.45F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.1F, 21.675F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition console_plinth_three = partdefinition.addOrReplaceChild("console_plinth_three", CubeListBuilder.create(), PartPose.offset(0.0F, -15.6F, 0.0F));

		PartDefinition corner_one_r19 = console_plinth_three.addOrReplaceChild("corner_one_r19", CubeListBuilder.create().texOffs(55, 94).addBox(-0.45F, -1.0F, -9.0121F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(64, 163).addBox(-0.4482F, -1.0F, 7.837F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.0626F, 25.575F, 0.0698F, 0.0F, -0.5236F, 0.0F));

		PartDefinition corner_one_r20 = console_plinth_three.addOrReplaceChild("corner_one_r20", CubeListBuilder.create().texOffs(104, 44).addBox(-0.55F, -1.0F, 7.9129F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(66, 115).addBox(-0.55F, -1.0F, -8.7621F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0874F, 25.575F, 0.0698F, 0.0F, -1.5708F, 0.0F));

		PartDefinition corner_one_r21 = console_plinth_three.addOrReplaceChild("corner_one_r21", CubeListBuilder.create().texOffs(33, 94).addBox(-0.45F, -1.0F, -8.9871F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(163, 30).addBox(-0.4982F, -1.0F, 7.712F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0624F, 25.575F, 0.1198F, 0.0F, 0.5236F, 0.0F));

		PartDefinition cube_r10 = console_plinth_three.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(120, 5).addBox(-4.044F, -2.218F, -7.996F, 8.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 26.7F, 0.0F, -3.1416F, 1.0472F, 3.1416F));

		PartDefinition cube_r11 = console_plinth_three.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 122).addBox(-4.044F, -2.218F, -7.996F, 8.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 26.7F, 0.0F, -3.1416F, -1.0472F, 3.1416F));

		PartDefinition cube_r12 = console_plinth_three.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(115, 128).addBox(-4.044F, -2.218F, -7.996F, 8.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 26.7F, 0.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition clawlegs = partdefinition.addOrReplaceChild("clawlegs", CubeListBuilder.create(), PartPose.offset(-6.2419F, 28.3721F, 3.8953F));

		PartDefinition cube_r13 = clawlegs.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(159, 67).addBox(5.882F, -6.86F, -0.886F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(152, 44).addBox(2.902F, -6.92F, -0.876F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, 0.0F, 3.1416F, -0.5236F, 3.1416F));

		PartDefinition cube_r14 = clawlegs.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(93, 47).addBox(-0.5F, -1.0F, -0.95F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5853F, -7.1123F, 0.2412F, -2.8449F, -0.4363F, 2.5133F));

		PartDefinition cube_r15 = clawlegs.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(82, 88).addBox(-1.175F, -1.2F, -1.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2901F, -8.5239F, -0.3154F, -2.618F, 0.0F, 1.5708F));

		PartDefinition clawlegs2 = partdefinition.addOrReplaceChild("clawlegs2", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.0919F, 28.3721F, -7.1797F, 0.0F, -2.0944F, 0.0F));

		PartDefinition cube_r16 = clawlegs2.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(159, 67).addBox(5.882F, -6.36F, -0.886F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(151, 0).addBox(2.902F, -6.42F, -0.876F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 3.1416F, -0.5236F, 3.1416F));

		PartDefinition cube_r17 = clawlegs2.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(33, 148).addBox(-0.2336F, -0.5769F, -0.9569F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5853F, -7.6123F, 0.2412F, -2.8449F, -0.4363F, 2.5133F));

		PartDefinition cube_r18 = clawlegs2.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(41, 78).addBox(-0.55F, -1.2026F, -0.9984F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2901F, -9.0239F, -0.3154F, -2.618F, 0.0F, 1.5708F));

		PartDefinition clawlegs3 = partdefinition.addOrReplaceChild("clawlegs3", CubeListBuilder.create(), PartPose.offsetAndRotation(6.4081F, 28.3721F, 3.8203F, 0.0F, 2.0944F, 0.0F));

		PartDefinition cube_r19 = clawlegs3.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(159, 67).addBox(5.882F, -6.36F, -0.886F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(143, 148).addBox(2.902F, -6.42F, -0.876F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 3.1416F, -0.5236F, 3.1416F));

		PartDefinition cube_r20 = clawlegs3.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(60, 64).addBox(-0.2336F, -0.5769F, -0.9569F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5853F, -7.6123F, 0.2412F, -2.8449F, -0.4363F, 2.5133F));

		PartDefinition cube_r21 = clawlegs3.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(41, 72).addBox(-0.65F, -1.2026F, -0.9984F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2901F, -9.0239F, -0.3154F, -2.618F, 0.0F, 1.5708F));

		PartDefinition under_console_struts = partdefinition.addOrReplaceChild("under_console_struts", CubeListBuilder.create(), PartPose.offset(-0.075F, 23.7F, 0.0F));

		PartDefinition cube_r22 = under_console_struts.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(0, 142).addBox(-1.137F, -21.08F, -2.62F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.6981F, 2.0944F, 0.0F));

		PartDefinition cube_r23 = under_console_struts.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(9, 72).addBox(-1.037F, -20.98F, -2.62F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.6981F, -2.0944F, 0.0F));

		PartDefinition cube_r24 = under_console_struts.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(0, 72).addBox(-1.037F, -21.03F, -2.62F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.6981F, 0.0F, 0.0F));

		PartDefinition console_corners = partdefinition.addOrReplaceChild("console_corners", CubeListBuilder.create(), PartPose.offset(0.0F, 29.018F, -10.66F));

		PartDefinition corner_r1 = console_corners.addOrReplaceChild("corner_r1", CubeListBuilder.create().texOffs(33, 142).addBox(-24.5574F, -1.0F, -2.4577F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -19.218F, 10.66F, 0.0F, -1.0079F, 0.0F));

		PartDefinition corner_r2 = console_corners.addOrReplaceChild("corner_r2", CubeListBuilder.create().texOffs(82, 122).addBox(-24.5574F, -1.0F, -2.4577F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -19.218F, 10.66F, -3.1416F, 1.0036F, 3.1416F));

		PartDefinition corner_r3 = console_corners.addOrReplaceChild("corner_r3", CubeListBuilder.create().texOffs(82, 94).addBox(-24.5574F, -1.0F, -2.4577F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -19.218F, 10.66F, -3.1416F, -1.0865F, 3.1416F));

		PartDefinition corner_r4 = console_corners.addOrReplaceChild("corner_r4", CubeListBuilder.create().texOffs(96, 53).addBox(-24.5574F, -1.0F, -2.4577F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -19.218F, 10.66F, 0.0F, 1.0908F, 0.0F));

		PartDefinition corner_r5 = console_corners.addOrReplaceChild("corner_r5", CubeListBuilder.create().texOffs(96, 59).addBox(-1.475F, -1.0F, -1.55F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(23.0F, -19.218F, 10.56F, -3.1416F, 0.0428F, 3.1416F));

		PartDefinition corner_r6 = console_corners.addOrReplaceChild("corner_r6", CubeListBuilder.create().texOffs(145, 102).addBox(-1.475F, -1.0F, -1.55F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-23.2F, -19.218F, 10.76F, 0.0F, 0.0436F, 0.0F));

		PartDefinition console_collar_one = partdefinition.addOrReplaceChild("console_collar_one", CubeListBuilder.create(), PartPose.offset(0.0F, -3.5F, 0.0F));

		PartDefinition corner_one_r22 = console_collar_one.addOrReplaceChild("corner_one_r22", CubeListBuilder.create().texOffs(87, 128).addBox(-0.45F, -1.0F, -9.0121F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(125, 128).addBox(-0.4482F, -1.0F, 7.837F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.0626F, 4.575F, 0.0698F, 0.0F, -0.5236F, 0.0F));

		PartDefinition corner_one_r23 = console_collar_one.addOrReplaceChild("corner_one_r23", CubeListBuilder.create().texOffs(76, 122).addBox(-0.55F, -1.0F, 7.9129F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(82, 128).addBox(-0.55F, -1.0F, -8.7621F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0874F, 4.575F, 0.0698F, 0.0F, -1.5708F, 0.0F));

		PartDefinition corner_one_r24 = console_collar_one.addOrReplaceChild("corner_one_r24", CubeListBuilder.create().texOffs(97, 102).addBox(-0.45F, -1.0F, -8.9871F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(115, 128).addBox(-0.4982F, -1.0F, 7.712F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0624F, 4.575F, 0.1198F, 0.0F, 0.5236F, 0.0F));

		PartDefinition cube_r25 = console_collar_one.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(148, 120).addBox(-4.044F, -2.218F, -7.996F, 8.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.7F, 0.0F, -3.1416F, 1.0472F, 3.1416F));

		PartDefinition cube_r26 = console_collar_one.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(148, 139).addBox(-4.044F, -2.218F, -7.996F, 8.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.7F, 0.0F, -3.1416F, -1.0472F, 3.1416F));

		PartDefinition cube_r27 = console_collar_one.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(152, 25).addBox(-4.044F, -2.218F, -7.996F, 8.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.7F, 0.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition console_collar_two = partdefinition.addOrReplaceChild("console_collar_two", CubeListBuilder.create(), PartPose.offset(0.095F, 21.1F, -0.206F));

		PartDefinition corner_one_r25 = console_collar_two.addOrReplaceChild("corner_one_r25", CubeListBuilder.create().texOffs(5, 167).addBox(-0.5232F, -2.65F, 5.687F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 167).addBox(-0.5232F, -2.65F, -6.788F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1576F, -20.925F, 0.2758F, 0.0F, -0.5236F, 0.0F));

		PartDefinition corner_one_r26 = console_collar_two.addOrReplaceChild("corner_one_r26", CubeListBuilder.create().texOffs(166, 163).addBox(-0.4482F, -2.65F, 5.687F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(44, 166).addBox(-0.4482F, -2.65F, -6.763F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1576F, -20.925F, 0.2758F, 0.0F, 0.5236F, 0.0F));

		PartDefinition corner_one_r27 = console_collar_two.addOrReplaceChild("corner_one_r27", CubeListBuilder.create().texOffs(165, 62).addBox(-0.5482F, -2.65F, 5.687F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(161, 163).addBox(-0.5732F, -2.65F, -6.738F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1576F, -20.925F, 0.2758F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r28 = console_collar_two.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(171, 78).addBox(-2.96F, -4.418F, -6.282F, 6.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.403F, -19.14F, 0.338F, -3.1416F, -2.0944F, 3.1416F));

		PartDefinition cube_r29 = console_collar_two.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(175, 94).addBox(-3.26F, -4.418F, -6.182F, 6.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.403F, -19.14F, 0.338F, -3.1416F, -1.0472F, 3.1416F));

		PartDefinition cube_r30 = console_collar_two.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(25, 176).addBox(-3.26F, -4.418F, -5.882F, 6.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.403F, -19.14F, 0.338F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition bone17 = console_collar_two.addOrReplaceChild("bone17", CubeListBuilder.create().texOffs(125, 33).addBox(-2.65F, -2.0F, 5.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(125, 33).addBox(-0.55F, -2.0F, 5.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(125, 33).addBox(1.55F, -2.0F, 5.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offset(-0.095F, -20.825F, 0.206F));

		PartDefinition bone18 = console_collar_two.addOrReplaceChild("bone18", CubeListBuilder.create().texOffs(125, 33).addBox(-2.6F, -2.0F, 5.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(125, 33).addBox(-0.5F, -2.0F, 5.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(125, 33).addBox(1.6F, -2.0F, 5.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.095F, -20.825F, 0.206F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone19 = console_collar_two.addOrReplaceChild("bone19", CubeListBuilder.create().texOffs(125, 33).addBox(-2.65F, -2.0F, 5.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(125, 33).addBox(-0.55F, -2.0F, 5.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(125, 33).addBox(1.55F, -2.0F, 5.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.095F, -20.825F, 0.206F, 0.0F, 1.0472F, 0.0F));

		PartDefinition bone20 = console_collar_two.addOrReplaceChild("bone20", CubeListBuilder.create().texOffs(125, 33).addBox(-2.65F, -2.0F, 5.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(125, 33).addBox(-0.55F, -2.0F, 5.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(125, 33).addBox(1.55F, -2.0F, 5.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.195F, -20.825F, 0.256F, 0.0F, 3.1416F, 0.0F));

		PartDefinition bone21 = console_collar_two.addOrReplaceChild("bone21", CubeListBuilder.create().texOffs(125, 33).addBox(-2.65F, -2.0F, 5.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(125, 33).addBox(-0.55F, -2.0F, 5.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(125, 33).addBox(1.55F, -2.0F, 5.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.195F, -20.825F, 0.256F, 0.0F, 2.0944F, 0.0F));

		PartDefinition bone22 = console_collar_two.addOrReplaceChild("bone22", CubeListBuilder.create().texOffs(125, 33).addBox(-2.65F, -2.0F, 5.225F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(125, 33).addBox(-0.55F, -2.0F, 5.225F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(125, 33).addBox(1.55F, -2.0F, 5.225F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.195F, -20.825F, 0.256F, 0.0F, -2.0944F, 0.0F));

		PartDefinition panel = partdefinition.addOrReplaceChild("panel", CubeListBuilder.create().texOffs(60, 21).addBox(-11.0029F, 5.2697F, 6.9223F, 22.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.0371F, 3.5283F, 0.0187F));

		PartDefinition cube_r31 = panel.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(103, 67).addBox(-11.5F, -8.1965F, 2.9073F, 21.0F, 0.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0371F, 0.5717F, -0.8187F, -0.7418F, 0.0F, 0.0F));

		PartDefinition panel2 = partdefinition.addOrReplaceChild("panel2", CubeListBuilder.create().texOffs(60, 3).addBox(-11.0029F, 5.2697F, 6.9223F, 22.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0371F, 3.5283F, 0.0187F, 0.0F, -1.0472F, 0.0F));

		PartDefinition cube_r32 = panel2.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(89, 102).addBox(-11.3F, -6.1321F, 4.799F, 21.0F, 0.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0371F, -2.2283F, -0.8187F, -0.7418F, 0.0F, 0.0F));

		PartDefinition panel3 = partdefinition.addOrReplaceChild("panel3", CubeListBuilder.create().texOffs(0, 54).addBox(-11.0029F, 5.2697F, 6.9223F, 22.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0371F, 3.5283F, 0.0187F, 0.0F, -2.0944F, 0.0F));

		PartDefinition cube_r33 = panel3.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(96, 53).addBox(-11.5F, -6.1321F, 4.799F, 21.0F, 0.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0371F, -2.2283F, -0.8187F, -0.7418F, 0.0F, 0.0F));

		PartDefinition panel4 = partdefinition.addOrReplaceChild("panel4", CubeListBuilder.create().texOffs(0, 36).addBox(-11.0029F, 5.2697F, 6.9223F, 22.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0371F, 3.5283F, 0.0187F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r34 = panel4.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(96, 39).addBox(-11.5F, -6.1321F, 4.799F, 21.0F, 0.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0371F, -2.2283F, -0.8187F, -0.7418F, 0.0F, 0.0F));

		PartDefinition panel5 = partdefinition.addOrReplaceChild("panel5", CubeListBuilder.create().texOffs(0, 18).addBox(-11.0029F, 5.2697F, 6.9223F, 22.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0371F, 3.5283F, 0.0187F, 0.0F, 2.0944F, 0.0F));

		PartDefinition cube_r35 = panel5.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(82, 88).addBox(-11.5F, -6.1321F, 4.799F, 21.0F, 0.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0371F, -2.2283F, -0.8187F, -0.7418F, 0.0F, 0.0F));

		PartDefinition panel6 = partdefinition.addOrReplaceChild("panel6", CubeListBuilder.create().texOffs(0, 0).addBox(-11.0029F, 5.2697F, 6.9223F, 22.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0371F, 3.5283F, 0.0187F, 0.0F, 1.0472F, 0.0F));

		PartDefinition cube_r36 = panel6.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(41, 74).addBox(-11.5F, -6.1321F, 4.799F, 21.0F, 0.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0371F, -2.2283F, -0.8187F, -0.7418F, 0.0F, 0.0F));

		PartDefinition bone2 = partdefinition.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offsetAndRotation(9.9198F, 3.1201F, 5.6383F, 0.0F, 2.0944F, 0.0F));

		PartDefinition corner_r7 = bone2.addOrReplaceChild("corner_r7", CubeListBuilder.create().texOffs(0, 94).addBox(0.7713F, -5.2958F, -1.0849F, 3.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5917F, 0.0608F, 6.0529F, 0.9505F, 0.5656F, 1.2216F));

		PartDefinition corner_r8 = bone2.addOrReplaceChild("corner_r8", CubeListBuilder.create().texOffs(0, 122).addBox(-11.0181F, 5.2816F, -0.0165F, 3.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.2802F, 2.7799F, -6.2383F, 0.0F, 0.0F, 0.9163F));

		PartDefinition bone3 = partdefinition.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offset(-6.3884F, 3.2809F, 11.8912F));

		PartDefinition corner_r9 = bone3.addOrReplaceChild("corner_r9", CubeListBuilder.create().texOffs(120, 0).addBox(-1.45F, -7.0F, -0.9F, 3.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.8F, 0.0F, 0.9505F, 0.5656F, 1.2216F));

		PartDefinition corner_r10 = bone3.addOrReplaceChild("corner_r10", CubeListBuilder.create().texOffs(66, 138).addBox(-13.2395F, 3.577F, -0.0915F, 3.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.6884F, 5.5191F, -12.2912F, 0.0F, 0.0F, 0.9163F));

		PartDefinition bone4 = partdefinition.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.9884F, 3.2809F, -11.4088F, 0.0F, -2.0944F, 0.0F));

		PartDefinition corner_r11 = bone4.addOrReplaceChild("corner_r11", CubeListBuilder.create().texOffs(138, 81).addBox(0.7713F, -5.2958F, -0.8599F, 3.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.9505F, 0.5656F, 1.2216F));

		PartDefinition corner_r12 = bone4.addOrReplaceChild("corner_r12", CubeListBuilder.create().texOffs(99, 144).addBox(-11.0181F, 5.2816F, -0.0915F, 3.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.6884F, 2.7191F, -12.2912F, 0.0F, 0.0F, 0.9163F));

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(97, 74).addBox(-13.7738F, 5.9336F, 4.6663F, 5.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(60, 59).addBox(-13.2808F, 5.2736F, 5.1563F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(57, 199).addBox(-13.2808F, 5.0736F, 6.1563F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(6.6188F, 2.3504F, 12.4767F));

		PartDefinition cube_r37 = bone.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(82, 102).addBox(-2.4855F, -0.41F, -1.9865F, 5.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4083F, 6.6436F, 5.6878F, -0.0436F, 0.0F, 0.0F));

		PartDefinition cube_r38 = bone.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(154, 148).addBox(-3.64F, -0.6F, -2.62F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(155, 120).addBox(2.36F, -0.6F, -2.62F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(161, 158).addBox(-0.64F, -0.825F, -2.62F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(96, 67).addBox(-2.74F, -0.6F, -0.02F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(138, 120).addBox(-2.74F, -0.6F, 2.7F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(60, 11).addBox(3.72F, -0.525F, 2.678F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(97, 81).addBox(-7.14F, -0.6F, 5.42F, 15.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.9538F, 1.3496F, -2.3367F, -0.7418F, 0.0F, 0.0F));

		PartDefinition base = partdefinition.addOrReplaceChild("base", CubeListBuilder.create().texOffs(60, 0).addBox(-3.195F, -9.268F, 5.409F, 6.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.172F, 20.82F, -0.065F));

		PartDefinition cube_r39 = base.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(60, 21).addBox(-2.785F, -12.218F, 5.5F, 6.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.8F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition cube_r40 = base.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(0, 54).addBox(-3.008F, -11.818F, 5.669F, 6.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.65F, 2.8F, 0.078F, 0.0F, 1.0516F, 0.0F));

		PartDefinition cube_r41 = base.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(0, 36).addBox(-3.035F, -11.818F, 5.5F, 6.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.403F, 2.8F, 0.338F, -3.1416F, 1.0472F, 3.1416F));

		PartDefinition cube_r42 = base.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(0, 18).addBox(-3.435F, -11.818F, 5.318F, 6.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.455F, 2.8F, 0.247F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r43 = base.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(0, 0).addBox(-3.737F, -11.818F, 4.603F, 6.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.053F, 2.8F, 0.416F, -3.1416F, -1.0516F, 3.1416F));

		PartDefinition bottom_rotor = partdefinition.addOrReplaceChild("bottom_rotor", CubeListBuilder.create().texOffs(103, 183).addBox(2.66F, -13.16F, -1.31F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(145, 179).addBox(-1.54F, -13.16F, 2.87F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.075F, 2.0F, -0.325F));

		PartDefinition cube_r44 = bottom_rotor.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(140, 179).addBox(-0.5F, -8.0F, -1.0F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.68F, -5.16F, 3.37F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r45 = bottom_rotor.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(155, 179).addBox(-0.5F, -8.0F, -0.5F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.02F, -5.16F, -0.81F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r46 = bottom_rotor.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(129, 0).addBox(-0.5F, -8.0F, -0.5F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.02F, -5.16F, 1.29F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r47 = bottom_rotor.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(150, 179).addBox(-0.5F, -8.0F, -0.5F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.16F, -5.16F, 1.29F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r48 = bottom_rotor.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(108, 183).addBox(-0.5F, -8.0F, -0.5F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.04F, -5.16F, -2.89F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r49 = bottom_rotor.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(113, 183).addBox(-1.0F, -8.0F, -0.5F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.68F, -5.16F, -2.89F, 0.0F, 3.1416F, 0.0F));

		PartDefinition bottom_rotor_ring = bottom_rotor.addOrReplaceChild("bottom_rotor_ring", CubeListBuilder.create(), PartPose.offset(0.17F, 18.1F, 0.119F));

		PartDefinition cube_r50 = bottom_rotor_ring.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(135, 25).addBox(-2.96F, -2.418F, -5.282F, 6.0F, 1.0F, 10.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.403F, -23.14F, 0.338F, -3.1416F, -2.0944F, 3.1416F));

		PartDefinition cube_r51 = bottom_rotor_ring.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(60, 39).addBox(-3.26F, -2.418F, -5.182F, 6.0F, 1.0F, 10.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.403F, -23.14F, 0.338F, -3.1416F, -1.0472F, 3.1416F));

		PartDefinition cube_r52 = bottom_rotor_ring.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(115, 116).addBox(-3.26F, -2.418F, -4.882F, 6.0F, 1.0F, 10.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.403F, -23.14F, 0.338F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition bone29 = bottom_rotor_ring.addOrReplaceChild("bone29", CubeListBuilder.create(), PartPose.offset(-0.095F, -20.825F, 0.206F));

		PartDefinition bone30 = bottom_rotor_ring.addOrReplaceChild("bone30", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.095F, -20.825F, 0.206F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone31 = bottom_rotor_ring.addOrReplaceChild("bone31", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.095F, -20.825F, 0.206F, 0.0F, 1.0472F, 0.0F));

		PartDefinition bone32 = bottom_rotor_ring.addOrReplaceChild("bone32", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.195F, -20.825F, 0.256F, 0.0F, 3.1416F, 0.0F));

		PartDefinition bone33 = bottom_rotor_ring.addOrReplaceChild("bone33", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.195F, -20.825F, 0.256F, 0.0F, 2.0944F, 0.0F));

		PartDefinition bone34 = bottom_rotor_ring.addOrReplaceChild("bone34", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.195F, -20.825F, 0.256F, 0.0F, -2.0944F, 0.0F));

		PartDefinition top_rotor = partdefinition.addOrReplaceChild("top_rotor", CubeListBuilder.create().texOffs(175, 183).addBox(-0.8401F, -17.16F, -3.4292F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(165, 183).addBox(-3.9254F, -17.16F, -0.2382F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(160, 183).addBox(2.2513F, -17.16F, -0.2626F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(133, 183).addBox(-0.834F, -17.16F, 2.8534F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.325F, -31.5F, -0.325F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r53 = top_rotor.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(123, 183).addBox(-0.375F, -10.0F, -0.625F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3112F, -7.16F, 2.48F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r54 = top_rotor.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(128, 183).addBox(-0.125F, -10.0F, -0.825F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.347F, -7.16F, 2.9981F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r55 = top_rotor.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(170, 183).addBox(-0.525F, -10.0F, -0.85F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.137F, -7.16F, -1.9058F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r56 = top_rotor.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(118, 183).addBox(-1.075F, -10.0F, -0.4F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5211F, -7.16F, -2.4239F, 0.0F, 1.5708F, 0.0F));

		PartDefinition top_rotor_ring = top_rotor.addOrReplaceChild("top_rotor_ring", CubeListBuilder.create(), PartPose.offset(-0.155F, 25.35F, 0.531F));

		PartDefinition cube_r57 = top_rotor_ring.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(135, 25).addBox(-2.96F, -2.418F, -4.718F, 6.0F, 1.0F, 10.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.403F, -34.14F, -0.338F, 3.1416F, 2.0944F, 3.1416F));

		PartDefinition cube_r58 = top_rotor_ring.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(60, 39).addBox(-3.26F, -2.418F, -4.818F, 6.0F, 1.0F, 10.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.403F, -34.14F, -0.338F, 3.1416F, 1.0472F, 3.1416F));

		PartDefinition cube_r59 = top_rotor_ring.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(115, 116).addBox(-3.26F, -2.418F, -5.118F, 6.0F, 1.0F, 10.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.403F, -34.14F, -0.338F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition bone35 = top_rotor_ring.addOrReplaceChild("bone35", CubeListBuilder.create(), PartPose.offset(-0.095F, -20.825F, -0.206F));

		PartDefinition bone36 = top_rotor_ring.addOrReplaceChild("bone36", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.095F, -20.825F, -0.206F, 0.0F, 1.0472F, 0.0F));

		PartDefinition bone37 = top_rotor_ring.addOrReplaceChild("bone37", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.095F, -20.825F, -0.206F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone38 = top_rotor_ring.addOrReplaceChild("bone38", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.195F, -20.825F, -0.256F, 0.0F, -3.1416F, 0.0F));

		PartDefinition bone39 = top_rotor_ring.addOrReplaceChild("bone39", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.195F, -20.825F, -0.256F, 0.0F, -2.0944F, 0.0F));

		PartDefinition bone40 = top_rotor_ring.addOrReplaceChild("bone40", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.195F, -20.825F, -0.256F, 0.0F, 2.0944F, 0.0F));

		PartDefinition upper_console_one = partdefinition.addOrReplaceChild("upper_console_one", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.205F, -76.2F, -0.206F, 0.0F, 0.0F, -3.1416F));

		PartDefinition corner_one_r28 = upper_console_one.addOrReplaceChild("corner_one_r28", CubeListBuilder.create().texOffs(100, 167).addBox(-0.5232F, -4.65F, 5.687F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(25, 167).addBox(-0.5232F, -4.65F, -6.788F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1576F, -47.925F, 0.2758F, 0.0F, -0.5236F, 0.0F));

		PartDefinition corner_one_r29 = upper_console_one.addOrReplaceChild("corner_one_r29", CubeListBuilder.create().texOffs(30, 167).addBox(-0.4482F, -4.65F, 5.687F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(35, 167).addBox(-0.4482F, -4.65F, -6.763F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1576F, -47.925F, 0.2758F, 0.0F, 0.5236F, 0.0F));

		PartDefinition corner_one_r30 = upper_console_one.addOrReplaceChild("corner_one_r30", CubeListBuilder.create().texOffs(73, 167).addBox(-0.5482F, -4.65F, 5.687F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(95, 167).addBox(-0.5732F, -4.65F, -6.738F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1576F, -47.925F, 0.2758F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r60 = upper_console_one.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(159, 62).addBox(-2.96F, -6.418F, -6.282F, 6.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.403F, -46.14F, 0.338F, -3.1416F, -2.0944F, 3.1416F));

		PartDefinition cube_r61 = upper_console_one.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(103, 167).addBox(-3.26F, -6.418F, -6.182F, 6.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.403F, -46.14F, 0.338F, -3.1416F, -1.0472F, 3.1416F));

		PartDefinition cube_r62 = upper_console_one.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(161, 167).addBox(-3.26F, -6.418F, -5.882F, 6.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.403F, -46.14F, 0.338F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition bone23 = upper_console_one.addOrReplaceChild("bone23", CubeListBuilder.create().texOffs(125, 33).addBox(-2.65F, -2.0F, 5.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(125, 33).addBox(-0.55F, -2.0F, 5.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(125, 33).addBox(1.55F, -2.0F, 5.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offset(-0.095F, -49.825F, 0.206F));

		PartDefinition bone24 = upper_console_one.addOrReplaceChild("bone24", CubeListBuilder.create().texOffs(125, 33).addBox(-2.625F, -2.0F, 5.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(125, 33).addBox(-0.525F, -2.0F, 5.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(125, 33).addBox(1.575F, -2.0F, 5.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.095F, -49.825F, 0.206F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone25 = upper_console_one.addOrReplaceChild("bone25", CubeListBuilder.create().texOffs(125, 33).addBox(-2.625F, -2.0F, 5.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(125, 33).addBox(-0.525F, -2.0F, 5.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(125, 33).addBox(1.575F, -2.0F, 5.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.095F, -49.825F, 0.206F, 0.0F, 1.0472F, 0.0F));

		PartDefinition bone26 = upper_console_one.addOrReplaceChild("bone26", CubeListBuilder.create().texOffs(125, 33).addBox(-2.625F, -2.0F, 5.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(125, 33).addBox(-0.525F, -2.0F, 5.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(125, 33).addBox(1.575F, -2.0F, 5.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.095F, -49.825F, 0.206F, 0.0F, 2.0944F, 0.0F));

		PartDefinition bone27 = upper_console_one.addOrReplaceChild("bone27", CubeListBuilder.create().texOffs(125, 33).addBox(-2.625F, -2.0F, 5.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(125, 33).addBox(-0.525F, -2.0F, 5.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(125, 33).addBox(1.575F, -2.0F, 5.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.095F, -49.825F, 0.206F, 0.0F, 3.1416F, 0.0F));

		PartDefinition bone28 = upper_console_one.addOrReplaceChild("bone28", CubeListBuilder.create().texOffs(125, 33).addBox(-2.6F, -2.0F, 5.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(125, 33).addBox(-0.5F, -2.0F, 5.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(125, 33).addBox(1.6F, -2.0F, 5.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.095F, -49.825F, 0.206F, 0.0F, -2.0944F, 0.0F));

		PartDefinition upper_console_two = partdefinition.addOrReplaceChild("upper_console_two", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -54.5F, 0.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition corner_one_r31 = upper_console_two.addOrReplaceChild("corner_one_r31", CubeListBuilder.create().texOffs(42, 122).addBox(-0.45F, -3.0F, -9.0121F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(120, 128).addBox(-0.4482F, -3.0F, 7.837F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.0626F, -25.425F, 0.0698F, 0.0F, -0.5236F, 0.0F));

		PartDefinition corner_one_r32 = upper_console_two.addOrReplaceChild("corner_one_r32", CubeListBuilder.create().texOffs(66, 122).addBox(-0.55F, -3.0F, 7.9129F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(71, 122).addBox(-0.55F, -3.0F, -8.7621F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0874F, -25.425F, 0.0698F, 0.0F, -1.5708F, 0.0F));

		PartDefinition corner_one_r33 = upper_console_two.addOrReplaceChild("corner_one_r33", CubeListBuilder.create().texOffs(9, 65).addBox(-0.45F, -3.0F, -8.9871F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(92, 128).addBox(-0.4982F, -3.0F, 7.712F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0624F, -25.425F, 0.1198F, 0.0F, 0.5236F, 0.0F));

		PartDefinition cube_r63 = upper_console_two.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(142, 101).addBox(-4.044F, -4.218F, -7.996F, 8.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -24.3F, 0.0F, -3.1416F, 1.0472F, 3.1416F));

		PartDefinition cube_r64 = upper_console_two.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(66, 144).addBox(-4.044F, -4.218F, -7.996F, 8.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -24.3F, 0.0F, -3.1416F, -1.0472F, 3.1416F));

		PartDefinition cube_r65 = upper_console_two.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(99, 148).addBox(-4.044F, -4.218F, -7.996F, 8.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -24.3F, 0.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition ConsoleCollarTwo3 = partdefinition.addOrReplaceChild("ConsoleCollarTwo3", CubeListBuilder.create(), PartPose.offset(0.095F, 21.1F, -0.206F));

		PartDefinition corner_one_r34 = ConsoleCollarTwo3.addOrReplaceChild("corner_one_r34", CubeListBuilder.create().texOffs(158, 25).addBox(-0.5232F, -7.65F, 5.687F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(120, 116).addBox(-0.5232F, -7.65F, -6.788F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1576F, -48.925F, 0.2758F, 0.0F, -0.5236F, 0.0F));

		PartDefinition corner_one_r35 = ConsoleCollarTwo3.addOrReplaceChild("corner_one_r35", CubeListBuilder.create().texOffs(132, 153).addBox(-0.4482F, -7.65F, 5.687F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(137, 153).addBox(-0.4482F, -7.65F, -6.763F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1576F, -48.925F, 0.2758F, 0.0F, 0.5236F, 0.0F));

		PartDefinition corner_one_r36 = ConsoleCollarTwo3.addOrReplaceChild("corner_one_r36", CubeListBuilder.create().texOffs(142, 153).addBox(-0.5482F, -7.65F, 5.687F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(115, 116).addBox(-0.5732F, -7.65F, -6.738F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1576F, -48.925F, 0.2758F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r66 = ConsoleCollarTwo3.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(136, 158).addBox(-2.96F, -9.418F, -6.282F, 6.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.403F, -47.14F, 0.338F, -3.1416F, -2.0944F, 3.1416F));

		PartDefinition cube_r67 = ConsoleCollarTwo3.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(0, 164).addBox(-3.26F, -9.418F, -6.182F, 6.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.403F, -47.14F, 0.338F, -3.1416F, -1.0472F, 3.1416F));

		PartDefinition cube_r68 = ConsoleCollarTwo3.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(66, 164).addBox(-3.26F, -9.418F, -5.882F, 6.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.403F, -47.14F, 0.338F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition ConsoleCollarOne6 = partdefinition.addOrReplaceChild("ConsoleCollarOne6", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -50.5F, 0.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition corner_one_r37 = ConsoleCollarOne6.addOrReplaceChild("corner_one_r37", CubeListBuilder.create().texOffs(9, 122).addBox(-0.45F, -3.0F, -9.0121F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(147, 81).addBox(-0.4482F, -3.0F, 7.837F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.0626F, -16.425F, 0.0698F, 0.0F, -0.5236F, 0.0F));

		PartDefinition corner_one_r38 = ConsoleCollarOne6.addOrReplaceChild("corner_one_r38", CubeListBuilder.create().texOffs(75, 138).addBox(-0.55F, -3.0F, 7.9129F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(9, 142).addBox(-0.55F, -3.0F, -8.7621F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0874F, -16.425F, 0.0698F, 0.0F, -1.5708F, 0.0F));

		PartDefinition corner_one_r39 = ConsoleCollarOne6.addOrReplaceChild("corner_one_r39", CubeListBuilder.create().texOffs(9, 94).addBox(-0.45F, -3.0F, -8.9871F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(108, 144).addBox(-0.4982F, -3.0F, 7.712F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0624F, -16.425F, 0.1198F, 0.0F, 0.5236F, 0.0F));

		PartDefinition cube_r69 = ConsoleCollarOne6.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(0, 94).addBox(-4.044F, -4.218F, -7.996F, 8.0F, 11.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.3F, 0.0F, -3.1416F, 1.0472F, 3.1416F));

		PartDefinition cube_r70 = ConsoleCollarOne6.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(33, 110).addBox(-4.044F, -4.218F, -7.996F, 8.0F, 11.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.3F, 0.0F, -3.1416F, -1.0472F, 3.1416F));

		PartDefinition cube_r71 = ConsoleCollarOne6.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(82, 116).addBox(-4.044F, -4.218F, -7.996F, 8.0F, 11.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.3F, 0.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition panel_two_glowies = partdefinition.addOrReplaceChild("panel_two_glowies", CubeListBuilder.create(), PartPose.offset(1.0F, 1.3F, -0.8F));

		PartDefinition cube_r72 = panel_two_glowies.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(0, 29).addBox(-1.8F, -8.1567F, 6.2478F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 47).addBox(-1.8F, -8.1567F, 11.9478F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(83, 39).mirror().addBox(3.2F, -8.1567F, 9.6478F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(120, 25).mirror().addBox(-6.8F, -8.1567F, 9.6478F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.7418F, -1.0472F, 0.0F));

		PartDefinition panel_three_lights = partdefinition.addOrReplaceChild("panel_three_lights", CubeListBuilder.create(), PartPose.offset(1.95F, 0.55F, -0.8F));

		PartDefinition cube_r73 = panel_three_lights.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(135, 25).addBox(-2.375F, -7.9067F, 6.5728F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(152, 53).addBox(3.625F, -7.9067F, 6.5728F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(153, 5).addBox(0.625F, -7.9067F, 6.5728F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.7418F, -2.0944F, 0.0F));

		PartDefinition bone5 = partdefinition.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offset(1.95F, 0.55F, -0.8F));

		PartDefinition cube_r74 = bone5.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(91, 110).addBox(5.725F, -7.7067F, 13.5478F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.7418F, -2.0944F, 0.0F));

		PartDefinition bone6 = partdefinition.addOrReplaceChild("bone6", CubeListBuilder.create(), PartPose.offset(4.5826F, 4.3344F, -13.8459F));

		PartDefinition lights_right_r1 = bone6.addOrReplaceChild("lights_right_r1", CubeListBuilder.create().texOffs(33, 122).addBox(5.8F, -2.4F, 0.1F, 4.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 65).addBox(-2.4F, -2.4F, 0.1F, 4.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.2376F, 0.1919F, 1.8456F, -0.829F, 0.0F, 0.0F));

		PartDefinition dials = bone6.addOrReplaceChild("dials", CubeListBuilder.create(), PartPose.offset(-4.7026F, -3.6492F, 3.3765F));

		PartDefinition cube_r75 = dials.addOrReplaceChild("cube_r75", CubeListBuilder.create().texOffs(168, 18).addBox(2.2F, -2.1F, 0.4F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(64, 168).addBox(-0.8F, -2.1F, 0.4F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(169, 21).addBox(-3.8F, -2.1F, 0.4F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.829F, 0.0F, 0.0F));

		PartDefinition crank_lever = partdefinition.addOrReplaceChild("crank_lever", CubeListBuilder.create(), PartPose.offset(4.5826F, 4.3344F, -13.8459F));

		PartDefinition base_r1 = crank_lever.addOrReplaceChild("base_r1", CubeListBuilder.create().texOffs(90, 116).addBox(-0.94F, -0.24F, -1.42F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 162).addBox(-1.44F, -0.74F, -0.42F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.829F, -0.0107F, 0.0091F));

		PartDefinition bone7 = partdefinition.addOrReplaceChild("bone7", CubeListBuilder.create(), PartPose.offset(0.3826F, 4.3344F, -13.8459F));

		PartDefinition base_r2 = bone7.addOrReplaceChild("base_r2", CubeListBuilder.create().texOffs(60, 39).addBox(-1.84F, -4.54F, -0.02F, 3.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.829F, 0.0F, 0.0F));

		PartDefinition switches_r1 = bone7.addOrReplaceChild("switches_r1", CubeListBuilder.create().texOffs(159, 125).addBox(-0.5F, -3.5F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3176F, 1.6204F, 0.355F, -0.9959F, 0.4981F, -0.6353F));

		PartDefinition buttons = partdefinition.addOrReplaceChild("buttons", CubeListBuilder.create(), PartPose.offset(1.115F, 5.9571F, -17.24F));

		PartDefinition base_r3 = buttons.addOrReplaceChild("base_r3", CubeListBuilder.create().texOffs(33, 106).addBox(-11.6F, -0.96F, 0.18F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4676F, 0.3773F, 3.3941F, -0.829F, -0.0107F, 0.0091F));

		PartDefinition cube_r76 = buttons.addOrReplaceChild("cube_r76", CubeListBuilder.create().texOffs(110, 170).addBox(-5.5F, -2.925F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(105, 170).addBox(-6.8F, -2.925F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(170, 158).addBox(-5.5F, -4.225F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(128, 170).addBox(-6.8F, -4.225F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.829F, 0.0F, 0.0F));

		PartDefinition control_two = partdefinition.addOrReplaceChild("control_two", CubeListBuilder.create(), PartPose.offset(1.0F, 1.3F, -0.8F));

		PartDefinition cube_r77 = control_two.addOrReplaceChild("cube_r77", CubeListBuilder.create().texOffs(145, 108).addBox(-1.3F, -8.1567F, 7.8478F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.7418F, -1.0472F, 0.0F));

		PartDefinition control_three = partdefinition.addOrReplaceChild("control_three", CubeListBuilder.create(), PartPose.offset(1.0F, 1.3F, -0.8F));

		PartDefinition cube_r78 = control_three.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(66, 110).addBox(-3.8F, -7.6067F, 7.3478F, 10.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.7418F, -2.0944F, 0.0F));

		PartDefinition control_four = partdefinition.addOrReplaceChild("control_four", CubeListBuilder.create(), PartPose.offset(1.95F, 0.55F, -0.8F));

		PartDefinition cube_r79 = control_four.addOrReplaceChild("cube_r79", CubeListBuilder.create().texOffs(158, 18).addBox(0.75F, -8.0067F, 14.5478F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.7418F, -2.0944F, 0.0F));

		PartDefinition cube_r80 = control_four.addOrReplaceChild("cube_r80", CubeListBuilder.create().texOffs(33, 101).addBox(-4.275F, -7.6067F, 11.8478F, 7.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.95F, 2.75F, 0.0F, -0.7418F, -2.0944F, 0.0F));

		PartDefinition bone8 = partdefinition.addOrReplaceChild("bone8", CubeListBuilder.create(), PartPose.offset(12.3022F, 2.4124F, -6.1706F));

		PartDefinition cube_r81 = bone8.addOrReplaceChild("cube_r81", CubeListBuilder.create().texOffs(103, 0).addBox(6.0F, 0.8F, 1.475F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(52, 101).addBox(5.5F, 1.3F, 1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.7418F, 2.0944F, 0.0F));

		PartDefinition bone9 = partdefinition.addOrReplaceChild("bone9", CubeListBuilder.create(), PartPose.offset(12.3022F, 2.4124F, -6.1706F));

		PartDefinition cube_r82 = bone9.addOrReplaceChild("cube_r82", CubeListBuilder.create().texOffs(157, 62).addBox(-5.8F, 0.8F, 1.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 88).addBox(-6.25F, 1.3F, 1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.7418F, 2.0944F, 0.0F));

		PartDefinition bone10 = partdefinition.addOrReplaceChild("bone10", CubeListBuilder.create(), PartPose.offset(12.3022F, 2.4124F, -6.1706F));

		PartDefinition cube_r83 = bone10.addOrReplaceChild("cube_r83", CubeListBuilder.create().texOffs(41, 88).addBox(-2.5F, 1.225F, 1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(113, 0).addBox(2.75F, 0.8F, 1.475F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(120, 33).addBox(1.25F, 0.8F, 1.475F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(33, 94).addBox(-3.375F, 1.3F, -1.0F, 8.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.7418F, 2.0944F, 0.0F));

		PartDefinition useless_ass_panel = partdefinition.addOrReplaceChild("useless_ass_panel", CubeListBuilder.create(), PartPose.offset(1.0F, 3.3F, -0.8F));

		PartDefinition cube_r84 = useless_ass_panel.addOrReplaceChild("cube_r84", CubeListBuilder.create().texOffs(130, 33).addBox(-9.75F, 0.525F, 4.475F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(9, 135).addBox(1.725F, 0.525F, 4.475F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(98, 39).addBox(1.25F, 0.6F, 3.75F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(148, 125).addBox(-10.25F, 0.6F, 3.75F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.8904F, -0.7301F, 3.0544F, -0.7418F, 1.0472F, 0.0F));

		PartDefinition cube_r85 = useless_ass_panel.addOrReplaceChild("cube_r85", CubeListBuilder.create().texOffs(148, 130).addBox(-7.5F, 0.0F, -2.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(132, 148).addBox(-1.5F, 0.0F, -2.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.8904F, -0.7301F, 3.0544F, -0.3927F, 1.0472F, 0.0F));

		PartDefinition cube_r86 = useless_ass_panel.addOrReplaceChild("cube_r86", CubeListBuilder.create().texOffs(41, 84).addBox(-2.45F, -6.7567F, 4.6978F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(94, 0).addBox(-2.2F, -6.8567F, 6.6978F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(66, 116).addBox(-5.7F, -6.8567F, 9.4478F, 9.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7418F, 1.0472F, 0.0F));

		PartDefinition cube_r87 = useless_ass_panel.addOrReplaceChild("cube_r87", CubeListBuilder.create().texOffs(140, 32).addBox(1.5F, 0.3F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(43, 142).addBox(-0.5F, 0.3F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(147, 94).addBox(3.5F, 0.3F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(75, 151).addBox(5.5F, 0.3F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(152, 37).addBox(1.5F, 0.3F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(152, 49).addBox(-0.5F, 0.3F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(152, 62).addBox(3.5F, 0.3F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(153, 10).addBox(5.5F, 0.3F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(9, 155).addBox(5.5F, 0.3F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(157, 37).addBox(1.5F, 0.3F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(157, 49).addBox(-0.5F, 0.3F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.2366F, 0.9589F, 9.6052F, -0.7418F, 1.0472F, 0.0F));

		PartDefinition lamp = partdefinition.addOrReplaceChild("lamp", CubeListBuilder.create(), PartPose.offset(-8.9458F, 1.4646F, 8.9259F));

		PartDefinition cube_r88 = lamp.addOrReplaceChild("cube_r88", CubeListBuilder.create().texOffs(22, 201).addBox(-1.75F, -0.575F, -0.725F, 4.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F))
		.texOffs(21, 198).addBox(-1.75F, -0.575F, -0.725F, 4.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition cube_r89 = lamp.addOrReplaceChild("cube_r89", CubeListBuilder.create().texOffs(13, 195).addBox(-0.5F, -1.4752F, -0.498F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(1.6485F, -0.3839F, -0.692F, -1.5708F, -1.0472F, 0.0F));

		PartDefinition cube_r90 = lamp.addOrReplaceChild("cube_r90", CubeListBuilder.create().texOffs(15, 204).addBox(-0.5017F, -0.175F, -0.575F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(1.6485F, -0.3839F, -0.692F, -1.1345F, -1.0472F, 0.0F));

		PartDefinition cube_r91 = lamp.addOrReplaceChild("cube_r91", CubeListBuilder.create().texOffs(13, 195).addBox(-0.5005F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.5524F, -0.3178F, -0.0591F, 2.0071F, 1.0472F, 3.1416F));

		PartDefinition cube_r92 = lamp.addOrReplaceChild("cube_r92", CubeListBuilder.create().texOffs(8, 200).addBox(-0.525F, -1.0F, -0.8F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(1.9422F, 0.4F, -0.8327F, -0.3054F, -1.0472F, 0.0F));

		PartDefinition cube_r93 = lamp.addOrReplaceChild("cube_r93", CubeListBuilder.create().texOffs(7, 196).addBox(3.2F, -7.8567F, 6.9478F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(9.9458F, 1.8354F, -9.7259F, -0.7418F, -1.0472F, 0.0F));

		PartDefinition throttle = partdefinition.addOrReplaceChild("throttle", CubeListBuilder.create().texOffs(30, 162).addBox(-0.525F, -1.4342F, -0.3195F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offset(-4.495F, 3.6292F, 12.14F));

		PartDefinition handbrake = partdefinition.addOrReplaceChild("handbrake", CubeListBuilder.create(), PartPose.offset(4.7098F, 5.7238F, -15.4415F));

		PartDefinition lever_section_2_r1 = handbrake.addOrReplaceChild("lever_section_2_r1", CubeListBuilder.create().texOffs(138, 167).addBox(-0.5F, -1.9F, 0.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -4.0F, -0.829F, -0.0107F, 0.0091F));

		PartDefinition lever_section_1_r1 = handbrake.addOrReplaceChild("lever_section_1_r1", CubeListBuilder.create().texOffs(83, 39).addBox(-0.5F, -3.5F, 0.3F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0133F, 1.6435F, -2.453F, -0.829F, -0.0107F, 0.0091F));

		PartDefinition x = partdefinition.addOrReplaceChild("x", CubeListBuilder.create(), PartPose.offset(12.3022F, 4.4124F, -6.1706F));

		PartDefinition x_r1 = x.addOrReplaceChild("x_r1", CubeListBuilder.create().texOffs(92, 122).addBox(2.75F, 0.8F, -0.025F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7418F, 2.0944F, 0.0F));

		PartDefinition y = partdefinition.addOrReplaceChild("y", CubeListBuilder.create(), PartPose.offset(12.3022F, 4.4124F, -6.1706F));

		PartDefinition y_r1 = y.addOrReplaceChild("y_r1", CubeListBuilder.create().texOffs(9, 107).addBox(1.25F, 0.8F, -0.025F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7418F, 2.0944F, 0.0F));

		PartDefinition z = partdefinition.addOrReplaceChild("z", CubeListBuilder.create(), PartPose.offset(12.3022F, 4.4124F, -6.1706F));

		PartDefinition z_r1 = z.addOrReplaceChild("z_r1", CubeListBuilder.create().texOffs(108, 0).addBox(-0.25F, 0.8F, -0.025F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7418F, 2.0944F, 0.0F));

		PartDefinition increment = partdefinition.addOrReplaceChild("increment", CubeListBuilder.create(), PartPose.offset(12.3022F, 4.4124F, -6.1706F));

		PartDefinition increment_r1 = increment.addOrReplaceChild("increment_r1", CubeListBuilder.create().texOffs(55, 105).addBox(-2.0F, 0.8F, 1.475F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7418F, 2.0944F, 0.0F));

		PartDefinition randomiser = partdefinition.addOrReplaceChild("randomiser", CubeListBuilder.create(), PartPose.offset(1.95F, 2.55F, -0.8F));

		PartDefinition randomiser_r1 = randomiser.addOrReplaceChild("randomiser_r1", CubeListBuilder.create().texOffs(159, 133).addBox(6.25F, -8.0067F, 14.0478F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7418F, -2.0944F, 0.0F));

		PartDefinition communicator = partdefinition.addOrReplaceChild("communicator", CubeListBuilder.create(), PartPose.offset(-0.075F, 5.0F, -1.2F));

		PartDefinition communicator_r1 = communicator.addOrReplaceChild("communicator_r1", CubeListBuilder.create().texOffs(60, 54).addBox(-2.0145F, -0.59F, -1.5135F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2855F, 3.994F, 19.3645F, -0.0436F, 0.0F, 0.0F));

		PartDefinition monitor = partdefinition.addOrReplaceChild("monitor", CubeListBuilder.create(), PartPose.offset(12.3022F, 4.4124F, -6.1706F));

		PartDefinition monitor_r1 = monitor.addOrReplaceChild("monitor_r1", CubeListBuilder.create().texOffs(134, 0).addBox(-1.775F, 1.3F, -6.0F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7418F, 2.0944F, 0.0F));

		PartDefinition refuller = partdefinition.addOrReplaceChild("refuller", CubeListBuilder.create(), PartPose.offset(-12.7164F, 7.1269F, 7.3501F));

		PartDefinition refuller_r1 = refuller.addOrReplaceChild("refuller_r1", CubeListBuilder.create().texOffs(0, 11).addBox(-3.0F, -0.6F, -0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, -1.0472F, 0.0F));

		PartDefinition door_control = partdefinition.addOrReplaceChild("door_control", CubeListBuilder.create(), PartPose.offset(1.0F, 3.3F, -0.8F));

		PartDefinition door_control_r1 = door_control.addOrReplaceChild("door_control_r1", CubeListBuilder.create().texOffs(143, 167).addBox(-0.3F, -8.6567F, 8.8478F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7418F, -1.0472F, 0.0F));

		PartDefinition dimension_changer = partdefinition.addOrReplaceChild("dimension_changer", CubeListBuilder.create(), PartPose.offset(9.2366F, 4.2589F, 8.8052F));

		PartDefinition dimension_changer_r1 = dimension_changer.addOrReplaceChild("dimension_changer_r1", CubeListBuilder.create().texOffs(153, 18).addBox(3.5F, 0.3F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7418F, 1.0472F, 0.0F));

		PartDefinition exterior_facing = partdefinition.addOrReplaceChild("exterior_facing", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition exterior_facing_r1 = exterior_facing.addOrReplaceChild("exterior_facing_r1", CubeListBuilder.create().texOffs(128, 167).addBox(4.4F, -8.6067F, 9.1228F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -20.7F, -0.8F, -0.7418F, -2.0944F, 0.0F));

		PartDefinition fast_return_switch = partdefinition.addOrReplaceChild("fast_return_switch", CubeListBuilder.create(), PartPose.offset(1.95F, 2.55F, -0.8F));

		PartDefinition fast_return_switch_r1 = fast_return_switch.addOrReplaceChild("fast_return_switch_r1", CubeListBuilder.create().texOffs(79, 216).addBox(-1.7F, -7.1317F, 4.9728F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.95F, 0.75F, 0.0F, -0.7418F, 1.0472F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r94 = bb_main.addOrReplaceChild("cube_r94", CubeListBuilder.create().texOffs(75, 0).addBox(-3.35F, 1.3F, -2.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.3022F, -19.5876F, -6.1706F, -0.7418F, 2.0944F, 0.0F));

		PartDefinition cube_r95 = bb_main.addOrReplaceChild("cube_r95", CubeListBuilder.create().texOffs(0, 88).addBox(-3.3F, -8.1567F, 13.3478F, 7.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -20.7F, -0.8F, -0.7418F, -1.0472F, 0.0F));

		PartDefinition cube_r96 = bb_main.addOrReplaceChild("cube_r96", CubeListBuilder.create().texOffs(108, 157).addBox(-2.25F, -8.0067F, 14.5478F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.95F, -21.45F, -0.8F, -0.7418F, -2.0944F, 0.0F));

		PartDefinition panel_three_small_lights_r1 = bb_main.addOrReplaceChild("panel_three_small_lights_r1", CubeListBuilder.create().texOffs(148, 139).addBox(-5.625F, -7.6067F, 11.8478F, 1.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -20.7F, -0.8F, -0.7418F, -2.0944F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderWithEntity(ConsoleBlockEntity entity, PoseStack stack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		stack.pushPose();
		stack.mulPose(Vector3f.XP.rotationDegrees(180f));
		stack.translate(0.4, -1.35,0.4);
		stack.scale(0.9f, 0.9f, 0.9f);


		Direction direction = entity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);

		if (direction == Direction.NORTH) {
			stack.translate(-1,0,0.1);
		}
		else if (direction == Direction.SOUTH) {
			stack.translate(0.1,0,-1);
		}
		else if (direction == Direction.EAST) {
			stack.translate(0.1,0,0.1);
		}
		else if (direction == Direction.WEST) {
			stack.translate(-1,0,-1);
		}

		super.renderWithEntity(entity, stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		if(sharedValues.getThrottleEnabled()) {
			if (entity.rotorState == EnumRotorState.DOWN) {
				if (entity.rotorTick < 0f/*1.5f*/) {
					entity.rotorTick += 0.0015f;
				} else {
					entity.rotorTick = 0f/*1.5f*/;
					entity.rotorState = EnumRotorState.UP;
				}
			}
			if (entity.rotorState == EnumRotorState.UP) {
				if (entity.rotorTick > -0.25f) {
					entity.rotorTick -= 0.0015f;
				} else {
					entity.rotorTick = -0.25f;
					entity.rotorState = EnumRotorState.DOWN;
				}
			}
			this.top_rotor.y = this.top_rotor.y - entity.rotorTick * 10f;
			this.bottom_rotor.y = this.bottom_rotor.y + entity.rotorTick * 16f;
			//stack.translate(0, -entity.rotorTick / 1.25f, 0);
			this.throttle.xRot = (float) Math.toRadians(95);
		} else {
			this.top_rotor.y = this.top_rotor.y;
			this.bottom_rotor.y = this.bottom_rotor.y;
			this.throttle.xRot = (float) Math.toRadians(0);
		}
		if(sharedValues.getHandbrakeEnabled()) {
			this.handbrake.zRot = (float) Math.toRadians(-75);
			this.handbrake.render(stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		} else {
			this.handbrake.zRot = (float) Math.toRadians(75);
			this.handbrake.render(stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		}
		if(sharedValues.getDoorControlEnabled()) {
			this.door_control.z = this.door_control.z + 3;
			this.door_control.render(stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		} else {
			this.door_control.z = this.door_control.z;
			this.door_control.render(stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		}
		this.bottom_rotor.render(stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		this.top_rotor.render(stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		this.throttle.render(stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		stack.popPose();
	}

	@Override
	public void setupAnim(Entity p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_, float p_102623_) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		console_plinth_one.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		console_plinth_two.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		console_plinth_three.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		clawlegs.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		clawlegs2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		clawlegs3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		under_console_struts.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		console_corners.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		console_collar_one.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		console_collar_two.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		panel.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		panel2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		panel3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		panel4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		panel5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		panel6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		base.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		upper_console_one.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		upper_console_two.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		ConsoleCollarTwo3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		ConsoleCollarOne6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		panel_two_glowies.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		panel_three_lights.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		crank_lever.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		buttons.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		control_two.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		control_three.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		control_four.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone9.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone10.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		useless_ass_panel.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		lamp.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		x.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		y.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		z.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		increment.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		randomiser.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		communicator.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		monitor.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		refuller.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		dimension_changer.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		exterior_facing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		fast_return_switch.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}