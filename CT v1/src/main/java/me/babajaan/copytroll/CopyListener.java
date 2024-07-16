package me.babajaan.copytroll;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CopyListener implements Listener {
    private static final Map<UUID, UUID> copyingPlayers = new HashMap<>();

    public static void registerCopyPlayer(Player copyingPlayer, Player copiedPlayer) {
        copyingPlayers.put(copyingPlayer.getUniqueId(), copiedPlayer.getUniqueId());
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        UUID playerUUID = player.getUniqueId();

        for (Map.Entry<UUID, UUID> entry : copyingPlayers.entrySet()) {
            UUID copyingPlayerUUID = entry.getKey();
            UUID copiedPlayerUUID = entry.getValue();

            if (copyingPlayerUUID.equals(playerUUID)) {
                Player copiedPlayer = Bukkit.getPlayer(copiedPlayerUUID);

                if (copiedPlayer != null) {
                    String message = event.getMessage();
                    String formattedMessage = "<" + player.getDisplayName() + "> " + message;
                    event.setCancelled(true);
                    copiedPlayer.chat(formattedMessage);
                }
            }
        }
    }
}







