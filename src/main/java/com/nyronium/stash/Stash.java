package com.nyronium.stash;

import net.minecraft.world.SimpleContainer;
import net.minecraftforge.fml.common.Mod;

@Mod(Stash.ID)
public class Stash {
    public static SimpleContainer container = new SimpleContainer(54);
    public static final String ID = "stash";

    public Stash() {
        System.out.println("Running Stash v1.0");
    }
}
