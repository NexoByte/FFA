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
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

/**
 *
 * @author Nexo
 */
public class BuildListener implements Listener {
    
    private FFA plugin;
    
    public BuildListener(FFA plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    
    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        Player p = (Player)e.getPlayer();
        if(!plugin.build.contains(p)) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player p = (Player)e.getPlayer();
        if(!plugin.build.contains(p)) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        Player p = (Player)e.getPlayer();
        if(!plugin.build.contains(p)) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onPickup(PlayerPickupItemEvent e) {
        Player p = (Player)e.getPlayer();
        if(!plugin.build.contains(p)) {
            e.setCancelled(true);
        }
    }
    
}
