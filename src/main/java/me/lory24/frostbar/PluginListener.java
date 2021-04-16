package me.lory24.frostbar;

import me.lory24.frostbar.events.PlayerDied;
import me.lory24.frostbar.events.PlayerJoin;
import me.lory24.frostbar.events.PlayerQuit;
import me.lory24.frostbar.events.PlayerRespawn;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PluginListener implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onPlayerJoin(PlayerJoinEvent event) { 
        new PlayerJoin().executeEvent(event); 
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerQuit(PlayerQuitEvent event) { 
        new PlayerQuit().executeEvent(event); 
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerDeath(PlayerDeathEvent event) { new PlayerDied().executeEvent(event); }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        new PlayerRespawn().executeEvent(event);
    }
}
