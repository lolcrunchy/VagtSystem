package dev.crnyy.vagtsystem.plugins.vagtpay;

import dev.crnyy.vagtsystem.files.Config;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
public class PaycheckListener implements Listener {

    private final Paycheck paycheck;
    public PaycheckListener(Paycheck paycheck, Config config) {
        this.paycheck = paycheck;
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent e) {
        final Player player = e.getPlayer();
        if (!(paycheck.paycheckIsActive(player))) {
            paycheck.setStartPay(player);
        }

    }

}
