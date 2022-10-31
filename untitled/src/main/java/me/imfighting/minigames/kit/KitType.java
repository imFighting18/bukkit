package me.imfighting.minigames.kit;

import org.bukkit.Material;

public enum KitType {

    MINER("§6Miner", Material.DIAMOND_PICKAXE, "§aMinere com uma picareta!"),
    FIGHTER("§6Fighter", Material.IRON_SWORD, "§aDerrote todos os inimigos!");

    private String display, description;
    private Material material;

    KitType(String display, Material material, String description) {
        this.display = display;
        this.material = material;
        this.description = description;
    }

    public Material getMaterial() {
        return material;
    }
    public String getDescription() {
        return description;
    }
    public String getDisplay() {
        return display;
    }
}
