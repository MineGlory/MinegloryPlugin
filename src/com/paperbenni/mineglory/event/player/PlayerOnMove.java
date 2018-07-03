package com.paperbenni.mineglory.event.player;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import com.connorlinfoot.actionbarapi.ActionBarAPI;

public class PlayerOnMove implements Listener {

	@EventHandler void onPlayerMove(PlayerMoveEvent event){
		Player p = event.getPlayer();
		Location l = p.getLocation();
		Location below = l.subtract(new Vector(0,1,0));
		Material blockbelow = below.getBlock().getType();
		if(blockbelow.equals(Material.SLIME_BLOCK)) {
			p.setVelocity(new Vector(0,1,0));
		}
		if(blockbelow.equals(Material.REDSTONE_BLOCK)) {
			p.setVelocity(p.getEyeLocation().getDirection().multiply(1.6));
			ActionBarAPI.sendActionBar(p, "Woosh");
		}
	}
	
}
