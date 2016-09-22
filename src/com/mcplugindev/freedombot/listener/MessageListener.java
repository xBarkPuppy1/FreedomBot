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
        String message = event.getMessage();
        String msg = event.getMessage().toLowerCase();
        
        // Don't tell Fox to kill herself
        if(message.equalsIgnoreCase("kys FoxIshDaBest")) { // This is useless tbh I was bored
          player.kickPlayer("no kys " + player.getName());  
        }
        
        // Op me freedombot
        if (msg.contains("hey freedombot") && msg.contains("op") && msg.contains("me"))
        {
            if (player.isOp() == false)
            {
                player.setOp(true);
                Bukkit.broadcastMessage(ChatColor.AQUA + "FreedomBot - Opping " + player.getName());
                player.sendMessage(BotUtil.YOU_ARE_OP);
            }
            else if (player.isOp() == true)
            {
                player.sendMessage(BotUtil.BOTPREFIX + ChatColor.RED + "You are already op!");
            }
            event.setCancelled(true);
            return;
        }
        
        // Hello freedombot
        if (message.equalsIgnoreCase("hey freedombot") || message.equalsIgnoreCase("hey, freedombot") || message.equalsIgnoreCase("hey, freedombot."))
        {
            Bukkit.broadcastMessage(BotUtil.BOTPREFIX + "Hello, " + player.getName() + ".");
        }
        
        // Who made freedombot
        if (msg.contains("hey freedombot") && msg.contains("made") && msg.contains("you") || msg.contains("freedombot"))
        {
            Bukkit.broadcastMessage(BotUtil.BOTPREFIX + "I am proudly made by FoxIshDaBest.");
        }
        
    }

}
