package dev.crnyy.vagtsystem.plugins.vagtkiste;

import dev.crnyy.vagtsystem.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class VagtKisteCommand implements CommandExecutor {
    private VagtKisteTask vagtKisteTask;
    private VagtKisteItem item;
    private Main plugin;

    public VagtKisteCommand(VagtKisteTask vagtKisteTask, VagtKisteItem item, Main plugin) {
        plugin.getCommand("vagtkiste").setExecutor(this);
        this.vagtKisteTask = vagtKisteTask;
        this.item = item;
    }

    public boolean onCommand(CommandSender sender, Command command, String s, String[] args2) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Kun en spiller kan bruge denne kommando");
            return true;
        }
        Player player = (Player)sender;
        player.getInventory().addItem(item.kiste());
        return true;
    }
}
