package com.duzo.tardis.tardis.controls.blocks;

import com.duzo.tardis.TARDISMod;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ControlsInit {
    public static final DeferredRegister<Block> CONTROL_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TARDISMod.MODID);
    public static final DeferredRegister<BlockEntityType<?>> CONTROL_BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TARDISMod.MODID);

}

