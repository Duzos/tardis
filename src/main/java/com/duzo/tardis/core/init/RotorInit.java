package com.duzo.tardis.core.init;

import com.duzo.tardis.tardis.blocks.rotors.RotorBlock;
import com.duzo.tardis.tardis.blocks.rotors.entities.RotorBlockEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.duzo.tardis.core.init.BlockEntityInit.BLOCK_ENTITIES;
import static com.duzo.tardis.core.init.BlockInit.BLOCKS;
import static com.duzo.tardis.core.init.BlockInit.register;

public class RotorInit {

//    public static HashMap<RegistryObject<BlockEntityType<RotorBlockEntity>>,RotorBlock> ROTORS;
    public static final RegistryObject<RotorBlock> ROTOR_BLOCK = BLOCKS.register("rotor_block", () -> new RotorBlock(BlockBehaviour.Properties.of(Material.GLASS).strength(3f)));
//    public static final RegistryObject<RotorBlock> CORAL_ROTOR_BLOCK = register("coral_rotor_block",() -> new RotorBlock(BlockBehaviour.Properties.of(Material.GLASS).strength(3f)), new Item.Properties().tab(CreativeTabInit.TARDIS_TAB));
    public static final RegistryObject<BlockEntityType<RotorBlockEntity>> ROTOR_BLOCK_ENTITY = BLOCK_ENTITIES.register("rotor_block_entity", () -> BlockEntityType.Builder.<RotorBlockEntity>of(RotorBlockEntity::new, ROTOR_BLOCK).build(null));
//    private static RegistryObject<BlockEntityType<RotorBlockEntity>> createRotorBlockEntity(String prefix, RotorBlock rotorBlock) {
//        RegistryObject<BlockEntityType<RotorBlockEntity>> rotor = BLOCK_ENTITIES.register( prefix +"_rotor_block_entity", () -> BlockEntityType.Builder.of(RotorBlockEntity::new, rotorBlock).build(null));
//        ROTORS.put(rotor,rotorBlock);
//        return rotor;
//    }
}
