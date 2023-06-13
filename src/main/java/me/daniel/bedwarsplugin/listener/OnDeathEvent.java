package me.daniel.bedwarsplugin.listener;


import me.daniel.bedwarsplugin.model.Team;
import me.daniel.bedwarsplugin.model.TeamManager;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class OnDeathEvent implements Listener {

    private final TeamManager teamManager;

    public OnDeathEvent(TeamManager teamManager) {
        this.teamManager = teamManager;
    }

    @EventHandler
    public void onDeathEvent(PlayerDeathEvent event) {
        Player player = event.getPlayer();

        Team team = teamManager.getTeamOfPlayer(player);

        if (!team.hasBed()) {
            player.setGameMode(GameMode.ADVENTURE);
        }
    }
}
