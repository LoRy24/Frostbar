package me.lory24.frostbar.events;

import me.lory24.frostbar.Frostbar;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.NotNull;

public class PlayerJoin extends EventExecutor<PlayerJoinEvent> {

    @Override
    public void executeEvent(@NotNull PlayerJoinEvent event) {
        Frostbar.getInstance().getFrostbarManager().addFrostbar(event.getPlayer());
        Frostbar.getInstance().getFrostbarManager().getPlayersBars().get(event.getPlayer())
                .frostbarBar.initBossBar();
    }
}
