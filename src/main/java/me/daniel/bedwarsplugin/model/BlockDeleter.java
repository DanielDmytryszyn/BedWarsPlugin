package me.daniel.bedwarsplugin.model;

import org.bukkit.Location;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Jakob Zeise
 * Class for deleting blocks.
 */
public class BlockDeleter {


    private final List<Location> blocksPlaced;

    /**
     * Constructs a BlockDeleter object.
     *
     */
    public BlockDeleter() {
        this.blocksPlaced = new ArrayList<>();
    }

    /**
     * Removes a block from the list of blocks placed.
     *
     * @param location The location of the block to remove.
     */
    public void removeBlock(Location location) {
        blocksPlaced.remove(location);
    }

    /**
     * Adds a block to the list of blocks placed.
     *
     * @param location The location of the block to add.
     */
    public void addBlock(Location location) {
        blocksPlaced.add(location);
    }

    /**
     * Resets the map by setting all blocks in the list of blocks placed to air.
     */
    public void resetMap() {
        for (Location location : blocksPlaced) {
            location.getBlock().setType(Material.AIR);
        }
        blocksPlaced.clear();
    }
}
