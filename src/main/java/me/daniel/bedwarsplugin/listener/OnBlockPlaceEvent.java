package me.daniel.bedwarsplugin.listener;

import me.daniel.bedwarsplugin.model.BlockDeleter;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

/**
 * Author: Jakob Zeise
 * Class for handling the onBlockPlace event.
 */
public class OnBlockPlaceEvent implements Listener {

    private final BlockDeleter blockDeleter;


    public OnBlockPlaceEvent(BlockDeleter blockDeleter) {
        this.blockDeleter = blockDeleter;
    }

    /**
     * Adds a block to the list of blocks placed.
     *
     * @param event the event
     */
    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent event) {

        Player player = event.getPlayer();
        if (player.getGameMode() == GameMode.CREATIVE) {
            return;
        }
        blockDeleter.addBlock(event.getBlock().getLocation());

    }

}
