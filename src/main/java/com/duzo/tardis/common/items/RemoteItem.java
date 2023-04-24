package com.duzo.tardis.common.items;

import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.tardis.TARDIS;
import com.duzo.tardis.tardis.blocks.entities.ExteriorBlockEntity;
import com.duzo.tardis.tardis.links.LinkableItem;
import com.duzo.tardis.tardis.io.TARDISTravel;
import com.duzo.tardis.tardis.manager.TARDISManager;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.duzo.tardis.tardis.io.TARDISTravel.searchForNearestAirBlock;

public class RemoteItem extends LinkableItem {
    public RemoteItem(Properties properties) {
        super(properties);
    }
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);

        if (this.getTARDIS(pStack) != null) {
            pTooltip.add(Component.translatable("Linked TARDIS: " + this.getTARDIS(pStack).getUuid()).withStyle(ChatFormatting.GREEN));
        } else {
            pTooltip.add(Component.translatable("No linked TARDIS").withStyle(ChatFormatting.RED));
        }
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        BlockPos pos = context.getClickedPos();
        Level level = context.getLevel();
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();

        if (player.isCrouching() && !level.isClientSide && level.getBlockEntity(pos) instanceof ExteriorBlockEntity) {
//            ExteriorBlockEntity entity = (ExteriorBlockEntity) level.getBlockEntity(pos);
            this.link(stack, TARDISManager.getInstance().findTARDIS(new AbsoluteBlockPos(level,pos)));
            return InteractionResult.SUCCESS;
        }
        if (!level.isClientSide && this.getTARDIS(stack) != null) {
            Direction direction = player.getDirection().getOpposite();

            this.getTARDIS(stack).to(new AbsoluteBlockPos(level,direction, pos),true);

            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }
}
