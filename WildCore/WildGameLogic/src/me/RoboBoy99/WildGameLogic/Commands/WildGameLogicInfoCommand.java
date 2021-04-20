package me.RoboBoy99.WildGameLogic.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class WildGameLogicInfoCommand implements CommandExecutor {

	@Override
	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!cmd.getName().equalsIgnoreCase("wGameLogic"))
            return false;
        if (!(sender instanceof Player))
        	//System.out.print(RED + "This command can only be used by a player");
            return false;
        
        Player player = (Player) sender;
        
        if(args.length == 0) {
        	if(player.hasPermission("wGameLogic.*")) {
	        	player.sendMessage(ChatColor.DARK_GREEN + "GameLogic" + ChatColor.DARK_GRAY + " » "  + ChatColor.GRAY + "wGameLogic was created by " + ChatColor.GREEN + "RoboBoy99" + ChatColor.GRAY + ".             Version: " + ChatColor.GREEN + "1.1");
        	}
        	if(!player.hasPermission("wGameLogic.*")) {
	        	player.sendMessage(ChatColor.DARK_GREEN + "GameLogic" + ChatColor.DARK_GRAY + " » "  + ChatColor.GRAY + "wGameLogic was created by " + ChatColor.GREEN + "RoboBoy99" + ChatColor.GRAY + ". " + ChatColor.RED + "No permissions.");
        	}
        	//	if(!player.hasPermission("wCore.*")) {
        	//    	player.sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "-------------------[" + ChatColor.GREEN + "" + ChatColor.BOLD + " WildCore " + ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "]-------------------");
	        //    	player.sendMessage(ChatColor.GRAY + "");
	        //   	player.sendMessage(ChatColor.GRAY + "- »" + ChatColor.GREEN + " wCore" + ChatColor.GRAY + " created by " + ChatColor.AQUA + "RoboBoy99 " + ChatColor.GRAY + "for Wild");
	        //  	player.sendMessage(ChatColor.GRAY + "");
	        // 	player.sendMessage(ChatColor.GRAY + "- »" + " Current running version " + ChatColor.GREEN + "1.0" + ChatColor.GRAY + ".");
	        //	player.sendMessage(ChatColor.GRAY + "");
	        // 	player.sendMessage(ChatColor.GRAY + "- » Command to reload the plugin /wcore reload " + ChatColor.RED + "             (You dont have permission for the command so dont try)" );
	        //	player.sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "-------------------------------------------------");
	        //}
        	
            return true;
        }
		return false;
	}
	
}
