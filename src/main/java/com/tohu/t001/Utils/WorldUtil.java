package com.tohu.t001.Utils;

import com.tohu.t001.T001;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class WorldUtil {
    public static void ChangeGameMode(T001 plugin, World world, GameMode gameMode) {
        Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
            @Override
            public void run() {
                for (Player player: world.getPlayers()) {
                    player.setGameMode(gameMode);
                }
            }
        }, 20L);
    }
}
