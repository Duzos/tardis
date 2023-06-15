package com.duzo.tardis.core.init;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.common.commands.InteriorDeletionCommand;
import com.duzo.tardis.common.commands.TestCommand;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

public class CommandsInit {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        LiteralCommandNode<CommandSourceStack> cmdTut = dispatcher.register(
                Commands.literal(TARDISMod.MODID)
//                        .then(TestCommand.register(dispatcher))
                        .then(InteriorDeletionCommand.register(dispatcher))
        );

        dispatcher.register(Commands.literal("tardis").redirect(cmdTut));
    }
}
