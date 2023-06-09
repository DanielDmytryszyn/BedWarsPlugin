package me.daniel.bedwarsplugin.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;


public class OnFallEvent implements Listener {

    @EventHandler
    public void onFall(PlayerMoveEvent event) {
        if (event.getTo().getBlock().getType() == Material.TRIPWIRE){
            Player player = event.getPlayer();
            player.setHealth(0.0);
        }
    }

}
