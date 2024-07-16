package me.babajaan.lightiningarrows2.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import java.util.Random;

public class LightningCommands implements CommandExecutor, Listener {

    private int lightningChance = 1; // Default chance: 1 in 1 (always)

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        if (strings.length < 1) {
            sender.sendMessage(ChatColor.LIGHT_PURPLE + "Usage: " + ChatColor.GREEN + "/arrow <chance of lightning>");
            return true;
        }

        try {
            int newChance = Integer.parseInt(strings[0]);
            if (newChance <= 0) {
                sender.sendMessage(ChatColor.RED + "The lightning chance must be a positive number.");
                return true;
            }
            lightningChance = newChance;
            sender.sendMessage(ChatColor.BOLD.BLUE + "Lightning chance set to 1 of " + lightningChance + ".");
        } catch (NumberFormatException e) {
            sender.sendMessage(ChatColor.RED + "Invalid lightning chance specified.");
        }

        return true;
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {
        if (event.getEntity() instanceof Arrow) {
            Arrow arrow = (Arrow) event.getEntity();
            Player shooter = (Player) arrow.getShooter();

            Random random = new Random();
            if (random.nextInt(lightningChance) == 0) {
                arrow.getWorld().strikeLightning(arrow.getLocation());
            }
        }
    }
}
