package com.akpwebdesign.bukkit.ExtendedSay;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OSayCommand implements CommandExecutor {

	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args)
	{
		
		//set up new List for our autocomplete data
		List<String> autoComplete = new ArrayList<String>();
		
		for(Player player : Bukkit.getOnlinePlayers()) {
			autoComplete.add(player.getDisplayName());
		}

		return autoComplete;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (!sender.hasPermission("bukkit.command.say"))
			return true;
		if (args.length == 0) {
			sender.sendMessage(ChatColor.RED + "Usage: /osay <name> <message ...> (Example: '/osay Can you see?')");
			return false;
		}

		StringBuilder message = new StringBuilder();
		message.append(ChatColor.LIGHT_PURPLE).append("[");
		message.append(args[0]);
		message.append(ChatColor.LIGHT_PURPLE).append("] ");

		if (args.length > 0) {
			message.append(args[1]);
			for (int i = 2; i < args.length; i++) {
				message.append(" ").append(args[i]);
			}
		}

		Bukkit.broadcastMessage(message.toString());
		return true;
	}

}
