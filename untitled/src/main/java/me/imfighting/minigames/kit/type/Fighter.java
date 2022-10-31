package me.imfighting.minigames.kit.type;

import me.imfighting.minigames.Minigames;
import me.imfighting.minigames.kit.Kit;
import me.imfighting.minigames.kit.KitType;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.UUID;

public class Fighter extends Kit {
    public Fighter(UUID uuid, Minigames minigames) {
        super(KitType.FIGHTER, uuid, minigames);
    }

    @Override
    public void onStart(Player player) {
        player.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 3));
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        System.out.println("Um Fighter quebrou um bloco!");
    }

}
