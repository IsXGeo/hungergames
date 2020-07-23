package me.isgeo.hungergames.commands;

import me.isgeo.hungergames.files.checkBounds;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class addSpawn {

    // TODO: Maybe find a better way to do this apart from three separate arrays?

    public static ArrayList<Double> spawnListX = new ArrayList<>();
    public static ArrayList<Double> spawnListY = new ArrayList<>();
    public static ArrayList<Double> spawnListZ = new ArrayList<>();

    public addSpawn(Player player){

        double x = player.getLocation().getX();
        double y = player.getLocation().getY();
        double z = player.getLocation().getZ();

        if(checkBounds.arenaBox(x, y, z)){
            spawnListX.add(x);
            spawnListY.add(y);
            spawnListZ.add(z);
        }else{
            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.YELLOW + "HG" + ChatColor.GRAY + "]" + ChatColor.RED + " Spawn outside bounds of Arena");
        }


    }

}
