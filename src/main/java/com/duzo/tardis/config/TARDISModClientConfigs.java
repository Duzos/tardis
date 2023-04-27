package com.duzo.tardis.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class TARDISModClientConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    static {
        BUILDER.push("Configs for TARDIS Mod");

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
