package dev.crnyy.vagtsystem.plugins.vagtkiste;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dev.crnyy.vagtsystem.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Utility;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.block.DoubleChest;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class VagtKisteTask implements Listener {

    private Map<Material, Double> sellPrices = new HashMap<Material, Double>();
    private final Main plugin;

    public VagtKisteTask(Main plugin) {
        this.plugin = plugin;

    }

    @EventHandler
    public void onChestClose(InventoryCloseEvent e) {
        final Player player = (Player) e.getPlayer();
        final Inventory inventory = e.getInventory();

        if (inventory.getType() == org.bukkit.event.inventory.InventoryType.CHEST &&
                inventory.getName().equals("§cVagt Kiste")) {

            clearChest(inventory);
        }
    }

    @Utility
    private void clearChest(Inventory inventory) {
        for (int i = 0; i < inventory.getSize(); i++) {
            inventory.setItem(i, new ItemStack(Material.AIR));
        }
        if (inventory.getHolder() instanceof DoubleChest) {
            DoubleChest doubleChest = (DoubleChest) inventory.getHolder();
            BlockState left = ((Chest) doubleChest.getLeftSide()).getBlock().getState();
            BlockState right = ((Chest) doubleChest.getRightSide()).getBlock().getState();
            left.update(true, false);
            right.update(true, false);
        } else if (inventory.getHolder() instanceof Chest) {
            BlockState blockState = ((Chest) inventory.getHolder()).getBlock().getState();
            blockState.update(true, false);
        }
    }

}
