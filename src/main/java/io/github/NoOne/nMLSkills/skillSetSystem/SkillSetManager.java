package io.github.NoOne.nMLSkills.skillSetSystem;

import io.github.NoOne.nMLSkills.NMLSkills;
import io.github.NoOne.nMLSkills.skillSystem.ResetSkillsEvent;
import io.github.NoOne.nMLSkills.skillSystem.Skills;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SkillSetManager {
    private static Map<UUID, SkillSet> profileMap = new HashMap<>(); // hashmap of all the profiles of all the players online atm
    private FileConfiguration config;
    private SkillSetConfig skillSetConfig;

    public SkillSetManager(NMLSkills nmlSkills) {
        skillSetConfig = nmlSkills.getSkillProfileConfig();
        config = skillSetConfig.getConfig();
    }

    public SkillSet createNewbieProfile(Player player) {
        SkillSet skillSet = new SkillSet(Skills.generateNewbieSkills());

        profileMap.put(player.getUniqueId(), skillSet);
        Bukkit.getPluginManager().callEvent(new ResetSkillsEvent(player));

        return skillSet;
    }

    public SkillSet getSkillSet(UUID uuid) {
        return profileMap.get(uuid);
    }

    public void loadSkillsFromConfig() {
        for (String id : config.getConfigurationSection("").getKeys(false)) {
            UUID uuid = UUID.fromString(id);

            int foragingLevel = config.getInt(id + ".skills.foragingLevel");
            int miningLevel = config.getInt(id + ".skills.miningLevel");
            int fishingLevel = config.getInt(id + ".skills.fishingLevel");
            int cultivatingLevel = config.getInt(id + ".skills.cultivatingLevel");
            int craftingLevel = config.getInt(id + ".skills.craftingLevel");
            int cookingLevel = config.getInt(id + ".skills.cookingLevel");
            int acrobaticsLevel = config.getInt(id + ".skills.acrobaticsLevel");
            int stealthLevel = config.getInt(id + ".skills.stealthLevel");

            double foragingExp = config.getDouble(id + ".skills.foragingExp");
            double miningExp = config.getDouble(id + ".skills.miningExp");
            double fishingExp = config.getDouble(id + ".skills.fishingExp");
            double cultivatingExp = config.getDouble(id + ".skills.cultivatingExp");
            double craftingExp = config.getDouble(id + ".skills.craftingExp");
            double cookingExp = config.getDouble(id + ".skills.cookingExp");
            double acrobaticsExp = config.getDouble(id + ".skills.acrobaticsExp");
            double stealthExp = config.getDouble(id + ".skills.stealthExp");

            int exp2LvlUpForaging = config.getInt(id + ".skills.exp2LvlUpForaging");
            int exp2LvlUpMining = config.getInt(id + ".skills.exp2LvlUpMining");
            int exp2LvlUpFishing = config.getInt(id + ".skills.exp2LvlUpFishing");
            int exp2LvlUpCultivating = config.getInt(id + ".skills.exp2LvlUpCultivating");
            int exp2LvlUpCrafting = config.getInt(id + ".skills.exp2LvlUpCrafting");
            int exp2LvlUpCooking = config.getInt(id + ".skills.exp2LvlUpCooking");
            int exp2LvlUpAcrobatics = config.getInt(id + ".skills.exp2LvlUpAcrobatics");
            int exp2LvlUpStealth = config.getInt(id + ".skills.exp2LvlUpStealth");

            Skills skills = new Skills(foragingLevel, miningLevel, fishingLevel, cultivatingLevel, craftingLevel, cookingLevel, acrobaticsLevel, stealthLevel,
                                        foragingExp, miningExp, fishingExp, cultivatingExp, craftingExp, cookingExp, acrobaticsExp, stealthExp);

            SkillSet skillSet = new SkillSet(skills);
            profileMap.put(uuid, skillSet);
        }
    }

    public void saveSkillsToConfig() {
        for (UUID uuid : profileMap.keySet()) {
            String id = uuid.toString();
            SkillSet skillSet = profileMap.get(uuid);
            Skills skills = skillSet.getSkills();

            config.set(id + ".skills.foragingLevel", skills.getForagingLevel());
            config.set(id + ".skills.miningLevel", skills.getMiningLevel());
            config.set(id + ".skills.fishingLevel", skills.getFishingLevel());
            config.set(id + ".skills.cultivatingLevel", skills.getCultivatingLevel());
            config.set(id + ".skills.craftingLevel", skills.getCraftingLevel());
            config.set(id + ".skills.cookingLevel", skills.getCookingLevel());
            config.set(id + ".skills.acrobaticsLevel", skills.getAcrobaticsLevel());
            config.set(id + ".skills.stealthLevel", skills.getStealthLevel());

            config.set(id + ".skills.foragingExp", skills.getForagingExp());
            config.set(id + ".skills.miningExp", skills.getMiningExp());
            config.set(id + ".skills.fishingExp", skills.getFishingExp());
            config.set(id + ".skills.cultivatingExp", skills.getCultivatingExp());
            config.set(id + ".skills.craftingExp", skills.getCraftingExp());
            config.set(id + ".skills.cookingExp", skills.getCookingExp());
            config.set(id + ".skills.acrobaticsExp", skills.getAcrobaticsExp());
            config.set(id + ".skills.stealthExp", skills.getStealthExp());

            config.set(id + ".skills.exp2LvlUpForaging", skills.getExp2LvlUpForaging());
            config.set(id + ".skills.exp2LvlUpMining", skills.getExp2LvlUpMining());
            config.set(id + ".skills.exp2LvlUpFishing", skills.getExp2LvlUpFishing());
            config.set(id + ".skills.exp2LvlUpCultivating", skills.getExp2LvlUpCultivating());
            config.set(id + ".skills.exp2LvlUpCrafting", skills.getExp2LvlUpCrafting());
            config.set(id + ".skills.exp2LvlUpCooking", skills.getExp2LvlUpCooking());
            config.set(id + ".skills.exp2LvlUpAcrobatics", skills.getExp2LvlUpAcrobatics());
            config.set(id + ".skills.exp2LvlUpStealth", skills.getExp2LvlUpStealth());
        }
    }

    public void saveASkillSetToConfig(Player player) {
        String id = player.getUniqueId().toString();
        SkillSet skillSet = profileMap.get(player.getUniqueId());
        Skills skills = skillSet.getSkills();

        config.set(id + ".skills.foragingLevel", skills.getForagingLevel());
        config.set(id + ".skills.miningLevel", skills.getMiningLevel());
        config.set(id + ".skills.fishingLevel", skills.getFishingLevel());
        config.set(id + ".skills.cultivatingLevel", skills.getCultivatingLevel());
        config.set(id + ".skills.craftingLevel", skills.getCraftingLevel());
        config.set(id + ".skills.cookingLevel", skills.getCookingLevel());
        config.set(id + ".skills.acrobaticsLevel", skills.getAcrobaticsLevel());
        config.set(id + ".skills.stealthLevel", skills.getStealthLevel());

        config.set(id + ".skills.foragingExp", skills.getForagingExp());
        config.set(id + ".skills.miningExp", skills.getMiningExp());
        config.set(id + ".skills.fishingExp", skills.getFishingExp());
        config.set(id + ".skills.cultivatingExp", skills.getCultivatingExp());
        config.set(id + ".skills.craftingExp", skills.getCraftingExp());
        config.set(id + ".skills.cookingExp", skills.getCookingExp());
        config.set(id + ".skills.acrobaticsExp", skills.getAcrobaticsExp());
        config.set(id + ".skills.stealthExp", skills.getStealthExp());

        config.set(id + ".skills.exp2LvlUpForaging", skills.getExp2LvlUpForaging());
        config.set(id + ".skills.exp2LvlUpMining", skills.getExp2LvlUpMining());
        config.set(id + ".skills.exp2LvlUpFishing", skills.getExp2LvlUpFishing());
        config.set(id + ".skills.exp2LvlUpCultivating", skills.getExp2LvlUpCultivating());
        config.set(id + ".skills.exp2LvlUpCrafting", skills.getExp2LvlUpCrafting());
        config.set(id + ".skills.exp2LvlUpCooking", skills.getExp2LvlUpCooking());
        config.set(id + ".skills.exp2LvlUpAcrobatics", skills.getExp2LvlUpAcrobatics());
        config.set(id + ".skills.exp2LvlUpStealth", skills.getExp2LvlUpStealth());
    }
}