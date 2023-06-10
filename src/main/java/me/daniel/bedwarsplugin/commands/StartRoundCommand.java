package me.daniel.bedwarsplugin.commands;

import me.daniel.bedwarsplugin.data.ItemSpawnerReader;
import me.daniel.bedwarsplugin.model.ItemSpawner;
import me.daniel.bedwarsplugin.model.Team;
import me.daniel.bedwarsplugin.model.TeamManager;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.logging.Logger;

/**
 * Author: Jakob Zeise
 * Command executor for the "start spawner" command.
 * This command starts the item spawners in the specified world.
 */
public class StartRoundCommand implements CommandExecutor {

    private final Plugin plugin;

    private final TeamManager teamManager;

    /**
     * Constructs a new StartSpawnerCommand with the specified plugin.
     *
     * @param plugin      the plugin instance
     * @param teamManager the team manager
     */
    public StartRoundCommand(Plugin plugin, TeamManager teamManager) {
        this.plugin = plugin;
        this.teamManager = teamManager;
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

        startSpawners(sender);

        teleportPlayerToBed();

        setSurvivalMode();

        clearInventory();

        return true;
    }

    private void clearInventory() {
        // TODO: 6/10/2023 clear inventory does not work
        List<Team> teams = teamManager.getTeams();
        teams.forEach(team -> team.getPlayers().forEach(player -> player.getInventory().clear()));
    }

    private void setSurvivalMode() {
        List<Team> teams = teamManager.getTeams();
        teams.forEach(team -> team.getPlayers().forEach(player -> player.setGameMode(GameMode.SURVIVAL)));
    }
    private void startSpawners(@NotNull CommandSender sender) {
        World world = sender.getServer().getWorlds().get(0);
        List<ItemSpawner> itemSpawner = ItemSpawnerReader.getItemSpawner(world);
        itemSpawner.forEach(spawner -> spawner.startSpawner(plugin));
    }

    private void teleportPlayerToBed() {
        List<Team> teams = teamManager.getTeams();
        teams.forEach(team -> team.getPlayers().forEach(player -> player.teleport(team.getBedLocation())));
    }
}
