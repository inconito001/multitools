package fr.inconito001.multitools.listener;

import fr.inconito001.multitools.Multitools;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class WorldListener implements Listener {

    private Multitools plugin;

    public WorldListener(Multitools plugin) {
        this.plugin = plugin;
        System.out.println("WorldListener initialized");
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Block block = event.getBlock();

        System.out.println("Block: " + block.getType().name());

        if (block.getType().name().contains("LOG")) {
            this.checkUpon(block);
        }
    }

    private void checkUpon(Block block) {
        Location location = block.getLocation();
        Location uponLocation = new Location(location.getWorld(), location.getX(), location.getY() + 1, location.getZ());

        Block uponBlock = uponLocation.getBlock();
        if (uponBlock.getType().name().contains("LOG")) {
            checkUpon(uponBlock);
            block.breakNaturally();
        }
    }
}
