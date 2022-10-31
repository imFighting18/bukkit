package me.imfighting.minigames.instance;

import jdk.nashorn.internal.runtime.regexp.joni.Config;
import me.imfighting.minigames.GameState;
import me.imfighting.minigames.Minigames;
import me.imfighting.minigames.kit.Kit;
import me.imfighting.minigames.kit.KitType;
import me.imfighting.minigames.kit.type.Fighter;
import me.imfighting.minigames.kit.type.Miner;
import me.imfighting.minigames.managaers.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Arena {

    private Minigames minigames;

    private int id;
    private Location spawn;

    private GameState state;
    private List<UUID> players;
    private HashMap<UUID, Kit> kits;
    private Countdown countdown;
    private Game game;

    public Arena(Minigames minigames, int id, Location spawn) {
        this.minigames = minigames;

        this.id = id;
        this.spawn = spawn;

        this.state = GameState.RECRUITING;
        this.players = new ArrayList<>();
        this.kits = new HashMap<>();
        this.countdown = new Countdown(minigames, this);
        this.game = new Game(this);
    }

    public void start() {
        game.start();
    }

    public void reset(boolean kickPlayers) {

        if (kickPlayers) {
            for (UUID uuid : players) {
                Player player = Bukkit.getPlayer(uuid);
                player.teleport(ConfigManager.getLobbySpawn());
                removeKit(player.getUniqueId());
            }
            players.clear();
        }

        kits.clear();
        sendTitle("", "");
        state = GameState.RECRUITING;
        countdown.cancel();
        countdown = new Countdown(minigames, this);
        game = new Game(this);

    }

    public void sendMessage(String message) {
        for (UUID uuid : players) {
            Bukkit.getPlayer(uuid).sendMessage(message);
        }
    }

    public void sendTitle(String title, String subtitle) {
        for (UUID uuid : players) {
            Bukkit.getPlayer(uuid).sendTitle(title, subtitle);
        }
    }


    public void addPlayer(Player player) {
        players.add(player.getUniqueId());
        player.teleport(spawn);

        player.sendMessage("§aEscolha um kit utilizando /arena kit!");

        if (state.equals(GameState.RECRUITING) && players.size() >= ConfigManager.getRequeriedPlayers()) {
            countdown.start();
        }
    }

    public void removePlayer(Player player) {
        players.remove(player.getUniqueId());
        player.teleport(ConfigManager.getLobbySpawn());
        sendTitle("", "");

        removeKit(player.getUniqueId());

        if (state == GameState.COUNTDOWN && players.size() < ConfigManager.getRequeriedPlayers()) {
            sendMessage("§cA contagem parou por falta de jogadores!");
            reset(false);
            return;
        }

        if (state == GameState.LIVE && players.size() < ConfigManager.getRequeriedPlayers()) {
            sendMessage("§cO jogo foi finalizado!");
            reset(false);
        }
    }

    public int getId() {
        return id;
    }

    public GameState getState() {
        return state;
    }

    public List<UUID> getPlayers() {
        return players;
    }

    public Game getGame() {
        return game;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public HashMap<UUID, Kit> getKits() {
        return kits;
    }

    public void removeKit(UUID uuid) {
        if (kits.containsKey(uuid)) {
            kits.get(uuid).remove();
            kits.remove(uuid);
        }
    }

    public void setKit(UUID uuid, KitType kitType) {
        removeKit(uuid);
        if (kitType == KitType.MINER) {
            kits.put(uuid, new Miner(uuid, minigames));
        } else if (kitType == KitType.FIGHTER) {
            kits.put(uuid, new Fighter(uuid, minigames));
        }
    }

    public KitType getKitType(Player player) {
        return kits.containsKey(player.getUniqueId()) ? kits.get(player.getUniqueId()).getKitType() : null;
    }

}
