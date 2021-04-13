package me.lory24.frostbar.events;

import me.lory24.frostbar.Frostbar;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit extends EventExecutor<PlayerQuitEvent> {

    @Override
    public void executeEvent(PlayerQuitEvent event) {
        if (!Frostbar.getInstance().getFrostbarManager().getPlayersBars().containsKey(event.getPlayer())) return;
        Frostbar.getInstance().getFrostbarManager().removeFrostbar(event.getPlayer());
    }
}
