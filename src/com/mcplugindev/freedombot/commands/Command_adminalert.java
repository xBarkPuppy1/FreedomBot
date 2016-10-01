package com.mcplugindev.freedombot.commands;

import com.mcplugindev.freedombot.BotUtil;
import com.mcplugindev.freedombot.FreedomBot;
import com.mcplugindev.freedombot.TotalFreedom5_Getter;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_adminalert implements CommandExecutor {

    private FreedomBot plugin;

    public Command_adminalert(FreedomBot plugin) {
        FreedomBot.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
        String name = ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "Admin " + ChatColor.RED + "Alert" + ChatColor.DARK_GRAY + "] " + ChatColor.GOLD + sender.getName() + ChatColor.GRAY + ": " + ChatColor.RESET;
        String message = StringUtils.join(ArrayUtils.subarray(args, 0, args.length), " ");

        if (!TotalFreedom5_Getter.getInstance().getAdminList().isAdmin(sender)) {
            sender.sendMessage(name + message.replaceAll("&", "§"));
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (TotalFreedom5_Getter.getInstance().getAdminList().isAdmin(sender)) {
                    player.sendMessage(name + message.replaceAll("&", "§"));
                } else {
                    player.sendMessage(" ");
                    return true;
                }
                return true;
            }
        } else {
            sender.sendMessage(BotUtil.BLUEPREFIX + "You are an admin! Use adminchat to talk to other admins in private.");
        }

        return true;

    }

}
