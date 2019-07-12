package me.sisko.left4chat;

import java.io.File;
import me.sisko.left4chat.Main;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {
    public static void load() {
        FileConfiguration config = Main.getPlugin().getConfig();
        File dataFolder = Main.getPlugin().getDataFolder();
        config.addDefault("sql.host", "127.0.0.1");
        config.addDefault("sql.database", "data");
        config.addDefault("sql.port", 3306);
        config.addDefault("sql.user", "user");
        config.addDefault("sql.pass", "password");
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }
        if (!new File(dataFolder, "config.yml").exists()) {
            Main.getPlugin().getLogger().info("Config.yml not found, creating!");
            config.options().copyDefaults(true);
            Main.getPlugin().saveConfig();
        } else {
            Main.getPlugin().getLogger().info("Config.yml found, loading!");
        }
    }

    public static void reload() {
        Main.getPlugin().reloadConfig();
        Main.ReconnectSQL();
    }
}

