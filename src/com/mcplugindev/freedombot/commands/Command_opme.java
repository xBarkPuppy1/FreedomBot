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

public class Command_opme implements CommandExecutor {

    private FreedomBot plugin;

    public Command_opme(FreedomBot plugin) {
        FreedomBot.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
        
// For this command to be used, you will need to remove the Command_opme.java file in your TotalFreedomMod.
        
        Player player = (Player) sender;
        if (TotalFreedom5_Getter.getInstance().getAdminList().isAdminImpostor(player)) {
            sender.sendMessage(BotUtil.BOTPREFIX + "You are an imposter. Verify!");
            sender.setOp(false);
            return true;
        } else if (!(player.isOp())) {
            Bukkit.broadcastMessage(ChatColor.AQUA + "FreedomBot - Opping " + sender.getName());
            player.setOp(true);
            sender.sendMessage(BotUtil.YOU_ARE_OP);
            return true;
        } else if (player.isOp()) {
            sender.sendMessage(BotUtil.BOTPREFIX + "You are already op!");
            return true;
        }
        return true;
    }

}
