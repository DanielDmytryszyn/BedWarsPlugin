package me.daniel.bedwarsplugin.listener;

import com.destroystokyo.paper.event.player.PlayerSetSpawnEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * Author:
 */
public class OnBedClickEvent implements Listener {

    @EventHandler
    public void onBedClick(PlayerSetSpawnEvent event) {
        event.setCancelled(true);
    }



}
