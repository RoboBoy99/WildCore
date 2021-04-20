package me.RoboBoy99.WildCore.Commands;



import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.RoboBoy99.WildCore.WildCore;
import net.md_5.bungee.api.ChatColor;



public class WildCommands implements CommandExecutor {
	
	WildCore wCore = WildCore.getInstance();
	public static final String RED = "\033[0;31m";  
	
	 @SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	        if (!(sender instanceof Player))
	        	//System.out.print(RED + "This command can only be used by a player");
	        	return false;
	 
	        Player player = (Player) sender;
	        if(cmd.getName().equalsIgnoreCase("Store")) {
		        if(args.length == 0) {

		        	player.playSound(player.getLocation(), wCore.getConfig().getString("Store-sound"), 10, 1);
		        	player.sendMessage(ChatColor.translateAlternateColorCodes('&', wCore.getConfig().getString("Store-msg")));
		            return true;
		            
		        }
	        } else if(cmd.getName().equalsIgnoreCase("Apply")) {
		        if(args.length == 0) {

		        	player.playSound(player.getLocation(), wCore.getConfig().getString("Apply-sound"), 10, 1);
		        	player.sendMessage(ChatColor.translateAlternateColorCodes('&', wCore.getConfig().getString("Apply-msg")));
		            return true;
		            
		        }
	        } else if(cmd.getName().equalsIgnoreCase("Rules")) {
		        if(args.length == 0) {
		        	
		        	player.playSound(player.getLocation(), wCore.getConfig().getString("Rules-sound"), 10, 1);
		        	player.sendMessage(ChatColor.translateAlternateColorCodes('&', wCore.getConfig().getString("Rules-msg")));
		            return true;
		            
		        }
	        } else if(cmd.getName().equalsIgnoreCase("Discord")) {
		        if(args.length == 0) {
		        	
		        	player.playSound(player.getLocation(), wCore.getConfig().getString("Discord-sound"), 10, 1);
		        	player.sendMessage(ChatColor.translateAlternateColorCodes('&', wCore.getConfig().getString("Discord-msg")));
		            return true;
		            
		        }
	        } else if(cmd.getName().equalsIgnoreCase("Twitter")) {
		        if(args.length == 0) {

		        	player.playSound(player.getLocation(), wCore.getConfig().getString("Twitter-sound"), 10, 1);
		        	player.sendMessage(ChatColor.translateAlternateColorCodes('&', wCore.getConfig().getString("Twitter-msg")));
		            return true;
		            
		        }
	        } else if(cmd.getName().equalsIgnoreCase("Reddit")) {
		        if(args.length == 0) {

		        	player.playSound(player.getLocation(), wCore.getConfig().getString("Reddit-sound"), 10, 1);
		        	player.sendMessage(ChatColor.translateAlternateColorCodes('&', wCore.getConfig().getString("Reddit-msg")));
		            return true;
		            
		        }
	        }
	        
			return false;
	 }
}

