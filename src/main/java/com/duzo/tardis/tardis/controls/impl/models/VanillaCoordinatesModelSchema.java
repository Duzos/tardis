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

public class VanillaCoordinatesModelSchema extends TARDISControlModelSchema {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(TARDISMod.MODID, "vanilla_coordinates"), "main");
    private final ModelPart plate;
    private final ModelPart buttonx;
    private final ModelPart buttony;
    private final ModelPart buttonz;
    private final ModelPart RESETCORDSSWITCH;
    private final ModelPart SETCORDSSWITCH2;

    public VanillaCoordinatesModelSchema(ModelPart root) {
        this.plate = root.getChild("plate");
        this.buttonx = root.getChild("buttonx");
        this.buttony = root.getChild("buttony");
        this.buttonz = root.getChild("buttonz");
        this.RESETCORDSSWITCH = root.getChild("RESETCORDSSWITCH");
        this.SETCORDSSWITCH2 = root.getChild("SETCORDSSWITCH2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition plate = partdefinition.addOrReplaceChild("plate", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r1 = plate.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(3, 49).addBox(-4.0F, -1.0F, -2.75F, 8.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 2.5F, 0.1309F, 0.0F, 0.0F));

        PartDefinition buttonx = partdefinition.addOrReplaceChild("buttonx", CubeListBuilder.create().texOffs(0, 12).addBox(3.0F, -1.75F, -5.25F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.75F, 0.0F));

        PartDefinition buttony = partdefinition.addOrReplaceChild("buttony", CubeListBuilder.create().texOffs(0, 25).addBox(-1.5F, -1.75F, -6.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.75F, 2.0F));

        PartDefinition buttonz = partdefinition.addOrReplaceChild("buttonz", CubeListBuilder.create().texOffs(9, 27).addBox(-6.0F, -1.75F, -5.25F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.75F, 0.0F));

        PartDefinition RESETCORDSSWITCH = partdefinition.addOrReplaceChild("RESETCORDSSWITCH", CubeListBuilder.create().texOffs(14, 19).addBox(-4.5F, -1.75F, 2.5F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 23.75F, -3.0F));

        PartDefinition bone3 = RESETCORDSSWITCH.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offset(-2.5F, -0.7481F, 5.5034F));

        PartDefinition cube_r2 = bone3.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(12, 52).mirror().addBox(-0.5F, -0.5F, 4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(4, 38).addBox(-0.75F, -0.75F, -1.0F, 1.5F, 1.5F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2137F, 0.212F, 0.8727F, 0.0F, 0.0F));

        PartDefinition SETCORDSSWITCH2 = partdefinition.addOrReplaceChild("SETCORDSSWITCH2", CubeListBuilder.create().texOffs(0, 17).addBox(0.5F, -1.75F, 2.5F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 23.75F, -3.0F));

        PartDefinition bone2 = SETCORDSSWITCH2.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(2.5F, -0.7481F, 5.5034F));

        PartDefinition cube_r3 = bone2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(12, 52).addBox(-0.5F, -0.5F, 4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 38).mirror().addBox(-0.75F, -0.75F, -1.0F, 1.5F, 1.5F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -0.2137F, 0.212F, 0.8727F, 0.0F, 0.0F));

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

        plate.render(stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        buttonx.render(stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        buttony.render(stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        buttonz.render(stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        RESETCORDSSWITCH.render(stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        SETCORDSSWITCH2.render(stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);

        stack.popPose();
    }

    @Override
    public ModelPart root() {
        return null;
    }

    @Override
    public void setupAnim(Entity p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_, float p_102623_) {

    }
}
