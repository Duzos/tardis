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
    public static final RegistryObject<SoundEvent> EMERGENCY_LAND = SOUNDS.register("emergency_land", () -> new SoundEvent(new ResourceLocation(TARDISMod.MODID, "emergency_land")));
    public static final RegistryObject<SoundEvent> FAIL_LAND = SOUNDS.register("fail_land", () -> new SoundEvent(new ResourceLocation(TARDISMod.MODID, "fail_land")));
    public static final RegistryObject<SoundEvent> FAIL_TAKEOFF = SOUNDS.register("fail_takeoff", () -> new SoundEvent(new ResourceLocation(TARDISMod.MODID, "fail_takeoff")));
    public static final RegistryObject<SoundEvent> HOP_TAKEOFF = SOUNDS.register("hop_takeoff", () -> new SoundEvent(new ResourceLocation(TARDISMod.MODID, "hop_takeoff")));
    public static final RegistryObject<SoundEvent> HOP_LAND = SOUNDS.register("hop_land", () -> new SoundEvent(new ResourceLocation(TARDISMod.MODID, "hop_land")));

    public static final RegistryObject<SoundEvent> HANDBRAKE_PULL = SOUNDS.register("handbrake_pull", () -> new SoundEvent(new ResourceLocation(TARDISMod.MODID, "handbrake_pull")));
    public static final RegistryObject<SoundEvent> DEMAT_LEVER_PULL = SOUNDS.register("demat_lever_pull", () -> new SoundEvent(new ResourceLocation(TARDISMod.MODID, "demat_lever_pull")));
}
