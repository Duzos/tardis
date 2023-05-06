package com.duzo.tardis.tardis.controls.blocks.basics;

import com.duzo.tardis.core.init.SoundsInit;
import com.duzo.tardis.network.Network;
import com.duzo.tardis.network.packets.UpdateExteriorDoorS2CPacket;
import com.duzo.tardis.network.packets.UpdateLeverPulledS2CPacket;
import com.duzo.tardis.tardis.controls.blocks.ControlBlockEntity;
import com.duzo.tardis.tardis.io.TARDISTravel;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public abstract class DematControlBlockEntity extends ControlBlockEntity {
    private boolean isPulled = false;
    public DematControlBlockEntity(BlockEntityType<?> p_155228_, BlockPos p_155229_, BlockState p_155230_) {
        super(p_155228_, p_155229_, p_155230_);
    }

    public boolean pulled() {
        return this.isPulled;
    }

    public void setPulled(boolean bool, boolean updateClient) {
        this.isPulled = bool;

        if (updateClient) {
            Network.sendToAll(new UpdateLeverPulledS2CPacket(this.getBlockPos(),bool));
        }
    }

    public void setPulled(boolean bool) {
        this.setPulled(bool,false);
    }

    @Override
    protected SoundEvent getSound() {
        return SoundsInit.DEMAT_LEVER_PULL.get();
    }

    @Override
    protected void run(Player player, BlockHitResult hit) {
        this.playSound();
        this.setPulled(!this.pulled(),true);

        TARDISTravel travel = this.getTARDIS().getTravel();
        if (travel.isMaterialising() || travel.isDematerialising()) {return;}

        if (travel.inFlight()) {
            travel.materialise();
        } else {
            travel.dematerialise();
        }
    }
}
