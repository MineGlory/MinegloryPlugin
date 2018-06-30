package com.paperbenni.mineglory.moba.player;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import com.paperbenni.mineglory.moba.map.MobaBeacon;

public class MobaPlayer {
	public static Boolean ORANGE = true;
	public static Boolean BLUE = false;
	
	private Boolean team = false;
	private Player player;
	private static HashMap<Player, MobaPlayer> registry = new HashMap<Player, MobaPlayer>();
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public static void addPlayer(Player player, Boolean team) {
		MobaPlayer mo = new MobaPlayer();
		mo.setTeam(team);
		mo.setPlayer(player);
		registry.put(player, mo);
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public static MobaPlayer getMobaPlayer(Player player) {
		return registry.get(player);
	}
	public static void removePlayer(Player player) {
		registry.remove(player);
	}
	
	
	public void setTeam(Boolean team) {
		this.team = team;
		if(team == ORANGE) {
			this.player.sendMessage("You joined the Orange team");
			this.player.teleport(MobaBeacon.OrangeBeacon.add(new Vector(0,2,0)));
		} else {
			this.player.sendMessage("You joined the Blue team");
			this.player.teleport(MobaBeacon.BlueBeacon.add(new Vector(0,2,0)));
		}
			
	}
	public Boolean getTeam() {
		return this.team;
	}
	
	public static void sendMessage(Boolean team, String message) {
		if(registry.isEmpty()) {
			return;
		}
		for(MobaPlayer player : registry.values()) {
			if(player.getTeam() == team) {
				player.getPlayer().sendMessage(message);
			}
		}
	}
}