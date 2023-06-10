package me.daniel.bedwarsplugin.listener;

import me.daniel.bedwarsplugin.model.Team;
import me.daniel.bedwarsplugin.model.TeamManager;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.List;

/**
 * Author: Jakob Zeise
 * Class for handling the onDamage event.
 */
public class OnDamageEvent implements Listener {

    private final TeamManager teamManager;

    public OnDamageEvent(List<Team> teams, TeamManager teamManager) {
        this.teamManager = teamManager;
    }


    /**
     * Cancels the onDamage event if the player is in the same team as the player who damaged him.
     *
     * @param event the event
     */
    @EventHandler
    public void onDamageEvent(EntityDamageByEntityEvent event) {


        Entity entity1 = event.getDamager();
        Entity entity2 = event.getEntity();

        if (entity1 instanceof Player player1 && entity2 instanceof Player player2) {
            Team teamPlayer1 = teamManager.getTeamOfPlayer(player1);
            Team teamPlayer2 = teamManager.getTeamOfPlayer(player2);

            if (teamPlayer1.equals(teamPlayer2)) {
                event.setCancelled(true);
            }
        }

    }
}
