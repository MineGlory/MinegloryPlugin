package com.paperbenni.mineglory.event.player;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.paperbenni.mineglory.Mineglory;
import com.paperbenni.mineglory.moba.map.WinLose;
import com.paperbenni.mineglory.moba.player.MobaPlayer;

public class DestroyBlock implements Listener {
	private final Mineglory mineglory;

	public DestroyBlock(Mineglory mineglory) {
		this.mineglory = mineglory;
	}

	@EventHandler
	public void DestroyBlockEvent(BlockBreakEvent event) {
		Block b = event.getBlock();
		if (b.getType().equals(Material.LAPIS_BLOCK)) {
			WinLose.lose(MobaPlayer.BLUE);
		}
		if (b.getType().equals(Material.EMERALD_BLOCK)) {
			WinLose.lose(MobaPlayer.ORANGE);
		}

		if (b.getType().equals(Material.EMERALD_BLOCK) || b.getType().equals(Material.LAPIS_BLOCK)) {
			new BukkitRunnable() {
				@Override
				public void run() {
					Bukkit.getServer().shutdown();
				}
			}.runTaskLater(mineglory, 500L);
		}

	}

}
