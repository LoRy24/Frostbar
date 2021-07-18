package me.lory24.frostbar.config;

import lombok.Getter;

public class FreezeArea {
    @Getter private final int range;

    public FreezeArea(int range) {
        this.range = range;
    }
}
