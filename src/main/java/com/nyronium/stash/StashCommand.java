package com.nyronium.stash;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import org.jetbrains.annotations.NotNull;

public class StashCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("stash")
                .executes(context -> {
                    ServerPlayer player = context.getSource().getPlayerOrException();

                    Component title = Component.literal("Public Stash");

                    player.openMenu(new MenuProvider() {
                        @Override
                        public @NotNull Component getDisplayName() {
                            return title;
                        }

                        @Override
                        public AbstractContainerMenu createMenu(int id, @NotNull Inventory playerInventory, @NotNull Player player) {
                            return ChestMenu.sixRows(id, playerInventory, Stash.container);
                        }
                    });

                    return Command.SINGLE_SUCCESS;
                }));
    }
}
