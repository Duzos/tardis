package com.duzo.tardis.common.commands;

import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.tardis.TARDIS;
import com.duzo.tardis.tardis.manager.TARDISManager;
import com.duzo.tardis.tardis.util.TARDISUtil;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;

public class InteriorDeletionCommand implements Command<CommandSourceStack> {

    private static final InteriorDeletionCommand CMD = new InteriorDeletionCommand();

    public static ArgumentBuilder<CommandSourceStack, ?> register(CommandDispatcher<CommandSourceStack> dispatcher) {
        return Commands.literal("interior_delete")
                .requires(cs -> cs.hasPermission(0))
                .executes(CMD);
    }

    @Override
    public int run(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerLevel level = context.getSource().getLevel();
        ServerPlayer player = context.getSource().getPlayer();
        BlockPos pos = player.getOnPos();

        if (level != TARDISUtil.getTARDISLevel()) {
            context.getSource().sendFailure(Component.literal("You are not in the TARDIS Dimension!"));
            return 0;
        }

        TARDIS tardis = TARDISManager.getInstance().findTARDISFromInteriorCoordinate(new AbsoluteBlockPos(level,pos));

        if (tardis == null) {
            context.getSource().sendFailure(Component.literal("TARDIS was null!"));
            return 0;
        }

        tardis.getInterior().delete();

        context.getSource().sendSuccess(Component.literal("Interior for " + tardis.getUuid().toString() + " deleted"),false);
        return 0;
    }
}
