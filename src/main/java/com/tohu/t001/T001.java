package com.tohu.t001;
import com.tohu.t001.Utils.WorldUtil;
import com.tohu.t001.Worlds.Lobby;
import com.tohu.t001.Worlds.Shared;
import com.tohu.t001.Worlds.Spigot;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class T001 extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        reloadMessage("リロードが完了しました");
        new Shared(this);
        new Lobby(this);
        new Spigot(this);
        World lobby = Bukkit.getWorld("lobby");
        World spigot = Bukkit.getWorld("spigot");
        WorldUtil.ChangeGameMode(this, lobby, GameMode.CREATIVE);
        WorldUtil.ChangeGameMode(this, spigot, GameMode.CREATIVE);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        reloadMessage("リロード中です");
    }

    public static void reloadMessage(String msg) {
        List<World> worlds = Bukkit.getWorlds();
        for (World world: worlds) {
            List<Player> players = world.getPlayers();
            for (Player player: players) {
                player.sendTitle(msg, "", 20, 40, 20);
            }
        }
    }
}
