package com.paperbenni.mineglory.moba.map;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class MobaBeacon {
	private static final Location OrangeBeacon = new Location(Bukkit.getWorld("world"), 500.0, 128.0, 0.0);
	private static final Location BlueBeacon = new Location(Bukkit.getWorld("world"), -50.0, 128.0, 0.0);

	public static Location getOrageBeacon() {
		return OrangeBeacon;
	}

	public static Location getBlueBeacon() {
		return BlueBeacon;
	}

}