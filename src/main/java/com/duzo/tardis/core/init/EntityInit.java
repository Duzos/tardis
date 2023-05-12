package com.duzo.tardis.core.init;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.tardis.controls.control_entities.ControlEntitySchema;
import com.duzo.tardis.tardis.controls.control_entities.impl.*;
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

//    public static final RegistryObject<EntityType<ControlEntitySchema>> BASIC_CONTROL_ENTITY =
//            ENTITY_TYPES.register("basic_control_entity",
//                    () -> EntityType.Builder.<ControlEntitySchema>of(ControlEntitySchema::new, MobCategory.AMBIENT)
//                            .sized(ControlEntitySchema.xSize(), ControlEntitySchema.ySize())
//                            .build(new ResourceLocation(TARDISMod.MODID, "basic_control_entity").toString()));
    public static final RegistryObject<EntityType<ControlEntitySchema>> THROTTLE_CONTROL_ENTITY =
            ENTITY_TYPES.register("throttle_control_entity",
                    () -> EntityType.Builder.<ControlEntitySchema>of(ThrottleControlEntity::new, MobCategory.AMBIENT)
                            .sized(ControlEntitySchema.xSize(), ControlEntitySchema.ySize())
                            .build(new ResourceLocation(TARDISMod.MODID, "throttle_control_entity").toString()));
    public static final RegistryObject<EntityType<ControlEntitySchema>> HANDBRAKE_CONTROL_ENTITY =
            ENTITY_TYPES.register("handbrake_control_entity",
                    () -> EntityType.Builder.<ControlEntitySchema>of(HandbrakeControlEntity::new, MobCategory.AMBIENT)
                            .sized(ControlEntitySchema.xSize(), ControlEntitySchema.ySize())
                            .build(new ResourceLocation(TARDISMod.MODID, "handbrake_control_entity").toString()));
    public static final RegistryObject<EntityType<ControlEntitySchema>> X_CONTROL_ENTITY =
            ENTITY_TYPES.register("x_control_entity",
                    () -> EntityType.Builder.<ControlEntitySchema>of(XCoordinateControlEntity::new, MobCategory.AMBIENT)
                            .sized(0.1f, 0.1f)
                            .build(new ResourceLocation(TARDISMod.MODID, "x_control_entity").toString()));
    public static final RegistryObject<EntityType<ControlEntitySchema>> Y_CONTROL_ENTITY =
            ENTITY_TYPES.register("y_control_entity",
                    () -> EntityType.Builder.<ControlEntitySchema>of(YCoordinateControlEntity::new, MobCategory.AMBIENT)
                            .sized(0.1f, 0.1f)
                            .build(new ResourceLocation(TARDISMod.MODID, "y_control_entity").toString()));
    public static final RegistryObject<EntityType<ControlEntitySchema>> Z_CONTROL_ENTITY =
            ENTITY_TYPES.register("z_control_entity",
                    () -> EntityType.Builder.<ControlEntitySchema>of(ZCoordinateControlEntity::new, MobCategory.AMBIENT)
                            .sized(0.1f, 0.1f)
                            .build(new ResourceLocation(TARDISMod.MODID, "z_control_entity").toString()));
    public static final RegistryObject<EntityType<ControlEntitySchema>> INCREMENT_CONTROL_ENTITY =
            ENTITY_TYPES.register("increment_control_entity",
                    () -> EntityType.Builder.<ControlEntitySchema>of(IncrementCoordinateControlEntity::new, MobCategory.AMBIENT)
                            .sized(ControlEntitySchema.xSize(), ControlEntitySchema.ySize())
                            .build(new ResourceLocation(TARDISMod.MODID, "increment_control_entity").toString()));
    public static final RegistryObject<EntityType<ControlEntitySchema>> DOOR_CONTROL_ENTITY =
            ENTITY_TYPES.register("door_control_entity",
                    () -> EntityType.Builder.<ControlEntitySchema>of(DoorControlEntity::new, MobCategory.AMBIENT)
                            .sized(ControlEntitySchema.xSize(), ControlEntitySchema.ySize())
                            .build(new ResourceLocation(TARDISMod.MODID, "door_control_entity").toString()));
    public static final RegistryObject<EntityType<ControlEntitySchema>> MONITOR_CONTROL_ENTITY =
            ENTITY_TYPES.register("monitor_control_entity",
                    () -> EntityType.Builder.<ControlEntitySchema>of(MonitorControlEntity::new, MobCategory.AMBIENT)
                            .sized(0.2f, 0.2f)
                            .build(new ResourceLocation(TARDISMod.MODID, "monitor_control_entity").toString()));
    public static final RegistryObject<EntityType<ControlEntitySchema>> RANDOMIZER_CONTROL_ENTITY =
            ENTITY_TYPES.register("randomizer_control_entity",
                    () -> EntityType.Builder.<ControlEntitySchema>of(RandomizerControlEntity::new, MobCategory.AMBIENT)
                            .sized(ControlEntitySchema.xSize(), ControlEntitySchema.ySize())
                            .build(new ResourceLocation(TARDISMod.MODID, "randomizer_control_entity").toString()));
}
