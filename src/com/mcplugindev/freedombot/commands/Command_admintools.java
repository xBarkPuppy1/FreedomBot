package com.mcplugindev.freedombot.commands;

import com.mcplugindev.freedombot.BotUtil;
import com.mcplugindev.freedombot.FreedomBot;
import com.mcplugindev.freedombot.TotalFreedom5_Getter;
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

        if (!TotalFreedom5_Getter.getInstance().getAdminList().isAdmin(sender)) {
            sender.sendMessage(BotUtil.NO_PERMISSION);
            return true;
        } else if (TotalFreedom5_Getter.getInstance().getAdminList().isAdmin(sender)) {
            sender.sendMessage(BotUtil.BOTPREFIX + "This command is still in development. Ask a FreedomBot developer to finish it.");
            return true;
        } else {
            sender.sendMessage(BotUtil.BOTPREFIX + "This command can only be used in game.");
        }

        return true;

    }

}
