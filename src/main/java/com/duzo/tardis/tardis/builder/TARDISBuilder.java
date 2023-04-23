package com.duzo.tardis.tardis.builder;

import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.tardis.TARDIS;

import java.util.UUID;

public class TARDISBuilder {
    private final UUID uuid;
    private AbsoluteBlockPos position;

    public TARDISBuilder(UUID uuid) {
        this.uuid = uuid;
    }

    public TARDISBuilder at(AbsoluteBlockPos position) {
        this.position = position;

        return this;
    }

    public TARDIS build() {
        if (this.position == null) {throw new IllegalArgumentException("TARDIS Position is null!");}

        TARDIS tardis = new TARDIS(this.uuid,this.position);
        tardis.getTravel().setDestination(this.position,true);
        tardis.getTravel().materialise();

        return tardis;
    }
}
