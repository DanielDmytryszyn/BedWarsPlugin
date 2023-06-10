package me.daniel.bedwarsplugin.model;


import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Objects;

/**
 * Author: Jakob Zeise,
 * A class representing a team.
 */
public class Team {

    private final TextColor textColor;
    private final Color color;
    private final Location bedLocation;
    private final List<Player> players;
    private boolean hasBed;

    private final String name;

    /**
     * Constructs a Team object.
     *
     * @param color       The color of the team.
     * @param color1
     * @param bedLocation The location of the bed.
     * @param players     The players in the team.
     * @param name        The name of the team.
     */
    public Team(TextColor color, Color color1, Location bedLocation, List<Player> players, String name) {
        this.textColor = color;
        this.color = color1;
        this.bedLocation = bedLocation;
        this.players = players;
        this.name = name;
        this.hasBed = true;
    }


    /**
     * Adds a player to the team.
     * Sets the custom name of the player to his name in the color of the team.
     * Sends a message to the player.
     *
     * @param player The player to add.
     */
    public void addPlayer(Player player) {

        players.add(player);
        String playerName = Objects.requireNonNull(player.getPlayerProfile().getName());
        player.customName(Component.text(playerName, textColor));
        player.displayName(Component.text(playerName, textColor));
        player.playerListName(Component.text(playerName, textColor));
        player.sendMessage(Component.text("You joined the " + name + " team!", textColor));

    }

    /**
     * gets the color of the team.
     *
     * @return the color
     */
    public TextColor getTextColor() {
        return textColor;
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

    /**
     * Removes a player from the team.
     *
     * @param player The player to remove.
     */
    public void removePlayer(Player player) {
        players.remove(player);
    }

    /**
     * Gets the name of the team.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    public void destroyBed() {
        hasBed = false;
    }
    public boolean hasBed() {
        return hasBed;
    }

}
