package com.duzo.tardis.client.models.blockentities;// Made with Blockbench 4.7.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.client.models.GenericModel;
import com.duzo.tardis.core.init.BlockEntityInit;
import com.duzo.tardis.tardis.exteriors.blocks.entities.ExteriorBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class CoralRampModel extends GenericModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(TARDISMod.MODID, "coral_ramp"), "main");
	private final ModelPart bone;

	public CoralRampModel(ModelPart root) {
		this.bone = root.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(138, 0).addBox(-19.0F, -1.0F, -21.0F, 38.0F, 1.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 25.0F, 3.0F));

		PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(16, 9).addBox(-17.0F, 2.0F, 43.0F, 3.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(16, 0).addBox(-17.0F, 2.0F, 20.0F, 3.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(16, 18).addBox(14.0F, 2.0F, 43.0F, 3.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 27).addBox(14.0F, 2.0F, 20.0F, 3.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(4, 0).addBox(-19.0F, -27.0F, 60.0F, 1.0F, 26.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 65).addBox(-19.0F, -28.0F, 1.0F, 1.0F, 1.0F, 64.0F, new CubeDeformation(0.0F))
		.texOffs(62, 131).addBox(-19.0F, -19.0F, 3.0F, 1.0F, 1.0F, 60.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-19.0F, -27.0F, 5.0F, 1.0F, 26.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 130).addBox(-19.0F, -11.0F, 3.0F, 1.0F, 1.0F, 60.0F, new CubeDeformation(0.0F))
		.texOffs(132, 65).addBox(18.0F, -11.0F, 3.0F, 1.0F, 1.0F, 60.0F, new CubeDeformation(0.0F))
		.texOffs(124, 132).addBox(18.0F, -19.0F, 3.0F, 1.0F, 1.0F, 60.0F, new CubeDeformation(0.0F))
		.texOffs(66, 66).addBox(18.0F, -28.0F, 1.0F, 1.0F, 1.0F, 64.0F, new CubeDeformation(0.0F))
		.texOffs(8, 0).addBox(18.0F, -27.0F, 60.0F, 1.0F, 26.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(12, 0).addBox(18.0F, -27.0F, 5.0F, 1.0F, 26.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-19.0F, -1.0F, -1.0F, 38.0F, 3.0F, 62.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0364F, -1.7325F, 0.2531F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderWithEntity(BlockEntity entity, PoseStack stack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		stack.pushPose();
		Direction direction = entity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);

		if (direction == Direction.NORTH) {
			stack.translate(-0.5,0,-0.85);
		}
		else if (direction == Direction.SOUTH) {
			stack.translate(0,0,0.5);
		}
		else if (direction == Direction.WEST) {
			stack.translate(0,0,-0.5);
		}
		else if (direction == Direction.EAST) {
			stack.translate(0.5,0,-0.85);
		}

		super.renderWithEntity(entity,stack,vertexConsumer,packedLight,packedOverlay,red,green,blue,alpha);
		stack.popPose();
	}

	@Override
	public void renderToBuffer(PoseStack stack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		stack.pushPose();
		stack.mulPose(Vector3f.XN.rotationDegrees(180.0f));

		stack.translate(0,-0.8,0);
		stack.scale(0.5f,0.5f,0.5f);

		bone.render(stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		stack.popPose();
	}

	@Override
	public void setupAnim(Entity p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_, float p_102623_) {

	}

}