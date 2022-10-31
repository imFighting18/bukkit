package me.imfighting.minigames.command;

import me.imfighting.minigames.GameState;
import me.imfighting.minigames.Minigames;
import me.imfighting.minigames.instance.Arena;
import me.imfighting.minigames.kit.KitUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ArenaCommand implements CommandExecutor {

    private Minigames minigames;

    public ArenaCommand(Minigames minigames) {
        this.minigames = minigames;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if (args.length == 1 && args[0].equalsIgnoreCase("list")) {
                player.sendMessage("§aArenas disponíveis:");
                for (Arena arena : minigames.getArenaManager().getArenas()) {
                    player.sendMessage("- " + arena.getId() + "(" + arena.getState().name() + ")");
                }
            } else if (args.length == 1 && args[0].equalsIgnoreCase("kit")) {

                Arena arena = minigames.getArenaManager().getArena(player);
                if (arena != null) {
                    if (arena.getState() != GameState.LIVE) {
                        new KitUI(player);
                    }
                } else {
                    player.sendMessage("§cVocê não está na arena!");
                }


            } else if (args.length == 1 && args[0].equalsIgnoreCase("leave")) {
                Arena arena = minigames.getArenaManager().getArena(player);
                if (arena != null) {
                    player.sendMessage("§aSaiu da arena!");
                    arena.removePlayer(player);
                } else {
                    player.sendMessage("§cNão está em uma arena!");
                }

            } else if (args.length == 2 && args[0].equalsIgnoreCase("join")) {
                if (minigames.getArenaManager().getArena(player) != null) {
                    player.sendMessage("§cVocê já está em uma arena!");
                    return false;
                }

                int id;
                try {
                    id = Integer.parseInt(args[1]);
                } catch (NumberFormatException e) {
                    player.sendMessage("§cDigite um número válido!");
                    return false;
                }

                if (id >= 0 && id < minigames.getArenaManager().getArenas().size()) {
                    Arena arena = minigames.getArenaManager().getArena(id);
                    if (arena.getState() == GameState.RECRUITING || arena.getState() == GameState.COUNTDOWN) {
                        player.sendMessage("§aVocê está na arena §b" + id + "§a.");
                        arena.addPlayer(player);
                    } else {
                        player.sendMessage("§cVocê não pode entrar na arena agora!");
                    }
                } else {
                    player.sendMessage("§cVocê não especificou uma arena com id válido!");
                }


            } else {
                player.sendMessage("§cUso inválido!");
            }
        }


        return false;
    }
}
