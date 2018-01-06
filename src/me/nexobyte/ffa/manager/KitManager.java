/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.nexobyte.ffa.manager;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import me.nexobyte.ffa.FFA;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 *
 * @author Nexo
 */
public class KitManager {
    
    private FFA plugin;
    
    public HashMap<Integer, ItemStack> heads = new HashMap<>();
    public HashMap<String, ItemStack> otherHeads = new HashMap<>();
    
    public ItemStack stats = createItem(Material.PAPER, "§eStats", Arrays.asList(""), 1, (short) 0, false);
    public ItemStack topPlayers = createItem(Material.SKULL_ITEM, "§eTop players", Arrays.asList(""), 1, (short) 3, false);
    public ItemStack kitSettings = createItem(Material.CHEST, "§eKit settings", Arrays.asList(""), 1, (short) 0, false);
    public ItemStack settings = createItem(Material.REDSTONE_COMPARATOR, "§eSettings", Arrays.asList(""), 1, (short) 0, false);
    
    public ItemStack sword = createItem(Material.IRON_SWORD, "§eSword", Arrays.asList(""), 1, (short) 0, true);
    public ItemStack rod = createItem(Material.FISHING_ROD, "§eRod", Arrays.asList(""), 1, (short) 0, true);
    public ItemStack bow = createItem(Material.BOW, "§eBow", Arrays.asList(""), 1, (short) 0, true);
    public ItemStack arrow = createItem(Material.ARROW, "§eArrow", Arrays.asList(""), 4, (short) 0, true);
    public ItemStack helmet = createItem(Material.CHAINMAIL_HELMET, "§eHelmet", Arrays.asList(""), 1, (short) 0, true);
    public ItemStack chestplate = createItem(Material.IRON_CHESTPLATE, "§eChestplate", Arrays.asList(""), 1, (short) 0, true);
    public ItemStack leggings = createItem(Material.CHAINMAIL_LEGGINGS, "§eLeggings", Arrays.asList(""), 1, (short) 0, true);
    public ItemStack boots = createItem(Material.CHAINMAIL_BOOTS, "§eBoots", Arrays.asList(""), 1, (short) 0, true);
    
    public ItemStack swordSlot = createItem(Material.IRON_SWORD, "§eSword slot", Arrays.asList(""), 1, (short) 0, true);
    public ItemStack rodSlot = createItem(Material.FISHING_ROD, "§eRod slot", Arrays.asList(""), 1, (short) 0, true);
    public ItemStack bowSlot = createItem(Material.BOW, "§eBow slot", Arrays.asList(""), 1, (short) 0, true);
    public ItemStack arrowSlot = createItem(Material.ARROW, "§eArrow slot", Arrays.asList(""), 1, (short) 0, true);
    
    public ItemStack killMSG = createItem(Material.WATER_BUCKET, "§eKill messages", Arrays.asList(""), 1, (short) 0, false);
    public ItemStack deathMSG = createItem(Material.POTION, "§eDeath messages", Arrays.asList(""), 1, (short) 1, false);
    public ItemStack streakMSG = createItem(Material.DIAMOND_SWORD, "§eStreak messages", Arrays.asList(""), 1, (short) 0, false);
    public ItemStack killSound = createItem(Material.REDSTONE, "§eKill sound", Arrays.asList(""), 1, (short) 0, false);
    public ItemStack deathSound = createItem(Material.APPLE, "§eDeath sound ", Arrays.asList(""), 1, (short) 0, false);
    
    public ItemStack numberOne = createHead("§eSlot 1", "http://textures.minecraft.net/texture/71bc2bcfb2bd3759e6b1e86fc7a79585e1127dd357fc202893f9de241bc9e530");
    public ItemStack numberTwo = createHead("§eSlot 2", "http://textures.minecraft.net/texture/4cd9eeee883468881d83848a46bf3012485c23f75753b8fbe8487341419847");
    public ItemStack numberThree = createHead("§eSlot 3", "http://textures.minecraft.net/texture/1d4eae13933860a6df5e8e955693b95a8c3b15c36b8b587532ac0996bc37e5");
    public ItemStack numberFour = createHead("§eSlot 4", "http://textures.minecraft.net/texture/d2e78fb22424232dc27b81fbcb47fd24c1acf76098753f2d9c28598287db5");
    public ItemStack numberFive = createHead("§eSlot 5", "http://textures.minecraft.net/texture/6d57e3bc88a65730e31a14e3f41e038a5ecf0891a6c243643b8e5476ae2");
    public ItemStack numberSix = createHead("§eSlot 6", "http://textures.minecraft.net/texture/334b36de7d679b8bbc725499adaef24dc518f5ae23e716981e1dcc6b2720ab");
    public ItemStack numberSeven = createHead("§eSlot 7", "http://textures.minecraft.net/texture/6db6eb25d1faabe30cf444dc633b5832475e38096b7e2402a3ec476dd7b9");
    public ItemStack numberEight = createHead("§eSlot 8", "http://textures.minecraft.net/texture/59194973a3f17bda9978ed6273383997222774b454386c8319c04f1f4f74c2b5");
    public ItemStack numberNine = createHead("§eSlot 9", "http://textures.minecraft.net/texture/e67caf7591b38e125a8017d58cfc6433bfaf84cd499d794f41d10bff2e5b840");
    
    public ItemStack activeHead = createHead("§aActivated", "http://textures.minecraft.net/texture/ebc37c9b37f4df36e4e50435fd41ecd6a7a711d11b91a6e507d285e8e85bd");
    public ItemStack deactiveHead = createHead("§cDeactivated", "http://textures.minecraft.net/texture/3cc470ae2631efdfaf967b369413bc2451cd7a39465da7836a6c7a14e877");
    
    public KitManager(FFA plugin) {
        this.plugin = plugin;
        heads.put(1, numberOne);
        heads.put(2, numberTwo);
        heads.put(3, numberThree);
        heads.put(4, numberFour);
        heads.put(5, numberFive);
        heads.put(6, numberSix);
        heads.put(7, numberSeven);
        heads.put(8, numberEight);
        heads.put(9, numberNine);
        otherHeads.put("TRUE", activeHead);
        otherHeads.put("FALSE", deactiveHead);
    }
    
    public ItemStack createItem(Material material, String name, List<String> lore, int amount, short id, boolean unbreakable) {
        ItemStack itemStack = new ItemStack(material, amount, id);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemMeta.setLore(lore);
        itemMeta.spigot().setUnbreakable(unbreakable);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    
    public ItemStack createHead(String name, String url) {
        ItemStack itemStack = SkullManager.getSkull(url);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    
    public void receiveSpawnItems(Player p) {
        p.getInventory().clear();
        p.getInventory().setArmorContents(null);
        p.setExp(0);
        p.setLevel(0);
        p.setFireTicks(0);
        p.getInventory().setItem(1, stats);
        p.getInventory().setItem(3, topPlayers);
        p.getInventory().setItem(5, kitSettings);
        p.getInventory().setItem(7, settings);
    }
    
    public void receiveSpawnItemsAll() {
        Bukkit.getOnlinePlayers().forEach(all -> {
            all.getInventory().clear();
            all.getInventory().setArmorContents(null);
            all.setExp(0);
            all.setLevel(0);
            all.setFireTicks(0);
            all.getInventory().setItem(1, stats);
            all.getInventory().setItem(3, topPlayers);
            all.getInventory().setItem(5, kitSettings);
            all.getInventory().setItem(7, settings);
        });
    }
    
    public void receiveKit(Player p) {
        String uuid = p.getUniqueId().toString();
        p.getInventory().clear();
        p.getInventory().setArmorContents(null);
        p.setExp(0);
        p.setLevel(0);
        p.setFireTicks(0);
        p.getInventory().setHelmet(helmet);
        p.getInventory().setChestplate(chestplate);
        p.getInventory().setLeggings(leggings);
        p.getInventory().setBoots(boots);
        p.getInventory().setItem(Integer.valueOf(plugin.getNexoPlayer().getCacheOf(uuid, "swordSlot")) -1, sword);
        p.getInventory().setItem(Integer.valueOf(plugin.getNexoPlayer().getCacheOf(uuid, "rodSlot")) -1, rod);
        p.getInventory().setItem(Integer.valueOf(plugin.getNexoPlayer().getCacheOf(uuid, "bowSlot")) -1, bow);
        p.getInventory().setItem(Integer.valueOf(plugin.getNexoPlayer().getCacheOf(uuid, "arrowSlot")) -1, arrow);
    }
    
    public void receiveKitAll() {
        Bukkit.getOnlinePlayers().forEach(all -> {
            String uuid = all.getUniqueId().toString();
            all.getInventory().clear();
            all.getInventory().setArmorContents(null);
            all.setExp(0);
            all.setLevel(0);
            all.setFireTicks(0);
            all.getInventory().setHelmet(helmet);
            all.getInventory().setChestplate(chestplate);
            all.getInventory().setLeggings(leggings);
            all.getInventory().setBoots(boots);
            all.getInventory().setItem(Integer.valueOf(plugin.getNexoPlayer().getCacheOf(uuid, "swordSlot")) -1, sword);
            all.getInventory().setItem(Integer.valueOf(plugin.getNexoPlayer().getCacheOf(uuid, "rodSlot")) -1, rod);
            all.getInventory().setItem(Integer.valueOf(plugin.getNexoPlayer().getCacheOf(uuid, "bowSlot")) -1, bow);
            all.getInventory().setItem(Integer.valueOf(plugin.getNexoPlayer().getCacheOf(uuid, "arrowSlot")) -1, arrow);
        });
    }
    
}
