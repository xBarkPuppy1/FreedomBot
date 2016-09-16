package com.mcplugindev.freedombot;

import java.util.Arrays;
import java.util.List;
import me.totalfreedom.totalfreedommod.admin.Admin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BotUtil {
    
    public static final String NO_PERMISSION = BotUtil.BOTPREFIX + "You are not allowed to use this command!";
    public static final String YOU_ARE_OP = ChatColor.YELLOW + "You are now op!";
    public static final String YOU_ARE_NOT_OP = ChatColor.YELLOW + "You are no longer op!";
    public static final String BANNED = ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "Freedom" + ChatColor.RED + "Bot" + ChatColor.DARK_GRAY + "]" + ChatColor.RESET + " You have been banned.";
    public static final String UNBANNED = ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "Freedom" + ChatColor.RED + "Bot" + ChatColor.DARK_GRAY + "]" + ChatColor.RESET + " You have been unbanned.";
    public static final String BOTPREFIX = ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "Freedom" + ChatColor.RED + "Bot" + ChatColor.DARK_GRAY + "]" + ChatColor.RESET + " ";
    public static final List<String> PERMBANED_USERS = Arrays.asList("player1", "player2", "player3");
    //
    // Do not remove any of the names below!
    //
    public static final List<String> FB_DEVELOPERS = Arrays.asList("FoxIshDaBest", "DUFC_Liam", "_JustYellow", "tylerhyperHD", "rovertpug");

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

    public static void addAdmin(Player player) {
        TotalFreedom5_Getter.getInstance().getAdminList().addAdmin((Admin) player);
        Bukkit.broadcastMessage(ChatColor.RED + "FreedomBot - Adding " + player.getName() + " to the admin list");
    }
    
    public static void removeAdmin(Player player) {
        TotalFreedom5_Getter.getInstance().getAdminList().removeAdmin((Admin) player);
        Bukkit.broadcastMessage(ChatColor.RED + "FreedomBot - Removing " + player.getName() + " from the admin list");
    }

    public static void addAdmin(CommandSender sender) {
        TotalFreedom5_Getter.getInstance().getAdminList().addAdmin((Admin) sender);
        Bukkit.broadcastMessage(ChatColor.RED + "FreedomBot - Adding " + sender.getName() + " to the admin list");
    }
    
    public static void removeAdmin(CommandSender sender) {
        TotalFreedom5_Getter.getInstance().getAdminList().removeAdmin((Admin) sender);
        Bukkit.broadcastMessage(ChatColor.RED + "FreedomBot - Removing " + sender.getName() + " from the admin list");
    }
}