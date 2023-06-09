package com.duzo.tardis.tardis.animation;

import com.duzo.tardis.network.Network;
import com.duzo.tardis.network.packets.UpdateExteriorAnimationS2CPacket;
import com.duzo.tardis.tardis.exteriors.blocks.entities.ExteriorBlockEntity;
import com.duzo.tardis.tardis.io.TARDISTravel;
import net.minecraft.util.Mth;

public abstract class ExteriorAnimation {
    protected float alpha;
    protected ExteriorBlockEntity exterior;
    protected int timeLeft;
    protected float alphaChangeAmount = 0.005f;

    public ExteriorAnimation(ExteriorBlockEntity exterior) {
        this.exterior = exterior;
    }

    public float getAlpha() {
        return Mth.clamp(this.alpha,0.0F,1.0F);
    }


    public abstract void tick();
    public abstract void setupAnimation(TARDISTravel.STATE state);

    public void setAlpha(float alpha) {
        this.alpha = Mth.clamp(alpha,0.0F,1.0F);
//        System.out.println("set alpha to " + alpha);
    }

    public void setAlphaChangeAmount(float amount) {
        this.alphaChangeAmount = amount;
    }

    public void updateClient() {
        if (this.exterior.getLevel().isClientSide) {return;}

        Network.sendToAll(new UpdateExteriorAnimationS2CPacket(exterior.getBlockPos(),this.getAlpha()));
    }
}
