package me.RoboBoy99.WildGameLogic.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class FallDamageEvent implements Listener {

	
	@EventHandler
	public void onFall(EntityDamageEvent e) {
		if(e.getCause() == DamageCause.FALL) {
			e.setCancelled(true);
		}
	}
}
