package dev.crnyy.vagtsystem.plugins.jailsystem;

import org.bukkit.block.data.type.Switch;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class JailManager {

    private final Map<UUID, JailData> jailedPlayers;
    private final Map<String, Integer> jailReasons;

    public JailManager() {
        this.jailedPlayers = new HashMap<>();
        this.jailReasons = new HashMap<>();

        jailReasons.put("VåbenOgArmor", 8);
        jailReasons.put("Våben", 5);
        jailReasons.put("Armor", 5);
        jailReasons.put("Hakkebombe", 15);
        jailReasons.put("Nopvp", 9);
        jailReasons.put("Narko", 4);
        jailReasons.put("Provo", 3);
        jailReasons.put("Slag", 3);
        jailReasons.put("SlagVagt", 4);
        jailReasons.put("Område", 4);
        jailReasons.put("VagtVault", 8);
    }

    public void jailPlayer(Player player, String reason, String blok) {
        switch (blok) {
            case "c":
                int jailTimeC = jailReasons.get(reason);
                long releaseTimeC = System.currentTimeMillis() + (jailTimeC * 60000L);
                jailedPlayers.put(player.getUniqueId(), new JailData(reason, releaseTimeC));
                //send player spawn a
                break;
            case "b":
                int jailTimeB = jailReasons.get(reason);
                long releaseTimeB = System.currentTimeMillis() + (jailTimeB * 60000L);
                jailedPlayers.put(player.getUniqueId(), new JailData(reason, releaseTimeB));
                //send player spawn a
                break;
            case "a":
                int jailTime = jailReasons.get(reason);
                long releaseTime = System.currentTimeMillis() + (jailTime * 60000L);
                jailedPlayers.put(player.getUniqueId(), new JailData(reason, releaseTime));
                //send player spawn a
                break;
        }
    }

    public void releasePlayer(Player player) {
        jailedPlayers.remove(player.getUniqueId());
        // spawn spiller
    }

    public boolean isPlayerJailed(Player player) {
        return jailedPlayers.containsKey(player.getUniqueId());
    }

    public JailData getJailData(Player player) {
        return jailedPlayers.get(player.getUniqueId());
    }

    public int getTimeForReason(String reason) {
        return jailReasons.getOrDefault(reason.toLowerCase(), -1);
    }

    public boolean isValidReason(String reason) {
        return jailReasons.containsKey(reason.toLowerCase());
    }

    public String getAvailableReasons() {
        return String.join(", ", jailReasons.keySet());
    }

}
