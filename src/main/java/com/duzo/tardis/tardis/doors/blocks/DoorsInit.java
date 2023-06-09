package com.duzo.tardis.tardis.doors.blocks;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.core.init.CreativeTabInit;
import com.duzo.tardis.core.init.ItemInit;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static com.duzo.tardis.core.init.BlockInit.register;

public class DoorsInit {
    public static final List<BlockEntityType<? extends InteriorDoorBlockEntity>> DOOR_ENTITIES_LIST = new ArrayList<>();
    public static final DeferredRegister<Block> DOOR_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TARDISMod.MODID);
    public static final DeferredRegister<BlockEntityType<?>> DOOR_BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TARDISMod.MODID);

    public static <T extends Block> RegistryObject<T> registerDoorBlock(String name, Supplier<T> supplier, Item.Properties properties){
        RegistryObject<T> block = DOOR_BLOCKS.register(name, supplier);
        ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), properties));
        return block;
    }

    @Deprecated
    /**
     * do not
     */
    public static void addDoorEntityToList(BlockEntityType<? extends InteriorDoorBlockEntity> door) {
        DOOR_ENTITIES_LIST.add(door);
    }
}
