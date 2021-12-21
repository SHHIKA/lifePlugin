package server.LifePlugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import server.LifePlugin.Lib.Money;

public class mcPay implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        switch (args[0]){
            case "info":
                player.sendMessage(ChatColor.GREEN + "mcPay info-----------");
                player.sendMessage(" ");
                player.sendMessage("your money : " + Money.getMoney(player));
                player.sendMessage(" ");

                break;

            case "give":
                if(args.length <= 3) {
                    player.sendMessage(ChatColor.RED + "情報が足りません");
                    player.sendMessage(ChatColor.RED + "使用方法: /mcpay give <PLayerName> <金額>");

                    return true;
                }

                Player target = Bukkit.getPlayer(args[1]);

                if(!target.isOnline()){
                    player.sendMessage("そのプライヤーは存在していないかオフラインです");

                    return true;
                }

                int money = Integer.parseInt(args[2]);

                if(!Money.canBuy(player, money)){
                    player.sendMessage(ChatColor.RED + "金額が大きすぎます");

                    return true;
                }

                Money.setMoney(player, Money.getMoney(player) - money);
                Money.setMoney(target, Money.getMoney(target) + money);

                player.sendMessage(ChatColor.GREEN + target.getName() + "に" + money + "monをプレゼントしました");
                player.sendMessage(ChatColor.GREEN + player.getName() + "に" + money + "monをもらいました");

                break;
        }

        return true;
    }
}
