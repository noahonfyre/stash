package com.nyronium.stash;

import net.minecraft.world.SimpleContainer;
import net.minecraft.world.scores.Team;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;

@Mod(Stash.ID)
public class Stash {
    public static SimpleContainer publicStash = new SimpleContainer(54);
    public static final String ID = "stash";
    public static HashMap<Team, SimpleContainer> teamStashMap = new HashMap<>();

    public Stash() {
        System.out.println("Running Stash v1.0");
    }
}
