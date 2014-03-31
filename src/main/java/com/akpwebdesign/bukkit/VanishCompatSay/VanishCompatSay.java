package com.akpwebdesign.bukkit.VanishCompatSay;

import org.bukkit.plugin.java.JavaPlugin;

public class VanishCompatSay extends JavaPlugin {
	@Override
    public void onEnable() {
        getLogger().info("${name} ${version} has been enabled!");
    }
 
    @Override
    public void onDisable() {
        getLogger().info("${name} ${version} has been disabled!");
    }
}
