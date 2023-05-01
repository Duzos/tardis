package com.duzo.tardis.tardis.animation.impl;

import com.duzo.tardis.tardis.TARDIS;
import com.duzo.tardis.tardis.animation.ExteriorAnimation;
import com.duzo.tardis.tardis.exteriors.blocks.entities.ExteriorBlockEntity;
import com.duzo.tardis.tardis.io.TARDISTravel;

public class ClassicAnimation extends ExteriorAnimation {

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
        } else if (state == TARDISTravel.STATE.MAT) {
            this.updateClient();
            alpha = alpha + alphaChangeAmount;
            timeLeft--;
            if (alpha >= 1f) {
                exterior.getTARDIS().getTravel().setState(TARDISTravel.STATE.LANDED);
            }
        }else if (state == TARDISTravel.STATE.HOP_LAND) {
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

        this.updateClient();
    }
}
