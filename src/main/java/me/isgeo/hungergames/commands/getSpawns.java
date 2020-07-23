package me.isgeo.hungergames.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class getSpawns{
    public getSpawns(Player player, int value){

        value--;

        if (value < 0 || value > (addSpawn.spawnListX.size() - 1)){
            System.out.println("Outside bounds of Array");
            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.YELLOW + "HG" + ChatColor.GRAY + "]" + ChatColor.RED + " Outside bounds of Array");
        }else {
            System.out.println(addSpawn.spawnListX.get(value));
            System.out.println(addSpawn.spawnListY.get(value));
            System.out.println(addSpawn.spawnListZ.get(value));
        }
    }
}
