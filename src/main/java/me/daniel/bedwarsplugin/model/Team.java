package me.daniel.bedwarsplugin.model;


import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;

public class Team {

    private final Color color;
    private final Location bedLocation;
    private final List<Player> players;

    public Team(Color color, Location bedLocation, List<Player> players) {
        this.color = color;
        this.bedLocation = bedLocation;
        this.players = players;
    }


    public void addPlayer(Player player) {

        players.add(player);

    }

    public Color getColor() {
        return color;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Location getBedLocation() {
        return bedLocation;
    }

    public boolean checkSameTeam(Player player1, Player player2) {
        return players.contains(player1) && players.contains(player2);
    }
}
