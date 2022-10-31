package com.imfighting.tutorial;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.sql.SQLException;

public class ConnectionListener implements Listener {

    Main main;

    public ConnectionListener(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        try {
            CustomPlayer customPlayer = new CustomPlayer(main, player.getUniqueId());
            main.getPlayerManager().addCustomPlayer(player.getUniqueId(), customPlayer);
        } catch (SQLException ex) {
            player.kickPlayer("§cDeu erro no banco de dados!");
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        main.getPlayerManager().removeCustomPlayer(e.getPlayer().getUniqueId());
    }

}
