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
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class MaxExpertiseSkillsCommand implements CommandExecutor {
    private SaveSkillsManager saveSkillsManager;

    public MaxExpertiseSkillsCommand(NMLSkills nmlSkills) {
        this.saveSkillsManager = nmlSkills.getSaveSkillsManager();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            Skills skills = saveSkillsManager.getSkills(player.getUniqueId());
            HashMap<Skill, Integer> expertiseSkills = skills.getExpertiseSkills();

            for (Map.Entry<Skill, Integer> entry : expertiseSkills.entrySet()) {
                Bukkit.getPluginManager().callEvent(new SkillChangeEvent(player, entry.getKey(), false, 99 - entry.getValue()));
            }
        }

        return true;
    }
}
