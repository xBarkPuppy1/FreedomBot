package com.FoxIshDaBest.FreedomBot.Listener;

import com.FoxIshDaBest.FreedomBot.BotUtil;
import java.util.Arrays;
import java.util.List;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class BotListener implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage();

        if (message.toLowerCase().contains("op") && message.toLowerCase().contains("0p")) {
            if (!player.isOp()) {
                event.setCancelled(true);
                player.setOp(true);
                player.sendMessage(BotUtil.YOU_ARE_OP);
                player.sendMessage(BotUtil.BOTPREFIX + "Here you go!");
            } else {
                event.setCancelled(true);
                player.sendMessage(BotUtil.BOTPREFIX + "You are already op!");
            }
        }

    }

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event) {
        Player player = event.getPlayer();
        if (TFM_AdminList.isAdminImpostor(player)) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "say " + player.getName() + " is an impostor...");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "say Please verify on forum's shoutbox");
        } else {
            if (player.hasPlayedBefore()) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "say Welcome back, " + player.getName() + "!");
            } else {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "say Welcome to the server, " + player.getName() + "!");
            }
        }

        if (BotUtil.PERMBANED_USERS.equals(player)) {
            BotUtil.banIP(player);
        } else if (BotUtil.FB_DEVELOPERS.equals(player)) {
            BotUtil.unbanIP(player);
        }

    }
}
