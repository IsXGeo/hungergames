package me.isgeo.hungergames.files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.util.BoundingBox;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
public class arenasConfig {

    private static File file;
    private static FileConfiguration customFile;

    private static final File arenasFolder = new File (Bukkit.getServer().getPluginManager().getPlugin("HungerGames").getDataFolder().getPath() + System.getProperty("file.separator") + "arenas");

    public static ArrayList<File> fileList = new ArrayList<>();
    public static HashMap<String, BoundingBox> arenaBoxList = new HashMap<>();
    public static HashMap<BoundingBox, String> arenaBoxListR = new HashMap<>();

    // TODO: Find a way to load already created config files and get their data into memory
    public static void setup(String name){

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

    public static void load(){

        File[] listOfFiles = arenasFolder.listFiles();

        if(listOfFiles != null){
            for(File file : listOfFiles){
                if (file.isFile()) {
                    fileList.add(file);
                    loadArenas.loadArena(file);
                }
            }
        }else{
            System.out.println("[HG] No arenas found!");
        }
    }

    public static FileConfiguration get(){
        return customFile;
    }

    public static File getSpec(String name){
        if(fileList.size() > 0) {
            for (File file : fileList) {
                if (file.getName().equalsIgnoreCase(name)) {
                    return file;
                }
            }
        }
        return null;
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
