package dev.steph.tpaplugin;

import dev.steph.tpaplugin.commands.AcceptCommand;
import dev.steph.tpaplugin.commands.TpaCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class TpaPlugin extends JavaPlugin {
    private TpaManager tpaManager;

    @Override
    public void onLoad() {
        this.tpaManager = new TpaManager();
    }

    @Override
    public void onEnable() {
        getCommand("tpa").setExecutor(new TpaCommand(tpaManager));
        getCommand("accept").setExecutor(new AcceptCommand(tpaManager));
    }
}
