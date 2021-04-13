package me.lory24.frostbar.events;

import me.lory24.frostbar.Frostbar;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDied extends EventExecutor<PlayerDeathEvent> {

    @Override
    public void executeEvent(PlayerDeathEvent event) {
        Frostbar.getInstance().getFrostbarManager().getPlayersBars().get(event.getEntity()).isPlayerRespawned = false;
        Frostbar.getInstance().getFrostbarManager().getPlayersBars().get(event.getEntity()).frostbarBar
                .updateValue(0.0D).updateChanges();
    }
}
