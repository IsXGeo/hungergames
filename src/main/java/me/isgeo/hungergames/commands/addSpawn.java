package me.isgeo.hungergames.commands;

import me.isgeo.hungergames.files.arenasConfig;
import me.isgeo.hungergames.files.checkBounds;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class addSpawn {

    public static HashMap<String, Location> spawnLoc = new HashMap<>();

    public addSpawn(Player player){

        String HG = ChatColor.GRAY + "[" + ChatColor.YELLOW + "HG" + ChatColor.GRAY + "] " + ChatColor.RED;

        Location loc = new Location(player.getLocation().getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ());
        boolean onlyOnce = false;
        int size = 0;

        String arena = checkBounds.getArenaName(player);

        // TODO: Stop the addspawn class overwriting itself each time a user runs the command
        if(arena != null) {
            for (String name : arenasConfig.arenaBoxList.keySet()) {
                if (name.equalsIgnoreCase(arena)) {
                    if (checkBounds.arenaContainLocation(arena, loc)) {
                        spawnLoc.put(arena, loc);
                        player.sendMessage(HG + ChatColor.YELLOW + arena + ChatColor.GRAY + " arena: " + ChatColor.GRAY + "Spawn position added");

                        for (String value : spawnLoc.keySet()) {
                            if (value.equals(arena)) {
                                size++;
                            }
                        }
                        System.out.println(size);
                        String path = "spawns.".concat(Integer.toString(size));

                        System.out.println(path + " || " + loc);
                        System.out.println("Added new spawn | " + size + " | " + ChatColor.YELLOW + arena);

                        arenasConfig.get().addDefault(path, loc);
                        arenasConfig.get().options().copyDefaults(true);
                        arenasConfig.save();

                        size++;
                    } else {
                        player.sendMessage(HG + "Spawn outside bounds of Arena");
                    }
                } else {
                    if (!onlyOnce) {
                        player.sendMessage(HG + "Invalid arena");
                    }

                }
                System.out.println(arena + " || " + name + " || " + spawnLoc.size());
            }
        }else{
            player.sendMessage(HG + "Please create the arena before adding spawns!");
        }




    }

}
