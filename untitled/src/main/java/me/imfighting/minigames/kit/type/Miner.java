package me.imfighting.minigames.kit.type;

import me.imfighting.minigames.Minigames;
import me.imfighting.minigames.kit.Kit;
import me.imfighting.minigames.kit.KitType;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.UUID;

public class Miner extends Kit {
    public Miner(UUID uuid, Minigames minigames) {
        super(KitType.MINER, uuid, minigames);
    }

    @Override
    public void onStart(Player player) {
        player.getInventory().addItem(new ItemStack(Material.DIAMOND_PICKAXE));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 3));
    }
}
