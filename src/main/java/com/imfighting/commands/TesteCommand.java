package com.imfighting.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TesteCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            ((Player) sender).sendMessage("No, this is consoly only!");
            /*if (args.length == 1) {
                if (args[0].equalsIgnoreCase("hello")) {
                    ((Player) sender).sendMessage("Hello my friend!");
                }
            }*/
        } else {
            sender.sendMessage("Olá, você digitou no console!");
        }

        return false;
    }
}
