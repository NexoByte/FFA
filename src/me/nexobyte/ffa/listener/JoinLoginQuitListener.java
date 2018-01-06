/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.nexobyte.ffa.listener;

import me.nexobyte.ffa.FFA;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 *
 * @author Nexo
 */
public class JoinLoginQuitListener implements Listener {
    
    private final FFA plugin;
    
    public JoinLoginQuitListener(FFA plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        plugin.getNexoPlayer().receiveInformation(p);
        plugin.getKitManager().receiveSpawnItems(p);
        plugin.getLocManager().teleportToSpawn(p);
    }
    
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        plugin.getNexoPlayer().saveInformation(p);
        if(plugin.ingame.contains(p))plugin.ingame.remove(p);
    }
}
