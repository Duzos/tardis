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

public class HartnellTARDISExteriorModel  extends TARDISExteriorModelSchema {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(TARDISMod.MODID, "hartnell_exterior"), "main");

    private final ModelPart bone;

    public HartnellTARDISExteriorModel(ModelPart root) {
        this.bone = root.getChild("bone");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-20.0F, 3.0F, -20.0F, 40.0F, 1.0F, 40.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-21.0F, 3.0F, -20.0F, 1.0F, 1.0F, 40.0F, new CubeDeformation(0.0F))
                .texOffs(39, 39).addBox(-21.0F, 3.0F, 20.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(39, 39).addBox(-21.0F, 3.0F, -21.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(39, 39).addBox(-20.0F, 3.0F, -21.0F, 40.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(39, 39).addBox(-20.0F, 3.0F, 20.0F, 40.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(20.0F, 3.0F, -20.0F, 1.0F, 1.0F, 40.0F, new CubeDeformation(0.0F))
                .texOffs(39, 39).addBox(20.0F, 3.0F, 20.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(39, 39).addBox(20.0F, 3.0F, -21.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(108, 41).addBox(-20.0F, -68.0F, -14.0F, 40.0F, 4.0F, 28.0F, new CubeDeformation(0.0F))
                .texOffs(0, 81).addBox(-17.0F, -76.0F, -17.0F, 34.0F, 4.0F, 34.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-4.0F, -79.0F, -4.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 11).addBox(-4.0F, -87.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 21).addBox(-3.0F, -88.0F, -3.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(20, 24).addBox(-2.0F, -85.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(4, 11).addBox(-3.5F, -85.0F, 2.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 11).addBox(2.5F, -85.0F, 2.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(2.5F, -85.0F, -3.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 0).addBox(-3.5F, -85.0F, -3.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(40, 192).addBox(-19.0F, -71.0F, 14.0F, 5.0F, 74.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(166, 113).addBox(-14.0F, -61.0F, 15.0F, 28.0F, 64.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 119).addBox(-14.0F, -61.0F, -16.0F, 28.0F, 64.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(68, 197).addBox(-0.5F, -61.0F, -17.0F, 1.0F, 64.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 197).addBox(-0.5F, -61.0F, 16.0F, 1.0F, 64.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(20, 184).addBox(-19.0F, -71.0F, -19.0F, 5.0F, 74.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(88, 119).addBox(14.0F, -71.0F, 14.0F, 5.0F, 74.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 184).addBox(14.0F, -71.0F, -19.0F, 5.0F, 74.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(108, 113).addBox(15.0F, -61.0F, -14.0F, 1.0F, 64.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 20.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(60, 197).addBox(-0.5F, -61.0F, 16.0F, 1.0F, 64.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(102, 81).addBox(-20.0F, -68.0F, -14.0F, 40.0F, 4.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition bone4 = bone.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(266, 37).addBox(-17.0F, -62.0F, -17.0F, 34.0F, 1.0F, 34.0F, new CubeDeformation(0.0F))
                .texOffs(320, 83).addBox(-17.5F, -63.0F, -17.5F, 35.0F, 1.0F, 35.0F, new CubeDeformation(0.0F))
                .texOffs(344, 131).addBox(-18.0F, -64.0F, -18.0F, 36.0F, 1.0F, 36.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r2 = bone4.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 41).mirror().addBox(-18.0F, -7.0F, -18.0F, 36.0F, 1.0F, 36.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 41).mirror().addBox(-18.0F, -11.0F, -18.0F, 36.0F, 4.0F, 36.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -79.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

        PartDefinition bone5 = bone.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offset(1.0F, 1.0F, 0.0F));

        PartDefinition bone2 = bone.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(58, 119).addBox(-0.5F, -30.0F, -0.5F, 1.0F, 64.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(301, 94).addBox(-0.6F, 0.0F, 14.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 95).addBox(-1.5F, -8.0F, 11.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(9, 48).addBox(-1.5F, -30.0F, 11.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-15.5F, -31.0F, -13.5F));

        PartDefinition bone3 = bone.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(166, 178).addBox(-0.5F, -30.0F, -13.5F, 1.0F, 64.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(196, 178).addBox(-1.5F, -30.0F, -14.0F, 1.0F, 64.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(9, 48).addBox(-1.5F, -30.0F, -12.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-15.5F, -31.0F, 13.5F));

        return LayerDefinition.create(meshdefinition, 512, 512);
    }


    @Override
    public void renderWithEntity(ExteriorBlockEntity entity, PoseStack stack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        stack.pushPose();
        Direction direction = entity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);

//		if (direction == Direction.SOUTH) {
//			direction = Direction.NORTH;
//		} else if (direction == Direction.NORTH) {
//			direction = Direction.SOUTH;
//		}

//		stack.mulPose(Vector3f.YP.rotationDegrees(direction.toYRot()));

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

        super.renderWithEntity(entity,stack,vertexConsumer,packedLight,packedOverlay,red,green,blue,alpha);
        stack.popPose();
    }

    @Override
    public void renderToBuffer(PoseStack stack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        bone.setPos(0,22,0);
        stack.pushPose();
        stack.mulPose(Vector3f.XN.rotationDegrees(180.0f));

//		stack.scale(0.3f,0.175f,0.3f); funny square block TARDIS
        stack.scale(0.5f,0.5f,0.5f);
        stack.translate(0, -1.6f, 0);


        bone.render(stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        stack.popPose();
    }

    @Override
    public void setupAnim(Entity p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_, float p_102623_) {

    }
}
