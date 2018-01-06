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
public class BuildCommand implements CommandExecutor {

    private final FFA plugin;
    
    public BuildCommand(FFA plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("build").setExecutor(this);
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
            if(plugin.build.contains(p)) {
                p.sendMessage(plugin.getPrefix() + "§3Der Baumodus wurde §eerfolgreich §3deaktiviert");
                plugin.build.remove(p);
            } else {
                p.sendMessage(plugin.getPrefix() + "§3Der Baumodus wurde §eerfolgreich §3aktiviert");
                plugin.build.add(p);
            }
        }
        
        return true;
    }
    
    
    
}
