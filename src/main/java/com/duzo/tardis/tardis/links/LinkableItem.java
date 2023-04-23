package com.duzo.tardis.tardis.links;

import com.duzo.tardis.tardis.TARDIS;
import com.duzo.tardis.tardis.manager.TARDISManager;
import com.duzo.tardis.tardis.manager.TARDISMap;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public abstract class LinkableItem extends Item {
    private TARDIS tardis;
    public LinkableItem(Properties properties) {
        super(properties);
    }

    protected void link(CompoundTag tag, TARDIS tardis) {
        this.tardis = tardis;
        tag.putUUID("tardisUUID",tardis.getUuid());
    }
    protected void link(ItemStack stack, TARDIS tardis) {
        this.link(stack.getOrCreateTag(), tardis);
    }

    protected TARDIS getTARDIS(CompoundTag tag) {
        if (!tag.contains("tardisUUID")) {return null;}
        UUID tardisUUID = tag.getUUID("tardisUUID");
        return TARDISManager.getInstance().findTARDIS(tardisUUID);
    }
    protected TARDIS getTARDIS(ItemStack stack) {
        return this.getTARDIS(stack.getOrCreateTag());
    }
}
