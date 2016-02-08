package com.infinity.pvp.main;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.infinity.pvp.gui.StatsScoreboard;
import com.infinity.pvp.listeners.ChatListener;
import com.infinity.pvp.listeners.GameTeleporter;
import com.infinity.pvp.listeners.PlayerOnlineListener;
import com.infinity.pvp.listeners.PreGameListener;
import com.infinity.pvp.permissions.PrefixPerms;

public class PvP extends JavaPlugin{

  public static PvP instance;
  
   public static PvP getInstance(){
       return instance;
   }
   
   public void registerCommands(){
	   
   }
   
   public void registerClasses(){
	   PluginManager pm = Bukkit.getPluginManager();
	   pm.registerEvents(new PlayerOnlineListener(), this);
	   pm.registerEvents(new StatsScoreboard(), this);
	   pm.registerEvents(new ChatListener(), this);
	   pm.registerEvents(new PreGameListener(), this);
	   pm.registerEvents(new PrefixPerms(), this);
	   pm.registerEvents(new GameTeleporter(), this);
   }
   
   public void onEnable(){
	   Bukkit.getServer().getLogger().info("[FFA PvP] The plugin has been enabled without errors.");
	   instance = this;
	   registerCommands();
	   registerClasses();
   }
   
   public void onDisable(){
	   Bukkit.getServer().getLogger().info("[FFA PvP] The plugin has been disabled without errors.");
	   instance = null;
   }
   
   String ffas = "" + ChatColor.RED + ChatColor.BOLD + "FFA PvP" + ChatColor.GRAY + " >>> " + ChatColor.RESET;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		CommandSender p = sender;
		
		if(cmd.getName().equalsIgnoreCase("game")){
			if(args.length == 0){
				p.sendMessage(ffas + ChatColor.RED + "Invalid usage. Usage: /game <start/stop>");
				return true;
			}else if(args[0].equalsIgnoreCase("start")){
				if(p.hasPermission("FFA.Admin") || p.hasPermission("FFA.CoOwner") || p.hasPermission("FFA.Owner")){
					PlayerOnlineListener.min_players_yet = true;
					p.sendMessage(ffas + ChatColor.GREEN + "Game will start on next player quit or join.");
					return true;
				}else{
					noPermissionMessage(p);
					return true;
				}
			}else if(args[0].equalsIgnoreCase("stop")){
				if(p.hasPermission("FFA.Admin") || p.hasPermission("FFA.CoOwner") || p.hasPermission("FFA.Owner")){
					for(Player all : Bukkit.getOnlinePlayers()){
						sendToServer(all, "lobby");
					}
					return true;
				}else{
					noPermissionMessage(p);
					return true;
				}
			}else if(!args[0].isEmpty()){
				p.sendMessage(ffas + ChatColor.RED + "Invalid usage. Usage: /game <start/stop>");
				return true;
			}
		}
		
		return false;
	}
	
	public void noPermissionMessage(CommandSender p){
		p.sendMessage(ffas + ChatColor.RED + "You do not have permission to use this command.");
	}
   
   public void sendToServer(Player player, String targetServer) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
		try{
			out.writeUTF("Connect");
			out.writeUTF(targetServer);
		}catch(Exception e){
			e.printStackTrace();
		}
		player.sendPluginMessage(this, "BungeeCord", b.toByteArray());
	}
}
