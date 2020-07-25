package me.isgeo.hungergames.files;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.util.BoundingBox;

import java.io.File;


public class loadArenas {

    public static void loadArena(File file) {

        FileConfiguration arena = YamlConfiguration.loadConfiguration(file);

        String name = arena.getString("name");
        String strWorld = arena.getString("world");
        Integer length = arena.getInt("length");
        Location corner1 = arena.getLocation("bounds.corner1");
        Location corner2 = arena.getLocation("bounds.corner2");

        //String apple = "1";

        //arena.getLocation("spawn." + apple);

        assert strWorld != null;
        World world = Bukkit.getWorld(strWorld);

        assert corner1 != null;
        assert corner2 != null;
        BoundingBox arenaBox = BoundingBox.of(corner1, corner2);
        arenasConfig.arenaBoxList.put(name, arenaBox);
        arenasConfig.arenaBoxListR.put(arenaBox, name);
        System.out.println("Loaded Arena | " + arenasConfig.arenaBoxList.size() + " | " + ChatColor.YELLOW + name + ChatColor.GRAY + " | With bounds " + arenaBox);


    }

}
