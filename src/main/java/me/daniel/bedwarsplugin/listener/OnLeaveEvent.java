package me.daniel.bedwarsplugin.listener;

import me.daniel.bedwarsplugin.model.TeamManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Author: Jakob Zeise
 * Class for handling the onLeave event.
 */
public class OnLeaveEvent implements Listener {

    private final TeamManager teamManager;

    public OnLeaveEvent(TeamManager teamManager) {
        this.teamManager = teamManager;
    }

    @EventHandler
    public void onLeaveEvent(PlayerQuitEvent event) {

        teamManager.removePlayer(event.getPlayer());

    }
}
