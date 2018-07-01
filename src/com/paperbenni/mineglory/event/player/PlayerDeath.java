package com.paperbenni.mineglory.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.paperbenni.mineglory.Mineglory;
import com.paperbenni.mineglory.moba.player.MobaPlayer;

public class PlayerDeath implements Listener {

	private final Mineglory mineglory;

	public PlayerDeath(Mineglory mineglory) {
		this.mineglory = mineglory;
	}

	@EventHandler
	public void OnPlayerDeath(PlayerDeathEvent event) {
		Player p = event.getEntity();
		new BukkitRunnable() {
			@Override
			public void run() {
				p.spigot().respawn();
			}
		}.runTaskLater(mineglory, 2L);
		
		new BukkitRunnable() {
			
			@Override
			public void run() {
				p.teleport(MobaPlayer.getMobaPlayer(p).getSpawn());
				MobaPlayer.getMobaPlayer(p).setup();
			}
		}.runTaskLater(mineglory, 4L);

	}

}
