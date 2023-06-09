package me.daniel.bedwarsplugin.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemMergeEvent;

/**
 * Author: Daniel Dmytryszyn
 * Class for handling the onMerge event.
 */
public class OnMergeEvent implements Listener {


    /**
     * Cancels the onMerge event, so that items do not merge.
     *
     * @param event the event
     */
    @EventHandler
    public void onMerge(ItemMergeEvent event) {
        event.setCancelled(true);

    }

}
