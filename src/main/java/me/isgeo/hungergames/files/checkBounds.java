package me.isgeo.hungergames.files;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

public class checkBounds {

    static String HG = ChatColor.GRAY + "[" + ChatColor.YELLOW + "HG" + ChatColor.GRAY + "] ";

    public static boolean arenaContainLocation(String name, Location location) {
        double x = location.getX();
        double y = location.getY();
        double z = location.getZ();

        BoundingBox value = arenasConfig.arenaBoxList.get(name);

        System.out.println("checkBounds | " + value);

        for (BoundingBox ignored : arenasConfig.arenaBoxList.values()){
            if(value.contains(x, y, z)){
                return true;
            }
        }
        return false;
    }

    public static String getArenaName(Player player) {

        Location playerLoc = new Location(player.getLocation().getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ());
        Vector playerVec = playerLoc.toVector();

        for (BoundingBox value : arenasConfig.arenaBoxList.values()){
            if(value.contains(playerVec)){
                for (String ignored : arenasConfig.arenaBoxListR.values()){
                    return arenasConfig.arenaBoxListR.get(value);
                }
            }
        }
        player.sendMessage(HG + "No arena found!");
        return null;
    }
//    public static boolean arenaOverlap(){
//        return createArena.arenaBox.overlaps(arenaList);
//    }

    // TODO: Add checks to ensure that arena boundaries do not overlap

}

