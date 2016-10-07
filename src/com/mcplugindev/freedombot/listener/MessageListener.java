package com.mcplugindev.freedombot.listener;

import com.mcplugindev.freedombot.BotUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class MessageListener implements Listener {
    
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage().toLowerCase();
        
        if (message.contains("hey freedombot") && message.contains("op") && message.contains("me")) {
            if (!player.isOp()) {
                player.setOp(true);
                Bukkit.broadcastMessage(ChatColor.AQUA + "FreedomBot - Opping " + player.getName());
                player.sendMessage(BotUtil.YOU_ARE_OP);
            }
            else if (player.isOp()) {
                player.sendMessage(BotUtil.BLUEPREFIX + ChatColor.RED + "You are already op!");
            }
            event.setCancelled(true);
            return;
        }
        
        if (message.equalsIgnoreCase("hey freedombot") || message.equalsIgnoreCase("hey, freedombot")) {
            Bukkit.broadcastMessage(BotUtil.BLUEPREFIX + "Hello, " + player.getName() + ".");
        }
        
        if (message.contains("hey freedombot") && message.contains("who made you")) {
            Bukkit.broadcastMessage(BotUtil.BLUEPREFIX + "I was made by FoxIshDaBest and DUFCLiam.");
        }
        
        if (message.equals(" ")) {
            event.setCancelled(true);
        }
        
        if (message.contains("hey freedombot") && message.contains("notice me senpai")) {
          Bukkit.broadcastMessage(BotUtil.BLUEPREFIX + "you have been noticed o3o");  
        }
        
        if (message.contains("hey freedombot") && message.contains("give me") && message.contains("owner") || message.contains("admin")) {
            Bukkit.broadcastMessage(BotUtil.BLUEPREFIX + "No.");
        }
        
        if (message.contains("hey freedombot") && message.contains("red prefix")) {
            Bukkit.broadcastMessage(BotUtil.REDPREFIX + "Hello, " + player.getName() + ".");
        }
        
        if (message.contains("hey freedombot") && message.contains("green prefix")) {
            Bukkit.broadcastMessage(BotUtil.GREENPREFIX + "Hello, " + player.getName() + ".");
        }
        
        if (message.contains("hey freedombot") && message.contains("blue prefix")) {
            Bukkit.broadcastMessage(BotUtil.BLUEPREFIX + "Hello, " + player.getName() + ".");
        }
        
        if (message.contains("hey freedombot") && message.contains("orange prefix")) {
            Bukkit.broadcastMessage(BotUtil.ORANGEPREFIX + "Hello, " + player.getName() + ".");
        }
        
        if (message.contains("hey freedombot") && message.contains("kill yourself") || message.contains("kys")) {
            Bukkit.broadcastMessage(BotUtil.BLUEPREFIX + "wha ;-;");
            Bukkit.broadcastMessage(ChatColor.WHITE + "FreedomBot died");
        }
        
        if (message.contains("hey freedombot") && message.contains("who are you")) {
            Bukkit.broadcastMessage(ChatColor.WHITE + "<" + player.getName() + "> I am you.");
        }
        
        if (message.contains("hey freedombot") && message.contains("kill me")) {
            player.setHealth(0);
            Bukkit.broadcastMessage(ChatColor.WHITE + player.getName() + " was slain by FreedomBot");
        }
        
    }

}
