package com.mordonia.mcore.mchat.util.playerData;

import com.mordonia.mcore.MCore;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class FileConfig {

    public static JavaPlugin plugin = MCore.getProvidingPlugin(MCore.class);

    public static File lastNames = new File(plugin.getDataFolder(), "lastnames.yml");
    public static FileConfiguration lastNamesCfg = YamlConfiguration.loadConfiguration(lastNames);
    public static File messages = new File(plugin.getDataFolder(), "messages.yml");
    public static FileConfiguration messagesCfg = YamlConfiguration.loadConfiguration(messages);

    public static void createFile(){
        if(!lastNames.exists()){
            plugin.saveResource("lastnames.yml", false);
        }
        if(!messages.exists()){
            plugin.saveResource("messages.yml", false);
        }
    }

    public static FileConfiguration getLastNamesCfg(){
        return lastNamesCfg;
    }

    public static FileConfiguration getMessagesCfg(){
        return messagesCfg;
    }


}
