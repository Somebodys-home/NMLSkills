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

            int combatLevel = config.getInt(id + ".skills.combatLevel");
            int foragingLevel = config.getInt(id + ".skills.foragingLevel");
            int miningLevel = config.getInt(id + ".skills.miningLevel");
            int fishingLevel = config.getInt(id + ".skills.fishingLevel");
            int cultivatingLevel = config.getInt(id + ".skills.cultivatingLevel");
            int craftingLevel = config.getInt(id + ".skills.craftingLevel");
            int cookingLevel = config.getInt(id + ".skills.cookingLevel");
            int acrobaticsLevel = config.getInt(id + ".skills.acrobaticsLevel");
            int stealthLevel = config.getInt(id + ".skills.stealthLevel");
            int soldierLevel = config.getInt(id + ".skills.soldierLevel");
            int marauderLevel = config.getInt(id + ".skills.marauderLevel");
            int assassinLevel = config.getInt(id + ".skills.assassinLevel");
            int cavalierLevel = config.getInt(id + ".skills.cavalierLevel");
            int martialArtistLevel = config.getInt(id + ".skills.martialArtistLevel");
            int shieldHeroLevel = config.getInt(id + ".skills.shieldHeroLevel");
            int marksmanLevel = config.getInt(id + ".skills.marksmanLevel");
            int sorcererLevel = config.getInt(id + ".skills.sorcererLevel");
            int primordialLevel = config.getInt(id + ".skills.primordialLevel");
            int hallowedLevel = config.getInt(id + ".skills.hallowedLevel");
            int annulledLevel = config.getInt(id + ".skills.annulledLevel");

            double combatExp = config.getDouble(id + ".skills.combatExp");
            double foragingExp = config.getDouble(id + ".skills.foragingExp");
            double miningExp = config.getDouble(id + ".skills.miningExp");
            double fishingExp = config.getDouble(id + ".skills.fishingExp");
            double cultivatingExp = config.getDouble(id + ".skills.cultivatingExp");
            double craftingExp = config.getDouble(id + ".skills.craftingExp");
            double cookingExp = config.getDouble(id + ".skills.cookingExp");
            double acrobaticsExp = config.getDouble(id + ".skills.acrobaticsExp");
            double stealthExp = config.getDouble(id + ".skills.stealthExp");
            double soldierExp = config.getDouble(id + ".skills.soldierExp");
            double marauderExp = config.getDouble(id + ".skills.marauderExp");
            double assassinExp = config.getDouble(id + ".skills.assassinExp");
            double cavalierExp = config.getDouble(id + ".skills.cavalierExp");
            double martialArtistExp = config.getDouble(id + ".skills.martialArtistExp");
            double shieldHeroExp = config.getDouble(id + ".skills.shieldHeroExp");
            double marksmanExp = config.getDouble(id + ".skills.marksmanExp");
            double sorcererExp = config.getDouble(id + ".skills.sorcererExp");
            double primordialExp = config.getDouble(id + ".skills.primordialExp");
            double hallowedExp = config.getDouble(id + ".skills.hallowedExp");
            double annulledExp = config.getDouble(id + ".skills.annulledExp");

            int exp2LvlUpCombat = config.getInt(id + ".skills.exp2LvlUpCombat");
            int exp2LvlUpForaging = config.getInt(id + ".skills.exp2LvlUpForaging");
            int exp2LvlUpMining = config.getInt(id + ".skills.exp2LvlUpMining");
            int exp2LvlUpFishing = config.getInt(id + ".skills.exp2LvlUpFishing");
            int exp2LvlUpCultivating = config.getInt(id + ".skills.exp2LvlUpCultivating");
            int exp2LvlUpCrafting = config.getInt(id + ".skills.exp2LvlUpCrafting");
            int exp2LvlUpCooking = config.getInt(id + ".skills.exp2LvlUpCooking");
            int exp2LvlUpAcrobatics = config.getInt(id + ".skills.exp2LvlUpAcrobatics");
            int exp2LvlUpStealth = config.getInt(id + ".skills.exp2LvlUpStealth");
            int exp2LvlUpSoldier = config.getInt(id + ".skills.exp2LvlUpSoldier");
            int exp2LvlUpMarauder = config.getInt(id + ".skills.exp2LvlUpMarauder");
            int exp2LvlUpAssassin = config.getInt(id + ".skills.exp2LvlUpAssassin");
            int exp2LvlUpCavalier = config.getInt(id + ".skills.exp2LvlUpCavalier");
            int exp2LvlUpMartialArtist = config.getInt(id + ".skills.exp2LvlUpMartialArtist");
            int exp2LvlUpShieldHero = config.getInt(id + ".skills.exp2LvlUpShieldHero");
            int exp2LvlUpMarksman = config.getInt(id + ".skills.exp2LvlUpMarksman");
            int exp2LvlUpSorcerer = config.getInt(id + ".skills.exp2LvlUpSorcerer");
            int exp2LvlUpPrimordial = config.getInt(id + ".skills.exp2LvlUpPrimordial");
            int exp2LvlUpHallowed = config.getInt(id + ".skills.exp2LvlUpHallowed");
            int exp2LvlUpAnnulled = config.getInt(id + ".skills.exp2LvlUpAnnulled");

            Skills skills = new Skills(combatLevel, foragingLevel, miningLevel, fishingLevel, cultivatingLevel, craftingLevel, cookingLevel, acrobaticsLevel, stealthLevel,
                    soldierLevel, marauderLevel, assassinLevel, cavalierLevel, martialArtistLevel, shieldHeroLevel, marksmanLevel, sorcererLevel, primordialLevel,
                    hallowedLevel, annulledLevel,
                    combatExp, foragingExp, miningExp, fishingExp, cultivatingExp, craftingExp, cookingExp, acrobaticsExp, stealthExp,
                    soldierExp, marauderExp, assassinExp, cavalierExp, martialArtistExp, shieldHeroExp, marksmanExp, sorcererExp, primordialExp, hallowedExp, annulledExp);

            SkillSet skillSet = new SkillSet(skills);
            profileMap.put(uuid, skillSet);
        }
    }

    public void saveSkillsToConfig() {
        for (UUID uuid : profileMap.keySet()) {
            String id = uuid.toString();
            SkillSet skillSet = profileMap.get(uuid);
            Skills skills = skillSet.getSkills();

            config.set(id + ".skills.combatLevel", skills.getCombatLevel());
            config.set(id + ".skills.foragingLevel", skills.getForagingLevel());
            config.set(id + ".skills.miningLevel", skills.getMiningLevel());
            config.set(id + ".skills.fishingLevel", skills.getFishingLevel());
            config.set(id + ".skills.cultivatingLevel", skills.getCultivatingLevel());
            config.set(id + ".skills.craftingLevel", skills.getCraftingLevel());
            config.set(id + ".skills.cookingLevel", skills.getCookingLevel());
            config.set(id + ".skills.acrobaticsLevel", skills.getAcrobaticsLevel());
            config.set(id + ".skills.stealthLevel", skills.getStealthLevel());
            config.set(id + ".skills.soldierLevel", skills.getSoldierLevel());
            config.set(id + ".skills.marauderLevel", skills.getMarauderLevel());
            config.set(id + ".skills.assassinLevel", skills.getAssassinLevel());
            config.set(id + ".skills.cavalierLevel", skills.getCavalierLevel());
            config.set(id + ".skills.martialArtistLevel", skills.getMartialArtistLevel());
            config.set(id + ".skills.shieldHeroLevel", skills.getShieldHeroLevel());
            config.set(id + ".skills.marksmanLevel", skills.getMarksmanLevel());
            config.set(id + ".skills.sorcererLevel", skills.getSorcererLevel());
            config.set(id + ".skills.primordialLevel", skills.getPrimordialLevel());
            config.set(id + ".skills.hallowedLevel", skills.getHallowedLevel());
            config.set(id + ".skills.annulledLevel", skills.getAnnulledLevel());

            config.set(id + ".skills.combatExp", skills.getCombatExp());
            config.set(id + ".skills.foragingExp", skills.getForagingExp());
            config.set(id + ".skills.miningExp", skills.getMiningExp());
            config.set(id + ".skills.fishingExp", skills.getFishingExp());
            config.set(id + ".skills.cultivatingExp", skills.getCultivatingExp());
            config.set(id + ".skills.craftingExp", skills.getCraftingExp());
            config.set(id + ".skills.cookingExp", skills.getCookingExp());
            config.set(id + ".skills.acrobaticsExp", skills.getAcrobaticsExp());
            config.set(id + ".skills.stealthExp", skills.getStealthExp());
            config.set(id + ".skills.soldierExp", skills.getSoldierExp());
            config.set(id + ".skills.marauderExp", skills.getMarauderExp());
            config.set(id + ".skills.assassinExp", skills.getAssassinExp());
            config.set(id + ".skills.cavalierExp", skills.getCavalierExp());
            config.set(id + ".skills.martialArtistExp", skills.getMartialArtistExp());
            config.set(id + ".skills.shieldHeroExp", skills.getShieldHeroExp());
            config.set(id + ".skills.marksmanExp", skills.getMarksmanExp());
            config.set(id + ".skills.sorcererExp", skills.getSorcererExp());
            config.set(id + ".skills.primordialExp", skills.getPrimordialExp());
            config.set(id + ".skills.hallowedExp", skills.getHallowedExp());
            config.set(id + ".skills.annulledExp", skills.getAnnulledExp());

            config.set(id + ".skills.exp2LvlUpCombat", skills.getExp2LvlUpCombat());
            config.set(id + ".skills.exp2LvlUpForaging", skills.getExp2LvlUpForaging());
            config.set(id + ".skills.exp2LvlUpMining", skills.getExp2LvlUpMining());
            config.set(id + ".skills.exp2LvlUpFishing", skills.getExp2LvlUpFishing());
            config.set(id + ".skills.exp2LvlUpCultivating", skills.getExp2LvlUpCultivating());
            config.set(id + ".skills.exp2LvlUpCrafting", skills.getExp2LvlUpCrafting());
            config.set(id + ".skills.exp2LvlUpCooking", skills.getExp2LvlUpCooking());
            config.set(id + ".skills.exp2LvlUpAcrobatics", skills.getExp2LvlUpAcrobatics());
            config.set(id + ".skills.exp2LvlUpStealth", skills.getExp2LvlUpStealth());
            config.set(id + ".skills.exp2LvlUpSoldier", skills.getExp2LvlUpSoldier());
            config.set(id + ".skills.exp2LvlUpMarauder", skills.getExp2LvlUpMarauder());
            config.set(id + ".skills.exp2LvlUpAssassin", skills.getExp2LvlUpAssassin());
            config.set(id + ".skills.exp2LvlUpCavalier", skills.getExp2LvlUpCavalier());
            config.set(id + ".skills.exp2LvlUpMartialArtist", skills.getMartialArtistExp());
            config.set(id + ".skills.exp2LvlUpShieldHero", skills.getExp2LvlUpShieldHero());
            config.set(id + ".skills.exp2LvlUpMarksman", skills.getExp2LvlUpMarksman());
            config.set(id + ".skills.exp2LvlUpSorcerer", skills.getExp2LvlUpSorcerer());
            config.set(id + ".skills.exp2LvlUpPrimordial", skills.getExp2LvlUpPrimordial());
            config.set(id + ".skills.exp2LvlUpHallowed", skills.getExp2LvlUpHallowed());
            config.set(id + ".skills.exp2LvlUpAnnulled", skills.getExp2LvlUpAnnulled());
        }
    }

    public void saveASkillSetToConfig(Player player) {
        String id = player.getUniqueId().toString();
        SkillSet skillSet = profileMap.get(player.getUniqueId());
        Skills skills = skillSet.getSkills();

        config.set(id + ".skills.combatLevel", skills.getCombatLevel());
        config.set(id + ".skills.foragingLevel", skills.getForagingLevel());
        config.set(id + ".skills.miningLevel", skills.getMiningLevel());
        config.set(id + ".skills.fishingLevel", skills.getFishingLevel());
        config.set(id + ".skills.cultivatingLevel", skills.getCultivatingLevel());
        config.set(id + ".skills.craftingLevel", skills.getCraftingLevel());
        config.set(id + ".skills.cookingLevel", skills.getCookingLevel());
        config.set(id + ".skills.acrobaticsLevel", skills.getAcrobaticsLevel());
        config.set(id + ".skills.stealthLevel", skills.getStealthLevel());
        config.set(id + ".skills.soldierLevel", skills.getSoldierLevel());
        config.set(id + ".skills.marauderLevel", skills.getMarauderLevel());
        config.set(id + ".skills.assassinLevel", skills.getAssassinLevel());
        config.set(id + ".skills.cavalierLevel", skills.getCavalierLevel());
        config.set(id + ".skills.martialArtistLevel", skills.getMartialArtistLevel());
        config.set(id + ".skills.shieldHeroLevel", skills.getShieldHeroLevel());
        config.set(id + ".skills.marksmanLevel", skills.getMarksmanLevel());
        config.set(id + ".skills.sorcererLevel", skills.getSorcererLevel());
        config.set(id + ".skills.primordialLevel", skills.getPrimordialLevel());
        config.set(id + ".skills.hallowedLevel", skills.getHallowedLevel());
        config.set(id + ".skills.annulledLevel", skills.getAnnulledLevel());

        config.set(id + ".skills.combatExp", skills.getCombatExp());
        config.set(id + ".skills.foragingExp", skills.getForagingExp());
        config.set(id + ".skills.miningExp", skills.getMiningExp());
        config.set(id + ".skills.fishingExp", skills.getFishingExp());
        config.set(id + ".skills.cultivatingExp", skills.getCultivatingExp());
        config.set(id + ".skills.craftingExp", skills.getCraftingExp());
        config.set(id + ".skills.cookingExp", skills.getCookingExp());
        config.set(id + ".skills.acrobaticsExp", skills.getAcrobaticsExp());
        config.set(id + ".skills.stealthExp", skills.getStealthExp());
        config.set(id + ".skills.soldierExp", skills.getSoldierExp());
        config.set(id + ".skills.marauderExp", skills.getMarauderExp());
        config.set(id + ".skills.assassinExp", skills.getAssassinExp());
        config.set(id + ".skills.cavalierExp", skills.getCavalierExp());
        config.set(id + ".skills.martialArtistExp", skills.getMartialArtistExp());
        config.set(id + ".skills.shieldHeroExp", skills.getShieldHeroExp());
        config.set(id + ".skills.marksmanExp", skills.getMarksmanExp());
        config.set(id + ".skills.sorcererExp", skills.getSorcererExp());
        config.set(id + ".skills.primordialExp", skills.getPrimordialExp());
        config.set(id + ".skills.hallowedExp", skills.getHallowedExp());
        config.set(id + ".skills.annulledExp", skills.getAnnulledExp());

        config.set(id + ".skills.exp2LvlUpCombat", skills.getExp2LvlUpCombat());
        config.set(id + ".skills.exp2LvlUpForaging", skills.getExp2LvlUpForaging());
        config.set(id + ".skills.exp2LvlUpMining", skills.getExp2LvlUpMining());
        config.set(id + ".skills.exp2LvlUpFishing", skills.getExp2LvlUpFishing());
        config.set(id + ".skills.exp2LvlUpCultivating", skills.getExp2LvlUpCultivating());
        config.set(id + ".skills.exp2LvlUpCrafting", skills.getExp2LvlUpCrafting());
        config.set(id + ".skills.exp2LvlUpCooking", skills.getExp2LvlUpCooking());
        config.set(id + ".skills.exp2LvlUpAcrobatics", skills.getExp2LvlUpAcrobatics());
        config.set(id + ".skills.exp2LvlUpStealth", skills.getExp2LvlUpStealth());
        config.set(id + ".skills.exp2LvlUpSoldier", skills.getExp2LvlUpSoldier());
        config.set(id + ".skills.exp2LvlUpMarauder", skills.getExp2LvlUpMarauder());
        config.set(id + ".skills.exp2LvlUpAssassin", skills.getExp2LvlUpAssassin());
        config.set(id + ".skills.exp2LvlUpCavalier", skills.getExp2LvlUpCavalier());
        config.set(id + ".skills.exp2LvlUpMartialArtist", skills.getMartialArtistExp());
        config.set(id + ".skills.exp2LvlUpShieldHero", skills.getExp2LvlUpShieldHero());
        config.set(id + ".skills.exp2LvlUpMarksman", skills.getExp2LvlUpMarksman());
        config.set(id + ".skills.exp2LvlUpSorcerer", skills.getExp2LvlUpSorcerer());
        config.set(id + ".skills.exp2LvlUpPrimordial", skills.getExp2LvlUpPrimordial());
        config.set(id + ".skills.exp2LvlUpHallowed", skills.getExp2LvlUpHallowed());
        config.set(id + ".skills.exp2LvlUpAnnulled", skills.getExp2LvlUpAnnulled());
    }
}