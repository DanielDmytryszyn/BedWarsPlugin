package me.daniel.bedwarsplugin.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;


/**
 * Author: Daniel Dmytryszyn
 * Class for handling the onFall event.
 */
public class OnFallEvent implements Listener {


    /**
     * Kills the player if he falls on a tripwire.
     *
     * @param event the event
     */
    @EventHandler
    public void onFall(PlayerMoveEvent event) {
        if (event.getTo().getBlock().getType() == Material.TRIPWIRE) {
            Player player = event.getPlayer();
            player.setHealth(0.0);
        }
    }

}
