package dev.crnyy.vagtsystem.plugins.vagtontime;

import dev.crnyy.vagtsystem.utils.ItemStackManager;
import dev.crnyy.vagtsystem.utils.LoreManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Utility;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class VagtMenuOntime {

    private Inventory ontime = Bukkit.createInventory(null, 45, "§6§lVAGT §f§lONTIME§7 - Hovedemenu");

    @Utility
    public void items(final Player player) {
        ItemStack item;
        ItemStackManager itemStack = new ItemStackManager();
        LoreManager lore = new LoreManager();

        //Vagt
        item = itemStack.itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 1, lore.loreMaker(""));
        for (int i = 0; i < 9; i++) {
            ontime.setItem(i, item);
        }
        item = itemStack.itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 0, lore.loreMaker(""));
        for (int i = 36; i < 45; i++) {
            ontime.setItem(i, item);
        }

        item = itemStack.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2NhMWE0OGQyZDIzMWZhNzFiYTVmN2M0MGZkYzEwZDNmMmU5OGM1YTYzYzAxNzMyMWU2NzgxMzA4YjhhNTc5MyJ9fX0=", "§6§lALL §f§lTIME", lore.loreMaker(
                "",
                "",
                "",
                ""));

        ontime.setItem(19, item);


    }


}
