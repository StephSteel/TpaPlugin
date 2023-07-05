package dev.steph.tpaplugin.commands;

import dev.steph.tpaplugin.TpaManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpaCommand implements CommandExecutor {
    private final TpaManager tpaManager;

    public TpaCommand(TpaManager tpaManager) {
        this.tpaManager = tpaManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cOnly players can execute this command!");
            return true;
        }

        Player player = (Player) sender;

        if (args.length < 1) {
            player.sendMessage("§cUsage: /" + label + " <player>");
            return true;
        }

        Player to = Bukkit.getPlayer(args[0]);

        if (to == null) {
            player.sendMessage("§cThis player is not online!");
            return true;
        }

        tpaManager.sendRequest(player, to);
        return true;
    }
}
