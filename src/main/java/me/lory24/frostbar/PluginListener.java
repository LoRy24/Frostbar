package me.lory24.frostbar;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PluginListener implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onPlayerJoin(PlayerJoinEvent event) {
        Frostbar.getInstance().getFrostbarManager().addFrostbar(event.getPlayer());
        Frostbar.getInstance().getFrostbarManager().getPlayersBars()
                .get(event.getPlayer()).frostbarBar.initBossBar();
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerQuit(PlayerQuitEvent event) {
        if (!Frostbar.getInstance().getFrostbarManager().getPlayersBars().containsKey(event.getPlayer())) return;
        Frostbar.getInstance().getFrostbarManager().removeFrostbar(event.getPlayer());
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerDeath(PlayerDeathEvent event) {
        Frostbar.getInstance().getFrostbarManager().getPlayersBars().get(event.getEntity()).isPlayerRespawned = false;
        Frostbar.getInstance().getFrostbarManager().getPlayersBars().get(event.getEntity()).frostbarBar
                .updateValue(0.0D).updateChanges();
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        Frostbar.getInstance().getFrostbarManager().getPlayersBars().get(event.getPlayer())
                .isPlayerRespawned = true;
    }
}
