package com.paperbenni.mineglory.event.player;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import com.paperbenni.mineglory.moba.map.MobaBeacon;

public class DestroyBlock implements Listener {

	@EventHandler
	public void DestroyBlockEvent(BlockBreakEvent event) {
		Location l = event.getBlock().getLocation();
		Block b = event.getBlock();
		if(b.getType().equals(Material.BEACON)) {
			if(l.equals(MobaBeacon.BlueBeacon)) {
				
			}
			if(l.equals(MobaBeacon.OrangeBeacon)) {
				
			}
		}
	}
	
}
