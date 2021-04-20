package me.RoboBoy99.WildGameLogic.Events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;


public class DeathEvent implements Listener {

	
	@EventHandler
    public void removeScreen(PlayerDeathEvent e) {
        Player p = e.getEntity();
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp " + p.getName() + " 0" + " 180" + " 32");
        p.setHealth(20.0);
        p.setFoodLevel(20);
    }
}
