package me.daniel.bedwarsplugin;

import me.daniel.bedwarsplugin.commands.StartSpawnerCommand;
import me.daniel.bedwarsplugin.files.ShopItemsReader;
import me.daniel.bedwarsplugin.listener.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class BedWarsPlugin extends JavaPlugin {

    @Override
    public void onEnable() {


        registerListeners();
        registerCommands();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerListeners() {


        getServer().getPluginManager().registerEvents(new OnBlockDestroyEvent(), this);
        getServer().getPluginManager().registerEvents(new OnFallEvent(), this);
        getServer().getPluginManager().registerEvents(new OnMergeEvent(), this);
        getServer().getPluginManager().registerEvents(new OnShopOpenEvent(ShopItemsReader.getShopItems()), this);
        getServer().getPluginManager().registerEvents(new OnBuyEvent(ShopItemsReader.getShopItems()), this);
    }


    public void registerCommands() {
        Objects.requireNonNull(this.getCommand("startSpawner")).setExecutor(new StartSpawnerCommand(this));
    }
}
