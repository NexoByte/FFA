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
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

/**
 *
 * @author Nexo
 */
public class InventoryClickListener implements Listener {
    
    private FFA plugin;
    
    public InventoryClickListener(FFA plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    
    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        Player p = (Player)e.getWhoClicked();
        String uuid = p.getUniqueId().toString();
        if(!plugin.build.contains(p)) {
            e.setCancelled(true);
        }
        if(e.getInventory().getName().equalsIgnoreCase("§8Kit settings")) {
            if(e.getSlotType() == InventoryType.SlotType.CONTAINER) {
            if(e.getSlot() == 3) {
                Integer swordSlot = Integer.valueOf(plugin.getNexoPlayer().getCacheOf(uuid, "swordSlot"));
                if(swordSlot == 9) {
                    plugin.getNexoPlayer().setCacheOf(uuid, "swordSlot", "1");
                    plugin.getKitSettingsManager().openInventory(p);
                } else {
                    swordSlot = swordSlot+1;
                    plugin.getNexoPlayer().setCacheOf(uuid, "swordSlot", String.valueOf(swordSlot));
                    plugin.getKitSettingsManager().openInventory(p);
                }
            } else if(e.getSlot() == 8) {
                Integer rodSlot = Integer.valueOf(plugin.getNexoPlayer().getCacheOf(uuid, "rodSlot"));
                if(rodSlot == 9) {
                    plugin.getNexoPlayer().setCacheOf(uuid, "rodSlot", "1");
                    plugin.getKitSettingsManager().openInventory(p);
                } else {
                    rodSlot = rodSlot+1;
                    plugin.getNexoPlayer().setCacheOf(uuid, "rodSlot", String.valueOf(rodSlot));
                    plugin.getKitSettingsManager().openInventory(p);
                }
            } else if(e.getSlot() == 12) {
                Integer bowSlot = Integer.valueOf(plugin.getNexoPlayer().getCacheOf(uuid, "bowSlot"));
                if(bowSlot == 9) {
                    plugin.getNexoPlayer().setCacheOf(uuid, "bowSlot", "1");
                    plugin.getKitSettingsManager().openInventory(p);
                } else {
                    bowSlot = bowSlot+1;
                    plugin.getNexoPlayer().setCacheOf(uuid, "bowSlot", String.valueOf(bowSlot));
                    plugin.getKitSettingsManager().openInventory(p);
                }
            } else if(e.getSlot() == 17) {
                Integer arrowSlot = Integer.valueOf(plugin.getNexoPlayer().getCacheOf(uuid, "arrowSlot"));
                if(arrowSlot == 9) {
                    plugin.getNexoPlayer().setCacheOf(uuid, "arrowSlot", "1");
                    plugin.getKitSettingsManager().openInventory(p);
                } else {
                    arrowSlot = arrowSlot+1;
                    plugin.getNexoPlayer().setCacheOf(uuid, "arrowSlot", String.valueOf(arrowSlot));
                    plugin.getKitSettingsManager().openInventory(p);
                }
            }
        }
        } else if(e.getInventory().getName().equalsIgnoreCase("§8Settings")) {
            if(e.getSlotType() == InventoryType.SlotType.CONTAINER) {
                if(e.getSlot() == 3) {
                    boolean killMSG = Boolean.valueOf(plugin.getNexoPlayer().getCacheOf(uuid, "killMSG"));
                    if(killMSG) {
                        plugin.getNexoPlayer().setCacheOf(uuid, "killMSG", "FALSE");
                        plugin.getSettingsManager().openInventory(p);
                    } else {
                        plugin.getNexoPlayer().setCacheOf(uuid, "killMSG", "TRUE");
                        plugin.getSettingsManager().openInventory(p);
                    }
                } else if(e.getSlot() == 8) {
                    boolean deathMSG = Boolean.valueOf(plugin.getNexoPlayer().getCacheOf(uuid, "deathMSG"));
                    if(deathMSG) {
                        plugin.getNexoPlayer().setCacheOf(uuid, "deathMSG", "FALSE");
                        plugin.getSettingsManager().openInventory(p);
                    } else {
                        plugin.getNexoPlayer().setCacheOf(uuid, "deathMSG", "TRUE");
                        plugin.getSettingsManager().openInventory(p);
                    }
                } else if(e.getSlot() == 12) {
                    boolean streakMSG = Boolean.valueOf(plugin.getNexoPlayer().getCacheOf(uuid, "streakMSG"));
                    if(streakMSG) {
                        plugin.getNexoPlayer().setCacheOf(uuid, "streakMSG", "FALSE");
                        plugin.getSettingsManager().openInventory(p);
                    } else {
                        plugin.getNexoPlayer().setCacheOf(uuid, "streakMSG", "TRUE");
                        plugin.getSettingsManager().openInventory(p);
                    }
                } else if(e.getSlot() == 17) {
                    Integer killSound = Integer.valueOf(plugin.getNexoPlayer().getCacheOf(uuid, "killSound"));
                    p.closeInventory();
                    if(killSound == 5) {
                        plugin.getNexoPlayer().setCacheOf(uuid, "killSound", "1");
                        plugin.getSettingsManager().openInventory(p);
                    } else {
                        killSound = killSound+1;
                        plugin.getNexoPlayer().setCacheOf(uuid, "killSound", String.valueOf(killSound));
                        plugin.getSettingsManager().openInventory(p);
                    }
                } else if(e.getSlot() == 21) {
                    Integer deathSound = Integer.valueOf(plugin.getNexoPlayer().getCacheOf(uuid, "deathSound"));
                    if(deathSound == 5) {
                        plugin.getNexoPlayer().setCacheOf(uuid, "deathSound", "1");
                        plugin.getSettingsManager().openInventory(p);
                    } else {
                        deathSound = deathSound+1;
                        plugin.getNexoPlayer().setCacheOf(uuid, "deathSound", String.valueOf(deathSound));
                        plugin.getSettingsManager().openInventory(p);
                    }
                }
            }
        }
    }
}
