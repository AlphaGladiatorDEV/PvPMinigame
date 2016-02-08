package com.infinity.pvp.permissions;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PrefixPerms implements Listener{
	
	@EventHandler
	public void playerChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String pname = p.getName();
		if(p.hasPermission("FFA.Mod")){
			String mod = "" + ChatColor.BLACK + "[" + ChatColor.WHITE + ChatColor.BOLD + "Siren" + ChatColor.BLACK + "] " + ChatColor.GOLD + pname + ChatColor.GRAY + " >>> " + ChatColor.RESET + e.getMessage();
			e.setFormat(mod);
		}else if(p.hasPermission("FFA.Builder")){
			String builder = "" + ChatColor.BLACK + "[" + ChatColor.GREEN + ChatColor.BOLD + "Cyclops" + ChatColor.BLACK + "] " + ChatColor.GOLD + pname + ChatColor.GRAY + " >>> " + ChatColor.RESET + e.getMessage();
		    e.setFormat(builder);
		}else if(p.hasPermission("FFA.Admin")){
			String admin = "" + ChatColor.BLACK + "[" + ChatColor.DARK_RED + ChatColor.BOLD + "Minor God" + ChatColor.RESET + ChatColor.BLACK + "] " + ChatColor.GOLD +  pname + ChatColor.GRAY + " >>> " + ChatColor.RESET + e.getMessage();
		    e.setFormat(admin);
		}else if(p.hasPermission("FFA.CoOwner")){
			String coowner = "" + ChatColor.BLACK + "[" + ChatColor.AQUA + ChatColor.BOLD + "TRITON" + ChatColor.RESET + ChatColor.BLACK + "] " + ChatColor.BLACK + "[" + ChatColor.DARK_GREEN + ChatColor.BOLD + "Elder Cyclop" + ChatColor.RESET + ChatColor.BLACK + "] " + ChatColor.GOLD + ChatColor.BOLD + pname + ChatColor.GRAY + " >>> " + ChatColor.RESET + e.getMessage();
	        e.setFormat(coowner);
		}else if(p.hasPermission("FFA.Owner")){
			String owner = "" + ChatColor.BLACK + "[" + ChatColor.DARK_BLUE + ChatColor.BOLD + "POSEIDON" + ChatColor.RESET + ChatColor.BLACK + "] " + ChatColor.BLACK + "[" + ChatColor.GREEN + ChatColor.BOLD + "Cyclop" + ChatColor.BLACK +  "] " + ChatColor.GOLD + ChatColor.BOLD + pname + ChatColor.GRAY + " >>> " + ChatColor.RESET + e.getMessage();
		    e.setFormat(owner);
		}else if(!p.hasPermission("FFA.Mod") || !p.hasPermission("FFA.Builder") || !p.hasPermission("FFA.Admin") || !p.hasPermission("FFA.CoOwner") || !p.hasPermission("FFA.Owner")){
			String player = "" + ChatColor.BLACK + "[" + ChatColor.YELLOW + "Member" + ChatColor.BLACK + "] " + ChatColor.RESET + pname + ChatColor.GRAY + " >>> " + ChatColor.RESET + e.getMessage();
			e.setFormat(player);
		}
		
	}
	
}
