package com.duzo.tardis.tardis.controls.impl.models;

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

public class CopperDematLeverModelSchema extends TARDISControlModelSchema {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(TARDISMod.MODID, "copper_demat_lever"), "main");
    private final ModelPart base;
    private final ModelPart lever;

    public CopperDematLeverModelSchema(ModelPart root) {
        this.base = root.getChild("base");
        this.lever = root.getChild("lever");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition base = partdefinition.addOrReplaceChild("base", CubeListBuilder.create().texOffs(2, 2).addBox(-5.0F, -6.728F, -19.6291F, 10.0F, 10.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(33, 4).addBox(-5.0F, -11.1593F, -14.134F, 10.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 54).addBox(2.25F, -12.6593F, -13.134F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(52, 25).addBox(-4.25F, -12.6593F, -13.134F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(44, 41).addBox(5.0F, -11.1593F, -14.134F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(8, 5).addBox(-5.0F, -11.1593F, -14.134F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 35).addBox(-6.0F, -8.728F, -14.6291F, 12.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(34, 29).addBox(-5.5F, -9.228F, -15.1291F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(34, 29).addBox(-5.5F, -10.228F, -15.1291F, 11.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(39, 34).addBox(-5.5F, -9.228F, -16.1291F, 11.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(34, 29).addBox(-5.5F, -3.228F, -15.1291F, 11.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(39, 34).addBox(-5.5F, -9.228F, -9.1291F, 11.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.728F, 11.6291F));

        PartDefinition cube_r1 = base.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(8, 45).addBox(-5.0F, -0.25F, -2.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(33, 12).addBox(-5.0F, -0.25F, -2.0F, 10.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(24, 45).addBox(5.0F, -0.25F, -2.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.9345F, -4.724F, -1.9199F, 0.0F, 0.0F));

        PartDefinition cube_r2 = base.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(8, 45).addBox(-5.0F, -1.25F, -2.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(24, 45).addBox(5.0F, -1.25F, -2.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(33, 12).addBox(-5.0F, -1.25F, -2.0F, 10.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.001F, -5.2762F, -18.6053F, 1.9199F, 0.0F, 0.0F));

        PartDefinition cube_r3 = base.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(8, 45).addBox(-5.0F, -20.0F, -8.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(24, 45).addBox(5.0F, -20.0F, -8.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(33, 12).addBox(-5.0F, -20.0F, -8.0F, 10.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.8727F, 0.0F, 0.0F));

        PartDefinition cube_r4 = base.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, 0.0F, -2.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 5).addBox(5.0F, 0.0F, -2.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(33, 0).addBox(-5.0F, 0.0F, -2.0F, 10.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.4753F, -16.0131F, 0.3491F, 0.0F, 0.0F));

        PartDefinition cube_r5 = base.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(8, 0).addBox(-5.0F, -20.0F, 4.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(36, 41).addBox(5.0F, -20.0F, 4.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(33, 8).addBox(-5.0F, -20.0F, 4.0F, 10.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -24.2681F, -0.8727F, 0.0F, 0.0F));

        PartDefinition cube_r6 = base.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 45).addBox(-5.0F, 0.0F, -2.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(16, 45).addBox(5.0F, 0.0F, -2.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(30, 41).addBox(-5.0F, 0.0F, -2.0F, 10.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.4753F, -8.255F, -0.3491F, 0.0F, 0.0F));

        PartDefinition cube_r7 = base.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(54, 20).addBox(-5.0F, -22.0F, -5.75F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(24, 54).addBox(1.5F, -22.0F, -5.75F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, 0.75F, 0.0F, 0.8727F, 0.0F, 0.0F));

        PartDefinition cube_r8 = base.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -2.0F, -0.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(8, 0).addBox(1.5F, -2.0F, -0.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, -9.9753F, -16.0131F, 0.3491F, 0.0F, 0.0F));

        PartDefinition cube_r9 = base.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(16, 54).addBox(-5.0F, -2.0F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(54, 16).addBox(1.5F, -2.0F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, -9.9753F, -8.255F, -0.3491F, 0.0F, 0.0F));

        PartDefinition cube_r10 = base.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(48, 50).addBox(-5.0F, -22.0F, 3.75F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(52, 43).addBox(1.5F, -22.0F, 3.75F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, 0.75F, -24.2681F, -0.8727F, 0.0F, 0.0F));

        PartDefinition lever = partdefinition.addOrReplaceChild("lever", CubeListBuilder.create().texOffs(0, 27).addBox(-8.0F, -2.0F, -2.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(40, 50).addBox(-8.0F, -7.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(12, 54).addBox(-7.5F, -14.0F, -0.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(32, 50).addBox(6.0F, -7.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(8, 54).addBox(6.5F, -14.0F, -0.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(18, 45).addBox(1.0F, -16.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 45).addBox(-8.0F, -16.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 14.5F, -0.5F, 0.7854F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
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

        stack.mulPose(Vector3f.YN.rotationDegrees(180.0f));

        super.renderWithEntity(entity,stack,vertexConsumer,packedLight,packedOverlay,red,green,blue,alpha);
        stack.popPose();
    }

    @Override
    public void renderToBuffer(PoseStack stack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        stack.pushPose();
        stack.mulPose(Vector3f.XN.rotationDegrees(180.0f));
        stack.translate(0,-0.6f,0);
        stack.scale(0.4f,0.4f,0.4f);

        base.render(stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        lever.render(stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        stack.popPose();
    }


    @Override
    public void setupAnim(Entity p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_, float p_102623_) {

    }
}
