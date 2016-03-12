package com.FoxIshDaBest.FreedomBot.Commands;

import com.FoxIshDaBest.FreedomBot.BotUtil;
import com.FoxIshDaBest.FreedomBot.FreedomBot;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class Command_makemefleh implements CommandExecutor {


    private FreedomBot plugin;

    public Command_makemefleh(FreedomBot plugin) {
        FreedomBot.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
        Player player = (Player) sender;
        if (sender.getName().equals("FoxIshDaBest")) {
            sender.sendMessage(ChatColor.GREEN + "ok");
            player.setVelocity(player.getVelocity().clone().add(new Vector(0, 2, 0)));
            BotUtil.setFlying(player, true);
            return true;
        } else {
            sender.sendMessage(ChatColor.RED + "no");
            player.setHealth(0);
        }
        
        return true;

    }

    

}
