package com.duzo.tardis.tardis.exteriors.impl.models;

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

public class BasicBoxExteriorModel extends TARDISExteriorModelSchema {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(TARDISMod.MODID, "basic_box_exterior"), "main");


    private final ModelPart box;
    private final ModelPart christmas_stuff;

    public BasicBoxExteriorModel(ModelPart root) {
        this.box = root.getChild("box");
        this.christmas_stuff = root.getChild("christmas_stuff");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition box = partdefinition.addOrReplaceChild("box", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition base = box.addOrReplaceChild("base", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -4.0F, -19.0F, 38.0F, 4.0F, 38.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Posts = base.addOrReplaceChild("Posts", CubeListBuilder.create().texOffs(166, 169).addBox(-18.0F, -62.0F, -18.0F, 4.0F, 58.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = Posts.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(86, 161).addBox(-18.0F, -62.0F, -18.0F, 4.0F, 58.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r2 = Posts.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(102, 161).addBox(-18.0F, -62.0F, -18.0F, 4.0F, 58.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r3 = Posts.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(118, 161).addBox(-18.0F, -62.0F, -18.0F, 4.0F, 58.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition Walls = base.addOrReplaceChild("Walls", CubeListBuilder.create().texOffs(128, 14).addBox(-16.0F, -56.0F, -14.0F, 1.0F, 52.0F, 28.0F, new CubeDeformation(0.0F))
                .texOffs(138, 161).addBox(-14.0F, -56.0F, -16.0F, 1.0F, 52.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(134, 161).addBox(13.0F, -56.0F, -16.0F, 1.0F, 52.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(30, 109).addBox(-13.0F, -56.0F, -16.0F, 26.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Wall_r1 = Walls.addOrReplaceChild("Wall_r1", CubeListBuilder.create().texOffs(84, 81).addBox(-16.0F, -56.0F, -14.0F, 1.0F, 52.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition Wall_r2 = Walls.addOrReplaceChild("Wall_r2", CubeListBuilder.create().texOffs(0, 109).addBox(-16.0F, -56.0F, -14.0F, 1.0F, 52.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition Roof = base.addOrReplaceChild("Roof", CubeListBuilder.create().texOffs(0, 42).addBox(-16.0F, -65.0F, -16.0F, 32.0F, 4.0F, 32.0F, new CubeDeformation(0.0F))
                .texOffs(0, 23).addBox(-17.0F, -64.5F, -17.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 15).addBox(-17.0F, -64.5F, 13.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(20, 4).addBox(13.0F, -64.5F, -17.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(16, 15).addBox(13.0F, -64.5F, 13.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 78).addBox(-14.0F, -68.0F, -14.0F, 28.0F, 3.0F, 28.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-3.0F, -70.0F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 42).addBox(-2.0F, -75.25F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 8).addBox(-3.0F, -75.5F, -3.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(16, 23).addBox(-2.0F, -76.5F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r4 = Roof.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 53).addBox(-4.5F, -70.75F, 0.0F, 9.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 53).addBox(0.0F, -70.75F, -4.5F, 0.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition PCB = base.addOrReplaceChild("PCB", CubeListBuilder.create().texOffs(142, 112).addBox(-17.0F, -61.0F, -19.0F, 34.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r5 = PCB.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(114, 0).addBox(-17.0F, -61.0F, -19.0F, 34.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r6 = PCB.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(114, 94).addBox(-17.0F, -61.0F, -19.0F, 34.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r7 = PCB.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(142, 103).addBox(-17.0F, -61.0F, -19.0F, 34.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition right_door = box.addOrReplaceChild("right_door", CubeListBuilder.create().texOffs(58, 161).addBox(-13.5F, -25.5F, -0.5F, 13.0F, 51.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-12.5F, -6.5F, -1.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(13.5F, -29.5F, -15.5F));

        PartDefinition left_door = box.addOrReplaceChild("left_door", CubeListBuilder.create().texOffs(142, 121).addBox(0.5F, -25.5F, -0.5F, 13.0F, 51.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 8).addBox(9.5F, -6.5F, -1.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-13.5F, -29.5F, -15.5F));

        PartDefinition christmas_stuff = partdefinition.addOrReplaceChild("christmas_stuff", CubeListBuilder.create().texOffs(252, 195).addBox(-1.0F, -61.0F, -19.0F, 2.0F, 61.0F, 0.0F, new CubeDeformation(0.001F))
                .texOffs(252, 193).addBox(19.0F, -61.0F, -1.0F, 0.0F, 61.0F, 2.0F, new CubeDeformation(0.001F))
                .texOffs(252, 193).addBox(-1.0F, -61.0F, 19.0F, 2.0F, 61.0F, 0.0F, new CubeDeformation(0.001F))
                .texOffs(252, 193).addBox(-19.0F, -61.0F, -1.0F, 0.0F, 61.0F, 2.0F, new CubeDeformation(0.001F))
                .texOffs(204, 239).addBox(-12.0F, -38.5F, -19.25F, 24.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(180, 144).addBox(-19.0F, -32.0F, -19.0F, 38.0F, 2.0F, 0.0F, new CubeDeformation(0.001F))
                .texOffs(180, 106).addBox(19.0F, -32.0F, -19.0F, 0.0F, 2.0F, 38.0F, new CubeDeformation(0.001F))
                .texOffs(180, 144).addBox(-19.0F, -32.0F, 19.0F, 38.0F, 2.0F, 0.0F, new CubeDeformation(0.001F))
                .texOffs(180, 106).addBox(-19.0F, -32.0F, -19.0F, 0.0F, 2.0F, 38.0F, new CubeDeformation(0.001F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r8 = christmas_stuff.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(248, 194).addBox(-1.0F, -9.0F, 66.0F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(0.0F, -23.144F, -35.064F, 0.6109F, 0.0F, 0.0F));

        PartDefinition cube_r9 = christmas_stuff.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(248, 203).addBox(-1.0F, -13.0F, 66.0F, 2.0F, 13.0F, 0.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(0.0F, -11.2147F, -19.1622F, 1.0472F, 0.0F, 0.0F));

        PartDefinition cube_r10 = christmas_stuff.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(248, 201).addBox(-66.0F, -13.0F, -1.0F, 0.0F, 13.0F, 2.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(19.1622F, -11.2147F, 0.0F, 0.0F, 0.0F, 1.0472F));

        PartDefinition cube_r11 = christmas_stuff.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(248, 192).addBox(-66.0F, -9.0F, -1.0F, 0.0F, 9.0F, 2.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(35.064F, -23.144F, 0.0F, 0.0F, 0.0F, 0.6109F));

        PartDefinition cube_r12 = christmas_stuff.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(248, 192).addBox(66.0F, -9.0F, -1.0F, 0.0F, 9.0F, 2.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(-35.064F, -23.144F, 0.0F, 0.0F, 0.0F, -0.6109F));

        PartDefinition cube_r13 = christmas_stuff.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(248, 201).addBox(66.0F, -13.0F, -1.0F, 0.0F, 13.0F, 2.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(-19.1622F, -11.2147F, 0.0F, 0.0F, 0.0F, -1.0472F));

        PartDefinition cube_r14 = christmas_stuff.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(248, 203).addBox(-1.0F, -13.0F, -66.0F, 2.0F, 13.0F, 0.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(0.0F, -11.2147F, 19.1622F, -1.0472F, 0.0F, 0.0F));

        PartDefinition cube_r15 = christmas_stuff.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(248, 194).addBox(-1.0F, -9.0F, -66.0F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(0.0F, -23.144F, 35.064F, -0.6109F, 0.0F, 0.0F));

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
        else if (direction == Direction.EAST) {
            stack.mulPose(Vector3f.YP.rotationDegrees(180f));
            stack.translate(-0.5,0,0.5);
        }
        else if (direction == Direction.WEST) {
            stack.mulPose(Vector3f.YP.rotationDegrees(180f));
            stack.translate(0.5,0,-0.5);
        }

        box.getChild("right_door").yRot = (float) Math.toRadians(entity.doorOpen() ? 87.5f : 0);
        box.getChild("left_door").yRot = - (float) Math.toRadians(entity.doorOpen() ? 87.5f : 0);

        super.renderWithEntity(entity,stack,vertexConsumer,packedLight,packedOverlay,red,green,blue,alpha);
        stack.popPose();
    }

    @Override
    public void renderToBuffer(PoseStack stack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        box.setPos(0,22,0);
        stack.pushPose();
        stack.mulPose(Vector3f.XN.rotationDegrees(180.0f));

//		stack.scale(0.3f,0.175f,0.3f); funny square block TARDIS
        stack.scale(0.5f,0.5f,0.5f);
        stack.translate(0, -1.5f, 0);


        box.render(stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        stack.popPose();
    }

    @Override
    public void setupAnim(Entity p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_, float p_102623_) {

    }
}
