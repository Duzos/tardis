package com.duzo.tardis.tardis.controls.impl;

import com.duzo.tardis.tardis.controls.TARDISControlSchema;
import com.duzo.tardis.tardis.controls.blocks.ControlBlockEntity;
import com.duzo.tardis.tardis.controls.blocks.basics.DematControlBlock;
import com.duzo.tardis.tardis.controls.blocks.basics.DematControlBlockEntity;
import com.duzo.tardis.tardis.controls.blocks.impl.entities.ToyotaDematLeverBlockEntity;
import com.duzo.tardis.tardis.controls.impl.models.CopperDematLeverModelSchema;
import com.duzo.tardis.tardis.controls.impl.models.ToyotaDematLeverModelSchema;
import net.minecraft.client.Minecraft;
import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.world.entity.AnimationState;

public class ToyotaDematLeverSchema extends TARDISControlSchema<ToyotaDematLeverModelSchema> {
    public static final AnimationDefinition LEVER_DOWN = AnimationDefinition.Builder.withLength(0.5f)
            .addAnimation("lever",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5f, KeyframeAnimations.degreeVec(122.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .build();
    public static final AnimationDefinition LEVER_UP = AnimationDefinition.Builder.withLength(0.5f)
            .addAnimation("lever",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(122.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .build();

    public final AnimationState leverUpAnimationState = new AnimationState();
    public final AnimationState leverDownAnimationState = new AnimationState();
    public ToyotaDematLeverSchema() {
        super("toyota_demat", "controls.tardis.toyota_demat");
    }

    @Override
    protected ToyotaDematLeverModelSchema model() {
        return new ToyotaDematLeverModelSchema(Minecraft.getInstance().getEntityModels().bakeLayer(ToyotaDematLeverModelSchema.LAYER_LOCATION));
    }

    @Override
    public AnimationState getAnimationToBeRan(ControlBlockEntity control) {
        if (!(control instanceof DematControlBlockEntity lever)) return null;

        if (lever.pulled()) {
            return leverUpAnimationState;
        }
        return leverDownAnimationState;
    }
}

