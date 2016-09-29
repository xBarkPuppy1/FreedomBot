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
        
        // Op me freedombot
        if (message.contains("hey") &&  message.contains("freedombot") && message.contains("op") && message.contains("me"))
        {
            if (!player.isOp())
            {
                player.setOp(true);
                Bukkit.broadcastMessage(ChatColor.AQUA + "FreedomBot - Opping " + player.getName());
                player.sendMessage(BotUtil.YOU_ARE_OP);
            }
            else if (player.isOp())
            {
                player.sendMessage(BotUtil.BOTPREFIX + ChatColor.RED + "You are already op!");
            }
            event.setCancelled(true);
            return;
        }
        
        if (message.equalsIgnoreCase("hey freedombot") || message.equalsIgnoreCase("hey, freedombot") || message.equalsIgnoreCase("hey, freedombot."))
        {
            Bukkit.broadcastMessage(BotUtil.BOTPREFIX + "Hello, " + player.getName() + ".");
        }
        
        if (message.contains("hey freedombot") && message.contains("made") && message.contains("you") || message.contains("freedombot"))
        {
            Bukkit.broadcastMessage(BotUtil.BOTPREFIX + "I was made by FoxIshDaBest and DUFCLiam.");
        }
        
    }

}
