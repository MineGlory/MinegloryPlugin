package com.paperbenni.mineglory.moba.item;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BuildItems {

	public static void giveWall(Player player) {
		ItemStack i = new ItemStack(Material.WOOD_SPADE);
		i.setDurability((short) 1);
		ItemMeta meta = i.getItemMeta();
		meta.setUnbreakable(true);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
		meta.setDisplayName("Wall");
		i.setItemMeta(meta);
		player.getInventory().addItem(i);
	}
	
	
}
