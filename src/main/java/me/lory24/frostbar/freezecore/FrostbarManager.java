package me.lory24.frostbar.freezecore;

import me.lory24.frostbar.Frostbar;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class FrostbarManager {
    public final HashMap<Player, PFreezeCore> playersBars;
    public final HashMap<Player, PFreezeCore> backupPlayersBars;

    public FrostbarManager() {
        playersBars = new HashMap<>();
        backupPlayersBars = new HashMap<>();
    }

    public void addFrostbar(Player player) {
        playersBars.put(player, new PFreezeCore(new FrostbarBossBar(BarColor.BLUE, BarStyle.SOLID, player)));
        backupPlayersBars.put(player, playersBars.get(player));
        playersBars.get(player).loopID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Frostbar.getInstance(), () -> {
            if (!playersBars.containsKey(player)) {
                Bukkit.getScheduler().cancelTask(backupPlayersBars.get(player).loopID);
                backupPlayersBars.remove(player);
                return;
            }
            playersBars.get(player).updateFreezeState(PFreezeStats.generateFreezeStats(player));
        }, 0, 2);
    }

    public void removeFrostbar(Player player) {
        playersBars.remove(player);
    }

    public HashMap<Player, PFreezeCore> getPlayersBars() {
        return playersBars;
    }
}
