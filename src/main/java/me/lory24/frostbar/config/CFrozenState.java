package me.lory24.frostbar.config;

import lombok.Getter;

public class CFrozenState {
    @Getter private final int damageTicks;
    @Getter private final int freezeDamage;
    @Getter private final String frozenMessage;

    public CFrozenState(int damageTicks, int freezeDamage, String frozenMessage) {
        this.freezeDamage = freezeDamage;
        this.frozenMessage = frozenMessage;
        this.damageTicks = damageTicks;
    }
}
