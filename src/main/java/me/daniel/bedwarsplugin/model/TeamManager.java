package me.daniel.bedwarsplugin.model;

import me.daniel.bedwarsplugin.data.TeamsDataReader;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Author: Jakob Zeise,
 * A class representing a team manager.
 */
public class TeamManager {

    /**
     * The teams.
     */
    private final List<Team> teams;

    /**
     * Constructs a TeamManager object.
     */
    public TeamManager() {
        teams = TeamsDataReader.getTeams();
    }

    /**
     * Adds a player to the smallest team.
     *
     * @param player The player to add.
     */
    public void addPlayer(Player player) {
        getSmallestTeam().addPlayer(player);
    }

    /**
     * Gets the teams.
     *
     * @return the teams
     */
    public List<Team> getTeams() {
        return teams;
    }

    /**
     * Gets the smallest team.
     *
     * @return the smallest team
     */
    public Team getSmallestTeam() {

        for (Team team : teams) {
            if (team.getPlayers().size() == 0) {
                return team;
            }
        }
        return null;
    }

    public Team getTeamOfPlayer(Player player) {
        for (Team team : teams) {
            if (team.getPlayers().contains(player)) {
                return team;
            }
        }
        return null;
    }

    public void removePlayer(Player player) {
        Team team = getTeamOfPlayer(player);
        team.removePlayer(player);
    }

    public List<Location> getBedLocations() {
        return teams.stream().map(Team::getBedLocation).toList();
    }

    public Team getTeamByBedLocation(Location location) {
        for (Team team : teams) {
            if (team.getBedLocation().equals(location)) {
                return team;
            }
        }
        return null;
    }

}
