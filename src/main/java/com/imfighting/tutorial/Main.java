package com.imfighting.tutorial;

import com.imfighting.commands.ConfigCommand;
import com.imfighting.commands.HealthCommand;
import com.imfighting.commands.TestCommand;
import com.imfighting.commands.TesteCommand;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        /*getConfig().options().copyDefaults();
        saveDefaultConfig();
        ArmorStand armorStand = (ArmorStand) Bukkit.getWorld("world").spawnEntity(new Location(Bukkit.getWorld("world"), -42, 68, 40), EntityType.ARMOR_STAND);
        Bukkit.getWorld("world").getBlockAt(1, 1, 1).setType(Material.LAVA);*/
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {

    }
}
