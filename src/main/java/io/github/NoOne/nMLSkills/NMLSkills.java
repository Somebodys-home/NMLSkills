package io.github.NoOne.nMLSkills;

import io.github.NoOne.menuSystem.MenuListener;
import io.github.NoOne.nMLConfig.ConfigTemplate;
import io.github.NoOne.nMLSkills.commands.*;
import io.github.NoOne.nMLSkills.skillSystem.SkillBars;
import io.github.NoOne.nMLSkills.skillSystem.SkillListener;
import org.bukkit.plugin.java.JavaPlugin;

public class NMLSkills extends JavaPlugin {
    private static NMLSkills instance;
    private SaveSkillsManager saveSkillsManager;
    private ConfigTemplate saveSkillsConfig;

    @Override
    public void onEnable() {
        instance = this;

        saveSkillsConfig = new ConfigTemplate(this, "skillsets");
        saveSkillsConfig.loadConfig();

        saveSkillsManager = new SaveSkillsManager(this);
        saveSkillsManager.loadSkillsFromConfig();

        SkillBars.startShowBarsTask();

        getCommand("resetSkills").setExecutor(new ResetSkillsCommand(this));
        getCommand("skills").setExecutor(new SkillsCommand(this));
        getCommand("setSkillLevel").setExecutor(new SetSkillLevelCommand(this));
        getCommand("setSkillExp").setExecutor(new SetSkillExpCommand(this));
        getCommand("maxSkills").setExecutor(new MaxSkillsCommand(this));
        getCommand("maxExpertiseSkills").setExecutor(new MaxExpertiseSkillsCommand(this));
        getServer().getPluginManager().registerEvents(new SkillListener(this), this);
        getServer().getPluginManager().registerEvents(new MenuListener(), this);
    }

    @Override
    public void onDisable() {
        saveSkillsManager.saveSkillsToConfig();
        saveSkillsConfig.saveConfig();
    }

    public static NMLSkills getInstance() {
        return instance;
    }

    public SaveSkillsManager getSaveSkillsManager() {
        return saveSkillsManager;
    }

    public ConfigTemplate getSkillProfileConfig() {
        return saveSkillsConfig;
    }
}
