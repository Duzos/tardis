package com.duzo.tardis.tardis.animation;

import com.duzo.tardis.network.Network;
import com.duzo.tardis.network.packets.UpdateExteriorAnimationS2CPacket;
import com.duzo.tardis.tardis.consoles.blocks.entities.ConsoleBlockEntity;
import com.duzo.tardis.tardis.io.TARDISTravel;
import net.minecraft.util.Mth;

public abstract class ConsoleAnimation {
    protected ConsoleBlockEntity console;
    protected float ticking;
    protected int timeLeft;
    protected float rotorChangeAmount = 1f;

    public ConsoleAnimation(ConsoleBlockEntity console) {
        this.console = console;
    }

    public float getTick() {
        return this.ticking;
    }

    public abstract void tick();
    public abstract void setupAnimation(TARDISTravel.STATE state);

    public void setTicking(float ticking) {
        this.ticking = ticking;
//        System.out.println("set alpha to " + alpha);
    }

    public void setTickingChangeAmount(float amount) {
        this.rotorChangeAmount = amount;
    }

    public void updateClient() {
        if (this.console.getLevel().isClientSide) {return;}

        Network.sendToAll(new UpdateExteriorAnimationS2CPacket(console.getBlockPos(),this.getTick()));
    }
}
