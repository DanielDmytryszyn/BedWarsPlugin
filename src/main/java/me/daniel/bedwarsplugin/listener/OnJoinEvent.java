package me.daniel.bedwarsplugin.listener;

import me.daniel.bedwarsplugin.model.TeamManager;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Author: Jakob Zeise
 * Class for handling the onJoin event.
 */
public class OnJoinEvent implements Listener {

    private final TeamManager teamManager;

    /**
     * Constructs an OnJoinEvent object.
     *
     * @param teamManager the team manager
     */
    public OnJoinEvent(TeamManager teamManager) {
        this.teamManager = teamManager;
    }

    /**
     * Adds the player to a team.
     *
     * @param event the event
     */
    @EventHandler
    public void onJoinEvent(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        teamManager.addPlayer(player);

    }
}
