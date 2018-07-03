package com.paperbenni.mineglory;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.paperbenni.mineglory.event.player.DestroyBlock;
import com.paperbenni.mineglory.event.player.FallDamage;
import com.paperbenni.mineglory.event.player.PlayerDeath;
import com.paperbenni.mineglory.event.player.PlayerHit;
import com.paperbenni.mineglory.event.player.PlayerInteract;
import com.paperbenni.mineglory.event.player.PlayerJoin;
import com.paperbenni.mineglory.event.player.PlayerLeave;
import com.paperbenni.mineglory.event.player.PlayerOnMove;

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

		pl.registerEvents(new PlayerJoin(this), this);
		pl.registerEvents(new PlayerInteract(), this);
		pl.registerEvents(new PlayerHit(), this);
		pl.registerEvents(new DestroyBlock(this), this);
		pl.registerEvents(new PlayerLeave(), this);
		pl.registerEvents(new PlayerOnMove(), this);
		pl.registerEvents(new PlayerDeath(this), this);
		pl.registerEvents(new FallDamage(), this);



	}
	
}
