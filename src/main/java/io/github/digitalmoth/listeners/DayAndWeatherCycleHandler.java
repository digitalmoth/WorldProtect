package io.github.digitalmoth.listeners;

import io.github.digitalmoth.WorldProtect;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class DayAndWeatherCycleHandler implements Listener {

    private WorldProtect plugin;

    public DayAndWeatherCycleHandler(WorldProtect plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void weatherChange(WeatherChangeEvent e) {
        if (plugin.worlds.contains(e.getWorld().getName())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void dayAndNightCycle() {
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable(){

            @Override
            public void run() {
                for(World w : Bukkit.getServer().getWorlds()) {
                    if (plugin.worlds.contains(w.getName())) {
                        w.setTime(0L);
                    }
                }
            }
        }, 0L, 10000L);
    }

}
