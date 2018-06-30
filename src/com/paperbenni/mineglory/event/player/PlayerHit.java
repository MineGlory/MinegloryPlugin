package com.paperbenni.mineglory.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.paperbenni.mineglory.moba.player.MobaPlayer;

public class PlayerHit implements Listener {

	@EventHandler
	public void HitEvent(EntityDamageByEntityEvent event) {
		if(event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
			Player victim = (Player) event.getEntity();
			Player damager = (Player) event.getDamager();
			
			if(MobaPlayer.getMobaPlayer(victim).getTeam() == MobaPlayer.getMobaPlayer(damager).getTeam()) {
				event.setCancelled(true);
				damager.sendMessage("You can't hit your teammate!");
			}
		}
	}
}
