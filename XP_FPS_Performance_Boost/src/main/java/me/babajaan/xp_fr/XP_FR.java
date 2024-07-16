package me.babajaan.xp_fr;

import me.babajaan.xp_fr.listeners.XPBottleBreakListener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.block.Block;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExpBottleEvent;

public final class XP_FR extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("XP Plugin Enabled. Hello");
        getServer().getPluginManager().registerEvents(new XPBottleBreakListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("XP Plugin Disabled. Goodbye");
    }
}
