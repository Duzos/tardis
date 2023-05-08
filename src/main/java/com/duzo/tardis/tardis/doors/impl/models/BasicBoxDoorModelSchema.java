package com.duzo.tardis.tardis.doors.impl.models;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.tardis.doors.TARDISInteriorDoorModelSchema;
import com.duzo.tardis.tardis.doors.blocks.InteriorDoorBlockEntity;
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

public class BasicBoxDoorModelSchema extends TARDISInteriorDoorModelSchema {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(TARDISMod.MODID, "basic_box_door"), "main");
    private final ModelPart box;

    public BasicBoxDoorModelSchema(ModelPart root) {
        this.box = root.getChild("box");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition box = partdefinition.addOrReplaceChild("box", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 8.0F));

        PartDefinition base = box.addOrReplaceChild("base", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -4.0F, -19.0F, 38.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Posts = base.addOrReplaceChild("Posts", CubeListBuilder.create().texOffs(0, 70).mirror().addBox(-18.0F, -62.0F, -18.0F, 4.0F, 58.0F, 4.0F, new CubeDeformation(0.001F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = Posts.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(56, 18).mirror().addBox(-18.0F, -62.0F, -18.0F, 4.0F, 58.0F, 4.0F, new CubeDeformation(0.001F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition Walls = base.addOrReplaceChild("Walls", CubeListBuilder.create().texOffs(20, 70).addBox(-14.0F, -56.0F, -16.0F, 1.0F, 52.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 70).addBox(13.0F, -56.0F, -16.0F, 1.0F, 52.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(72, 9).addBox(-13.0F, -56.0F, -16.0F, 26.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Roof = base.addOrReplaceChild("Roof", CubeListBuilder.create().texOffs(144, 26).addBox(-16.0F, -65.0F, -18.0F, 32.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(120, 78).addBox(-17.0F, -64.5F, -17.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(112, 78).addBox(16.0F, -64.5F, -17.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition PCB = base.addOrReplaceChild("PCB", CubeListBuilder.create().texOffs(0, 132).addBox(-17.0F, -61.0F, -19.0F, 34.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r2 = PCB.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(96, 78).addBox(14.0F, -61.0F, -19.0F, 3.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r3 = PCB.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(104, 78).addBox(-17.0F, -61.0F, -19.0F, 3.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition right_door = box.addOrReplaceChild("right_door", CubeListBuilder.create().texOffs(28, 18).addBox(-13.5F, -25.5F, -0.5F, 13.0F, 51.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-12.5F, -6.5F, -1.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(13.5F, -29.5F, -15.5F));

        PartDefinition left_door = box.addOrReplaceChild("left_door", CubeListBuilder.create().texOffs(0, 18).addBox(0.5F, -25.5F, -0.5F, 13.0F, 51.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 9).addBox(9.5F, -6.5F, -1.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-13.5F, -29.5F, -15.5F));

        return LayerDefinition.create(meshdefinition, 256, 256);
    }

    @Override
    public void renderWithEntity(InteriorDoorBlockEntity entity, PoseStack stack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        stack.pushPose();
        Direction direction = entity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);
        stack.mulPose(Vector3f.YP.rotationDegrees(180.0f));


        if (direction == Direction.SOUTH) {
            stack.translate(-1.15,0,-0.75);
        }
        else if (direction == Direction.NORTH) {
            stack.translate(-0.15,0,0.25);
        }
        else if (direction == Direction.EAST) {
            stack.translate(-0.15,0,-0.75);
        }
        else if (direction == Direction.WEST) {
            stack.translate(-1.15,0,0.25);
        }

        box.getChild("right_door").yRot = (float) Math.toRadians(entity.doorOpen() ? -270f : 0);
        box.getChild("left_door").yRot = - (float) Math.toRadians(entity.doorOpen() ? -270f : 0);

        super.renderWithEntity(entity,stack,vertexConsumer,packedLight,packedOverlay,red,green,blue,alpha);
        stack.popPose();
    }

    @Override
    public void renderToBuffer(PoseStack stack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        stack.pushPose();
        stack.mulPose(Vector3f.XN.rotationDegrees(180.0f));

        stack.scale(0.65f,0.65f,0.65f);
        stack.translate(1f, -1.5f, 1f);
        box.render(stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        stack.popPose();
    }

    @Override
    public void setupAnim(Entity p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_, float p_102623_) {

    }
}