package com.duzo.tardis.common.blocks.entities;

import com.duzo.tardis.client.models.GenericModel;
import com.duzo.tardis.client.models.blockentities.CoralRampModel;
import com.duzo.tardis.core.init.BlockEntityInit;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class CoralRampBlockEntity extends GenericBlockEntity{
    public CoralRampBlockEntity(BlockEntityType<?> p_155228_, BlockPos p_155229_, BlockState p_155230_) {
        super(p_155228_, p_155229_, p_155230_);
    }
    public CoralRampBlockEntity(BlockPos p_155229_, BlockState p_155230_) {
        super(BlockEntityInit.CORAL_RAMP_ENTITY.get(), p_155229_, p_155230_);
    }

    @Override
    public GenericModel model() {
        return new CoralRampModel(Minecraft.getInstance().getEntityModels().bakeLayer(CoralRampModel.LAYER_LOCATION));
    }

    @Override
    public String id() {
        return "coral_ramp";
    }

}
