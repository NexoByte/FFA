/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.nexobyte.ffa;

import java.util.ArrayList;
import java.util.HashMap;
import me.nexobyte.ffa.commands.BuildCommand;
import me.nexobyte.ffa.commands.SetSpawnCommand;
import me.nexobyte.ffa.listener.BuildListener;
import me.nexobyte.ffa.listener.InteractListener;
import me.nexobyte.ffa.listener.InventoryClickListener;
import me.nexobyte.ffa.listener.JoinLoginQuitListener;
import me.nexobyte.ffa.listener.MoveListener;
import me.nexobyte.ffa.manager.KitManager;
import me.nexobyte.ffa.manager.KitSettingsManager;
import me.nexobyte.ffa.manager.LocManager;
import me.nexobyte.ffa.manager.SQLManager;
import me.nexobyte.ffa.manager.SettingsManager;
import me.nexobyte.ffa.player.NexoPlayer;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Nexo
 */
public class FFA extends JavaPlugin {
    
    public String prefix, noperms, console;
    
    public ArrayList<Player> build = new ArrayList<>();
    public ArrayList<Player> ingame = new ArrayList<>();
    public HashMap<String, Location> locations = new HashMap<>();
    
    private KitManager kitManager;
    private KitSettingsManager kitSettingsManager;
    private LocManager locManager;
    private SQLManager sqlManager;
    private SettingsManager settingsManager;
    
    private JoinLoginQuitListener joinLoginQuitListener;
    private InteractListener interactListener;
    private InventoryClickListener inventoryClickListener;
    private MoveListener moveListener;
    private BuildListener buildListener;
    
    private SetSpawnCommand setSpawnCommand;
    private BuildCommand buildCommand;
    
    private NexoPlayer nexoPlayer;
    
    
    @Override
    public void onEnable() {
        this.sqlManager = new SQLManager(this);
        this.sqlManager.openConnection("ms1127.nitrado.net", "ni131303_1_DB", "ni131303_1_DB", "Test123", 3306);
        this.createTables();
        this.init();
    }

    @Override
    public void onDisable() {
        
    }
    
    private void init() {
        this.prefix = "§8[§dFFA§8] §r";
        this.noperms = this.prefix + "§cBefehl wurde nicht gefunden.";
        this.console = this.prefix + "§cNicht für die Konsole.";
        
        this.kitManager = new KitManager(this);
        this.settingsManager = new SettingsManager(this);
        this.kitSettingsManager = new KitSettingsManager(this);
        this.locManager = new LocManager(this);
        
        this.interactListener = new InteractListener(this);
        this.inventoryClickListener = new InventoryClickListener(this);
        this.joinLoginQuitListener = new JoinLoginQuitListener(this);
        this.moveListener = new MoveListener(this);
        this.buildListener = new BuildListener(this);
        this.buildCommand = new BuildCommand(this);
        
        this.setSpawnCommand = new SetSpawnCommand(this);
        
        this.nexoPlayer = new NexoPlayer(this);
        
        this.locations.put("Spawn", this.getLocManager().getLocation("Spawn"));
        
    }
    
    private void createTables() {
        // uuid, lastName, lastIP, kills, deahts, points
        this.getSQLManager().update("CREATE TABLE IF NOT EXISTS ffaUsers (uuid VARCHAR(64), lastName VARCHAR(64), lastIP VARCHAR(64), kills BIGINT, deaths BIGINT, points BIGINT)");
        // uuid, swordSlot, rodSlot, bowSlot, arrowSlot, killMSG, deathMSG, streakMSG, killSound, deathSound
        this.getSQLManager().update("CREATE TABLE IF NOT EXISTS settings (uuid VARCHAR(64), swordSlot INT, rodSlot INT, bowSlot INT, arrowSlot INT, killMSG VARCHAR(64), deathMSG VARCHAR(64), streakMSG VARCHAR(64), killSound VARCHAR(64), deathSound VARCHAR(64))");
    }

    public String getPrefix() {
        return prefix;
    }

    public String getNoPerms() {
        return noperms;
    }

    public String getConsole() {
        return console;
    }

    public KitManager getKitManager() {
        return kitManager;
    }

    public KitSettingsManager getKitSettingsManager() {
        return kitSettingsManager;
    }

    public LocManager getLocManager() {
        return locManager;
    }

    public SQLManager getSQLManager() {
        return sqlManager;
    } 

    public SettingsManager getSettingsManager() {
        return settingsManager;
    }

    public NexoPlayer getNexoPlayer() {
        return nexoPlayer;
    }
}
