package com.duzo.tardis.tardis;

import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.tardis.io.TARDISTravel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

import java.util.UUID;

public class TARDIS {
    private AbsoluteBlockPos pos;
    private TARDISTravel travel;
    private UUID uuid;

    public TARDIS(AbsoluteBlockPos pos, TARDISTravel travel) {
        this.pos = pos;
        this.travel = travel;
        this.uuid = java.util.UUID.randomUUID();
    }
    public TARDIS(AbsoluteBlockPos pos) {
        this(pos, new TARDISTravel(null));
        this.travel.setTARDIS(this);
    }

    public TARDISTravel getTravel() {
        return this.travel;
    }
    public Level getLevel() {
        return this.pos.getDimension();
    }

    public void setPosition(AbsoluteBlockPos pos) {
        this.pos = pos;
    }
    public BlockPos getPosition() {
        return this.pos;
    }
    public UUID getUuid() {
        return this.uuid;
    }
}
