package com.paperbenni.mineglory.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteract implements Listener {

	@EventHandler
	public void OnInteract(PlayerInteractEvent event) {
		if(event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
			Player p = event.getPlayer();

			ItemStack i = event.getItem();
			if(i.getItemMeta().getDisplayName().equals("1Wall")) {
				p.sendMessage("You leftclicked with this a wall");
			}
		}
		
	}
}
