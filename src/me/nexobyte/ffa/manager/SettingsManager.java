/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.nexobyte.ffa.manager;

import me.nexobyte.ffa.FFA;
import me.nexobyte.ffa.sounds.Sounds;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

/**
 *
 * @author Nexo
 */
public class SettingsManager {
    
    private FFA plugin;
    
    public SettingsManager(FFA plugin) {
        this.plugin = plugin;
    }
    
    public void openInventory(Player p) {
        String uuid = p.getUniqueId().toString();
        Inventory inv = Bukkit.createInventory(null, 3*9, "§8Settings");
        inv.setItem(0, plugin.getKitManager().killMSG);
        inv.setItem(3, plugin.getKitManager().otherHeads.get(plugin.getNexoPlayer().getCacheOf(uuid, "killMSG")));
        inv.setItem(5, plugin.getKitManager().deathMSG);
        inv.setItem(8, plugin.getKitManager().otherHeads.get(plugin.getNexoPlayer().getCacheOf(uuid, "deathMSG")));
        inv.setItem(9, plugin.getKitManager().streakMSG);
        inv.setItem(12, plugin.getKitManager().otherHeads.get(plugin.getNexoPlayer().getCacheOf(uuid, "streakMSG")));
        inv.setItem(14, plugin.getKitManager().killSound);
        int killSound = Integer.valueOf(plugin.getNexoPlayer().getCacheOf(uuid, "killSound"));
        inv.setItem(17, plugin.getKitManager().createHead("§d" + Sounds.getSoundById(killSound).getSoundName(), Sounds.getSoundById(killSound).getUrl()));
        inv.setItem(18, plugin.getKitManager().deathSound);
        int deathSound = Integer.valueOf(plugin.getNexoPlayer().getCacheOf(uuid, "deathSound"));
        inv.setItem(21, plugin.getKitManager().createHead("§d" + Sounds.getSoundById(deathSound).getSoundName(), Sounds.getSoundById(deathSound).getUrl()));
        p.openInventory(inv);
    }
    
    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        Player p = (Player)e.getWhoClicked();
        String uuid = p.getUniqueId().toString();
        if(!plugin.build.contains(p)) {
            e.setCancelled(true);
        }
    }
}
