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
import org.bukkit.event.player.PlayerMoveEvent;

/**
 *
 * @author Nexo
 */
public class MoveListener implements Listener {
    
    private final FFA plugin;
    
    public MoveListener(FFA plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    
    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if(p.getLocation().getY() < 100) {
            if(!plugin.ingame.contains(p)) {
                plugin.ingame.add(p);
                plugin.getKitManager().receiveKit(p);
            }
        } else {
            if(plugin.ingame.contains(p)) {
                plugin.ingame.remove(p);
                plugin.getKitManager().receiveSpawnItems(p);
            }
        }
    }
    
}
