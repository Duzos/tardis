package com.duzo.tardis.common.items;

import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.tardis.TARDIS;
import com.duzo.tardis.tardis.manager.TARDISManager;
import com.duzo.tardis.tardis.util.TARDISUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

// TEST ITEM TO TEST IF DELETION IS FUNCTIONING
// @TODO remove this :)
public class InteriorDeletionItem extends Item {
    public InteriorDeletionItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        BlockPos pos = context.getClickedPos();
        Level level = context.getLevel();

        if (level.isClientSide) return InteractionResult.FAIL;
        if (!level.equals(TARDISUtil.getTARDISLevel())) return InteractionResult.FAIL;

        TARDIS tardis = TARDISManager.getInstance().findTARDISFromInteriorCoordinate(new AbsoluteBlockPos(level,pos));
        tardis.getInterior().delete();
        return  InteractionResult.SUCCESS;
    }
}
