package me.imfighting.minigames.listener;

import me.imfighting.minigames.GameState;
import me.imfighting.minigames.Minigames;
import me.imfighting.minigames.instance.Arena;
import me.imfighting.minigames.kit.KitType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GameListener implements Listener {

    private Minigames minigames;

    public GameListener(Minigames minigames) {
        this.minigames = minigames;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        if (e.getInventory().getTitle().equals("§8Kit selection") && e.getCurrentItem() != null && e.getInventory() != null) {
            e.setCancelled(true);

            KitType type = KitType.valueOf(e.getCurrentItem().getItemMeta().getLocalizedName());

            Arena arena = minigames.getArenaManager().getArena(player);
            if (arena != null) {
                KitType activated = arena.getKitType(player);
                if (activated != null && activated == type) {
                    player.sendMessage("§cVocê já está com este kit!");
                } else {
                    player.sendMessage("§aVocê ativou o kit " + type.getDisplay() + "§a!");
                    arena.setKit(player.getUniqueId(), type);
                }

                player.closeInventory();
            }


        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {

        Arena arena = minigames.getArenaManager().getArena(e.getPlayer());
        if (arena != null && arena.getState().equals(GameState.LIVE)) {
            arena.getGame().addPoints(e.getPlayer());
        }
    }
}
