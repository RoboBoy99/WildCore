package me.RoboBoy99.Clans.mainstuff;


import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;

public class ClansData 
{
	//Map<UUID, String> members = new HashMap<>();
	UUID owner;
	String clanName;
	ItemStack Display;
	int Size;
	int TotalKills;
	int Money;
	int Level;
	ChatColor color;
	Location loc;
	
	public ClansData(UUID owner, String name, ItemStack Display, ChatColor color, int Size, int Kills, int Money, int level, Location loc) {
	    this.clanName = name;
	    this.Display = Display;
		this.Size = Size;
		this.Level = level;
		this.TotalKills = Kills; 
		this.Money = Money;
		this.color = color;
		this.loc = loc;
	  //  members.put(owner, "Owner");
	}

	public UUID getUUID()
	{
	    return owner;
	}
	  
	public String getName()
	{
	    return clanName;
	}
	
	public ChatColor Color() {
		return color;
	}
	
	public int Level() {
		return Level;
	}
	
	public int Kills() {
		return TotalKills;
	}
	
	public UUID getOwner() {
		return owner;
	}
	
	public ItemStack GetDisplay() {
		return Display;
		
	}
	
	public int TotalMoney() {
		return Money;
	}
	
	public Location loc() {
		return loc;
	}
	//public boolean inTeam(Player player) {
	//    return members.containsKey(player.getUniqueId());
	//}

	//public UUID getOwner(OfflinePlayer pli) 
	//{   
	//	UUID uuid = pli.getUniqueId();
	//    if (members.get(uuid).equals("Owner")) 
    //    	return uuid;
	//    
	 //   return null;
	//}
	
	
//	public void addMember(Player player, String rank) {
	//    members.put(player.getUniqueId(), rank);
	//}

	//public void removeMember(OfflinePlayer player) {
	 //   if (members.containsKey(player.getUniqueId()))    //If the hashmap contains the player, we remove him.
	   //     members.remove(player.getUniqueId());       //pretty self-explanatory.
	//}

	//public String getRank(OfflinePlayer pl) 
	//{
	   // if (members.containsKey(pl.getUniqueId()))
	  //      return members.get(pl.getUniqueId());
	//    return null;
//	}

}
