package com.akpwebdesign.bukkit.VanishCompatSay;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class MSayCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (!sender.hasPermission("bukkit.command.say"))
			return true;
		if (args.length == 0) {
			sender.sendMessage(ChatColor.RED + "Usage: /msay <message ...>");
			return false;
		}

		StringBuilder message = new StringBuilder();
		message.append(ChatColor.LIGHT_PURPLE).append("[");
		if (sender instanceof ConsoleCommandSender) {
			message.append("Server");
		} else if (sender instanceof Player) {
			message.append(((Player) sender).getDisplayName());
		} else {
			message.append(sender.getName());
		}
		message.append(ChatColor.LIGHT_PURPLE).append("] ");

		if (args.length > 0) {
			message.append(args[0]);
			for (int i = 1; i < args.length; i++) {
				message.append(" ").append(args[i]);
			}
		}

		Bukkit.broadcastMessage(message.toString());
		return true;
	}

}
