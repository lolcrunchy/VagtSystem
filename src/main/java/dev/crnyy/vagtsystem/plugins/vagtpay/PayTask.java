package dev.crnyy.vagtsystem.plugins.vagtpay;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PayTask implements Runnable {

    private final Paycheck paycheck;
    public PayTask(Paycheck paycheck) {
        this.paycheck = paycheck;
    }

    @Override
    public void run() {
        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            if (player.hasPermission("")) {
                paycheck.addPayAmount(player, 1);
            }
        }
    }


}
