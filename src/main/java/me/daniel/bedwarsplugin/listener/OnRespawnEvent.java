package me.daniel.bedwarsplugin.listener;

import me.daniel.bedwarsplugin.model.Team;
import me.daniel.bedwarsplugin.model.TeamManager;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

/**
 * Author: Jakob Zeise
 */
public class OnRespawnEvent implements Listener {

    private final TeamManager teamManager;


    /**
     * Constructs an OnSpawnEvent object.
     *
     * @param teamManager the team manager
     */
    public OnRespawnEvent(TeamManager teamManager) {
        this.teamManager = teamManager;
    }


    /**
     * Teleports the player to the bed location of his team.
     *
     * @param event the event
     */
    @EventHandler
    public void onRespawnEvent(PlayerRespawnEvent event) {
        System.out.println("Player respawned!");

        Player player = event.getPlayer();

        Team team = teamManager.getTeamOfPlayer(player);

        Location bedLocation = team.getBedLocation();
        player.teleport(bedLocation);

    }

}
