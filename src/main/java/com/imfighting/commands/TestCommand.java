package com.imfighting.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (player.hasPermission("testplugin.use")) {
                player.sendMessage("§aVocê tem permissão!");
            } else {
                player.sendMessage("§cVocê não tem permissão!");
            }
        }
        return false;
    }
}
