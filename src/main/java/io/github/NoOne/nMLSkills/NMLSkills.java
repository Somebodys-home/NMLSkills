package io.github.NoOne.nMLSkills;

import io.github.NoOne.menuSystem.MenuListener;
import io.github.NoOne.nMLSkills.skillSetSystem.SkillSetConfig;
import io.github.NoOne.nMLSkills.skillSetSystem.SkillSetListener;
import io.github.NoOne.nMLSkills.skillSetSystem.SkillSetManager;
import io.github.NoOne.nMLSkills.skillSystem.commands.*;
import io.github.NoOne.nMLSkills.skillSystem.SkillBars;
import io.github.NoOne.nMLSkills.skillSystem.SkillListener;
import org.bukkit.plugin.java.JavaPlugin;

public class NMLSkills extends JavaPlugin {
    private static NMLSkills instance;
    private SkillSetManager skillSetManager;
    private SkillSetConfig skillSetConfig;

    @Override
    public void onEnable() {
        instance = this;

        skillSetConfig = new SkillSetConfig(this, "skillsets");
        skillSetConfig.loadConfig();

        skillSetManager = new SkillSetManager(this);
        skillSetManager.loadSkillsFromConfig();

        getCommand("resetSkills").setExecutor(new ResetSkillsCommand(this));
        getCommand("skills").setExecutor(new SkillsCommand(this));
        getCommand("setSkillLevel").setExecutor(new SetSkillLevelCommand(this));
        getCommand("setSkillExp").setExecutor(new SetSkillExpCommand(this));
        getCommand("maxSkills").setExecutor(new MaxSkillsCommand(this));
        getCommand("maxExpertiseSkills").setExecutor(new MaxExpertiseSkillsCommand(this));
        getServer().getPluginManager().registerEvents(new SkillSetListener(this), this);
        getServer().getPluginManager().registerEvents(new SkillListener(this), this);
        getServer().getPluginManager().registerEvents(new MenuListener(), this);
    }

    @Override
    public void onDisable() {
        skillSetManager.saveSkillsToConfig(); // DO NOT CHANGE THE ORDER OF THIS, THAT SHIT EXPLODES
        skillSetConfig.saveConfig();
    }

    public static NMLSkills getInstance() {
        return instance;
    }

    public SkillSetManager getSkillSetManager() {
        return skillSetManager;
    }

    public SkillSetConfig getSkillProfileConfig() {
        return skillSetConfig;
    }
}
