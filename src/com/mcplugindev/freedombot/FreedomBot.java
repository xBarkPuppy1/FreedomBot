package com.mcplugindev.freedombot;

import com.mcplugindev.freedombot.commands.*;
import com.mcplugindev.freedombot.listener.BotListener;
import com.mcplugindev.freedombot.listener.MessageListener;
import java.util.logging.Level;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class FreedomBot extends JavaPlugin {

    public static FreedomBot plugin;
    public static Server server;

    @Override
    public void onLoad() {
        plugin = this;

    }

    @Override
    public void onEnable() {
        final PluginManager pm = plugin.getServer().getPluginManager();
        pm.registerEvents(new BotListener(), plugin);
        pm.registerEvents(new MessageListener(), plugin);
        plugin.getLogger().log(Level.INFO, "FreedomBot v{0} has been enabled!", plugin.getDescription().getVersion());
        plugin.getLogger().log(Level.INFO, "The current FreedomBot developers are FoxIshDaBest, DUFC_Liam, _JustYellow, and tylerhyperHD.");
        this.getCommand("freedombot").setExecutor(new Command_freedombot(plugin));
        this.getCommand("opme").setExecutor(new Command_opme(plugin));
        this.getCommand("admintool").setExecutor(new Command_admintool(plugin));
        this.getCommand("getgamemode").setExecutor(new Command_getgamemode(plugin));
        this.getCommand("getip").setExecutor(new Command_getip(plugin));
        this.getCommand("adminalert").setExecutor(new Command_adminalert(plugin));

    }

    @Override
    public void onDisable() {
        plugin.getLogger().log(Level.INFO, "FreedomBot v{0} has been disabled!", plugin.getDescription().getVersion());

    }

}
