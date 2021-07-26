package io.github.digitalmoth.listeners;

import io.github.digitalmoth.WorldProtect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class WorldModifyHandler implements Listener {

    WorldProtect plugin;

    public WorldModifyHandler(WorldProtect plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (plugin.worlds.contains(p.getWorld().getName())) {
            if (!p.hasPermission("worldprotect.modify")) {
                p.sendMessage("У вас нет прав на модифицирование данного мира");
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (plugin.worlds.contains(p.getWorld().getName())) {
            if (!p.hasPermission("worldprotect.modify")) {
                p.sendMessage("У вас нет прав на модифицирование данного мира");
                e.setCancelled(true);
            }
        }
    }

}
