package com.duzo.tardis.tardis.exteriors.impl.models;// Made with Blockbench 4.7.0
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.tardis.blocks.entities.ExteriorBlockEntity;
import com.duzo.tardis.tardis.exteriors.TARDISExteriorModelSchema;
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

public class ClassicTARDISExteriorModel extends TARDISExteriorModelSchema {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(TARDISMod.MODID, "classic_exterior"), "main");
	private final ModelPart bone;

	public ClassicTARDISExteriorModel(ModelPart root) {
		this.bone = root.getChild("bone");
	}


	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-26.5F, -1.0F, -26.5F, 53.0F, 3.0F, 53.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(129, 57).addBox(-22.5F, -88.0F, -22.5F, 45.0F, 4.0F, 45.0F, new CubeDeformation(0.0F))
				.texOffs(129, 57).addBox(-22.5F, -84.0F, -22.5F, 45.0F, 1.0F, 45.0F, new CubeDeformation(0.0F))
				.texOffs(160, 0).addBox(-20.5F, -90.75F, -20.5F, 41.0F, 3.0F, 41.0F, new CubeDeformation(0.0F))
				.texOffs(364, 15).addBox(-16.5F, -91.75F, -16.5F, 33.0F, 1.0F, 33.0F, new CubeDeformation(0.0F))
				.texOffs(12, 26).addBox(-3.5F, -94.5F, -3.5F, 7.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 37).addBox(-3.0F, -101.875F, -3.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(30, 63).addBox(-2.0F, -102.875F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(34, 57).addBox(-2.0F, -95.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(34, 22).addBox(-2.0F, -101.375F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(16, 0).addBox(-0.5F, -103.375F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 65).addBox(-1.5F, -99.5F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(20, 79).addBox(-1.5F, -100.5F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(296, 298).addBox(-24.0F, -77.0F, -23.0F, 47.0F, 1.0F, 47.0F, new CubeDeformation(0.0F))
				.texOffs(279, 427).addBox(-21.0F, -83.0F, -26.0F, 42.0F, 6.0F, 52.0F, new CubeDeformation(0.0F))
				.texOffs(142, 387).addBox(-25.0F, -84.0F, -25.0F, 6.0F, 83.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(217, 387).addBox(19.0F, -84.0F, -25.0F, 6.0F, 83.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(192, 387).addBox(19.0F, -84.0F, 19.0F, 6.0F, 83.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(167, 387).addBox(-25.0F, -84.0F, 19.0F, 6.0F, 83.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(34, 44).addBox(-23.5F, -86.0F, -23.5F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 45).addBox(19.5F, -86.0F, -23.5F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 57).addBox(19.5F, -86.0F, 19.5F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(17, 57).addBox(-23.5F, -86.0F, 19.5F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(133, 175).addBox(-24.0F, -76.0F, -0.5F, 1.0F, 75.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(222, 163).addBox(-23.0F, -76.0F, -19.0F, 1.0F, 75.0F, 38.0F, new CubeDeformation(0.0F))
				.texOffs(123, 175).addBox(22.0F, -76.0F, -0.5F, 1.0F, 75.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(143, 163).addBox(21.0F, -76.0F, -19.0F, 1.0F, 75.0F, 38.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, 0.0F));

		PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 175).addBox(-23.0F, -66.0F, -19.0F, 1.0F, 75.0F, 38.0F, new CubeDeformation(0.0F))
				.texOffs(128, 175).addBox(-24.0F, -66.0F, -0.5F, 1.0F, 75.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r2 = bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(279, 368).addBox(-21.0F, -69.0F, -26.0F, 42.0F, 6.0F, 52.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r3 = bone.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(33, 29).addBox(0.0F, -83.0F, -4.0F, 0.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -17.75F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r4 = bone.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(17, 37).addBox(0.0F, -83.0F, -4.0F, 0.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -17.75F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition bone3 = bone.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offset(-18.5F, -48.0F, -21.5F));

		PartDefinition cube_r5 = bone3.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(11, 0).addBox(16.5F, -39.5F, -18.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(32.5F, 38.5F, 16.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r6 = bone3.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(138, 175).addBox(15.5F, -66.0F, -0.5F, 1.0F, 75.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(18.5F, 38.0F, 15.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r7 = bone3.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(101, 251).addBox(15.5F, -66.0F, -19.0F, 1.0F, 75.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(18.5F, 38.0F, 16.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition bone4 = bone.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offset(18.5F, -48.0F, -21.45F));

		PartDefinition cube_r8 = bone4.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(23, 133).addBox(15.65F, -29.5F, -12.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(16.5F, -39.5F, -12.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 175).addBox(15.5F, -66.0F, -14.0F, 1.0F, 75.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 38.0F, 15.95F, 0.0F, 1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void renderWithEntity(ExteriorBlockEntity entity, PoseStack stack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
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
		bone.setPos(0,22,0);
		stack.pushPose();
		stack.mulPose(Vector3f.XN.rotationDegrees(180.0f));

		stack.scale(0.5f,0.5f,0.5f);
		stack.translate(0, -1.5f, 0);

		bone.render(stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		stack.popPose();
	}

	@Override
	public void setupAnim(Entity p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_, float p_102623_) {

	}
}