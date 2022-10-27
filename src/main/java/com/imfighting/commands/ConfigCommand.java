package com.imfighting.commands;

import com.imfighting.tutorial.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ConfigCommand implements CommandExecutor {

    private Main m;

    public ConfigCommand(Main m) {
        this.m = m;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            m.getConfig().set("Word", "Cake");

            List<String> list = m.getConfig().getStringList("String-list");
            list.add("Valor5");
            m.getConfig().set("String-list", list);

            m.saveConfig();

            /*player.sendMessage(m.getConfig().getString("Word"));
            player.sendMessage(m.getConfig().getInt("Number") + "");
            if (m.getConfig().getBoolean("Boolean")) {
                player.sendMessage("§aHabilitado!");
            } else {
                player.sendMessage("§cDesabilitado!");
            }

            for (String str : m.getConfig().getStringList("String-list")) {
                player.sendMessage(str);
            }*/





        }


        return false;
    }
}
