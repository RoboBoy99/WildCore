package me.RoboBoy99.Clans.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.RoboBoy99.Clans.MainClans;
import me.RoboBoy99.Clans.GUI.Gui;
import me.RoboBoy99.Clans.mainstuff.ClansData;
import me.RoboBoy99.Clans.mainstuff.ClansManager;
import net.md_5.bungee.api.ChatColor;


public class ClanCommand implements CommandExecutor {

	String clanName;
	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	        if(!cmd.getName().equalsIgnoreCase("Clans"))
	            return false;
	        if (!(sender instanceof Player))
	            return false;
	 
	        Player player = (Player) sender;
       
	        if(args.length == 0) {

		    	Gui.ClanInfo(player);
	            ClansManager clanManager = MainClans.getInstance().clanManager;
	        	player.sendMessage(clanManager.players.toString());
	        	player.sendMessage(clanManager.members.toString());
	            return true;
	        }
	 
	        if (player.hasPermission("Kits.editer")) {
	            ClansManager clanManager = MainClans.getInstance().clanManager;
		        String getClan = clanManager.players.getOrDefault(player.getUniqueId(), clanName);
	            String Name = args[1];      
	            String targetS;
	 		    targetS = args[1];
	 		    @SuppressWarnings("deprecation")
				OfflinePlayer target = Bukkit.getOfflinePlayer(targetS);
		        
	            switch (args[0]) {
	                case "create":
	                    if (clanManager.exist(Name))
	            			player.sendMessage(ChatColor.RED + "This clan Name is already exist please choose a diffrent name");
	                    else if(clanManager.inTeam(player)) {
	                    	player.sendMessage(ChatColor.RED + "What are you doing? lol");
	                    } else {
	                    	clanManager.add(Name, new ClansData(player.getUniqueId(), Name, new ItemStack(Material.WHITE_BANNER), ChatColor.WHITE, 0 ,0, 0, 0, null), player);
                            player.sendMessage(ChatColor.GREEN + "The clan " + Name + " Has Been Created");	  
	                    }                  
	                    return true;
	                case "info":
	                	if(clanManager.exist(Name)) {
		                	clanManager.getInfo(Name, player);
	                	}
	                    return true;
	                case "join":
	                	if(clanManager.exist(Name)) {
	                		clanManager.Join(Name, player);
	                	}
	                	return true;	                	
				    case "kick":
	    	 		    clanManager.Kick(target, player, getClan);
	    	 		    return true;
	               default:	                	
	                   player.sendMessage("Usage: /clans add name");
	                   return true;
	             }
	            
	        }
	 
	        return false;
	    }
}
