package me.daniel.bedwarsplugin.model;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Author: Jakob Zeise,
 * A class representing an item spawner in a BedWars plugin.
 */
public class ItemSpawner {

    private final Location location;
    private final ItemStack item;

    private BukkitRunnable runnable;

    /**
     * Constructs an ItemSpawner object.
     *
     * @param location The location where the items will spawn.
     * @param item     The item stack representing the resource.
     */
    public ItemSpawner(Location location, ItemStack item) {
        this.location = location;
        this.item = item;
    }

    /**
     * Starts the spawner, which periodically drops the specified item at the specified location.
     *
     * @param plugin The plugin instance.
     */
    public void startSpawner(Plugin plugin) {

        runnable = new BukkitRunnable() {
            @Override
            public void run() {
                World world = location.getWorld();
                world.dropItem(location, item);
            }
        };
        runnable.runTaskTimer(plugin, 200, 200);

    }


    /**
     * Stops the spawner.
     */
    public void stopSpawner() {
        runnable.cancel();
    }


}
