package com.tallcraft.tallcraftdeathmessages;

import org.bukkit.plugin.PluginManager;
import listeners.*;
import commands.*;

import org.bukkit.plugin.java.JavaPlugin;



//test
public final class TallcraftDeathMessages extends JavaPlugin {
	public static TallcraftDeathMessages instance;
	
	public static Cmd_Init customMessages;

	@Override
	public void onEnable() {

        // Initialize variables
        instance = this;

        PluginManager pluginManager = this.getServer().getPluginManager();
        pluginManager.registerEvents(new DeathListener(), this);
        
        this.getCommand("tcdmreload").setExecutor(new Cmd_Reload());
        
        customMessages = new Cmd_Init();
        customMessages.initConfig();



        System.out.println("[TallcraftDeathMessages] Tallcraft Death Messages Loaded successfully.");



	}

}
