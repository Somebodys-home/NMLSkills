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
            String skill = args[0];
            double prevExp = 0;
            double newExp = Double.parseDouble(args[1]);
            int exp2LevelUp = skills.getExpToLvlUpSkill(skill);

            if (newExp >= exp2LevelUp) {
                player.sendMessage("§cNew exp value cannot be greater than exp needed to level up skill.");
            } else {
                switch (skill) {
                    case "combat" -> prevExp = skills.getCombatExp();
                    case "foraging" -> prevExp = skills.getForagingExp();
                    case "mining" -> prevExp = skills.getMiningExp();
                    case "fishing" -> prevExp = skills.getFishingExp();
                    case "farming" -> prevExp = skills.getFarmingExp();
                    case "crafting" -> prevExp = skills.getCraftingExp();
                    case "cooking" -> prevExp = skills.getCookingExp();
                    case "acrobatics" -> prevExp = skills.getAcrobaticsExp();
                    case "stealth" -> prevExp = skills.getStealthExp();
                    case "soldier" -> prevExp = skills.getSoldierExp();
                    case "marauder" -> prevExp = skills.getMarauderExp();
                    case "assassin" -> prevExp = skills.getAssassinExp();
                    case "cavalier" -> prevExp = skills.getCavalierExp();
                    case "martialartist" -> prevExp = skills.getMartialArtistExp();
                    case "shieldhero" -> prevExp = skills.getShieldHeroExp();
                    case "marksman" -> prevExp = skills.getMarksmanExp();
                    case "sorcerer" -> prevExp = skills.getSorcererExp();
                    case "primordial" -> prevExp = skills.getPrimordialExp();
                    case "hallowed" -> prevExp = skills.getHallowedExp();
                    case "annulled" -> prevExp = skills.getAnnulledExp();
                }

                Bukkit.getPluginManager().callEvent(new SkillChangeEvent(player, skill + "exp", newExp - prevExp));
            }
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
