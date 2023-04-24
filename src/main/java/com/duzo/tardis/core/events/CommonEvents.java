package com.duzo.tardis.core.events;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.tardis.manager.TARDISManager;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.profiling.jfr.event.WorldLoadFinishedEvent;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.ServerLifecycleHooks;
import org.apache.logging.log4j.core.jmx.Server;

@Mod.EventBusSubscriber(modid = TARDISMod.MODID)
public class CommonEvents {
    @SubscribeEvent
    public void onWorldLoad(LevelEvent.Load event) { // When world loads
        if (!event.getLevel().isClientSide()) { // Server Side Only
            ServerLevel world = (ServerLevel) event.getLevel();
            assert world != null;
            System.out.println("world loaded" + world);
            if (world.dimension().equals(ServerLevel.OVERWORLD)) {
                TARDISMod.server = ServerLifecycleHooks.getCurrentServer();
            }
        }
    }
}
