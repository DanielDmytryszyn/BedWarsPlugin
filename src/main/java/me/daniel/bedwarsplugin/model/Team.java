package me.daniel.bedwarsplugin.model;


import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Author: Jakob Zeise
 * A class representing a team.
 */
public class Team {

    private final Color color;
    private final Location bedLocation;
    private final List<Player> players;

    /**
     * Constructs a Team object.
     *
     * @param color       The color of the team.
     * @param bedLocation The location of the bed.
     * @param players     The players in the team.
     */
    public Team(Color color, Location bedLocation, List<Player> players) {
        this.color = color;
        this.bedLocation = bedLocation;
        this.players = players;
    }


    /**
     * Adds a player to the team.
     *
     * @param player The player to add.
     */
    public void addPlayer(Player player) {

        players.add(player);

    }

    /**
     * gets the color of the team.
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Gets the players in the team.
     *
     * @return the players
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * Gets the location of the bed.
     *
     * @return the bed location
     */
    public Location getBedLocation() {
        return bedLocation;
    }

    /**
     * Checks if two players are in the same team.
     *
     * @param player1 the first player
     * @param player2 the second player
     * @return true if the players are in the same team, false otherwise
     */
    public boolean checkSameTeam(Player player1, Player player2) {
        return players.contains(player1) && players.contains(player2);
    }
}
