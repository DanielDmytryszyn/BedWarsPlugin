package me.daniel.bedwarsplugin.commands;

import me.daniel.bedwarsplugin.data.ItemSpawnerReader;
import me.daniel.bedwarsplugin.model.ItemSpawner;
import me.daniel.bedwarsplugin.model.Team;
import me.daniel.bedwarsplugin.model.TeamManager;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.type.Bed;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

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

        //teleportPlayerToBed();

        setSurvivalMode();

        clearInventory();

        resetVitals();

        replaceBeds();

        return true;
    }


    private void replaceBeds() {
        for (Team team : teamManager.getTeams()) {
            Location bedFootLocation = team.getBedFootLocation();
            Location bedHeadLocation = team.getBedHeadLocation();

            bedFootLocation.getBlock().setType(team.getBedMaterial());
            bedHeadLocation.getBlock().setType(team.getBedMaterial());

            Block bedFootBlock = bedFootLocation.getBlock();
            Block bedHeadBlock = bedHeadLocation.getBlock();

            BlockState bedFootState = bedFootBlock.getState();
            BlockState bedHeadState = bedHeadBlock.getState();

            bedFootState.setType(team.getBedMaterial());
            bedHeadState.setType(team.getBedMaterial());

            Bed bedFoot = (Bed) bedFootState.getBlockData();
            Bed bedHead = (Bed) bedHeadState.getBlockData();

            bedFoot.setPart(Bed.Part.FOOT);
            bedHead.setPart(Bed.Part.HEAD);


            BlockFace bedDirection = team.getBedDirection();

            bedFoot.setFacing(bedDirection);
            bedHead.setFacing(bedDirection);

            bedFootState.setBlockData(bedFoot);
            bedHeadState.setBlockData(bedHead);

            bedFootState.update(true, false);
            bedHeadState.update(true, false);
        }
    }





    private void clearInventory() {
        List<Team> teams = teamManager.getTeams();
        teams.forEach(team -> team.getPlayers().forEach(player -> player.getInventory().clear()));
    }

    private void resetVitals() {
        List<Team> teams = teamManager.getTeams();
        teams.forEach(team -> team.getPlayers().forEach(player -> player.setHealth(20)));
        teams.forEach(team -> team.getPlayers().forEach(player -> player.setFoodLevel(20)));
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
        Consumer<Team> teamConsumer = team -> {
            List<Player> players = team.getPlayers();
            players.forEach(player -> Bukkit.getScheduler().runTaskLater(
                    plugin, () -> player.teleport(team.getBedLocation()), 5L * 20));
        };
        teams.forEach(teamConsumer);
    }
}
