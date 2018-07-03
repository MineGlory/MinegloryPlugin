package com.paperbenni.mineglory.moba.map;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class Directions {
	final public static Integer PosX = 1;
	final public static Integer NegX = 2;
	final public static Integer PosZ = 3;
	final public static Integer NegZ = 4;

	final public static Vector PosXV = new Vector(1, 0, 0);
	final public static Vector NegXV = new Vector(-1, 0, 0);
	final public static Vector PosZV = new Vector(0, 0, 1);
	final public static Vector NegZV = new Vector(0, 0, -1);

	public static Vector getFacing(Player p, Location l) {

		Location pl = p.getLocation();
		Integer x = 0;
		Integer z = 0;
		if (pl.getX() > l.getX()) {
			x = -1;
		} else {
			x = 1;
		}
		if (pl.getZ() > l.getZ()) {
			z = -1;
		} else {
			z = 1;
		}
		if (Math.abs(pl.getX() - l.getX()) > Math.abs(pl.getZ() - l.getZ())) {
			z = 0;
		} else {
			x = 0;
		}
		return new Vector(x, 0, z);

	}

	public static Material getFloorBlock(Player p) {
		Location below = p.getLocation().subtract(new Vector(0, 1, 0));
		return below.getWorld().getBlockAt(below).getType();
	}

	public static Block getFloor(Player p) {
		Location below = p.getLocation().subtract(new Vector(0, 1, 0));
		return below.getBlock();
	}

	public static BlockFace VectorToFace(Vector v) {
		if(v.equals(Directions.PosXV)) {
			return BlockFace.EAST;
		}
		if(v.equals(Directions.NegXV)) {
			return BlockFace.WEST;
		}
		if(v.equals(Directions.PosZV)) {
			return BlockFace.SOUTH;
		}
		if(v.equals(Directions.NegZV)) {
			return BlockFace.NORTH;
		}
		return BlockFace.EAST;
	}

}
