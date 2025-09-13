package io.github.NoOne.nMLSkills.skillSetSystem;

import io.github.NoOne.nMLSkills.NMLSkills;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.io.IOException;

public class SkillSetConfig {
    private NMLSkills nmlSkills;
    private File file;
    private String fileName;
    private FileConfiguration config = new YamlConfiguration();

    public SkillSetConfig(NMLSkills nmlSkills, String filename) {
        this.nmlSkills = nmlSkills;
        this.fileName = filename;
        file = new File(nmlSkills.getDataFolder(), filename + ".yml");
    }

    public void loadConfig() {
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            nmlSkills.saveResource(fileName + ".yml", false);
        } try {
            config.load(file);
        } catch (IOException | InvalidConfigurationException exception) {
            exception.printStackTrace();
        }
    }

    public void saveConfig() {
        try {
            config.save(file);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public FileConfiguration getConfig() {
        return config;
    }
}
