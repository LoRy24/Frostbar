package me.lory24.frostbar.freezecore;

import me.lory24.frostbar.Frostbar;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PFreezeStats {
    private final int torchInArea;
    private final int snowInArea;
    private final int iceInArea;

    public static PFreezeStats generateFreezeStats(@NotNull Player player) {
        int torches = 0, snow = 0, ice = 0;
        int range = Frostbar.getInstance().getConfigValues().getFreezeArea().getRange();
        for (int y = -2; y <= 0x4; y++) {
            for (int x = -range; x < range; x++) {
                for (int z = -range; z < range; z++) {
                    Location blockLoc = new Location(player.getLocation().getWorld(), player.getLocation().getX() + x,
                            player.getLocation().getY() + y, player.getLocation().getZ() + z);
                    if (player.getWorld().getBlockAt(blockLoc).getType().equals(Material.TORCH)) torches++;
                    if (player.getWorld().getBlockAt(blockLoc).getType().equals(Material.SNOW) || player.getWorld().getBlockAt(blockLoc)
                            .getType().equals(Material.SNOW_BLOCK)) snow++;
                    if (player.getWorld().getBlockAt(blockLoc).getType().equals(Material.ICE) || player.getWorld().getBlockAt(blockLoc).getType().equals(Material.FROSTED_ICE) ||
                            player.getWorld().getBlockAt(blockLoc).getType().equals(Material.PACKED_ICE)) ice++;
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

    public int getTorchInArea() {
        return torchInArea;
    }

    public int getSnowInArea() { return snowInArea; }

    public int getIceInArea() {
        return iceInArea;
    }
}
