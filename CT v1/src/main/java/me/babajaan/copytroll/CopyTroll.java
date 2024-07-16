package me.babajaan.copytroll;

import me.babajaan.copytroll.commands.CopyCommand;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class CopyTroll extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println(ChatColor.GREEN + "CopyMessages Plugin Enabled. ");
        getCommand("copy").setExecutor(new CopyCommand());
        getServer().getPluginManager().registerEvents(new CopyListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println(ChatColor.RED + "CopyMessages Plugin Disabled. ");
    }
}
