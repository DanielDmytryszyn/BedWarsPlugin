package me.daniel.bedwarsplugin.listener;

import me.daniel.bedwarsplugin.model.Team;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.List;

public class OnDamageEvent implements Listener {

    private List<Team> teams;


    @EventHandler
    public void onDamageEvent(EntityDamageByEntityEvent event) {


        Entity entity1 = event.getDamager();
        Player player1;

        if (entity1 instanceof Player p1) player1 = p1;
        else return;


        Entity entity2 = event.getEntity();
        Player player2;
        if (entity2 instanceof Player p2)player2 = p2;
        else return;

        boolean inSameTeam = false;
        for (Team team : teams) {
            if (team.checkSameTeam(player1, player2)) {

            }
        }



    }
}
