package com.duzo.tardis.common.items;

import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.tardis.TARDIS;
import com.duzo.tardis.tardis.blocks.entities.ExteriorBlockEntity;
import com.duzo.tardis.tardis.links.LinkableItem;
import com.duzo.tardis.tardis.io.TARDISTravel;
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

public class RemoteItem extends Item {
    private TARDIS tardis;
    public RemoteItem(Properties properties) {
        super(properties);
    }

    private void link(TARDIS tardis) {
        this.tardis = tardis;
    }

    protected TARDIS getTARDIS() {
        return this.tardis;
    }

//    @Override
//    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
//        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
//
//        if (this.getTARDIS() != null) {
//            pTooltip.add(Component.translatable("Linked TARDIS: " + this.getTARDIS().getUuid()).withStyle(ChatFormatting.GREEN));
//        } else {
//            pTooltip.add(Component.translatable("No linked TARDIS").withStyle(ChatFormatting.RED));
//        }
//    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        BlockPos pos = context.getClickedPos();
        Level level = context.getLevel();
        Player player = context.getPlayer();

        if (player.isCrouching() && !level.isClientSide && level.getBlockEntity(pos) instanceof ExteriorBlockEntity) {
            ExteriorBlockEntity entity = (ExteriorBlockEntity) level.getBlockEntity(pos);
            this.link(entity.getTARDIS());
            return InteractionResult.SUCCESS;
        }
        if (!level.isClientSide && this.getTARDIS() != null) {
            TARDISTravel travel = this.getTARDIS().getTravel();

            Direction direction = player.getDirection().getOpposite();

            travel.setDestination(new AbsoluteBlockPos(level,direction, searchForNearestAirBlock(level,pos, Direction.UP)));
            travel.dematerialise(true);

            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }
}
