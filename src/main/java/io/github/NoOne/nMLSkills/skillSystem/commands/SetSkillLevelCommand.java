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
            int prevLevel = 0;
            int newLevel = Integer.parseInt(args[1]);

            switch (args[0]) {
                case "combat" -> {
                    prevLevel = skills.getCombatLevel();
                    skills.setCombatLevel(newLevel);
                }
                case "foraging" -> {
                    prevLevel = skills.getForagingLevel();
                    skills.setForagingLevel(newLevel);
                }
                case "mining" -> {
                    prevLevel = skills.getMiningLevel();
                    skills.setMiningLevel(newLevel);
                }
                case "fishing" -> {
                    prevLevel = skills.getFishingLevel();
                    skills.setFishingLevel(newLevel);
                }
                case "farming" -> {
                    prevLevel = skills.getFarmingLevel();
                    skills.setFarmingLevel(newLevel);
                }
                case "crafting" -> {
                    prevLevel = skills.getCraftingLevel();
                    skills.setCraftingLevel(newLevel);
                }
                case "cooking" -> {
                    prevLevel = skills.getCookingLevel();
                    skills.setCookingLevel(newLevel);
                }
                case "acrobatics" -> {
                    prevLevel = skills.getAcrobaticsLevel();
                    skills.setAcrobaticsLevel(newLevel);
                }
                case "stealth" -> {
                    prevLevel = skills.getStealthLevel();
                    skills.setStealthLevel(newLevel);
                }
                case "soldier" -> {
                    prevLevel = skills.getSoldierLevel();
                    skills.setSoldierLevel(newLevel);
                }
                case "marauder" -> {
                    prevLevel = skills.getMarauderLevel();
                    skills.setMarauderLevel(newLevel);
                }
                case "assassin" -> {
                    prevLevel = skills.getAssassinLevel();
                    skills.setAssassinLevel(newLevel);
                }
                case "cavalier" -> {
                    prevLevel = skills.getCavalierLevel();
                    skills.setCavalierLevel(newLevel);
                }
                case "martialartist" -> {
                    prevLevel = skills.getMartialArtistLevel();
                    skills.setMartialArtistLevel(newLevel);
                }
                case "shieldhero" -> {
                    prevLevel = skills.getShieldHeroLevel();
                    skills.setShieldHeroLevel(newLevel);
                }
                case "marksman" -> {
                    prevLevel = skills.getMarksmanLevel();
                    skills.setMarksmanLevel(newLevel);
                }
                case "sorcerer" -> {
                    prevLevel = skills.getSorcererLevel();
                    skills.setSorcererLevel(newLevel);
                }
                case "primordial" -> {
                    prevLevel = skills.getPrimordialLevel();
                    skills.setPrimordialLevel(newLevel);
                }
                case "hallowed" -> {
                    prevLevel = skills.getHallowedLevel();
                    skills.setHallowedLevel(newLevel);
                }
                case "annulled" -> {
                    prevLevel = skills.getAnnulledLevel();
                    skills.setAnnulledLevel(newLevel);
                }
            }

            Bukkit.getPluginManager().callEvent(new SkillChangeEvent(player, args[0], newLevel - prevLevel));
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
