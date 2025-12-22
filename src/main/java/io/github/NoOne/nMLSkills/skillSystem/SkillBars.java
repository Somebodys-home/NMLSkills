package io.github.NoOne.nMLSkills.skillSystem;

import io.github.NoOne.nMLSkills.NMLSkills;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.UUID;

public class SkillBars {
    private static NMLSkills nmlSkills;
    private BukkitTask skillBarsTask;
    private static HashMap<UUID, BossBar[]> skillBars = new HashMap<>();

    public SkillBars(NMLSkills nmlSkills) {
        this.nmlSkills = nmlSkills;
    }

    public void start() {
        skillBarsTask = Bukkit.getScheduler().runTaskTimer(nmlSkills, () -> {
            for (Player player : Bukkit.getOnlinePlayers()) {
                UUID uuid = player.getUniqueId();

                if (!skillBars.containsKey(uuid)) {
                    Skills skills = nmlSkills.getSkillSetManager().getSkillSet(uuid).getSkills();
                    BossBar foragingBar = Bukkit.createBossBar("Lvl. §b" + skills.getForagingLevel() + "§r Foraging" , BarColor.WHITE, BarStyle.SOLID);
                    BossBar miningBar = Bukkit.createBossBar("Lvl. §b" + skills.getMiningLevel() + "§r Mining" , BarColor.WHITE, BarStyle.SOLID);
                    BossBar fishingBar = Bukkit.createBossBar("Lvl. §b" + skills.getFishingLevel() + "§r Fishing" , BarColor.WHITE, BarStyle.SOLID);
                    BossBar farmingBar = Bukkit.createBossBar("Lvl. §b" + skills.getFarmingLevel() + "§r Farming" , BarColor.WHITE, BarStyle.SOLID);
                    BossBar craftingBar = Bukkit.createBossBar("Lvl. §b" + skills.getCraftingLevel() + "§r Crafting" , BarColor.WHITE, BarStyle.SOLID);
                    BossBar cookingBar = Bukkit.createBossBar("Lvl. §b" + skills.getCookingLevel() + "§r Cooking" , BarColor.WHITE, BarStyle.SOLID);
                    BossBar acrobaticsBar = Bukkit.createBossBar("Lvl. §b" + skills.getAcrobaticsLevel() + "§r Acrobatics" , BarColor.WHITE, BarStyle.SOLID);
                    BossBar stealthBar = Bukkit.createBossBar("Lvl. §b" + skills.getStealthLevel() + "§r Stealth" , BarColor.WHITE, BarStyle.SOLID);
                    BossBar soldierBar = Bukkit.createBossBar("Lvl. §b" + skills.getSoldierLevel() + "§r Soldier" , BarColor.WHITE, BarStyle.SOLID);
                    BossBar marauderBar = Bukkit.createBossBar("Lvl. §b" + skills.getMarauderLevel() + "§r Marauder" , BarColor.WHITE, BarStyle.SOLID);
                    BossBar assassinBar = Bukkit.createBossBar("Lvl. §b" + skills.getAssassinLevel() + "§r Assassin" , BarColor.WHITE, BarStyle.SOLID);
                    BossBar cavalierBar = Bukkit.createBossBar("Lvl. §b" + skills.getCavalierLevel() + "§r Cavalier" , BarColor.WHITE, BarStyle.SOLID);
                    BossBar martialArtistBar = Bukkit.createBossBar("Lvl. §b" + skills.getMartialArtistLevel() + "§r Martial Artist" , BarColor.WHITE, BarStyle.SOLID);
                    BossBar shieldHeroBar = Bukkit.createBossBar("Lvl. §b" + skills.getShieldHeroLevel() + "§r Shield Hero" , BarColor.WHITE, BarStyle.SOLID);
                    BossBar marksmanBar = Bukkit.createBossBar("Lvl. §b" + skills.getMarksmanLevel() + "§r Marksman" , BarColor.WHITE, BarStyle.SOLID);
                    BossBar sorcererBar = Bukkit.createBossBar("Lvl. §b" + skills.getSorcererLevel() + "§r Sorcerer" , BarColor.WHITE, BarStyle.SOLID);
                    BossBar primordialBar = Bukkit.createBossBar("Lvl. §b" + skills.getPrimordialLevel() + "§r Primordial" , BarColor.WHITE, BarStyle.SOLID);
                    BossBar hallowedBar = Bukkit.createBossBar("Lvl. §b" + skills.getHallowedLevel() + "§r Hallowed" , BarColor.WHITE, BarStyle.SOLID);
                    BossBar annulledBar = Bukkit.createBossBar("Lvl. §b" + skills.getAnnulledLevel() + "§r Annulled" , BarColor.WHITE, BarStyle.SOLID);

                    foragingBar.setProgress(getSkillBarProgress(player, "foraging"));
                    miningBar.setProgress(getSkillBarProgress(player, "mining"));
                    fishingBar.setProgress(getSkillBarProgress(player, "fishing"));
                    farmingBar.setProgress(getSkillBarProgress(player, "farming"));
                    craftingBar.setProgress(getSkillBarProgress(player, "crafting"));
                    cookingBar.setProgress(getSkillBarProgress(player, "cooking"));
                    acrobaticsBar.setProgress(getSkillBarProgress(player, "acrobatics"));
                    stealthBar.setProgress(getSkillBarProgress(player, "stealth"));
                    foragingBar.setProgress(getSkillBarProgress(player, "soldier"));
                    miningBar.setProgress(getSkillBarProgress(player, "marauder"));
                    fishingBar.setProgress(getSkillBarProgress(player, "assassin"));
                    farmingBar.setProgress(getSkillBarProgress(player, "cavalier"));
                    craftingBar.setProgress(getSkillBarProgress(player, "martialArtist"));
                    cookingBar.setProgress(getSkillBarProgress(player, "shieldHero"));
                    acrobaticsBar.setProgress(getSkillBarProgress(player, "marksman"));
                    stealthBar.setProgress(getSkillBarProgress(player, "sorcerer"));
                    cookingBar.setProgress(getSkillBarProgress(player, "primordial"));
                    acrobaticsBar.setProgress(getSkillBarProgress(player, "hallowed"));
                    stealthBar.setProgress(getSkillBarProgress(player, "annulled"));
                    skillBars.put(uuid, new BossBar[]{foragingBar, miningBar, fishingBar, farmingBar, craftingBar, cookingBar, acrobaticsBar, stealthBar,
                            soldierBar, marauderBar, assassinBar, cavalierBar, martialArtistBar, shieldHeroBar, marksmanBar, sorcererBar, primordialBar, hallowedBar, annulledBar});
                } else {
                    if (player.hasMetadata("foraging_bar")) {
                        skillBars.get(uuid)[0].addPlayer(player);
                    } else {
                        skillBars.get(uuid)[0].removePlayer(player);
                    }

                    if (player.hasMetadata("mining_bar")) {
                        skillBars.get(uuid)[1].addPlayer(player);
                    } else {
                        skillBars.get(uuid)[1].removePlayer(player);
                    }

                    if (player.hasMetadata("fishing_bar")) {
                        skillBars.get(uuid)[2].addPlayer(player);
                    } else {
                        skillBars.get(uuid)[2].removePlayer(player);
                    }

                    if (player.hasMetadata("farming_bar")) {
                        skillBars.get(uuid)[3].addPlayer(player);
                    } else {
                        skillBars.get(uuid)[3].removePlayer(player);
                    }

                    if (player.hasMetadata("crafting_bar")) {
                        skillBars.get(uuid)[4].addPlayer(player);
                    } else {
                        skillBars.get(uuid)[4].removePlayer(player);
                    }

                    if (player.hasMetadata("cooking_bar")) {
                        skillBars.get(uuid)[5].addPlayer(player);
                    } else {
                        skillBars.get(uuid)[5].removePlayer(player);
                    }

                    if (player.hasMetadata("acrobatics_bar")) {
                        skillBars.get(uuid)[6].addPlayer(player);
                    } else {
                        skillBars.get(uuid)[6].removePlayer(player);
                    }

                    if (player.hasMetadata("stealth_bar")) {
                        skillBars.get(uuid)[7].addPlayer(player);
                    } else {
                        skillBars.get(uuid)[7].removePlayer(player);
                    }

                    if (player.hasMetadata("soldier_bar")) {
                        skillBars.get(uuid)[8].addPlayer(player);
                    } else {
                        skillBars.get(uuid)[8].removePlayer(player);
                    }

                    if (player.hasMetadata("marauder_bar")) {
                        skillBars.get(uuid)[9].addPlayer(player);
                    } else {
                        skillBars.get(uuid)[9].removePlayer(player);
                    }

                    if (player.hasMetadata("assassin_bar")) {
                        skillBars.get(uuid)[10].addPlayer(player);
                    } else {
                        skillBars.get(uuid)[10].removePlayer(player);
                    }

                    if (player.hasMetadata("cavalier_bar")) {
                        skillBars.get(uuid)[11].addPlayer(player);
                    } else {
                        skillBars.get(uuid)[11].removePlayer(player);
                    }

                    if (player.hasMetadata("martial artist_bar")) {
                        skillBars.get(uuid)[12].addPlayer(player);
                    } else {
                        skillBars.get(uuid)[12].removePlayer(player);
                    }

                    if (player.hasMetadata("shield hero_bar")) {
                        skillBars.get(uuid)[13].addPlayer(player);
                    } else {
                        skillBars.get(uuid)[13].removePlayer(player);
                    }

                    if (player.hasMetadata("marksman_bar")) {
                        skillBars.get(uuid)[14].addPlayer(player);
                    } else {
                        skillBars.get(uuid)[14].removePlayer(player);
                    }

                    if (player.hasMetadata("sorcerer_bar")) {
                        skillBars.get(uuid)[15].addPlayer(player);
                    } else {
                        skillBars.get(uuid)[15].removePlayer(player);
                    }

                    if (player.hasMetadata("primordial_bar")) {
                        skillBars.get(uuid)[16].addPlayer(player);
                    } else {
                        skillBars.get(uuid)[16].removePlayer(player);
                    }

                    if (player.hasMetadata("hallowed_bar")) {
                        skillBars.get(uuid)[17].addPlayer(player);
                    } else {
                        skillBars.get(uuid)[17].removePlayer(player);
                    }

                    if (player.hasMetadata("annulled_bar")) {
                        skillBars.get(uuid)[18].addPlayer(player);
                    } else {
                        skillBars.get(uuid)[18].removePlayer(player);
                    }
                }

            }
        }, 0L, 1L);
    }

    public void stop() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.removeMetadata("foraging_bar", nmlSkills);
            player.removeMetadata("mining_bar", nmlSkills);
            player.removeMetadata("fishing_bar", nmlSkills);
            player.removeMetadata("farming_bar", nmlSkills);
            player.removeMetadata("crafting_bar", nmlSkills);
            player.removeMetadata("cooking_bar", nmlSkills);
            player.removeMetadata("acrobatics_bar", nmlSkills);
            player.removeMetadata("stealth_bar", nmlSkills);
            player.removeMetadata("soldier_bar", nmlSkills);
            player.removeMetadata("marauder_bar", nmlSkills);
            player.removeMetadata("assassin_bar", nmlSkills);
            player.removeMetadata("cavalier_bar", nmlSkills);
            player.removeMetadata("martial artist_bar", nmlSkills);
            player.removeMetadata("shield hero_bar", nmlSkills);
            player.removeMetadata("marksman_bar", nmlSkills);
            player.removeMetadata("sorcerer_bar", nmlSkills);
            player.removeMetadata("primordial_bar", nmlSkills);
            player.removeMetadata("hallowed_bar", nmlSkills);
            player.removeMetadata("annulled_bar", nmlSkills);
        }

        skillBarsTask.cancel();
        skillBars.clear();
    }

    public static double getSkillBarProgress(Player player, String skill) {
        Skills skills = nmlSkills.getSkillSetManager().getSkillSet(player.getUniqueId()).getSkills();

        switch (skill) {
            case "foraging" -> {
                return skills.getForagingExp() / skills.getExp2LvlUpForaging();
            }
            case "mining" -> {
                return skills.getMiningExp() / skills.getExp2LvlUpMining();
            }
            case "fishing" -> {
                return skills.getFishingExp() / skills.getExp2LvlUpFishing();
            }
            case "farming" -> {
                return skills.getFarmingExp() / skills.getExp2LvlUpFarming();
            }
            case "crafting" -> {
                return skills.getCraftingExp() / skills.getExp2LvlUpCrafting();
            }
            case "cooking" -> {
                return skills.getCookingExp() / skills.getExp2LvlUpCooking();
            }
            case "acrobatics" -> {
                return skills.getAcrobaticsExp() / skills.getExp2LvlUpAcrobatics();
            }
            case "stealth" -> {
                return skills.getStealthExp() / skills.getExp2LvlUpStealth();
            }
        }

        return 0;
    }

    public static void updateSkillBarProgress(Player player, String skill) {
        UUID uuid = player.getUniqueId();
        Skills skills = nmlSkills.getSkillSetManager().getSkillSet(uuid).getSkills();

        switch (skill) {
            case "combatexp" -> player.setExp((float) (skills.getCombatExp() / skills.getExp2LvlUpCombat()));
            case "foragingexp" -> {
                BossBar foragingBar = skillBars.get(uuid)[0];
                double progress = skills.getForagingExp() / skills.getExp2LvlUpForaging();

                if (progress >= 1) {
                    progress -= 1;
                    skills.setForagingLevel(skills.getForagingLevel() + 1);
                    skills.setForagingExp(progress * skills.getExp2LvlUpForaging());
                }

                foragingBar.setProgress(progress);
                player.setMetadata("foraging_bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("foraging_bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "miningexp" -> {
                BossBar miningBar = skillBars.get(uuid)[1];
                double progress = skills.getMiningExp() / skills.getExp2LvlUpMining();

                if (progress >= 1) {
                    progress -= 1;
                    skills.setMiningLevel(skills.getMiningLevel() + 1);
                    skills.setMiningExp(progress * skills.getExp2LvlUpMining());
                }

                miningBar.setProgress(progress);
                player.setMetadata("mining_bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("mining_bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "fishingexp" -> {
                BossBar fishingBar = skillBars.get(uuid)[2];
                double progress = skills.getFishingExp() / skills.getExp2LvlUpFishing();

                if (progress >= 1) {
                    progress -= 1;
                    skills.setFishingLevel(skills.getFishingLevel() + 1);
                    skills.setFishingExp(progress * skills.getExp2LvlUpFishing());
                }

                fishingBar.setProgress(progress);
                player.setMetadata("fishing_bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("fishing_bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "farmingexp" -> {
                BossBar farmingBar = skillBars.get(uuid)[3];
                double progress = skills.getFarmingExp() / skills.getExp2LvlUpFarming();

                if (progress >= 1) {
                    progress -= 1;
                    skills.setFarmingLevel(skills.getFarmingLevel() + 1);
                    skills.setFarmingExp(progress * skills.getExp2LvlUpFarming());
                }

                farmingBar.setProgress(progress);
                player.setMetadata("farming_bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("farming_bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "craftingexp" -> {
                BossBar craftingBar = skillBars.get(uuid)[4];
                double progress = skills.getCraftingExp() / skills.getExp2LvlUpCrafting();

                if (progress >= 1) {
                    progress -= 1;
                    skills.setCraftingLevel(skills.getCraftingLevel() + 1);
                    skills.setCraftingExp(progress * skills.getExp2LvlUpCrafting());
                }

                craftingBar.setProgress(progress);
                player.setMetadata("crafting_bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("crafting_bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "cookingexp" -> {
                BossBar cookingBar = skillBars.get(uuid)[5];
                double progress = skills.getCookingExp() / skills.getExp2LvlUpCooking();

                if (progress >= 1) {
                    progress -= 1;
                    skills.setCookingLevel(skills.getCookingLevel() + 1);
                    skills.setCookingExp(progress * skills.getExp2LvlUpCooking());
                }

                cookingBar.setProgress(progress);
                player.setMetadata("cooking_bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("cooking_bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "acrobaticsexp" -> {
                BossBar acrobaticsBar = skillBars.get(uuid)[6];
                double progress = skills.getAcrobaticsExp() / skills.getExp2LvlUpAcrobatics();

                if (progress >= 1) {
                    progress -= 1;
                    skills.setAcrobaticsLevel(skills.getAcrobaticsLevel() + 1);
                    skills.setAcrobaticsExp(progress * skills.getExp2LvlUpAcrobatics());
                }

                acrobaticsBar.setProgress(progress);
                player.setMetadata("acrobatics_bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("acrobatics_bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "stealthexp" -> {
                BossBar stealthBar = skillBars.get(uuid)[7];
                double progress = skills.getStealthExp() / skills.getExp2LvlUpStealth();

                if (progress >= 1) {
                    progress -= 1;
                    skills.setStealthLevel(skills.getStealthLevel() + 1);
                    skills.setStealthExp(progress * skills.getExp2LvlUpStealth());
                }

                stealthBar.setProgress(progress);
                player.setMetadata("stealth_bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("stealth_bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "soldierexp" -> {
                BossBar soldierBar = skillBars.get(uuid)[8];
                double progress = skills.getSoldierExp() / skills.getExp2LvlUpSoldier();

                if (progress >= 1) {
                    progress -= 1;
                    skills.setSoldierLevel(skills.getSoldierLevel() + 1);
                    skills.setSoldierExp(progress * skills.getExp2LvlUpSoldier());
                }

                soldierBar.setProgress(progress);
                player.setMetadata("soldier_bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("soldier_bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "marauderexp" -> {
                BossBar marauderBar = skillBars.get(uuid)[9];
                double progress = skills.getMarauderExp() / skills.getExp2LvlUpMarauder();

                if (progress >= 1) {
                    progress -= 1;
                    skills.setMarauderLevel(skills.getMarauderLevel() + 1);
                    skills.setMarauderExp(progress * skills.getExp2LvlUpMarauder());
                }

                marauderBar.setProgress(progress);
                player.setMetadata("marauder_bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("marauder_bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "assassinexp" -> {
                BossBar assassinBar = skillBars.get(uuid)[10];
                double progress = skills.getAssassinExp() / skills.getExp2LvlUpAssassin();

                if (progress >= 1) {
                    progress -= 1;
                    skills.setAssassinLevel(skills.getAssassinLevel() + 1);
                    skills.setAssassinExp(progress * skills.getExp2LvlUpAssassin());
                }

                assassinBar.setProgress(progress);
                player.setMetadata("assassin_bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("assassin_bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "cavalierexp" -> {
                BossBar cavalierBar = skillBars.get(uuid)[11];
                double progress = skills.getCavalierExp() / skills.getExp2LvlUpCavalier();

                if (progress >= 1) {
                    progress -= 1;
                    skills.setCavalierLevel(skills.getCavalierLevel() + 1);
                    skills.setCavalierExp(progress * skills.getExp2LvlUpCavalier());
                }

                cavalierBar.setProgress(progress);
                player.setMetadata("cavalier_bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("cavalier_bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "martialartistexp" -> {
                BossBar maBar = skillBars.get(uuid)[12];
                double progress = skills.getMartialArtistExp() / skills.getExp2LvlUpMartialArtist();

                if (progress >= 1) {
                    progress -= 1;
                    skills.setMartialArtistLevel(skills.getMartialArtistLevel() + 1);
                    skills.setMartialArtistExp(progress * skills.getExp2LvlUpMartialArtist());
                }

                maBar.setProgress(progress);
                player.setMetadata("martial artist_bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("martial artist_bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "shieldheroexp" -> {
                BossBar shBar = skillBars.get(uuid)[13];
                double progress = skills.getShieldHeroExp() / skills.getExp2LvlUpShieldHero();

                if (progress >= 1) {
                    progress -= 1;
                    skills.setShieldHeroLevel(skills.getShieldHeroLevel() + 1);
                    skills.setShieldHeroExp(progress * skills.getExp2LvlUpShieldHero());
                }

                shBar.setProgress(progress);
                player.setMetadata("shield hero_bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("shield hero_bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "marksmanexp" -> {
                BossBar marksmanBar = skillBars.get(uuid)[14];
                double progress = skills.getMarksmanExp() / skills.getExp2LvlUpMarksman();

                if (progress >= 1) {
                    progress -= 1;
                    skills.setMarksmanLevel(skills.getMarksmanLevel() + 1);
                    skills.setMarksmanExp(progress * skills.getExp2LvlUpMarksman());
                }

                marksmanBar.setProgress(progress);
                player.setMetadata("marksman_bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("marksman_bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "sorcererexp" -> {
                BossBar sorcererBar = skillBars.get(uuid)[15];
                double progress = skills.getSorcererExp() / skills.getExp2LvlUpSorcerer();

                if (progress >= 1) {
                    progress -= 1;
                    skills.setSorcererLevel(skills.getSorcererLevel() + 1);
                    skills.setSorcererExp(progress * skills.getExp2LvlUpSorcerer());
                }

                sorcererBar.setProgress(progress);
                player.setMetadata("sorcerer_bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("sorcerer_bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "hallowedexp" -> {
                BossBar hallowedBar = skillBars.get(uuid)[16];
                double progress = skills.getHallowedExp() / skills.getExp2LvlUpHallowed();

                if (progress >= 1) {
                    progress -= 1;
                    skills.setHallowedLevel(skills.getHallowedLevel() + 1);
                    skills.setHallowedExp(progress * skills.getExp2LvlUpHallowed());
                }

                hallowedBar.setProgress(progress);
                player.setMetadata("hallowed_bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("hallowed_bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "annulledexp" -> {
                BossBar annulledBar = skillBars.get(uuid)[17];
                double progress = skills.getAnnulledExp() / skills.getExp2LvlUpAnnulled();

                if (progress >= 1) {
                    progress -= 1;
                    skills.setAnnulledLevel(skills.getAnnulledLevel() + 1);
                    skills.setAnnulledExp(progress * skills.getExp2LvlUpAnnulled());
                }

                annulledBar.setProgress(progress);
                player.setMetadata("annulled_bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("annulled_bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
        }
    }

    public static void updateSkillBarLevel(Player player, String skill) {
        UUID uuid = player.getUniqueId();
        Skills skills = nmlSkills.getSkillSetManager().getSkillSet(player.getUniqueId()).getSkills();

        switch (skill) {
            case "combat" -> player.setLevel(skills.getCombatLevel());
            case "foraging" -> {
                BossBar foragingBar = skillBars.get(uuid)[0];

                foragingBar.setTitle("Lvl. §b" + skills.getForagingLevel() + "§r Foraging");
                player.setMetadata("foraging_bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("foraging_bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "mining" -> {
                BossBar miningBar = skillBars.get(uuid)[1];

                miningBar.setTitle("Lvl. §b" + skills.getMiningLevel() + "§r Mining");
                player.setMetadata("mining_bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("mining_bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "fishing" -> {
                BossBar fishingBar = skillBars.get(uuid)[2];

                fishingBar.setTitle("Lvl. §b" + skills.getFishingLevel() + "§r Fishing");
                player.setMetadata("fishing_bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("fishing_bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "farming" -> {
                BossBar farmingBar = skillBars.get(uuid)[3];

                farmingBar.setTitle("Lvl. §b" + skills.getFarmingLevel() + "§r Farming");
                player.setMetadata("farming_bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("farming_bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "crafting" -> {
                BossBar craftingBar = skillBars.get(uuid)[4];

                craftingBar.setTitle("Lvl. §b" + skills.getCraftingLevel() + "§r Crafting");
                player.setMetadata("crafting_bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("crafting_bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "cooking" -> {
                BossBar cookingBar = skillBars.get(uuid)[5];

                cookingBar.setTitle("Lvl. §b" + skills.getCookingLevel() + "§r Cooking");
                player.setMetadata("cooking_bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("cooking_bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "acrobatics" -> {
                BossBar acrobaticsBar = skillBars.get(uuid)[6];

                acrobaticsBar.setTitle("Lvl. §b" + skills.getAcrobaticsLevel() + "§r Acrobatics");
                player.setMetadata("acrobatics_bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("acrobatics_bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "stealth" -> {
                BossBar stealthBar = skillBars.get(uuid)[7];

                stealthBar.setTitle("Lvl. §b" + skills.getStealthLevel() + "§r Stealth");
                player.setMetadata("stealth_bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("stealth_bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "soldier" -> {
                BossBar soldierBar = skillBars.get(uuid)[8];

                soldierBar.setTitle("Lvl. §b" + skills.getSoldierLevel() + "§r Soldier");
                player.setMetadata("soldier_bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("soldier_bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "marauder" -> {
                BossBar marauderBar = skillBars.get(uuid)[9];

                marauderBar.setTitle("Lvl. §b" + skills.getMarauderLevel() + "§r Marauder");
                player.setMetadata("marauder_bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("marauder_bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "assassin" -> {
                BossBar assassinBar = skillBars.get(uuid)[10];

                assassinBar.setTitle("Lvl. §b" + skills.getAssassinLevel() + "§r Assassin");
                player.setMetadata("assassin_bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("assassin_bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "cavalier" -> {
                BossBar cavalierBar = skillBars.get(uuid)[11];

                cavalierBar.setTitle("Lvl. §b" + skills.getCavalierLevel() + "§r Cavalier");
                player.setMetadata("cavalier_bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("cavalier_bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "martialartist" -> {
                BossBar maBar = skillBars.get(uuid)[12];

                maBar.setTitle("Lvl. §b" + skills.getMartialArtistLevel() + "§r Martial Artist");
                player.setMetadata("martial artist_bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("martial artist_bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "shieldhero" -> {
                BossBar shBar = skillBars.get(uuid)[13];

                shBar.setTitle("Lvl. §b" + skills.getShieldHeroLevel() + "§r Shield Hero");
                player.setMetadata("shield hero_bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("shield hero_bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "marksman" -> {
                BossBar marksmanBar = skillBars.get(uuid)[14];

                marksmanBar.setTitle("Lvl. §b" + skills.getMarksmanLevel() + "§r Marksman");
                player.setMetadata("marksman_bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("marksman_bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "sorcerer" -> {
                BossBar sorcererBar = skillBars.get(uuid)[15];

                sorcererBar.setTitle("Lvl. §b" + skills.getSorcererLevel() + "§r Sorcerer");
                player.setMetadata("sorcerer_bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("sorcerer_bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "hallowed" -> {
                BossBar hallowedBar = skillBars.get(uuid)[16];

                hallowedBar.setTitle("Lvl. §b" + skills.getHallowedLevel() + "§r Hallowed");
                player.setMetadata("hallowed_bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("hallowed_bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "annulled" -> {
                BossBar annulledBar = skillBars.get(uuid)[17];

                annulledBar.setTitle("Lvl. §b" + skills.getAnnulledLevel() + "§r Annulled");
                player.setMetadata("annulled_bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("annulled_bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
        }
    }
}
