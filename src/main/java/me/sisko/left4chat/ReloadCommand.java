package me.sisko.left4chat;

import me.sisko.left4chat.ConfigManager;
import me.sisko.left4chat.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand
implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            sender.sendMessage((Object)ChatColor.RED + "You don't have permission to do that!");
        } else {
            ConfigManager.reload();
            Main.getPlugin().getLogger().info("Config and database has been reloaded");
        }
        return true;
    }
}

