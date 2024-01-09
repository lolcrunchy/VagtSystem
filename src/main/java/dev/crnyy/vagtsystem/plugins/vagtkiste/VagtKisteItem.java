package dev.crnyy.vagtsystem.plugins.vagtkiste;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class VagtKisteItem {

    public static ItemStack kiste() {
        ItemStack item = new ItemStack(Material.CHEST, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§cVagt Kiste");
        item.setItemMeta(meta);
        return item;
    }

}
