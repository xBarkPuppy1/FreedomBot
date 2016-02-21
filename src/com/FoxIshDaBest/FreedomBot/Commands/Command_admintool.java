package com.FoxIshDaBest.FreedomBot.Commands;

import com.FoxIshDaBest.FreedomBot.FreedomBot;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_admintool implements CommandExecutor {

    private FreedomBot plugin;

    public Command_admintool(FreedomBot plugin) {
        FreedomBot.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
        plugin.getConfig();
        final String msg = StringUtils.join(args, " ", 1, args.length);

            if (args.length == 0) {
               sender.sendMessage(ChatColor.RED + "Usage: /adminhelp <message>");
               return true;
            }
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (TFM_AdminList.isSuperAdmin(player)) {
                    String name = ChatColor.RED + sender.getName() + ChatColor.GRAY + ": ";
                    String message = ChatColor.RESET + msg;
                    player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "Admin Help" + ChatColor.DARK_GRAY + "]" + name + message);
                
            }
        }
        
        return true;

    }

}
