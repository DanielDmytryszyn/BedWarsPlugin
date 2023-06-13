package me.daniel.bedwarsplugin.listener;

import me.daniel.bedwarsplugin.model.BlockDeleter;
import me.daniel.bedwarsplugin.model.Team;
import me.daniel.bedwarsplugin.model.TeamManager;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;

import java.util.List;

/**
 * Author: Daniel Dmytryszyn
 * Class for handling the onBlockDestroy event.
 */
public class OnBlockDestroyEvent implements Listener {

    private final BlockDeleter blockDeleter;
    private final TeamManager teamManager;

    public OnBlockDestroyEvent(BlockDeleter blockDeleter, TeamManager teamManager) {
        this.blockDeleter = blockDeleter;
        this.teamManager = teamManager;
    }


    /**
     * Cancels the onBlockDestroy event if the player is in creative mode.
     * If the player is not in creative mode,
     * the event is canceled and the block is removed from the list of blocks placed.
     * @param event the event
     */
    @EventHandler
    public void onBlockDestroy(BlockDamageEvent event) {

        Player player = event.getPlayer();
        if (player.getGameMode() == GameMode.CREATIVE) return;

        List<Location> bedLocations = teamManager.getBedLocations();

        Location blockLocation = event.getBlock().getLocation();

        Location ownBedLocation = teamManager.getTeamOfPlayer(player).getBedLocation();

        if (blockLocation.equals(ownBedLocation)) {
            event.setCancelled(true);
            return;
        }

        if (bedLocations.contains(blockLocation)) {
            Team teamDestroyedBed = teamManager.getTeamByBedLocation(blockLocation);
            teamDestroyedBed.destroyBed();
            return;
        }

        List<Location> destructibleBlocks = blockDeleter.getBlocksPlaced();

        if (!destructibleBlocks.contains(blockLocation)) {
            event.setCancelled(true);
        }


    }

}
