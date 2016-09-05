package listeners;


import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scoreboard.*;
import java.util.List;
import java.util.Random;

import com.tallcraft.tallcraftdeathmessages.TallcraftDeathMessages;






public class DeathListener implements Listener {
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
        Player player = e.getEntity();
        String playerName = player.getDisplayName();
        String killerName = "";
        String messagePart = "";
        
        Boolean killerExists = true; //check if message contains killer or not
        
        YamlConfiguration messages = TallcraftDeathMessages.customMessages.getMessages();
        
        
        
    
        
        Scoreboard sb = player.getScoreboard(); 
        String teamPrefix = sb.getEntryTeam(playerName).getPrefix(); // get Team Color
        String playerNameFormatted = teamPrefix+playerName+"§r";
        
        String deathMessage = e.getDeathMessage();
        
        if(deathMessage.contains("was slain by")){
        	  messagePart = "was slain by";
        }
        if(deathMessage.contains("was blown up by")){
      	  messagePart = "was blown up by";
        }
        if(deathMessage.contains("was fireballed by")){
        	  messagePart = "was fireballed by";
        }
        if(deathMessage.contains("was shot by")){
        	  messagePart = "was shot by";
        }
        
        if(deathMessage.contains("was killed trying to hurt")){
      	  messagePart = "was killed trying to hurt";
        }
      

        if(deathMessage.contains("fell from a high place")){
      	  messagePart = "fell from a high place";
      	  killerExists = false;
        }
        
        if(deathMessage.contains("hit the ground too hard")){
        	  messagePart = "hit the ground too hard";
        	  killerExists = false;
         }
        
        if(deathMessage.contains("went up in flames")){
      	  messagePart = "went up in flames";
      	  killerExists = false;
        }
        
        if(deathMessage.contains("burned to death")){
        	  messagePart = "burned to death";
        	  killerExists = false;
          }
        
        if (messagePart!="") {
	   	  String customMsg = getRandomMsg(messages.getStringList(messagePart));
		  customMsg = customMsg.replace("{{player}}", playerNameFormatted);
		  
		  if (killerExists && customMsg.contains("{{killer}}")) {
			  int killerPos = deathMessage.indexOf(messagePart);
			  killerName = deathMessage.substring(killerPos+messagePart.length()+1, deathMessage.length());
			  customMsg = customMsg.replace("{{killer}}", killerName);
		  }
		  
		  e.setDeathMessage(customMsg);
        }
        
	}
	
	
	//Return random death message from list of messages
	private static String getRandomMsg (List<String> msgList) {
		int listLength = msgList.size();
	  	int randomLineNo = randInt(0,listLength-1);
	  	String randomMsg = msgList.get(randomLineNo);
		return randomMsg;
	}
	
	
	// Just a simple random number generator
	private static int randInt(int min, int max) {

	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}

}

