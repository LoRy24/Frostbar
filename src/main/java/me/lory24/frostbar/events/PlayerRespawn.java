package me.lory24.frostbar.events;

import me.lory24.frostbar.Frostbar;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawn extends EventExecutor<PlayerRespawnEvent> {

    @Override
    public void executeEvent(PlayerRespawnEvent event) {
        Frostbar.getInstance().getFrostbarManager().getPlayersBars().get(event.getPlayer())
                .isPlayerRespawned = true;
    }
}
