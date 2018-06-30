package com.paperbenni.mineglory.event.world;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class LoadEvent implements Listener {

	Plugin plugin;
	public LoadEvent(Plugin plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void WorldLoadEvent(WorldLoadEvent event)  {
		World world = event.getWorld();
		Location l = new Location(world, -100, 0, -50);
		new BukkitRunnable() {
			
			@Override
			public void run() {
				for (int x = 0; x < 200; x++) {
					for (int y = 0; y < 256; y++) {
						for(int z = 0; z < 100; z++) {	
							Block b = world.getBlockAt(l.add(new Vector(x, y, z)));
							b.setType(Material.AIR);
						}
					}	
					
				}
				
			}
		}.runTaskLater(plugin, 50L);
	}
}
