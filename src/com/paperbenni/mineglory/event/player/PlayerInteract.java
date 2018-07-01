package com.paperbenni.mineglory.event.player;

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
		if (event.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
			if (event.getItem() == null)
				return;
			Player p = event.getPlayer();
			ItemStack i = event.getItem();
			if (i.getType().equals(Material.WOOD_SPADE)) {

				Short dmg = i.getDurability();
				if (dmg == 1) {
					BuildEffects.WallEffect(p, event.getClickedBlock().getLocation());
				}
				if (dmg == 2) {
					BuildEffects.PlatformEffect(p);
				}

				event.setCancelled(true);
			}

		}
		if (event.getAction().equals(Action.LEFT_CLICK_AIR)) {
			if (event.getItem() == null)
				return;
			Player p = event.getPlayer();
			ItemStack i = event.getItem();
			if (i.getType().equals(Material.WOOD_SPADE)) {
				Short dmg = i.getDurability();
				if (dmg == 2) {
					BuildEffects.PlatformEffect(p);
				}
			}
		}


	}
}
