package me.daniel.bedwarsplugin.commands;

import me.daniel.bedwarsplugin.model.Team;
import me.daniel.bedwarsplugin.model.TeamManager;
import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Author: Jakob Zeise
 * Command executor for the "get team info" command.
 */
public class GetTeamInfoCommand implements CommandExecutor {

    private final TeamManager teamManager;

    public GetTeamInfoCommand(TeamManager teamManager) {
        this.teamManager = teamManager;
    }

    /**
     * Executes the "get team info" command.
     * Sends the player information about their team.
     *
     * @param sender  the command sender
     * @param command the command executed
     * @param label   the alias used for the command
     * @param args    the command arguments
     * @return true if the command was executed successfully, false otherwise
     */
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player player) {

            Team team = teamManager.getTeamOfPlayer(player);

            if (team == null) {
                player.sendMessage(Component.text("You are not in a team."));
                return true;
            }

            String teamInfo = "You are in team " + team.getName();
            player.sendMessage(Component.text(teamInfo, team.getTextColor()));

            String teamSizeInfo = "Your team has " + (team.getPlayers().size() > 1 ? " players." : " player.");
            player.sendMessage(Component.text(teamSizeInfo, team.getTextColor()));

            String bedInfo = "Your bed is " + (team.hasBed() ? "still alive" : "destroyed") + ".";
            player.sendMessage(Component.text(bedInfo, team.getTextColor()));

        }

        return true;
    }
}
