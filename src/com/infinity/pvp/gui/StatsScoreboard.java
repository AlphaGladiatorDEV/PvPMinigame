package com.infinity.pvp.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.infinity.pvp.listeners.PlayerOnlineListener;

public class StatsScoreboard implements Listener{
	
	@EventHandler 
	public void pJoinEvent(PlayerJoinEvent e){
		Player p = e.getPlayer();
		setupScoreboard(p);
	}
	
	public static void setupScoreboard(Player p){
		ScoreboardManager sm = Bukkit.getScoreboardManager();
		Scoreboard onJoin = sm.getNewScoreboard();
		Objective o = onJoin.registerNewObjective("dash", "dummy");
		
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		o.setDisplayName("" + ChatColor.RED + ChatColor.BOLD + "FFA PvP");
		
		Score plefts = null;
		Score pleft = null;
		Score line1 = null;
		Score line2 = null;
		Score bottom = null;
		
		try{
			
			line1 = o.getScore(ChatColor.BLACK+ "");
			line1.setScore(5);
			
			plefts = o.getScore(ChatColor.GREEN + "Players Left:");
			plefts.setScore(4);
			
			int value = PlayerOnlineListener.alivePlayers.size();
			pleft = o.getScore("" + value);
			pleft.setScore(3);
			
			line2 = o.getScore(ChatColor.AQUA + "");
			line2.setScore(2);
			
			bottom = o.getScore(ChatColor.WHITE + "--------");
			bottom.setScore(1);
			
			p.setScoreboard(onJoin);
		} catch (Exception ex){
			System.out.println(ex);
		}
		
	}

}
