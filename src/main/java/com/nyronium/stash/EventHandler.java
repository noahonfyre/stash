package com.nyronium.stash;

import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Stash.ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EventHandler {
    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        StashCommand.register(event.getDispatcher());
    }
}
