package me.RoboBoy99.WildGameLogic;

import org.bukkit.plugin.java.JavaPlugin;	

import me.RoboBoy99.WildGameLogic.Commands.WildGameLogicInfoCommand;
import me.RoboBoy99.WildGameLogic.Events.ClickEvent;
import me.RoboBoy99.WildGameLogic.Events.FallDamageEvent;
import me.RoboBoy99.WildGameLogic.Events.JoinAndQuitEvent;


public class WildGameLogic extends JavaPlugin {

	
	@Override
	public void onEnable() {
		RegisterEvents();
		RegisterCmds();
	}
	
	public void onDisable() {
		
	}
	
	public void RegisterCmds() {
		
		getCommand("wGameLogic").setExecutor(new WildGameLogicInfoCommand());
	}
	public void RegisterEvents() {
		getServer().getPluginManager().registerEvents(new FallDamageEvent(), this);
		getServer().getPluginManager().registerEvents(new JoinAndQuitEvent(), this);
		getServer().getPluginManager().registerEvents(new ClickEvent(), this);

	}

}
