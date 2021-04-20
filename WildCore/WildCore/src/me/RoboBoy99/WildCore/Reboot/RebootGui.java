package me.RoboBoy99.WildCore.Reboot;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.RoboBoy99.WildCore.WildCore;
import net.md_5.bungee.api.ChatColor;

public class RebootGui  {
	
	
	public static void Gui(Player player) {
		
		if(WildCore.getInstance().Seconds) {
			player.sendMessage(ChatColor.DARK_RED + "Reboot" + ChatColor.DARK_GRAY + " »" + ChatColor.RED + " you cant open the gui a reboot option was already chosen.");
			return;
		
		} else if(WildCore.getInstance().Minute) {
			player.sendMessage(ChatColor.DARK_RED + "Reboot" + ChatColor.DARK_GRAY + " »" + ChatColor.RED + " you cant open the gui a reboot option was already chosen.");
			return;
		} else if (WildCore.getInstance().FiveMinutes) {
			player.sendMessage(ChatColor.DARK_RED + "Reboot" + ChatColor.DARK_GRAY + " »" + ChatColor.RED + " you cant open the gui a reboot option was already chosen.");
			return;
		}
		
		Inventory Gui = Bukkit.createInventory(player, 9, ChatColor.DARK_GRAY + "» Reboot");
		
		
		ItemStack Seconds = new ItemStack(Material.MAP);
		ItemMeta SecondsMeta = Seconds.getItemMeta();
		SecondsMeta.setDisplayName(ChatColor.GRAY + "30 Seconds");
		List<String> lore = new ArrayList<>();
		lore.add(ChatColor.RED + "The server will reboot in 30 seconds.");
		SecondsMeta.setLore(lore);
		Seconds.setItemMeta(SecondsMeta);
		Gui.setItem(2, Seconds);
		
		ItemStack OneMin = new ItemStack(Material.MAP);
		ItemMeta OneMinMeta = OneMin.getItemMeta();
		OneMinMeta.setDisplayName(ChatColor.GRAY + "1 Minute");
		List<String> lore1 = new ArrayList<>();
		lore1.add(ChatColor.RED + "The server will reboot in 1 minute.");
		OneMinMeta.setLore(lore1);
		OneMin.setItemMeta(OneMinMeta);
		Gui.setItem(4, OneMin);
		
		ItemStack FiveMins = new ItemStack(Material.MAP);
		ItemMeta FiveMinsMeta = FiveMins.getItemMeta();
		FiveMinsMeta.setDisplayName(ChatColor.GRAY + "5 Minutes");
		List<String> lore2 = new ArrayList<>();
		lore2.add(ChatColor.RED + "The server will reboot in 5 minutes.");
		FiveMinsMeta.setLore(lore2);
		FiveMins.setItemMeta(FiveMinsMeta);
		Gui.setItem(6, FiveMins);
		
		player.openInventory(Gui);
	}
	
	
	public static void SecondsRebootConfirm(Player player) {
		Inventory ConfirmGui = Bukkit.createInventory(player, 9, ChatColor.DARK_GRAY + "» Are u Sure? (30 Seconds)");
		
		ItemStack Yes = new ItemStack(Material.STAINED_CLAY, 1, (short) 5);
		ItemMeta YesM = Yes.getItemMeta();
		YesM.setDisplayName(ChatColor.DARK_GREEN + "Yes, reboot");
		Yes.setItemMeta(YesM);
		ConfirmGui.setItem(2, Yes);
		
		
		ItemStack No = new ItemStack(Material.STAINED_CLAY, 1, (short) 14);
		ItemMeta NoM = No.getItemMeta();
		NoM.setDisplayName(ChatColor.RED + "No, cancel reboot");
		No.setItemMeta(NoM);
		ConfirmGui.setItem(6, No);
		
		player.openInventory(ConfirmGui);
	}
	
	public static void MinutRebootConfirm(Player player) {
		Inventory ConfirmGui = Bukkit.createInventory(player, 9, ChatColor.DARK_GRAY + "» Are u Sure? (1 minute)");
		
		ItemStack Yes = new ItemStack(Material.STAINED_CLAY, 1, (short) 5);
		ItemMeta YesM = Yes.getItemMeta();
		YesM.setDisplayName(ChatColor.DARK_GREEN + "Yes, reboot");
		Yes.setItemMeta(YesM);
		ConfirmGui.setItem(2, Yes);
		
		
		ItemStack No = new ItemStack(Material.STAINED_CLAY, 1, (short) 14);
		ItemMeta NoM = No.getItemMeta();
		NoM.setDisplayName(ChatColor.RED + "No, cancel reboot");
		No.setItemMeta(NoM);
		ConfirmGui.setItem(6, No);
		
		player.openInventory(ConfirmGui);
	}
	
	public static void FiveRebootConfirm(Player player) {
		Inventory ConfirmGui = Bukkit.createInventory(player, 9, "" + ChatColor.DARK_GRAY + "» Are u Sure? (5 minutes)");
		
		ItemStack Yes = new ItemStack(Material.STAINED_CLAY, 1, (short) 5);
		ItemMeta YesM = Yes.getItemMeta();
		YesM.setDisplayName(ChatColor.DARK_GREEN + "Yes, reboot");
		Yes.setItemMeta(YesM);
		ConfirmGui.setItem(2, Yes);
		
		
		ItemStack No = new ItemStack(Material.STAINED_CLAY, 1, (short) 14);
		ItemMeta NoM = No.getItemMeta();
		NoM.setDisplayName(ChatColor.RED + "No, cancel reboot");
		No.setItemMeta(NoM);
		ConfirmGui.setItem(6, No);
		
		

		player.openInventory(ConfirmGui);
	}
}
