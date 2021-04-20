package me.RoboBoy99.Clans;

import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;	

import me.RoboBoy99.Clans.commands.ClanCommand;
import me.RoboBoy99.Clans.events.ChatAPI;
import me.RoboBoy99.Clans.events.ClickEvent;
import me.RoboBoy99.Clans.mainstuff.ClansData;
import me.RoboBoy99.Clans.mainstuff.ClansManager;
import net.milkbowl.vault.economy.Economy;

public class MainClans extends JavaPlugin {
	private static MainClans INSTANCE;
	public static MainClans getInstance() {
		return INSTANCE;
	}

	public ClansManager clanManager;
	public ClansData clansData;

   
	private static Economy econ = null;
	@Override 
	public void onEnable() {
        if (!setupEconomy() ) {
            System.out.println("No economy plugin found, Disabling vault");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        
		INSTANCE = this;
		clanManager = new ClansManager();
		
		getCommand("clans").setExecutor(new ClanCommand());
		getServer().getPluginManager().registerEvents(new ChatAPI(), this);
		getServer().getPluginManager().registerEvents(new ClickEvent(), this);
	}

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
    	
    public static Economy getEconomy() {
        return econ;
    }
    
	public void onDisable() {
	}
}
