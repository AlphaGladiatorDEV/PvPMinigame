package com.infinity.pvp.listeners;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class GameTeleporter implements Listener{
	
	@EventHandler
	public void pJoinEvent(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if(PlayerOnlineListener.min_players_yet == true){
			List<Player> players = null;
			PlayerOnlineListener.alivePlayers = players;
			World world = p.getWorld();
			Location loc1 = new Location(world, -348, 6, 33);
			Location loc2 = new Location(world, -344, 6, 33);
			Location loc3 = new Location(world, -340, 6, 33);
			Location loc4 = new Location(world, -333, 6, 26);
			Location loc5 = new Location(world, -333, 6, 22);
			Location loc6 = new Location(world, -333, 6, 18);
			Location loc7 = new Location(world, -340, 6, 11);
			Location loc8 = new Location(world, -344, 6, 11);
			Location loc9 = new Location(world, -348, 6, 11);
			Location loc10 = new Location(world, -355, 6, 18);
			Location loc11 = new Location(world, -355, 6, 22);
			Location loc12 = new Location(world, -355, 6, 26);
			Player p1 = PlayerOnlineListener.alivePlayers.get(0);
			Player p2 = PlayerOnlineListener.alivePlayers.get(1);;
			Player p3 = PlayerOnlineListener.alivePlayers.get(2);;
			Player p4 = PlayerOnlineListener.alivePlayers.get(3);;
			Player p5 = PlayerOnlineListener.alivePlayers.get(4);;
			Player p6 = PlayerOnlineListener.alivePlayers.get(5);;
			Player p7 = PlayerOnlineListener.alivePlayers.get(6);;
			Player p8 = PlayerOnlineListener.alivePlayers.get(7);;
			Player p9 = PlayerOnlineListener.alivePlayers.get(8);;
			Player p10 = PlayerOnlineListener.alivePlayers.get(9);;
			Player p11 = PlayerOnlineListener.alivePlayers.get(10);;
			Player p12 = PlayerOnlineListener.alivePlayers.get(11);;
			p1.teleport(loc1);
			p2.teleport(loc2);
			p3.teleport(loc3);
			p4.teleport(loc4);
			p5.teleport(loc5);
			p6.teleport(loc6);
			p7.teleport(loc7);
			p8.teleport(loc8);
			p9.teleport(loc9);
			p10.teleport(loc10);
			p11.teleport(loc11);
			p12.teleport(loc12);
		}
	}

}
