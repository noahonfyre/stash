package com.nyronium.stash;

import net.minecraft.world.SimpleContainer;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Stash.ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EventHandler {
    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        StashCommand.register(event.getDispatcher());
    }


    @SubscribeEvent
    public void onServerStart(ServerStartedEvent event) {
        event.getServer().getScoreboard().getPlayerTeams().forEach(team -> {
            Stash.teamStashMap.put(team, new SimpleContainer(54));
        });
    }
}
