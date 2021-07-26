package io.github.digitalmoth;

import io.github.digitalmoth.listeners.WorldModifyHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import io.github.digitalmoth.listeners.WorldModifyByPluginsHandler;

import java.util.List;

public class WorldProtect extends JavaPlugin {

    public List worlds = getConfig().getStringList("worlds");

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        registerEvents();

        disableDayCycle();
        disableWeatherCycle();

//        WorldEditModifyHandler.registerWorldEditEvent();
    }



    private void registerEvents() {
        Bukkit.getPluginManager().registerEvents(new WorldModifyHandler(this), this);
        Bukkit.getPluginManager().registerEvents(new WorldModifyByPluginsHandler(this), this);

    }

    private void disableWeatherCycle() {
        for (var world : worlds) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mvgamerule doWeatherCycle false " + world);
        }
    }

    private void disableDayCycle() {
        for (var world : worlds) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mvgamerule doDaylightCycle false " + world);
        }
    }
}
