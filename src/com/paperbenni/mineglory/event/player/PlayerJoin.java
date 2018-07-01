package com.paperbenni.mineglory.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.paperbenni.mineglory.moba.player.MobaPlayer;

public class PlayerJoin implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		p.sendMessage("Welcome to MineGlory");
		Boolean team = false;
		if (Math.round(Math.random()) == 1) {
			team = true;
		} else {
			team = false;
		}
		p.getInventory().clear();
		MobaPlayer.addPlayer(p, team);
		MobaPlayer.getMobaPlayer(p).setup();
		

	}
}
