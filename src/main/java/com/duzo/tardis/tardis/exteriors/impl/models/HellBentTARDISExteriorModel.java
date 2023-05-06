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

public class HellBentTARDISExteriorModel extends TARDISExteriorModelSchema {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(TARDISMod.MODID, "hellbent_exterior"), "main");
    private final ModelPart bone;
    private final ModelPart rightdoor;
    private final ModelPart leftdoor;

    public HellBentTARDISExteriorModel(ModelPart root) {
        this.bone = root.getChild("bone");
        this.rightdoor = root.getChild("rightdoor");
        this.leftdoor = root.getChild("leftdoor");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 35).addBox(-13.0F, -5.0F, -13.0F, 26.0F, 5.0F, 26.0F, new CubeDeformation(0.0F))
                .texOffs(0, 35).addBox(-13.0F, 0.0F, -13.0F, 26.0F, 1.0F, 26.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-13.0F, -62.0F, -13.0F, 26.0F, 9.0F, 26.0F, new CubeDeformation(0.0F))
                .texOffs(100, 66).addBox(-12.0F, -53.0F, 12.0F, 24.0F, 48.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, 0.0F));

        PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 66).addBox(-11.0F, -47.5F, -4.5F, 24.0F, 48.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 66).addBox(-11.0F, -47.5F, -3.5F, 24.0F, 48.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 66).addBox(-11.0F, -47.5F, -2.5F, 24.0F, 48.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 66).addBox(-11.0F, -47.5F, -1.5F, 24.0F, 48.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.5F, -5.5F, -1.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r2 = bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(50, 66).addBox(-13.0F, -47.5F, -4.5F, 24.0F, 48.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(50, 66).addBox(-13.0F, -47.5F, -3.5F, 24.0F, 48.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(50, 66).addBox(-13.0F, -47.5F, -2.5F, 24.0F, 48.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(50, 66).addBox(-13.0F, -47.5F, -1.5F, 24.0F, 48.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.5F, -5.5F, -1.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition right_door = partdefinition.addOrReplaceChild("right_door", CubeListBuilder.create().texOffs(0, 115).addBox(-0.5F, -48.5F, -0.5F, 9.0F, 48.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.5F, 18.5F, -8.5F));

        PartDefinition left_door = partdefinition.addOrReplaceChild("left_door", CubeListBuilder.create().texOffs(104, 0).addBox(-8.5F, -48.5F, -0.5F, 9.0F, 48.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(8.5F, 18.5F, -8.5F));

        return LayerDefinition.create(meshdefinition, 256, 256);
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
        stack.scale(0.64f,0.6f,0.64f);
        stack.translate(0, -1.45f, 0);


        bone.render(stack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        stack.scale(1f,1.1f,1f);
        leftdoor.render(stack,vertexConsumer,packedLight,packedOverlay,red,green,blue,alpha);
        rightdoor.render(stack,vertexConsumer,packedLight,packedOverlay,red,green,blue,alpha);
        stack.popPose();
    }

    @Override
    public void setupAnim(Entity p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_, float p_102623_) {

    }
}
