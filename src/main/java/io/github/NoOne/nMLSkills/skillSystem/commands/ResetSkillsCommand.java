package io.github.NoOne.nMLSkills.skillSystem.commands;

import io.github.NoOne.nMLSkills.NMLSkills;
import io.github.NoOne.nMLSkills.skillSetSystem.SkillSetManager;
import io.github.NoOne.nMLSkills.skillSystem.ResetSkillsEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ResetSkillsCommand implements CommandExecutor {
    private final SkillSetManager skillSetManager;

    public ResetSkillsCommand(NMLSkills nmlSkills) {
        this.skillSetManager = nmlSkills.getSkillProfileManager();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            Bukkit.getPluginManager().callEvent(new ResetSkillsEvent(player));
            player.sendMessage(ChatColor.GREEN + "Your skills have been reset.");
        }

        return true;
    }
}
