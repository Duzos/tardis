package com.duzo.tardis.tardis.links;

import com.duzo.tardis.tardis.TARDIS;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class LinkableItem extends Item {
    private TARDIS tardis;
    public LinkableItem(Properties properties) {
        super(properties);
    }

    protected void link(TARDIS tardis) {
        this.tardis = tardis;
    }

    protected TARDIS getTARDIS() {
        return this.tardis;
    }
}
