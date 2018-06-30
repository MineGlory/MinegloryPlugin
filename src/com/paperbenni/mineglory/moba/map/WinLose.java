package com.paperbenni.mineglory.moba.map;

import com.paperbenni.mineglory.moba.player.MobaPlayer;

public class WinLose {
	public static void lose(Boolean team) {
		MobaPlayer.sendMessage(team, "Your beacon has been destroyed. better luck next time!");
	}
}
