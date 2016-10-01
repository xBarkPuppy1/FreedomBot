package com.mcplugindev.freedombot.commands;

import com.mcplugindev.freedombot.BotUtil;
import com.mcplugindev.freedombot.FreedomBot;
import static org.bukkit.Bukkit.getPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_getip implements CommandExecutor {

    private FreedomBot plugin;

    public Command_getip(FreedomBot plugin) {
        FreedomBot.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {

        
        final Player player = getPlayer(args[0]);
        final String ip = player.getAddress().getAddress().getHostAddress().trim();

        if (args.length == 0) {
            sender.sendMessage(BotUtil.BLUEPREFIX + "No player listed!");
            return true;
        } else {
            sender.sendMessage(BotUtil.BLUEPREFIX + player.getName() + "'s ip address is " + ip + ".");
        }
        
        return true;

    }

}
