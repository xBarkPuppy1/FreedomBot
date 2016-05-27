package com.mcplugindev.freedombot;

import com.mcplugindev.freedombot.commands.Command_freedombot;
import com.mcplugindev.freedombot.commands.Command_opme;
import com.mcplugindev.freedombot.commands.Command_admintool;
import com.mcplugindev.freedombot.commands.Command_adminalert;
import com.mcplugindev.freedombot.listener.BotListener;
import java.util.logging.Level;
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
        plugin.getLogger().log(Level.INFO, "FreedomBot v{0} has been enabled!", plugin.getDescription().getVersion());
        plugin.getLogger().log(Level.INFO, "The current FreedomBot developers are FoxIshDaBest, DUFCLiam, _JustYellow, and tylerhyperHD.");

        this.getCommand("freedombot").setExecutor(new Command_freedombot(plugin));
        this.getCommand("opme").setExecutor(new Command_opme(plugin));
        this.getCommand("admintool").setExecutor(new Command_admintool(plugin));
        this.getCommand("adminalert").setExecutor(new Command_adminalert(plugin));

    }

    @Override
    public void onDisable() {
        plugin.getLogger().log(Level.INFO, "FreedomBot v{0} has been disabled!", plugin.getDescription().getVersion());

    }

}
