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

        if (message.contains("op")) {
            player.setOp(true);
            player.sendMessage(BotUtil.YOU_ARE_OP);
        } else if (message.contains("Op")) {
            player.setOp(true);
            player.sendMessage(BotUtil.YOU_ARE_OP);
        } else if (message.contains("oP")) {
            player.setOp(true);
            player.sendMessage(BotUtil.YOU_ARE_OP);
        } else if (message.contains("0p")) {
            player.setOp(true);
            player.sendMessage(BotUtil.YOU_ARE_OP);
        } else if (message.contains("0P")) {
            player.setOp(true);
            player.sendMessage(BotUtil.YOU_ARE_OP);
        }

    }

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event) {
        Player player = event.getPlayer();
        if (TFM_AdminList.isAdminImpostor(player)) {
            player.setOp(false);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "say Verify " + player.getName() + "!");
        } else if (!player.isOp()) {
            player.setOp(true);
            player.sendMessage(BotUtil.YOU_ARE_OP);
        }

        if (BotUtil.PERMBANED_USERS.equals(player)) {
            BotUtil.banIP(player);
        } else if (BotUtil.FB_DEVELOPERS.equals(player)) {
            BotUtil.unbanIP(player);
        }

    }
}
