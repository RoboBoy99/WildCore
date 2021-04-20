package me.RoboBoy99.WildGameLogic.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinAndQuitEvent implements Listener{

	
	@EventHandler
	public void JoinEvent(PlayerJoinEvent e) {
		e.setJoinMessage(null);
	}
	
	
	@EventHandler
	public void QuitEvent(PlayerQuitEvent e) {
		e.setQuitMessage(null);
	}
}
