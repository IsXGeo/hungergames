package me.isgeo.hungergames.commands;

import me.isgeo.hungergames.HungerGames;
import me.isgeo.hungergames.files.arenasConfig;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class createArena {

    Plugin plugin = HungerGames.getPlugin(HungerGames.class);

    public createArena(Player player, String name, Integer length) {

        String world = (String) plugin.getConfig().get("temp.world");
        String HG = ChatColor.GRAY + "[" + ChatColor.YELLOW + "HG" + ChatColor.GRAY + "]";

        assert world != null;
        if (!world.equals("zero")) {
            player.sendMessage(HG + "Created arena with name " + ChatColor.YELLOW + name + ChatColor.GRAY + " in world " + ChatColor.YELLOW + world);

            arenasConfig.setup(name);
            arenasConfig.get().addDefault("world", world);
            arenasConfig.get().addDefault("length:", length);
            arenasConfig.get().addDefault("bounds.x", plugin.getConfig().get("temp.x"));
            arenasConfig.get().addDefault("bounds.y", plugin.getConfig().get("temp.y"));
            arenasConfig.get().addDefault("bounds.z", plugin.getConfig().get("temp.z"));

            arenasConfig.get().addDefault("bounds.x2", plugin.getConfig().get("temp.x2"));
            arenasConfig.get().addDefault("bounds.y2", plugin.getConfig().get("temp.y2"));
            arenasConfig.get().addDefault("bounds.z2", plugin.getConfig().get("temp.z2"));
            arenasConfig.get().options().copyDefaults(true);
            arenasConfig.save();

        }else{
            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.YELLOW + "HG" + ChatColor.GRAY + "]" + ChatColor.RED + " Please set bounds for arena first!");
        }

    }
}
