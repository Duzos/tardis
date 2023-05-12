package com.duzo.tardis.tardis.animation.impl;

import com.duzo.tardis.network.Network;
import com.duzo.tardis.network.packets.UpdateExteriorAnimationS2CPacket;
import com.duzo.tardis.tardis.animation.ExteriorAnimation;
import com.duzo.tardis.tardis.exteriors.blocks.entities.ExteriorBlockEntity;
import com.duzo.tardis.tardis.io.TARDISTravel;

public class ClassicAnimation extends ExteriorAnimation {
    private boolean firstRun;

    public ClassicAnimation(ExteriorBlockEntity exterior) {
        super(exterior);
    }

    @Override
    public void tick() {
        if (exterior.getTARDIS() == null) return;

        TARDISTravel.STATE state = exterior.getTARDIS().getTravel().getState();

        if (state == TARDISTravel.STATE.DEMAT)   {
            this.updateClient();
            alpha = alpha - alphaChangeAmount;
            timeLeft--;
        } else if (state == TARDISTravel.STATE.HOP_TAKEOFF) {
            this.updateClient();
            alpha = alpha - (alphaChangeAmount);
            timeLeft--;
        } else if (state == TARDISTravel.STATE.FAIL_TAKEOFF) {
            this.updateClient();
            if (alpha >= 0.5f && firstRun) {
                alpha = alpha - (alphaChangeAmount );
            } else {
                alpha = alpha + (alphaChangeAmount * 2);
                firstRun = false;
            }

            if (alpha >= 1f) {
                exterior.getTARDIS().getTravel().setState(TARDISTravel.STATE.LANDED);
                firstRun = true;
            }

            timeLeft--;
        } else if (state == TARDISTravel.STATE.MAT) {
            this.updateClient();
            alpha = alpha + alphaChangeAmount;
            timeLeft--;
            if (alpha >= 1f) {
                exterior.getTARDIS().getTravel().setState(TARDISTravel.STATE.LANDED);
            }
        }else if (state == TARDISTravel.STATE.HOP_MAT) {
            this.updateClient();
            alpha = alpha + (alphaChangeAmount * 2);
            timeLeft--;
            if (alpha >= 1f) {
                exterior.getTARDIS().getTravel().setState(TARDISTravel.STATE.LANDED);
            }
        } else if (state == TARDISTravel.STATE.LANDED) {
            this.updateClient();
            alpha = 1F;
        }
    }

    @Override
    public void setupAnimation(TARDISTravel.STATE state) {
        if (state == TARDISTravel.STATE.DEMAT) {
            alpha = 1f;
            timeLeft = 150;
        } else if (state == TARDISTravel.STATE.MAT){
            alpha = 0f;
            timeLeft = 200;
        } else {
            alpha = 1f;
            timeLeft = 0;
        }

        firstRun = true;

        this.updateClient();
    }

    public void setFirstRun(boolean firstRun) {
        this.firstRun = firstRun;
    }

    @Override
    public void updateClient() {
        if (this.exterior.getLevel().isClientSide) {return;}

        Network.sendToAll(new UpdateExteriorAnimationS2CPacket(exterior.getBlockPos(),this.getAlpha(),this.firstRun));
    }
}
