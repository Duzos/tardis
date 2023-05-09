package com.duzo.tardis.tardis.animation.impl;

import com.duzo.tardis.network.Network;
import com.duzo.tardis.network.packets.UpdateConsoleAnimationS2CPacket;
import com.duzo.tardis.network.packets.UpdateExteriorAnimationS2CPacket;
import com.duzo.tardis.tardis.animation.ConsoleAnimation;
import com.duzo.tardis.tardis.animation.ExteriorAnimation;
import com.duzo.tardis.tardis.consoles.blocks.entities.ConsoleBlockEntity;
import com.duzo.tardis.tardis.io.TARDISTravel;

public class BorealisAnimation extends ConsoleAnimation {
    private boolean firstRun;

    public BorealisAnimation(ConsoleBlockEntity console) {
        super(console);
    }

    @Override
    public void tick() {
        if (console.getTARDIS() == null) return;
        TARDISTravel.STATE state = console.getTARDIS().getTravel().getState();

        if (state == TARDISTravel.STATE.FLIGHT || state == TARDISTravel.STATE.DEMAT || state == TARDISTravel.STATE.HOP_TAKEOFF || state == TARDISTravel.STATE.FAIL_TAKEOFF) {
            //if (!(timeLeft <= 0)) {
            this.updateClient();
            ticking = ticking + rotorChangeAmount;
                //timeLeft = timeLeft - TARDISTravel.;
            //}
        }
    }

    @Override
    public void setupAnimation(TARDISTravel.STATE state) {
        ticking = 0f;
        firstRun = true;
        timeLeft = 500;
        this.updateClient();
    }

    public void setFirstRun(boolean firstRun) {
        this.firstRun = firstRun;
    }

    @Override
    public void updateClient() {
        if (this.console.getLevel().isClientSide) {return;}

        Network.sendToAll(new UpdateConsoleAnimationS2CPacket(console.getBlockPos(),this.getTick(),this.firstRun));
    }
}
