package me.lory24.frostbar.freezecore;

import lombok.Getter;
import me.lory24.frostbar.Frostbar;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PFreezeStats {
    @Getter private final int torchInArea;
    @Getter private final int snowInArea;
    @Getter private final int iceInArea;

    public static PFreezeStats generateFreezeStats(@NotNull Player player) {
        int torches = 0, snow = 0, ice = 0;
        int range = Frostbar.getInstance().getConfigValues().getFreezeArea().getRange();
        for (int y = -2; y <= 0x4; y++) {
            for (int x = -range; x < range; x++) {
                for (int z = -range; z < range; z++) {
                    Location blockLoc = new Location(player.getLocation().getWorld(), player.getLocation().getX() + x,
                            player.getLocation().getY() + y, player.getLocation().getZ() + z);

                    torches += player.getWorld().getBlockAt(blockLoc).getType().equals(Material.TORCH) ? 1 : 0;

                    ice += player.getWorld().getBlockAt(blockLoc).getType().equals(Material.ICE) || player.getWorld().getBlockAt(blockLoc)
                            .getType().equals(Material.FROSTED_ICE) || player.getWorld().getBlockAt(blockLoc).getType().equals(Material.PACKED_ICE) ? 1 : 0;
                    snow += player.getWorld().getBlockAt(blockLoc).getType().equals(Material.SNOW) || player.getWorld()
                            .getBlockAt(blockLoc).getType().equals(Material.SNOW_BLOCK) ? 1 : 0;
                }
            }
        }
        return new PFreezeStats(torches, snow, ice);
    }

    public PFreezeStats(int torchInArea, int snowBlocksInArea, int iceBlocksInArea) {
        this.torchInArea = torchInArea;
        this.snowInArea = snowBlocksInArea;
        this.iceInArea = iceBlocksInArea;
    }
}
