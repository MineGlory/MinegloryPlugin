package com.paperbenni.mineglory.moba.item;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BuildItems {

	public static void giveBridge(Player player) {
		giveCustomItem(player, "Bridge",(short) 1);
	}
	
	public static void givePlatform(Player player) {
		giveCustomItem(player, "Platform", (short) 2);
	}
	
	public static void giveBooster(Player player) {
		giveCustomItem(player, ChatColor.RED + "Booster", (short) 3);
	}
	
	public static void giveStairs(Player player) {
		giveCustomItem(player, ChatColor.BLUE + "Stairs", (short) 4);
	}
	
	public static void giveCustomItem(Player player, String name, short durability) {
		ItemStack i = new ItemStack(Material.WOOD_SPADE);
		i.setDurability(durability);
		ItemMeta meta = i.getItemMeta();
		meta.setUnbreakable(true);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
		meta.setDisplayName(name);
		i.setItemMeta(meta);
		player.getInventory().addItem(i);
	}
	
	
}
