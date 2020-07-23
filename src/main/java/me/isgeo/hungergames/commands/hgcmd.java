package me.isgeo.hungergames.commands;

import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class hgcmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String HG = ChatColor.GRAY + "[" + ChatColor.YELLOW + "HG" + ChatColor.GRAY + "]";
        String unknownArgue = HG + ChatColor.RED + " Insufficient arguments";

        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(args.length == 0){
                new help(player);
                return true;
            }

            if(args[0].equalsIgnoreCase("help")) {
                new help(player);
                return true;
            }
            if(args[0].equalsIgnoreCase("arena")) {
                if (args.length >= 2) {
                    if (args[1].equalsIgnoreCase("create")) {
                        if(args.length >= 4) {
                            if(StringUtils.isNumeric(args[3])){
                                new createArena(player, args[2], Integer.parseInt(args[3]));
                            }else{
                                player.sendMessage(unknownArgue);
                            }
                            return true;
                        }
                    }else if(args[1].equalsIgnoreCase("pos1")) {
                        new setArenaPos(player, 1);
                        return true;
                    }else if(args[1].equalsIgnoreCase("pos2")) {
                        new setArenaPos(player, 2);
                        return true;
                    }
                    player.sendMessage(unknownArgue);
                    return true;
                }
                player.sendMessage(unknownArgue);
                return true;
            }else if(args[0].equalsIgnoreCase("info")) {
                new pluginInfo(player);
                return true;
            }else if(args[0].equalsIgnoreCase("addspawn")) {
                new addSpawn(player);
                return true;
            }else if(args[0].equalsIgnoreCase("getspawns")) {
                if(args.length >= 2){
                    if(StringUtils.isNumeric(args[1])){
                        new getSpawns(player, Integer.parseInt(args[1]));
                    }else{
                        player.sendMessage(unknownArgue);
                    }
                }else{
                    player.sendMessage(unknownArgue);
                }
                return true;
            }

            player.sendMessage(unknownArgue);
            return true;
        }else{
            System.out.println(ChatColor.RED + "You must be a player to execute this command.");
        }
    return false;
    }

}

