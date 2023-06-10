package me.daniel.bedwarsplugin.listener;

import me.daniel.bedwarsplugin.model.BlockDeleter;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;

/**
 * Author: Daniel Dmytryszyn
 * Class for handling the onBlockDestroy event.
 */
public class OnBlockDestroyEvent implements Listener {

    private final BlockDeleter blockDeleter;

    public OnBlockDestroyEvent(BlockDeleter blockDeleter) {
        this.blockDeleter = blockDeleter;
    }


    /**
     * Cancels the onBlockDestroy event if the player is in creative mode.
     * If the player is not in creative mode,
     * the event is canceled and the block is removed from the list of blocks placed.
     * @param event the event
     */
    @EventHandler
    public void onBlockDestroy(BlockDamageEvent event) {
        Material blockMaterial = event.getBlock().getType();
        Player player = event.getPlayer();
        if (player.getGameMode() == GameMode.CREATIVE) return;

        if (blockMaterial == Material.RED_WOOL || blockMaterial == Material.LIGHT_BLUE_WOOL) {
            event.setCancelled(false);

            Location location = event.getBlock().getLocation();
            blockDeleter.removeBlock(location);

            return;
        }
        event.setCancelled(true);

    }
}
