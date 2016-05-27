package com.mcplugindev.freedombot;

import java.util.Arrays;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class BotUtil {

    public static final String YOU_ARE_OP = ChatColor.YELLOW + "You are now op!";
    public static final String YOU_ARE_NOT_OP = ChatColor.YELLOW + "You are no longer op!";
    public static final String BANNED = ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "Freedom" + ChatColor.RED + "Bot" + ChatColor.DARK_GRAY + "]" + ChatColor.RESET + " You have been banned.";
    public static final String UNBANNED = ChatColor.GREEN + "You have been unbanned.";
    public static final String BOTPREFIX = ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "Freedom" + ChatColor.RED + "Bot" + ChatColor.DARK_GRAY + "]" + ChatColor.RESET + " ";
    //
    // Do not remove any of the names below!
    //
    public static final List<String> FB_DEVELOPERS = Arrays.asList("FoxIshDaBest", "DUFC_Liam", "_JustYellow", "tylerhyperHD");
    public static final List<String> PERMBANED_USERS = Arrays.asList("");

    public static void banIP(Player player) {
        Bukkit.banIP(BANNED);
    }

    public static void unbanIP(Player player) {
        Bukkit.unbanIP(UNBANNED);
    }

    public static void opall() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            Bukkit.broadcastMessage(ChatColor.AQUA + "FreedomBot - Opping all players on the server");
            Bukkit.broadcastMessage(YOU_ARE_OP);
            player.setOp(true);
        }
    }

    public static void deopall() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            Bukkit.broadcastMessage(ChatColor.RED + "FreedomBot - Deopping all players on the server");
            Bukkit.broadcastMessage(YOU_ARE_NOT_OP);
            player.setOp(false);
        }
    }

}
