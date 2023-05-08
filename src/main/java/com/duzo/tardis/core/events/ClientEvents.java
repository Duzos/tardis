package com.duzo.tardis.core.events;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.core.init.BlockEntityInit;
import com.duzo.tardis.tardis.doors.InteriorDoorRenderer;
import com.duzo.tardis.tardis.doors.blocks.DoorsInit;
import com.duzo.tardis.tardis.doors.impl.models.BasicBoxDoorModelSchema;
import com.duzo.tardis.tardis.exteriors.ExteriorRenderer;
import com.duzo.tardis.tardis.exteriors.impl.models.BasicBoxExteriorModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = TARDISMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEvents {
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers renderers) {
        renderers.registerBlockEntityRenderer(BlockEntityInit.TARDIS_BLOCK_ENTITY.get(), ExteriorRenderer::new);
        renderers.registerBlockEntityRenderer(DoorsInit.BASIC_DOOR_ENTITY.get(), InteriorDoorRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(BasicBoxExteriorModel.LAYER_LOCATION,BasicBoxExteriorModel::createBodyLayer);
        event.registerLayerDefinition(BasicBoxDoorModelSchema.LAYER_LOCATION,BasicBoxDoorModelSchema::createBodyLayer);
    }
}
