package com.akpwebdesign.bukkit.VanishCompatSay;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.kitteh.vanish.VanishPlugin;

public class VNPHook {

	public static boolean isVanished(Player target) {

		boolean isVanished = false;

		VanishPlugin v = (VanishPlugin) Bukkit.getPluginManager().getPlugin("VanishNoPacket");
		isVanished = v.getManager().isVanished(target);

		return isVanished;
	}

}