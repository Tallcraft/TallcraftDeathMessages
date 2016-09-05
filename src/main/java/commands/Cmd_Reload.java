package commands;



import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.tallcraft.tallcraftdeathmessages.TallcraftDeathMessages;


public class Cmd_Reload implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		
		if(!(sender instanceof Player)){
			System.out.println("Command can only be executed by player.");
			return true;
		}
		Player p =(Player) sender;
		
		if(!p.hasPermission("tallcraftdeathmessages.reload")){
			p.sendMessage("§4You don't permission.");
			return true;
		} else {
			p.sendMessage("§4Tallcraft Death Messages reloaded.");
		}
		
		TallcraftDeathMessages.customMessages.initConfig();

		return true;
	}

}
