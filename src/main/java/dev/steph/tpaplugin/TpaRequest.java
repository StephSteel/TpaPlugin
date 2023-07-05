package dev.steph.tpaplugin;

import org.bukkit.entity.Player;

public class TpaRequest {
    private final Player from;
    private final Player to;

    public TpaRequest(Player from, Player to) {
        this.from = from;
        this.to = to;
    }

    public Player getFrom() {
        return from;
    }

    public Player getTo() {
        return to;
    }
}
