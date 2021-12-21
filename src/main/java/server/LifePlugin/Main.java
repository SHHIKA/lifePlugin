package server.LifePlugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import server.LifePlugin.commands.*;

@SuppressWarnings("all")
public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new Listener(), this);

        getCommand("home").setExecutor(new home());
        getCommand("mcpay").setExecutor(new mcPay());

        autoRun();
    }

    @Override
    public void onDisable() {

    }

    public void autoRun(){
        BukkitRunnable task = new BukkitRunnable() {
            int count = 3600;

            @Override
            public void run() {
                if(count == 10){
                    Bukkit.broadcastMessage(ChatColor.YELLOW + "まもなくサーバーが自動再起動します");
                }

                if(count == 0){
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "reload");
                }

                count--;
            }
        };

        task.runTaskTimer(this, 0L, 20L);
    }
}
