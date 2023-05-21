package com.FlowMC.FlowChat;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import events.*;

public class FlowChat extends JavaPlugin implements Listener {	
	public PluginDescriptionFile pyml = getDescription();

  //On Server Start	
	public void onEnable() {
		System.out.println("["+ pyml.getName() +"] by "+ pyml.getAuthors() +" has been enabled!");
		this.saveDefaultConfig();
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new Chat(this), this);
	}
	
  //On Server Stop
	public void onDisable() {
		System.out.println("["+ pyml.getName() +"] by "+ pyml.getAuthors() +" has been enabled!");
	}
}
