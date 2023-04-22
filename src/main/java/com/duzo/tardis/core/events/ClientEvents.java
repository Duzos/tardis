package com.duzo.tardis.core.events;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.client.models.blockentities.DefaultExteriorModel;
import com.duzo.tardis.client.models.renderers.blockentities.ExteriorRenderer;
import com.duzo.tardis.core.init.BlockEntityInit;
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
    }

    @SubscribeEvent
    public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(DefaultExteriorModel.LAYER_LOCATION, DefaultExteriorModel::createBodyLayer);
    }
}
