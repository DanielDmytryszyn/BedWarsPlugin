package me.daniel.bedwarsplugin.listener;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;

public class OnTrapdoorInteractEvent implements Listener {

    @EventHandler
    public void onTrapdoorInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (player.getGameMode() == GameMode.CREATIVE){
            return;
        }
        if (Objects.requireNonNull(event.getClickedBlock()).getType() == Material.OAK_TRAPDOOR){
            event.setCancelled(true);
        }

    }


}
