package com.duzo.tardis.core.events;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.client.renderers.GenericRenderer;
import com.duzo.tardis.core.init.BlockEntityInit;
import com.duzo.tardis.core.init.BlockInit;
import com.duzo.tardis.core.init.EntityInit;
import com.duzo.tardis.core.screens.MonitorScreen;
import com.duzo.tardis.tardis.consoles.ConsoleRenderer;
import com.duzo.tardis.tardis.consoles.impl.models.BorealisConsoleModel;
import com.duzo.tardis.tardis.consoles.impl.models.HudolinConsoleModel;
import com.duzo.tardis.tardis.controls.control_entities.ControlEntityRenderer;
import com.duzo.tardis.tardis.doors.InteriorDoorRenderer;
import com.duzo.tardis.tardis.doors.blocks.DoorsInit;
import com.duzo.tardis.tardis.doors.impl.models.BasicBoxDoorModelSchema;
import com.duzo.tardis.tardis.exteriors.ExteriorRenderer;
import com.duzo.tardis.tardis.exteriors.impl.models.BasicBoxExteriorModel;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.UUID;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = TARDISMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEvents {
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers renderers) {
        renderers.registerBlockEntityRenderer(BlockEntityInit.TARDIS_BLOCK_ENTITY.get(), ExteriorRenderer::new);
        renderers.registerBlockEntityRenderer(DoorsInit.BASIC_DOOR_ENTITY.get(), InteriorDoorRenderer::new);
        renderers.registerBlockEntityRenderer(BlockEntityInit.CONSOLE_BLOCK_ENTITY.get(), ConsoleRenderer::new);
//        renderers.registerEntityRenderer(EntityInit.BASIC_CONTROL_ENTITY.get(), ControlEntityRenderer::new);
        renderers.registerEntityRenderer(EntityInit.THROTTLE_CONTROL_ENTITY.get(), ControlEntityRenderer::new);
        renderers.registerEntityRenderer(EntityInit.HANDBRAKE_CONTROL_ENTITY.get(), ControlEntityRenderer::new);
        renderers.registerEntityRenderer(EntityInit.X_CONTROL_ENTITY.get(), ControlEntityRenderer::new);
        renderers.registerEntityRenderer(EntityInit.Y_CONTROL_ENTITY.get(), ControlEntityRenderer::new);
        renderers.registerEntityRenderer(EntityInit.Z_CONTROL_ENTITY.get(), ControlEntityRenderer::new);
        renderers.registerEntityRenderer(EntityInit.INCREMENT_CONTROL_ENTITY.get(), ControlEntityRenderer::new);
        renderers.registerEntityRenderer(EntityInit.DOOR_CONTROL_ENTITY.get(), ControlEntityRenderer::new);
        renderers.registerEntityRenderer(EntityInit.MONITOR_CONTROL_ENTITY.get(), ControlEntityRenderer::new);
        renderers.registerEntityRenderer(EntityInit.RANDOMIZER_CONTROL_ENTITY.get(), ControlEntityRenderer::new);
        renderers.registerEntityRenderer(EntityInit.FACING_CONTROL_ENTITY.get(), ControlEntityRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(BasicBoxExteriorModel.LAYER_LOCATION,BasicBoxExteriorModel::createBodyLayer);
        event.registerLayerDefinition(BasicBoxDoorModelSchema.LAYER_LOCATION,BasicBoxDoorModelSchema::createBodyLayer);
        event.registerLayerDefinition(BorealisConsoleModel.LAYER_LOCATION,BorealisConsoleModel::createBodyLayer);
        event.registerLayerDefinition(HudolinConsoleModel.LAYER_LOCATION,HudolinConsoleModel::createBodyLayer);
    }

    public static Screen createMonitorScreen(Component component, UUID tardisID, Player player, BlockPos pos) {
        return new MonitorScreen(component, tardisID, player, pos);
    }
}
