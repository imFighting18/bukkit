package me.imfighting.minigames.listener;

import me.imfighting.minigames.Minigames;
import me.imfighting.minigames.instance.Arena;
import me.imfighting.minigames.managaers.ConfigManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectListener implements Listener {

    private Minigames minigames;

    public ConnectListener(Minigames minigames) {
        this.minigames = minigames;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        e.getPlayer().teleport(ConfigManager.getLobbySpawn());

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {

        Arena arena = minigames.getArenaManager().getArena(e.getPlayer());
        if (arena!=null) {
            arena.removePlayer(e.getPlayer());
        }

    }

}
