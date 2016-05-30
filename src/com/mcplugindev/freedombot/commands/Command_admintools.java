package com.mcplugindev.freedombot.commands;

import com.mcplugindev.freedombot.FreedomBot;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Command_admintools implements CommandExecutor {

    private FreedomBot plugin;

    public Command_admintools(FreedomBot plugin) {
        FreedomBot.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {

        // TODO: code things

        return true;

    }

}
