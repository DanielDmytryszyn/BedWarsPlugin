package me.daniel.bedwarsplugin.data;

import me.daniel.bedwarsplugin.model.ItemSpawner;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Jakob Zeise
 * Utility class for reading item spawner data from a file.
 */
public class ItemSpawnerReader {

    static List<ItemSpawner> spawners;

    /**
     * Author: Jakob Zeise
     * Retrieves a list of item spawners based on the provided world.
     *
     * @param world the world to retrieve the item spawners from
     * @return a list of item spawners
     */
    public static List<ItemSpawner> getItemSpawner(World world) {

        String testFile = "35,114,1,EMERALD;35,124,1,EMERALD;57,115,-7,EMERALD";

        if (spawners != null) {
            return spawners;
        }

        List<ItemSpawner> spawners = new ArrayList<>();

        String[] elements = testFile.split(";");
        for (String s : elements) {
            String[] values = s.split(",");

            double x = Double.parseDouble(values[0]);
            double y = Double.parseDouble(values[1]);
            double z = Double.parseDouble(values[2]);

            Location location = new Location(world, x, y, z);

            Material material = Material.valueOf(values[3]);

            ItemStack item = new ItemStack(material);

            ItemSpawner resourceSpawner = new ItemSpawner(location, item);

            spawners.add(resourceSpawner);
        }

        return spawners;
    }
}
