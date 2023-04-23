package com.duzo.tardis.core.init;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.common.items.RemoteItem;
import com.duzo.tardis.tardis.item.TARDISSpawnItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TARDISMod.MODID);

    public static final RegistryObject<TARDISSpawnItem> TARDIS_ITEM = ITEMS.register("tardis_item", () -> new TARDISSpawnItem(new Item.Properties().tab(CreativeTabInit.TARDIS_TAB).stacksTo(1)));
    public static final RegistryObject<RemoteItem> REMOTE_ITEM = ITEMS.register("remote_item", () -> new RemoteItem(new Item.Properties().tab(CreativeTabInit.TARDIS_TAB).stacksTo(1)));
}
