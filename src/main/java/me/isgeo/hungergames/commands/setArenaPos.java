package me.isgeo.hungergames.commands;

import me.isgeo.hungergames.HungerGames;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.text.DecimalFormat;

public class setArenaPos {

    private static DecimalFormat df = new DecimalFormat("0.0");

    public static World world;
    public static Double x1;
    public static Double y1;
    public static Double z1;
    public static Double x2;
    public static Double y2;
    public static Double z2;

    public setArenaPos(Player player, int position) {

        world = player.getLocation().getWorld();
        assert world != null;
        String strWorld = world.getName();

        // TODO: Maybe find a way to make this a little bit more clean?

        if(position == 1) {
            x1 = player.getLocation().getX();
            y1 = player.getLocation().getY();
            z1 = player.getLocation().getZ();
            double x3 = Double.parseDouble(df.format(x1));
            double y3 = Double.parseDouble(df.format(y1));
            double z3 = Double.parseDouble(df.format(z1));
            player.sendMessage(ChatColor.GRAY + "Position " + ChatColor.YELLOW + "1" + ChatColor.GRAY + " set.");
            player.sendMessage(ChatColor.GRAY + "World: " + ChatColor.YELLOW + strWorld + ChatColor.GRAY + ".");
            player.sendMessage(ChatColor.GRAY + "X: " + ChatColor.YELLOW + x3 + ChatColor.GRAY + ".");
            player.sendMessage(ChatColor.GRAY + "Y: " + ChatColor.YELLOW + y3 + ChatColor.GRAY + ".");
            player.sendMessage(ChatColor.GRAY + "Z: " + ChatColor.YELLOW + z3 + ChatColor.GRAY + ".");
        }else if(position == 2){
            x2 = player.getLocation().getX();
            y2 = player.getLocation().getY();
            z2 = player.getLocation().getZ();
            double x3 = Double.parseDouble(df.format(x2));
            double y3 = Double.parseDouble(df.format(y2));
            double z3 = Double.parseDouble(df.format(z2));
            player.sendMessage(ChatColor.GRAY + "Position " + ChatColor.YELLOW + "2" + ChatColor.GRAY + " set.");
            player.sendMessage(ChatColor.GRAY + "World: " + ChatColor.YELLOW + strWorld + ChatColor.GRAY + ".");
            player.sendMessage(ChatColor.GRAY + "X: " + ChatColor.YELLOW + x3 + ChatColor.GRAY + ".");
            player.sendMessage(ChatColor.GRAY + "Y: " + ChatColor.YELLOW + y3 + ChatColor.GRAY + ".");
            player.sendMessage(ChatColor.GRAY + "Z: " + ChatColor.YELLOW + z3 + ChatColor.GRAY + ".");
        }

    }
}
