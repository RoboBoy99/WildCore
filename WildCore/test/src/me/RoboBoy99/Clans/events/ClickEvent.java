package me.RoboBoy99.Clans.events;

			
import net.md_5.bungee.api.ChatColor;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.SkullMeta;

import me.RoboBoy99.Clans.MainClans;
import me.RoboBoy99.Clans.GUI.Gui;
import me.RoboBoy99.Clans.mainstuff.ClansManager;

public class ClickEvent implements Listener
{
	String clanName;
	
  
    
	@SuppressWarnings("deprecation")
	@EventHandler 
	public void onMenuClick(InventoryClickEvent e) 
	{
		ClansManager clanManager = MainClans.getInstance().clanManager;
		Player player = (Player) e.getWhoClicked();
		String getClan = clanManager.players.getOrDefault(e.getWhoClicked().getUniqueId(), clanName);
		
		if(e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GRAY + "Information of " + ChatColor.GREEN + ChatColor.BOLD + getClan)) 
		{
			if(e.getCurrentItem().getType() == Material.PLAYER_HEAD) {
				
				if(e.getSlot() == 12) {
					Gui.Members(player);
				}
				
				if(e.getSlot() == 14) {
					Gui.ClanShop(player);
				}
				
				if(e.getSlot() == 16) {
					Gui.BankGui(player);;
				}
			}
			e.setCancelled(true);
		}
		
		if(e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GRAY + "Welcome to the Clan Shop")) {
			switch(e.getCurrentItem().getType()) {
				case BARRIER :
					Gui.ClanInfo(player);
			    break;
				case RED_DYE:
					Gui.ColorsShop(player);
				break;
			default:
				break;
			}
			
			e.setCancelled(true);
		}
		
		if(e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GRAY + "Colors Shop")){
			switch(e.getCurrentItem().getType()) {
			    case BARRIER:
				    Gui.ClanShop(player);
		         break;
			    case WHITE_DYE:
			    	if(clanManager.Handler.get(getClan).White) {
			    		clanManager.SetColor(getClan, ChatColor.WHITE);
			    		player.sendMessage(ChatColor.GRAY + "Clan Color is now White " + clanManager.Clans.get(getClan).Color() + getClan);
			    	}
			    	break;
			    case BLACK_DYE:
			    	if(clanManager.Handler.get(getClan).Black) {
			    		clanManager.SetColor(getClan, ChatColor.BLACK);
			    		player.sendMessage(ChatColor.GRAY + "Clan Color is now Black " + clanManager.Clans.get(getClan).Color() + getClan);
			    	}
			    	break;
			    case LAPIS_LAZULI:
			    	if(clanManager.Handler.get(getClan).Blue) {
			    		clanManager.SetColor(getClan, ChatColor.BLUE);
			    		player.sendMessage(ChatColor.GRAY + "Clan Color is now Blue " + clanManager.Clans.get(getClan).Color() + getClan);
			    	}  	
			    
			default:
				break;
			}
			e.setCancelled(true);
		}
		
		if(e.getView().getTitle().equalsIgnoreCase(ChatColor.GREEN + "Members")) {
				if(clanManager.getRank(Bukkit.getOfflinePlayer(player.getUniqueId())) == "Owner") 
				{
					switch(e.getCurrentItem().getType()) {
					case PLAYER_HEAD:
						SkullMeta meta = (SkullMeta) e.getCurrentItem().getItemMeta();
						Gui.PlayerOption(player, meta.getOwningPlayer());  
						meta.getOwningPlayer().getUniqueId();
						break;
					case GREEN_STAINED_GLASS_PANE:
						Gui.AddPlayerToTeam(player);
						break;
					default:
						break;
				}
					switch(e.getCurrentItem().getType()) {
					case BARRIER:
						Gui.ClanInfo(player);
						break;
					default:
						break;
					}
				}
			e.setCancelled(true);
			
		}
		if(e.getView().getTitle().equalsIgnoreCase(ChatColor.BOLD + "" + ChatColor.GREEN + "Bank")){
			switch(e.getCurrentItem().getType()) {
	        case BARRIER:
			    Gui.ClanInfo(player);
		         break;
			case GREEN_CONCRETE:
				//add
				break;
			default:
				break;
			}
			e.setCancelled(true);
		}
		if(e.getView().getTitle().endsWith(ChatColor.GREEN +"?"))
		{
			String name = e.getClickedInventory().getItem(4).getItemMeta().getDisplayName();
			switch(e.getCurrentItem().getType()) {
		        case BARRIER:
				    Gui.Members(player);
			         break;
		        case EMERALD_BLOCK:
					clanManager.Promote(Bukkit.getOfflinePlayer(name), player, getClan);
					Gui.Members(player);
		        	break;
		        case RED_CONCRETE:
					clanManager.Promote(Bukkit.getOfflinePlayer(name), player, getClan);
					Gui.Members(player);
					break;
			default:
				break;
			}			
		}
	}
	
}
