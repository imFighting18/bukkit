package com.imfighting.tutorial;

import org.bukkit.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class Main extends JavaPlugin implements Listener {

    private Database db;
    private PlayerManager playerManager;


    @Override
    public void onEnable() {
        db = new Database();
        try {
            db.connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        playerManager = new PlayerManager();

        Bukkit.getPluginManager().registerEvents(this, this);
        Bukkit.getPluginManager().registerEvents(new ConnectionListener(this), this);
    }

    @Override
    public void onDisable() {
        db.disconnect();
    }

    public Database getDatabase() {
        return db;
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }

    @EventHandler
    public void onRain(WeatherChangeEvent e) {
        e.setCancelled(true);
    }
}
