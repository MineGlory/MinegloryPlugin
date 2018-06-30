package com.paperbenni.mineglory;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.paperbenni.mineglory.event.player.PlayerHit;
import com.paperbenni.mineglory.event.player.PlayerInteract;
import com.paperbenni.mineglory.event.player.PlayerJoin;
import com.paperbenni.mineglory.event.world.LoadEvent;

public class Mineglory extends JavaPlugin{

	@Override
	public void onEnable() {
		registerEvents();
	}
	
	@Override
	public void onDisable() {
		
	}
	
	private void registerEvents() {
		PluginManager pl = getServer().getPluginManager();
		pl.registerEvents(new PlayerJoin(), this);
		pl.registerEvents(new PlayerInteract(), this);
		pl.registerEvents(new PlayerHit(), this);
		pl.registerEvents(new LoadEvent(this), this);

	}
	
}
