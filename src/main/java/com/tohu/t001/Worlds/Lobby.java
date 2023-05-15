package com.tohu.t001.Worlds;


import com.tohu.t001.T001;
import com.tohu.t001.Utils.PlayerUtil;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;


public class Lobby implements Listener {
    T001 plugin;
    World world;
    public Location spawnPlace;
    public int SPAWN_X = 1000, SPAWN_Y = 5, SPAWN_Z = 1000;

    public Lobby(T001 plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.world = Bukkit.getWorld("lobby");
        this.spawnPlace = new Location(world, SPAWN_X, SPAWN_Y, SPAWN_Z);
    }

    @EventHandler
    public void onChangedWorld(PlayerChangedWorldEvent e) {
        Player player = e.getPlayer();
        World world = player.getWorld();
        if (world != this.world) return;
        player.teleport(spawnPlace);
        PlayerUtil.changeGameMode(plugin, player, GameMode.CREATIVE);
    }

}
