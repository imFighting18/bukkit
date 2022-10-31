package me.imfighting.minigames.managaers;

import me.imfighting.minigames.Minigames;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {

    private static FileConfiguration config;

    public static void setupConfig(Minigames minigames) {
        ConfigManager.config = minigames.getConfig();
        minigames.saveDefaultConfig();
    }

    public static int getRequeriedPlayers() {
        return config.getInt("required-players");
    }

    public static int getCountdownSeconds() {
        return config.getInt("countdown-seconds");
    }

    public static Location getLobbySpawn() {
        return new Location(
                Bukkit.getWorld(config.getString("lobby-spawn.world")),
                config.getDouble("lobby-spawn.x"),
                config.getDouble("lobby-spawn.y"),
                config.getDouble("lobby-spawn.z"),
                (float) config.getDouble("lobby-spawn.yaw"),
                (float) config.getDouble("lobby-spawn.pitch")
        );
    }
}
