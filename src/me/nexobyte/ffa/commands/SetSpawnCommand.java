/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.nexobyte.ffa.commands;

import me.nexobyte.ffa.FFA;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 *
 * @author Nexo
 */
public class SetSpawnCommand implements CommandExecutor {

    private final FFA plugin;
    
    public SetSpawnCommand(FFA plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("setSpawn").setExecutor(this);
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        
        if(!(sender instanceof Player)) {
            sender.sendMessage(plugin.getConsole());
            return false;
        }
        
        Player p = (Player)sender;
        
        if(!p.isOp()) {
            p.sendMessage(plugin.getNoPerms());
            return false;
        }
        
        if(args.length == 0) {
            plugin.getLocManager().setLocation(p, "Spawn");
            plugin.locations.put("Spawn", p.getLocation());
            p.sendMessage(plugin.getPrefix() + "§3Der Spawn wurde §eerfolgreich §3gesetzt");
        }
        
        return true;
    }
    
    
    
}
