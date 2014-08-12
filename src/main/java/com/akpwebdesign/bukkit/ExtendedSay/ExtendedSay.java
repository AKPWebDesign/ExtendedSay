package com.akpwebdesign.bukkit.ExtendedSay;

import org.bukkit.plugin.java.JavaPlugin;

public class ExtendedSay extends JavaPlugin {
	@Override
	public void onEnable() {
		getLogger().info("${name} ${version} has been enabled!");
		
		this.saveDefaultConfig();

		getCommand("say").setExecutor(new SayCommand(this));
		getCommand("msay").setExecutor(new MSayCommand(this));
		getCommand("osay").setExecutor(new OSayCommand(this));
	}

	@Override
	public void onDisable() {
		getLogger().info("${name} ${version} has been disabled!");
	}
}
