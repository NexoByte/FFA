/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.nexobyte.ffa.sounds;

import org.bukkit.Sound;

/**
 *
 * @author Nexo
 */
public enum Sounds {
    
    LEVEL_UP(1, "LEVEL_UP", Sound.LEVEL_UP, "http://textures.minecraft.net/texture/98901f71434d53920747694f682f5e53b8f74483f269c384c6936b7d86582"),
    HORSE_DEATH(2, "HORSE_DEATH", Sound.HORSE_DEATH, "http://textures.minecraft.net/texture/b66b2b32d31539c7383d923bae4faaf65da6715cd526c35d2e4e6825da11fb"),
    ANVIL_BREAK(3, "ANVIL_BREAK", Sound.ANVIL_BREAK, "http://textures.minecraft.net/texture/9b425aa3d94618a87dac9c94f377af6ca4984c07579674fad917f602b7bf235"),
    CREEPER_DEATH(4, "CREEPER_DEATH", Sound.CREEPER_DEATH, "http://textures.minecraft.net/texture/f2ceb39dd4de24a7adfe291a3a0cfc7cf4f645de59b603fcfe06c6b5a06e26"),
    TNT_EXPLOSION(5, "TNT_EXPLOSION", Sound.EXPLODE, "http://textures.minecraft.net/texture/4cee694b5df34f40d5e774bd3046db849e34ff55a482d0731e9d7a7bb74a12");
    
    private final int id;
    private final String soundName;
    private final Sound sound;
    private final String url;
    
    private Sounds(int id, String soundName, Sound sound, String url) {
        this.id = id;
        this.soundName = soundName;
        this.sound = sound;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public String getSoundName() {
        return soundName;
    }

    public Sound getSound() {
        return sound;
    }

    public String getUrl() {
        return url;
    }
    
    public static Sounds getSoundById(int id) {
        for(Sounds sounds : Sounds.values()) {
            if(sounds.getId() == id) {
                return sounds;
            }
        }
        return null;
    }
    
}
