package server.LifePlugin.Lib;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Home {

    private final String name;
    private final Location location;
    private final Player player;

    public Home(String name, Location location, Player player){
        this.name = name;
        this.location = location;
        this.player = player;
    }

    public String getName(){
        return name;
    }

    public Location getLocation(){
        return location;
    }

    public Player getPlayer(){
        return player;
    }
}
