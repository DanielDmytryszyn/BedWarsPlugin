package me.daniel.bedwarsplugin.commands;

import me.daniel.bedwarsplugin.files.ItemSpawnerReader;
import me.daniel.bedwarsplugin.model.ItemSpawner;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Author: Jakob Zeise
 * Command executor for the "start spawner" command.
 * This command starts the item spawners in the specified world.
 */
public class StartSpawnerCommand implements CommandExecutor {

    private final Plugin plugin;

    /**
     * Constructs a new StartSpawnerCommand with the specified plugin.
     *
     * @param plugin the plugin instance
     */
    public StartSpawnerCommand(Plugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Executes the "start spawner" command.
     * Starts the item spawners in the specified world.
     *
     * @param sender  the command sender
     * @param command the command executed
     * @param label   the alias used for the command
     * @param args    the command arguments
     * @return true if the command was executed successfully, false otherwise
     */
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        World world = sender.getServer().getWorlds().get(0);
        List<ItemSpawner> itemSpawner = ItemSpawnerReader.getItemSpawner(world);
        itemSpawner.forEach(spawner -> spawner.startSpawner(plugin));

        return true;
    }
}
