package com.nyronium.stash;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.scores.Team;
import org.jetbrains.annotations.NotNull;

public class StashCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("stash")
                .executes(context -> {
                    ServerPlayer player = context.getSource().getPlayerOrException();

                    Component title;
                    Container container;

                    Team team = player.getTeam();
                    if(team == null) {
                        title = Component.literal("Public Stash");
                        container = Stash.publicStash;
                    } else {
                        title = Component.literal(team.getName() + "'s Stash");
                        container = Stash.teamStashMap.get(team);

                        if(container == null) container = Stash.publicStash;
                    }

                    Component finalTitle = title;
                    Container finalContainer = container;

                    player.openMenu(new MenuProvider() {
                        @Override
                        public @NotNull Component getDisplayName() {
                            return finalTitle;
                        }

                        @Override
                        public AbstractContainerMenu createMenu(int id, @NotNull Inventory playerInventory, @NotNull Player player) {
                            return ChestMenu.sixRows(id, playerInventory, finalContainer);
                        }
                    });

                    return Command.SINGLE_SUCCESS;
                }));
    }
}
