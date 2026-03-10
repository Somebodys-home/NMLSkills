package io.github.NoOne.nMLSkills.skillSystem.commands;

import io.github.NoOne.nMLSkills.NMLSkills;
import io.github.NoOne.nMLSkills.skillSetSystem.SkillSetManager;
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
    private final SkillSetManager skillSetManager;

    public SetSkillLevelCommand(NMLSkills nmlSkills) {
        this.skillSetManager = nmlSkills.getSkillSetManager();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            Skills skills = skillSetManager.getSkillSet(player.getUniqueId()).getSkills();
            String skill = args[0];
            int prevLevel = 0;
            int newLevel = Integer.parseInt(args[1]);

            switch (skill) {
                case "combat" -> prevLevel = skills.getCombatLevel();
                case "foraging" -> prevLevel = skills.getForagingLevel();
                case "mining" -> prevLevel = skills.getMiningLevel();
                case "fishing" -> prevLevel = skills.getFishingLevel();
                case "farming" -> prevLevel = skills.getFarmingLevel();
                case "crafting" -> prevLevel = skills.getCraftingLevel();
                case "cooking" -> prevLevel = skills.getCookingLevel();
                case "acrobatics" -> prevLevel = skills.getAcrobaticsLevel();
                case "stealth" -> prevLevel = skills.getStealthLevel();
                case "soldier" -> prevLevel = skills.getSoldierLevel();
                case "marauder" -> prevLevel = skills.getMarauderLevel();
                case "assassin" -> prevLevel = skills.getAssassinLevel();
                case "cavalier" -> prevLevel = skills.getCavalierLevel();
                case "martialartist" -> prevLevel = skills.getMartialArtistLevel();
                case "shieldhero" -> prevLevel = skills.getShieldHeroLevel();
                case "marksman" -> prevLevel = skills.getMarksmanLevel();
                case "sorcerer" -> prevLevel = skills.getSorcererLevel();
                case "primordial" -> prevLevel = skills.getPrimordialLevel();
                case "hallowed" -> prevLevel = skills.getHallowedLevel();
                case "annulled" -> prevLevel = skills.getAnnulledLevel();
            }

            Bukkit.getPluginManager().callEvent(new SkillChangeEvent(player, skill, newLevel - prevLevel));
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
