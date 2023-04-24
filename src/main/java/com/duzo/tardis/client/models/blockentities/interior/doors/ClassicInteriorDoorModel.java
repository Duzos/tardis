package com.duzo.tardis.client.models.blockentities.interior.doors;// Made with Blockbench 4.7.0
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.tardis.blocks.doors.entities.InteriorDoorBlockEntity;
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

public class ClassicInteriorDoorModel extends InteriorDoorModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(TARDISMod.MODID, "classic_interior_doors"), "main");
	private final ModelPart bone;

	public ClassicInteriorDoorModel(ModelPart root) {
		this.bone = root.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(86, 86).addBox(-24.5F, -1.0F, -14.5F, 49.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(102, 0).addBox(-24.0F, -77.0F, -11.0F, 47.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(152, 116).addBox(19.0F, -83.0F, -14.0F, 6.0F, 6.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(102, 104).addBox(-19.0F, -78.0F, -14.0F, 38.0F, 1.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(112, 3).addBox(-19.0F, -82.0F, -14.0F, 38.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(102, 92).addBox(-19.0F, -83.0F, -14.0F, 38.0F, 1.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(8, 6).addBox(14.0F, -82.0F, -5.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(7, 4).addBox(5.0F, -82.0F, -5.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(6, 0).addBox(-14.0F, -82.0F, -5.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(6, 2).addBox(-7.0F, -82.0F, -5.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-1.0F, -82.0F, -4.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(21, 0).addBox(-25.0F, -83.0F, -14.0F, 6.0F, 6.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(31, 10).addBox(-25.0F, -83.0F, -15.0F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(162, 126).addBox(19.0F, -83.0F, -15.0F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, 102).addBox(-19.0F, -83.0F, -15.0F, 38.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(80, 0).addBox(-25.0F, -77.0F, -13.0F, 6.0F, 76.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(70, 86).addBox(19.0F, -77.0F, -13.0F, 6.0F, 76.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(4, 94).addBox(25.0F, -31.0F, -18.0F, 8.0F, 30.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(134, 116).addBox(33.0F, -31.0F, -18.0F, 1.0F, 30.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(36, 94).addBox(-33.0F, -31.0F, -18.0F, 8.0F, 30.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(36, 132).addBox(-34.0F, -31.0F, -18.0F, 1.0F, 30.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 25.0F, -16.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(144, 12).addBox(-5.0F, -26.0F, -8.0F, 1.0F, 28.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(112, 47).addBox(-4.0F, -26.0F, -8.0F, 8.0F, 27.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(144, 48).addBox(62.0F, -26.0F, -8.0F, 1.0F, 28.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(112, 12).addBox(54.0F, -26.0F, -8.0F, 8.0F, 27.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-29.0F, -31.999F, -9.9564F, -0.0436F, 0.0F, 0.0F));

		PartDefinition cube_r2 = bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(144, 146).addBox(-5.0F, -49.0F, -8.0F, 1.0F, 26.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(102, 116).addBox(-4.0F, -49.0F, -8.0F, 8.0F, 25.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(102, 149).addBox(62.0F, -49.0F, -8.0F, 1.0F, 26.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(4, 132).addBox(54.0F, -49.0F, -8.0F, 8.0F, 25.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-29.0F, -34.0656F, -10.914F, -0.0873F, 0.0F, 0.0F));

		PartDefinition bone3 = bone.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offset(-18.5F, -48.0F, -9.5F));

		PartDefinition cube_r3 = bone3.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(4, 5).addBox(16.5F, -39.5F, -18.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(32.5F, 38.5F, 16.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r4 = bone3.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 94).addBox(15.5F, -66.0F, -0.5F, 1.0F, 75.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(18.5F, 38.0F, 15.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r5 = bone3.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(216, 138).addBox(15.25F, 5.5F, -2.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(201, 138).addBox(15.0F, 5.0F, -3.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(40, 0).addBox(15.5F, -66.0F, -19.0F, 1.0F, 75.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(18.5F, 38.0F, 16.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r6 = bone3.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(197, 166).addBox(15.25F, -29.5F, -1.25F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(18.5F, 38.0F, 16.1F, 0.0F, 1.5708F, 0.0F));

		PartDefinition bone2 = bone3.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(-2.5F, -6.0F, -3.8F));

		PartDefinition cube_r7 = bone2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(37, 209).addBox(13.5F, -45.5F, -9.5F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(37, 209).addBox(13.5F, -45.5F, -6.5F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(37, 178).addBox(14.5F, -47.0F, -11.0F, 1.0F, 11.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(18.5F, 48.0F, 19.5F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r8 = bone2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(12, 228).addBox(13.0F, -42.5F, -2.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(12, 228).addBox(12.5F, -39.5F, -3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(96, 225).addBox(13.0F, -41.5F, -3.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(75, 193).addBox(12.5F, -44.5F, -10.5F, 2.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(18.5F, 48.0F, 18.75F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r9 = bone2.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(45, 239).addBox(0.0F, -1.5F, -1.25F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.5F, 6.5F, 5.8F, 0.0F, 1.5708F, 0.0F));

		PartDefinition bone4 = bone.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offset(18.5F, -48.0F, -9.45F));

		PartDefinition cube_r10 = bone4.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(130, 220).addBox(15.65F, -29.5F, -12.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 5).addBox(16.5F, -39.5F, -12.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(15.5F, -66.0F, -14.0F, 1.0F, 75.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 38.0F, 15.95F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r11 = bone4.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(223, 191).addBox(15.4F, -29.0F, 0.25F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(221, 170).addBox(15.25F, -29.5F, 0.75F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.5F, 38.0F, 16.05F, 0.0F, 1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderWithEntity(InteriorDoorBlockEntity entity, PoseStack stack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		stack.pushPose();
		Direction direction = entity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);

		if (direction == Direction.NORTH) {
			stack.translate(-1,0,-0.5);
		}
		else if (direction == Direction.SOUTH) {
			stack.translate(0,0,0.5);
		}
		else if (direction == Direction.WEST) {
			stack.translate(0,0,-0.5);
		}
		else if (direction == Direction.EAST) {
			stack.translate(-1,0,0.5);
		}

		super.renderWithEntity(entity,stack,vertexConsumer,packedLight,packedOverlay,red,green,blue,alpha);
		stack.popPose();
	}

	@Override
	public void renderToBuffer(PoseStack stack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		stack.pushPose();
		stack.mulPose(Vector3f.XN.rotationDegrees(180.0f));
//
		stack.scale(0.5f,0.5f,0.5f);
		stack.translate(1f, -1.5f, -1f);
		bone.render(stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		stack.popPose();
	}

	@Override
	public void setupAnim(Entity p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_, float p_102623_) {

	}
}