package server.LifePlugin.Lib;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class Data extends Money {

    private static final Map<Player, Home> homes = new HashMap<>();

    public static void setHome(Player player, Home home){
        homes.put(player, home);
    }

    public static Home getHome(Player player){
        return homes.get(player);
    }

}
