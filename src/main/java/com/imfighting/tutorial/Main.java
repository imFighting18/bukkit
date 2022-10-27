package com.imfighting.tutorial;

import com.imfighting.commands.HealthCommand;
import com.imfighting.commands.TesteCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        getCommand("test").setExecutor(new TesteCommand());
    }

   /* @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        e.setCancelled(true);
        e.getPlayer().sendMessage(ChatColor.BLUE + "Stop moving, you're frozen!");
    }

    @EventHandler
    public void onPlayerEggThrow(PlayerEggThrowEvent e) {
        e.getPlayer().sendMessage("You are throwing egg!");
    }*/
}
