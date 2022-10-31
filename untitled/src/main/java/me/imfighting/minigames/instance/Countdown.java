package me.imfighting.minigames.instance;

import me.imfighting.minigames.GameState;
import me.imfighting.minigames.Minigames;
import me.imfighting.minigames.managaers.ConfigManager;
import org.bukkit.scheduler.BukkitRunnable;

public class Countdown extends BukkitRunnable {

    private Minigames minigames;
    private Arena arena;
    private int countdownSeconds;

    public Countdown(Minigames minigames, Arena arena) {
        this.minigames = minigames;
        this.arena = arena;
        this.countdownSeconds = ConfigManager.getCountdownSeconds();
    }

    public void start() {
        arena.setState(GameState.COUNTDOWN);
        runTaskTimer(minigames, 0, 20);
    }

    @Override
    public void run() {
        if (countdownSeconds == 0) {
            cancel();
            arena.start();
            return;
        }

        if (countdownSeconds <= 10 || countdownSeconds % 15 == 0) {
            arena.sendMessage("Arena irá iniciar em: " + countdownSeconds + " segundo" + (countdownSeconds == 1 ? ""
                    : "s") + ".");
        }

        arena.sendTitle("§a"+countdownSeconds+" segundo"+(countdownSeconds == 1 ? "":"s"), "para o jogo começar!");

        countdownSeconds--;
    }
}
