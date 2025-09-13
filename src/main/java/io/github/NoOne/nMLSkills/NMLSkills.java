package io.github.NoOne.nMLSkills;

import io.github.NoOne.menuSystem.MenuListener;
import io.github.NoOne.nMLSkills.skillSetSystem.SkillSetConfig;
import io.github.NoOne.nMLSkills.skillSetSystem.SkillSetListener;
import io.github.NoOne.nMLSkills.skillSetSystem.SkillSetManager;
import io.github.NoOne.nMLSkills.skillSystem.commands.ResetSkillsCommand;
import io.github.NoOne.nMLSkills.skillSystem.SkillBars;
import io.github.NoOne.nMLSkills.skillSystem.SkillListener;
import io.github.NoOne.nMLSkills.skillSystem.commands.SetSkillExpCommand;
import io.github.NoOne.nMLSkills.skillSystem.commands.SetSkillLevelCommand;
import io.github.NoOne.nMLSkills.skillSystem.commands.SkillsCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class NMLSkills extends JavaPlugin {
    private NMLSkills instance;
    private SkillSetManager skillSetManager;
    private SkillSetConfig skillSetConfig;
    private SkillBars skillBars;

    @Override
    public void onEnable() {
        instance = this;

        skillBars = new SkillBars(this);
        skillBars.start();

        skillSetConfig = new SkillSetConfig(this, "skillsets");
        skillSetConfig.loadConfig();

        skillSetManager = new SkillSetManager(this);
        skillSetManager.loadSkillsFromConfig();

        getCommand("resetSkills").setExecutor(new ResetSkillsCommand(this));
        getCommand("skills").setExecutor(new SkillsCommand(this));
        getCommand("setSkillLevel").setExecutor(new SetSkillLevelCommand(this));
        getCommand("setSkillExp").setExecutor(new SetSkillExpCommand(this));
        getServer().getPluginManager().registerEvents(new SkillSetListener(this), this);
        getServer().getPluginManager().registerEvents(new SkillListener(this), this);
        getServer().getPluginManager().registerEvents(new MenuListener(), this);
    }

    @Override
    public void onDisable() {
        skillBars.stop();
        skillSetManager.saveSkillsToConfig(); // DO NOT CHANGE THE ORDER OF THIS, THAT SHIT EXPLODES
        skillSetConfig.saveConfig();
    }

    public NMLSkills getInstance() {
        return instance;
    }

    public SkillSetManager getSkillProfileManager() {
        return skillSetManager;
    }

    public SkillSetConfig getSkillProfileConfig() {
        return skillSetConfig;
    }
}
