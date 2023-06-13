package me.daniel.bedwarsplugin.listener;

import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;


/**
 * Author: Daniel Dmytryszyn
 */
public class OnVillagerHitEvent implements Listener {

    /**
     * This event is used to cancel damage to villagers
     */
    @EventHandler
    public void onVillagerHit(EntityDamageEvent event) {

        if (event.getEntity() instanceof Villager){
            event.setCancelled(true);
        }

    }

}
