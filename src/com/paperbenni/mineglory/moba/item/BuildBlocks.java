package com.paperbenni.mineglory.moba.item;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.util.Vector;

public class BuildBlocks {

	public static void setPillow(Location l, Integer height, Vector direction) {
		World w = l.getWorld();
		for (int i = 0; i < height; i++) {
			w.getBlockAt(l.add(direction)).setType(Material.HARD_CLAY);
		}

	}

	public static void setPlatform(Location l, Integer radius) {
		for (int i = 0; i < radius; i++) {
			Location loc = new Location(l.getWorld(), l.getX(), l.getY(), l.getZ()+i);
			setPillow(loc, radius, new Vector(1,0,0));

		}
	}

	public static void setBlock(Integer x, Integer y, Integer z) {
		World w = Bukkit.getWorld("world");
		Location l = new Location(w, (double) x, (double) y, (double) z);
		w.getBlockAt(l).setType(Material.COBBLESTONE);
	}

	public static void offSetBlock(Location loc, Integer x, Integer y, Integer z) {
		World w = loc.getWorld();
		Location l = loc.add(new Vector((double) x, (double) y, (double) z));
		w.getBlockAt(l).setType(Material.COBBLESTONE);
	}

}
