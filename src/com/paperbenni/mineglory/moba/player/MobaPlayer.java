package com.paperbenni.mineglory.moba.player;

import java.util.Collection;
import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import com.paperbenni.mineglory.moba.item.BuildItems;
import com.paperbenni.mineglory.moba.map.MobaBeacon;

public class MobaPlayer {
	public static Boolean ORANGE = true;
	public static Boolean BLUE = false;

	private Boolean team = false;
	private Player player;
	private Integer Mana = 0;

	public static Boolean currentTeam = false;
	
	public void addMana(Integer amount) {
		this.Mana += amount;
	}

	public void takeMana(Integer amount) {
		this.Mana -= amount;
	}

	public Integer getMana() {
		return this.Mana;
	}

	public void setMana(Integer amount) {
		this.Mana = amount;
	}

	private static HashMap<Player, MobaPlayer> registry = new HashMap<Player, MobaPlayer>();

	public MobaPlayer(Player player) {
		this.setPlayer(player);
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public static void addPlayer(Player player) {
		MobaPlayer mo = new MobaPlayer(player);
		registry.put(player, mo);
	}

	public Player getPlayer() {
		return this.player;
	}

	public static MobaPlayer getMobaPlayer(Player player) {
		return registry.get(player);
	}

	public static Collection<MobaPlayer> getPlayers() {
		return registry.values();
	}

	public static void removePlayer(Player player) {
		registry.remove(player);
	}

	public void setTeam(Boolean team) {
		this.team = team;
		if (team == ORANGE) {
			this.player.sendMessage("You joined the Orange team");
			if (!(MobaBeacon.getOrageBeacon().getBlock().getType().equals(Material.EMERALD_BLOCK))) {
				MobaBeacon.getOrageBeacon().getBlock().setType(Material.EMERALD_BLOCK);
				MobaBeacon.getOrageBeacon().add(new Vector(1,0,0)).getBlock().setType(Material.IRON_BLOCK);
			}
			Location PlayerLoc = MobaBeacon.getOrageBeacon().clone().add(new Vector(0.5, 2.0, 0.5));
			this.player.teleport(PlayerLoc);
		} else {
			if (!(MobaBeacon.getBlueBeacon().getBlock().getType().equals(Material.LAPIS_BLOCK))) {
				MobaBeacon.getBlueBeacon().getBlock().setType(Material.LAPIS_BLOCK);
				MobaBeacon.getBlueBeacon().subtract(new Vector(1,0,0)).getBlock().setType(Material.IRON_BLOCK);

			}
			this.player.sendMessage("You joined the Blue team");
			Location PlayerLoc = MobaBeacon.getBlueBeacon().clone().add(new Vector(0.5, 2.0, 0.5));
			this.player.teleport(PlayerLoc);
		}

	}

	public Boolean getTeam() {
		return this.team;
	}

	public Location getSpawn() {
		if (this.team == ORANGE) {
			return MobaBeacon.getOrageBeacon();
		} else {
			return MobaBeacon.getBlueBeacon();
		}
	}

	public void setup() {
		Player p = this.player;
		BuildItems.giveBridge(p);
		BuildItems.givePlatform(p);
		BuildItems.giveBooster(p);
		BuildItems.giveStairs(p);
		p.setFallDistance(10);
		Inventory i = p.getInventory();
		ItemStack sword = new ItemStack(Material.IRON_SWORD);
		ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE);
		ItemStack pick = new ItemStack(Material.DIAMOND_PICKAXE);
		i.addItem(sword);
		i.addItem(chestplate);
		i.addItem(pick);
		
		this.setTeam(currentTeam);
		
		if(currentTeam == false) {
			currentTeam = true;
		} else {
			currentTeam = true;
		}
		
	}

	public static void sendMessage(Boolean team, String message) {
		if (registry.isEmpty()) {
			return;
		}
		for (MobaPlayer player : registry.values()) {
			if (player.getTeam() == team) {
				player.getPlayer().sendMessage(message);
			}
		}
	}

	public void PlayerTick() {
		this.addMana(1);
	}
}
