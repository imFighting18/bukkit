package me.imfighting.minigames.listener;

import me.imfighting.minigames.GameState;
import me.imfighting.minigames.Minigames;
import me.imfighting.minigames.instance.Arena;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class GameListener implements Listener {

    private Minigames minigames;

    public GameListener(Minigames minigames) {
        this.minigames = minigames;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {

        Arena arena = minigames.getArenaManager().getArena(e.getPlayer());
        if (arena != null && arena.getState().equals(GameState.LIVE)) {
                arena.getGame().addPoints(e.getPlayer());
        }
    }
}
