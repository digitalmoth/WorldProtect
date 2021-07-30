package io.github.digitalmoth;

import io.github.digitalmoth.listeners.DayAndWeatherCycleHandler;
import io.github.digitalmoth.listeners.WorldModifyHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import io.github.digitalmoth.listeners.WorldModifyByCommandsHandler;

import java.util.List;

public class WorldProtect extends JavaPlugin {

    public List worlds = getConfig().getStringList("worlds");

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        registerEvents();
//        WorldEditModifyHandler.registerWorldEditEvent();
    }

    private void registerEvents() {
        Bukkit.getPluginManager().registerEvents(new WorldModifyHandler(this), this);
        Bukkit.getPluginManager().registerEvents(new WorldModifyByCommandsHandler(this), this);
        Bukkit.getPluginManager().registerEvents(new DayAndWeatherCycleHandler(this), this);
    }
    }
