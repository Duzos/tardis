package com.duzo.tardis.tardis.util;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.core.world.dimension.DimensionsInit;
import net.minecraft.server.level.ServerLevel;
import net.minecraftforge.server.ServerLifecycleHooks;

public class TARDISUtil {
    public static ServerLevel getTARDISLevel() {
        return ServerLifecycleHooks.getCurrentServer().getLevel(DimensionsInit.TARDIS_DIM_KEY);
    }
}
