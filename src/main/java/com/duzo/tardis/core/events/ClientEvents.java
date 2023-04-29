package com.duzo.tardis.core.events;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.tardis.controls.ControlRenderer;
import com.duzo.tardis.tardis.controls.blocks.ControlsInit;
import com.duzo.tardis.tardis.controls.impl.models.CoralDematLeverModelSchema;
import com.duzo.tardis.tardis.controls.impl.models.CoralRotorModelSchema;
import com.duzo.tardis.tardis.controls.impl.models.VanillaDematLeverModelSchema;
import com.duzo.tardis.tardis.doors.blocks.DoorsInit;
import com.duzo.tardis.tardis.doors.impl.models.ClassicInteriorDoorModel;
import com.duzo.tardis.tardis.exteriors.ExteriorRenderer;
import com.duzo.tardis.tardis.doors.InteriorDoorRenderer;
import com.duzo.tardis.core.init.BlockEntityInit;
import com.duzo.tardis.tardis.exteriors.impl.models.ClassicTARDISExteriorModel;
import com.duzo.tardis.tardis.exteriors.impl.models.OriginalTARDISExteriorModel;
import com.duzo.tardis.tardis.exteriors.impl.models.ThirdTARDISExteriorModel;
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
//        DoorsInit.DOOR_ENTITIES_LIST.forEach((door) -> renderers.registerBlockEntityRenderer(door,InteriorDoorRenderer::new));
        renderers.registerBlockEntityRenderer(DoorsInit.CLASSIC_DOOR_ENTITY.get(),InteriorDoorRenderer::new);

        // Controls
        renderers.registerBlockEntityRenderer(ControlsInit.CORAL_DEMAT_LEVER_ENTITY.get(), ControlRenderer::new);
        renderers.registerBlockEntityRenderer(ControlsInit.VANILLA_DEMAT_LEVER_ENTITY.get(), ControlRenderer::new);
        renderers.registerBlockEntityRenderer(ControlsInit.CORAL_ROTOR_ENTITY.get(), ControlRenderer::new);

        // Rotors
//        renderers.registerBlockEntityRenderer(RotorInit.ROTOR_BLOCK_ENTITY.get(), RotorRenderer::new);
//        RotorInit.ROTORS.forEach((rotor,block) -> {
//            renderers.registerBlockEntityRenderer(rotor.get(), RotorRenderer::new);
//        });
    }

    @SubscribeEvent
    public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
        // Coral
        event.registerLayerDefinition(CoralDematLeverModelSchema.LAYER_LOCATION, CoralDematLeverModelSchema::createBodyLayer); // Demat lever
        event.registerLayerDefinition(ClassicTARDISExteriorModel.LAYER_LOCATION, ClassicTARDISExteriorModel::createBodyLayer); // Exterior
        event.registerLayerDefinition(ClassicInteriorDoorModel.LAYER_LOCATION, ClassicInteriorDoorModel::createBodyLayer); // Interior door
        event.registerLayerDefinition(CoralRotorModelSchema.LAYER_LOCATION, CoralRotorModelSchema::createBodyLayer); // Rotor

        event.registerLayerDefinition(OriginalTARDISExteriorModel.LAYER_LOCATION, OriginalTARDISExteriorModel::createBodyLayer);
        event.registerLayerDefinition(ThirdTARDISExteriorModel.LAYER_LOCATION, ThirdTARDISExteriorModel::createBodyLayer);
        event.registerLayerDefinition(VanillaDematLeverModelSchema.LAYER_LOCATION, VanillaDematLeverModelSchema::createBodyLayer);
//        event.registerLayerDefinition(CoralTimeRotorModel.LAYER_LOCATION, CoralTimeRotorModel::createBodyLayer);
    }
}
