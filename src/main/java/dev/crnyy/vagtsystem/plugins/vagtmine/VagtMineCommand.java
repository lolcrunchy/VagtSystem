package dev.crnyy.vagtsystem.plugins.vagtmine;

import dev.crnyy.vagtsystem.Main;
import dev.crnyy.vagtsystem.files.Config;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.earth2me.essentials.Essentials;
public class VagtMineCommand implements CommandExecutor {

    private final VagtMine mine;
    private final Config config;
    private final Main main;
    public VagtMineCommand(VagtMine mine, Config config, Main main) {
        this.mine = mine;
        this.config = config;
        this.main = main;
    }

    public int blocksRemaining;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            return true;
        }
        final Player player = (Player) sender;
        ItemUtils item = new ItemUtils();
        if (cmd.getName().equalsIgnoreCase("spassermine")) {
            if (args.length == 1 && !args[0].isEmpty()) {
                final Player player1 = Bukkit.getPlayer(args[0]);

                if (player1 != null) {
                    if (mine.playersCurrentlyInMine.contains(player1.getUniqueId())) {
                        mine.playersCurrentlyInMine.remove(player.getUniqueId());
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "spawn " + player.getName());
                        mine.blocksMined.remove(player.getUniqueId());
                        return true;
                    }
                    Essentials essentials = (Essentials) main.getServer().getPluginManager().getPlugin("Essentials");
                    player.sendMessage("Du har sendt " + player1.getName() + " i spasserminen.");
                    player1.sendMessage("Du er blevet sendt i spasserminen!");

                    blocksRemaining = config.getConfig().getInt("Spassermine.Antal-start-blocks");

                    mine.blocksMined.put(player1.getUniqueId(), 0);
                    mine.playersCurrentlyInMine.add(player1.getUniqueId());
                    player1.getInventory().addItem(item.pickaxe(player1, blocksRemaining));
                    player.teleport(essentials.getWarps().getWarp("spassermine").getBlock().getLocation());
                    return true;
                } else {
                    player.sendMessage("Spilleren blev ikke fundet!");
                }
            } else {
                player.sendMessage("Du skal skrive spillerens navn!");
            }
        }

        return false;
    }

}
