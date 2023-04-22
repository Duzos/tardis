package com.duzo.tardis.core.init;

import com.duzo.tardis.TARDISMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundsInit {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, TARDISMod.MODID);

    public static final RegistryObject<SoundEvent> DEMATERIALISE = SOUNDS.register("dematerialise", () -> new SoundEvent(new ResourceLocation(TARDISMod.MODID, "dematerialise")));
    public static final RegistryObject<SoundEvent> MATERIALISE = SOUNDS.register("materialise", () -> new SoundEvent(new ResourceLocation(TARDISMod.MODID, "materialise")));
}
