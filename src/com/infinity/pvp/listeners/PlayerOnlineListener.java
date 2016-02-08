package com.infinity.pvp.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R2.CraftServer;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

import com.infinity.pvp.gui.StatsScoreboard;

public class PlayerOnlineListener implements Listener{
	
	public static List<Player> alivePlayers = new ArrayList<Player>(); 
  
  public static boolean min_players_yet = false;
  public static int min_players = 2;
  
  @EventHandler
  public void PlayerJoinEvent(PlayerJoinEvent e){
	  Player p = e.getPlayer();
	  e.setJoinMessage(null);
	  p.getInventory().clear();
	  ItemStack air = new ItemStack(Material.AIR);
	  p.getInventory().setHelmet(air);
	  p.getInventory().setChestplate(air);
	  p.getInventory().setLeggings(air);
	  p.getInventory().setBoots(air);
	  alivePlayers.add(p);
	  for (Player all : Bukkit.getOnlinePlayers()){
		  StatsScoreboard.setupScoreboard(all);
	  }
	  if(alivePlayers.size() == min_players || min_players_yet == true){
		  min_players_yet = true;
		  Bukkit.broadcastMessage("" + ChatColor.BOLD + ChatColor.RED + "FFA PvP" + ChatColor.RESET + ChatColor.GRAY + " >>> " + ChatColor.GREEN + "The game has started!");
	  }else{
		  int players_needed = min_players - alivePlayers.size();
		  Bukkit.broadcastMessage("" + ChatColor.RED + ChatColor.BOLD + "FFA PvP" + ChatColor.GRAY + " >>> " + players_needed + ChatColor.GOLD + " players needed until the game can start.");
	  }
	  p.sendMessage(ChatColor.DARK_RED + "=========================");
	  p.sendMessage("" + ChatColor.GOLD + "Map: " + ChatColor.GREEN + ChatColor.BOLD + p.getWorld().getName() + ChatColor.RESET + ChatColor.GOLD + " made by " + ChatColor.AQUA + ChatColor.BOLD + "xXInfinityXx");
	  p.sendMessage(ChatColor.DARK_RED + "=========================");
	  
  }
  @EventHandler
  public void PlayerExitEvent(PlayerQuitEvent e){
	  Player p = e.getPlayer();
	  String pname = p.getName();
	  e.setQuitMessage("" + ChatColor.RED + ChatColor.BOLD + "Quit " + ChatColor.GRAY + ">>> " + ChatColor.RESET + pname);
	  alivePlayers.remove(p);
	  for (Player all : Bukkit.getOnlinePlayers()){
		  StatsScoreboard.setupScoreboard(all);
	  }
	  if(alivePlayers.size() == min_players || min_players_yet == true){
		  min_players_yet = true;
		  Bukkit.broadcastMessage("" + ChatColor.BOLD + ChatColor.RED + "FFA PvP" + ChatColor.RESET + ChatColor.GRAY + " >>> " + ChatColor.GREEN + "The game has started!");
	  }else{
		  int players_needed = min_players - alivePlayers.size();
		  Bukkit.broadcastMessage("" + ChatColor.RED + ChatColor.BOLD + "FFA PvP" + ChatColor.GRAY + " >>> " + players_needed + ChatColor.GOLD + " players needed until the game can start.");
	  }
  }
  
  
  public void respawnPlayer(Player paramPlayer) {
	  if (paramPlayer.isDead())
	  ((CraftServer)Bukkit.getServer()).getHandle().moveToWorld(((CraftPlayer)paramPlayer).getHandle(), 0, false);
	}

  
  @EventHandler
  public void YaDead(PlayerDeathEvent e){
	  
	  //Variables\\
	  Player p = e.getEntity();
	  String pname = p.getName();
	  Player k = p.getKiller();
	  String kname = k.getName();
	  Location eloc = p.getLocation();
	  
	  //Statistics Update & Player Death Announciation\\
	  alivePlayers.remove(p);
	  int aplayers = alivePlayers.size();
	  k.getWorld().strikeLightningEffect(eloc);
	  e.setDeathMessage("" + ChatColor.RED + ChatColor.BOLD + "FFA PvP" + ChatColor.GRAY + " >>> " + ChatColor.GREEN + ChatColor.BOLD + pname + ChatColor.RESET + ChatColor.GOLD + " was killed by " + ChatColor.DARK_RED + ChatColor.BOLD + kname + ChatColor.RESET + ChatColor.GOLD + "!");
	  p.sendMessage("" + ChatColor.RED + ChatColor.BOLD + "FFA PvP" + ChatColor.GRAY + " >>> " + "You were killed by " + ChatColor.DARK_RED + ChatColor.BOLD + kname + ChatColor.RESET + ChatColor.GOLD + "!");
	  k.sendMessage("" + ChatColor.RED + ChatColor.BOLD + "FFA PvP" + ChatColor.GRAY + " >>> " + "You killed " + ChatColor.GOLD + ChatColor.BOLD + pname + ChatColor.RESET + ChatColor.GREEN + "!");
	  Bukkit.broadcastMessage("" + ChatColor.GOLD + "Game " + ChatColor.GRAY + ">>> " + ChatColor.GOLD + "There are " + ChatColor.GREEN + aplayers + ChatColor.RESET + ChatColor.GOLD + " players remaning.");
	  for (Player all : Bukkit.getOnlinePlayers()){
		  all.playSound(all.getLocation(), Sound.AMBIENCE_CAVE, 1.5f, 1f);
		  StatsScoreboard.setupScoreboard(all);
	  }
	  
	  //Player Update
	  respawnPlayer(p);
	  p.setGameMode(GameMode.SPECTATOR);
	  for (Player all : Bukkit.getOnlinePlayers()){
		  all.hidePlayer(p);
	  }
	  
	  //Game Finish
	  if(alivePlayers.size() == 1){
		  Bukkit.broadcastMessage("" + ChatColor.RED + ChatColor.BOLD + "FFA PvP" + ChatColor.GRAY + " >>> " + ChatColor.GOLD + ChatColor.BOLD + kname + ChatColor.RESET + ChatColor.GREEN + " has won!");
	  }
	  
  }
  
  
  
}
  
