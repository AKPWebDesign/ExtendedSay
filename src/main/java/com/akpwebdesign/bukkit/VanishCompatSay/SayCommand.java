package com.akpwebdesign.bukkit.VanishCompatSay;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class SayCommand implements CommandExecutor {

//	@Override
//	public List<String> tabComplete(CommandSender sender, String alias,
//			String[] args) throws IllegalArgumentException {
//		Validate.notNull(sender, "Sender cannot be null");
//		Validate.notNull(args, "Arguments cannot be null");
//
//		if (args.length >= 1) {
//			return super.tabComplete(sender, alias, args);
//		}
//		return ImmutableList.of();
//	}

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (!sender.hasPermission("bukkit.command.say"))
			return true;
		if (args.length == 0) {
			sender.sendMessage(ChatColor.RED + "Usage: /say <message ...>");
			return false;
		}

		StringBuilder message = new StringBuilder();
		message.append(ChatColor.LIGHT_PURPLE).append("[");
		if (sender instanceof ConsoleCommandSender) {
			message.append("Server");
		} else if (sender instanceof Player) {
			if(VNPHook.isVanished((Player) sender)) {
				message.append("Server");
			}
			else {
				message.append(((Player) sender).getDisplayName());
			}
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
