package me.isgeo.hungergames.commands;

import me.isgeo.hungergames.HungerGames;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.text.DecimalFormat;

public class setArenaPos {

    private static DecimalFormat df = new DecimalFormat("0.0");
    Plugin plugin = HungerGames.getPlugin(HungerGames.class);

    public setArenaPos(Player player, int position) {

        World world = player.getLocation().getWorld();
        double x = player.getLocation().getX();
        double y = player.getLocation().getY();
        double z = player.getLocation().getZ();

        String strWorld = world.getName();

        if(position == 1) {
            plugin.getConfig().set("temp.world", strWorld);
            plugin.getConfig().set("temp.x", x);
            plugin.getConfig().set("temp.y", y);
            plugin.getConfig().set("temp.z", z);
        }else if(position == 2){
            plugin.getConfig().set("temp.world", strWorld);
            plugin.getConfig().set("temp.x2", x);
            plugin.getConfig().set("temp.y2", y);
            plugin.getConfig().set("temp.z2", z);
        }
        plugin.saveConfig();

        x = Double.parseDouble(df.format(x));
        y = Double.parseDouble(df.format(y));
        z = Double.parseDouble(df.format(z));

        player.sendMessage(ChatColor.GRAY + "Position " + ChatColor.YELLOW + position + ChatColor.GRAY + " set.");
        player.sendMessage(ChatColor.GRAY + "World: " + ChatColor.YELLOW + strWorld + ChatColor.GRAY + ".");
        player.sendMessage(ChatColor.GRAY + "X: " + ChatColor.YELLOW + x + ChatColor.GRAY + ".");
        player.sendMessage(ChatColor.GRAY + "Y: " + ChatColor.YELLOW + y + ChatColor.GRAY + ".");
        player.sendMessage(ChatColor.GRAY + "Z: " + ChatColor.YELLOW + z + ChatColor.GRAY + ".");

    }
}
