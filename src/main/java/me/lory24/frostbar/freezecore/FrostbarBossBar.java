package me.lory24.frostbar.freezecore;

import lombok.Getter;
import me.lory24.frostbar.Frostbar;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

public class FrostbarBossBar {
    @Getter private double value = 0.0D;
    @Getter private final BarColor color;
    @Getter private final BarStyle style;
    @Getter private final Player owner;
    public final BossBar bossBar;
    @Getter private boolean visible = true;

    public FrostbarBossBar(BarColor color, BarStyle style, Player owner) {
        this.color = color;
        this.style = style;
        this.owner = owner;
        this.bossBar = Bukkit.createBossBar(Frostbar.getInstance().getConfigValues().getBossBarTitle(), this.color, this.style);
    }

    public void initBossBar() {
        this.bossBar.setVisible(visible);
        this.bossBar.setProgress(value);
        this.bossBar.addPlayer(owner);
    }

    public FrostbarBossBar setVisible(boolean value) {
        this.visible = value;
        return this;
    }

    public FrostbarBossBar updateValue(double newVal) {
        this.value = Math.max(Math.min(newVal, 1.0D), 0.0D);
        this.bossBar.setProgress(value);
        return this;
    }

    public void updateChanges() {
        bossBar.setVisible(visible);
    }
}
