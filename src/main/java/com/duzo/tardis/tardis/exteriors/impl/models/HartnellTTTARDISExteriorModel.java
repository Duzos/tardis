package com.duzo.tardis.tardis.exteriors.impl.models;// Made with Blockbench 4.7.2
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

public class HartnellTTTARDISExteriorModel extends TARDISExteriorModelSchema {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(TARDISMod.MODID, "hellbent_exterior"), "main");
    private final ModelPart bone;

    public HartnellTTTARDISExteriorModel(ModelPart root) {
        this.bone = root.getChild("bone");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(6, 35).addBox(-13.0F, -5.0F, -8.0F, 26.0F, 0.0F, 21.0F, new CubeDeformation(0.0F))
                .texOffs(25, 60).addBox(-13.0F, -5.0F, -9.0F, 26.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 57).addBox(9.0F, -5.0F, -13.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(22, 57).addBox(-13.0F, -5.0F, -13.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(13.0F, -62.0F, -13.0F, 1.0F, 9.0F, 26.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-13.0F, -62.0F, -13.0F, 26.0F, 9.0F, 26.0F, new CubeDeformation(0.0F))
                .texOffs(44, 3).addBox(10.0F, -53.0F, -13.0F, 3.0F, 48.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(44, 3).mirror().addBox(-13.0F, -53.0F, -13.0F, 3.0F, 48.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 0).addBox(-14.0F, -62.0F, -13.0F, 1.0F, 9.0F, 26.0F, new CubeDeformation(0.0F))
                .texOffs(25, 25).addBox(-13.0F, -62.0F, 13.0F, 26.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(184, 74).addBox(-13.0F, -53.0F, 13.0F, 26.0F, 48.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(159, 49).addBox(13.0F, -53.0F, -13.0F, 1.0F, 48.0F, 26.0F, new CubeDeformation(0.0F))
                .texOffs(159, 49).addBox(-14.0F, -53.0F, -13.0F, 1.0F, 48.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 29.0F, 0.0F));

        PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(44, 3).addBox(-2.0F, -24.0F, -2.0F, 4.0F, 48.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.1953F, -29.0F, -10.4366F, 0.0F, -0.3491F, 0.0F));

        PartDefinition cube_r2 = bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(44, 3).mirror().addBox(-2.0F, -24.0F, -2.0F, 4.0F, 48.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.1953F, -29.0F, -10.4366F, 0.0F, 0.3491F, 0.0F));

        PartDefinition door = bone.addOrReplaceChild("door", CubeListBuilder.create().texOffs(0, 115).addBox(-9.0F, -24.0F, -9.0F, 9.0F, 48.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -29.0F, 0.0F));

        PartDefinition doorpart2 = door.addOrReplaceChild("doorpart2", CubeListBuilder.create().texOffs(0, 115).addBox(0.0F, -24.0F, -9.0F, 9.0F, 48.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 256, 256);
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
            stack.translate(-0.5,0,0.5);
            stack.mulPose(Vector3f.YP.rotationDegrees(180f));
        }
        else if (direction == Direction.EAST) {
            stack.translate(0.5,0,-0.5);
            stack.mulPose(Vector3f.YP.rotationDegrees(180f));
        }

        bone.getChild("door").visible = !entity.doorOpen();

        super.renderWithEntity(entity, stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        stack.popPose();
    }

    @Override
    public void renderToBuffer(PoseStack stack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        stack.pushPose();
        stack.mulPose(Vector3f.XN.rotationDegrees(180.0f));

        stack.scale(0.65f,0.65f,0.65f);
        stack.translate(0, -1.5f, 0);

        bone.render(stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        stack.popPose();
    }

    @Override
    public void setupAnim(Entity p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_, float p_102623_) {

    }
}