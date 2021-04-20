package me.RoboBoy99.Clans.mainstuff;

import java.util.HashMap;						
import java.util.Map;
import java.util.UUID;

import javax.annotation.Nullable;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;


public class ClansManager {

	public Map<String, ClansData> Clans;
	public Map<String, ShopHandler> Handler;
	public Map<UUID, String> players = new HashMap<UUID, String>();
	public Map<UUID, String> members = new HashMap<>();
	public ClansManager() {
		Clans = new HashMap<>();
		Handler = new HashMap<>();
	}
	
	public void getInfo(String Name, Player player) {
		if(!exist(Name)) 
			return;
		
		player.sendMessage(ChatColor.DARK_GRAY + " ---- " + ChatColor.GREEN + "Info of the Clan " + Name + ChatColor.DARK_GRAY + " ---- ");
		for(UUID pl : players.keySet()) {
			if(players.get(pl).matches(Name)) 
			{
				if (getRank(Bukkit.getOfflinePlayer(pl)) == "Owner"){
					player.sendMessage(ChatColor.GRAY + "Clan Leader: " + ChatColor.GOLD + Bukkit.getOfflinePlayer(pl).getName());	
				}
			}
		}
		for(UUID pl : players.keySet()) { 
			if(players.get(pl).matches(Name)) {
				if(getRank(Bukkit.getOfflinePlayer(pl)) == "Member") {
					player.sendMessage(ChatColor.GRAY + "Members: " + ChatColor.AQUA + Bukkit.getOfflinePlayer(pl).getName());	
				} else if(players.size() < 2) {
					player.sendMessage(ChatColor.GRAY + "Members:" + ChatColor.RED + " 0");				    
				}
			}
		}
		player.sendMessage("");
		player.sendMessage(ChatColor.GRAY + "" + ChatColor.UNDERLINE + "Statics:");
		player.sendMessage("");
		player.sendMessage(ChatColor.GRAY + "Clan Level: " + ChatColor.AQUA + Clans.get(Name).Level());
		player.sendMessage(ChatColor.GRAY + "Clan Kills: " + ChatColor.RED + Clans.get(Name).Kills());
		player.sendMessage(ChatColor.GRAY + "Clan Total Money: " + ChatColor.GREEN + Clans.get(Name).TotalMoney());
		player.sendMessage(ChatColor.DARK_GRAY + " ---- " + ChatColor.GREEN + "                  " + ChatColor.DARK_GRAY + " ---- ");
	}
	
	public String getRank(OfflinePlayer pl) 
	{
	    if (members.containsKey(pl.getUniqueId()))
	        return members.get(pl.getUniqueId());
	    return null;
	}
	
	public String SizeInfo(String Name, Player player) 
	{
		int Size = 0;
		if(exist(Name)) {
			for(UUID pl : players.keySet())
			{	   
		        if (players.get(pl).matches(Name))  
		        {
		        	Size++;  
		        }
		        
			}
        	String SizeString = String.valueOf(Size).toString();
        	player.sendMessage(SizeString);
        	return SizeString;
        	
		} else 
		{
			player.sendMessage("You dont have a clan with that name!");
		}
		return null;
		
		
	}
	
	public void Depsit() 
	{
		
	}
	
	public void WithDraw() {
		
	}
	
	public void add(String Name, ClansData clanData, Player player) {
		if (exist(Name)) 
			return;

		Clans.put(Name, clanData);
		Handler.put(Name, new ShopHandler());
		players.put(player.getUniqueId(), Name);
		members.put(player.getUniqueId(), "Owner");
		
	}
	
	public void Join(String Name, Player player) {
		int Size = 0;
		if(exist(Name)) {
			for(UUID pl : players.keySet())
			{	   
		        if (players.get(pl).matches(Name))  
		        {
		        	Size++;  
		        	if(Size <= 7) {
                		player.sendMessage(ChatColor.GREEN + "You join the clan " + Name);
		    			players.put(player.getUniqueId(), Name);
		    			members.put(player.getUniqueId(), "Member");
		        	} else {
		        		player.sendMessage("Clan is full sorry");
		        	}
		        }
			}
		}
	}
	
	public void Kick(OfflinePlayer target, Player player, String clanName) 
	{	
		UUID whouuid = target.getUniqueId();
		if(getRank(player) == "Owner") 
		{
			if(players.get(target.getUniqueId()).matches(clanName)) 
			{
				members.remove(whouuid);
				players.remove(whouuid);
			}
			
			for(Player pl : Bukkit.getOnlinePlayers()) {
				if(players.get(pl.getUniqueId()).matches(clanName)) {
					pl.sendMessage(ChatColor.GOLD + "" + target.getName() + "" + ChatColor.GREEN + " Get kicked from the clan by " + ChatColor.AQUA + player.getName());
				}
			}
		}
	}
	
	
	public void Promote(OfflinePlayer target, Player player, String clanName) {
		if(getRank(player) == "Owner") {
			if(players.get(target.getUniqueId()).matches(clanName)) 
			{
				if(getRank(target) == "Member") {
					members.put(target.getUniqueId(), "Sergent");
					for(Player pl : Bukkit.getOnlinePlayers()) {
						if(players.get(pl.getUniqueId()).matches(clanName)) {
							pl.sendMessage(ChatColor.GOLD + "" + target.getName() + "" + ChatColor.BOLD + ChatColor.GREEN + " Get a Promotion");
						}
					}
				} else if(getRank(target) == "Sergent") {
					members.put(target.getUniqueId(), "Member");
					for(Player pl : Bukkit.getOnlinePlayers()) {
						if(players.get(pl.getUniqueId()).matches(clanName)) {
							pl.sendMessage(ChatColor.GOLD + "" + target.getName() + "" + ChatColor.BOLD + ChatColor.RED + " Get a Demote");
						}
					}
				}

			}
		}
	}
	public void SetColor(String Name, ChatColor color) {
		Clans.get(Name).color = color;
	}
	public int Level(String Name) {
		return Clans.get(Name).Level();
	}
	
	public int Kills(String Name) {
		return Clans.get(Name).Kills();
	}
	
	public int Money(String Name) {
		return Clans.get(Name).TotalMoney();
	}
	public boolean exist(String Name) {
		return Clans.containsKey(Name);
	}
	
	public boolean inTeam(Player player) {
		return players.containsKey(player.getUniqueId());
	}
	
	
	public void remove(String Name) {
		if (!exist(Name))
			return;

		Clans.remove(Name);
	}

	@Nullable
	public ClansData get(String Name) {
		if (!exist(Name))
			return null;

		return Clans.get(Name);
	}
	

}
