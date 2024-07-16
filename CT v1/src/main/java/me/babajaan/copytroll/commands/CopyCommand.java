package me.babajaan.copytroll.commands;

import me.babajaan.copytroll.CopyListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;


public class CopyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player && sender.isOp()) {
            Player player = (Player) sender;

            if (args.length < 2) {
                player.sendMessage(ChatColor.DARK_RED + "Usage: /copy <playerName> <playerCopied>");
            } else {
                String playerName = args[0];
                String playerCopied = args[1];
                Player target = Bukkit.getServer().getPlayerExact(playerName);
                Player targetCopied = Bukkit.getServer().getPlayerExact(playerCopied);

                if (target == null || targetCopied == null) {
                    player.sendMessage(ChatColor.DARK_RED + "Invalid player(s).");
                } else {
                    // Register CopyListener for the copying player and copied player
                    CopyListener.registerCopyPlayer(player, targetCopied);
                    player.sendMessage(ChatColor.GREEN + "Player " + target.getDisplayName() + " will now copy " + targetCopied.getDisplayName());
                }
            }
        } else {
            sender.sendMessage(ChatColor.DARK_RED + "You need to be an admin player to execute this command.");
        }

        return true;
    }
}
