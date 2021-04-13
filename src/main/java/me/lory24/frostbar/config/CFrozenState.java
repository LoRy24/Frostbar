package me.lory24.frostbar.config;

public class CFrozenState {
    private final int damageTicks;
    private final int freezeDamage;
    private final String frozenMessage;

    public CFrozenState(int damageTicks, int freezeDamage, String frozenMessage) {
        this.damageTicks = damageTicks;
        this.freezeDamage = freezeDamage;
        this.frozenMessage = frozenMessage;
    }

    public int getDamageTicks() {
        return damageTicks;
    }

    public int getFreezeDamage() {
        return freezeDamage;
    }

    public String getFrozenMessage() {
        return frozenMessage;
    }
}
