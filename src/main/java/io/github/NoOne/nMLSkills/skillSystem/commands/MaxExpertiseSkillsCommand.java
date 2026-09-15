package io.github.NoOne.nMLSkills.skillSystem.commands;

import io.github.NoOne.nMLSkills.NMLSkills;
import io.github.NoOne.nMLSkills.skillSetSystem.SkillSetManager;
import io.github.NoOne.nMLSkills.skillSystem.SkillChangeEvent;
import io.github.NoOne.nMLSkills.skillSystem.Skills;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxExpertiseSkillsCommand implements CommandExecutor {
    private SkillSetManager skillSetManager;

    public MaxExpertiseSkillsCommand(NMLSkills nmlSkills) {
        this.skillSetManager = nmlSkills.getSkillSetManager();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            Skills skills = skillSetManager.getSkillSet(player.getUniqueId()).getSkills();
            HashMap<String, Integer> expertiseSkills = skills.getExpertiseSkills();

            for (Map.Entry<String, Integer> entry : expertiseSkills.entrySet()) {
                Bukkit.getPluginManager().callEvent(new SkillChangeEvent(player, entry.getKey(), 99 - entry.getValue()));
            }

            player.sendMessage("§dYour expertises have been maxed.");
        }

        return true;
    }
}
