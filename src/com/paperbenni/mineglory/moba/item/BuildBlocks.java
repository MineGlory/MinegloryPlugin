package com.paperbenni.mineglory.moba.item;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.util.Vector;

public class BuildBlocks {

	public static void setPillow(Location l, Integer height, String direction) {
		World w = l.getWorld();
		Vector v = new Vector(0, 0, 0);

		for (int i = 0; i < height; i++) {
			if (direction.equals("PosX")) {
				v = new Vector(i, 0, 0);
			}
			if (direction.equals("NegX")) {
				v = new Vector((-1)*i, 0, 0);
			}
			if (direction.equals("PosZ")) {
				v = new Vector(0, 0, i);
			}
			if (direction.equals("NegZ")) {
				v = new Vector(0, 0, (-1)*i);
			}
			if (direction.equals("PosY")) {
				v = new Vector(0, i, 0);
			}
			if (direction.equals("NegY")) {
				v = new Vector(0, (-1)*i, 0);
			}
			l.add(v);
			w.getBlockAt(l).setType(Material.COBBLESTONE);
		}
	}
	
	public static void setBlock(Integer x, Integer y, Integer z) {
		World w = Bukkit.getWorld("world");
		Location l = new Location(w, (double) x, (double) y, (double) z);
		w.getBlockAt(l).setType(Material.COBBLESTONE);
	}
	public static void offSetBlock(Location loc, Integer x, Integer y, Integer z) {
		World w = loc.getWorld();//weiter
		Location l = loc.add(new Vector((double) x, (double) y, (double) z));
		w.getBlockAt(l).setType(Material.COBBLESTONE);
	}

}
