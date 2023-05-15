package com.duzo.tardis.tardis.controls.control_entities.impl;

import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.tardis.TARDIS;
import com.duzo.tardis.tardis.consoles.blocks.entities.ConsoleBlockEntity;
import com.duzo.tardis.tardis.controls.control_entities.ControlEntitySchema;
import com.duzo.tardis.tardis.doors.blocks.InteriorDoorBlockEntity;
import com.duzo.tardis.tardis.manager.TARDISManager;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.awt.*;
import java.util.UUID;

public class DoorControlEntity extends ControlEntitySchema {
    public DoorControlEntity(EntityType<? extends AmbientCreature> p_i50290_1_, Level p_i50290_2_) {
        super(p_i50290_1_, p_i50290_2_);
    }

    public DoorControlEntity(EntityType<? extends AmbientCreature> entity, Level level, UUID tardisID, String name, BlockPos consoleBlockPos) {
        super(entity, level, tardisID, name, consoleBlockPos);
    }

    public void setDoorOpen(UUID tardisID, Boolean bool, Player source) {
        if(source.getLevel().isClientSide()) return;
        TARDIS tardis = TARDISManager.getInstance().findTARDIS(tardisID);
        if(tardis.getInterior().getInteriorDoorPos() == null) {return;}
        InteriorDoorBlockEntity door = (InteriorDoorBlockEntity) level.getBlockEntity(tardis.getInterior().getInteriorDoorPos());
        if(bool) {
            door.setDoorLocked(!door.doorLocked(), true);
            if(door.doorLocked()) {
                source.displayClientMessage(Component.translatable("Door locked!").withStyle(ChatFormatting.YELLOW), true);
            } else {
                source.displayClientMessage(Component.translatable("Door unlocked!").withStyle(ChatFormatting.YELLOW), true);
            }
        } else {
            if(!door.doorLocked()) {
                door.setDoorOpened(!door.doorOpen(), true);
            } else {
                door.setDoorOpened(false, true);
            }
            if(door.doorOpen()) {
                source.displayClientMessage(Component.translatable("Door opened!").withStyle(ChatFormatting.YELLOW), true);
            } else {
                source.displayClientMessage(Component.translatable("Door closed!").withStyle(ChatFormatting.YELLOW), true);
            }
        }
    }

    @Override
    public void runInteractions(Player pSource) {
        super.runInteractions(pSource);
        if (pSource.level.isClientSide) return;

        if(!this.getControlName().equals("Door Control")) return;

        this.setDoorOpen(this.tardisID, pSource.isCrouching(), pSource);
        if(this.consolePosition != null && !level.isClientSide()) {
            ConsoleBlockEntity console = (ConsoleBlockEntity) level.getBlockEntity(this.consolePosition);
            assert console != null;
            console.setDoorControl();
        }
        this.level.playSound(null, this.blockPosition(), SoundEvents.LEVER_CLICK, SoundSource.MASTER, 1f, 5f);
    }
}
