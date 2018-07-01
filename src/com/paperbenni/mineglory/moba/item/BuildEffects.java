package com.paperbenni.mineglory.moba.item;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.paperbenni.mineglory.moba.map.Directions;

public class BuildEffects {

	public static void WallEffect(Player p, Location loc) {
		Integer d = Directions.getFacing(p, loc);
		if (d == Directions.PosX) {
			BuildBlocks.setPillow(loc.add(1, 0, 0), 5, "PosX");
			p.sendMessage("PosX");
			return;

		}
		if (d == Directions.NegX) {
			BuildBlocks.setPillow(loc.add(-1, 0, 0), 5, "NegX");
			p.sendMessage("NegX");//weiter
		}
		if (d == Directions.PosZ) {
			BuildBlocks.setPillow(loc.add(0, 0, 1), 5, "PosZ");
			p.sendMessage("PosZ");
		} else {
			BuildBlocks.setPillow(loc.add(0, 0, -1), 5, "NegZ");
			p.sendMessage("NegZ");

		}

	}
}
