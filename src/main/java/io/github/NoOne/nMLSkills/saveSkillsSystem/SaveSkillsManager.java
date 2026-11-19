package io.github.NoOne.nMLSkills.saveSkillsSystem;

import io.github.NoOne.nMLSkills.NMLSkills;
import io.github.NoOne.nMLSkills.skillSystem.Skill;
import io.github.NoOne.nMLSkills.skillSystem.Skills;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class SaveSkillsManager {
    private HashMap<UUID, Skills> skillsMap; // hashmap of all the profiles of all the players online atm
    private FileConfiguration config;
    private SaveSkillsConfig saveSkillsConfig;

    public SaveSkillsManager(NMLSkills nmlSkills) {
        saveSkillsConfig = nmlSkills.getSkillProfileConfig();
        config = saveSkillsConfig.getConfig();
        skillsMap = new HashMap<>();
    }

    public void loadSkillsFromConfig() {
        for (String id : config.getConfigurationSection("").getKeys(false)) {
            UUID uuid = UUID.fromString(id);
            LinkedHashMap<Skill, Integer> skillLevels = new LinkedHashMap<>();
            LinkedHashMap<Skill, Integer> skillExps = new LinkedHashMap<>();

            for (Skill skill : Skill.values()) {
                skillLevels.put(skill, config.getInt(id + ".skills." + skill.toString()));
                skillExps.put(skill, config.getInt(id + ".skills." + skill + "Exp"));
            }

            skillsMap.put(uuid, new Skills(skillLevels, skillExps));
        }
    }

    public void saveSkillsToConfig() {
        for (Map.Entry<UUID, Skills> entry : skillsMap.entrySet()) {
            String id = entry.getKey().toString();
            Skills skills = entry.getValue();

            for (Skill skill : skills.getSkillLevels().keySet()) {
                config.set(id + ".skills." + skill, skills.getSkillLevel(skill));
            }

            for (Skill skill : skills.getSkillExps().keySet()) {
                config.set(id + ".skills." + skill + "Exp", skills.getSkillExp(skill));
            }
        }
    }

    public void saveASkillSetToConfig(Player player) {
        String id = player.getUniqueId().toString();
        Skills skills = skillsMap.get(player.getUniqueId());

        for (Skill skill : skills.getSkillLevels().keySet()) {
            config.set(id + ".skills." + skill, skills.getSkillLevel(skill));
        }

        for (Skill skill : skills.getSkillExps().keySet()) {
            config.set(id + ".skills." + skill + "Exp", skills.getSkillExp(skill));
        }
    }

    public void createNewbieSkills(Player player) {
        skillsMap.put(player.getUniqueId(), Skills.generateNewbieSkills());
    }

    public boolean hasSavedSkills(Player player) {
        return skillsMap.containsKey(player.getUniqueId());
    }

    public Skills getSkills(UUID uuid) {
        return skillsMap.get(uuid);
    }
}