package me.RoboBoy99.WildGameLogic.Events;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import net.md_5.bungee.api.ChatColor;

public class ClickEvent implements Listener{

	Map<UUID, Long> cooldown = new HashMap<>();
	
	@EventHandler
	public void onClickEvent(PlayerInteractEvent e) {
		if(e.getPlayer().getInventory().getItemInHand().getType().equals(Material.ENDER_PEARL)) {
			Player player = e.getPlayer();
			UUID uuid = player.getUniqueId();
			if(cooldown.containsKey(uuid)) {
				if(cooldown.get(uuid) > System.currentTimeMillis()){
					long timeLeft = (cooldown.get(uuid) - System.currentTimeMillis()) / 1000;
					player.sendMessage(ChatColor.RED + "Cooldown will end in " + ChatColor.BOLD + ChatColor.RED + timeLeft + ChatColor.RED + " seconds");
					e.setCancelled(true);
					return;
				} 
			}
			cooldown.put(uuid, System.currentTimeMillis() + (10 * 1000));		
			
		}
	}
}
