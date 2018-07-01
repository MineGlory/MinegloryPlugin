package com.paperbenni.mineglory.moba.item;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import com.paperbenni.mineglory.moba.map.Directions;

public class BuildEffects {

	public static void WallEffect(Player p, Location loc) {
		Vector dir = Directions.getFacing(p, loc);
		BuildBlocks.setPillow(loc, 10, dir);
	}

	public static void PlatformEffect(Player p) {

		if (Directions.getFloorBlock(p).equals(Material.AIR)) {
			BuildBlocks.setPlatform(p.getLocation().subtract(new Vector(3, 2, 2)), 5);
		} else {
			BuildBlocks.setPlatform(p.getLocation().subtract(new Vector(3, 1, 2)), 5);

		}
	}
}
