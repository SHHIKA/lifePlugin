package server.LifePlugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import server.LifePlugin.Lib.Data;
import server.LifePlugin.Lib.Home;
import server.LifePlugin.Lib.Money;

public class home implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        switch (args[0]){
            case "add":
                if(!Money.canBuy(player, 5000)){
                    player.sendMessage(ChatColor.RED + "mcPayが不足しています");

                    return true;
                }

                if(args.length >= 2){
                    player.sendMessage(ChatColor.RED + "情報が足りません");

                    return true;
                }

                Money.setMoney(player, Money.getMoney(player) - 5000);
                Data.setHome(player, new Home(args[1], player.getLocation(), player));
                player.sendMessage(ChatColor.GREEN + "Homeを作成しました");

                break;

            case "info":
                if(Data.getHome(player) == null){
                    player.sendMessage("あなたのHomeはありません");

                    return true;
                }

                Home home = Data.getHome(player);

                player.sendMessage(ChatColor.GREEN + "HOME");
                player.sendMessage("Name: " + home.getName());
                player.sendMessage("Location: " + home.getLocation().getBlockX() + " " + home.getLocation().getBlockY() + " " + home.getLocation().getBlockZ());
                player.sendMessage(" ");

                break;

            case "remove":
                if(Data.getHome(player) == null){
                    player.sendMessage("あなたのHomeはありません");

                    return true;
                }

                player.sendMessage("Homeを削除しました");
                Data.setHome(player, null);

                break;
        }

        return true;
    }
}
