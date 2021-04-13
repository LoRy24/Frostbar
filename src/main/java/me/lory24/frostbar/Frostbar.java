package me.lory24.frostbar;

import me.lory24.frostbar.config.ConfigValues;
import me.lory24.frostbar.freezecore.FrostbarManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Frostbar extends JavaPlugin {

    private static Frostbar instance;
    private ConfigValues configValues;
    private FrostbarManager frostbarManager;

    @Override
    public void onEnable() {
        getLogger().info("Enabling plugin features, wait...");
        instance = this;
        instance.saveDefaultConfig();
        configValues = new ConfigValues(this.getConfig());
        frostbarManager = new FrostbarManager();
        Bukkit.getPluginManager().registerEvents(new PluginListener(), this);
        for (Player player : Bukkit.getOnlinePlayers()) {
            getFrostbarManager().addFrostbar(player);
            getFrostbarManager().getPlayersBars().get(player).frostbarBar.initBossBar();
        }
        getLogger().info("Plugin enabled!");
    }

    @Override
    public void onDisable() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            getFrostbarManager().getPlayersBars().get(player).frostbarBar.bossBar.setVisible(false);
            getFrostbarManager().backupPlayersBars.get(player)
                    .frostbarBar.bossBar.setVisible(false);
        }
        getLogger().info("Plugin disabled!");
    }

    public static Frostbar getInstance() { return instance; }

    public ConfigValues getConfigValues() {
        return configValues;
    }

    public FrostbarManager getFrostbarManager() {
        return frostbarManager;
    }
}
