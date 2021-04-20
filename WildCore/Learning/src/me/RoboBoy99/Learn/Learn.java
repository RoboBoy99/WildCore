package me.RoboBoy99.Learn;

import org.bukkit.plugin.java.JavaPlugin;


public class Learn extends JavaPlugin{

	
	@Override 
	public void onEnable() {
		
		getCommand("learn").setExecutor(new LearnCmd());
	}
	
	
	public void onDisable() {
		
	}
}
