package dev.crnyy.vagtsystem.plugins.vagtkiste;

import dev.crnyy.vagtsystem.files.Config;
import dev.crnyy.vagtsystem.files.Data;
import dev.crnyy.vagtsystem.files.Message;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Utility;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VagtKiste implements Listener {

    private final Config config;
    private final Message message;
    private Map<Material, Double> items;
    private Location lastClickedLocation = null;

    public VagtKiste(Config config, Message message) {
        this.config = config;
        this.message = message;

        items = new HashMap<Material, Double>();

        ConfigurationSection itemsSection = config.getConfig().getConfigurationSection("Vagtkiste.ITEMS");
        if (itemsSection != null) {
            for (String itemName : itemsSection.getKeys(false)) {
                Material material = Material.getMaterial(itemName.toUpperCase());
                if (material != null && itemsSection.isDouble(itemName)) {
                    double price = itemsSection.getDouble(itemName);
                    items.put(material, price);
                }
            }
        }
    }

//    @EventHandler
//    public void onPlayerInteractEvent(PlayerInteractEvent e) {
//        Block clickedBlock = e.getClickedBlock();
//        Location clickedLocation = clickedBlock.getLocation();
//        Material type = Material.getMaterial(config.getConfig().getString("Vagtkiste.TYPE"));
//        String name = ChatColor.translateAlternateColorCodes('&', config.getConfig().getString("Vagtkiste.NAME"));
//        if (e.getAction() != Action.RIGHT_CLICK_BLOCK) {
//            return;
//        }
//        if (clickedBlock == null) {
//            return;
//        }
//        if (type == null) {
//            return;
//        }
//        if (name == null) {
//            return;
//        }
//        if (clickedBlock.getType() == type) {
//            String key = "placedBlocks." + clickedLocation.getWorld().getName() + "." + clickedLocation.getBlockX() + "." + clickedLocation.getBlockY() + "." + clickedLocation.getBlockZ();
//            if (Data.get().contains(key)) {
//                lastClickedLocation = clickedLocation;
//            }
//        }
//    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e) {
        final Player player = (Player) e.getPlayer();
        Inventory closedInventory = e.getInventory();
        if (closedInventory == null) {
            return;
        }
        if (closedInventory.getName().equals(config.getConfig().getString("Vagtkiste.NAME"))) {
            if (lastClickedLocation != null && isChestAtLocation(lastClickedLocation)) {
                processInventoryContents(player, closedInventory);
                lastClickedLocation = null;
                closedInventory.clear();
            }
        }
    }
    @Utility
    private boolean isChestAtLocation(Location location) {
        Block block = location.getBlock();
        return block.getState() instanceof Chest;
    }

    @Utility
    private void processInventoryContents(Player player, Inventory inventory) {
        for (ItemStack item : inventory.getContents()) {
            if (item != null && item.getType() != Material.AIR) {
                processItem(player, item);
            }
        }
    }

    @Utility
    private void processItem(Player player, ItemStack item) {
        final Material itemType = item.getType();
        if (items.containsKey(itemType)) {
            int amount = item.getAmount();
            double pricePerItem = getPrice(itemType);
            double reward = amount * pricePerItem;

            player.sendMessage("Du modtog $" + reward + " for at sælge " + amount + " " + itemType.toString() + ".");
        } else {

            player.sendMessage("Denne genstand er ikke konfigureret til at blive solgt.");
        }
    }

    @Utility
    private double getPrice(Material material) {
        return items.getOrDefault(material, 0.0);
    }
}
