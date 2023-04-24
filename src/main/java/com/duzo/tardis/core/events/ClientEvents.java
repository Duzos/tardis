package com.duzo.tardis.core.events;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.client.models.blockentities.exteriors.DefaultExteriorModel;
import com.duzo.tardis.client.models.blockentities.interior.doors.DefaultInteriorDoorModel;
import com.duzo.tardis.client.models.blockentities.interior.rotors.CoralTimeRotorModel;
import com.duzo.tardis.client.renderers.blockentities.ExteriorRenderer;
import com.duzo.tardis.client.renderers.blockentities.InteriorDoorRenderer;
import com.duzo.tardis.client.renderers.blockentities.RotorRenderer;
import com.duzo.tardis.core.init.BlockEntityInit;
import com.duzo.tardis.core.init.RotorInit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

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
        event.registerLayerDefinition(DefaultExteriorModel.LAYER_LOCATION, DefaultExteriorModel::createBodyLayer);
        event.registerLayerDefinition(DefaultInteriorDoorModel.LAYER_LOCATION, DefaultInteriorDoorModel::createBodyLayer);
        event.registerLayerDefinition(CoralTimeRotorModel.LAYER_LOCATION, CoralTimeRotorModel::createBodyLayer);
    }
}
