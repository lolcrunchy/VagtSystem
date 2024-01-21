package dev.crnyy.vagtsystem.plugins.vagtmine;

import org.bukkit.entity.Player;

import java.util.*;

public class VagtMine {
    public static Map<UUID, Integer> blocksMined = new HashMap<UUID, Integer>();
    public static List<UUID> playersCurrentlyInMine = new ArrayList<UUID>();

    public void addBlock(final Player player) {
        int current = blocksMined.getOrDefault(player.getUniqueId(), 0);
        blocksMined.put(player.getUniqueId(), current + 1);
    }

}
