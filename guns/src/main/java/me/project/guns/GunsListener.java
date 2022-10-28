package me.project.guns;

import org.bukkit.Material;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.util.Vector;

public class GunsListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        if (e.getHand().equals(EquipmentSlot.HAND)) {
            if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_AIR))
            if (e.getPlayer().getInventory().getItemInHand().getType().equals(Material.IRON_HOE)) {
                p.launchProjectile(Egg.class);
                p.sendMessage("§aVocê atirou um ovo!");
            } else if (e.getPlayer().getInventory().getItemInHand().getType().equals(Material.DIAMOND_HOE)) {
                p.launchProjectile(Snowball.class);
                p.sendMessage("§aVocê atirou uma bola de neve!");
            }
        }
    }
}
