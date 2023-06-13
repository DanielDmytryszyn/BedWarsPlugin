package me.daniel.bedwarsplugin.data;

import me.daniel.bedwarsplugin.model.Team;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;

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

        Location bedHeadLocationGreen = new Location(Bukkit.getWorlds().get(0), 41, 121, 60);
        Location bedFootLocationGreen = new Location(Bukkit.getWorlds().get(0), 41, 121, 61);
        
        teams.add(new Team(
                greenTextColor,
                greenColor,
                bedHeadLocationGreen,
                bedFootLocationGreen,
                "Green",
                new Location(Bukkit.getWorlds().get(0), 52, 204, 2),
                Material.GREEN_BED,
                BlockFace.NORTH
        ));


        Color yellowColor = Color.YELLOW;
        TextColor yellowTextColor = TextColor.color(
                yellowColor.getRed(),
                yellowColor.getGreen(),
                yellowColor.getBlue()
        );

        Location bedHeadLocationYellow = new Location(Bukkit.getWorlds().get(0), -33, 121, 4);
        Location bedFootLocationYellow = new Location(Bukkit.getWorlds().get(0), -34, 121, 4);
        teams.add(new Team(
                yellowTextColor,
                yellowColor,
                bedHeadLocationYellow,
                bedFootLocationYellow,
                "Yellow",
                new Location(Bukkit.getWorlds().get(0), -34, 121, 4),
                Material.YELLOW_BED,
                BlockFace.EAST

        ));


        Color redColor = Color.RED;
        TextColor redTextColor = TextColor.color(
                redColor.getRed(),
                redColor.getGreen(),
                redColor.getBlue()
        );


        Location bedHeadLocationRed = new Location(Bukkit.getWorlds().get(0), 41, 121, -65);
        Location bedFootLocationRed = new Location(Bukkit.getWorlds().get(0), 41, 121, -66);
        teams.add(new Team(
                redTextColor,
                redColor,
                bedHeadLocationRed,
                bedFootLocationRed,
                "Red",
                new Location(Bukkit.getWorlds().get(0), 41, 121, -45),
                Material.RED_BED,
                BlockFace.SOUTH
        ));


        Color blueColor = Color.BLUE;
        TextColor blueTextColor = TextColor.color(
                blueColor.getRed(),
                blueColor.getGreen(),
                blueColor.getBlue()
        );
        Location bedHeadLocationBlue = new Location(Bukkit.getWorlds().get(0), 113, 121, 4);
        Location bedFootLocationBlue = new Location(Bukkit.getWorlds().get(0), 114, 121, 4);
        teams.add(new Team(
                blueTextColor,
                blueColor,
                bedHeadLocationBlue,
                bedFootLocationBlue,
                "Blue",
                new Location(Bukkit.getWorlds().get(0), 113, 121, 4),
                Material.BLUE_BED,
                BlockFace.WEST
        ));

        return teams;

    }


}
