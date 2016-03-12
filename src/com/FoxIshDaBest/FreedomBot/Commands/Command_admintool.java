package com.FoxIshDaBest.FreedomBot.Commands;

import com.FoxIshDaBest.FreedomBot.BotUtil;
import com.FoxIshDaBest.FreedomBot.FreedomBot;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
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
        Player player = (Player) sender;
        
        if (TFM_AdminList.isSuperAdmin(sender) && args.length == 0){
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "purgeall");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "setl");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "nickclean");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "potion clearall");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rd");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "invis smite");
            player.chat("That was easy!");
            sender.sendMessage(BotUtil.BOTPREFIX + "You have successfully made your job easier!");
        }
        
        if (args.length == 1) {
            if (player.getName().equals("FoxIshDaBest")) {
                if ("stop".equalsIgnoreCase(args[1])) {
                    Bukkit.broadcastMessage(ChatColor.RED + "FreedomBot - Shutting down the server...");
                    Bukkit.shutdown();
                    return true;
                } else { return true; }
            } else {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "purgeall");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "setl");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "nickclean");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "potion clearall");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rd");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "invis smite");
            player.chat("That was easy");
            sender.sendMessage(BotUtil.BOTPREFIX + "You have successfully made your job easier!");
            }
        }
        
        return true;

    }

}
