package io.github.digitalmoth.listeners;

import io.github.digitalmoth.WorldProtect;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class WorldModifyByPluginsHandler implements Listener {

    WorldProtect plugin;

    public WorldModifyByPluginsHandler(WorldProtect plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onModifyCommand(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        String[] s = e.getMessage().toLowerCase().split(" ");
        if (plugin.worlds.contains(p.getWorld().getName()) &&
                !p.hasPermission("worldprotect.modify")) {
            if (cmdwe(s[0])) {
                sendMsgToPlayer(p, "Вы не можете модифицировать данный мир");
                e.setCancelled(true);
            }
            if (cmdgb(s[0])) {
                sendMsgToPlayer(p, "Вы не можете модифицировать данный мир");
                e.setCancelled(true);
            }
            if (cmdgp(s[0])) {
                sendMsgToPlayer(p, "Вы не можете модифицировать данный мир");
                e.setCancelled(true);
            }
            if (cmdweC(s[0])) {
                sendMsgToPlayer(p, "Вы не можете модифицировать данный мир");
                e.setCancelled(true);
            }
            if (cmdweP(s[0])) {
                sendMsgToPlayer(p, "Вы не можете модифицировать данный мир");
                e.setCancelled(true);
            }
            if (cmdweS(s[0])) {
                sendMsgToPlayer(p, "Вы не можете модифицировать данный мир");
                e.setCancelled(true);
            }
            if (cmdweU(s[0])) {
                sendMsgToPlayer(p, "Вы не можете модифицировать данный мир");
                e.setCancelled(true);
            }
            if (cmdweCP(s[0])) {
                e.setMessage(e.getMessage().replace("-o", ""));
                sendMsgToPlayer(p, "Вы не можете модифицировать данный мир");
                    e.setCancelled(true);
            }
        }
    }

    boolean cmdwe(String s){
            s = s.replace("worldedit:", "");
            String[] cmds = {"//set", "//replace", "//overlay", "//walls", "//outline", "//faces", "//smooth", "//deform",
                    "//hollow", "//cut"};
            byte b;
            int i;
            String[] arrayOfString1;
            for (i = (arrayOfString1 = cmds).length, b = 0; b < i; ) {
                String cmd = arrayOfString1[b];
                if (cmd.equalsIgnoreCase(s))
                    return true;
                b++;
            }
            return false;
        }

    boolean cmdgb(String s){
        s = s.replace("gobrush:", "");
        String[] cmds = {"/gobrush", "/gb"};
        byte b;
        int i;
        String[] arrayOfString1;
        for (i = (arrayOfString1 = cmds).length, b = 0; b < i; ) {
            String cmd = arrayOfString1[b];
            if (cmd.equalsIgnoreCase(s))
                return true;
            b++;
        }
        return false;
    }

    boolean cmdgp(String s){
        s = s.replace("gopaint:", "");
        String[] cmds = {"/gopaint", "/gp"};
        byte b;
        int i;
        String[] arrayOfString1;
        for (i = (arrayOfString1 = cmds).length, b = 0; b < i; ) {
            String cmd = arrayOfString1[b];
            if (cmd.equalsIgnoreCase(s))
                return true;
            b++;
        }
        return false;
    }

    boolean cmdweC(String s) {
        s = s.replace("worldedit:", "");
        String[] cmds = { "//cyl", "//hcyl" };
        byte b;
        int i;
        String[] arrayOfString1;
        for (i = (arrayOfString1 = cmds).length, b = 0; b < i; ) {
            String cmd = arrayOfString1[b];
            if (cmd.equalsIgnoreCase(s))
                return true;
            b++;
        }
        return false;
    }

    boolean cmdweP(String s) {
        s = s.replace("worldedit:", "");
        String[] cmds = { "//pyramid", "//hpyramid" };
        byte b;
        int i;
        String[] arrayOfString1;
        for (i = (arrayOfString1 = cmds).length, b = 0; b < i; ) {
            String cmd = arrayOfString1[b];
            if (cmd.equalsIgnoreCase(s))
                return true;
            b++;
        }
        return false;
    }

    boolean cmdweS(String s) {
        s = s.replace("worldedit:", "");
        String[] cmds = { "//sphere", "//hsphere" };
        byte b;
        int i;
        String[] arrayOfString1;
        for (i = (arrayOfString1 = cmds).length, b = 0; b < i; ) {
            String cmd = arrayOfString1[b];
            if (cmd.equalsIgnoreCase(s))
                return true;
            b++;
        }
        return false;
    }

    boolean cmdweU(String s) {
        s = s.replace("worldedit:", "");
        String[] cmds = { "//up", "/up" };
        byte b;
        int i;
        String[] arrayOfString1;
        for (i = (arrayOfString1 = cmds).length, b = 0; b < i; ) {
            String cmd = arrayOfString1[b];
            if (cmd.equalsIgnoreCase(s))
                return true;
            b++;
        }
        return false;
    }

    boolean cmdweCP(String s) {
        s = s.replace("worldedit:", "");
        return s.equalsIgnoreCase("//paste");
    }
    private void sendMsgToPlayer(Player p, String msg) {
        p.sendMessage(ChatColor.RED + msg);
    }
}
