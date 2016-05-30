package com.mcplugindev.freedombot.commands;

import com.mcplugindev.freedombot.BotUtil;
import com.mcplugindev.freedombot.FreedomBot;
import com.mcplugindev.freedombot.TotalFreedom5_Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_cleanup implements CommandExecutor {

    private FreedomBot plugin;

    public Command_cleanup(FreedomBot plugin) {
        FreedomBot.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {

        if (TotalFreedom5_Getter.getInstance().getAdminList().isAdmin(sender)) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "purgeall");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "setl");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "nickclean");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "potion clearall");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rd");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "invis smite");
            Bukkit.broadcastMessage(ChatColor.RED + "CONSOLE - Opping all players on the server and deoping all imposters");
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (TotalFreedom5_Getter.getInstance().getAdminList().isAdminImpostor(player)) {
                    player.sendMessage(BotUtil.BOTPREFIX + "Please verify!");
                    player.setOp(false);
                    player.sendMessage(BotUtil.YOU_ARE_NOT_OP);
                } else {
                    player.setOp(true);
                    player.sendMessage(BotUtil.YOU_ARE_OP);
                }
            }
            sender.sendMessage(BotUtil.BOTPREFIX + "You have used the admintool command.");
        } else {
            sender.sendMessage(BotUtil.BOTPREFIX + "You are not allowed to use this command!");
            return true;
        }

        return true;

    }

}
