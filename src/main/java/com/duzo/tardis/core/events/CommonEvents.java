package com.duzo.tardis.core.events;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.tardis.exteriors.TARDISExteriors;
import com.duzo.tardis.tardis.manager.TARDISManager;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.profiling.jfr.event.WorldLoadFinishedEvent;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.ServerLifecycleHooks;
import org.apache.logging.log4j.core.jmx.Server;

@Mod.EventBusSubscriber(modid = TARDISMod.MODID)
public class CommonEvents { }
