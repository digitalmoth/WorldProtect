package io.github.digitalmoth;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Utils {

    public static void sendMsgToPlayer(Player p, String msg) {
        p.sendMessage(ChatColor.translateAlternateColorCodes('&' , msg));
    }

}
