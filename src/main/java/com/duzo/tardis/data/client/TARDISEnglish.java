package com.duzo.tardis.data.client;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.core.init.ItemInit;
import com.duzo.tardis.tardis.controls.blocks.ControlsInit;
import com.duzo.tardis.tardis.doors.blocks.DoorsInit;
import com.duzo.tardis.tardis.item.TARDISSpawnItem;
import com.mojang.logging.LogUtils;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;

import javax.sound.sampled.Control;
import java.util.logging.Logger;

public class TARDISEnglish extends LanguageProvider {
    public TARDISEnglish(DataGenerator gen) {
        super(gen, TARDISMod.MODID, "en_us");
    }

    @Override
    public void addTranslations() {
        /* TARDISes */
        for (RegistryObject<Item> item : ItemInit.ITEMS.getEntries()) {
            if(item.get() instanceof TARDISSpawnItem) {
                add(item.get(),"TARDIS");
            }
        }

        add(ItemInit.REMOTE_ITEM.get(), "Stattenheim Remote");

        add(DoorsInit.CORAL_DOOR_BLOCK.get(),"Coral Door");
        add(DoorsInit.WAR_DOOR_BLOCK.get(),"War Door");

        add(ControlsInit.TOYOTA_DEMAT_LEVER.get(),"Toyota Lever");
        add(ControlsInit.COPPER_DEMAT_LEVER.get(),"Copper Lever");
        add(ControlsInit.CORAL_DEMAT_LEVER.get(),"Coral Lever");
        add(ControlsInit.VANILLA_DEMAT_LEVER.get(),"Vanilla Lever");

        add(ControlsInit.VANILLA_COORDINATES.get(),"Coordinates Panel (WIP)");

        add(ControlsInit.VANILLA_HANDBRAKE.get(),"Vanilla Handbrake");

        add(ControlsInit.EIGHTH_ROTOR.get(),"Eighth Rotor");
        add(ControlsInit.WAR_ROTOR.get(),"War Rotor");
        add(ControlsInit.CORAL_ROTOR.get(),"Coral Rotor");
        add(ControlsInit.INVISIBLE_ROTOR.get(),"Invisible Rotor");

        add("itemGroup.tardis_tab","Box Mod");
    }
}
