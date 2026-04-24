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
import java.util.Map;

public class MaxSkillsCommand implements CommandExecutor {
    private SkillSetManager skillSetManager;

    public MaxSkillsCommand(NMLSkills nmlSkills) {
        this.skillSetManager = nmlSkills.getSkillSetManager();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            Skills skills = skillSetManager.getSkillSet(player.getUniqueId()).getSkills();
            HashMap<String, Integer> prevSkillLevels = new HashMap<>() {{
                put("combat", skills.getCombatLevel());
                put("foraging", skills.getForagingLevel());
                put("mining", skills.getMiningLevel());
                put("farming", skills.getFarmingLevel());
                put("crafting", skills.getCraftingLevel());
                put("cooking", skills.getCookingLevel());
                put("acrobatics", skills.getAcrobaticsLevel());
                put("stealth", skills.getStealthLevel());
                put("soldier", skills.getSoldierLevel());
                put("marauder", skills.getMarauderLevel());
                put("assassin", skills.getAssassinLevel());
                put("cavalier", skills.getCavalierLevel());
                put("martialartist", skills.getMartialArtistLevel());
                put("shieldhero", skills.getShieldHeroLevel());
                put("marksman", skills.getMarksmanLevel());
                put("sorcerer", skills.getSorcererLevel());
                put("primordial", skills.getPrimordialLevel());
                put("hallowed", skills.getHallowedLevel());
                put("annulled", skills.getAnnulledLevel());
            }};

            for (Map.Entry<String, Integer> entry : prevSkillLevels.entrySet()) {
                Bukkit.getPluginManager().callEvent(new SkillChangeEvent(player, entry.getKey(), 99 - entry.getValue()));
            }

            player.sendMessage(ChatColor.GREEN + "Your skills have been maxed.");
        }

        return true;
    }
}