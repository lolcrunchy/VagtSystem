package dev.crnyy.vagtsystem.plugins.vagtgearshop.b;

import dev.crnyy.vagtsystem.Main;
import dev.crnyy.vagtsystem.files.Config;
import dev.crnyy.vagtsystem.plugins.ArmorManager;
import dev.crnyy.vagtsystem.utils.Messages;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

public class BVagtShopListener implements Listener {

    private Main plugin;
    private Messages messages;
    private Config config;
    public BVagtShopListener(Main plugin, Messages messages, Config config) {
        this.plugin = plugin;
        this.messages = messages;
        this.config = config;
    }

    private Economy economy = Main.economy;

    @EventHandler
    public void onClick(final InventoryClickEvent e) {
        final Player player = (Player) e.getWhoClicked();
        final double balance = economy.getBalance(player);
        final ArmorManager am = new ArmorManager();
        final InventoryView view = player.getOpenInventory();
        final Inventory topInventory = view.getTopInventory();
        if (view == null) {
            return;
        }
        if (player == null) {
            return;
        }
        if (e.getClickedInventory() == null) {
            return;
        }
        if (topInventory == null) {
            return;
        }
        if (topInventory.getName().equals("Vagt Shop B")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
        }
        if (e.getClickedInventory().getName().equals("Vagt Shop B")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            switch (e.getCurrentItem().getType()) {
                case GOLD_HELMET:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lHJELM")) {
                            e.setCancelled(true);
                            int price = 2000;
                            if (balance >= price) {
                                am.player = player.getName();
                                am.bHelmetMap.put(player.getUniqueId(), 0);
                                player.getInventory().addItem(am.bHelmet(player));
                                player.sendMessage(messages.vagtshopBuyedItem("hjelm", price));
                                economy.withdrawPlayer(player, 2000);
                            } else {
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopNoMoney("hjelm", 2000)));
                            }
                        }
                    }
                    break;
                case DIAMOND_CHESTPLATE:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lBRYSTPLADE")) {
                            e.setCancelled(true);
                            if (balance >= 2000) {
                                am.player = player.getName();
                                am.bChestplateMap.put(player.getUniqueId(), 0);
                                player.getInventory().addItem(am.bChestplate(player));
                                player.sendMessage("Du købte en brystplade.");
                                economy.withdrawPlayer(player, 2000);
                            } else {
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopNoMoney("brystplade", 2000)));
                            }
                        }
                    }
                    break;
                case DIAMOND_LEGGINGS:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lBUKSER")) {
                            e.setCancelled(true);
                            if (balance >= 2000) {
                                am.player = player.getName();
                                am.bLeggingsMap.put(player.getUniqueId(), 0);
                                player.getInventory().addItem(am.bLeggings(player));
                                player.sendMessage("Du købte et par bukser.");
                                economy.withdrawPlayer(player, 2000);
                            } else {
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopNoMoney("bukser", 2000)));
                            }
                        }
                    }
                    break;
                case DIAMOND_BOOTS:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lSKO")) {
                            e.setCancelled(true);
                            if (balance >= 2000) {
                                am.player = player.getName();
                                am.bBootsMap.put(player.getUniqueId(), 0);
                                player.getInventory().addItem(am.bBoots(player));
                                player.sendMessage("Du købte et par sko.");
                                economy.withdrawPlayer(player, 2000);
                            } else {
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopNoMoney("sko", 2000)));
                            }
                        }
                    }
                    break;
                case DIAMOND_SWORD:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lSVÆRD")) {
                            e.setCancelled(true);
                            if (balance >= 2000) {
                                am.player = player.getName();
                                am.bSwordMap.put(player.getUniqueId(), 0);
                                player.getInventory().addItem(am.bSword(player));
                                player.sendMessage("Du købte et sværd.");
                                economy.withdrawPlayer(player, 2000);
                            } else {
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopNoMoney("sværd", 2000)));
                            }
                        }
                    }
                    break;
                case BOW:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lBUE")) {
                            e.setCancelled(true);
                            if (balance >= 1500) {
                                am.player = player.getName();
                                am.bBowMap.put(player.getUniqueId(), 0);
                                player.getInventory().addItem(am.bBow(player));
                                player.sendMessage("Du købte en bue.");
                                economy.withdrawPlayer(player, 1500);
                            } else {
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopNoMoney("bue", 1500)));
                            }
                        }
                    }
                    break;
                case STICK:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lPIND")) {
                            e.setCancelled(true);
                            int price = config.getConfig().getInt("Vagtshop.B.stick");
                            if (balance >= price) {
                                am.player = player.getName();
                                player.getInventory().addItem(am.cStick(player, "B"));
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopBuyedItem("Stick", price)));
                                economy.withdrawPlayer(player, price);
                            } else {
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopNoMoney("Stick", price)));
                            }
                        }
                    }
                    break;
                case GRILLED_PORK:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lMAD")) {
                            e.setCancelled(true);
                            int price = config.getConfig().getInt("Vagtshop.B.food");
                            if (balance >= price) {
                                am.player = player.getName();
                                player.getInventory().addItem(am.cFood(player, "B"));
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopBuyedItem("16x Mad", price)));
                                economy.withdrawPlayer(player, price);
                            } else {
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopNoMoney("16x mad", price)));
                            }
                        }
                    }
                    break;
                case ARROW:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lPILE")) {
                            e.setCancelled(true);
                            int price = config.getConfig().getInt("Vagtshop.B.arrow");
                            if (balance >= price) {
                                am.player = player.getName();
                                player.getInventory().addItem(am.cArrows(player, "B"));
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopBuyedItem("16x Arrow", price)));
                                economy.withdrawPlayer(player, price);
                            } else {
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopNoMoney("16x Arrow", price)));
                            }
                        }
                    }
                    break;
            }
        }
    }

}
