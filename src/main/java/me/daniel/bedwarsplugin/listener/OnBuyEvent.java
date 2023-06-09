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

import java.util.List;
import java.util.Objects;

public class OnBuyEvent implements Listener {

    private final List<ShopItem> shopItems;

    public OnBuyEvent(List<ShopItem> shopItems) {
        this.shopItems = shopItems;
    }

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

        if (itemClicked != null) {
            pay(Material.EMERALD, price, yourInventory);
            addItem(itemClicked.getType(), yourInventory, amount);
        }
    }

    public void addItem(Material item, PlayerInventory inventory, int amount) {
        for (int i = 0; i < amount; i++) {
            inventory.addItem(new ItemStack(item));
        }

    }


    public void pay(Material itemToRemove, int amount, PlayerInventory inventory) {

        if (inventory.contains(itemToRemove, amount)) {
            for (int i = 0; i < amount; i++) {
                inventory.removeItemAnySlot(new ItemStack(itemToRemove));
            }

        }
    }


}
