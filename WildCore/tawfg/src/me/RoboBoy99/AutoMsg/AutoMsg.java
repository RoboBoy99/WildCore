package me.RoboBoy99.AutoMsg;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import net.md_5.bungee.api.ChatColor;


public class AutoMsg extends JavaPlugin
{



	@Override
	public void onEnable() {
		Msg();
		Msg1();
		Msg2();
	}
	
	public void onDisable() {
		
	}
	
	
	  public void Msg() {
		  new BukkitRunnable() {
			  
			  @Override
		       public void run() {
		    	   for(Player pl : Bukkit.getOnlinePlayers()) {
		    		   
		    		   pl.sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "---------------------------------------------------\n \n" + ChatColor.GOLD + "" + ChatColor.BOLD +  "                          Discord\n\n" + ChatColor.YELLOW + "                             �������� ���� ������\n                     /discord !���� ������� ��� ��\n \n" + ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "-----------------------------------------------------");

		    	   }
		    	   
		       }
		  }.runTaskTimerAsynchronously(this, 0, 6000L);
	  }
	  
	  
	  public void Msg1() {
		  new BukkitRunnable() {
			  
			  @Override
		       public void run() {
		    	   for(Player pl : Bukkit.getOnlinePlayers()) {
		    		   
		    		   pl.sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "---------------------------------------------------\n \n" + ChatColor.GOLD + "" + ChatColor.BOLD +  "                          Vote\n\n" + ChatColor.YELLOW + "                             ���� ��� �� ���� ������\n                     /discord ������ �� ������� �����\n \n" + ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "-----------------------------------------------------");

		    	   }
		    	   
		       }
		  }.runTaskTimerAsynchronously(this, 0, 12000L);
	  }
	  
	  public void Msg2() {
		  new BukkitRunnable() {
			  
			  @Override
		       public void run() {
		    	   for(Player pl : Bukkit.getOnlinePlayers()) {
		    		   
		    		   pl.sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "---------------------------------------------------\n \n" + ChatColor.GOLD + "" + ChatColor.BOLD +  "                          Buy\n\n" + ChatColor.YELLOW + "                             ������� ������ ������ ���� �����\n                     /buy !���� ����� ���� ?��� ��� ����\n \n" + ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "-----------------------------------------------------");

		    	   }
		    	   
		       }
		  }.runTaskTimerAsynchronously(this, 0, 18000L);
	  }
}

