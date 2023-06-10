package me.daniel.bedwarsplugin.data;

import me.daniel.bedwarsplugin.model.Team;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Jakob Zeise
 * Utility class for reading team data from a file.
 */
public class TeamsDataReader {


    /**
     * Retrieves a list of teams.
     *
     * @return a list of teams
     */
    public static List<Team> getTeams() {
        List<Team> teams = new ArrayList<>();

        Color greenColor = Color.GREEN;
        TextColor greenTextColor = TextColor.color(
                greenColor.getRed(),
                greenColor.getGreen(),
                greenColor.getBlue()
        );

        Location bedLocationGreen = new Location(Bukkit.getWorlds().get(0), 41, 121, 60);
        teams.add(new Team(greenTextColor, greenColor, bedLocationGreen, new ArrayList<>(), "Green"));


        Color yellowColor = Color.YELLOW;
        TextColor yellowTextColor = TextColor.color(
                yellowColor.getRed(),
                yellowColor.getGreen(),
                yellowColor.getBlue()
        );

        Location bedLocationYellow = new Location(Bukkit.getWorlds().get(0), -34, 121, 4);
        teams.add(new Team(yellowTextColor, yellowColor, bedLocationYellow, new ArrayList<>(), "Yellow"));


        Color redColor = Color.RED;
        TextColor redTextColor = TextColor.color(
                redColor.getRed(),
                redColor.getGreen(),
                redColor.getBlue()
        );


        Location bedLocationRed = new Location(Bukkit.getWorlds().get(0), 41, 121, -45);
        teams.add(new Team(redTextColor, redColor, bedLocationRed, new ArrayList<>(), "Red"));


        Color blueColor = Color.AQUA;
        TextColor blueTextColor = TextColor.color(
                blueColor.getRed(),
                blueColor.getGreen(),
                blueColor.getBlue()
        );
        Location bedLocationAqua = new Location(Bukkit.getWorlds().get(0), 114, 121, 4);
        teams.add(new Team(blueTextColor, blueColor, bedLocationAqua, new ArrayList<>(), "Blue"));

        return teams;

    }


}
