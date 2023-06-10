package me.daniel.bedwarsplugin.data;

import me.daniel.bedwarsplugin.model.ShopItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Jakob Zeise
 * Utility class for reading shop item data from a file.
 */
public class ShopItemsReader {

    /**
     * Retrieves a list of shop items.
     *
     * @return a list of shop items
     */
    public static List<ShopItem> getShopItems() {

        List<ShopItem> items = new ArrayList<>();
        items.add(new ShopItem(new ItemStack(Material.BOW), 15, 1));
        items.add(new ShopItem(new ItemStack(Material.ARROW), 1, 8));
        items.add(new ShopItem(new ItemStack(Material.BLUE_WOOL), 1, 16));
        items.add(new ShopItem(new ItemStack(Material.DIAMOND_PICKAXE), 5, 1));
        items.add(new ShopItem(new ItemStack(Material.DIAMOND_SWORD), 20, 1));

        return items;
    }

    /**
     * Retrieves a shop item based on the provided item stack.
     *
     * @param itemStack the item stack to retrieve the shop item from
     * @return the shop item
     */
    public static ShopItem getShopItem(ItemStack itemStack) {
        List<ShopItem> items = getShopItems();

        for (ShopItem i : items) {

            if (i.getItem().equals(itemStack)) {
                return i;
            }

        }
        return null;
    }


}
