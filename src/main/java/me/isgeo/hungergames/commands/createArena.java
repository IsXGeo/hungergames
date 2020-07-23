package me.isgeo.hungergames.commands;

import me.isgeo.hungergames.files.arenasConfig;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.util.BoundingBox;

import java.util.ArrayList;

public class createArena {

    public static BoundingBox arenaBox = new BoundingBox();
    public static ArrayList<String> arenaList = new ArrayList<>();

    public createArena(Player player, String name, Integer length) {

        World world = setArenaPos.world;
        String HG = ChatColor.GRAY + "[" + ChatColor.YELLOW + "HG" + ChatColor.GRAY + "]";

        if (setArenaPos.x1 != null && setArenaPos.x2 != null) {

            String strWorld = world.getName();

            player.sendMessage(HG + " Created arena with name " + ChatColor.YELLOW + name + ChatColor.GRAY + " in world " + ChatColor.YELLOW + strWorld);

            double x = setArenaPos.x1;
            double y = setArenaPos.y1;
            double z = setArenaPos.z1;
            double x2 = setArenaPos.x2;
            double y2 = setArenaPos.y2;
            double z2 = setArenaPos.z2;

            arenasConfig.setup(name);
            arenasConfig.get().addDefault("world", strWorld);
            arenasConfig.get().addDefault("length", length);
            arenasConfig.get().addDefault("bounds.x", x);
            arenasConfig.get().addDefault("bounds.y", y);
            arenasConfig.get().addDefault("bounds.z", z);

            arenasConfig.get().addDefault("bounds.x2", x2);
            arenasConfig.get().addDefault("bounds.y2", y2);
            arenasConfig.get().addDefault("bounds.z2", z2);
            arenasConfig.get().options().copyDefaults(true);
            arenasConfig.save();

            arenaList.add(name);

            Location corner1 = new Location(world, x, y, z);
            Location corner2 = new Location(world, x2, y2, z2);

            arenaBox = BoundingBox.of(corner1, corner2);

        }else{
            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.YELLOW + "HG" + ChatColor.GRAY + "]" + ChatColor.RED + " Please set bounds for arena first!");
        }

    }
}
