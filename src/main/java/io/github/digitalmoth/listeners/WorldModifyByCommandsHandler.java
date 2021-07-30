package io.github.digitalmoth.listeners;

import io.github.digitalmoth.Utils;
import io.github.digitalmoth.WorldProtect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.List;

public class WorldModifyByCommandsHandler implements Listener {

    WorldProtect plugin;
    private String BLOCKED_COMMAND_MESSAGE = "&cУ вас нет прав на исполнение данной команды в этом мире";

    public WorldModifyByCommandsHandler(WorldProtect plugin) {
        this.plugin = plugin;
        BLOCKED_COMMAND_MESSAGE = plugin.getConfig().getString("blocked-command-message");
    }

    @EventHandler
    public void onModifyCommand(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        String[] s = e.getMessage().toLowerCase().split(" ");
        if (plugin.worlds.contains(p.getWorld().getName()) &&
                !p.hasPermission("worldprotect.commands")) {
            if (cmd(s[0])) {
                Utils.sendMsgToPlayer(p, BLOCKED_COMMAND_MESSAGE);
                e.setCancelled(true);
            }
        }
    }

    boolean cmd(String s){
            s = s.replace("worldedit:", "");
            s = s.replace("gobrush:", "");
            s = s.replace("gopaint:", "");
            s = s.replace("minecraft:", "");
            List<String> cmds = plugin.getConfig().getStringList("blocked-commands");
            for (String cmd : cmds) {
                if (cmd.equalsIgnoreCase(s))
                    return true;
            }
            return false;
        }
}
