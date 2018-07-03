package com.paperbenni.mineglory.moba.item;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.util.Vector;

import com.paperbenni.mineglory.moba.map.Directions;

public class BuildBlocks {

	public static void setPillow(Location l, Integer height, Vector direction) {
		World w = l.getWorld();
		for (int i = 0; i < height; i++) {
			w.getBlockAt(l.add(direction)).setType(Material.HARD_CLAY);
		}

	}

	public static void setPlatform(Location l, Integer radius) {
		for (int i = 0; i < radius; i++) {
			Location loc = new Location(l.getWorld(), l.getX(), l.getY(), l.getZ() + i);
			setPillow(loc, radius, new Vector(1, 0, 0));

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

	public static void Staircase(Location l, Vector dir, Integer length) {
		Location loc = l.clone();
		BlockFace face = Directions.VectorToFace(dir);
		for (int i = 0; i < length; i++) {
			loc = loc.add(dir).add(new Vector(0,1,0));
			loc.getBlock().setType(Material.BRICK_STAIRS);
			setStairsData(loc.getWorld(), (int) loc.getX(), (int) loc.getY(), (int) loc.getZ(), face);
		}
	}

	@SuppressWarnings("deprecation")
	public static boolean setStairsData(World world, int x, int y, int z, BlockFace dir) {
		byte d = 0;

		if (dir == BlockFace.WEST) {
			d = 0x1;
		} else if (dir == BlockFace.EAST) {
			d = 0x0;
		} else if (dir == BlockFace.NORTH) {
			d = 0x3;
		} else if (dir == BlockFace.SOUTH) {
			d = 0x2;
		}
		return world.getBlockAt(x, y, z).setTypeIdAndData(67, d, false);
	}

}
