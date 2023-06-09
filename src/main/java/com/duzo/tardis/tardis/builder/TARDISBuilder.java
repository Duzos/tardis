package com.duzo.tardis.tardis.builder;

import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.tardis.TARDIS;
import com.duzo.tardis.tardis.exteriors.TARDISExteriorSchema;
import com.duzo.tardis.tardis.exteriors.TARDISExteriors;
import com.duzo.tardis.tardis.interiors.TARDISInterior;
import com.duzo.tardis.tardis.interiors.TARDISInteriorSchema;
import com.duzo.tardis.tardis.interiors.TARDISInteriors;
import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

import java.util.UUID;

public class TARDISBuilder {
    private final UUID uuid;
    private AbsoluteBlockPos position;
    private TARDISExteriorSchema<?> exteriorSchema;
    private TARDISInteriorSchema interior;
    public static final String DEFAULT_EXTERIOR = "";
    public static final String DEFAULT_INTERIOR = "";

    public TARDISBuilder(UUID uuid) {
        this.uuid = uuid;
    }

    public TARDISBuilder at(AbsoluteBlockPos position) {
        this.position = position;

        return this;
    }
    public TARDISBuilder exterior(TARDISExteriorSchema<?> exterior) {
        this.exteriorSchema = exterior;
        return this;
    }

    public TARDISBuilder interior(TARDISInteriorSchema interior) {
        this.interior = interior;
        return this;
    }

    public TARDIS build() {
        return this.build(true);
    }
    public TARDIS build(boolean withMaterialise) {
        if (this.position == null) {throw new IllegalArgumentException("TARDIS Position is null!");}
        if (this.exteriorSchema == null) {this.exteriorSchema = TARDISExteriors.get(DEFAULT_EXTERIOR);}
        if (this.interior == null) {this.interior = TARDISInteriors.get(DEFAULT_INTERIOR);}

        TARDIS tardis = new TARDIS(this.uuid,this.position, this.exteriorSchema, new TARDISInterior(this.interior));

        if (withMaterialise) {
            tardis.getTravel().setDestination(this.position, true);
            tardis.getTravel().materialise();
            tardis.getTravel().startHopping();
        }
        tardis.getInterior().generate();

        Logger logger = LogUtils.getLogger();

        logger.info("Created a new TARDIS:");
        logger.info("UUID: " + tardis.getUuid());
        logger.info("Exterior: " + tardis.getExteriorSchema().getID());
        logger.info("Interior: " + tardis.getInterior().getSchema().getID());
        logger.info("Position: " + tardis.getPosition());

        return tardis;
    }
}
