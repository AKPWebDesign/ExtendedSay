package com.akpwebdesign.bukkit.VanishCompatSay;

import org.bukkit.plugin.java.JavaPlugin;

public class VanishCompatSay extends JavaPlugin {
	@Override
	public void onEnable() {
		getLogger().info("${name} ${version} has been enabled!");

		// This will throw a NullPointerException if you don't have the command
		// defined in your plugin.yml file!
		getCommand("say").setExecutor(new SayCommand());
	}

	@Override
	public void onDisable() {
		getLogger().info("${name} ${version} has been disabled!");
	}
}
