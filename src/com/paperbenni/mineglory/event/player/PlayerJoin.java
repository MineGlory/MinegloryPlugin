package com.paperbenni.mineglory.event.player;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import com.paperbenni.mineglory.Mineglory;
import com.paperbenni.mineglory.moba.player.MobaPlayer;

public class PlayerJoin implements Listener {

	private final Mineglory mineglory;

	public PlayerJoin(Mineglory mineglory) {
		this.mineglory = mineglory;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		p.sendMessage("Welcome to MineGlory");
		Boolean team = false;
		if (Math.round(Math.random()) == 1) {
			team = true;
		} else {
			team = false;
		}
		p.getInventory().clear();
		MobaPlayer.addPlayer(p, team);
		MobaPlayer mp = MobaPlayer.getMobaPlayer(p);
		mp.setup();
		ScoreboardManager m = Bukkit.getScoreboardManager();
		Scoreboard b = m.getNewScoreboard();
		Objective o = b.registerNewObjective("Mana", "");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		Team mana = b.registerNewTeam("mana");
		mana.addEntry(ChatColor.AQUA + "Mana: ");
		mana.setPrefix("");
		o.getScore(ChatColor.AQUA + "Mana: ").setScore(0);
		new BukkitRunnable() {

			@Override
			public void run() {
				mp.PlayerTick();

				mana.setSuffix("" + mp.getMana());
			}
		}.runTaskTimerAsynchronously(mineglory, 0, 50L);

		p.setScoreboard(b);

	}
}
