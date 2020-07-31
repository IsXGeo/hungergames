package me.isgeo.hungergames.commands;

import me.isgeo.hungergames.files.arenasConfig;
import me.isgeo.hungergames.files.checkBounds;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import static me.isgeo.hungergames.files.arenasConfig.spawns;

public class addSpawn {

    public addSpawn(Player player){

        String HG = ChatColor.GRAY + "[" + ChatColor.YELLOW + "HG" + ChatColor.GRAY + "] " + ChatColor.RED;

        Location loc = new Location(player.getLocation().getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), player.getLocation().getYaw(), player.getLocation().getPitch());
        boolean onlyOnce = false;



        String arena = checkBounds.getArenaName(player);

        // TODO: Rewrite addSpawn.java to save locations in a separate array within the hashmap
        if(arena != null) {
            for (String name : arenasConfig.arenaBoxList.keySet()) {
                if (name.equalsIgnoreCase(arena)) {
                    if (checkBounds.arenaContainLocation(arena, loc)) {

                        boolean match = false;

                        for (Location i : spawns){
                            if(loc == i){
                                match = true;
                                System.out.println(HG + "Match Found | Adding location to spawns Array");
                            }else{
                                System.out.println(HG + "No match");
                            }
                        }

                        if(!match){
                            spawns.add(loc);
                        }


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
