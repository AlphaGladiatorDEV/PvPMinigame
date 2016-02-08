package com.infinity.pvp.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener{
	
	@EventHandler
	public void pChatEvent(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		if(PlayerOnlineListener.alivePlayers.contains(p)){
			return;
		}else if(!PlayerOnlineListener.alivePlayers.contains(p)){
			e.setCancelled(true);
			p.sendMessage("" + ChatColor.RED + ChatColor.BOLD + "FFA PvP" + ChatColor.RESET + ChatColor.GRAY + " >>> " + ChatColor.RESET + ChatColor.RED + "You cannot chat because you could possibly give player location spoilers!");
			return;
		}
	}

}
