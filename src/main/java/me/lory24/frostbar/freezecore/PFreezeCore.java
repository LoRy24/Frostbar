package me.lory24.frostbar.freezecore;

import me.lory24.frostbar.config.CFrozenState;
import me.lory24.frostbar.config.ConfigValues;
import me.lory24.frostbar.Frostbar;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

@SuppressWarnings("FieldCanBeLocal")
public class PFreezeCore {
    public final FrostbarBossBar frostbarBar;
    private final Player player;
    protected int loopID;
    private boolean frozenMessageSent = false;
    private int damageLoopID;
    private boolean damagingLoopStarted = false;
    public boolean isPlayerRespawned = true;

    public PFreezeCore(FrostbarBossBar frostbarBar) {
        this.frostbarBar = frostbarBar;
        player = frostbarBar.getOwner();
    }

    public void updateFreezeState(PFreezeStats stats) {
        ConfigValues configValues = Frostbar.getInstance().getConfigValues();
        CFrozenState frozenState = configValues.getcFrozenState();

        if (player.hasPermission("freeze.bypass")) return;

        if (!isPlayerRespawned) return;

        Frostbar.getInstance().getFrostbarManager().getPlayersBars().get(player).frostbarBar
                .bossBar.setVisible(frostbarBar.getValue() != 0.0);

        if (stats.getIceInArea() == 0x0 && stats.getSnowInArea() == 0x0 && stats.getTorchInArea() == 0x0) {
            if (frostbarBar.getValue() == 0.0D) return;
            frostbarBar.updateValue(frostbarBar.getValue() - configValues.getNormalRegen()).updateChanges();
            return;
        }

        if (frostbarBar.getValue() == 1.0D) {
            if (!frozenMessageSent) player.sendMessage(frozenState.getFrozenMessage());
            frozenMessageSent = true;
            startFreezingLoop(frozenState);
            frostbarBar.updateValue(frostbarBar.getValue() - (stats.getTorchInArea() * configValues.getTorchRegen())).updateChanges();
            return;
        }

        frozenMessageSent = false;
        frostbarBar.updateValue(frostbarBar.getValue() + ((stats.getSnowInArea() *
                configValues.getSnowFreeze()) + (
                        stats.getIceInArea() * configValues.getIceFreeze())) - (stats.getTorchInArea() *
                configValues.getTorchRegen()))
        .updateChanges();
    }

    private void startFreezingLoop(CFrozenState state) {
        if (damagingLoopStarted) return;
        damagingLoopStarted = true;
        damageLoopID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Frostbar.getInstance(), () -> {
            if (frostbarBar.getValue() != 1.0D) {
                damagingLoopStarted = false;
                frozenMessageSent = false;
                Bukkit.getScheduler().cancelTask(damageLoopID);
                return;
            }
            if (player.getHealth() - state.getFreezeDamage() < 0x0) {
                player.setHealth(0x0);
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_DEATH, 8, 2);
                return;
            }
            player.setHealth(player.getHealth() - state.getFreezeDamage());
            player.playSound(player.getLocation(),
                    Sound.ENTITY_PLAYER_HURT, 8, 4);
        }, 0x0, state.getDamageTicks());
    }
}
