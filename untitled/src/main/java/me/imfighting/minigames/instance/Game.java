package me.imfighting.minigames.instance;

import me.imfighting.minigames.GameState;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class Game {

    private Arena arena;
    private HashMap<UUID, Integer> points;

    public Game(Arena arena) {
        this.arena = arena;
        points = new HashMap<>();
    }

    public void start() {
        arena.setState(GameState.LIVE);
        arena.sendMessage("§aO jogo foi iniciado, seu objetivo é quebrar 20 blocos! Boa sorte!");

        for (UUID uuid : arena.getKits().keySet()) {
            arena.getKits().get(uuid).onStart(Bukkit.getPlayer(uuid));
        }

        for (UUID uuid : arena.getPlayers()) {
            points.put(uuid, 0);
            Bukkit.getPlayer(uuid).closeInventory();
        }
    }

    public void addPoints(Player player) {
        int playerPoints = points.get(player.getUniqueId()) + 1;
        if (playerPoints == 20) {
            arena.sendMessage("§aJogo finalizado! " + player.getName() + " ganhou!");
            arena.reset(true);
            return;
        }

        player.sendMessage("§a+1 PONTO!");
        points.replace(player.getUniqueId(), playerPoints);
    }
}
