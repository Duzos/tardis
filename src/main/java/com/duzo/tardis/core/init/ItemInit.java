package com.duzo.tardis.core.init;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.common.items.RemoteItem;
import com.duzo.tardis.tardis.item.TARDISSpawnItem;
import com.duzo.tardis.tardis.item.impl.*;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TARDISMod.MODID);

    // TARDIS Spawn items
    public static final RegistryObject<TARDISSpawnItem> CLASSIC_TARDIS_ITEM = ITEMS.register("classic_tardis_item", () -> new ClassicTARDISSpawnItem(new Item.Properties().tab(CreativeTabInit.TARDIS_TAB).stacksTo(1)));
//    public static final RegistryObject<TARDISSpawnItem> ORIGINAL_TARDIS_ITEM = ITEMS.register("original_tardis_item", () -> new OriginalTARDISSpawnItem(new Item.Properties().tab(CreativeTabInit.TARDIS_TAB).stacksTo(1)));
    public static final RegistryObject<TARDISSpawnItem> THIRD_TARDIS_ITEM = ITEMS.register("third_tardis_item", () -> new ThirdTARDISSpawnItem(new Item.Properties().tab(CreativeTabInit.TARDIS_TAB).stacksTo(1)));
    public static final RegistryObject<TARDISSpawnItem> BAKER_TARDIS_ITEM = ITEMS.register("baker_tardis_item", () -> new BakerTARDISSpawnItem(new Item.Properties().tab(CreativeTabInit.TARDIS_TAB).stacksTo(1)));
    public static final RegistryObject<TARDISSpawnItem> SECOND_TARDIS_ITEM = ITEMS.register("second_tardis_item", () -> new SecondTARDISSpawnItem(new Item.Properties().tab(CreativeTabInit.TARDIS_TAB).stacksTo(1)));


    public static final RegistryObject<RemoteItem> REMOTE_ITEM = ITEMS.register("remote_item", () -> new RemoteItem(new Item.Properties().tab(CreativeTabInit.TARDIS_TAB).stacksTo(1)));
}
