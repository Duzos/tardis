package com.duzo.tardis.core.init;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.common.items.InteriorDeletionItem;
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
    public static final RegistryObject<TARDISSpawnItem> BASIC_BOX_ITEM = ITEMS.register("basic_box_tardis_item",
            () -> new TARDISSpawnItemBuilder(new Item.Properties().tab(CreativeTabInit.TARDIS_TAB).stacksTo(1)).exterior("basic_box"));

    public static final RegistryObject<RemoteItem> STATTENHEIM_REMOTE = ITEMS.register("stattenheim_remote",
            () -> new RemoteItem(new Item.Properties().tab(CreativeTabInit.TARDIS_TAB).stacksTo(1)));
    public static final RegistryObject<InteriorDeletionItem> INTERIOR_DELETION = ITEMS.register("interior_deletion_test",
            () -> new InteriorDeletionItem(new Item.Properties().tab(CreativeTabInit.TARDIS_TAB).stacksTo(1)));
}
