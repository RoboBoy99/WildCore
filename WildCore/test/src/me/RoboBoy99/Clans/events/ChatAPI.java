package me.RoboBoy99.Clans.events;

import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.RoboBoy99.Clans.MainClans;
import me.RoboBoy99.Clans.mainstuff.ClansManager;
import net.md_5.bungee.api.ChatColor;

public class ChatAPI implements Listener {

	String clanName;
	
	@EventHandler
    public void playerChat(AsyncPlayerChatEvent e)
    {
        ClansManager clanManager = MainClans.getInstance().clanManager;
		Player player = e.getPlayer();
		UUID uuid = player.getUniqueId();
		String getClan = clanManager.players.getOrDefault(uuid, clanName);
		String clanFormat = ChatColor.GRAY + "[" + clanManager.Clans.get(getClan).Color() + getClan + ChatColor.GRAY + "] " + ChatColor.RESET + "%1$s: %2$s";
		String NoClanFormat = ChatColor.GRAY + "[" + ChatColor.GRAY + "Lonely" + ChatColor.GRAY + "] " + ChatColor.RESET + "%1$s: %2$s";
		if(clanManager.players.containsKey(uuid))
		{
			e.setFormat(clanFormat);
			return;
		} else 
		{
			e.setFormat(NoClanFormat);
			return;
		}
    }
}