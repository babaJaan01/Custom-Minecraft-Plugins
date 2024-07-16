package me.babajaan.xp_fr.listeners;

import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExpBottleEvent;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

import java.util.Collection;

public class XPBottleBreakListener implements Listener {

    @EventHandler
    public void onXPBottleBreak(ExpBottleEvent e) {
        e.setShowEffect(false);

    }
//    @EventHandler
//    public void onBottleBreak(ProjectileHitEvent event) {
//        if (event.getEntity() instanceof ThrownPotion) {
//            ThrownPotion potion = (ThrownPotion) event.getEntity();
//
//
//            if (event.getHitBlock() != null) {
//
//                event.setCancelled(true);
//
//
//            }
//        }
//    }
}
