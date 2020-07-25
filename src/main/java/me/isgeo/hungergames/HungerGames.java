package me.isgeo.hungergames;

import me.isgeo.hungergames.commands.hgcmd;
import me.isgeo.hungergames.files.arenasConfig;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class HungerGames extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Objects.requireNonNull(getCommand("hg")).setExecutor(new hgcmd());

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        arenasConfig.load();

    }

}
