package dev.crnyy.vagtsystem.plugins.vagtkiste;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class VagtKisteCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        final Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("vagtkiste")) {
            if (!(player.hasPermission("vagt.*"))) {
                player.sendMessage("§cIngen adgang!");
                return true;
            }
            if (args.length > 0) {
                player.sendMessage("§cUgyldigt argument!");
                return true;
            }
            player.getInventory().addItem(VagtKisteItem.kiste());
            return true;
        }
        return false;
    }
}
