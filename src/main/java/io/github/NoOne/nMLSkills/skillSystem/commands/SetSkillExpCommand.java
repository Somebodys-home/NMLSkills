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

            switch (args[0]) {
                case "combat" -> skills.setCombatExp(Double.parseDouble(args[1]));
                case "foraging" -> skills.setForagingExp(Double.parseDouble(args[1]));
                case "mining" -> skills.setMiningExp(Double.parseDouble(args[1]));
                case "fishing" -> skills.setFishingExp(Double.parseDouble(args[1]));
                case "cultivating" -> skills.setCultivatingExp(Double.parseDouble(args[1]));
                case "crafting" -> skills.setCraftingExp(Double.parseDouble(args[1]));
                case "cooking" -> skills.setCookingExp(Double.parseDouble(args[1]));
                case "acrobatics" -> skills.setAcrobaticsExp(Double.parseDouble(args[1]));
                case "stealth" -> skills.setStealthExp(Double.parseDouble(args[1]));
            }

            Bukkit.getPluginManager().callEvent(new SkillChangeEvent(player, args[0]+"exp"));
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
