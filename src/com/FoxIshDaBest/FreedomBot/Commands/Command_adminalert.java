package com.FoxIshDaBest.FreedomBot.Commands;

import com.FoxIshDaBest.FreedomBot.FreedomBot;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
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

        if (!TFM_AdminList.isSuperAdmin(sender)) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (TFM_AdminList.isSuperAdmin(player)) {
                    player.sendMessage(name + message.replaceAll("&", "§"));
                }
                return true;
            }
        } else {
            Bukkit.broadcastMessage(TFM_Util.randomChatColor() + sender.getName() + " is a clown.");
        }

        return true;

    }

}
