package com.duzo.tardis;

import com.duzo.tardis.core.init.*;
import com.duzo.tardis.core.world.dimension.DimensionsInit;
import com.duzo.tardis.tardis.exteriors.TARDISExteriors;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.server.ServerLifecycleHooks;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TARDISMod.MODID)
public class TARDISMod {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "tardis";
    // Directly reference a slf4j logger
    public static MinecraftServer server;
    private static final Logger LOGGER = LogUtils.getLogger();
    public TARDISMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        bus.addListener(this::commonSetup);
//        bus.addListener(this::onWorldLoad);

        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        BlockEntityInit.BLOCK_ENTITIES.register(bus);
        SoundsInit.SOUNDS.register(bus);
        DimensionsInit.register();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @SubscribeEvent
    public void onWorldLoad(LevelEvent.Load event) { // When world loads
        System.out.println("world loaded");
        if (!event.getLevel().isClientSide()) { // Server Side Only
            ServerLevel world = (ServerLevel) event.getLevel();
            assert world != null;
            System.out.println("world loaded" + world);
            if (world.dimension().equals(ServerLevel.OVERWORLD)) {
                TARDISMod.server = ServerLifecycleHooks.getCurrentServer();

                TARDISExteriors.init();
            }
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
