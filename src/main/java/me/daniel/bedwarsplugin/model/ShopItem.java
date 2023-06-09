package me.daniel.bedwarsplugin.model;

import org.bukkit.inventory.ItemStack;

/**
 * Author: Jakob Zeise,
 * A class representing an item in a shop.
 */
public class ShopItem {

    private final int price;
    private final ItemStack item;
    private final int amount;

    /**
     * Constructs a ShopItem object.
     *
     * @param item   The item stack representing the item.
     * @param price  The price of the item.
     * @param amount The amount of items.
     */
    public ShopItem(ItemStack item, int price, int amount) {
        this.item = item;
        this.price = price;
        this.amount = amount;
    }

    /**
     * Gets the number of items.
     *
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }


    /**
     * Gets the price of the item.
     *
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Gets the item stack representing the item.
     *
     * @return the item
     */
    public ItemStack getItem() {
        return item;
    }
}
