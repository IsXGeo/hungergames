package me.isgeo.hungergames.commands;

import me.isgeo.hungergames.files.arenasConfig;
import me.isgeo.hungergames.files.checkBounds;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;

import static me.isgeo.hungergames.files.arenasConfig.save;
import static me.isgeo.hungergames.files.arenasConfig.spawnLocations;

public class addSpawn {

    public addSpawn(Player player){

        String CON = ChatColor.WHITE + "[" + ChatColor.YELLOW + "HG" + ChatColor.WHITE + "] " + ChatColor.RED;
        String HG = ChatColor.GRAY + "[" + ChatColor.YELLOW + "HG" + ChatColor.GRAY + "] ";

        Location loc = new Location(player.getLocation().getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), player.getLocation().getYaw(), player.getLocation().getPitch());
        ArrayList<Location> spawns = new ArrayList<>();

        String arena = checkBounds.getArenaName(player);

        if(arena != null) {
            if (checkBounds.arenaContainLocation(arena, loc)) {
                if(spawnLocations.get(arena) != null) {

                    ArrayList<ArrayList> temp = new ArrayList<>();
                    temp.add(spawnLocations.get(arena));

                    System.out.println(CON + temp);

                    int size = spawnLocations.get(arena).size();
                    String path = "spawns.".concat(Integer.toString(size));

                    for(int i = 0; i < temp.size() ; i++){
                        for(int j = 0; j < temp.get(i).size(); j++){
                            System.out.println(CON + temp + " | " + j);
                        }
                    }

                    player.sendMessage(HG + "Added spawn " + ChatColor.YELLOW + size);

                    arenasConfig.get().addDefault(path, loc);

                }else{
                    int size = 1;
                    String path = "spawns.".concat(Integer.toString(size));

                    player.sendMessage(HG + "Added spawn " + ChatColor.YELLOW + size);

                    spawns.add(loc);

                    arenasConfig.get().addDefault(path, loc);

                }
                arenasConfig.get().options().copyDefaults(true);
                save();
                System.out.println(CON + "First" + spawnLocations);
                spawnLocations.put(arena, spawns);
                System.out.println(CON + "Second" + spawnLocations);

            } else {
                System.out.println(CON + "checkBounds arenaContainLocation was false");
            }

        }else{
            player.sendMessage(HG + "Spawn outside bounds of Arena");
        }

    }

}
