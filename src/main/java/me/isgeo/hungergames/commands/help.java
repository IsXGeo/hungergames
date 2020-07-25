package me.isgeo.hungergames.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class help {
    public help(Player player){

        String HG = ChatColor.GRAY + "/hg " + ChatColor.YELLOW;

        player.sendMessage(ChatColor.GRAY + "-----------[" + ChatColor.YELLOW + "HungerGames " + ChatColor.GRAY + "-" + ChatColor.YELLOW + " Help Menu" + ChatColor.GRAY + "]-----------");
        player.sendMessage(HG + "help" + ChatColor.GRAY + " - Opens the help menu");
        player.sendMessage(HG + "info" + ChatColor.GRAY + " - Gives plugin information");
        player.sendMessage(HG + "arena pos1" + ChatColor.GRAY + " - Set arena position 1");
        player.sendMessage(HG + "arena pos2" + ChatColor.GRAY + " - Set arena position 2");
        player.sendMessage(HG + "arena create [name] [length]" + ChatColor.GRAY + "- Create arena");
        player.sendMessage(HG + "addspawn" + ChatColor.GRAY + "- Add a spawnpoint to an arena");
    }
}
