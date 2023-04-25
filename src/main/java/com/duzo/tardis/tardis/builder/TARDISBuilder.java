package com.duzo.tardis.tardis.builder;

import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.tardis.TARDIS;
import com.duzo.tardis.tardis.exteriors.TARDISExteriorModelSchema;
import com.duzo.tardis.tardis.exteriors.TARDISExteriorSchema;
import com.duzo.tardis.tardis.exteriors.TARDISExteriors;

import java.util.UUID;

public class TARDISBuilder {
    private final UUID uuid;
    private AbsoluteBlockPos position;
    private TARDISExteriorSchema exteriorSchema;
    public static final String DEFAULT_EXTERIOR = "classic";

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

    public TARDIS build() {
        if (this.position == null) {throw new IllegalArgumentException("TARDIS Position is null!");}
        if (this.exteriorSchema == null) {this.exteriorSchema = TARDISExteriors.get(DEFAULT_EXTERIOR);}
        System.out.println(this.exteriorSchema);
        System.out.println(TARDISExteriors.get(DEFAULT_EXTERIOR));
        System.out.println(this.exteriorSchema == null);

        TARDIS tardis = new TARDIS(this.uuid,this.position, this.exteriorSchema);
        tardis.getTravel().setDestination(this.position,true);
        tardis.getTravel().materialise();

        return tardis;
    }
}
