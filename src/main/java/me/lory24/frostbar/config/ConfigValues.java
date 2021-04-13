package me.lory24.frostbar.config;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigValues {
    private final String bossBarTitle;
    private final double snowFreeze;
    private final double iceFreeze;
    private final double torchRegen;
    private final FreezeArea freezeArea;
    private final CFrozenState cFrozenState;
    private final double normalRegen;

    public ConfigValues(FileConfiguration config) {
        bossBarTitle = parseColors(config.getString("Settings.BossbarTitle"));
        snowFreeze = config.getDouble("Settings.FreezingState.SnowFreeze");
        iceFreeze = config.getDouble("Settings.FreezingState.IceFreeze");
        freezeArea = new FreezeArea(Integer.parseInt(config.getString("Settings.FreezeArea.AreaRange")));
        cFrozenState = new CFrozenState(config.getInt("Settings.FrozenState.DamageTicks"),
                config.getInt("Settings.FrozenState.FreezeDamage"), parseColors(config
                .getString("Settings.FrozenState.FrozenMessage")));
        torchRegen = config.getDouble("Settings.FreezingState.TorchRegeneration");
        normalRegen = config.getDouble("Settings.NormalRegen");
    }

    private String parseColors(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    /* ********************************************************************************************************* */

    public String getBossBarTitle() {
        return bossBarTitle;
    }

    public double getSnowFreeze() { return snowFreeze; }

    public double getIceFreeze() {
        return iceFreeze;
    }

    public FreezeArea getFreezeArea() {
        return freezeArea;
    }

    public CFrozenState getcFrozenState() {
        return cFrozenState;
    }

    public double getTorchRegen() {
        return torchRegen;
    }

    public double getNormalRegen() {
        return normalRegen;
    }
}
