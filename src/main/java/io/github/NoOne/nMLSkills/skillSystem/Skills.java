package io.github.NoOne.nMLSkills.skillSystem;

public class Skills {
    private int foragingLevel;
    private int miningLevel;
    private int fishingLevel;
    private int cultivatingLevel;
    private int craftingLevel;
    private int cookingLevel;
    private int acrobaticsLevel;
    private int stealthLevel;

    private double foragingExp;
    private double miningExp;
    private double fishingExp;
    private double cultivatingExp;
    private double craftingExp;
    private double cookingExp;
    private double acrobaticsExp;
    private double stealthExp;

    private int exp2LvlUpForaging;
    private int exp2LvlUpMining;
    private int exp2LvlUpFishing;
    private int exp2LvlUpCultivating;
    private int exp2LvlUpCrafting;
    private int exp2LvlUpCooking;
    private int exp2LvlUpAcrobatics;
    private int exp2LvlUpStealth;

    public Skills(int foragingLevel, int miningLevel, int fishingLevel, int cultivatingLevel, int craftingLevel, int cookingLevel, int acrobaticsLevel, int stealthLevel,
                  double foragingExp, double miningExp, double fishingExp, double cultivatingExp, double craftingExp, double cookingExp, double acrobaticsExp,
                  double stealthExp) {

        this.foragingLevel = foragingLevel;
        this.miningLevel = miningLevel;
        this.fishingLevel = fishingLevel;
        this.cultivatingLevel = cultivatingLevel;
        this.craftingLevel = craftingLevel;
        this.cookingLevel = cookingLevel;
        this.acrobaticsLevel = acrobaticsLevel;
        this.stealthLevel = stealthLevel;
        this.foragingExp = foragingExp;
        this.miningExp = miningExp;
        this.fishingExp = fishingExp;
        this.cultivatingExp = cultivatingExp;
        this.craftingExp = craftingExp;
        this.cookingExp = cookingExp;
        this.acrobaticsExp = acrobaticsExp;
        this.stealthExp = stealthExp;

        // todo: come up with a formula for this eventually
        this.exp2LvlUpForaging = 100;
        this.exp2LvlUpMining = 100;
        this.exp2LvlUpFishing = 100;
        this.exp2LvlUpCultivating = 100;
        this.exp2LvlUpCrafting = 100;
        this.exp2LvlUpCooking = 100;
        this.exp2LvlUpAcrobatics = 100;
        this.exp2LvlUpStealth = 100;
    }

    public static Skills generateNewbieSkills() {
        return new Skills(1, 1, 1, 1, 1, 1, 1, 1,
                        0, 0, 0, 0, 0, 0, 0, 0);
    }

    public void add2Skill(String skill, double amount) {
        switch (skill.toLowerCase()) {
            case "foraginglvl" -> foragingLevel += (int) amount;
            case "mininglvl" -> miningLevel += (int) amount;
            case "fishinglvl" -> fishingLevel += (int) amount;
            case "cultivatinglvl" -> cultivatingLevel += (int) amount;
            case "craftinglvl" -> craftingLevel += (int) amount;
            case "cookinglvl" -> cookingLevel += (int) amount;
            case "acrobaticslvl" -> acrobaticsLevel += (int) amount;
            case "stealthlvl" -> stealthLevel += (int) amount;

            case "foragingexp" -> foragingExp += amount;
            case "miningexp" -> miningExp += amount;
            case "fishingexp" -> fishingExp += amount;
            case "cultivatingexp" -> cultivatingExp += amount;
            case "craftingexp" -> craftingExp += amount;
            case "cookingexp" -> cookingExp += amount;
            case "acrobaticsexp" -> acrobaticsExp += amount;
            case "stealthexp" -> stealthExp += amount;
        }
    }

    public void removeFromSkill(String skill, double amount) {
        switch (skill.toLowerCase()) {
            case "foraginglvl" -> foragingLevel -= (int) amount;
            case "mininglvl" -> miningLevel -= (int) amount;
            case "fishinglvl" -> fishingLevel -= (int) amount;
            case "cultivatinglvl" -> cultivatingLevel -= (int) amount;
            case "craftinglvl" -> craftingLevel -= (int) amount;
            case "cookinglvl" -> cookingLevel -= (int) amount;
            case "acrobaticslvl" -> acrobaticsLevel -= (int) amount;
            case "stealthlvl" -> stealthLevel -= (int) amount;

            case "foragingexp" -> foragingExp -= amount;
            case "miningexp" -> miningExp -= amount;
            case "fishingexp" -> fishingExp -= amount;
            case "cultivatingexp" -> cultivatingExp -= amount;
            case "craftingexp" -> craftingExp -= amount;
            case "cookingexp" -> cookingExp -= amount;
            case "acrobaticsexp" -> acrobaticsExp -= amount;
            case "stealthexp" -> stealthExp -= amount;
        }
    }

    public int getForagingLevel() {
        return foragingLevel;
    }

    public void setForagingLevel(int foragingLevel) {
        this.foragingLevel = foragingLevel;
    }

    public int getMiningLevel() {
        return miningLevel;
    }

    public void setMiningLevel(int miningLevel) {
        this.miningLevel = miningLevel;
    }

    public int getFishingLevel() {
        return fishingLevel;
    }

    public void setFishingLevel(int fishingLevel) {
        this.fishingLevel = fishingLevel;
    }

    public int getCookingLevel() {
        return cookingLevel;
    }

    public void setCookingLevel(int cookingLevel) {
        this.cookingLevel = cookingLevel;
    }

    public int getCultivatingLevel() {
        return cultivatingLevel;
    }

    public void setCultivatingLevel(int cultivatingLevel) {
        this.cultivatingLevel = cultivatingLevel;
    }

    public int getCraftingLevel() {
        return craftingLevel;
    }

    public void setCraftingLevel(int craftingLevel) {
        this.craftingLevel = craftingLevel;
    }

    public int getAcrobaticsLevel() {
        return acrobaticsLevel;
    }

    public void setAcrobaticsLevel(int acrobaticsLevel) {
        this.acrobaticsLevel = acrobaticsLevel;
    }

    public int getStealthLevel() {
        return stealthLevel;
    }

    public void setStealthLevel(int stealthLevel) {
        this.stealthLevel = stealthLevel;
    }

    public double getForagingExp() {
        return foragingExp;
    }

    public void setForagingExp(double foragingExp) {
        this.foragingExp = foragingExp;
    }

    public double getMiningExp() {
        return miningExp;
    }

    public void setMiningExp(double miningExp) {
        this.miningExp = miningExp;
    }

    public double getFishingExp() {
        return fishingExp;
    }

    public void setFishingExp(double fishingExp) {
        this.fishingExp = fishingExp;
    }

    public double getCultivatingExp() {
        return cultivatingExp;
    }

    public void setCultivatingExp(double cultivatingExp) {
        this.cultivatingExp = cultivatingExp;
    }

    public double getCraftingExp() {
        return craftingExp;
    }

    public void setCraftingExp(double craftingExp) {
        this.craftingExp = craftingExp;
    }

    public double getCookingExp() {
        return cookingExp;
    }

    public void setCookingExp(double cookingExp) {
        this.cookingExp = cookingExp;
    }

    public double getAcrobaticsExp() {
        return acrobaticsExp;
    }

    public void setAcrobaticsExp(double acrobaticsExp) {
        this.acrobaticsExp = acrobaticsExp;
    }

    public double getStealthExp() {
        return stealthExp;
    }

    public void setStealthExp(double stealthExp) {
        this.stealthExp = stealthExp;
    }

    public int getExp2LvlUpForaging() {
        return exp2LvlUpForaging;
    }

    public void setExp2LvlUpForaging(int exp2LvlUpForaging) {
        this.exp2LvlUpForaging = exp2LvlUpForaging;
    }

    public int getExp2LvlUpMining() {
        return exp2LvlUpMining;
    }

    public void setExp2LvlUpMining(int exp2LvlUpMining) {
        this.exp2LvlUpMining = exp2LvlUpMining;
    }

    public int getExp2LvlUpFishing() {
        return exp2LvlUpFishing;
    }

    public void setExp2LvlUpFishing(int exp2LvlUpFishing) {
        this.exp2LvlUpFishing = exp2LvlUpFishing;
    }

    public int getExp2LvlUpCultivating() {
        return exp2LvlUpCultivating;
    }

    public void setExp2LvlUpCultivating(int exp2LvlUpCultivating) {
        this.exp2LvlUpCultivating = exp2LvlUpCultivating;
    }

    public int getExp2LvlUpCrafting() {
        return exp2LvlUpCrafting;
    }

    public void setExp2LvlUpCrafting(int exp2LvlUpCrafting) {
        this.exp2LvlUpCrafting = exp2LvlUpCrafting;
    }

    public int getExp2LvlUpCooking() {
        return exp2LvlUpCooking;
    }

    public void setExp2LvlUpCooking(int exp2LvlUpCooking) {
        this.exp2LvlUpCooking = exp2LvlUpCooking;
    }

    public int getExp2LvlUpAcrobatics() {
        return exp2LvlUpAcrobatics;
    }

    public void setExp2LvlUpAcrobatics(int exp2LvlUpAcrobatics) {
        this.exp2LvlUpAcrobatics = exp2LvlUpAcrobatics;
    }

    public int getExp2LvlUpStealth() {
        return exp2LvlUpStealth;
    }

    public void setExp2LvlUpStealth(int exp2LvlUpStealth) {
        this.exp2LvlUpStealth = exp2LvlUpStealth;
    }
}