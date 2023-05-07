package com.duzo.tardis.tardis.controls.blocks;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.core.init.CreativeTabInit;
import com.duzo.tardis.tardis.controls.blocks.impl.*;
import com.duzo.tardis.tardis.controls.blocks.impl.entities.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.duzo.tardis.core.init.BlockInit.register;

public class ControlsInit {
    public static final DeferredRegister<Block> CONTROL_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TARDISMod.MODID);
    public static final DeferredRegister<BlockEntityType<?>> CONTROL_BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TARDISMod.MODID);

    public static final RegistryObject<Block> CORAL_DEMAT_LEVER = register("coral_demat_lever", () -> new CoralDematLeverBlock(BlockBehaviour.Properties.of(Material.METAL).noOcclusion().strength(3F)), new Item.Properties().tab(CreativeTabInit.TARDIS_TAB));
    public static final RegistryObject<BlockEntityType<CoralDematLeverBlockEntity>> CORAL_DEMAT_LEVER_ENTITY = CONTROL_BLOCK_ENTITIES.register("coral_demat_lever_entity", () -> BlockEntityType.Builder.of(CoralDematLeverBlockEntity::new, CORAL_DEMAT_LEVER.get()).build(null));
    public static final RegistryObject<Block> COPPER_DEMAT_LEVER = register("copper_demat_lever", () -> new CopperDematLeverBlock(BlockBehaviour.Properties.of(Material.METAL).noOcclusion().strength(3F)), new Item.Properties().tab(CreativeTabInit.TARDIS_TAB));
    public static final RegistryObject<BlockEntityType<CopperDematLeverBlockEntity>> COPPER_DEMAT_LEVER_ENTITY = CONTROL_BLOCK_ENTITIES.register("copper_demat_lever_entity", () -> BlockEntityType.Builder.of(CopperDematLeverBlockEntity::new, COPPER_DEMAT_LEVER.get()).build(null));

    public static final RegistryObject<Block> VANILLA_DEMAT_LEVER = register("vanilla_demat_lever", () -> new VanillaDematLeverBlock(BlockBehaviour.Properties.of(Material.METAL).noOcclusion().strength(3F)), new Item.Properties().tab(CreativeTabInit.TARDIS_TAB));
    public static final RegistryObject<BlockEntityType<VanillaDematLeverBlockEntity>> VANILLA_DEMAT_LEVER_ENTITY = CONTROL_BLOCK_ENTITIES.register("vanilla_demat_lever_entity", () -> BlockEntityType.Builder.of(VanillaDematLeverBlockEntity::new, VANILLA_DEMAT_LEVER.get()).build(null));
    public static final RegistryObject<Block> TOYOTA_DEMAT_LEVER = register("toyota_demat_lever", () -> new ToyotaDematLeverBlock(BlockBehaviour.Properties.of(Material.METAL).noOcclusion().strength(3F)), new Item.Properties().tab(CreativeTabInit.TARDIS_TAB));
    public static final RegistryObject<BlockEntityType<ToyotaDematLeverBlockEntity>> TOYOTA_DEMAT_LEVER_ENTITY = CONTROL_BLOCK_ENTITIES.register("toyota_demat_lever_entity", () -> BlockEntityType.Builder.of(ToyotaDematLeverBlockEntity::new, TOYOTA_DEMAT_LEVER.get()).build(null));

    public static final RegistryObject<Block> CORAL_ROTOR = register("coral_rotor", () -> new CoralRotorBlock(BlockBehaviour.Properties.of(Material.METAL).noOcclusion().strength(3F)), new Item.Properties().tab(CreativeTabInit.TARDIS_TAB));
    public static final RegistryObject<BlockEntityType<CoralRotorBlockEntity>> CORAL_ROTOR_ENTITY = CONTROL_BLOCK_ENTITIES.register("coral_rotor_entity", () -> BlockEntityType.Builder.of(CoralRotorBlockEntity::new, CORAL_ROTOR.get()).build(null));

    public static final RegistryObject<Block> WAR_ROTOR = register("war_rotor", () -> new WarRotorBlock(BlockBehaviour.Properties.of(Material.METAL).noOcclusion().strength(3F)), new Item.Properties().tab(CreativeTabInit.TARDIS_TAB));
    public static final RegistryObject<BlockEntityType<WarRotorBlockEntity>> WAR_ROTOR_ENTITY = CONTROL_BLOCK_ENTITIES.register("war_rotor_entity", () -> BlockEntityType.Builder.of(WarRotorBlockEntity::new, WAR_ROTOR.get()).build(null));

    public static final RegistryObject<Block> EIGHTH_ROTOR = register("eighth_rotor", () -> new EighthRotorBlock(BlockBehaviour.Properties.of(Material.METAL).noOcclusion().strength(3F)), new Item.Properties().tab(CreativeTabInit.TARDIS_TAB));
    public static final RegistryObject<BlockEntityType<EighthRotorBlockEntity>> EIGHTH_ROTOR_ENTITY = CONTROL_BLOCK_ENTITIES.register("eighth_rotor_entity", () -> BlockEntityType.Builder.of(EighthRotorBlockEntity::new, EIGHTH_ROTOR.get()).build(null));

    public static final RegistryObject<Block> VANILLA_HANDBRAKE = register("vanilla_handbrake", () -> new VanillaHandbrakeBlock(BlockBehaviour.Properties.of(Material.METAL).noOcclusion().strength(3F)), new Item.Properties().tab(CreativeTabInit.TARDIS_TAB));
    public static final RegistryObject<BlockEntityType<VanillaHandbrakeBlockEntity>> VANILLA_HANDBRAKE_ENTITY = CONTROL_BLOCK_ENTITIES.register("vanilla_handbrake", () -> BlockEntityType.Builder.of(VanillaHandbrakeBlockEntity::new, VANILLA_HANDBRAKE.get()).build(null));

    public static final RegistryObject<Block> VANILLA_COORDINATES = register("vanilla_coordinates", () -> new VanillaCoordinatesBlock(BlockBehaviour.Properties.of(Material.METAL).noOcclusion().strength(3F)), new Item.Properties().tab(CreativeTabInit.TARDIS_TAB));
    public static final RegistryObject<BlockEntityType<VanillaCoordinatesBlockEntity>> VANILLA_COORDINATES_ENTITY = CONTROL_BLOCK_ENTITIES.register("vanilla_coordinates", () -> BlockEntityType.Builder.of(VanillaCoordinatesBlockEntity::new, VANILLA_COORDINATES.get()).build(null));
}

