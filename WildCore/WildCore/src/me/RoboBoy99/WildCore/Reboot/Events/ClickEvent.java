package me.RoboBoy99.WildCore.Reboot.Events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.RoboBoy99.WildCore.WildCore;
import me.RoboBoy99.WildCore.Reboot.RebootGui;
import net.md_5.bungee.api.ChatColor;

public class ClickEvent implements Listener {

	
	@EventHandler 
	public void onMenuClick(InventoryClickEvent e) 
	{
		Player player = (Player) e.getWhoClicked();
		if(e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GRAY + "» Reboot")) {
			
			if(e.getCurrentItem().getType() == Material.MAP) {
				if(e.getSlot() == 2) {
					RebootGui.SecondsRebootConfirm(player);
				}
				
				if(e.getSlot() == 4) {
					RebootGui.MinutRebootConfirm(player);
				}
				
				if(e.getSlot() == 6) {
					RebootGui.FiveRebootConfirm(player);
				}
			}
			e.setCancelled(true);
		}
		if(e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GRAY + "» Are u Sure? (30 Seconds)")) {
			if(e.getCurrentItem().getType() == Material.STAINED_CLAY) {
				
				if(e.getSlot() == 2) {
					Bukkit.broadcastMessage(ChatColor.DARK_RED + "Reboot" + ChatColor.DARK_GRAY + " »" + ChatColor.RED + " The server is scheduled to reboot in 30 seconds.");
					WildCore.getInstance().Seconds = true;
					player.closeInventory();
				}
				
				if(e.getSlot() == 6) {
					player.closeInventory();
				}
			}
			
			e.setCancelled(true);
		}
		
		if(e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GRAY + "» Are u Sure? (1 minute)")) {
			if(e.getCurrentItem().getType() == Material.STAINED_CLAY) {
				
				if(e.getSlot() == 2) {
					Bukkit.broadcastMessage(ChatColor.DARK_RED + "Reboot" + ChatColor.DARK_GRAY + " »" + ChatColor.RED + " The server is scheduled to reboot in 1 minute.");
					WildCore.getInstance().Minute = true;
					player.closeInventory();
				}
				
				if(e.getSlot() == 6) {
					
					player.closeInventory();
				}
			}
			
			e.setCancelled(true);
		}
		
		if(e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GRAY + "» Are u Sure? (5 minutes)")) {
			if(e.getCurrentItem().getType() == Material.STAINED_CLAY) {
				
				if(e.getSlot() == 2) {
					Bukkit.broadcastMessage(ChatColor.DARK_RED + "Reboot" + ChatColor.DARK_GRAY + " »" + ChatColor.RED + " The server is scheduled to reboot in 5 minutes.");
					WildCore.getInstance().FiveMinutes = true;
					player.closeInventory();
				}
				
				if(e.getSlot() == 6) {
					player.closeInventory();
				}
			}
			
			e.setCancelled(true);
		}
	}
}
