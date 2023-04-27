package com.duzo.tardis.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class TARDISModCommonConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> CAN_LAND_IN_TARDIS_DIM;

    static {
        BUILDER.push("Configs for TARDIS Mod");

        CAN_LAND_IN_TARDIS_DIM = BUILDER.comment("Defines if a TARDIS can land inside the TARDIS Dimension")
                .define("Can Land In TARDIS",false);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
