package com.duzo.tardis.core.init;

import com.duzo.tardis.TARDISMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TARDISMod.MODID);

    public static final RegistryObject<Item> TARDIS_ITEM = ITEMS.register("tardis_item", () -> new Item(new Item.Properties().tab(CreativeTabInit.TARDIS_TAB)));
}
