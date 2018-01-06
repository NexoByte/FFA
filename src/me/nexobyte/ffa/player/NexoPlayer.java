/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.nexobyte.ffa.player;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.function.Consumer;
import me.nexobyte.ffa.FFA;
import org.bukkit.entity.Player;

/**
 *
 * @author Nexo
 */
public class NexoPlayer {
    
    private final FFA plugin; 
    
    public NexoPlayer(FFA plugin) {
        this.plugin = plugin;
    }
    
    public HashMap<String, String> cache = new HashMap<>();
    
    public void receiveInformation(Player p) {
        String uuid = p.getUniqueId().toString();
        createFFAPlayer(p);
        createSettingsPlayer(p);
    }
    
    public void saveInformation(Player p) {
        String uuid = p.getUniqueId().toString();
        String lastName = getCacheOf(uuid, "lastName");
        String lastIP = getCacheOf(uuid, "lastIP");
        Long kills = Long.valueOf(getCacheOf(uuid, "kills"));
        Long deaths = Long.valueOf(getCacheOf(uuid, "deaths"));
        Long points = Long.valueOf(getCacheOf(uuid, "points"));
        plugin.getSQLManager().update("UPDATE ffaUsers SET lastName='" + lastName + "', lastIP='" + lastIP + "', kills='" + kills + "', deaths='" + deaths + "', points='" + points + "' WHERE uuid='" + uuid + "'");
        Integer swordSlot = Integer.valueOf(getCacheOf(uuid, "swordSlot"));
        Integer rodSlot = Integer.valueOf(getCacheOf(uuid, "rodSlot"));
        Integer bowSlot = Integer.valueOf(getCacheOf(uuid, "bowSlot"));
        Integer arrowSlot = Integer.valueOf(getCacheOf(uuid, "arrowSlot"));
        String killMSG = getCacheOf(uuid, "killMSG");
        String deathMSG = getCacheOf(uuid, "deathMSG");
        String streakMSG = getCacheOf(uuid, "streakMSG");
        String killSound = getCacheOf(uuid, "killSound");
        String deathSound = getCacheOf(uuid, "deathSound");
        plugin.getSQLManager().update("UPDATE settings SET swordSlot='" + swordSlot + "', rodSlot='" + rodSlot + "', bowSlot='" + bowSlot + "', arrowSlot='" + arrowSlot + "', killMSG='" + killMSG + "', deathMSG='" + deathMSG + "', streakMSG='" + streakMSG + "', killSound='" + killSound + "', deathSound='" + deathSound + "' WHERE uuid='" + uuid + "'");
        removeCache(uuid);
    }
    
    public void doesFFAPlayerExists(String uuid, Consumer<Boolean> consumer) {
        plugin.getSQLManager().query("SELECT * FROM ffaUsers WHERE uuid='" + uuid + "'", result -> {
            try {
                consumer.accept(result.next());
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    result.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }   
    
    public void doesSettingsPlayerExists(String uuid, Consumer<Boolean> consumer) {
        plugin.getSQLManager().query("SELECT * FROM settings WHERE uuid='" + uuid + "'", result -> {
            try {
                consumer.accept(result.next());
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    result.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
        public void createFFAPlayer(Player p) {
        String uuid = p.getUniqueId().toString();
        doesFFAPlayerExists(p.getUniqueId().toString(), result -> {
            if(!result) {
                plugin.getSQLManager().update("INSERT INTO ffaUsers VALUES ('" + p.getUniqueId().toString()+"', '" + p.getName() + "', '" + p.getAddress().getAddress().getHostAddress() + "', '0', '0', '1000')");
                cache.put(uuid + "lastName", p.getName());
                cache.put(uuid + "lastIP", p.getAddress().getAddress().getHostAddress());
                cache.put(uuid + "kills", "0");
                cache.put(uuid + "deaths", "0");
                cache.put(uuid + "points", "1000");
            } else {
                plugin.getSQLManager().query("SELECT * FROM ffaUsers WHERE uuid='" + uuid + "'", rs -> {
                    try {
                        rs.next();
                        cache.put(uuid + "lastName", p.getName());
                        cache.put(uuid + "lastIP", p.getAddress().getAddress().getHostAddress());
                        cache.put(uuid + "kills", String.valueOf(rs.getLong("kills")));
                        cache.put(uuid + "deaths", String.valueOf(rs.getLong("deaths")));
                        cache.put(uuid + "points", String.valueOf(rs.getLong("points")));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                });
            }
        });
    }
    
    public void createSettingsPlayer(Player p) {
        String uuid = p.getUniqueId().toString();
        doesSettingsPlayerExists(p.getUniqueId().toString(), result -> {
            if(!result) {
                plugin.getSQLManager().update("INSERT INTO settings VALUES ('" + p.getUniqueId().toString() + "', '1', '2', '3', '4', 'TRUE', 'TRUE', 'TRUE', '1', '1')");
                cache.put(uuid + "swordSlot", "1");
                cache.put(uuid + "rodSlot", "2");
                cache.put(uuid + "bowSlot", "3");
                cache.put(uuid + "arrowSlot", "4");
                cache.put(uuid + "killMSG", "TRUE");
                cache.put(uuid + "deathMSG", "TRUE");
                cache.put(uuid + "streakMSG", "TRUE");
                cache.put(uuid + "killSound", "1");
                cache.put(uuid + "deathSound", "1");     
            } else {
                plugin.getSQLManager().query("SELECT * FROM settings WHERE uuid='" + uuid + "'", rs -> {
                    try {
                        rs.next();
                        cache.put(uuid + "swordSlot", String.valueOf(rs.getInt("swordSlot")));
                        cache.put(uuid + "rodSlot", String.valueOf(rs.getInt("rodSlot")));
                        cache.put(uuid + "bowSlot", String.valueOf(rs.getInt("bowSlot")));
                        cache.put(uuid + "arrowSlot", String.valueOf(rs.getInt("arrowSlot")));
                        cache.put(uuid + "killMSG", rs.getString("killMSG"));
                        cache.put(uuid + "deathMSG", rs.getString("deathMSG"));
                        cache.put(uuid + "streakMSG", rs.getString("streakMSG"));
                        cache.put(uuid + "killSound", rs.getString("killSound"));
                        cache.put(uuid + "deathSound", rs.getString("deathSound"));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                });
            }
        });
    }
    
    public String getCacheOf(String uuid, String type) {
        return cache.get(uuid + type);
    }
    
    public void setCacheOf(String uuid, String type, String newValue) {
        cache.put(uuid + type, newValue);
    }
    
    public void removeCache(String uuid) {
        cache.remove(uuid + "lastName");
        cache.remove(uuid + "lastIP");
        cache.remove(uuid + "kills");
        cache.remove(uuid + "deaths");
        cache.remove(uuid + "points");
        cache.remove(uuid + "swordSlot");
        cache.remove(uuid + "rodSlot");
        cache.remove(uuid + "bowSlot");
        cache.remove(uuid + "arrowSlot");
        cache.remove(uuid + "killMSG");
        cache.remove(uuid + "deathMSG");
        cache.remove(uuid + "streakMSG");
        cache.remove(uuid + "killSound");
        cache.remove(uuid + "deathSound");
        
    }
}
