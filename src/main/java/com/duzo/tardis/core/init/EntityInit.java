package com.duzo.tardis.core.init;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.tardis.controls.control_entities.ControlEntitySchema;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TARDISMod.MODID);

    public static final RegistryObject<EntityType<ControlEntitySchema>> BASIC_CONTROL_ENTITY =
            ENTITY_TYPES.register("basic_control_entity",
                    () -> EntityType.Builder.<ControlEntitySchema>of(ControlEntitySchema::new, MobCategory.AMBIENT)
                            .sized(ControlEntitySchema.xSize(), ControlEntitySchema.ySize())
                            .build(new ResourceLocation(TARDISMod.MODID, "basic_control_entity").toString()));
}
