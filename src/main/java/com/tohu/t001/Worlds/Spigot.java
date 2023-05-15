package com.tohu.t001.Worlds;

import com.tohu.t001.T001;
import com.tohu.t001.Utils.PlayerUtil;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.BlockVector;

import java.io.IOException;
public class Spigot implements Listener {
    T001 plugin;
    World world;
    public Location spawnPLace, test;
    public FileConfiguration fileConfiguration;
    public int SPAWN_X = 1000, SPAWN_Y = 5, SPAWN_Z = 1000;

    public Spigot(T001 plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.world = Bukkit.getWorld("spigot");
        this.spawnPLace = new Location(world, SPAWN_X, SPAWN_Y, SPAWN_Z);
        this.fileConfiguration = plugin.getConfig();
        this.test = new Location(world, 100, 5, 100);
    }

    @EventHandler
    public void onChangedWorldEvent(PlayerChangedWorldEvent e) {
        Player player = e.getPlayer();
        World world = player.getWorld();
        if (world != this.world) return;
        player.teleport(spawnPLace);
        PlayerUtil.changeGameMode(plugin, player, GameMode.CREATIVE);
        player.sendTitle("Spigotチュートリアル", "", 20, 40, 20);
    }

    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent e) {
        Player player = e.getPlayer();
        World world = player.getWorld();
        if (world != this.world) return;
        player.sendMessage(ChatColor.YELLOW + "ブロックが壊されたよ！");
    }

    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent e) {
        Player player = e.getPlayer();
        World world = player.getWorld();
        if (world != this.world) return;
        player.sendMessage(ChatColor.YELLOW + "ブロックが置かれたよ！");

    }
// 感圧版ふんだ時
//    @EventHandler
//    public void onPlayerInteractEvent(PlayerInteractEvent e) {
//        Player player = e.getPlayer();
//        World world = player.getWorld();
//        ItemStack itemStack = new ItemStack(Material.DIAMOND, 1);
//        if (world != this.world) return;
//        player.sendMessage("クリックされた");
//        player.getInventory().addItem(itemStack);
//        if (e.getAction() == Action.PHYSICAL) {
//            if (e.getClickedBlock().getType().equals(Material.STONE_PLATE)) {
//                player.sendMessage("踏んだ");
//                if (Math.floor(e.getClickedBlock().getLocation().getX()) == Math.floor(test.getX()) && Math.floor(e.getClickedBlock().getLocation().getY()) == Math.floor(test.getY()) && Math.floor(e.getClickedBlock().getLocation().getZ()) == Math.floor(test.getZ())) {
//                    player.sendMessage("テスト");
//                }

//            }
//        }
//    }

    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent e) throws IOException {
        Player player = (Player) e.getWhoClicked();
        World world = player.getWorld();
        if (world != this.world) return;
        player.sendMessage(String.valueOf(e.getSlot()));
    }

// ブロックにぶつかった
//    @EventHandler
//    public void onPlayerMove(PlayerMoveEvent event) {
//        Player player = event.getPlayer();
//        Location from = event.getFrom();
//        Location to = event.getTo();
//
//        // プレイヤーがブロックにぶつかったかどうかを判定
//        if (to.getBlockX() != from.getBlockX() || to.getBlockY() != from.getBlockY() || to.getBlockZ() != from.getBlockZ()) {
//            Location blockLoc = new Location(to.getWorld(), to.getBlockX()+1, to.getBlockY(), to.getBlockZ());
//            Block b = world.getBlockAt(blockLoc);
//            Block block = to.getBlock();
//            Material material = block.getType();
//
//            // ブロックにぶつかった時の処理を実行
//            // ...
//            if (b.getType().equals(Material.DIAMOND_BLOCK)) {
//                player.sendMessage("踏んだ");
//            }
//        }
//    }


}
