package io.github.NoOne.nMLSkills.skillSystem.commands;

import io.github.NoOne.menuSystem.MenuSystem;
import io.github.NoOne.nMLSkills.NMLSkills;
import io.github.NoOne.nMLSkills.skillSystem.menus.SkillsMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SkillsCommand implements CommandExecutor {
    private final NMLSkills nmlSkills;

    public SkillsCommand(NMLSkills nmlSkills) {
        this.nmlSkills = nmlSkills;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player player) {
            new SkillsMenu(MenuSystem.getPlayerMenuUtility(player), nmlSkills).open();
        }

        return true;
    }
}