package me.daniel.bedwarsplugin;

import me.daniel.bedwarsplugin.commands.GetTeamInfoCommand;
import me.daniel.bedwarsplugin.commands.StartRoundCommand;
import me.daniel.bedwarsplugin.commands.StopRoundCommand;
import me.daniel.bedwarsplugin.data.ShopItemsReader;
import me.daniel.bedwarsplugin.listener.*;
import me.daniel.bedwarsplugin.model.BlockDeleter;
import me.daniel.bedwarsplugin.model.TeamManager;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Author: Daniel Dmytryszyn & Jakob Zeise
 * Main class of the BedWars plugin.
 */
public final class BedWarsPlugin extends JavaPlugin {

    private TeamManager teamManager;
    private BlockDeleter blockDeleter;

    /**
     * Called when the plugin is enabled.
     * Registers the listeners and commands.
     */
    @Override
    public void onEnable() {

        teamManager = new TeamManager();
        blockDeleter = new BlockDeleter();

        registerListeners();
        registerCommands();

    }

    /**
     * Called when the plugin is disabled.
     * Disables the plugin.
     */
    @Override
    public void onDisable() {
        getServer().getPluginManager().disablePlugin(this);
        // Plugin shutdown logic
    }


    /**
     * Registers the listeners.
     */
    public void registerListeners() {
        getServer().getPluginManager().registerEvents(new OnBlockDestroyEvent(blockDeleter), this);
        getServer().getPluginManager().registerEvents(new OnFallEvent(), this);
        getServer().getPluginManager().registerEvents(new OnMergeEvent(), this);
        getServer().getPluginManager().registerEvents(new OnBuyEvent(), this);
        getServer().getPluginManager().registerEvents(new OnShopOpenEvent(ShopItemsReader.getShopItems()), this);

        getServer().getPluginManager().registerEvents(new OnLeaveEvent(teamManager), this);
        getServer().getPluginManager().registerEvents(new OnRespawnEvent(teamManager), this);
        getServer().getPluginManager().registerEvents(new OnJoinEvent(teamManager), this);

    }

    /**
     * Registers the commands.
     */
    public void registerCommands() {

        PluginCommand stopSpawner = this.getCommand("stopround");
        if (stopSpawner == null) {
            Bukkit.getServer().sendMessage(Component.text("Could not register stopround command!"));
            return;
        }
        stopSpawner.setExecutor(new StopRoundCommand(blockDeleter));

        PluginCommand startSpawner = this.getCommand("startround");
        if (startSpawner == null) {
            Bukkit.getServer().sendMessage(Component.text("Could not register startround command!"));
            return;
        }
        startSpawner.setExecutor(new StartRoundCommand(this, teamManager));

        PluginCommand teamInfo = this.getCommand("teaminfo");
        if (teamInfo == null) {
            Bukkit.getServer().sendMessage(Component.text("Could not register teaminfo command!"));
            return;
        }
        teamInfo.setExecutor(new GetTeamInfoCommand(teamManager));
    }

}
