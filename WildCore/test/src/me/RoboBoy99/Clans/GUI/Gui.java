package me.RoboBoy99.Clans.GUI;

import java.util.ArrayList;		
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Collectors;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import me.RoboBoy99.Clans.MainClans;
import me.RoboBoy99.Clans.mainstuff.ClansManager;

public class Gui 
{
	static String Name;
	OfflinePlayer pluuid;
	
	public static void ClanManagment(Player player) 
	{
		Inventory PO = Bukkit.createInventory(player , 9, ChatColor.DARK_GRAY + "Managment"); 
		
		ItemStack Settings = new ItemStack(Material.ENCHANTED_BOOK);
		ItemMeta SettingsMeta = Settings.getItemMeta();
		SettingsMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Clan Settings");
		Settings.setItemMeta(SettingsMeta);
		PO.setItem(1, Settings);
		
	}
	
	@SuppressWarnings("deprecation")
	public static void AddPlayerToTeam(Player player) {
		ClansManager clanManager = MainClans.getInstance().clanManager;
		Inventory PM = Bukkit.createInventory(player , 45, ChatColor.AQUA + "Invite a Player");
		ItemStack barrier = new ItemStack(Material.BARRIER, 1);
		ItemMeta back = barrier.getItemMeta();
		back.setDisplayName(ChatColor.DARK_RED + "Go back");
		barrier.setItemMeta(back);
		PM.setItem(8, barrier);
		player.openInventory(PM);
		
		for(Player pl : Bukkit.getOnlinePlayers()) 
		{
			if(clanManager.players.get(pl.getUniqueId()) == null) 
			{
				String Name = pl.getName();
				boolean isNewVersion = Arrays.stream(Material.values()).map(Material::name).collect(Collectors.toList()).contains("PLAYER_HEAD");
				Material type = Material.matchMaterial(isNewVersion ? "PLAYER_HEAD" : "SKULL_ITEM");
				ItemStack skull = new ItemStack(type, 1);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner(Name);
				meta.setDisplayName(ChatColor.GOLD + Name);
				skull.setItemMeta(meta);	
				PM.addItem(skull);
			}
		}	
	}
	
	@SuppressWarnings("deprecation")
	public static void ClanInfo(Player player) 
	{
		ClansManager clanManager = MainClans.getInstance().clanManager;
		UUID uuid = player.getUniqueId();
		String getClan = clanManager.players.getOrDefault(uuid, Name);
		Inventory PM = Bukkit.createInventory(player , 45, ChatColor.DARK_GRAY + "Information of " + ChatColor.GREEN + ChatColor.BOLD + getClan);
	
		boolean OisNewVersion = Arrays.stream(Material.values()).map(Material::name).collect(Collectors.toList()).contains("PLAYER_HEAD");
		Material type = Material.matchMaterial(OisNewVersion ? "PLAYER_HEAD" : "SKULL_ITEM");
		ItemStack Oskull = new ItemStack(type, 1);
		SkullMeta meta = (SkullMeta) Oskull.getItemMeta();
		meta.setOwner("Chest");
		meta.setDisplayName(ChatColor.YELLOW  + "Clan Shop");
		Oskull.setItemMeta(meta);
		PM.setItem(14, Oskull);
		
		ItemStack Members = new ItemStack(Material.PLAYER_HEAD, 1);
		ItemMeta memberMeta = Members.getItemMeta();
		memberMeta.setDisplayName(ChatColor.GRAY + "Members");
		Members.setItemMeta(memberMeta);
		PM.setItem(12, Members);
		
		ItemStack Statics = new ItemStack(Material.PAPER, 1);
		ItemMeta StaticsMeta = Statics.getItemMeta();
		StaticsMeta.setDisplayName(ChatColor.GRAY + "Clan Statics");
		ArrayList<String> lore = new ArrayList<>();
		lore.add(ChatColor.GRAY + "Level " + ChatColor.GOLD + clanManager.Level(getClan));
		lore.add(ChatColor.GRAY + "Kills " + ChatColor.RED + clanManager.Kills(getClan));
		lore.add(ChatColor.GRAY + "Money " + ChatColor.GREEN + clanManager.Money(getClan));
		StaticsMeta.setLore(lore);
		Statics.setItemMeta(StaticsMeta);
		PM.setItem(10, Statics);
		
		
		
		boolean BankisNewVersion = Arrays.stream(Material.values()).map(Material::name).collect(Collectors.toList()).contains("PLAYER_HEAD");
		Material type1 = Material.matchMaterial(BankisNewVersion ? "PLAYER_HEAD" : "SKULL_ITEM");
		ItemStack Bankskull = new ItemStack(type1, 1);
		SkullMeta Bankmeta = (SkullMeta) Bankskull.getItemMeta();
		Bankmeta.setOwner("Tempory");
		Bankmeta.setDisplayName(ChatColor.GREEN + "Bank");
		Bankskull.setItemMeta(Bankmeta);
		PM.setItem(16, Bankskull);
		
		ItemStack Manage = new ItemStack(Material.YELLOW_CONCRETE, 1);
		ItemMeta ManageMeta = Manage.getItemMeta();
		ManageMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Owner Managment");
		Manage.setItemMeta(ManageMeta);
		PM.setItem(31, Manage);
		
		player.openInventory(PM);
	}
	
	public static void BankGui(Player player) {
		ClansManager clanManager = MainClans.getInstance().clanManager;
		String getClan = clanManager.players.getOrDefault(player.getUniqueId(), Name);
		Inventory Bank = Bukkit.createInventory(player, 27 , ChatColor.BOLD + "" + ChatColor.GREEN + "Bank");
		
		ItemStack Display = new ItemStack(Material.EMERALD_BLOCK);
		ItemMeta  DisplayMeta = Display.getItemMeta();
		DisplayMeta.setDisplayName(ChatColor.GREEN + "Clan Amount: " + ChatColor.LIGHT_PURPLE + clanManager.Clans.get(getClan).TotalMoney() + "$");
		Display.setItemMeta(DisplayMeta);
		Bank.setItem(13, Display);
		
		ItemStack Depsit = new ItemStack(Material.GREEN_CONCRETE);
		ItemMeta DepsitMeta = Depsit.getItemMeta();
		DepsitMeta.setDisplayName(ChatColor.GREEN + "Depsit");
		Depsit.setItemMeta(DepsitMeta);
		Bank.setItem(15, Depsit);
		
		ItemStack WithDraw = new ItemStack(Material.PURPLE_CONCRETE);
		ItemMeta WithDrawMeta = WithDraw.getItemMeta();
		WithDrawMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Withdraw");
		WithDraw.setItemMeta(WithDrawMeta);
		Bank.setItem(11, WithDraw);

		player.openInventory(Bank);
	}
	@SuppressWarnings("deprecation")
	public static void PlayerOption(Player player, OfflinePlayer whoOptions)
	{
		ClansManager clanManager = MainClans.getInstance().clanManager;
		UUID whouuid = whoOptions.getUniqueId();
		Inventory PO = Bukkit.createInventory(player, 9 , ChatColor.BOLD + "" + ChatColor.GREEN + "What to do with " + ChatColor.AQUA + Bukkit.getOfflinePlayer(whouuid).getName() + ChatColor.GREEN +"?");
		boolean isNewVersion = Arrays.stream(Material.values()).map(Material::name).collect(Collectors.toList()).contains("PLAYER_HEAD");
		Material type = Material.matchMaterial(isNewVersion ? "PLAYER_HEAD" : "SKULL_ITEM");
		ItemStack skull = new ItemStack(type, 1);
		SkullMeta meta = (SkullMeta) skull.getItemMeta();
		meta.setOwner(Bukkit.getOfflinePlayer(whouuid).getName());
		meta.setDisplayName(Bukkit.getOfflinePlayer(whouuid).getName());
		skull.setItemMeta(meta);
		PO.setItem(4, skull);	
		if(clanManager.members.containsKey(whoOptions.getUniqueId())) {
			if(clanManager.getRank(whoOptions) == "Member")
			{
				ItemStack promote = new ItemStack(Material.EMERALD_BLOCK, 1);
				ItemMeta promoteMeta = promote.getItemMeta();
				promoteMeta.setDisplayName(ChatColor.GREEN + "Promote");
				promote.setItemMeta(promoteMeta);
				PO.setItem(6, promote);
			} else if(clanManager.getRank(whoOptions) == "Sergent") {
				ItemStack depromote = new ItemStack(Material.RED_CONCRETE, 1);
				ItemMeta depromoteMeta = depromote.getItemMeta();
				depromoteMeta.setDisplayName(ChatColor.RED + "Demote");
				depromote.setItemMeta(depromoteMeta);
				PO.setItem(6, depromote);
			}
				
		}
		
		ItemStack Back = new ItemStack(Material.BARRIER, 1);
		ItemMeta BackMeta = Back.getItemMeta();
		BackMeta.setDisplayName(ChatColor.RED + "Back");
		Back.setItemMeta(BackMeta);
		PO.setItem(0, Back);
		
		ItemStack Kick = new ItemStack(Material.FIRE_CORAL_BLOCK, 1);
		ItemMeta KickMeta = Kick.getItemMeta();
		KickMeta.setDisplayName(ChatColor.RED + "Kick");
		Kick.setItemMeta(KickMeta);
		PO.setItem(2, Kick);
		player.openInventory(PO);	
		

	}
	
	@SuppressWarnings("deprecation")
	public static void Members(Player player) {
		ClansManager clanManager = MainClans.getInstance().clanManager;
		String getClan = clanManager.players.getOrDefault(player.getUniqueId(), Name);
		Inventory PM = Bukkit.createInventory(player , 27, ChatColor.GREEN + "Members");
		player.openInventory(PM);
		
		ItemStack Back = new ItemStack(Material.BARRIER, 1);
		ItemMeta BackMeta = Back.getItemMeta();
		BackMeta.setDisplayName(ChatColor.RED + "Back");
		Back.setItemMeta(BackMeta);
		PM.setItem(0, Back);
		
		ItemStack AddPlayer = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
		ItemMeta AddPlayerMeta = AddPlayer.getItemMeta();
		AddPlayerMeta.setDisplayName(ChatColor.AQUA + "Invite a Player");
		AddPlayer.setItemMeta(AddPlayerMeta);
		
		ItemStack Glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
		ItemMeta metab = Glass.getItemMeta();
		metab.setDisplayName("");
		Glass.setItemMeta(metab);
		
		PM.setItem(1, Glass);
		PM.setItem(2, Glass);
		PM.setItem(3, Glass);
		PM.setItem(5, Glass);
		PM.setItem(6, Glass);
		PM.setItem(7, Glass);
		PM.setItem(8, Glass);
		PM.setItem(9, Glass);
		PM.setItem(17, Glass);
		PM.setItem(18, Glass);
		PM.setItem(19, Glass);
		PM.setItem(20, Glass);
		PM.setItem(21, Glass);
		PM.setItem(22, Glass);
		PM.setItem(23, Glass);
		PM.setItem(24, Glass);
		PM.setItem(25, Glass);
		PM.setItem(26, Glass);
		
		
		for(UUID pl : clanManager.players.keySet())
		{
			if(clanManager.players.get(pl).matches(getClan)) 
			{	
				String OName = Bukkit.getOfflinePlayer(pl).getName();
				boolean OisNewVersion = Arrays.stream(Material.values()).map(Material::name).collect(Collectors.toList()).contains("PLAYER_HEAD");
				Material type = Material.matchMaterial(OisNewVersion ? "PLAYER_HEAD" : "SKULL_ITEM");
				ItemStack Oskull = new ItemStack(type, 1);
				SkullMeta meta = (SkullMeta) Oskull.getItemMeta();
				meta.setOwner(OName);
				meta.setDisplayName(ChatColor.YELLOW  + OName);
				
				//meta.setDisplayName(ChatColor.GOLD + Bukkit.getPlayer(pl).getName());
				ArrayList<String> lore = new ArrayList<>();
				lore.add(ChatColor.AQUA + "Rank : " + clanManager.getRank(Bukkit.getOfflinePlayer(pl)));
				if(Bukkit.getOfflinePlayer(pl).isOnline() == true) 
				{
					lore.add(ChatColor.GREEN + "Online");
				} else {
					lore.add(ChatColor.RED + "Offline");
				}
				meta.setLore(lore);
				Oskull.setItemMeta(meta);		
				if(clanManager.getRank(Bukkit.getOfflinePlayer(pl)) == "Owner") 
				{
					PM.setItem(4, Oskull);
					break;
				} 
			}
		}
		
		for(UUID pl : clanManager.players.keySet())
		{	   
	        if (clanManager.players.get(pl).matches(getClan))
	        {
				String Name = Bukkit.getOfflinePlayer(pl).getName();
				boolean isNewVersion = Arrays.stream(Material.values()).map(Material::name).collect(Collectors.toList()).contains("PLAYER_HEAD");
				Material type = Material.matchMaterial(isNewVersion ? "PLAYER_HEAD" : "SKULL_ITEM");
				ItemStack skull = new ItemStack(type, 1);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner(Name);
				meta.setDisplayName(ChatColor.YELLOW + Name);
				
				//meta.setDisplayName(ChatColor.GOLD + Bukkit.getPlayer(pl).getName());
				ArrayList<String> lore = new ArrayList<>();
				lore.add(ChatColor.AQUA + "Rank : " + clanManager.getRank(Bukkit.getOfflinePlayer(pl)));
				if(Bukkit.getOfflinePlayer(pl).isOnline() == true) 
				{
					lore.add(ChatColor.GREEN + "Online");
				} else {
					lore.add(ChatColor.RED + "Offline");
				}
				meta.setLore(lore);
				skull.setItemMeta(meta);
				if(clanManager.getRank(Bukkit.getOfflinePlayer(pl)) == "Member")
				{		
					PM.addItem(skull);
				}
	        }
	        	
	    } 
		
		for(UUID pl : clanManager.players.keySet())
		{	   
	        if (clanManager.players.get(pl).matches(getClan))
	        {
				String Name = Bukkit.getOfflinePlayer(pl).getName();
				boolean isNewVersion = Arrays.stream(Material.values()).map(Material::name).collect(Collectors.toList()).contains("PLAYER_HEAD");
				Material type = Material.matchMaterial(isNewVersion ? "PLAYER_HEAD" : "SKULL_ITEM");
				ItemStack skull = new ItemStack(type, 1);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner(Name);
				meta.setDisplayName(ChatColor.YELLOW + Name);
				
				//meta.setDisplayName(ChatColor.GOLD + Bukkit.getPlayer(pl).getName());
				ArrayList<String> lore = new ArrayList<>();
				lore.add(ChatColor.AQUA + "Rank : " + clanManager.getRank(Bukkit.getOfflinePlayer(pl)));
				if(Bukkit.getOfflinePlayer(pl).isOnline() == true) 
				{
					lore.add(ChatColor.GREEN + "Online");
				} else {
					lore.add(ChatColor.RED + "Offline");
				}
				meta.setLore(lore);
				skull.setItemMeta(meta);
				if(clanManager.getRank(Bukkit.getOfflinePlayer(pl)) == "Sergent")
				{		
					PM.addItem(skull);
				}
	        }
		}
		
		if(clanManager.getRank(Bukkit.getOfflinePlayer(player.getUniqueId())) == "Owner")
		{
			{		
				PM.setItem(1, AddPlayer);
	        }
		} else if(clanManager.getRank(Bukkit.getOfflinePlayer(player.getUniqueId())) == "Sergent") {
			PM.setItem(1, AddPlayer);
		}
	}
	public static void ClanShop(Player player) {
		
		Inventory PM = Bukkit.createInventory(player , 27, ChatColor.DARK_GRAY + "Welcome to the Clan Shop");
		player.openInventory(PM);
		ItemStack Upgrades = new ItemStack(Material.PAPER, 1);
		ItemStack Display = new ItemStack(Material.IRON_SWORD, 1);
		ItemStack Colors = new ItemStack(Material.RED_DYE, 1);
		ItemStack BlackGlass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
		
		ItemStack Back = new ItemStack(Material.BARRIER, 1);
		ItemMeta BackMeta = Back.getItemMeta();
		BackMeta.setDisplayName(ChatColor.RED + "Back");
		Back.setItemMeta(BackMeta);
		PM.setItem(0, Back);
		
		ItemMeta UpgradesMeta = Upgrades.getItemMeta();
		UpgradesMeta.setDisplayName(ChatColor.GOLD + "Clan Upgrades (Will come in the next update!)");
		Upgrades.setItemMeta(UpgradesMeta);
		PM.setItem(11, Upgrades);
		
		ItemMeta DisplaysMeta = Display.getItemMeta();
		DisplaysMeta.setDisplayName(ChatColor.GREEN + "Select a Display Item for you're clan");
		Display.setItemMeta(DisplaysMeta);
		PM.setItem(13, Display);
		
		ItemMeta ColorsMeta = Colors.getItemMeta();
		ColorsMeta.setDisplayName(ChatColor.AQUA + "Select the color of your clan (Shows in Chat)");
		Colors.setItemMeta(ColorsMeta);
		PM.setItem(15, Colors);
		
		PM.setItem(1, BlackGlass);
		PM.setItem(2, BlackGlass);
		PM.setItem(3, BlackGlass);
		PM.setItem(4, BlackGlass);
		PM.setItem(5, BlackGlass);
		PM.setItem(6, BlackGlass);
		PM.setItem(7, BlackGlass);
		PM.setItem(8, BlackGlass);
		PM.setItem(9, BlackGlass);
		PM.setItem(10, BlackGlass);
		PM.setItem(12, BlackGlass);
		PM.setItem(14, BlackGlass);
		PM.setItem(16, BlackGlass);
		PM.setItem(17, BlackGlass);
		PM.setItem(18, BlackGlass);
		PM.setItem(19, BlackGlass);
		PM.setItem(20, BlackGlass);
		PM.setItem(21, BlackGlass);
		PM.setItem(22, BlackGlass);
		PM.setItem(23, BlackGlass);
		PM.setItem(24, BlackGlass);
		PM.setItem(25, BlackGlass);
		PM.setItem(26, BlackGlass);
		PM.setItem(27, BlackGlass);
	}
		
	public static void ColorsShop(Player player) {
		ClansManager clanManager = MainClans.getInstance().clanManager;
		String getClan = clanManager.players.getOrDefault(player.getUniqueId(), Name);
		Inventory PM = Bukkit.createInventory(player , 45, ChatColor.DARK_GRAY + "Colors Shop");
		player.openInventory(PM);
		
		ItemStack Back = new ItemStack(Material.BARRIER, 1);
		ItemMeta BackMeta = Back.getItemMeta();
		BackMeta.setDisplayName(ChatColor.RED + "Back");
		Back.setItemMeta(BackMeta);
		PM.setItem(0, Back);
		
		ItemStack White = new ItemStack(Material.WHITE_DYE, 1);
		ItemMeta WhiteMeta = White.getItemMeta();
		WhiteMeta.setDisplayName(ChatColor.WHITE + "White Color");
		White.setItemMeta(WhiteMeta);
		PM.setItem(18, White);
		
		ItemStack Black = new ItemStack(Material.BLACK_DYE, 1);
		ItemMeta blackMeta = Black.getItemMeta();
		if(clanManager.Handler.get(getClan).Black) {
			blackMeta.setDisplayName(ChatColor.BLACK + "Black Color");
		} else {
			blackMeta.setDisplayName(ChatColor.BLACK + "Black Color" + ChatColor.RED + " (Lock)");
		}
		Black.setItemMeta(blackMeta);
		PM.setItem(11, Black);
		
		ItemStack Blue = new ItemStack(Material.LAPIS_LAZULI, 1);	
		ItemMeta blueMeta = Blue.getItemMeta();
		if(clanManager.Handler.get(getClan).Blue) {
			blueMeta.setDisplayName(ChatColor.DARK_BLUE + "Blue Color");
		} else {
			blueMeta.setDisplayName(ChatColor.DARK_BLUE + "Blue Color" + ChatColor.RED + " (Lock)");
		}
		Blue.setItemMeta(blueMeta);
		PM.setItem(12, Blue);
		
		ItemStack Green = new ItemStack(Material.GREEN_DYE, 1);	
		ItemMeta GreenMeta = Green.getItemMeta();
		if(clanManager.Handler.get(getClan).Green) {
			GreenMeta.setDisplayName(ChatColor.DARK_GREEN + "Dark Green");
		} else {
			GreenMeta.setDisplayName(ChatColor.DARK_GREEN + "Dark Green" + ChatColor.RED + " (Lock)");
		}
		Green.setItemMeta(GreenMeta);
		PM.setItem(13, Green);
		
		ItemStack Cyan = new ItemStack(Material.BLUE_DYE, 1);	
		ItemMeta CyanMeta = Cyan.getItemMeta();
		if(clanManager.Handler.get(getClan).LightBlue) {
			CyanMeta.setDisplayName(ChatColor.BLUE +"Light Blue Color");
		} else {
			CyanMeta.setDisplayName(ChatColor.BLUE + "Light Blue Color" + ChatColor.RED + " (Lock)");
		}
		Cyan.setItemMeta(CyanMeta);
		PM.setItem(14, Cyan);
		
		ItemStack DarkRed = new ItemStack(Material.REDSTONE, 1);	
		ItemMeta DarkRedMeta = DarkRed.getItemMeta();
		if(clanManager.Handler.get(getClan).DarkRed) {
			DarkRedMeta.setDisplayName(ChatColor.DARK_RED + "Dark Red Color");
		} else {
			DarkRedMeta.setDisplayName(ChatColor.DARK_RED + "Dark Red Color" + ChatColor.RED + " (Lock)");
		}
		DarkRed.setItemMeta(DarkRedMeta);
		PM.setItem(15, DarkRed);
		
		ItemStack Purple = new ItemStack(Material.PURPLE_DYE, 1);	
		ItemMeta PurpleMeta = Purple.getItemMeta();
		if(clanManager.Handler.get(getClan).Purple) {
			PurpleMeta.setDisplayName(ChatColor.DARK_PURPLE + "Purple Color");
		} else {
			PurpleMeta.setDisplayName(ChatColor.DARK_PURPLE + "Purple Color" + ChatColor.RED + " (Lock)");
		}
		Purple.setItemMeta(PurpleMeta);
		PM.setItem(20, Purple);
		
		ItemStack Orange = new ItemStack(Material.ORANGE_DYE, 1);	
		ItemMeta OrangeMeta = Orange.getItemMeta();
		if(clanManager.Handler.get(getClan).Orange) {
			OrangeMeta.setDisplayName(ChatColor.GOLD + "Orange Color");
		} else {
			OrangeMeta.setDisplayName(ChatColor.GOLD + "Orange Color" + ChatColor.RED + " (Lock)");
		}
		Orange.setItemMeta(OrangeMeta);
		PM.setItem(21, Orange);
		
		ItemStack Gray = new ItemStack(Material.LIGHT_GRAY_DYE, 1);	
		ItemMeta GrayMeta = Gray.getItemMeta();
		if(clanManager.Handler.get(getClan).Gray) {
			GrayMeta.setDisplayName(ChatColor.GRAY + "Gray Color");
		} else {
			GrayMeta.setDisplayName(ChatColor.GRAY + "Gray Color" + ChatColor.RED + " (Lock)");
		}
		Gray.setItemMeta(GrayMeta);
		PM.setItem(22, Gray);
		
		ItemStack DarkGray = new ItemStack(Material.GRAY_DYE, 1);	
		ItemMeta DarkGrayMeta = DarkGray.getItemMeta();
		if(clanManager.Handler.get(getClan).DarkGray) {
			DarkGrayMeta.setDisplayName(ChatColor.DARK_GRAY + "Dark Gray Color");
		} else {
			DarkGrayMeta.setDisplayName(ChatColor.DARK_GRAY + "Dark Gray Color" + ChatColor.RED + " (Lock)");
		}
		DarkGray.setItemMeta(DarkGrayMeta);
		PM.setItem(23, DarkGray);
		
		ItemStack LightBlue = new ItemStack(Material.CYAN_DYE, 1);	
		ItemMeta LightBlueMeta = LightBlue.getItemMeta();
		if(clanManager.Handler.get(getClan).LightBlue) {
			LightBlueMeta.setDisplayName(ChatColor.DARK_AQUA + "Cyan Color");
		} else {
			LightBlueMeta.setDisplayName(ChatColor.DARK_AQUA + "Cyan Color" + ChatColor.RED + " (Lock)");
		}
		LightBlue.setItemMeta(LightBlueMeta);
		PM.setItem(24, LightBlue);
		
		ItemStack LightGreen = new ItemStack(Material.LIME_DYE, 1);	
		ItemMeta LightGreenMeta = LightGreen.getItemMeta();
		if(clanManager.Handler.get(getClan).LightGreen) {
			LightGreenMeta.setDisplayName(ChatColor.GREEN + "Light Green Color");
		} else {
			LightGreenMeta.setDisplayName(ChatColor.GREEN + "Light Green Color" + ChatColor.RED + " (Lock)");
		}
		LightGreen.setItemMeta(LightGreenMeta);
		PM.setItem(29, LightGreen);
		
		ItemStack LightAqua = new ItemStack(Material.LIGHT_BLUE_DYE, 1);	
		ItemMeta LightAquaMeta = LightAqua.getItemMeta();
		if(clanManager.Handler.get(getClan).LightAqua) {
			LightAquaMeta.setDisplayName(ChatColor.AQUA + "Light Aqua Color");
		} else {
			LightAquaMeta.setDisplayName(ChatColor.AQUA + "Light Aqua Color" + ChatColor.RED + " (Lock)");
		}
		LightAqua.setItemMeta(LightAquaMeta);
		PM.setItem(30, LightAqua);
		
		ItemStack Red = new ItemStack(Material.RED_DYE, 1);	
		ItemMeta RedMeta = Red.getItemMeta();
		if(clanManager.Handler.get(getClan).Red) {
			RedMeta.setDisplayName(ChatColor.RED + "Red Color");
		} else {
			RedMeta.setDisplayName(ChatColor.RED + "Red Color" + " (Lock)");
		}
		Red.setItemMeta(RedMeta);
		PM.setItem(31, Red);
		
		ItemStack Pink = new ItemStack(Material.MAGENTA_DYE, 1);	
		ItemMeta PinkMeta = Pink.getItemMeta();
		if(clanManager.Handler.get(getClan).Pink) {
			PinkMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Pink Color");
		} else {
			PinkMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Pink Color" + ChatColor.RED + " (Lock)");
		}
		Pink.setItemMeta(PinkMeta);
		PM.setItem(32, Pink);
		
		ItemStack Yellow = new ItemStack(Material.YELLOW_DYE, 1);	
		ItemMeta YellowMeta = Yellow.getItemMeta();
		if(clanManager.Handler.get(getClan).Yellow) {
			YellowMeta.setDisplayName(ChatColor.YELLOW + "Yellow Color");
		} else {
			YellowMeta.setDisplayName(ChatColor.YELLOW + "Yellow Color" + ChatColor.RED + " (Lock)");
		}
		Yellow.setItemMeta(YellowMeta);
		PM.setItem(33, Yellow);
		
		ItemStack Glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
		ItemMeta meta = Glass.getItemMeta();
		meta.setDisplayName("");
		Glass.setItemMeta(meta);
		PM.setItem(1, Glass);
		PM.setItem(2, Glass);
		PM.setItem(3, Glass);
		PM.setItem(4, Glass);
		PM.setItem(5, Glass);
		PM.setItem(6, Glass);
		PM.setItem(7, Glass);
		PM.setItem(8, Glass);
		PM.setItem(9, Glass);
		PM.setItem(10, Glass);
		PM.setItem(16, Glass);
		PM.setItem(17, Glass);
		PM.setItem(19, Glass);
		PM.setItem(25, Glass);
		PM.setItem(26, Glass);
		PM.setItem(27, Glass);
		PM.setItem(28, Glass);
		PM.setItem(34, Glass);
		PM.setItem(35, Glass);
		PM.setItem(36, Glass);
		PM.setItem(37, Glass);
		PM.setItem(38, Glass);
		PM.setItem(39, Glass);
		PM.setItem(40, Glass);
		PM.setItem(41, Glass);
		PM.setItem(42, Glass);
		PM.setItem(43, Glass);
		PM.setItem(44, Glass);
		PM.setItem(45, Glass);	
	}
}
