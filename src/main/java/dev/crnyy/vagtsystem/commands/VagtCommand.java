package dev.crnyy.vagtsystem.commands;

import dev.crnyy.vagtsystem.files.Config;
import dev.crnyy.vagtsystem.files.Message;
import dev.crnyy.vagtsystem.plugins.vagtmenu.VagtMenu;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VagtCommand implements CommandExecutor {

    private final Config config;
    private final Message message;
    public VagtCommand(Config config, Message message) {
        this.config = config;
        this.message = message;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        final Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("vagt")) {
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("reload")) {
                    if (!(player.hasPermission("vagt.*"))) {
                        player.sendMessage("§cIngen adgang!");
                        return true;
                    }
                    config.reloadConfig();
                    message.reloadConfig();
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lVagt Systemet &7Message.yml og Config.yml er reloaded"));
                } else {
                    player.sendMessage("§eUgyldigt argument!");
                    return true;
                }
            } else if (args.length == 0) {
                VagtMenu menu = new VagtMenu();
                menu.openInventory(player);
            }
        }
        return false;
    }
}
