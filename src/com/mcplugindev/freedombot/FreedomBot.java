package com.mcplugindev.freedombot;

import com.mcplugindev.freedombot.commands.*;
import com.mcplugindev.freedombot.listener.BotListener;
import com.mcplugindev.freedombot.listener.MessageListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class FreedomBot extends JavaPlugin {

    public static FreedomBot plugin;
    public static Server server;
    private FileConfiguration configMain;
    private File configFileMain;

    public FreedomBot(FreedomBot pl) {
        plugin = pl;
    }
    
    @Override
    public void onLoad() {
        plugin = this;

    }
        public FileConfiguration getConfigMain() {
        return configMain;
    }

    public void createFiles() {
        if (!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }

        configFileMain = new File(getDataFolder(), "config.yml");
        if (!configFileMain.exists()) {
            try {
                configFileMain.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        configMain = YamlConfiguration.loadConfiguration(configFileMain);
    }

    public void configSettings() {
        boolean save = false;
        File file = new File(this.getDataFolder(), "config.yml");
        if(!this.getConfigMain().contains("botprefix")) {
            this.getConfigMain().set("botprefix", "&8[&9Freedom&1Bot&8]");
            save = true;
        }
         if(save) {
            try
            {
                this.getConfigMain().save(file);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
    
   
    
    @Override
    public void onEnable() {
        final PluginManager pm = plugin.getServer().getPluginManager();
        pm.registerEvents(new BotListener(), plugin);
        pm.registerEvents(new MessageListener(this), plugin);
        plugin.getLogger().log(Level.INFO, "FreedomBot v{0} has been enabled!", plugin.getDescription().getVersion());
        plugin.getLogger().log(Level.INFO, "The current FreedomBot developers are FoxIshDaBest, DUFC_Liam, _JustYellow, and tylerhyperHD.");
        this.getCommand("freedombot").setExecutor(new Command_freedombot(plugin));
        this.getCommand("opme").setExecutor(new Command_opme(plugin));
        this.getCommand("admintool").setExecutor(new Command_admintool(plugin));
        this.getCommand("getgamemode").setExecutor(new Command_getgamemode(plugin));
        this.getCommand("getip").setExecutor(new Command_getip(plugin));
        this.getCommand("adminalert").setExecutor(new Command_adminalert(plugin));
        createFiles();
        configSettings();
    }

    @Override
    public void onDisable() {
        plugin.getLogger().log(Level.INFO, "FreedomBot v{0} has been disabled!", plugin.getDescription().getVersion());

    }


}
