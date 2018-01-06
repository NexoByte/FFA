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
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 *
 * @author Nexo
 */
public class InteractListener implements Listener {
    
    private FFA plugin;
    
    public InteractListener(FFA plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    
    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = (Player)e.getPlayer();
        try{
            if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK 
                && e.getItem() != null && e.getItem().getItemMeta() != null && e.getItem().getItemMeta().getDisplayName() != null) {
            if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eSettings")) {
                plugin.getSettingsManager().openInventory(p);
            } else if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eKit settings")) {
                plugin.getKitSettingsManager().openInventory(p);
            }
            }
        } catch (NullPointerException ex) {}
    } 
}
