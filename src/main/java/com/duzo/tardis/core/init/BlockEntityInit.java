package com.duzo.tardis.core.init;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.tardis.blocks.entities.TARDISBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityInit {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TARDISMod.MODID);

    public static final RegistryObject<BlockEntityType<TARDISBlockEntity>> TARDIS_BLOCK_ENTITY = BLOCK_ENTITIES.register("tardis_block_entity",() -> BlockEntityType.Builder.of(TARDISBlockEntity::new, BlockInit.TARDIS_BLOCK.get()).build(null));
}
