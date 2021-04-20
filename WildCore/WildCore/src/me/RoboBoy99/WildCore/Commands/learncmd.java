package me.RoboBoy99.WildCore.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class learncmd implements CommandExecutor {
	
	
	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] Line) {
	        if(!cmd.getName().equalsIgnoreCase("Learn"))
	            return false;
	        if (!(sender instanceof Player))
	        	//System.out.print(RED + "This command can only be used by a player");
	            return false;
	        
	        Player player = (Player) sender;
	        
	        if(Line.length == 0) {
	        	player.sendMessage(ChatColor.AQUA + "this is not a number");
	        	return true;
	        }
	        
	        if(Line[0].equalsIgnoreCase("boom")) {
	        	player.sendMessage("0");
	        	return true;
	        } 
	        
	        if(Line[1].equalsIgnoreCase("")) {
	        	player.sendMessage("1 and so on");
	        	return true;
	        } 
			return false;
	 }
}


///
/// CmdName [0, 1, 2, 3] 
