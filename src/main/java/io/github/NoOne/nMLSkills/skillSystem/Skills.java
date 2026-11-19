package io.github.NoOne.nMLSkills.skillSystem;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Skills {
    private LinkedHashMap<Skill, Integer> skillLevels;
    private LinkedHashMap<Skill, Integer> skillExps;

    public Skills(int combatLevel, int foragingLevel, int miningLevel, int fishingLevel, int farmingLevel, int craftingLevel, int cookingLevel, int acrobaticsLevel,
                  int stealthLevel,
                  int soldierLevel, int marauderLevel, int assassinLevel, int cavalierLevel, int martialArtistLevel, int shieldHeroLevel, int marksmanLevel,
                  int sorcererLevel, int primordialLevel, int hallowedLevel, int annulledLevel,
                  int combatExp, int foragingExp, int miningExp, int fishingExp, int farmingExp, int craftingExp, int cookingExp,
                  int acrobaticsExp, int stealthExp,
                  int soldierExp, int marauderExp, int assassinExp, int cavalierExp, int martialArtistExp, int shieldHeroExp, int marksmanExp,
                  int sorcererExp, int primordialExp, int hallowedExp, int annulledExp) {

        skillLevels = new LinkedHashMap<>(){{
            put(Skill.COMBAT, combatLevel);
            put(Skill.FORAGING, foragingLevel);
            put(Skill.MINING, miningLevel);
            put(Skill.FISHING, fishingLevel);
            put(Skill.FARMING, farmingLevel);
            put(Skill.CRAFTING, craftingLevel);
            put(Skill.COOKING, cookingLevel);
            put(Skill.ACROBATICS, acrobaticsLevel);
            put(Skill.STEALTH, stealthLevel);
            put(Skill.SOLDIER, soldierLevel);
            put(Skill.MARAUDER, marauderLevel);
            put(Skill.ASSASSIN, assassinLevel);
            put(Skill.CAVALIER, cavalierLevel);
            put(Skill.MARTIAL_ARTIST, martialArtistLevel);
            put(Skill.SHIELD_HERO, shieldHeroLevel);
            put(Skill.MARKSMAN, marksmanLevel);
            put(Skill.SORCERER, sorcererLevel);
            put(Skill.PRIMORDIAL, primordialLevel);
            put(Skill.HALLOWED, hallowedLevel);
            put(Skill.ANNULLED, annulledLevel);
        }};

        skillExps = new LinkedHashMap<>(){{
            put(Skill.COMBAT, combatExp);
            put(Skill.FORAGING, foragingExp);
            put(Skill.MINING, miningExp);
            put(Skill.FISHING, fishingExp);
            put(Skill.FARMING, farmingExp);
            put(Skill.CRAFTING, craftingExp);
            put(Skill.COOKING, cookingExp);
            put(Skill.ACROBATICS, acrobaticsExp);
            put(Skill.STEALTH, stealthExp);
            put(Skill.SOLDIER, soldierExp);
            put(Skill.MARAUDER, marauderExp);
            put(Skill.ASSASSIN, assassinExp);
            put(Skill.CAVALIER, cavalierExp);
            put(Skill.MARTIAL_ARTIST, martialArtistExp);
            put(Skill.SHIELD_HERO, shieldHeroExp);
            put(Skill.MARKSMAN, marksmanExp);
            put(Skill.SORCERER, sorcererExp);
            put(Skill.PRIMORDIAL, primordialExp);
            put(Skill.HALLOWED, hallowedExp);
            put(Skill.ANNULLED, annulledExp);
        }};
    }

    public Skills(LinkedHashMap<Skill, Integer> skillLevels, LinkedHashMap<Skill, Integer> skillExps) {
        this.skillLevels = skillLevels;
        this.skillExps = skillExps;
    }

    public static Skills generateNewbieSkills() {
        return new Skills(1, 1, 1, 1, 1, 1, 1, 1, 1,
                        1, 1, 1, 1, 1, 1, 1, 1, 1,
                        1, 1, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0);
    }

    public void addToSkillLevel(Skill skill, int amount) {
        skillLevels.replace(skill, skillLevels.get(skill) + amount);
    }

    public void addToSkillLevels(Map<Skill, Integer> skills) {
        for (Map.Entry<Skill, Integer> entry : skills.entrySet()) {
            addToSkillLevel(entry.getKey(), entry.getValue());
        }
    }

    public void removeFromSkillLevel(Skill skill, int amount) {
        skillLevels.replace(skill, skillLevels.get(skill) - amount);
    }

    public void removeFromSkillLevels(Map<Skill, Integer> skills) {
        for (Map.Entry<Skill, Integer> entry : skills.entrySet()) {
            removeFromSkillLevel(entry.getKey(), entry.getValue());
        }
    }

    public void addToSkillExp(Skill skill, int amount) {
        skillExps.replace(skill, skillExps.get(skill) + amount);
    }

    public void addToSkillExps(Map<Skill, Integer> skills) {
        for (Map.Entry<Skill, Integer> entry : skills.entrySet()) {
            addToSkillExp(entry.getKey(), entry.getValue());
        }
    }

    public void removeFromSkillExp(Skill skill, int amount) {
        skillExps.replace(skill, skillExps.get(skill) - amount);
    }

    public void removeFromSkillExps(Map<Skill, Integer> skills) {
        for (Map.Entry<Skill, Integer> entry : skills.entrySet()) {
            removeFromSkillExp(entry.getKey(), entry.getValue());
        }
    }

    public int getSkillLevel(Skill skill) {
        return skillLevels.get(skill);
    }

    // todo: come up with a formula for this eventually
    public int calculateExpToLvlUpSkill(Skill skill) {
        return 100;
    }

    public int getSkillExp(Skill skill) {
        return skillExps.get(skill);
    }

    // returns the progress percent that the player is for leveling up for given skill (0 -> 1)
    public int calculateExpPercent(Skill skill) {
        return skillExps.get(skill) / calculateExpToLvlUpSkill(skill);
    }

    public HashMap<Skill, Integer> getExpertiseSkills() {
        return new HashMap<>(){{
            for (Skill skill : Skill.getExpertiseSkills()) {
                put(skill, getSkillLevel(skill));
            }
        }};
    }

    public LinkedHashMap<Skill, Integer> getSkillLevels() {
        return skillLevels;
    }

    public LinkedHashMap<Skill, Integer> getSkillExps() {
        return skillExps;
    }
}