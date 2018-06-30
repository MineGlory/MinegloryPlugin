package com.paperbenni.mineglory.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.paperbenni.mineglory.moba.player.MobaPlayer;

public class PlayerLeave implements Listener {

	@EventHandler 
	public void PlayerLeaveEvent(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		MobaPlayer moba = MobaPlayer.getMobaPlayer(player);
		MobaPlayer.sendMessage(moba.getTeam(), player.getName() + " has left the Game");
		MobaPlayer.removePlayer(event.getPlayer());
	}
	
	
}
