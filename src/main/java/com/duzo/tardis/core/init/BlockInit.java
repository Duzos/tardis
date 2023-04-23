package com.duzo.tardis.core.init;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.tardis.blocks.ExteriorBlock;
import com.duzo.tardis.tardis.blocks.InteriorDoorBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TARDISMod.MODID);

    public static final RegistryObject<Block> TARDIS_BLOCK = register("tardis_block", () -> new ExteriorBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(3F)), new Item.Properties().tab(CreativeTabInit.TARDIS_TAB));
    public static final RegistryObject<Block> INTERIOR_DOOR_BLOCK = register("interior_door_block", () -> new InteriorDoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(3F)), new Item.Properties().tab(CreativeTabInit.TARDIS_TAB));
    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> supplier, Item.Properties properties){
        RegistryObject<T> block = BLOCKS.register(name, supplier);
        ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), properties));
        return block;
    }
}
