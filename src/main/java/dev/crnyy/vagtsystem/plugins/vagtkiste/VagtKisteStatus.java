package dev.crnyy.vagtsystem.plugins.vagtkiste;

import dev.crnyy.vagtsystem.files.Config;
import dev.crnyy.vagtsystem.files.Data;
import dev.crnyy.vagtsystem.files.Message;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class VagtKisteStatus implements Listener {

    private final Config config;
    private final Message message;

    public VagtKisteStatus(Config config, Message message) {
        this.config = config;
        this.message = message;
    }

//    @EventHandler
//    public void onBlockPlaceEvent(BlockPlaceEvent e) {
//        final Player player = e.getPlayer();
//        final Location location = e.getBlockPlaced().getLocation();
//        final int x = (int) location.getX();
//        final int y = (int) location.getY();
//        final int z = (int) location.getZ();
//        final World world = player.getWorld();
//        final ItemStack placedBlock = e.getItemInHand();
//        Material type = Material.getMaterial(config.getConfig().getString("Vagtkiste.TYPE"));
//        String name = ChatColor.translateAlternateColorCodes('&', config.getConfig().getString("Vagtkiste.NAME"));
//        if (location == null) {
//            return;
//        }
//        if (e.getBlockPlaced() == null) {
//            return;
//        }
//        if (placedBlock == null) {
//            return;
//        }
//        if (e.getBlockPlaced().getType() == type) {
//            if (placedBlock.hasItemMeta()) {
//                if (placedBlock.getItemMeta().hasDisplayName()) {
//                    if (placedBlock.getItemMeta().getDisplayName().contains(name)) {
//                        String key = "placedChests." + world.getName() + "." + x + "." + y + "." + z;
//                        Data.get().set(key, true);
//                        Data.save();
//                    }
//                }
//            }
//        }
//    }
//
//    @EventHandler
//    public void onBlockBreakEvent(BlockBreakEvent e) {
//        Location location = e.getBlock().getLocation();
//        Material type = Material.getMaterial(config.getConfig().getString("Vagtkiste.TYPE"));
//        String name = ChatColor.translateAlternateColorCodes('&', config.getConfig().getString("Vagtkiste.NAME"));
//        if (type != null && name != null
//                && e.getBlock().getType() == type) {
//            String key = "placedChests." + location.getWorld().getName() + "." + location.getBlockX() + "." + location.getBlockY() + "." + location.getBlockZ();
//            if (Data.get().contains(key)) {
//                Data.get().set(key, null);
//                Data.save();
//            }
//        }
//    }

}
