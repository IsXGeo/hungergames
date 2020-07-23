package me.isgeo.hungergames.files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class arenasConfig {

    private static File file;
    private static FileConfiguration customFile;

    // Finds or generates the custom configs
    public static void setup(String name){

        File arenasFolder = new File (Bukkit.getServer().getPluginManager().getPlugin("HungerGames").getDataFolder().getPath() + System.getProperty("file.separator") + "arenas");

        if(!arenasFolder.exists()){
            arenasFolder.mkdir();
        }

        File filePath = Bukkit.getServer().getPluginManager().getPlugin("HungerGames").getDataFolder();

        if(!filePath.exists()) {
            filePath.mkdir();
        }

        file = new File(arenasFolder.getPath() + System.getProperty("file.separator"), name + ".yml");

        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        customFile = YamlConfiguration.loadConfiguration(file);


    }

    public static FileConfiguration get(){
        return customFile;
    }

    public static void save(){
        try {
            customFile.save(file);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to save file");
        }

    }

    public static void reload(){
        customFile = YamlConfiguration.loadConfiguration(file);
    }

}
