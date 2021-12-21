package server.LifePlugin.Lib;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class Money {

    private static Map<Player, Integer> map = new HashMap<>();

    public static Map<Player, Integer> getData(){
        return map;
    }

    public static int getMoney(Player player){
        return map.get(player);
    }

    public static void setMoney(Player player, int money){
        map.put(player, money);
    }

    public static boolean canBuy(Player player, int howMach){
        return map.get(player) - howMach >= 0;
    }
}
