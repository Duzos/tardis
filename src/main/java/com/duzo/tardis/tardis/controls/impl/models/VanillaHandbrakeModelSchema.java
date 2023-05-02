package com.duzo.tardis.tardis.controls.impl.models;// Made with Blockbench 4.7.2
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

public class VanillaHandbrakeModelSchema extends TARDISControlModelSchema {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(TARDISMod.MODID, "vanilla_handbrake"), "main");
	private final ModelPart RESETCORDSSWITCH;

	public VanillaHandbrakeModelSchema(ModelPart root) {
		this.RESETCORDSSWITCH = root.getChild("RESETCORDSSWITCH");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition RESETCORDSSWITCH = partdefinition.addOrReplaceChild("RESETCORDSSWITCH", CubeListBuilder.create().texOffs(14, 19).addBox(-2.0F, -1.0F, -3.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 23.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition bone3 = RESETCORDSSWITCH.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0019F, -0.0034F));

		PartDefinition cube_r1 = bone3.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(12, 52).mirror().addBox(-0.75F, -0.95F, -0.35F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.25F, -8.1987F, -5.0061F, -1.2217F, 0.0F, 0.0F));

		PartDefinition cube_r2 = bone3.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(6, 40).addBox(-0.75F, -0.75F, -0.5F, 1.5F, 1.5F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.8786F, -3.5185F, -0.9163F, 0.0F, 0.0F));

		PartDefinition cube_r3 = bone3.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(20, 42).addBox(-0.55F, -0.55F, -3.5F, 1.1F, 1.1F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 38).addBox(-0.75F, -0.75F, -2.5F, 1.5F, 1.5F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.4016F, -3.508F, -1.2217F, 0.0F, 0.0F));

		PartDefinition cube_r4 = bone3.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(4, 38).addBox(-0.75F, -1.75F, -4.0F, 1.5F, 1.5F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(4, 38).addBox(-0.75F, -0.75F, -4.0F, 1.5F, 1.5F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2137F, -0.212F, -0.8727F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
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

		RESETCORDSSWITCH.render(stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		stack.popPose();
	}

	@Override
	public void setupAnim(Entity p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_, float p_102623_) {

	}
}