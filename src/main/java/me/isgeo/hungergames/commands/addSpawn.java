package me.isgeo.hungergames.commands;

import me.isgeo.hungergames.files.arenasConfig;
import me.isgeo.hungergames.files.checkBounds;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import static me.isgeo.hungergames.files.arenasConfig.*;

public class addSpawn {

    public addSpawn(Player player){

        String CON = ChatColor.WHITE + "[" + ChatColor.YELLOW + "HG" + ChatColor.WHITE + "] " + ChatColor.RED;
        String HG = ChatColor.GRAY + "[" + ChatColor.YELLOW + "HG" + ChatColor.GRAY + "] ";

        Location loc = new Location(player.getLocation().getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), player.getLocation().getYaw(), player.getLocation().getPitch());
        boolean onlyOnce = false;



        String arena = checkBounds.getArenaName(player);

        // TODO: Rewrite addSpawn.java to save locations in a separate array within the hashmap
        if(arena != null) {
            for (String name : arenaBoxList.keySet()) {
                if (name.equalsIgnoreCase(arena)) {
                    if (checkBounds.arenaContainLocation(arena, loc)) {

                        System.out.println(CON + "First" + spawns);

                        spawns.add(loc);

                        System.out.println(CON + "Second" + spawns);

                        int size = spawns.size();

                        String path = "spawns.".concat(Integer.toString(size));

                        player.sendMessage(HG + "Added spawn " + ChatColor.YELLOW + size);

                        arenasConfig.get().addDefault(path, loc);
                        arenasConfig.get().options().copyDefaults(true);
                        arenasConfig.save();

                        System.out.println(CON + "First" + spawnLocations);
                        spawnLocations.put(arena, spawns);
                        System.out.println(CON + "Second" + spawnLocations);

                        // Old System that doesn't work

                        /**int size = 0;
                        player.sendMessage(HG + ChatColor.YELLOW + arena + ChatColor.GRAY + " arena: " + ChatColor.GRAY + "Spawn position added");
                        arenasConfig.spawnLocations.put(arena, loc);
                        System.out.println(size);

                        System.out.println(arenasConfig.spawnLocations);
                        System.out.println(arenasConfig.spawnLocations.size());
                        for (String value : arenasConfig.spawnLocations.keySet()) {
                            if (value.equals(arena)) {
                                System.out.println(arena + " | " + value + " | " + size);
                                size++;
                                System.out.println("[2]" + arena + " | " + value + " | " + size);
                            }
                        }
                        String path = "spawns.".concat(Integer.toString(size));

                        System.out.println("Added new spawn | " + path + " | " + ChatColor.YELLOW + arena);

                        arenasConfig.get().addDefault(path, loc);
                        arenasConfig.get().options().copyDefaults(true);
                        arenasConfig.save();

                        System.out.println(size);
                        size++;

                        System.out.println(size);
                         **/
                    } else {
                        player.sendMessage(HG + "Spawn outside bounds of Arena");
                    }
                } else {
                    if (!onlyOnce) {
                        player.sendMessage(HG + "Invalid arena");
                    }

                }
            }
        }else{
            player.sendMessage(HG + "Please create the arena before adding spawns!");
        }




    }

}
