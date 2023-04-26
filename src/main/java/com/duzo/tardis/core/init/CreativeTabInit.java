package com.duzo.tardis.core.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class CreativeTabInit {
    public static final CreativeModeTab TARDIS_TAB = new CreativeModeTab("tardis_tab") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(ItemInit.CLASSIC_TARDIS_ITEM.get());
        }
    };
}
