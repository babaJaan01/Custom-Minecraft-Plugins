package me.babajaan.harampigs.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class PigKillEvent implements Listener {

    @EventHandler
    public void onPigAttackEvent(EntityDamageByEntityEvent e) {

        Entity entity = e.getEntity();

        if (e.getDamager() instanceof Player) {
            Player player = (Player) e.getDamager();
            if ((entity.getType() == EntityType.PIG) || (entity.getType() == EntityType.PIGLIN) || (entity.getType() == EntityType.PIGLIN_BRUTE) || (entity.getType() == EntityType.ZOMBIFIED_PIGLIN)) {
                player.sendMessage(ChatColor.DARK_RED + "HARAM!");
            }
        }
    }

    @EventHandler
    public void onPigEatEvent(PlayerItemConsumeEvent e) throws InterruptedException {
        Player player = e.getPlayer();
        ItemStack consumedItem = e.getItem();


        if (consumedItem.getType() == Material.COOKED_PORKCHOP || consumedItem.getType() == Material.PORKCHOP) {
            sendBigTextTitle(player, ChatColor.DARK_RED + "HARAM ALERT", ChatColor.YELLOW + "Yad21", 10, 50, 10);
            launchPlayer(player);
            // removeBoots(player);
            player.setHealth(3);

        }
    }

    private void sendBigTextTitle(Player player, String title, String subtitle, int fadeIn, int stay, int fadeOut) throws InterruptedException {
        player.sendTitle("", "", fadeIn, stay, fadeOut); // Clear existing title

        // Big text in middle of screen
        for (int i = 0; i < 5; i++) {
            player.sendTitle(title, "", fadeIn, stay, fadeOut);
            player.playSound(player.getLocation(), Sound.ENTITY_PIG_DEATH, 3.0f, 1.0f);
            player.playSound(player.getLocation(), Sound.ENTITY_PIG_AMBIENT, 5.0f, 1.0f);
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_DEATH, 2.0f, 1.0f);
            player.playSound(player.getLocation(), Sound.ENTITY_COW_AMBIENT, 3.0f, 1.0f);
            Thread.sleep(500);
        }
        player.sendMessage(subtitle); // this the chat message
    }

    private void launchPlayer(Player player)  {
        Vector velocity = player.getLocation().getDirection().multiply(10).setY(2);
        player.setVelocity(velocity);
    }

//    private void removeBoots(Player player) {
//        ItemStack boots = player.getInventory().getBoots();
//        if (boots != null) {
//            player.getInventory().setBoots(null);
//            player.getWorld().dropItem(player.getLocation(), boots);
//        }
//    }

}
