package com.duzo.tardis.tardis.item;

import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.tardis.exteriors.TARDISExteriorSchema;
import com.duzo.tardis.tardis.interiors.TARDISInteriorSchema;
import com.duzo.tardis.tardis.manager.TARDISManager;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public abstract class TARDISSpawnItem extends Item {
    public TARDISSpawnItem(Properties properties) {
        super(properties);
    }

    protected TARDISExteriorSchema<?> getExterior() {
        return null;
    }
    protected TARDISInteriorSchema getInterior() {
        return null;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        BlockPos pos = context.getClickedPos();
        Level level = context.getLevel();
        AbsoluteBlockPos absolutePos = new AbsoluteBlockPos(level,pos);
        Player player = context.getPlayer();
        InteractionHand hand = context.getHand();

        if (!level.isClientSide && hand == InteractionHand.MAIN_HAND) {
            TARDISManager.getInstance().create(absolutePos,this.getExterior(), this.getInterior());
            context.getItemInHand().shrink(1);
        }
        return InteractionResult.SUCCESS;
    }
}
