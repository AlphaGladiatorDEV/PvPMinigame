package com.infinity.pvp.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class PreGameListener implements Listener{
	
	@EventHandler
	public void combatEvent(EntityDamageByEntityEvent e){
		if(PlayerOnlineListener.min_players_yet == false){
			e.setCancelled(true);
		}else{
			return;
		}
	}
	
	@EventHandler
	public void moveEvent(PlayerMoveEvent e){
		if(PlayerOnlineListener.min_players_yet == false){
			e.setCancelled(true);
		}else{
			return;
		}
	}

}
