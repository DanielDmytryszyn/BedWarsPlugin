package me.daniel.bedwarsplugin.listener;

import me.daniel.bedwarsplugin.model.Team;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemMergeEvent;

import java.util.List;

public class OnMergeEvent implements Listener {


    @EventHandler
    public void onMerge(ItemMergeEvent event) {
        event.setCancelled(true);

    }

}
