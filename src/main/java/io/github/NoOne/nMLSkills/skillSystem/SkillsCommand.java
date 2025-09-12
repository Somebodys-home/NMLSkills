package io.github.NoOne.nMLSkills.skillSystem;

import io.github.NoOne.menuSystem.MenuSystem;
import io.github.NoOne.nMLPlayerStats.NMLPlayerStats;
import io.github.NoOne.nMLPlayerStats.profileSystem.ProfileManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StatsCommand implements CommandExecutor {
    private final NMLPlayerStats nmlPlayerStats;

    public StatsCommand(NMLPlayerStats nmlPlayerStats) {
        this.nmlPlayerStats = nmlPlayerStats;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player player) {
            new SkillsMenu(MenuSystem.getPlayerMenuUtility(player), nmlPlayerStats).open();
        }

        return true;
    }
}