package me.RoboBoy99.WildCore.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.RoboBoy99.WildCore.WildCore;

public class JoinEvent implements Listener  {

	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player player = (Player) e.getPlayer();
		player.playSound(player.getLocation(), WildCore.getInstance().getConfig().getString("JoinSound"), 10, 1);
	}
}
