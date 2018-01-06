/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.nexobyte.ffa.manager;

import me.nexobyte.ffa.FFA;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

/**
 *
 * @author Nexo
 */
public class KitSettingsManager {
    
    private FFA plugin;
    
    public KitSettingsManager(FFA plugin) {
        this.plugin = plugin;
    }
    
    public void openInventory(Player p) {
        String uuid = p.getUniqueId().toString();
        Inventory inv = Bukkit.createInventory(null, 2*9, "§8Kit settings");
        inv.setItem(0, plugin.getKitManager().swordSlot);
        inv.setItem(3, plugin.getKitManager().heads.get(Integer.valueOf(plugin.getNexoPlayer().getCacheOf(uuid, "swordSlot"))));
        inv.setItem(5, plugin.getKitManager().rodSlot);
        inv.setItem(8, plugin.getKitManager().heads.get(Integer.valueOf(plugin.getNexoPlayer().getCacheOf(uuid, "rodSlot"))));
        inv.setItem(9, plugin.getKitManager().bowSlot);
        inv.setItem(12, plugin.getKitManager().heads.get(Integer.valueOf(plugin.getNexoPlayer().getCacheOf(uuid, "bowSlot"))));
        inv.setItem(14, plugin.getKitManager().arrowSlot);
        inv.setItem(17, plugin.getKitManager().heads.get(Integer.valueOf(plugin.getNexoPlayer().getCacheOf(uuid, "arrowSlot"))));
        p.openInventory(inv);
    }
}
