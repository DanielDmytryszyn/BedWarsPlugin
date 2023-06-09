package me.daniel.bedwarsplugin.listener;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;

public class OnBlockDestroyEvent implements Listener {

    @EventHandler
    public void onBlockDestroy(BlockDamageEvent event) {
        Material blockMaterial = event.getBlock().getType();
        Player player = event.getPlayer();
        if (player.getGameMode() == GameMode.CREATIVE) return;

        if (blockMaterial == Material.RED_WOOL || blockMaterial == Material.LIGHT_BLUE_WOOL) {
            event.setCancelled(false);
            return;
        }
        event.setCancelled(true);

    }
}
