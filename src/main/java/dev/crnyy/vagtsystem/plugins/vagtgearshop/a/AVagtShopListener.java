package dev.crnyy.vagtsystem.plugins.vagtgearshop.a;

import dev.crnyy.vagtsystem.Main;
import dev.crnyy.vagtsystem.plugins.ArmorManager;
import dev.crnyy.vagtsystem.utils.Messages;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

public class AVagtShopListener implements Listener {

    private Main plugin;
    private Messages messages;
    public AVagtShopListener(Main plugin, Messages messages) {
        this.plugin = plugin;
        this.messages = messages;
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
        if (topInventory.getName().equals("Vagt Shop A")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
        }
        if (e.getClickedInventory().getName().equals("Vagt Shop A")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            switch (e.getCurrentItem().getType()) {
                case GOLD_HELMET:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lHJELM")) {
                            e.setCancelled(true);
                            int price = 2000;
                            if (balance >= price) {
                                am.player = player.getName();
                                am.aHelmetMap.put(player.getUniqueId(), 0);
                                player.getInventory().addItem(am.aHelmet(player));
                                player.sendMessage(messages.vagtshopBuyedItem("hjelm", price));
                                economy.withdrawPlayer(player, 2000);
                            } else {
                                player.sendMessage("Du har ikke nok penge til dette.");
                            }
                        }
                    }
                    break;
                case DIAMOND_CHESTPLATE:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lBRYSTPLADE")) {
                            e.setCancelled(true);
                            if (balance >= 2000) {
                                am.player = player.getName();
                                am.aChestplateMap.put(player.getUniqueId(), 0);
                                player.getInventory().addItem(am.aChestplate(player));
                                player.sendMessage("Du købte en brystplade.");
                                economy.withdrawPlayer(player, 2000);
                            } else {
                                player.sendMessage("Du har ikke nok penge til dette.");
                            }
                        }
                    }
                    break;
                case DIAMOND_LEGGINGS:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lBUKSER")) {
                            e.setCancelled(true);
                            if (balance >= 2000) {
                                am.player = player.getName();
                                am.aLeggingsMap.put(player.getUniqueId(), 0);
                                player.getInventory().addItem(am.aLeggings(player));
                                player.sendMessage("Du købte et par bukser.");
                                economy.withdrawPlayer(player, 2000);
                            } else {
                                player.sendMessage("Du har ikke nok penge til dette.");
                            }
                        }
                    }
                    break;
                case DIAMOND_BOOTS:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lSKO")) {
                            e.setCancelled(true);
                            if (balance >= 2000) {
                                am.player = player.getName();
                                am.aBootsMap.put(player.getUniqueId(), 0);
                                player.getInventory().addItem(am.aBoots(player));
                                player.sendMessage("Du købte et par sko.");
                                economy.withdrawPlayer(player, 2000);
                            } else {
                                player.sendMessage("Du har ikke nok penge til dette.");
                            }
                        }
                    }
                    break;
                case DIAMOND_SWORD:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lSVÆRD")) {
                            e.setCancelled(true);
                            if (balance >= 2000) {
                                am.player = player.getName();
                                am.aSwordMap.put(player.getUniqueId(), 0);
                                player.getInventory().addItem(am.aSword(player));
                                player.sendMessage("Du købte et sværd.");
                                economy.withdrawPlayer(player, 2000);
                            } else {
                                player.sendMessage("Du har ikke nok penge til dette.");
                            }
                        }
                    }
                    break;
                case BOW:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lBUE")) {
                            e.setCancelled(true);
                            if (balance >= 1500) {
                                am.player = player.getName();
                                am.aBowMap.put(player.getUniqueId(), 0);
                                player.getInventory().addItem(am.aBow(player));
                                player.sendMessage("Du købte en bue.");
                                economy.withdrawPlayer(player, 1500);
                            } else {
                                player.sendMessage("Du har ikke nok penge til dette.");
                            }
                        }
                    }
                    break;
                case STICK:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lPIND")) {
                            e.setCancelled(true);
                            if (balance >= 2000) {
                                am.player = player.getName();
                                player.getInventory().addItem(am.cStick(player, "A"));
                                player.sendMessage("Du købte en pind.");
                                economy.withdrawPlayer(player, 2000);
                            } else {
                                player.sendMessage("Du har ikke nok penge til dette.");
                            }
                        }
                    }
                    break;
                case GRILLED_PORK:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lMAD")) {
                            e.setCancelled(true);
                            if (balance >= 300) {
                                am.player = player.getName();
                                player.getInventory().addItem(am.cFood(player, "A"));
                                player.sendMessage("Du købte 16x mad.");
                                economy.withdrawPlayer(player, 300);
                            } else {
                                player.sendMessage("Du har ikke nok penge til dette.");
                            }
                        }
                    }
                    break;
                case ARROW:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lPILE")) {
                            e.setCancelled(true);
                            if (balance >= 1000) {
                                am.player = player.getName();
                                player.getInventory().addItem(am.cArrows(player, "A"));
                                player.sendMessage("Du købte 16x pile.");
                                economy.withdrawPlayer(player, 1000);
                            } else {
                                player.sendMessage("Du har ikke nok penge til dette.");
                            }
                        }
                    }
                    break;
            }
        }
    }

}
