package com.duzo.tardis.tardis;

import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.tardis.builder.TARDISBuilder;

import java.util.UUID;

public class TARDISManager {
    private static final TARDISManager instance = new TARDISManager();

    public static TARDISManager getInstance() {
        return instance;
    }

    /**
     * Creates a TARDIS
     * @param pos position and dimension where the TARDIS will be created
     * @return the new TARDIS
     */
    public TARDIS create(AbsoluteBlockPos pos) {
        TARDIS tardis = new TARDISBuilder(UUID.randomUUID()).at(pos).build();

        return tardis;
    }
}
