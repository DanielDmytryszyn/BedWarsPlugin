package me.daniel.bedwarsplugin.listener;

import me.daniel.bedwarsplugin.files.ShopItemsReader;
import me.daniel.bedwarsplugin.model.ShopItem;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.Objects;

/**
 * Author: Daniel Dmytryszyn
 * Class for handling the onBuy event.
 */
public class OnBuyEvent implements Listener {

    /**
     * Cancels the onBuy event if the player does not have enough emeralds.
     *
     * @param event the event
     */
    @EventHandler
    public void onBuy(InventoryClickEvent event) {

        Inventory shop = event.getInventory();

        if (event.getClickedInventory() != shop) {
            return;
        }

        event.setCancelled(true);
        PlayerInventory yourInventory = event.getWhoClicked().getInventory();
        ItemStack itemClicked = new ItemStack(Objects.requireNonNull(event.getCurrentItem()).getType());


        ShopItem shopItem = ShopItemsReader.getShopItem(itemClicked);
        if (shopItem == null) {
            return;
        }
        int price = shopItem.getPrice();

        int amount = shopItem.getAmount();

        if (!yourInventory.contains(Material.EMERALD, price)) {
            return;
        }

        pay(Material.EMERALD, price, yourInventory);
        addItem(itemClicked.getType(), yourInventory, amount);
    }

    /**
     * Adds an item to the player's inventory.
     *
     * @param item      the item to add
     * @param inventory the player's inventory
     * @param amount    the number of items to add
     */
    public void addItem(Material item, PlayerInventory inventory, int amount) {
        for (int i = 0; i < amount; i++) {
            inventory.addItem(new ItemStack(item));
        }

    }


    /**
     * Removes an item from the player's inventory.
     *
     * @param itemToRemove the item to remove
     * @param amount       the number of items to remove
     * @param inventory    the player's inventory
     */
    public void pay(Material itemToRemove, int amount, PlayerInventory inventory) {

        if (inventory.contains(itemToRemove, amount)) {
            for (int i = 0; i < amount; i++) {
                inventory.removeItemAnySlot(new ItemStack(itemToRemove));
            }
        }
    }


}
