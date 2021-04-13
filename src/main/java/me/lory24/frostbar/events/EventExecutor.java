package me.lory24.frostbar.events;

import org.bukkit.event.Event;

public abstract class EventExecutor<T extends Event> {
    public abstract void executeEvent(T event);
}
