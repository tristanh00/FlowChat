package events;

import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.FlowMC.FlowChat.FlowChat;

public class Chat implements Listener {
	private FlowChat pl;

	public Chat(FlowChat pl) {
		this.pl = pl;
	}
	
	@EventHandler
	public void filterAds(AsyncPlayerChatEvent c) {
		/*
		 * Char sequences to remove. 
		 */
		
		String ipv2 = "\\w{1,3}(\\.|-)+\\w{2,9}(\\.|-)+\\w{1,3}";
		String ipv4 = "\\d{1,3}(\\.|\\s|-)+\\d{1,3}(\\.|\\s|-)+\\d{1,3}(\\.|\\s|-)+\\d{1,3}";
		String ipv6 = "\\d{1,3}(\\.|\\s|-)+\\d{1,3}(\\.|\\s|-)+\\d{1,3}(\\.|\\s|-)+\\d{1,3}(\\s|:)+\\d{1,5}";
		
		String m = c.getMessage();
		String newMessage = m.replaceAll(ipv6, "*.*.*.*:***").replaceAll(ipv4, "*.*.*.*").replaceAll(ipv2, "**.*****.***");
		c.setMessage(newMessage);
	}
	
	@EventHandler
	public void filterWords(AsyncPlayerChatEvent c) {
	    List<String> badwords = this.pl.getConfig().getStringList("badwords");
	    
	    for (int i = 0; i < badwords.size(); i++) {
	      String[] split = ((String)badwords.get(i)).split(":");
	      String word = split[0];
	      String replace = split[1];
          if (c.getMessage().contains(word)) {
            String newMSG = c.getMessage().replaceAll(word, "§o" + replace);
            c.setMessage(newMSG);
          }
	      }   
	  }
}
