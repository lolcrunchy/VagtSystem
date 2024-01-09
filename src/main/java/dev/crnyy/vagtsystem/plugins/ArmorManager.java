package dev.crnyy.vagtsystem.plugins;

import dev.crnyy.vagtsystem.utils.LoreManager;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ArmorManager {


    public String player;

    public Map<UUID, Integer> cHelmetMap = new HashMap<UUID, Integer>();
    public Map<UUID, Integer> cChestplateMap = new HashMap<UUID, Integer>();
    public Map<UUID, Integer> cLeggingsMap = new HashMap<UUID, Integer>();
    public Map<UUID, Integer> cBootsMap = new HashMap<UUID, Integer>();
    public Map<UUID, Integer> cSwordMap = new HashMap<UUID, Integer>();
    public Map<UUID, Integer> cBowMap = new HashMap<UUID, Integer>();

    public Map<UUID, Integer> bHelmetMap = new HashMap<UUID, Integer>();
    public Map<UUID, Integer> bChestplateMap = new HashMap<UUID, Integer>();
    public Map<UUID, Integer> bLeggingsMap = new HashMap<UUID, Integer>();
    public Map<UUID, Integer> bBootsMap = new HashMap<UUID, Integer>();
    public Map<UUID, Integer> bSwordMap = new HashMap<UUID, Integer>();
    public Map<UUID, Integer> bBowMap = new HashMap<UUID, Integer>();

    public Map<UUID, Integer> aHelmetMap = new HashMap<UUID, Integer>();
    public Map<UUID, Integer> aChestplateMap = new HashMap<UUID, Integer>();
    public Map<UUID, Integer> aLeggingsMap = new HashMap<UUID, Integer>();
    public Map<UUID, Integer> aBootsMap = new HashMap<UUID, Integer>();
    public Map<UUID, Integer> aSwordMap = new HashMap<UUID, Integer>();
    public Map<UUID, Integer> aBowMap = new HashMap<UUID, Integer>();


    public ItemStack cHelmet(final Player player) {
        LoreManager loreManager = new LoreManager();
        ItemStack item = new ItemStack(Material.GOLD_HELMET, 1);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName("§cVagt Hjelm");
        meta.setLore(loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Enchants§8:",
                "§8- §7Protection§8: §f"+cHelmetMap.get(player.getUniqueId()),
                "",
                "§8【 &7Købt af§8: §f" + player.getName() + " §8】",
                "§8【 &7Rank§8: §fC §8】",
                "",
                "§cDette item er ulovligt!",
                "§8§m-------------------------"));
        item.setItemMeta(meta);
        return item;
    }
    public ItemStack cChestplate(final Player player) {
        LoreManager loreManager = new LoreManager();
        ItemStack item = new ItemStack(Material.IRON_CHESTPLATE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName("§cVagt Brystplade");
        meta.setLore(loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Enchants§8:",
                "§8- §7Protection§8: §f"+cChestplateMap.get(player.getUniqueId()),
                "",
                "§8【 &7Købt af§8: §f" + player.getName() + " §8】",
                "§8【 &7Rank§8: §fC §8】",
                "",
                "§cDette item er ulovligt!",
                "§8§m-------------------------"));
        item.setItemMeta(meta);
        return item;
    }
    public ItemStack cLeggings(final Player player) {
        LoreManager loreManager = new LoreManager();
        ItemStack item = new ItemStack(Material.IRON_LEGGINGS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName("§cVagt Bukser");
        meta.setLore(loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Enchants§8:",
                "§8- §7Protection§8: §f"+cLeggingsMap.get(player.getUniqueId()),
                "",
                "§8【 &7Købt af§8: §f" + player.getName() + " §8】",
                "§8【 &7Rank§8: §fC §8】",
                "",
                "§cDette item er ulovligt!",
                "§8§m-------------------------"));
        item.setItemMeta(meta);
        return item;
    }
    public ItemStack cBoots(final Player player) {
        LoreManager loreManager = new LoreManager();
        ItemStack item = new ItemStack(Material.IRON_BOOTS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName("§cVagt Sko");
        meta.setLore(loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Enchants§8:",
                "§8- §7Protection§8: §f"+cBootsMap.get(player.getUniqueId()),
                "",
                "§8【 &7Købt af§8: §f" + player.getName() + " §8】",
                "§8【 &7Rank§8: §fC §8】",
                "",
                "§cDette item er ulovligt!",
                "§8§m-------------------------"));
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack cSword(final Player player) {
        LoreManager loreManager = new LoreManager();
        ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName("§cVagt Sværd");
        meta.setLore(loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Enchants§8:",
                "§8- §7Sharpness§8: §f"+cSwordMap.get(player.getUniqueId()),
                "",
                "§8【 &7Købt af§8: §f" + player.getName() + " §8】",
                "§8【 &7Rank§8: §fC §8】",
                "",
                "§cDette item er ulovligt!",
                "§8§m-------------------------"));
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack cBow(final Player player) {
        LoreManager loreManager = new LoreManager();
        ItemStack item = new ItemStack(Material.BOW, 1);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName("§cVagt Bue");
        meta.setLore(loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Enchants§8:",
                "§8- §7Power§8: §f"+cBowMap.get(player.getUniqueId()),
                "",
                "§8【 &7Købt af§8: §f" + player.getName() + " §8】",
                "§8【 &7Rank§8: §fC §8】",
                "",
                "§cDette item er ulovligt!",
                "§8§m-------------------------"));
        item.setItemMeta(meta);
        return item;
    }


    public ItemStack bHelmet(final Player player) {
        LoreManager loreManager = new LoreManager();
        ItemStack item = new ItemStack(Material.GOLD_HELMET, 1);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName("§bVagt Hjelm");
        meta.setLore(loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Enchants§8:",
                "§8- §7Protection§8: §f"+bHelmetMap.get(player.getUniqueId()),
                "",
                "§8【 &7Købt af§8: §f" + player.getName() + " §8】",
                "§8【 &7Rank§8: §fB §8】",
                "",
                "§cDette item er ulovligt!",
                "§8§m-------------------------"));
        item.setItemMeta(meta);
        return item;
    }
    public ItemStack bChestplate(final Player player) {
        LoreManager loreManager = new LoreManager();
        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName("§bVagt Brystplade");
        meta.setLore(loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Enchants§8:",
                "§8- §7Protection§8: §f"+bChestplateMap.get(player.getUniqueId()),
                "",
                "§8【 &7Købt af§8: §f" + player.getName() + " §8】",
                "§8【 &7Rank§8: §fB §8】",
                "",
                "§cDette item er ulovligt!",
                "§8§m-------------------------"));
        item.setItemMeta(meta);
        return item;
    }
    public ItemStack bLeggings(final Player player) {
        LoreManager loreManager = new LoreManager();
        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName("§bVagt Bukser");
        meta.setLore(loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Enchants§8:",
                "§8- §7Protection§8: §f"+bLeggingsMap.get(player.getUniqueId()),
                "",
                "§8【 &7Købt af§8: §f" + player.getName() + " §8】",
                "§8【 &7Rank§8: §fB §8】",
                "",
                "§cDette item er ulovligt!",
                "§8§m-------------------------"));
        item.setItemMeta(meta);
        return item;
    }
    public ItemStack bBoots(final Player player) {
        LoreManager loreManager = new LoreManager();
        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName("§bVagt Sko");
        meta.setLore(loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Enchants§8:",
                "§8- §7Protection§8: §f"+bBootsMap.get(player.getUniqueId()),
                "",
                "§8【 &7Købt af§8: §f" + player.getName() + " §8】",
                "§8【 &7Rank§8: §fB §8】",
                "",
                "§cDette item er ulovligt!",
                "§8§m-------------------------"));
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack bSword(final Player player) {
        LoreManager loreManager = new LoreManager();
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName("§bVagt Sværd");
        meta.setLore(loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Enchants§8:",
                "§8- §7Sharpness§8: §f"+bSwordMap.get(player.getUniqueId()),
                "",
                "§8【 &7Købt af§8: §f" + player.getName() + " §8】",
                "§8【 &7Rank§8: §fB §8】",
                "",
                "§cDette item er ulovligt!",
                "§8§m-------------------------"));
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack bBow(final Player player) {
        LoreManager loreManager = new LoreManager();
        ItemStack item = new ItemStack(Material.BOW, 1);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName("§bVagt Bue");
        meta.setLore(loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Enchants§8:",
                "§8- §7Power§8: §f"+bBowMap.get(player.getUniqueId()),
                "",
                "§8【 &7Købt af§8: §f" + player.getName() + " §8】",
                "§8【 &7Rank§8: §fB §8】",
                "",
                "§cDette item er ulovligt!",
                "§8§m-------------------------"));
        item.setItemMeta(meta);
        return item;
    }



    public ItemStack aHelmet(final Player player) {
        LoreManager loreManager = new LoreManager();
        ItemStack item = new ItemStack(Material.GOLD_HELMET, 1);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName("§aVagt Hjelm");
        meta.setLore(loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Enchants§8:",
                "§8- §7Protection§8: §f"+aHelmetMap.get(player.getUniqueId()),
                "",
                "§8【 &7Købt af§8: §f" + player.getName() + " §8】",
                "§8【 &7Rank§8: §fA §8】",
                "",
                "§cDette item er ulovligt!",
                "§8§m-------------------------"));
        item.setItemMeta(meta);
        return item;
    }
    public ItemStack aChestplate(final Player player) {
        LoreManager loreManager = new LoreManager();
        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName("§aVagt Brystplade");
        meta.setLore(loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Enchants§8:",
                "§8- §7Protection§8: §f"+aChestplateMap.get(player.getUniqueId()),
                "",
                "§8【 &7Købt af§8: §f" + player.getName() + " §8】",
                "§8【 &7Rank§8: §fA §8】",
                "",
                "§cDette item er ulovligt!",
                "§8§m-------------------------"));
        item.setItemMeta(meta);
        return item;
    }
    public ItemStack aLeggings(final Player player) {
        LoreManager loreManager = new LoreManager();
        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName("§aVagt Bukser");
        meta.setLore(loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Enchants§8:",
                "§8- §7Protection§8: §f"+aLeggingsMap.get(player.getUniqueId()),
                "",
                "§8【 &7Købt af§8: §f" + player.getName() + " §8】",
                "§8【 &7Rank§8: §fA §8】",
                "",
                "§cDette item er ulovligt!",
                "§8§m-------------------------"));
        item.setItemMeta(meta);
        return item;
    }
    public ItemStack aBoots(final Player player) {
        LoreManager loreManager = new LoreManager();
        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName("§aVagt Sko");
        meta.setLore(loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Enchants§8:",
                "§8- §7Protection§8: §f"+aBootsMap.get(player.getUniqueId()),
                "",
                "§8【 &7Købt af§8: §f" + player.getName() + " §8】",
                "§8【 &7Rank§8: §fA §8】",
                "",
                "§cDette item er ulovligt!",
                "§8§m-------------------------"));
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack aSword(final Player player) {
        LoreManager loreManager = new LoreManager();
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName("§aVagt Sværd");
        meta.setLore(loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Enchants§8:",
                "§8- §7Sharpness§8: §f"+aSwordMap.get(player.getUniqueId()),
                "",
                "§8【 &7Købt af§8: §f" + player.getName() + " §8】",
                "§8【 &7Rank§8: §fA §8】",
                "",
                "§cDette item er ulovligt!",
                "§8§m-------------------------"));
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack aBow(final Player player) {
        LoreManager loreManager = new LoreManager();
        ItemStack item = new ItemStack(Material.BOW, 1);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName("§aVagt Bue");
        meta.setLore(loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Enchants§8:",
                "§8- §7Power§8: §f"+aBowMap.get(player.getUniqueId()),
                "",
                "§8【 &7Købt af§8: §f" + player.getName() + " §8】",
                "§8【 &7Rank§8: §fA §8】",
                "",
                "§cDette item er ulovligt!",
                "§8§m-------------------------"));
        item.setItemMeta(meta);
        return item;
    }


    public ItemStack cStick(final Player player, String block) {
        LoreManager loreManager = new LoreManager();
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.addEnchant(Enchantment.KNOCKBACK, 2, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName("§cVagt Pind");
        meta.setLore(loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Enchants§8:",
                "§8- §7Knockback§8: §f2",
                "",
                "§8【 &7Købt af§8: §f" + player.getName() + " §8】",
                "§8【 &7Rank§8: §f" + block + " §8】",
                "",
                "§cDette item er ulovligt!",
                "§8§m-------------------------"));
        item.setItemMeta(meta);
        return item;
    }
    public ItemStack cFood(final Player player, String block) {
        LoreManager loreManager = new LoreManager();
        ItemStack item = new ItemStack(Material.GRILLED_PORK, 16);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName("§cVagt Mad");
        meta.setLore(loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§8【 &7Købt af§8: §f" + player.getName() + " §8】",
                "§8【 &7Rank§8: §f" + block + " §8】",
                "",
                "§cDette item er ulovligt!",
                "§8§m-------------------------"));
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack cArrows(final Player player, String block) {
        LoreManager loreManager = new LoreManager();
        ItemStack item = new ItemStack(Material.ARROW, 16);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName("§cVagt Pile");
        meta.setLore(loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§8【 &7Købt af§8: §f" + player.getName() + " §8】",
                "§8【 &7Rank§8: §f" + block + " §8】",
                "",
                "§cDette item er ulovligt!",
                "§8§m-------------------------"));
        item.setItemMeta(meta);
        return item;
    }
}
