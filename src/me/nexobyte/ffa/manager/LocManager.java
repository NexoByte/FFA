/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.nexobyte.ffa.manager;

import java.io.File;
import java.io.IOException;
import me.nexobyte.ffa.FFA;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

/**
 *
 * @author Nexo
 */
public class LocManager {
    
    private final FFA plugin;
    
    public LocManager(FFA plugin) {
        this.plugin = plugin;
    }
    
    public void setLocation(Player p, String path) {
        File file = new File("plugins/" + plugin.getDescription().getName(), "locations.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        cfg.set(path + ".World", p.getWorld().getName());
        cfg.set(path + ".X", p.getLocation().getBlockX());
        cfg.set(path + ".Y", p.getLocation().getBlockY());
        cfg.set(path + ".Z", p.getLocation().getBlockZ());
        cfg.set(path + ".Yaw", p.getLocation().getYaw());
        cfg.set(path + ".Pitch", p.getLocation().getPitch());
        try {
            cfg.save(file);
        } catch (IOException e) {
            plugin.getServer().getConsoleSender().sendMessage(plugin.getPrefix() + "§cFile konnte nicht gespeichert werden");
        }
    }
    
    public Location getLocation(String path) {
        try {
            File file = new File("plugins/" + plugin.getDescription().getName(), "locations.yml");
            FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
            World world = Bukkit.getWorld(cfg.getString(path + ".World"));
            double x = cfg.getDouble(path + ".X");
            double y = cfg.getDouble(path + ".Y");
            double z = cfg.getDouble(path + ".Z");
            double yaw = cfg.getDouble(path + ".Yaw");
            double pitch = cfg.getDouble(path + ".Pitch");
            return new Location(world, x, y, z, (float)yaw, (float)pitch);
        } catch (NullPointerException e) {
            plugin.getServer().getConsoleSender().sendMessage(plugin.getPrefix() + "§cUngültige Location");
        }
        return null;
    }
    
    public void teleportLocation(Player p, String path) {
        p.teleport(getLocation(path));
    }
    
    public void teleportToSpawn(Player p) {
        p.teleport(plugin.locations.get("Spawn"));
    }
    
}
