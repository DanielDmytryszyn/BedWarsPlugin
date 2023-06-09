package me.daniel.bedwarsplugin;

import me.daniel.bedwarsplugin.commands.StartSpawnerCommand;
import me.daniel.bedwarsplugin.commands.StopSpawnerCommand;
import me.daniel.bedwarsplugin.files.ShopItemsReader;
import me.daniel.bedwarsplugin.listener.*;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

/**
 * Author: Daniel Dmytryszyn & Jakob Zeise
 * Main class of the BedWars plugin.
 */
public final class BedWarsPlugin extends JavaPlugin {

    /**
     * Called when the plugin is enabled.
     * Registers the listeners and commands.
     */
    @Override
    public void onEnable() {


        registerListeners();
        registerCommands();

    }

    /**
     * Called when the plugin is disabled.
     */
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    /**
     * Registers the listeners.
     */
    public void registerListeners() {
        getServer().getPluginManager().registerEvents(new OnBlockDestroyEvent(), this);
        getServer().getPluginManager().registerEvents(new OnFallEvent(), this);
        getServer().getPluginManager().registerEvents(new OnMergeEvent(), this);
        getServer().getPluginManager().registerEvents(new OnShopOpenEvent(ShopItemsReader.getShopItems()), this);
        getServer().getPluginManager().registerEvents(new OnBuyEvent(), this);
    }

    /**
     * Registers the commands.
     */
    public void registerCommands() {

        PluginCommand stopSpawner = Objects.requireNonNull(this.getCommand("stopSpawner"));
        stopSpawner.setExecutor(new StopSpawnerCommand());

        PluginCommand startSpawner = Objects.requireNonNull(this.getCommand("startSpawner"));
        startSpawner.setExecutor(new StartSpawnerCommand(this));

    }
}
