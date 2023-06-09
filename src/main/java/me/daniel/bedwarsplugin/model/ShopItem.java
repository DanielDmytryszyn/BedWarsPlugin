package me.daniel.bedwarsplugin.model;

import org.bukkit.inventory.ItemStack;

public class ShopItem {

    private final int price;
    private final ItemStack item;
    private final int amount;

    public ShopItem(ItemStack item, int price, int amount) {
        this.item = item;
        this.price = price;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public int getPrice() {
        return price;
    }

    public ItemStack getItem() {
        return item;
    }
}
