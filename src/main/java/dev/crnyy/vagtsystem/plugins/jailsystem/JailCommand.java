package dev.crnyy.vagtsystem.plugins.jailsystem;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import dev.crnyy.vagtsystem.plugins.jailsystem.*;

import java.util.Arrays;

public class JailCommand implements CommandExecutor {

    private final JailManager jailManager;

    public JailCommand(JailManager jailManager) {
        this.jailManager = jailManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        final Player target = Bukkit.getPlayer(args[0]);
        final Player player = (Player) sender;

        if (!(player.hasPermission("vagt"))) {
            player.sendMessage("Du har ikke adgang til dette.");
            return true;
        }

        if (args.length < 2) {
            player.sendMessage("§eUsage: /jail <player> <reason>");
            return true;
        }

        if (target == null || !target.isOnline()) {
            player.sendMessage("Spilleren eksistere ikke.");
            return true;
        }

        String reason = String.join(" ", Arrays.copyOfRange(args, 1, args.length));

        if (jailManager.isValidReason(reason)) {
            jailManager.jailPlayer(target, reason, player.getLocation().getWorld().getName());
            player.sendMessage(target.getName() + " er blevet jailet: " + reason);
        } else {
            player.sendMessage("Ugyldig grund. Tilgængelige grunde: " + jailManager.getAvailableReasons());
        }

        return true;
    }

}
