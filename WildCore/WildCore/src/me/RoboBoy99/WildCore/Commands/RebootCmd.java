package me.RoboBoy99.WildCore.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.RoboBoy99.WildCore.Reboot.RebootGui;

public class RebootCmd implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!cmd.getName().equalsIgnoreCase("Reboot"))
            return false;
        if (!(sender instanceof Player))
        	//System.out.print(RED + "This command can only be used by a player");
            return false;
 
        Player player = (Player) sender;
        if(args.length == 0) {
        	if(player.hasPermission("wCore.*")) {
        		RebootGui.Gui(player);
        	}
        }
		return false;
	}
}
