package me.lory24.frostbar.config;

import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigValues {
    @Getter private final String bossBarTitle;
    @Getter private final double snowFreeze;
    @Getter private final double iceFreeze;
    @Getter private final double torchRegen;
    @Getter private final FreezeArea freezeArea;
    @Getter private final CFrozenState cFrozenState;
    @Getter private final double normalRegen;

    public ConfigValues(FileConfiguration config) {
        bossBarTitle = parseColors(config.getString("Settings.BossbarTitle"));
        snowFreeze = config.getDouble("Settings.FreezingState.SnowFreeze");
        iceFreeze = config.getDouble("Settings.FreezingState.IceFreeze");
        freezeArea = new FreezeArea(Integer.parseInt(config.getString("Settings.FreezeArea.AreaRange")));
        cFrozenState = new CFrozenState(config.getInt("Settings.FrozenState.DamageTicks"), config.getInt(
                "Settings.FrozenState.FreezeDamage"), parseColors(config.getString("Settings.FrozenState.FrozenMessage")));
        torchRegen = config.getDouble("Settings.FreezingState.TorchRegeneration");
        normalRegen = config.getDouble("Settings.NormalRegen");
    }

    private String parseColors(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
