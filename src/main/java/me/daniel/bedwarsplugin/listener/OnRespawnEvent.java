package me.daniel.bedwarsplugin.listener;

import me.daniel.bedwarsplugin.BedWarsPlugin;
import me.daniel.bedwarsplugin.model.Team;
import me.daniel.bedwarsplugin.model.TeamManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.concurrent.Delayed;

/**
 * Author: Jakob Zeise
 */
public class OnRespawnEvent implements Listener {

    private final TeamManager teamManager;
    private final Plugin plugin;

    /**
     * Constructs an OnSpawnEvent object.
     *
     * @param teamManager the team manager
     */
    public OnRespawnEvent(TeamManager teamManager, Plugin plugin) {
        this.teamManager = teamManager;
        this.plugin = plugin;
    }


    /**
     * Teleports the player to the bed location of his team.
     *
     * @param event the event
     */
    @EventHandler
    public void onRespawnEvent(PlayerRespawnEvent event) {

        Player player = event.getPlayer();

        Team team = teamManager.getTeamOfPlayer(player);

        if (!team.hasBed()) {
            player.setGameMode(GameMode.SPECTATOR);
            return;
        }

        Bukkit.getScheduler().runTaskLater(plugin, () -> player.teleport(team.getBedLocation()), 5L * 20);

        event.setRespawnLocation(team.getSpawnLocation());

    }


}


