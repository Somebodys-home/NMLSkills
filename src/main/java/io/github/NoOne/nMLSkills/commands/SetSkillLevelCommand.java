package io.github.NoOne.nMLSkills.commands;

import io.github.NoOne.nMLSkills.NMLSkills;
import io.github.NoOne.nMLSkills.SaveSkillsManager;
import io.github.NoOne.nMLSkills.skillSystem.Skill;
import io.github.NoOne.nMLSkills.skillSystem.SkillChangeEvent;
import io.github.NoOne.nMLSkills.skillSystem.Skills;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SetSkillLevelCommand implements CommandExecutor, TabCompleter {
    private SaveSkillsManager saveSkillsManager;

    public SetSkillLevelCommand(NMLSkills nmlSkills) {
        this.saveSkillsManager = nmlSkills.getSaveSkillsManager();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            Skills skills = saveSkillsManager.getSkills(player.getUniqueId());
            Skill skill = Skill.fromString(args[0]);
            int prevLevel = skills.getSkillLevel(skill);
            int newLevel = Integer.parseInt(args[1]);

            Bukkit.getPluginManager().callEvent(new SkillChangeEvent(player, skill, false, newLevel - prevLevel));
        }

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (strings.length == 1) {
            return new ArrayList<>(List.of("combat", "foraging", "mining", "fishing", "farming", "crafting", "cooking", "acrobatics", "stealth",
                                            "soldier", "marauder", "assassin", "cavalier", "martialartist", "shieldhero", "marksman", "sorcerer", "primordial",
                                            "hallowed", "annulled")).stream()
                    .filter(string -> string.toLowerCase().startsWith(strings[0].toLowerCase()))
                    .collect(Collectors.toList());
        }

        return List.of();
    }
}
