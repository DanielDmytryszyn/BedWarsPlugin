package me.daniel.bedwarsplugin.listener;

import me.daniel.bedwarsplugin.model.ShopItem;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;

import java.util.List;


/**
 * Author: Daniel Dmytryszyn
 * Class for handling the onShopOpen event.
 */
public class OnShopOpenEvent implements Listener {


    private final List<ShopItem> shopItems;

    public OnShopOpenEvent(List<ShopItem> shopItems) {
        this.shopItems = shopItems;
    }

    /**
     * Opens the shop inventory if the player right-clicks on a villager.
     *
     * @param event the event
     */
    @EventHandler
    public void onShopOpen(PlayerInteractEntityEvent event) {

        Inventory shop = Bukkit.createInventory(null, 27, Component.text("Shop"));

        addItemsToShop(shop);

        if (event.getRightClicked() instanceof Villager) {
            Player p = event.getPlayer();
            p.openInventory(shop);
        }

    }

    /**
     * Adds the shop items to the shop inventory.
     *
     * @param inventory the inventory
     */
    public void addItemsToShop(Inventory inventory) {

        shopItems.forEach(shopItem -> {
            for (int i = 0; i < shopItem.getAmount(); i++) {
                inventory.addItem(shopItem.getItem());
            }
        });
    }

}
