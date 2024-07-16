package me.babajaan.harampigs;

import me.babajaan.harampigs.listeners.PigKillEvent;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class HaramPigs extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Plugin Enabled. Hello");
        getServer().getPluginManager().registerEvents(new PigKillEvent(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Plugin Disabled. Goodbye");
    }
}
