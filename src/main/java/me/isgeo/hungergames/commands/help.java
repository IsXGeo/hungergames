package me.isgeo.hungergames.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class help {
    public help(Player player){
        player.sendMessage(ChatColor.GRAY + "-----------[" + ChatColor.YELLOW + "HungerGames " + ChatColor.GRAY + "-" + ChatColor.YELLOW + " Help Menu" + ChatColor.GRAY + "]-----------");
        player.sendMessage(ChatColor.GRAY + "/hg " + ChatColor.YELLOW + "help" + ChatColor.GRAY + " - Opens the help menu");
        player.sendMessage(ChatColor.GRAY + "/hg " + ChatColor.YELLOW + "info" + ChatColor.GRAY + " - Gives plugin information");
        player.sendMessage(ChatColor.GRAY + "/hg " + ChatColor.YELLOW + "arena pos1" + ChatColor.GRAY + " - Set arena position 1");
        player.sendMessage(ChatColor.GRAY + "/hg " + ChatColor.YELLOW + "arena pos2" + ChatColor.GRAY + " - Set arena position 2");
        player.sendMessage(ChatColor.GRAY + "/hg " + ChatColor.YELLOW + "arena create [name] [length]" + ChatColor.GRAY + "- Create arena");
    }
}
