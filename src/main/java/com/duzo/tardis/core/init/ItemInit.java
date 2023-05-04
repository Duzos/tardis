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
    public static final RegistryObject<TARDISSpawnItem> CORAL_TARDIS_ITEM = ITEMS.register("coral_tardis_item", () -> new TARDISSpawnItemBuilder(new Item.Properties().tab(CreativeTabInit.TARDIS_TAB).stacksTo(1)).interior("coral").exterior("coral"));
    public static final RegistryObject<TARDISSpawnItem> WAR_TARDIS_ITEM = ITEMS.register("war_tardis_item", () -> new TARDISSpawnItemBuilder(new Item.Properties().tab(CreativeTabInit.TARDIS_TAB).stacksTo(1)).interior("war").exterior("war"));
//    public static final RegistryObject<TARDISSpawnItem> ORIGINAL_TARDIS_ITEM = ITEMS.register("original_tardis_item", () -> new OriginalTARDISSpawnItem(new Item.Properties().tab(CreativeTabInit.TARDIS_TAB).stacksTo(1)));
    public static final RegistryObject<TARDISSpawnItem> THIRD_TARDIS_ITEM = ITEMS.register("third_tardis_item", () -> new TARDISSpawnItemBuilder(new Item.Properties().tab(CreativeTabInit.TARDIS_TAB).stacksTo(1)).interior("eighth").exterior("third"));
    public static final RegistryObject<TARDISSpawnItem> BAKER_TARDIS_ITEM = ITEMS.register("baker_tardis_item", () -> new TARDISSpawnItemBuilder(new Item.Properties().tab(CreativeTabInit.TARDIS_TAB).stacksTo(1)).interior("baker").exterior("baker"));
    public static final RegistryObject<TARDISSpawnItem> SECOND_TARDIS_ITEM = ITEMS.register("second_tardis_item", () -> new TARDISSpawnItemBuilder(new Item.Properties().tab(CreativeTabInit.TARDIS_TAB).stacksTo(1)).interior("baker").exterior("second"));
    public static final RegistryObject<TARDISSpawnItem> TOYOTA_TARDIS_ITEM = ITEMS.register("toyota_tardis_item", () -> new TARDISSpawnItemBuilder(new Item.Properties().tab(CreativeTabInit.TARDIS_TAB).stacksTo(1)).exterior("toyota"));
    public static final RegistryObject<TARDISSpawnItem> COPPER_TARDIS_ITEM = ITEMS.register("copper_tardis_item", () -> new TARDISSpawnItemBuilder(new Item.Properties().tab(CreativeTabInit.TARDIS_TAB).stacksTo(1)).exterior("copper"));
    public static final RegistryObject<TARDISSpawnItem> HELLBENT_TARDIS_ITEM = ITEMS.register("hellbent_tardis_item", () -> new TARDISSpawnItemBuilder(new Item.Properties().tab(CreativeTabInit.TARDIS_TAB).stacksTo(1)).interior("baker").exterior("hellbent"));


    public static final RegistryObject<RemoteItem> REMOTE_ITEM = ITEMS.register("remote_item", () -> new RemoteItem(new Item.Properties().tab(CreativeTabInit.TARDIS_TAB).stacksTo(1)));
}
