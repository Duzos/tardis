package com.duzo.tardis.common.items;

import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.tardis.blocks.entities.TARDISBlockEntity;
import com.duzo.tardis.tardis.links.LinkableItem;
import com.duzo.tardis.tardis.io.TARDISTravel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import static com.duzo.tardis.tardis.io.TARDISTravel.searchForNearestAirBlock;

public class RemoteItem extends LinkableItem {
    public RemoteItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        BlockPos pos = context.getClickedPos();
        Level level = context.getLevel();
        Player player = context.getPlayer();

        if (player.isCrouching() && !level.isClientSide && level.getBlockEntity(pos) instanceof TARDISBlockEntity) {
            TARDISBlockEntity entity = (TARDISBlockEntity) level.getBlockEntity(pos);
            this.link(entity.getTARDIS());
            return InteractionResult.SUCCESS;
        }
        if (!level.isClientSide && this.getTARDIS() != null) {
            TARDISTravel travel = this.getTARDIS().getTravel();

            travel.setDestination(new AbsoluteBlockPos(level,player.getDirection().getOpposite(), searchForNearestAirBlock(level,pos, Direction.UP)));
            travel.dematerialise(true);

            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }
}
