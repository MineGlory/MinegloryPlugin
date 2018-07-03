package com.paperbenni.mineglory.moba.item;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import com.connorlinfoot.actionbarapi.ActionBarAPI;
import com.paperbenni.mineglory.moba.map.Directions;
import com.paperbenni.mineglory.moba.player.MobaPlayer;

public class BuildEffects {

	public static void BridgeEffect(Player p, Location loc) {
		Vector dir = Directions.getFacing(p, loc);
		BuildBlocks.setPillow(loc, 10, dir);
	}
	
	public static void StairsEffect(Player p, Location l) {
		Vector dir = Directions.getFacing(p, l);
		if(dir.equals(Directions.PosXV) || dir.equals(Directions.NegXV)) {
		BuildBlocks.Staircase(l.clone().add(new Vector(0,0,1)), dir, 5);
		BuildBlocks.Staircase(l.clone().add(new Vector(0,0,-1)), dir, 5);
		}
		if(dir.equals(Directions.PosZV) || dir.equals(Directions.NegZV)) {
		BuildBlocks.Staircase(l.clone().add(new Vector(1,0,0)), dir, 5);
		BuildBlocks.Staircase(l.clone().add(new Vector(-1,0,0)), dir, 5);
		}
		BuildBlocks.Staircase(l, dir, 5);
	}
	
	public static void BoosterEffect(Player p) {
		MobaPlayer mp = MobaPlayer.getMobaPlayer(p);
		if(mp.getMana() < 20) {
			ActionBarAPI.sendActionBar(p, "You need 40 Mana");
			return;
		}
		mp.takeMana(20);
		Directions.getFloor(p).setType(Material.REDSTONE_BLOCK);

	}

	public static void PlatformEffect(Player p) {
		MobaPlayer mp = MobaPlayer.getMobaPlayer(p);
		if(mp.getMana() < 2) {
			ActionBarAPI.sendActionBar(p, ChatColor.RED + "Need Mana", 10);
			return;
		}

		mp.takeMana(2);
		if (Directions.getFloorBlock(p).equals(Material.AIR)) {
			BuildBlocks.setPlatform(p.getLocation().subtract(new Vector(3, 2, 2)), 5);
		} else {
			BuildBlocks.setPlatform(p.getLocation().subtract(new Vector(3, 1, 2)), 5);

		}
	}
}
