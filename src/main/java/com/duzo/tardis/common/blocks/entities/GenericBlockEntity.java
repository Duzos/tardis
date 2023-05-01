package com.duzo.tardis.common.blocks.entities;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.client.models.GenericModel;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class GenericBlockEntity extends BlockEntity {
    public GenericBlockEntity(BlockEntityType<?> p_155228_, BlockPos p_155229_, BlockState p_155230_) {
        super(p_155228_, p_155229_, p_155230_);
    }

    public abstract GenericModel model();
    public abstract String id();
    public ResourceLocation texture() {
        return new ResourceLocation(TARDISMod.MODID, "textures/block/generic/" + this.id() + ".png");
    }
}
