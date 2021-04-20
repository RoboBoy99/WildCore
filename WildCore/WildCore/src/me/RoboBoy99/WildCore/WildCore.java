package me.RoboBoy99.WildCore;



import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.RoboBoy99.WildCore.Commands.RebootCmd;
import me.RoboBoy99.WildCore.Commands.WildCommands;
import me.RoboBoy99.WildCore.Commands.learncmd;
import me.RoboBoy99.WildCore.Commands.wCoreCommand;
import me.RoboBoy99.WildCore.Events.JoinEvent;
import me.RoboBoy99.WildCore.Reboot.Events.ClickEvent;
import me.RoboBoy99.WildCore.Reboot.Runnables.Runnables;

public class WildCore extends JavaPlugin {

	public boolean Seconds = false;
	public boolean Minute = false;
	public boolean FiveMinutes = false;
	private static WildCore Instance;
	
	public static WildCore getInstance() {
		return Instance;
	}
	
	@Override
	public void onEnable() {

		getConfig().options().copyDefaults();
		saveDefaultConfig();
		Instance = this;
		
		CheckTimers();
		
		RegisterEvents();
		RegisterCmds();
	}
	
	public void onDisable() {
		
	}
	
	public void RegisterCmds() {
		getCommand("Learn").setExecutor(new learncmd());
		getCommand("wCore").setExecutor(new wCoreCommand());
		getCommand("Reboot").setExecutor(new RebootCmd());
		getCommand("Store").setExecutor(new WildCommands());
		getCommand("Rules").setExecutor(new WildCommands());
		getCommand("Apply").setExecutor(new WildCommands());
		getCommand("Discord").setExecutor(new WildCommands());
		getCommand("Twitter").setExecutor(new WildCommands());
		getCommand("Reddit").setExecutor(new WildCommands());
	}
	
	public void RegisterEvents() {
		getServer().getPluginManager().registerEvents(new ClickEvent(), this);
		getServer().getPluginManager().registerEvents(new JoinEvent(), this);
	}

	public void CheckTimers() {
		Runnables.CheckSeconds();
		Runnables.CheckMinute();
		Runnables.CheckFiveMinutes();
	}
	

	
	public void CheckMinute() {
		new BukkitRunnable() 
		{
			@Override
			public void run() 
			{
				if(Minute) {
					Bukkit.broadcastMessage("RESET 1 MINUTE");
				//	getServer().dispatchCommand(getServer().getConsoleSender(), "restart");

				}
			}
		}.runTaskTimerAsynchronously(this, 0, 1200);
	}
	

}
//String message = getConfig().getString(path);
//String link= getConfig().getString(path);
//String hoverMessage = getConfig().getString(path);
//TextComponent message = new TextComponent(message);
//message.setClickEvent( new ClickEvent( ClickEvent.Action.OPEN_URL, link ) );
//message.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(hoverMessage).create() ) );    