package com.paperbenni.mineglory.event.player;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.paperbenni.mineglory.moba.item.BuildEffects;

public class PlayerInteract implements Listener {

	@EventHandler
	public void OnInteract(PlayerInteractEvent event) {
		Action a = event.getAction();

		if (a.equals(Action.LEFT_CLICK_BLOCK) || a.equals(Action.LEFT_CLICK_AIR)) {
			Player p = event.getPlayer();
			ItemStack i = event.getItem();
			if (event.getItem() == null) {
				return;
			}

			if (i.getType().equals(Material.WOOD_SPADE)) {
				Short dmg = i.getDurability();
				if (dmg == 2) {
					BuildEffects.PlatformEffect(p);
				}
				if (dmg == 3) {
					BuildEffects.BoosterEffect(p);
				}
			}

			if (a.equals(Action.LEFT_CLICK_BLOCK)) {
				Location l = event.getClickedBlock().getLocation();
				if (i.getType().equals(Material.WOOD_SPADE)) {

					Short dmg = i.getDurability();
					if (dmg == 1) {
						BuildEffects.BridgeEffect(p, l);
					}
					if (dmg == 2) {
						BuildEffects.PlatformEffect(p);
					}
					if (dmg == 4) {
						BuildEffects.StairsEffect(p, l);
					}

					event.setCancelled(true);
				}
				if (i.getType().equals(Material.DIAMOND_PICKAXE)) {
					event.getClickedBlock().setType(Material.AIR);
				}
			}

		}

	}
}
