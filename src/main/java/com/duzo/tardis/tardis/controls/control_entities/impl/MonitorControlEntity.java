package com.duzo.tardis.tardis.controls.control_entities.impl;

import com.duzo.tardis.core.events.ClientEvents;
import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.tardis.TARDIS;
import com.duzo.tardis.tardis.consoles.blocks.entities.ConsoleBlockEntity;
import com.duzo.tardis.tardis.controls.control_entities.ControlEntitySchema;
import com.duzo.tardis.tardis.manager.TARDISManager;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.UUID;

public class MonitorControlEntity extends ControlEntitySchema {
    public MonitorControlEntity(EntityType<? extends AmbientCreature> p_i50290_1_, Level p_i50290_2_) {
        super(p_i50290_1_, p_i50290_2_);
    }

    public MonitorControlEntity(EntityType<? extends AmbientCreature> entity, Level level, UUID tardisID, String name, BlockPos consoleBlockPos) {
        super(entity, level, tardisID, name, consoleBlockPos);
    }

    public void openMonitorScreen(UUID tardisID, Player source) {
        Minecraft.getInstance().setScreen(ClientEvents.createMonitorScreen(Component.translatable("screen.ait.borealis_monitor"), tardisID, source));
    }

    @Override
    public void runInteractions(Player pSource) {
        super.runInteractions(pSource);
        if (pSource.level.isClientSide) {
            this.openMonitorScreen(this.tardisID, pSource);
        }
        if (pSource.level.isClientSide) return;

        if(!this.getControlName().equals("Monitor")) return;
        if(this.consolePosition != null && !level.isClientSide()) {
            ConsoleBlockEntity console = (ConsoleBlockEntity) level.getBlockEntity(this.consolePosition);
            assert console != null;
        }
        this.level.playSound(null, this.blockPosition(), SoundEvents.LEVER_CLICK, SoundSource.MASTER, 1f, 5f);
    }
}
