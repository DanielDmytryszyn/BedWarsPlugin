package me.daniel.bedwarsplugin.model;


import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Author: Jakob Zeise,
 * A class representing a team.
 */
public class Team {

    private final TextColor textColor;
    private final Color color;
    private final Location bedHeadLocation;
    private final Location bedFootLocation;
    private final List<Player> players;
    private boolean hasBed;
    private Location spawnLocation;
    private final String name;
    private final Material bedMaterial;
    private final BlockFace bedDirection;

    /**
     *
     * @param color The color of the team.
     * @param color1 The color of the team.
     * @param bedHeadLocation The location of the head of the bed.
     * @param bedFootLocation   The location of the foot of the bed.
     * @param name The name of the team.
     * @param spawnLocation The location where the players of the team spawn.
     * @param bedMaterial The material of the bed.
     */
    public Team(
            TextColor color,
            Color color1,
            Location bedHeadLocation,
            Location bedFootLocation,
            String name,
            Location spawnLocation,
            Material bedMaterial,
            BlockFace bedDirection
    ) {
        this.textColor = color;
        this.color = color1;
        this.bedHeadLocation = bedHeadLocation;
        this.bedFootLocation = bedFootLocation;
        this.players = new ArrayList<>();
        this.name = name;
        this.hasBed = true;
        this.spawnLocation = spawnLocation;
        this.bedMaterial = bedMaterial;
        this.bedDirection = bedDirection;
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
        return bedHeadLocation;
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
        players.forEach(player -> {
            player.playSound(player.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_IMPACT, 1.0f, 1.0f);
            player.sendMessage(Component.text("Your bed has been destroyed!!!!!!!"));
        });

    }
    public boolean hasBed() {
        return hasBed;
    }

    public Location getSpawnLocation() {
        return spawnLocation;
    }

    public Material getBedMaterial() {
        return bedMaterial;
    }

    public Location getBedFootLocation() {
        return bedFootLocation;
    }

    public Location getBedHeadLocation() {
        return bedHeadLocation;
    }

    public BlockFace getBedDirection() {
        return bedDirection;
    }
}
