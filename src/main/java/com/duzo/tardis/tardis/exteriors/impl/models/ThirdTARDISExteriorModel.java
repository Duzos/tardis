package com.duzo.tardis.tardis.exteriors.impl.models;// Made with Blockbench 4.7.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.tardis.TARDIS;
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

public class ThirdTARDISExteriorModel extends TARDISExteriorModelSchema {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(TARDISMod.MODID, "third_exterior"), "main");
	private final ModelPart bone;
	private final ModelPart bone3;

	public ThirdTARDISExteriorModel(ModelPart root) {
		this.bone = root.getChild("bone");
		this.bone3 = root.getChild("bone3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(108, 113).addBox(15.0F, -61.0F, -14.0F, 1.0F, 64.0F, 28.0F, new CubeDeformation(0.0F))
		.texOffs(0, 184).addBox(14.0F, -71.0F, -19.0F, 5.0F, 74.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(88, 119).addBox(14.0F, -71.0F, 14.0F, 5.0F, 74.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(20, 184).addBox(-19.0F, -71.0F, -19.0F, 5.0F, 74.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(64, 197).addBox(-0.5F, -61.0F, 16.0F, 1.0F, 64.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(68, 197).addBox(-0.5F, -61.0F, -17.0F, 1.0F, 64.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 119).addBox(-14.0F, -61.0F, -16.0F, 28.0F, 64.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(166, 113).addBox(-14.0F, -61.0F, 15.0F, 28.0F, 64.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 192).addBox(-19.0F, -71.0F, 14.0F, 5.0F, 74.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(4, 0).addBox(-3.5F, -82.0F, -3.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(2.5F, -82.0F, -3.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 11).addBox(2.5F, -82.0F, 2.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 11).addBox(-3.5F, -82.0F, 2.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 24).addBox(-2.0F, -82.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 21).addBox(-3.0F, -85.0F, -3.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 11).addBox(-4.0F, -84.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-4.0F, -76.0F, -4.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 81).addBox(-17.0F, -73.0F, -17.0F, 34.0F, 4.0F, 34.0F, new CubeDeformation(0.0F))
		.texOffs(108, 41).addBox(-20.0F, -69.0F, -14.0F, 40.0F, 4.0F, 28.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-20.0F, 3.0F, -20.0F, 40.0F, 1.0F, 40.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r2 = bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(60, 197).addBox(-0.5F, -61.0F, 16.0F, 1.0F, 64.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(102, 81).addBox(-20.0F, -69.0F, -14.0F, 40.0F, 4.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition bone4 = bone.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r3 = bone4.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 41).addBox(-18.0F, -65.0F, -18.0F, 36.0F, 4.0F, 36.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition bone5 = bone.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offset(1.0F, 1.0F, 0.0F));

		PartDefinition bone2 = bone.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(-15.5F, -31.0F, -13.5F));

		PartDefinition cube_r4 = bone2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(9, 48).addBox(-18.0F, -62.0F, -2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.5F, 28.0F, 13.5F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r5 = bone2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(8, 95).addBox(-17.0F, -39.0F, -2.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(58, 119).addBox(-16.0F, -61.0F, -14.0F, 1.0F, 64.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.5F, 27.0F, 13.5F, 0.0F, -1.5708F, 0.0F));

		PartDefinition bone3 = partdefinition.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offset(-15.5F, -7.0F, 13.5F));

		PartDefinition cube_r6 = bone3.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(9, 48).addBox(-18.0F, -62.0F, 1.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.5F, 28.0F, -13.5F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r7 = bone3.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(196, 178).addBox(-17.0F, -61.0F, -0.5F, 1.0F, 64.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(166, 178).addBox(-16.0F, -61.0F, 0.0F, 1.0F, 64.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.5F, 27.0F, -13.5F, 0.0F, -1.5708F, 0.0F));

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

		stack.translate(0,0.5,0);

		super.renderWithEntity(entity, stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		stack.popPose();
	}

	@Override
	public void renderToBuffer(PoseStack stack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		stack.pushPose();
		stack.mulPose(Vector3f.XN.rotationDegrees(180.0f));

		stack.scale(0.5f,0.5f,0.5f);
		stack.translate(0, -0.5f, 0);

		bone.render(stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone3.render(stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		stack.popPose();
	}

	@Override
	public void setupAnim(Entity p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_, float p_102623_) {

	}
}