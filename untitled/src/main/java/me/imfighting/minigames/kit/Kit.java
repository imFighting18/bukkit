package me.imfighting.minigames.kit;

import me.imfighting.minigames.Minigames;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

import java.util.UUID;

public abstract class Kit implements Listener {

    private KitType kitType;
    private UUID uuid;

    public Kit(KitType kitType, UUID uuid, Minigames minigames) {
        this.kitType = kitType;
        this.uuid = uuid;

        Bukkit.getPluginManager().registerEvents(this, minigames);

    }

    public UUID getUuid() {
        return uuid;
    }
    public KitType getKitType() {
        return kitType;
    }
    public abstract void onStart(Player player);

    public void remove() {
        HandlerList.unregisterAll(this);
    }



}
