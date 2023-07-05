package dev.steph.tpaplugin;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TpaManager {
    private final Map<UUID, TpaRequest> requests = new HashMap<>();

    public void sendRequest(Player from, Player to) {
        if (from.getUniqueId().equals(to.getUniqueId())) {
            from.sendMessage("§cYou can't send tpa-requests to yourself!");
            return;
        }

        requests.put(to.getUniqueId(), new TpaRequest(from, to));
        from.sendMessage("§aTpa-Request has been sent to " + to.getName());
        to.sendMessage("§aYou received a tpa-request from " + from.getName() + ". Type /accept to accept it");
    }

    public void acceptRequest(Player player) {
        final TpaRequest request = requests.get(player.getUniqueId());

        if (request == null) {
            player.sendMessage("§cYou don't have any tpa-requests! :(");
            return;
        }

        final Player teleportTo = request.getFrom();
        player.teleport(teleportTo);

        requests.remove(player.getUniqueId());
    }
}
