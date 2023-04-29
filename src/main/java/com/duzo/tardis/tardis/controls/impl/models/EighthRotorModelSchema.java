package com.duzo.tardis.tardis.controls.impl.models;// Made with Blockbench 4.7.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.tardis.controls.TARDISControlModelSchema;
import com.duzo.tardis.tardis.controls.blocks.ControlBlockEntity;
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

public class EighthRotorModelSchema extends TARDISControlModelSchema {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(TARDISMod.MODID, "eighth_rotor"), "main");
	private final ModelPart plate;
	private final ModelPart rotorbottomstrips2;
	private final ModelPart rotortopstrips2;
	private final ModelPart plate2;
	private final ModelPart bb_main;

	public EighthRotorModelSchema(ModelPart root) {
		this.plate = root.getChild("plate");
		this.rotorbottomstrips2 = root.getChild("rotorbottomstrips2");
		this.rotortopstrips2 = root.getChild("rotortopstrips2");
		this.plate2 = root.getChild("plate2");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition plate = partdefinition.addOrReplaceChild("plate", CubeListBuilder.create().texOffs(72, 13).addBox(-9.0F, 0.0F, -9.0F, 18.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(1, 48).addBox(-8.0F, 0.0F, -8.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(18, 66).addBox(8.0F, 0.0F, -8.0F, 1.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 65).addBox(-9.0F, 0.0F, -8.0F, 1.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(74, 44).addBox(-9.0F, 0.0F, 8.0F, 18.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 0.0F));

		PartDefinition rotorbottomstrips2 = partdefinition.addOrReplaceChild("rotorbottomstrips2", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = rotorbottomstrips2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 92).addBox(-6.75F, -12.5F, -1.0F, 2.0F, 25.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(88, 85).addBox(4.75F, -12.5F, -1.0F, 2.0F, 25.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -29.5F, 0.0F, 0.0F, 0.6981F, 0.0F));

		PartDefinition cube_r2 = rotorbottomstrips2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(16, 92).addBox(-6.75F, -12.5F, -1.0F, 2.0F, 25.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(8, 92).addBox(4.75F, -12.5F, -1.0F, 2.0F, 25.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -29.5F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r3 = rotorbottomstrips2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(32, 94).addBox(-6.75F, -12.5F, -1.0F, 2.0F, 25.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(24, 94).addBox(4.75F, -12.5F, -1.0F, 2.0F, 25.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -29.5F, 0.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r4 = rotorbottomstrips2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(48, 94).addBox(-7.0F, -10.0F, -1.25F, 2.0F, 25.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, -32.0F, 0.25F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r5 = rotorbottomstrips2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(40, 94).addBox(5.0F, -10.0F, -0.75F, 2.0F, 25.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, -32.0F, -0.25F, 0.0F, -1.5708F, 0.0F));

		PartDefinition rotorringbottom5 = rotorbottomstrips2.addOrReplaceChild("rotorringbottom5", CubeListBuilder.create(), PartPose.offset(0.0F, 3.5F, 0.0F));

		PartDefinition cube_r6 = rotorringbottom5.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(44, 76).addBox(-7.75F, 14.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(76, 76).addBox(-0.25F, 14.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -44.0F, 0.0F, 0.0F, -2.618F, 0.0F));

		PartDefinition cube_r7 = rotorringbottom5.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 6).addBox(7.75F, 14.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -44.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition cube_r8 = rotorringbottom5.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(6, 0).addBox(7.75F, 14.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -44.0F, 0.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r9 = rotorringbottom5.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(6, 2).addBox(-8.75F, 14.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -44.0F, 0.0F, 3.1416F, 0.0F, -3.1416F));

		PartDefinition cube_r10 = rotorringbottom5.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(6, 4).addBox(7.75F, 14.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(6, 6).addBox(-8.75F, 14.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -44.0F, 0.0F, 0.0F, -2.0944F, 0.0F));

		PartDefinition cube_r11 = rotorringbottom5.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(3, 7).addBox(7.75F, 14.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -44.0F, 0.0F, 0.0F, 2.0944F, 0.0F));

		PartDefinition cube_r12 = rotorringbottom5.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 83).addBox(-0.25F, 14.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(84, 66).addBox(-7.75F, 14.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -44.0F, 0.0F, 0.0F, 2.618F, 0.0F));

		PartDefinition cube_r13 = rotorringbottom5.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(24, 85).addBox(-0.25F, 14.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(56, 85).addBox(-7.75F, 14.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -44.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition rotortopstrips2 = partdefinition.addOrReplaceChild("rotortopstrips2", CubeListBuilder.create(), PartPose.offset(0.0F, -8.0F, 0.0F));

		PartDefinition cube_r14 = rotortopstrips2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(56, 94).addBox(-6.75F, -11.5F, -1.0F, 2.0F, 24.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(64, 94).addBox(4.75F, -11.5F, -1.0F, 2.0F, 24.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 29.5F, 0.0F, 0.0F, 0.3054F, 0.0F));

		PartDefinition cube_r15 = rotortopstrips2.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(72, 94).addBox(-6.75F, -11.5F, -1.0F, 2.0F, 24.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(80, 94).addBox(4.75F, -11.5F, -1.0F, 2.0F, 24.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 29.5F, 0.0F, 0.0F, -1.1781F, 0.0F));

		PartDefinition cube_r16 = rotortopstrips2.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(96, 85).addBox(-6.75F, -11.5F, -1.0F, 2.0F, 24.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(104, 85).addBox(4.75F, -11.5F, -1.0F, 2.0F, 24.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 29.5F, 0.0F, 0.0F, -0.3927F, 0.0F));

		PartDefinition cube_r17 = rotortopstrips2.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(106, 15).addBox(-7.0F, -14.0F, -1.25F, 2.0F, 24.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, 32.0F, 0.25F, -3.1416F, -1.1781F, -3.1416F));

		PartDefinition cube_r18 = rotortopstrips2.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(110, 109).addBox(5.0F, -14.0F, -0.75F, 2.0F, 24.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, 32.0F, -0.25F, -3.1416F, -1.1781F, -3.1416F));

		PartDefinition rotorringtop5 = rotortopstrips2.addOrReplaceChild("rotorringtop5", CubeListBuilder.create(), PartPose.offset(0.0F, 26.0F, 0.0F));

		PartDefinition cube_r19 = rotorringtop5.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(36, 66).addBox(-7.75F, -15.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(60, 67).addBox(-0.25F, -15.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 14.5F, 0.0F, -3.1416F, -0.1309F, 3.1416F));

		PartDefinition cube_r20 = rotorringtop5.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(0, 0).addBox(7.75F, -15.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 14.5F, 0.0F, 0.0F, -1.4399F, 0.0F));

		PartDefinition cube_r21 = rotorringtop5.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(0, 2).addBox(7.75F, -15.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 14.5F, 0.0F, -3.1416F, 0.3927F, -3.1416F));

		PartDefinition cube_r22 = rotorringtop5.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(3, 1).addBox(-8.75F, -15.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 14.5F, 0.0F, -3.1416F, 0.3927F, 3.1416F));

		PartDefinition cube_r23 = rotorringtop5.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(3, 3).addBox(7.75F, -15.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 4).addBox(-8.75F, -15.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 14.5F, 0.0F, -3.1416F, -0.6545F, 3.1416F));

		PartDefinition cube_r24 = rotorringtop5.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(3, 5).addBox(7.75F, -15.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 14.5F, 0.0F, -3.1416F, 1.4399F, 3.1416F));

		PartDefinition cube_r25 = rotorringtop5.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(72, 0).addBox(-0.25F, -15.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(72, 17).addBox(-7.75F, -15.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 14.5F, 0.0F, -3.1416F, 0.9163F, 3.1416F));

		PartDefinition cube_r26 = rotorringtop5.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(74, 26).addBox(-0.25F, -15.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(74, 35).addBox(-7.75F, -15.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 14.5F, 0.0F, 0.0F, 1.1781F, 0.0F));

		PartDefinition plate2 = partdefinition.addOrReplaceChild("plate2", CubeListBuilder.create().texOffs(72, 11).addBox(-9.0F, -1.0F, -9.0F, 18.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(1, 48).addBox(-8.0F, -1.0F, -8.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(56, 32).addBox(8.0F, -1.0F, -8.0F, 1.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(54, 0).addBox(-9.0F, -1.0F, -8.0F, 1.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(72, 9).addBox(-9.0F, -1.0F, 8.0F, 18.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -31.0F, -9.0F, 18.0F, 30.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderWithEntity(ControlBlockEntity entity, PoseStack stack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		stack.pushPose();
		Direction direction = entity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);

		if (direction == Direction.NORTH) {
			stack.translate(-0.5,0,-0.5);
		}
		else if (direction == Direction.SOUTH) {
			stack.translate(0.5,0,0.5);
		}
		else if (direction == Direction.WEST) {
			stack.translate(0.5,0,-0.5);
		}
		else if (direction == Direction.EAST) {
			stack.translate(-0.5,0,0.5);
		}

		super.renderWithEntity(entity,stack,vertexConsumer,packedLight,packedOverlay,red,green,blue,alpha);
		stack.popPose();
	}

	@Override
	public void renderToBuffer(PoseStack stack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		stack.pushPose();
		stack.mulPose(Vector3f.XN.rotationDegrees(180.0f));
		stack.translate(0,-1.5f,0);
		stack.scale(0.85f,1,0.85f);


		plate.render(stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rotorbottomstrips2.render(stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rotortopstrips2.render(stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		plate2.render(stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);

		stack.popPose();
	}

	@Override
	public void setupAnim(Entity p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_, float p_102623_) {

	}
}