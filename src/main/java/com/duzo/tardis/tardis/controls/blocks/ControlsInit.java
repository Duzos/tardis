package com.duzo.tardis.tardis.controls.blocks;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.core.init.CreativeTabInit;
import com.duzo.tardis.tardis.controls.blocks.impl.CoralDematLeverBlock;
import com.duzo.tardis.tardis.controls.blocks.impl.VanillaDematLeverBlock;
import com.duzo.tardis.tardis.controls.blocks.impl.entities.CoralDematLeverBlockEntity;
import com.duzo.tardis.tardis.controls.blocks.impl.entities.VanillaDematLeverBlockEntity;
import com.duzo.tardis.tardis.doors.blocks.impl.ClassicInteriorDoorBlock;
import com.duzo.tardis.tardis.doors.blocks.impl.entities.ClassicInteriorDoorBlockEntity;
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

    public static final RegistryObject<Block> VANILLA_DEMAT_LEVER = register("vanilla_demat_lever", () -> new VanillaDematLeverBlock(BlockBehaviour.Properties.of(Material.METAL).noOcclusion().strength(3F)), new Item.Properties().tab(CreativeTabInit.TARDIS_TAB));
    public static final RegistryObject<BlockEntityType<VanillaDematLeverBlockEntity>> VANILLA_DEMAT_LEVER_ENTITY = CONTROL_BLOCK_ENTITIES.register("vanilla_demat_lever_entity", () -> BlockEntityType.Builder.of(VanillaDematLeverBlockEntity::new, VANILLA_DEMAT_LEVER.get()).build(null));
}

