package dev.crnyy.vagtsystem.plugins.vagtmine;

import com.earth2me.essentials.Essentials;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VagtMineListener implements Listener {

    private final VagtMine mine;
    private final ItemUtils itemUtils;
    public VagtMineListener(VagtMine mine, ItemUtils itemUtils) {
        this.mine = mine;
        this.itemUtils = itemUtils;
    }

    @EventHandler
    public void onPlayerCommandExecute(PlayerCommandPreprocessEvent e) {
        final Player player = e.getPlayer();
        if (!(mine.playersCurrentlyInMine.contains(player.getUniqueId()))) {
            return;
        }
        e.setCancelled(true);
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent e) {
        final Player player = e.getPlayer();
        if (!(mine.playersCurrentlyInMine.contains(player.getUniqueId()))) {
            return;
        }
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "warp spassermine " + player.getName());
    }

    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent e) {
        final Player player = e.getPlayer();
        final int blocksMined = mine.blocksMined.getOrDefault(player.getUniqueId(), 0);
        if (!(mine.playersCurrentlyInMine.contains(player.getUniqueId()))) {
            return;
        }

        mine.addBlock(player);
        e.setCancelled(true);
        e.getBlock().setType(Material.AIR);

        if (player.getInventory().getItemInHand().getType() == Material.WOOD_PICKAXE) {
            ItemStack pa = player.getInventory().getItemInHand();
            ItemMeta itemMeta = pa.getItemMeta();

            List<String> currentLore = itemMeta.getLore();

            if (currentLore == null || currentLore.size() < 7) {
                currentLore = new ArrayList<>(Collections.nCopies(7, ""));
            }

            int needed = Math.max(0, 500 - (blocksMined + 1));
            currentLore.set(5, "§8【 §7Tilbage§8: §f" + needed + " §8】");
            itemMeta.setLore(currentLore);
            pa.setItemMeta(itemMeta);
        }

        if (blocksMined + 1 == 500) {
            player.sendMessage("Wuhu du er ikke længere en spasser!");
            ItemStack[] inventoryContents = player.getInventory().getContents();
            for (int i = 0; i < inventoryContents.length; i++) {
                ItemStack item = inventoryContents[i];
                if (item != null && item.getType() == Material.WOOD_PICKAXE && item.hasItemMeta()) {
                    ItemMeta meta = item.getItemMeta();
                    if (meta.hasDisplayName() && meta.getDisplayName().equals("§6Spasser §fPickaxe")) {
                        player.getInventory().setItem(i, new ItemStack(Material.AIR));
                        break;
                    }
                }
            }

            mine.playersCurrentlyInMine.remove(player.getUniqueId());
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "spawn " + player.getName());
            mine.blocksMined.remove(player.getUniqueId());

        }

    }



}
