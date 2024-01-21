package dev.crnyy.vagtsystem.plugins.vagtpay;

import dev.crnyy.vagtsystem.files.Config;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Paycheck {

    private final Config config;
    public Paycheck(Config config) {
        this.config = config;
    }

    public static Map<UUID, Integer> payAmount = new HashMap<UUID, Integer>();


    public boolean paycheckIsActive(final Player player) {
        if (payAmount.containsKey(player.getUniqueId())) {
            return true;
        }
        return false;
    }
    public int getPayAmount(final Player player) {
        return payAmount.get(player.getUniqueId());
    }
    public void setPayAmount(final Player player, final int amount) {
        payAmount.put(player.getUniqueId(), amount);
    }
    public void addPayAmount(final Player player, final int amount) {
        int currentAmount = payAmount.get(player.getUniqueId());
        payAmount.put(player.getUniqueId(), currentAmount + amount);
    }
    public void removePayAmount(final Player player, final int amount) {
        int currentAmount = payAmount.get(player.getUniqueId());
        payAmount.put(player.getUniqueId(), currentAmount - amount);
    }
    public void clearPayCheck(final Player player) {
        payAmount.put(player.getUniqueId(), 0);
    }
    public void removeFromMap(final Player player) {
        payAmount.remove(player.getUniqueId());
    }
    public void setStartPay(final Player player) {
        int amount = config.getConfig().getInt("Pay.Start-pay");
        payAmount.put(player.getUniqueId(), amount);
    }

}
