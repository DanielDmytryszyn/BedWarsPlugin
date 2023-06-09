package me.daniel.bedwarsplugin.files;

import me.daniel.bedwarsplugin.model.ShopItem;
import net.md_5.bungee.api.chat.hover.content.Item;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ShopItemsReader {

    public static List<ShopItem> getShopItems() {

        List<ShopItem> items = new ArrayList<>();
        items.add(new ShopItem(new ItemStack(Material.BOW), 15, 1));
        items.add(new ShopItem(new ItemStack(Material.ARROW), 1, 8));
        items.add(new ShopItem(new ItemStack(Material.BLUE_WOOL), 1, 16));
        items.add(new ShopItem(new ItemStack(Material.DIAMOND_PICKAXE), 5,1));
        items.add(new ShopItem(new ItemStack(Material.DIAMOND_SWORD), 20,1));

        return items;
    }

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
