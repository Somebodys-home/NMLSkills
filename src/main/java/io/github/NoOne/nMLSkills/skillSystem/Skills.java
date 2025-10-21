package io.github.NoOne.nMLSkills.skillSystem;

public class Skills {
    private int combatLevel;
    private int foragingLevel;
    private int miningLevel;
    private int fishingLevel;
    private int cultivatingLevel;
    private int craftingLevel;
    private int cookingLevel;
    private int acrobaticsLevel;
    private int stealthLevel;
    private int soldierLevel;
    private int marauderLevel;
    private int assassinLevel;
    private int cavalierLevel;
    private int martialArtistLevel;
    private int shieldHeroLevel;
    private int marksmanLevel;
    private int sorcererLevel;
    private int primordialLevel;
    private int hallowedLevel;
    private int annulledLevel;

    private double combatExp;
    private double foragingExp;
    private double miningExp;
    private double fishingExp;
    private double cultivatingExp;
    private double craftingExp;
    private double cookingExp;
    private double acrobaticsExp;
    private double stealthExp;
    private double soldierExp;
    private double marauderExp;
    private double assassinExp;
    private double cavalierExp;
    private double martialArtistExp;
    private double shieldHeroExp;
    private double marksmanExp;
    private double sorcererExp;
    private double primordialExp;
    private double hallowedExp;
    private double annulledExp;

    private int exp2LvlUpCombat;
    private int exp2LvlUpForaging;
    private int exp2LvlUpMining;
    private int exp2LvlUpFishing;
    private int exp2LvlUpCultivating;
    private int exp2LvlUpCrafting;
    private int exp2LvlUpCooking;
    private int exp2LvlUpAcrobatics;
    private int exp2LvlUpStealth;
    private int exp2LvlUpSoldier;
    private int exp2LvlUpMarauder;
    private int exp2LvlUpAssassin;
    private int exp2LvlUpCavalier;
    private int exp2LvlUpMartialArtist;
    private int exp2LvlUpShieldHero;
    private int exp2LvlUpMarksman;
    private int exp2LvlUpSorcerer;
    private int exp2LvlUpPrimordial;
    private int exp2LvlUpHallowed;
    private int exp2LvlUpAnnulled;

    public Skills(int combatLevel, int foragingLevel, int miningLevel, int fishingLevel, int cultivatingLevel, int craftingLevel, int cookingLevel, int acrobaticsLevel,
                  int stealthLevel,
                  int soldierLevel, int marauderLevel, int assassinLevel, int cavalierLevel, int martialArtistLevel, int shieldHeroLevel, int marksmanLevel,
                  int sorcererLevel, int primordialLevel, int hallowedLevel, int annulledLevel,
                  double combatExp, double foragingExp, double miningExp, double fishingExp, double cultivatingExp, double craftingExp, double cookingExp,
                  double acrobaticsExp, double stealthExp,
                  double soldierExp, double marauderExp, double assassinExp, double cavalierExp, double martialArtistExp, double shieldHeroExp, double marksmanExp,
                  double sorcererExp, double primordialExp, double hallowedExp, double annulledExp) {

        this.combatLevel = combatLevel;
        this.foragingLevel = foragingLevel;
        this.miningLevel = miningLevel;
        this.fishingLevel = fishingLevel;
        this.cultivatingLevel = cultivatingLevel;
        this.craftingLevel = craftingLevel;
        this.cookingLevel = cookingLevel;
        this.acrobaticsLevel = acrobaticsLevel;
        this.stealthLevel = stealthLevel;
        this.soldierLevel = soldierLevel;
        this.marauderLevel = marauderLevel;
        this.assassinLevel = assassinLevel;
        this.cavalierLevel = cavalierLevel;
        this.martialArtistLevel = martialArtistLevel;
        this.shieldHeroLevel = shieldHeroLevel;
        this.marksmanLevel = marksmanLevel;
        this.sorcererLevel = sorcererLevel;
        this.primordialLevel = primordialLevel;
        this.hallowedLevel = hallowedLevel;
        this.annulledLevel = annulledLevel;

        this.combatExp = combatExp;
        this.foragingExp = foragingExp;
        this.miningExp = miningExp;
        this.fishingExp = fishingExp;
        this.cultivatingExp = cultivatingExp;
        this.craftingExp = craftingExp;
        this.cookingExp = cookingExp;
        this.acrobaticsExp = acrobaticsExp;
        this.stealthExp = stealthExp;
        this.soldierExp = soldierExp;
        this.marauderExp = marauderExp;
        this.assassinExp = assassinExp;
        this.cavalierExp = cavalierExp;
        this.martialArtistExp = martialArtistExp;
        this.shieldHeroExp = shieldHeroExp;
        this.marksmanExp = marksmanExp;
        this.sorcererExp = sorcererExp;
        this.primordialExp = primordialExp;
        this.hallowedExp = hallowedExp;
        this.annulledExp = annulledExp;

        // todo: come up with a formula for this eventually
        this.exp2LvlUpCombat = 100;
        this.exp2LvlUpForaging = 100;
        this.exp2LvlUpMining = 100;
        this.exp2LvlUpFishing = 100;
        this.exp2LvlUpCultivating = 100;
        this.exp2LvlUpCrafting = 100;
        this.exp2LvlUpCooking = 100;
        this.exp2LvlUpAcrobatics = 100;
        this.exp2LvlUpStealth = 100;
        this.exp2LvlUpSoldier = 100;
        this.exp2LvlUpMarauder = 100;
        this.exp2LvlUpAssassin = 100;
        this.exp2LvlUpCavalier = 100;
        this.exp2LvlUpMartialArtist = 100;
        this.exp2LvlUpShieldHero = 100;
        this.exp2LvlUpMarksman = 100;
        this.exp2LvlUpSorcerer = 100;
        this.exp2LvlUpPrimordial = 100;
        this.exp2LvlUpHallowed = 100;
        this.exp2LvlUpAnnulled = 100;
    }

    public static Skills generateNewbieSkills() {
        return new Skills(1, 1, 1, 1, 1, 1, 1, 1, 1,
                        1, 1, 1, 1, 1, 1, 1, 1, 1,
                        1, 1, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0);
    }

    public void add2Skill(String skill, double amount) {
        switch (skill.toLowerCase()) {
            case "combatlvl" -> combatLevel += (int) amount;
            case "foraginglvl" -> foragingLevel += (int) amount;
            case "mininglvl" -> miningLevel += (int) amount;
            case "fishinglvl" -> fishingLevel += (int) amount;
            case "cultivatinglvl" -> cultivatingLevel += (int) amount;
            case "craftinglvl" -> craftingLevel += (int) amount;
            case "cookinglvl" -> cookingLevel += (int) amount;
            case "acrobaticslvl" -> acrobaticsLevel += (int) amount;
            case "stealthlvl" -> stealthLevel += (int) amount;
            case "soldierlvl" -> soldierLevel += (int) amount;
            case "marauderlvl" -> marauderLevel += (int) amount;
            case "assassinlvl" -> assassinLevel += (int) amount;
            case "cavalierlvl" -> cavalierLevel += (int) amount;
            case "martialartistlvl" -> martialArtistLevel += (int) amount;
            case "shieldherolvl" -> shieldHeroLevel += (int) amount;
            case "marksmanlvl" -> marksmanLevel += (int) amount;
            case "sorcererlvl" -> sorcererLevel += (int) amount;
            case "primordiallvl" -> primordialLevel += (int) amount;
            case "hallowedlvl" -> hallowedLevel += (int) amount;
            case "annulledlvl" -> annulledLevel += (int) amount;

            case "combatexp" -> combatExp += amount;
            case "foragingexp" -> foragingExp += amount;
            case "miningexp" -> miningExp += amount;
            case "fishingexp" -> fishingExp += amount;
            case "cultivatingexp" -> cultivatingExp += amount;
            case "craftingexp" -> craftingExp += amount;
            case "cookingexp" -> cookingExp += amount;
            case "acrobaticsexp" -> acrobaticsExp += amount;
            case "stealthexp" -> stealthExp += amount;
            case "soldierexp" -> soldierExp += amount;
            case "marauderexp" -> marauderExp += amount;
            case "assassinexp" -> assassinExp += amount;
            case "cavalierexp" -> cavalierExp += amount;
            case "martialartistexp" -> martialArtistExp += amount;
            case "shieldheroexp" -> shieldHeroExp += amount;
            case "marksmanexp" -> marksmanExp += amount;
            case "sorcererexp" -> sorcererExp += amount;
            case "primordialexp" -> primordialExp += amount;
            case "hallowedexp" -> hallowedExp += amount;
            case "annulledexp" -> annulledExp += amount;
        }
    }

    public void removeFromSkill(String skill, double amount) {
        switch (skill.toLowerCase()) {
            case "combatlvl" -> combatLevel -= (int) amount;
            case "foraginglvl" -> foragingLevel -= (int) amount;
            case "mininglvl" -> miningLevel -= (int) amount;
            case "fishinglvl" -> fishingLevel -= (int) amount;
            case "cultivatinglvl" -> cultivatingLevel -= (int) amount;
            case "craftinglvl" -> craftingLevel -= (int) amount;
            case "cookinglvl" -> cookingLevel -= (int) amount;
            case "acrobaticslvl" -> acrobaticsLevel -= (int) amount;
            case "stealthlvl" -> stealthLevel -= (int) amount;
            case "soldierlvl" -> soldierLevel -= (int) amount;
            case "marauderlvl" -> marauderLevel -= (int) amount;
            case "assassinlvl" -> assassinLevel -= (int) amount;
            case "cavalierlvl" -> cavalierLevel -= (int) amount;
            case "martialartistlvl" -> martialArtistLevel -= (int) amount;
            case "shieldherolvl" -> shieldHeroLevel -= (int) amount;
            case "marksmanlvl" -> marksmanLevel -= (int) amount;
            case "sorcererlvl" -> sorcererLevel -= (int) amount;
            case "primordiallvl" -> primordialLevel -= (int) amount;
            case "hallowedlvl" -> hallowedLevel -= (int) amount;
            case "annulledlvl" -> annulledLevel -= (int) amount;

            case "combatexp" -> combatExp -= amount;
            case "foragingexp" -> foragingExp -= amount;
            case "miningexp" -> miningExp -= amount;
            case "fishingexp" -> fishingExp -= amount;
            case "cultivatingexp" -> cultivatingExp -= amount;
            case "craftingexp" -> craftingExp -= amount;
            case "cookingexp" -> cookingExp -= amount;
            case "acrobaticsexp" -> acrobaticsExp -= amount;
            case "stealthexp" -> stealthExp -= amount;
            case "soldierexp" -> soldierExp -= amount;
            case "marauderexp" -> marauderExp -= amount;
            case "assassinexp" -> assassinExp -= amount;
            case "cavalierexp" -> cavalierExp -= amount;
            case "martialartistexp" -> martialArtistExp -= amount;
            case "shieldheroexp" -> shieldHeroExp -= amount;
            case "marksmanexp" -> marksmanExp -= amount;
            case "sorcererexp" -> sorcererExp -= amount;
            case "primordialexp" -> primordialExp -= amount;
            case "hallowedexp" -> hallowedExp -= amount;
            case "annulledexp" -> annulledExp -= amount;
        }
    }

    public int getCombatLevel() {
        return combatLevel;
    }

    public void setCombatLevel(int combatLevel) {
        this.combatLevel = combatLevel;
    }

    public int getMiningLevel() {
        return miningLevel;
    }

    public void setMiningLevel(int miningLevel) {
        this.miningLevel = miningLevel;
    }

    public int getForagingLevel() {
        return foragingLevel;
    }

    public void setForagingLevel(int foragingLevel) {
        this.foragingLevel = foragingLevel;
    }

    public int getFishingLevel() {
        return fishingLevel;
    }

    public void setFishingLevel(int fishingLevel) {
        this.fishingLevel = fishingLevel;
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

    public int getCookingLevel() {
        return cookingLevel;
    }

    public void setCookingLevel(int cookingLevel) {
        this.cookingLevel = cookingLevel;
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

    public double getCombatExp() {
        return combatExp;
    }

    public void setCombatExp(double combatExp) {
        this.combatExp = combatExp;
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

    public int getExp2LvlUpCombat() {
        return exp2LvlUpCombat;
    }

    public void setExp2LvlUpCombat(int exp2LvlUpCombat) {
        this.exp2LvlUpCombat = exp2LvlUpCombat;
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

    public int getSoldierLevel() {
        return soldierLevel;
    }

    public void setSoldierLevel(int soldierLevel) {
        this.soldierLevel = soldierLevel;
    }

    public int getMarauderLevel() {
        return marauderLevel;
    }

    public void setMarauderLevel(int marauderLevel) {
        this.marauderLevel = marauderLevel;
    }

    public int getAssassinLevel() {
        return assassinLevel;
    }

    public void setAssassinLevel(int assassinLevel) {
        this.assassinLevel = assassinLevel;
    }

    public int getCavalierLevel() {
        return cavalierLevel;
    }

    public void setCavalierLevel(int cavalierLevel) {
        this.cavalierLevel = cavalierLevel;
    }

    public int getMartialArtistLevel() {
        return martialArtistLevel;
    }

    public void setMartialArtistLevel(int martialArtistLevel) {
        this.martialArtistLevel = martialArtistLevel;
    }

    public int getMarksmanLevel() {
        return marksmanLevel;
    }

    public void setMarksmanLevel(int marksmanLevel) {
        this.marksmanLevel = marksmanLevel;
    }

    public int getPrimordialLevel() {
        return primordialLevel;
    }

    public void setPrimordialLevel(int primordialLevel) {
        this.primordialLevel = primordialLevel;
    }

    public int getHallowedLevel() {
        return hallowedLevel;
    }

    public void setHallowedLevel(int hallowedLevel) {
        this.hallowedLevel = hallowedLevel;
    }

    public int getShieldHeroLevel() {
        return shieldHeroLevel;
    }

    public void setShieldHeroLevel(int shieldHeroLevel) {
        this.shieldHeroLevel = shieldHeroLevel;
    }

    public int getSorcererLevel() {
        return sorcererLevel;
    }

    public void setSorcererLevel(int sorcererLevel) {
        this.sorcererLevel = sorcererLevel;
    }

    public int getAnnulledLevel() {
        return annulledLevel;
    }

    public void setAnnulledLevel(int annulledLevel) {
        this.annulledLevel = annulledLevel;
    }

    public double getSoldierExp() {
        return soldierExp;
    }

    public void setSoldierExp(double soldierExp) {
        this.soldierExp = soldierExp;
    }

    public double getMarauderExp() {
        return marauderExp;
    }

    public void setMarauderExp(double marauderExp) {
        this.marauderExp = marauderExp;
    }

    public double getAssassinExp() {
        return assassinExp;
    }

    public void setAssassinExp(double assassinExp) {
        this.assassinExp = assassinExp;
    }

    public double getCavalierExp() {
        return cavalierExp;
    }

    public void setCavalierExp(double cavalierExp) {
        this.cavalierExp = cavalierExp;
    }

    public double getMartialArtistExp() {
        return martialArtistExp;
    }

    public void setMartialArtistExp(double martialArtistExp) {
        this.martialArtistExp = martialArtistExp;
    }

    public double getMarksmanExp() {
        return marksmanExp;
    }

    public void setMarksmanExp(double marksmanExp) {
        this.marksmanExp = marksmanExp;
    }

    public double getShieldHeroExp() {
        return shieldHeroExp;
    }

    public void setShieldHeroExp(double shieldHeroExp) {
        this.shieldHeroExp = shieldHeroExp;
    }

    public double getSorcererExp() {
        return sorcererExp;
    }

    public void setSorcererExp(double sorcererExp) {
        this.sorcererExp = sorcererExp;
    }

    public double getPrimordialExp() {
        return primordialExp;
    }

    public void setPrimordialExp(double primordialExp) {
        this.primordialExp = primordialExp;
    }

    public double getHallowedExp() {
        return hallowedExp;
    }

    public void setHallowedExp(double hallowedExp) {
        this.hallowedExp = hallowedExp;
    }

    public double getAnnulledExp() {
        return annulledExp;
    }

    public void setAnnulledExp(double annulledExp) {
        this.annulledExp = annulledExp;
    }

    public int getExp2LvlUpSoldier() {
        return exp2LvlUpSoldier;
    }

    public void setExp2LvlUpSoldier(int exp2LvlUpSoldier) {
        this.exp2LvlUpSoldier = exp2LvlUpSoldier;
    }

    public int getExp2LvlUpMarauder() {
        return exp2LvlUpMarauder;
    }

    public void setExp2LvlUpMarauder(int exp2LvlUpMarauder) {
        this.exp2LvlUpMarauder = exp2LvlUpMarauder;
    }

    public int getExp2LvlUpAssassin() {
        return exp2LvlUpAssassin;
    }

    public void setExp2LvlUpAssassin(int exp2LvlUpAssassin) {
        this.exp2LvlUpAssassin = exp2LvlUpAssassin;
    }

    public int getExp2LvlUpCavalier() {
        return exp2LvlUpCavalier;
    }

    public void setExp2LvlUpCavalier(int exp2LvlUpCavalier) {
        this.exp2LvlUpCavalier = exp2LvlUpCavalier;
    }

    public int getExp2LvlUpMartialArtist() {
        return exp2LvlUpMartialArtist;
    }

    public void setExp2LvlUpMartialArtist(int exp2LvlUpMartialArtist) {
        this.exp2LvlUpMartialArtist = exp2LvlUpMartialArtist;
    }

    public int getExp2LvlUpShieldHero() {
        return exp2LvlUpShieldHero;
    }

    public void setExp2LvlUpShieldHero(int exp2LvlUpShieldHero) {
        this.exp2LvlUpShieldHero = exp2LvlUpShieldHero;
    }

    public int getExp2LvlUpMarksman() {
        return exp2LvlUpMarksman;
    }

    public void setExp2LvlUpMarksman(int exp2LvlUpMarksman) {
        this.exp2LvlUpMarksman = exp2LvlUpMarksman;
    }

    public int getExp2LvlUpSorcerer() {
        return exp2LvlUpSorcerer;
    }

    public void setExp2LvlUpSorcerer(int exp2LvlUpSorcerer) {
        this.exp2LvlUpSorcerer = exp2LvlUpSorcerer;
    }

    public int getExp2LvlUpHallowed() {
        return exp2LvlUpHallowed;
    }

    public void setExp2LvlUpHallowed(int exp2LvlUpHallowed) {
        this.exp2LvlUpHallowed = exp2LvlUpHallowed;
    }

    public int getExp2LvlUpAnnulled() {
        return exp2LvlUpAnnulled;
    }

    public void setExp2LvlUpAnnulled(int exp2LvlUpAnnulled) {
        this.exp2LvlUpAnnulled = exp2LvlUpAnnulled;
    }

    public int getExp2LvlUpPrimordial() {
        return exp2LvlUpPrimordial;
    }

    public void setExp2LvlUpPrimordial(int exp2LvlUpPrimordial) {
        this.exp2LvlUpPrimordial = exp2LvlUpPrimordial;
    }
}