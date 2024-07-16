package me.babajaan.lightiningarrows2;

import me.babajaan.lightiningarrows2.Commands.LightningCommands;
import org.bukkit.plugin.java.JavaPlugin;

public final class LightiningArrows2 extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Lightning Arrows 2.0 Enabled");
        getCommand("arrow").setExecutor(new LightningCommands());
        getServer().getPluginManager().registerEvents(new LightningCommands(), this);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Lightning Arrows 2.0 Enabled");
    }
}
