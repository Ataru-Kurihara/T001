package com.tohu.t001.Utils;

import com.tohu.t001.T001;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class PlayerUtil {
    public static void changeGameMode(T001 plugin, Player player, GameMode gameMode) {
        Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
            @Override
            public void run() {
                player.setGameMode(gameMode);
            }
        }, 20L);
    }

    public static void teleportPlayer(T001 plugin, Player player, Location location) {
        Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
            @Override
            public void run() {
                player.teleport(location);
            }
        }, 20L);
    }
}

