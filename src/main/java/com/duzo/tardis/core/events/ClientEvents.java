package com.duzo.tardis.core.events;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.client.models.blockentities.interior.doors.ClassicInteriorDoorModel;
import com.duzo.tardis.client.renderers.blockentities.ExteriorRenderer;
import com.duzo.tardis.client.renderers.blockentities.InteriorDoorRenderer;
import com.duzo.tardis.core.init.BlockEntityInit;
import com.duzo.tardis.tardis.exteriors.TARDISExteriors;
import com.duzo.tardis.tardis.exteriors.impl.models.ClassicTARDISExteriorModel;
import net.minecraft.server.level.ServerLevel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.ServerLifecycleHooks;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = TARDISMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEvents {
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers renderers) {
        // Exteriors
        renderers.registerBlockEntityRenderer(BlockEntityInit.TARDIS_BLOCK_ENTITY.get(), ExteriorRenderer::new);
        // Doors
        renderers.registerBlockEntityRenderer(BlockEntityInit.INTERIOR_DOOR_BLOCK_ENTITY.get(), InteriorDoorRenderer::new);
        // Rotors
//        renderers.registerBlockEntityRenderer(RotorInit.ROTOR_BLOCK_ENTITY.get(), RotorRenderer::new);
//        RotorInit.ROTORS.forEach((rotor,block) -> {
//            renderers.registerBlockEntityRenderer(rotor.get(), RotorRenderer::new);
//        });
    }

    @SubscribeEvent
    public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ClassicTARDISExteriorModel.LAYER_LOCATION, ClassicTARDISExteriorModel::createBodyLayer);
        event.registerLayerDefinition(ClassicInteriorDoorModel.LAYER_LOCATION, ClassicInteriorDoorModel::createBodyLayer);
//        event.registerLayerDefinition(CoralTimeRotorModel.LAYER_LOCATION, CoralTimeRotorModel::createBodyLayer);
    }
}
