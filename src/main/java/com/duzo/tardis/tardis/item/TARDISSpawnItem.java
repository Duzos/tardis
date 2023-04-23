package com.duzo.tardis.tardis.item;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.tardis.TARDISManager;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.checkerframework.checker.units.qual.A;

public class TARDISSpawnItem extends Item {
    public TARDISSpawnItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        BlockPos pos = context.getClickedPos();
        Level level = context.getLevel();
        AbsoluteBlockPos absolutePos = new AbsoluteBlockPos(level,pos);
        Player player = context.getPlayer();
        InteractionHand hand = context.getHand();

        if (!level.isClientSide && hand == InteractionHand.MAIN_HAND) {
            TARDISManager.getInstance().create(absolutePos);
            context.getItemInHand().shrink(1);
        }
        return InteractionResult.SUCCESS;
    }
}
