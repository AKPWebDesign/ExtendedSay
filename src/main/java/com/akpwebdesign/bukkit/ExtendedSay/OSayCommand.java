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
	
	private ExtendedSay plugin;
	
	public OSayCommand(ExtendedSay plugin) {
		super();
		this.plugin = plugin;
	}

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
		if (args.length < 2) {
			sender.sendMessage(ChatColor.RED + "Usage: /osay <name> <message ...> (Example: '/osay Can you see?')");
			return false;
		}
		
		ChatColor color = ChatColor.LIGHT_PURPLE;
		
		String colorString = this.plugin.getConfig().getString("colors.osay");
		
		if(ChatColor.valueOf(colorString).isColor())
			color = ChatColor.valueOf(colorString);


		StringBuilder message = new StringBuilder();
		message.append(color).append("[");
		message.append(args[0]);
		message.append(color).append("] ");

		if (args.length > 1) {
			message.append(args[1]);
			for (int i = 2; i < args.length; i++) {
				message.append(" ").append(args[i]);
			}
		}

		Bukkit.broadcastMessage(message.toString());
		return true;
	}

}
