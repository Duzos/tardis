package com.duzo.tardis.tardis.interiors;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.core.world.dimension.DimensionsInit;
import com.duzo.tardis.tardis.doors.TARDISInteriorDoors;
import com.duzo.tardis.tardis.structures.TARDISStructure;
import com.duzo.tardis.tardis.util.TARDISUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.checkerframework.checker.units.qual.C;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class TARDISInterior extends TARDISStructure {
    protected BlockPos doorPosition;
    protected String id;
    protected StructureTemplate template;

    public TARDISInterior(ResourceLocation location, String id) {
        super(id);
        this.location = location;
        this.id = id;
    }
    public TARDISInterior(String structureName) {
        this(new ResourceLocation(TARDISMod.MODID,"interiors/" + structureName), structureName);
    }

    @Deprecated
    public void findDoorPosition(StructureTemplate template) {
        CompoundTag tag = template.save(new CompoundTag());

        AtomicInteger i = new AtomicInteger();
        AtomicInteger interiorDoorNumberState = new AtomicInteger();

        tag.getList("pallete", Tag.TAG_COMPOUND).forEach((inbt -> {
            CompoundTag nbt = (CompoundTag) inbt;
            String name = nbt.getString("Name");

            // If the name is in the door list

//            if (Arrays.stream(TARDISInteriorDoors.INTERIOR_DOOR_BLOCK_ID_LIST).toArray(door -> name.equals(door))) {
//                interiorDoorNumberState.set(i.intValue());
//            }

            i.getAndIncrement();
        }));

        tag.getList("blocks", Tag.TAG_COMPOUND).forEach((inbt -> {
            CompoundTag nbt = (CompoundTag) inbt;
            int state = nbt.getInt("state");

            if (state == interiorDoorNumberState.get()) {
                ListTag posList = nbt.getList("pos", Tag.TAG_INT);
                doorPosition = new BlockPos(posList.getInt(0),posList.getInt(1),posList.getInt(2));
            }
        }));
    }
    @Deprecated
    public void place(ServerLevel level, BlockPos pos) {
        this.template.placeInWorld(level,pos,pos,new StructurePlaceSettings(), RandomSource.create(),2);
    }

    @Deprecated
    /**
     * This is to be ran when the TARDIS level loads so that the TARDIS level isnt returned as null
     */
    public void generateTemplate() {
        this.template = TARDISUtil.getTARDISLevel().getStructureManager().getOrCreate(location);
    }

    public void setDoorPosition(BlockPos pos) {
        this.doorPosition = pos;
    }
    public BlockPos getDoorPosition() {
        return this.doorPosition;
    }
    public String getID() {return this.id;}
}
