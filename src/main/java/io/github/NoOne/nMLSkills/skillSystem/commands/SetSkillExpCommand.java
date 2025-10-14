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

public class SetSkillExpCommand implements CommandExecutor, TabCompleter {
    private final SkillSetManager skillSetManager;

    public SetSkillExpCommand(NMLSkills nmlSkills) {
        this.skillSetManager = nmlSkills.getSkillSetManager();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            Skills skills = skillSetManager.getSkillSet(player.getUniqueId()).getSkills();
            double prevExp = 0;
            double newExp = Double.parseDouble(args[1]);

            switch (args[0]) {
                case "combat" -> {
                    prevExp = skills.getCombatExp();
                    skills.setCombatExp(newExp);
                }
                case "foraging" -> {
                    prevExp = skills.getForagingExp();
                    skills.setForagingExp(newExp);
                }
                case "mining" -> {
                    prevExp = skills.getMiningExp();
                    skills.setMiningExp(newExp);
                }
                case "fishing" -> {
                    prevExp = skills.getFishingExp();
                    skills.setFishingExp(newExp);
                }
                case "cultivating" -> {
                    prevExp = skills.getCultivatingExp();
                    skills.setCultivatingExp(newExp);
                }
                case "crafting" -> {
                    prevExp = skills.getCraftingExp();
                    skills.setCraftingExp(newExp);
                }
                case "cooking" -> {
                    prevExp = skills.getCookingExp();
                    skills.setCookingExp(newExp);
                }
                case "acrobatics" -> {
                    prevExp = skills.getAcrobaticsExp();
                    skills.setAcrobaticsExp(newExp);
                }
                case "stealth" -> {
                    prevExp = skills.getStealthExp();
                    skills.setStealthExp(newExp);
                }
            }

            Bukkit.getPluginManager().callEvent(new SkillChangeEvent(player, args[0]+"exp", newExp - prevExp));
        }

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (strings.length == 1) {
            return new ArrayList<>(List.of("combat", "foraging", "mining", "fishing", "cultivating", "crafting", "cooking", "acrobatics", "stealth")).stream()
                    .filter(string -> string.toLowerCase().startsWith(strings[0].toLowerCase()))
                    .collect(Collectors.toList());
        }

        return List.of();
    }
}
