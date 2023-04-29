package com.duzo.tardis.tardis.exteriors.impl.models;// Made with Blockbench 4.7.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.tardis.exteriors.TARDISExteriorModelSchema;
import com.duzo.tardis.tardis.exteriors.blocks.entities.ExteriorBlockEntity;
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

public class BakerTARDISExteriorModel extends TARDISExteriorModelSchema {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(TARDISMod.MODID, "baker_exterior"), "main");
	private final ModelPart bone;

	public BakerTARDISExteriorModel(ModelPart root) {
		this.bone = root.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(129, 49).addBox(-24.0F, -72.0F, -18.0F, 48.0F, 5.0F, 36.0F, new CubeDeformation(0.0F))
		.texOffs(106, 138).addBox(-16.0F, -76.0F, -21.0F, 32.0F, 4.0F, 42.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-24.0F, -2.0F, -24.0F, 48.0F, 1.0F, 48.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-24.0F, -1.0F, -24.0F, 48.0F, 1.0F, 48.0F, new CubeDeformation(0.0F))
		.texOffs(0, 49).addBox(-21.5F, -3.0F, -21.5F, 43.0F, 1.0F, 43.0F, new CubeDeformation(0.0F))
		.texOffs(129, 95).addBox(-19.5F, -78.0F, -19.5F, 39.0F, 2.0F, 39.0F, new CubeDeformation(0.0F))
		.texOffs(0, 13).addBox(-2.5F, -83.0F, -2.5F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(16, 15).addBox(-2.0F, -88.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 19).addBox(-1.5F, -89.0F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-4.5F, -82.0F, -4.5F, 9.0F, 4.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(222, 264).addBox(-22.0F, -76.0F, -22.0F, 6.0F, 74.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(198, 264).addBox(-22.0F, -76.0F, 16.0F, 6.0F, 74.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(261, 0).addBox(16.0F, -76.0F, -22.0F, 6.0F, 74.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(260, 258).addBox(16.0F, -76.0F, 16.0F, 6.0F, 74.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(132, 184).addBox(-20.0F, -67.0F, -16.0F, 1.0F, 64.0F, 32.0F, new CubeDeformation(0.0F))
		.texOffs(254, 264).addBox(-21.0F, -67.0F, -0.5F, 1.0F, 64.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(246, 264).addBox(-21.0F, -66.0F, -0.5F, 1.0F, 64.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 180).addBox(-20.0F, -66.0F, -16.0F, 1.0F, 64.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r2 = bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(250, 264).addBox(-21.0F, -66.0F, -0.5F, 1.0F, 64.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(66, 180).addBox(-20.0F, -66.0F, -16.0F, 1.0F, 64.0F, 32.0F, new CubeDeformation(0.0F))
		.texOffs(0, 134).addBox(-16.0F, -75.0F, -21.0F, 32.0F, 4.0F, 42.0F, new CubeDeformation(0.0F))
		.texOffs(0, 285).mirror().addBox(-24.0F, -71.0F, 18.0F, 48.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r3 = bone.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 93).addBox(-24.0F, -71.0F, -18.0F, 48.0F, 5.0F, 36.0F, new CubeDeformation(0.0F))
		.texOffs(0, 285).addBox(-24.0F, -71.0F, 18.0F, 48.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r4 = bone.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 285).addBox(-24.0F, -71.0F, 18.0F, 48.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r5 = bone.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 285).mirror().addBox(-24.0F, -71.0F, 18.0F, 48.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition bone2 = bone.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r6 = bone2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(266, 136).addBox(20.0F, -66.0F, -0.5F, 1.0F, 64.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(232, 184).addBox(19.0F, -66.0F, -16.0F, 1.0F, 64.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition bone3 = bone.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r7 = bone3.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(13, 313).addBox(-20.05F, -45.0F, -2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(198, 184).addBox(-20.0F, -66.0F, -16.0F, 1.0F, 64.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

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
		else if (direction == Direction.EAST) {
			stack.mulPose(Vector3f.YP.rotationDegrees(180f));
			stack.translate(-0.5,0,0.5);
		}
		else if (direction == Direction.WEST) {
			stack.mulPose(Vector3f.YP.rotationDegrees(180f));
			stack.translate(0.5,0,-0.5);
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