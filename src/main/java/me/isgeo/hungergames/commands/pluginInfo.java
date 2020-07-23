package me.isgeo.hungergames.commands;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class pluginInfo {
    public pluginInfo(Player player){

        // TODO: Find a way around the issue of requiring bungee api for chat events

//        TextComponent message1 = new TextComponent("Github");
//        TextComponent message2 = new TextComponent("Discord");
//
//        message1.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://github.com"));
//        message1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Link to Github").create()));
//        message2.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://discord.com"));
//        message2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Link to Discord").create()));

        player.sendMessage(ChatColor.GRAY + "[" + ChatColor.YELLOW + "HungerGames" + ChatColor.GRAY + "]");
        player.sendMessage(ChatColor.GRAY + "Plugin by " + ChatColor.YELLOW + "IsGeo");
        player.sendMessage(ChatColor.GRAY + "Version: " + ChatColor.YELLOW + "1.0-SNAPSHOT");
//        player.sendMessage(ChatColor.GRAY + "[" + message1 + ChatColor.GRAY + "]" + "   " + ChatColor.GRAY + "[" + message2 + ChatColor.GRAY + "]");


    }
}
