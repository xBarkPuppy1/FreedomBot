package com.mcplugindev.freedombot.commands;

import com.mcplugindev.freedombot.BotUtil;
import com.mcplugindev.freedombot.FreedomBot;
import static org.bukkit.Bukkit.getPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_getgamemode implements CommandExecutor {

    private FreedomBot plugin;

    public Command_getgamemode(FreedomBot plugin) {
        FreedomBot.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {

        if (args.length == 0) {
            sender.sendMessage(BotUtil.BLUEPREFIX + "You need to state a player's username to see their gamemode!");
            return true;
        } else {
            final Player player = getPlayer(args[0]);

            sender.sendMessage(BotUtil.BLUEPREFIX + player.getName() + "'s current gamemode is " + player.getGameMode() + ".");
        }

        return true;

    }

}
