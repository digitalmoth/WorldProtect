package io.github.digitalmoth.listeners;

import io.github.digitalmoth.Utils;
import io.github.digitalmoth.WorldProtect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.PlayerBucketEmptyEvent;

public class WorldModifyHandler implements Listener {

    WorldProtect plugin;
    private String NO_PERM_MESSAGE = "&cУ вас нет прав на модификацию данного мира";

    public WorldModifyHandler(WorldProtect plugin) {
        this.plugin = plugin;
        NO_PERM_MESSAGE = plugin.getConfig().getString("permissionmsg");
    }


    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (plugin.worlds.contains(p.getWorld().getName())) {
            if (!p.hasPermission("worldprotect.modify")) {
                Utils.sendMsgToPlayer(p, NO_PERM_MESSAGE);
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (plugin.worlds.contains(p.getWorld().getName())) {
            if (!p.hasPermission("worldprotect.modify")) {
                Utils.sendMsgToPlayer(p, NO_PERM_MESSAGE);
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void bucketEmpty(PlayerBucketEmptyEvent e) {
        Player p = e.getPlayer();
        if ( plugin.worlds.contains(p.getWorld().getName())) {
            Utils.sendMsgToPlayer(p, NO_PERM_MESSAGE);
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void entitySpawnEvent(EntitySpawnEvent e) {
        if (plugin.worlds.contains(e.getEntity().getWorld().getName())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void entityCreation(CreatureSpawnEvent e) {
        if (plugin.worlds.contains(e.getEntity().getWorld().getName())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void entityExplosionEvent(EntityExplodeEvent e) {
        if (plugin.worlds.contains(e.getEntity().getWorld().getName())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void fireSpreadEvent(BlockSpreadEvent e) {
        if (plugin.worlds.contains(e.getBlock().getWorld().getName())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void playerDamagingMobEvent(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player &&
                plugin.worlds.contains(e.getEntity().getWorld().getName())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void blockLeashEvent(PlayerLeashEntityEvent e) {
        if (plugin.worlds.contains(e.getEntity().getWorld().getName())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void blockGrowEvent(BlockGrowEvent e) {
        if (plugin.worlds.contains(e.getBlock().getWorld().getName())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void leafDecayEvent(LeavesDecayEvent e) {
        if (plugin.worlds.contains(e.getBlock().getWorld().getName())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void sheepWool(SheepDyeWoolEvent e) {
        if (plugin.worlds.contains(e.getEntity().getWorld().getName())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void iceMelt(BlockFadeEvent e) {
        if (plugin.worlds.contains(e.getBlock().getWorld().getName())) {
            e.setCancelled(true);
        }
    }
}
