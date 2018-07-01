package com.paperbenni.mineglory.moba.map;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Directions {
	final public static Integer PosX = 1;
	final public static Integer NegX = 2;
	final public static Integer PosZ = 3;
	final public static Integer NegZ = 4;

	public static Integer getFacing(Player p, Location l) {

		Location pl = p.getLocation();
		double x1 = Math.abs(l.getX() - pl.getX());
		double z1 = Math.abs(l.getZ() - pl.getZ());

		double max = Math.max(x1, z1);
		if (max == x1) {
			double x2 = l.getX() - pl.getX();
			if (x2 < 0) {
				return NegX;
			} else {
				return PosX;
			}
		}

		if (max == z1) {
			double z2 = l.getZ() - pl.getZ();
			if (z2 < 0) {
				return NegZ;
			} else {
				return PosZ;
			}
		}
		return 0;
	}

}
