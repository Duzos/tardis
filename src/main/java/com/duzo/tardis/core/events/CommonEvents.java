package com.duzo.tardis.core.events;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.core.init.EntityInit;
import com.duzo.tardis.tardis.controls.control_entities.ControlEntitySchema;
import com.duzo.tardis.tardis.exteriors.TARDISExteriors;
import com.duzo.tardis.tardis.manager.TARDISManager;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.profiling.jfr.event.WorldLoadFinishedEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.ServerLifecycleHooks;
import org.apache.logging.log4j.core.jmx.Server;

@Mod.EventBusSubscriber(modid = TARDISMod.MODID)
public class CommonEvents {

    @Mod.EventBusSubscriber(modid = TARDISMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {
        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
            event.put(EntityInit.BASIC_CONTROL_ENTITY.get(), ControlEntitySchema.setAttributes());
            event.put(EntityInit.THROTTLE_CONTROL_ENTITY.get(), ControlEntitySchema.setAttributes());
            event.put(EntityInit.HANDBRAKE_CONTROL_ENTITY.get(), ControlEntitySchema.setAttributes());
            event.put(EntityInit.X_CONTROL_ENTITY.get(), ControlEntitySchema.setAttributes());
            event.put(EntityInit.Y_CONTROL_ENTITY.get(), ControlEntitySchema.setAttributes());
            event.put(EntityInit.Z_CONTROL_ENTITY.get(), ControlEntitySchema.setAttributes());
            event.put(EntityInit.INCREMENT_CONTROL_ENTITY.get(), ControlEntitySchema.setAttributes());
        }
    }

}
