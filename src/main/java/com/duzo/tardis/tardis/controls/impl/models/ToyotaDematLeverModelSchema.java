package com.duzo.tardis.tardis.controls.impl.models;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.tardis.controls.TARDISControlModelSchema;
import com.duzo.tardis.tardis.controls.blocks.ControlBlockEntity;
import com.duzo.tardis.tardis.controls.blocks.basics.DematControlBlockEntity;
import com.duzo.tardis.tardis.controls.impl.ToyotaDematLeverSchema;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.minecraft.client.animation.definitions.FrogAnimation;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.jetbrains.annotations.NotNull;

public class ToyotaDematLeverModelSchema extends TARDISControlModelSchema {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(TARDISMod.MODID, "toyota_demat_lever"), "main");

    private final ModelPart base;
    private final ModelPart lever;
    private final ModelPart bb_main;
    private final ModelPart root;

    public ToyotaDematLeverModelSchema(ModelPart root) {
        this.base = root.getChild("base");
        this.lever = root.getChild("lever");
        this.bb_main = root.getChild("bb_main");
        this.root = root;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition base = partdefinition.addOrReplaceChild("base", CubeListBuilder.create().texOffs(0, 25).addBox(-1.75F, -3.1593F, -14.134F, 3.5F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(17, 25).addBox(3.0F, -3.1593F, -14.134F, 2.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-5.0F, -3.1593F, -14.134F, 2.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.728F, 11.6291F));

        PartDefinition base_r1 = base.addOrReplaceChild("base_r1", CubeListBuilder.create().texOffs(25, 48).addBox(1.75F, -1.25F, -1.5F, 1.25F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(47, 45).addBox(-3.0F, -1.25F, -1.5F, 1.25F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(23, 46).addBox(1.75F, -1.25F, -0.5F, 1.25F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(45, 43).addBox(-3.0F, -1.25F, -0.5F, 1.25F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 32).addBox(-5.0F, -1.25F, -1.5F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(30, 29).addBox(3.0F, -1.25F, -1.5F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 18).addBox(-1.75F, -1.25F, -1.5F, 3.5F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.001F, -0.2093F, -7.6478F, -1.0472F, 0.0F, 0.0F));

        PartDefinition base_r2 = base.addOrReplaceChild("base_r2", CubeListBuilder.create().texOffs(32, 46).addBox(1.75F, -1.25F, -2.5F, 1.25F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(48, 37).addBox(-3.0F, -1.25F, -2.5F, 1.25F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(17, 18).addBox(-1.75F, -1.25F, -2.5F, 3.5F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(13, 35).addBox(-5.0F, -1.25F, -2.5F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(30, 21).addBox(3.0F, -1.25F, -2.5F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2092F, -16.6206F, 1.0472F, 0.0F, 0.0F));

        PartDefinition base_r3 = base.addOrReplaceChild("base_r3", CubeListBuilder.create().texOffs(39, 18).addBox(1.25F, 0.0F, -1.0F, 3.5F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(37, 37).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(26, 37).addBox(6.0F, 0.0F, -1.0F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -2.4753F, -16.0134F, 0.3491F, 0.0F, 0.0F));

        PartDefinition base_r4 = base.addOrReplaceChild("base_r4", CubeListBuilder.create().texOffs(40, 0).addBox(-5.0F, 0.0F, -2.0F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(12, 43).addBox(3.0F, 0.0F, -2.0F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 40).addBox(-1.75F, 0.0F, -2.0F, 3.5F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.4753F, -8.255F, -0.3491F, 0.0F, 0.0F));

        PartDefinition lever = partdefinition.addOrReplaceChild("lever", CubeListBuilder.create().texOffs(0, 46).addBox(1.75F, -5.5F, -1.0F, 1.25F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(43, 24).addBox(-3.0F, -5.5F, -1.0F, 1.25F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(13, 18).addBox(-2.9F, -7.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(9, 0).addBox(1.9F, -7.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(50, 26).addBox(3.266F, -13.5981F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(7, 46).addBox(-4.266F, -13.5981F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 10).addBox(0.266F, -14.5981F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 10).mirror().addBox(-5.266F, -14.5981F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 20.5F, -0.5F, -0.9599F, 0.0F, 0.0F));

        PartDefinition lever_r1 = lever.addOrReplaceChild("lever_r1", CubeListBuilder.create().texOffs(40, 50).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.833F, -8.116F, 0.0F, 0.0F, 0.0F, -0.5236F));

        PartDefinition lever_r2 = lever.addOrReplaceChild("lever_r2", CubeListBuilder.create().texOffs(45, 50).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.833F, -8.116F, 0.0F, 0.0F, 0.0F, 0.5236F));

        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -2.0F, -8.0F, 12.0F, 2.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(16, 52).addBox(-3.0F, -4.0F, -6.0F, 6.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

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

        stack.mulPose(Vector3f.YN.rotationDegrees(180.0f));

        if (entity instanceof DematControlBlockEntity) {
//            lever.xRot = (float) Math.toRadians(((DematControlBlockEntity) entity).pulled() ? -55f : 55f);
            if (((DematControlBlockEntity) entity).pulled()) {
                this.animate(entity.getSchema().getAnimationToBeRan(entity), ToyotaDematLeverSchema.LEVER_DOWN,1f);
            }
        }

        super.renderWithEntity(entity,stack,vertexConsumer,packedLight,packedOverlay,red,green,blue,alpha);
        stack.popPose();
    }

    @Override
    public void renderToBuffer(PoseStack stack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        stack.pushPose();
        stack.mulPose(Vector3f.XN.rotationDegrees(180.0f));
        stack.translate(0,-0.6f,0);
        stack.scale(0.4f,0.4f,0.4f);

        bb_main.render(stack,vertexConsumer,packedLight,packedOverlay,red,green,blue,alpha);
        base.render(stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        lever.render(stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        stack.popPose();
    }

    @Override
    public @NotNull ModelPart root() {
        return this.root;
    }


    @Override
    public void setupAnim(Entity p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_, float p_102623_) {
    }
}
