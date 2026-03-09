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
    private static final HashMap<UUID, BossBar[]> skillBars = new HashMap<>();
    private static final HashMap<UUID, BukkitTask> removeSkillBarTasks = new HashMap<>();

    public SkillBars(NMLSkills nmlSkills) {
        this.nmlSkills = nmlSkills;
    }

    public void start() {
        skillBarsTask = Bukkit.getScheduler().runTaskTimer(nmlSkills, () -> {
            for (Player player : Bukkit.getOnlinePlayers()) {
                UUID uuid = player.getUniqueId();

                if (!skillBars.containsKey(uuid)) {
                    Skills skills = nmlSkills.getSkillSetManager().getSkillSet(uuid).getSkills();
                    BossBar foragingBar = Bukkit.createBossBar("Lvl. §b" + skills.getForagingLevel() + "§r Forager" , BarColor.GREEN, BarStyle.SOLID);
                    BossBar miningBar = Bukkit.createBossBar("Lvl. §b" + skills.getMiningLevel() + "§r Miner" , BarColor.BLUE, BarStyle.SOLID);
                    BossBar fishingBar = Bukkit.createBossBar("Lvl. §b" + skills.getFishingLevel() + "§r Fisherman" , BarColor.BLUE, BarStyle.SOLID);
                    BossBar farmingBar = Bukkit.createBossBar("Lvl. §b" + skills.getFarmingLevel() + "§r Farmer" , BarColor.GREEN, BarStyle.SOLID);
                    BossBar craftingBar = Bukkit.createBossBar("Lvl. §b" + skills.getCraftingLevel() + "§r Crafter" , BarColor.YELLOW, BarStyle.SOLID);
                    BossBar cookingBar = Bukkit.createBossBar("Lvl. §b" + skills.getCookingLevel() + "§r Chef" , BarColor.BLUE, BarStyle.SOLID);
                    BossBar acrobaticsBar = Bukkit.createBossBar("Lvl. §b" + skills.getAcrobaticsLevel() + "§r Acrobat" , BarColor.WHITE, BarStyle.SOLID);
                    BossBar stealthBar = Bukkit.createBossBar("Lvl. §b" + skills.getStealthLevel() + "§r Skulker" , BarColor.WHITE, BarStyle.SOLID);
                    BossBar soldierBar = Bukkit.createBossBar("Lvl. §b" + skills.getSoldierLevel() + "§r Soldier" , BarColor.RED, BarStyle.SOLID);
                    BossBar marauderBar = Bukkit.createBossBar("Lvl. §b" + skills.getMarauderLevel() + "§r Marauder" , BarColor.RED, BarStyle.SOLID);
                    BossBar assassinBar = Bukkit.createBossBar("Lvl. §b" + skills.getAssassinLevel() + "§r Assassin" , BarColor.WHITE, BarStyle.SOLID);
                    BossBar cavalierBar = Bukkit.createBossBar("Lvl. §b" + skills.getCavalierLevel() + "§r Cavalier" , BarColor.BLUE, BarStyle.SOLID);
                    BossBar martialArtistBar = Bukkit.createBossBar("Lvl. §b" + skills.getMartialArtistLevel() + "§r Martial Artist" , BarColor.RED, BarStyle.SOLID);
                    BossBar shieldHeroBar = Bukkit.createBossBar("Lvl. §b" + skills.getShieldHeroLevel() + "§r Shield Hero" , BarColor.BLUE, BarStyle.SOLID);
                    BossBar marksmanBar = Bukkit.createBossBar("Lvl. §b" + skills.getMarksmanLevel() + "§r Marksman" , BarColor.GREEN, BarStyle.SOLID);
                    BossBar sorcererBar = Bukkit.createBossBar("Lvl. §b" + skills.getSorcererLevel() + "§r Sorcerer" , BarColor.PINK, BarStyle.SOLID);
                    BossBar primordialBar = Bukkit.createBossBar("Lvl. §b" + skills.getPrimordialLevel() + "§r Primordial" , BarColor.GREEN, BarStyle.SOLID);
                    BossBar hallowedBar = Bukkit.createBossBar("Lvl. §b" + skills.getHallowedLevel() + "§r Hallowed" , BarColor.WHITE, BarStyle.SOLID);
                    BossBar annulledBar = Bukkit.createBossBar("Lvl. §b" + skills.getAnnulledLevel() + "§r Annulled" , BarColor.PURPLE, BarStyle.SOLID);

                    foragingBar.setProgress(getSkillBarProgress(player, "foraging"));
                    miningBar.setProgress(getSkillBarProgress(player, "mining"));
                    fishingBar.setProgress(getSkillBarProgress(player, "fishing"));
                    farmingBar.setProgress(getSkillBarProgress(player, "farming"));
                    craftingBar.setProgress(getSkillBarProgress(player, "crafting"));
                    cookingBar.setProgress(getSkillBarProgress(player, "cooking"));
                    acrobaticsBar.setProgress(getSkillBarProgress(player, "acrobatics"));
                    stealthBar.setProgress(getSkillBarProgress(player, "stealth"));
                    soldierBar.setProgress(getSkillBarProgress(player, "soldier"));
                    marauderBar.setProgress(getSkillBarProgress(player, "marauder"));
                    assassinBar.setProgress(getSkillBarProgress(player, "assassin"));
                    cavalierBar.setProgress(getSkillBarProgress(player, "cavalier"));
                    martialArtistBar.setProgress(getSkillBarProgress(player, "martialArtist"));
                    shieldHeroBar.setProgress(getSkillBarProgress(player, "shieldHero"));
                    marksmanBar.setProgress(getSkillBarProgress(player, "marksman"));
                    sorcererBar.setProgress(getSkillBarProgress(player, "sorcerer"));
                    primordialBar.setProgress(getSkillBarProgress(player, "primordial"));
                    hallowedBar.setProgress(getSkillBarProgress(player, "hallowed"));
                    annulledBar.setProgress(getSkillBarProgress(player, "annulled"));
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

                    if (player.hasMetadata("martial_artist_bar")) {
                        skillBars.get(uuid)[12].addPlayer(player);
                    } else {
                        skillBars.get(uuid)[12].removePlayer(player);
                    }

                    if (player.hasMetadata("shield_hero_bar")) {
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
            player.removeMetadata("martial_artist_bar", nmlSkills);
            player.removeMetadata("shield_hero_bar", nmlSkills);
            player.removeMetadata("marksman_bar", nmlSkills);
            player.removeMetadata("sorcerer_bar", nmlSkills);
            player.removeMetadata("primordial_bar", nmlSkills);
            player.removeMetadata("hallowed_bar", nmlSkills);
            player.removeMetadata("annulled_bar", nmlSkills);
        }

        skillBarsTask.cancel();
        skillBars.clear();
    }

    public static void updateSkillBarLevel(Player player, String skill) {
        Skills skills = nmlSkills.getSkillSetManager().getSkillSet(player.getUniqueId()).getSkills();
        BossBar skillBar = getSkillBar(player, skill);
        String title = "";

        switch (skill) {
            case "combat" -> {
                player.setLevel(skills.getCombatLevel());
                return;
            }
            case "foraging" -> title = "Forager";
            case "mining" -> title = "Miner";
            case "fishing" -> title = "Fisher";
            case "farming" -> title = "Farmer";
            case "crafting" -> title = "Crafter";
            case "cooking" -> title = "Chef";
            case "acrobatics" -> title = "Acrobat";
            case "stealth" -> title = "Skulker";
        }

        if (title.isEmpty()) {
            title = skill.substring(0,1).toUpperCase() + skill.substring(1);
        }

        skillBar.setTitle("Lvl. §b" + skills.getSkillLevel(skill) + " §r" + title);
        showSkillBarTask(player, skill);
    }

    public static void updateSkillBarProgress(Player player, String skill) {
        skill = skill.replace("exp", "");

        UUID uuid = player.getUniqueId();
        Skills skills = nmlSkills.getSkillSetManager().getSkillSet(uuid).getSkills();
        BossBar skillBar = getSkillBar(player, skill);
        double barProgress = skills.getSkillExp(skill) / skills.getExpToLvlUpSkill(skill);
        boolean shouldUpdateBar = false;

        while (barProgress >= 1) { // for when to level up from exp
            shouldUpdateBar = true;
            barProgress -= 1;
            skills.add2Skill(skill + "exp", -skills.getExpToLvlUpSkill(skill));
            // bar would be shown to the player in the method that updates the skill bar level
            Bukkit.getPluginManager().callEvent(new SkillChangeEvent(player, skill, 1));
        }

        if (!shouldUpdateBar) {
            showSkillBarTask(player, skill);
        }

        skillBar.setProgress(barProgress);
    }

    public static void updateSkillBarProgressOverTime(Player player, String skill, double change, int time) {
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
                    updateSkillBarLevel(player, skill);
                }

                foragingBar.setProgress(progress);
                showSkillBarTask(player, "foraging_bar");
            }
            case "miningexp" -> {
                BossBar miningBar = skillBars.get(uuid)[1];
                double progress = skills.getMiningExp() / skills.getExp2LvlUpMining();

                if (progress >= 1) {
                    progress -= 1;
                    skills.setMiningLevel(skills.getMiningLevel() + 1);
                    skills.setMiningExp(progress * skills.getExp2LvlUpMining());
                    updateSkillBarLevel(player, skill);
                }

                miningBar.setProgress(progress);
                showSkillBarTask(player, "mining_bar");
            }
            case "fishingexp" -> {
                BossBar fishingBar = skillBars.get(uuid)[2];
                double progress = skills.getFishingExp() / skills.getExp2LvlUpFishing();

                if (progress >= 1) {
                    progress -= 1;
                    skills.setFishingLevel(skills.getFishingLevel() + 1);
                    skills.setFishingExp(progress * skills.getExp2LvlUpFishing());
                    updateSkillBarLevel(player, skill);
                }

                fishingBar.setProgress(progress);
                showSkillBarTask(player, "fishing_bar");
            }
            case "farmingexp" -> {
                BossBar farmingBar = skillBars.get(uuid)[3];
                double progress = skills.getFarmingExp() / skills.getExp2LvlUpFarming();

                if (progress >= 1) {
                    progress -= 1;
                    skills.setFarmingLevel(skills.getFarmingLevel() + 1);
                    skills.setFarmingExp(progress * skills.getExp2LvlUpFarming());
                    updateSkillBarLevel(player, skill);
                }

                farmingBar.setProgress(progress);
                showSkillBarTask(player, "farming_bar");
            }
            case "craftingexp" -> {
                BossBar craftingBar = skillBars.get(uuid)[4];
                double progress = skills.getCraftingExp() / skills.getExp2LvlUpCrafting();

                if (progress >= 1) {
                    progress -= 1;
                    skills.setCraftingLevel(skills.getCraftingLevel() + 1);
                    skills.setCraftingExp(progress * skills.getExp2LvlUpCrafting());
                    updateSkillBarLevel(player, skill);
                }

                craftingBar.setProgress(progress);
                showSkillBarTask(player, "crafting_bar");
            }
            case "cookingexp" -> {
                BossBar cookingBar = skillBars.get(uuid)[5];
                double progress = skills.getCookingExp() / skills.getExp2LvlUpCooking();

                if (progress >= 1) {
                    progress -= 1;
                    skills.setCookingLevel(skills.getCookingLevel() + 1);
                    skills.setCookingExp(progress * skills.getExp2LvlUpCooking());
                    updateSkillBarLevel(player, skill);
                }

                cookingBar.setProgress(progress);
                showSkillBarTask(player, "cooking_bar");
            }
            case "acrobaticsexp" -> {
                BossBar acrobaticsBar = skillBars.get(uuid)[6];

                player.setMetadata("acrobatics_bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    final double progressPerTick = change / ((double) time / 20);
                    int timeElapsed = 0;

                    @Override
                    public void run() {
                        timeElapsed++;
                        acrobaticsBar.setProgress(Math.min(acrobaticsBar.getProgress() + progressPerTick, 1)); // adding to the progress without going over 1

                        if (timeElapsed == (time * 20)) {
                            player.removeMetadata("acrobatics_bar", nmlSkills);
                            cancel();
                        }
//                        if (acrobaticsBar.getProgress() == 1) {
//                            acrobaticsBar.setProgress(0);
//                            skills.setAcrobaticsLevel(skills.getAcrobaticsLevel() + 1);
//                            skills.setAcrobaticsExp(progress * skills.getExp2LvlUpAcrobatics());
//                            updateSkillBarLevel(player, skill);
//                        }
                    }
                }.runTaskTimer(nmlSkills, 0L, 1L);
            }
            case "stealthexp" -> {
                BossBar stealthBar = skillBars.get(uuid)[7];
                double progress = skills.getStealthExp() / skills.getExp2LvlUpStealth();

                if (progress >= 1) {
                    progress -= 1;
                    skills.setStealthLevel(skills.getStealthLevel() + 1);
                    skills.setStealthExp(progress * skills.getExp2LvlUpStealth());
                    updateSkillBarLevel(player, skill);
                }

                stealthBar.setProgress(progress);
                showSkillBarTask(player, "stealth_bar");
            }
            case "soldierexp" -> {
                BossBar soldierBar = skillBars.get(uuid)[8];
                double progress = skills.getSoldierExp() / skills.getExp2LvlUpSoldier();

                if (progress >= 1) {
                    progress -= 1;
                    skills.setSoldierLevel(skills.getSoldierLevel() + 1);
                    skills.setSoldierExp(progress * skills.getExp2LvlUpSoldier());
                    updateSkillBarLevel(player, skill);
                }

                soldierBar.setProgress(progress);
                showSkillBarTask(player, "soldier_bar");
            }
            case "marauderexp" -> {
                BossBar marauderBar = skillBars.get(uuid)[9];
                double progress = skills.getMarauderExp() / skills.getExp2LvlUpMarauder();

                if (progress >= 1) {
                    progress -= 1;
                    skills.setMarauderLevel(skills.getMarauderLevel() + 1);
                    skills.setMarauderExp(progress * skills.getExp2LvlUpMarauder());
                    updateSkillBarLevel(player, skill);
                }

                marauderBar.setProgress(progress);
                showSkillBarTask(player, "marauder_bar");
            }
            case "assassinexp" -> {
                BossBar assassinBar = skillBars.get(uuid)[10];
                double progress = skills.getAssassinExp() / skills.getExp2LvlUpAssassin();

                if (progress >= 1) {
                    progress -= 1;
                    skills.setAssassinLevel(skills.getAssassinLevel() + 1);
                    skills.setAssassinExp(progress * skills.getExp2LvlUpAssassin());
                    updateSkillBarLevel(player, skill);
                }

                assassinBar.setProgress(progress);
                showSkillBarTask(player, "assassin_bar");
            }
            case "cavalierexp" -> {
                BossBar cavalierBar = skillBars.get(uuid)[11];
                double progress = skills.getCavalierExp() / skills.getExp2LvlUpCavalier();

                if (progress >= 1) {
                    progress -= 1;
                    skills.setCavalierLevel(skills.getCavalierLevel() + 1);
                    skills.setCavalierExp(progress * skills.getExp2LvlUpCavalier());
                    updateSkillBarLevel(player, skill);
                }

                cavalierBar.setProgress(progress);
                showSkillBarTask(player, "cavalier_bar");
            }
            case "martialartistexp" -> {
                BossBar maBar = skillBars.get(uuid)[12];
                double progress = skills.getMartialArtistExp() / skills.getExp2LvlUpMartialArtist();

                if (progress >= 1) {
                    progress -= 1;
                    skills.setMartialArtistLevel(skills.getMartialArtistLevel() + 1);
                    skills.setMartialArtistExp(progress * skills.getExp2LvlUpMartialArtist());
                    updateSkillBarLevel(player, skill);
                }

                maBar.setProgress(progress);
                showSkillBarTask(player, "martial_artist_bar");
            }
            case "shieldheroexp" -> {
                BossBar shBar = skillBars.get(uuid)[13];
                double progress = skills.getShieldHeroExp() / skills.getExp2LvlUpShieldHero();

                if (progress >= 1) {
                    progress -= 1;
                    skills.setShieldHeroLevel(skills.getShieldHeroLevel() + 1);
                    skills.setShieldHeroExp(progress * skills.getExp2LvlUpShieldHero());
                    updateSkillBarLevel(player, skill);
                }

                shBar.setProgress(progress);
                showSkillBarTask(player, "shield_hero_bar");
            }
            case "marksmanexp" -> {
                BossBar marksmanBar = skillBars.get(uuid)[14];
                double progress = skills.getMarksmanExp() / skills.getExp2LvlUpMarksman();

                if (progress >= 1) {
                    progress -= 1;
                    skills.setMarksmanLevel(skills.getMarksmanLevel() + 1);
                    skills.setMarksmanExp(progress * skills.getExp2LvlUpMarksman());
                    updateSkillBarLevel(player, skill);
                }

                marksmanBar.setProgress(progress);
                showSkillBarTask(player, "marksman_bar");
            }
            case "sorcererexp" -> {
                BossBar sorcererBar = skillBars.get(uuid)[15];
                double progress = skills.getSorcererExp() / skills.getExp2LvlUpSorcerer();

                if (progress >= 1) {
                    progress -= 1;
                    skills.setSorcererLevel(skills.getSorcererLevel() + 1);
                    skills.setSorcererExp(progress * skills.getExp2LvlUpSorcerer());
                    updateSkillBarLevel(player, skill);
                }

                sorcererBar.setProgress(progress);
                showSkillBarTask(player, "sorcerer_bar");
            }
            case "hallowedexp" -> {
                BossBar hallowedBar = skillBars.get(uuid)[16];
                double progress = skills.getHallowedExp() / skills.getExp2LvlUpHallowed();

                if (progress >= 1) {
                    progress -= 1;
                    skills.setHallowedLevel(skills.getHallowedLevel() + 1);
                    skills.setHallowedExp(progress * skills.getExp2LvlUpHallowed());
                    updateSkillBarLevel(player, skill);
                }

                hallowedBar.setProgress(progress);
                showSkillBarTask(player, "hallowed_bar");
            }
            case "annulledexp" -> {
                BossBar annulledBar = skillBars.get(uuid)[17];
                double progress = skills.getAnnulledExp() / skills.getExp2LvlUpAnnulled();

                if (progress >= 1) {
                    progress -= 1;
                    skills.setAnnulledLevel(skills.getAnnulledLevel() + 1);
                    skills.setAnnulledExp(progress * skills.getExp2LvlUpAnnulled());
                    updateSkillBarLevel(player, skill);
                }

                annulledBar.setProgress(progress);
                showSkillBarTask(player, "annulled_bar");
            }
        }
    }

    private static void showSkillBarTask(Player player, String skill) {
        UUID uuid = player.getUniqueId();
        String metadataString = getSkillBarMetadataString(skill);

        player.setMetadata(metadataString, new FixedMetadataValue(nmlSkills, true));

        if (removeSkillBarTasks.containsKey(uuid)) {
            removeSkillBarTasks.get(uuid).cancel();
            removeSkillBarTasks.remove(uuid);
        }

        removeSkillBarTasks.put(uuid,
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata(metadataString, nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60)
        );
    }

    public static double getSkillBarProgress(Player player, String skill) {
        Skills skills = nmlSkills.getSkillSetManager().getSkillSet(player.getUniqueId()).getSkills();

        return switch (skill) {
            case "foraging" -> skills.getForagingExp() / skills.getExp2LvlUpForaging();
            case "mining" -> skills.getMiningExp() / skills.getExp2LvlUpMining();
            case "fishing" -> skills.getFishingExp() / skills.getExp2LvlUpFishing();
            case "farming" -> skills.getFarmingExp() / skills.getExp2LvlUpFarming();
            case "crafting" -> skills.getCraftingExp() / skills.getExp2LvlUpCrafting();
            case "cooking" -> skills.getCookingExp() / skills.getExp2LvlUpCooking();
            case "acrobatics" -> skills.getAcrobaticsExp() / skills.getExp2LvlUpAcrobatics();
            case "stealth" -> skills.getStealthExp() / skills.getExp2LvlUpStealth();
            default -> 0;
        };
    }

    public static String getSkillBarMetadataString(String skill) {
        return switch (skill) {
            case "foraging" -> "foraging_bar";
            case "mining" -> "mining_bar";
            case "fishing" -> "fishing_bar";
            case "farming" -> "farming_bar";
            case "crafting" -> "crafting_bar";
            case "cooking" -> "cooking_bar";
            case "acrobatics" -> "acrobatics_bar";
            case "stealth" -> "stealth_bar";
            default -> "";
        };
    }

    private static BossBar getSkillBar(Player player, String skill) {
        UUID uuid = player.getUniqueId();

        return switch (skill) {
            case "foraging" -> skillBars.get(uuid)[0];
            case "mining" -> skillBars.get(uuid)[1];
            case "fishing" -> skillBars.get(uuid)[2];
            case "farming" -> skillBars.get(uuid)[3];
            case "crafting" -> skillBars.get(uuid)[4];
            case "cooking" -> skillBars.get(uuid)[5];
            case "acrobatics" -> skillBars.get(uuid)[6];
            case "stealth" -> skillBars.get(uuid)[7];
            case "soldier" -> skillBars.get(uuid)[8];
            case "marauder" -> skillBars.get(uuid)[9];
            case "assassin" -> skillBars.get(uuid)[10];
            case "cavalier" -> skillBars.get(uuid)[11];
            case "martialartist" -> skillBars.get(uuid)[12];
            case "shieldhero" -> skillBars.get(uuid)[13];
            case "marksman" -> skillBars.get(uuid)[14];
            case "sorcerer" -> skillBars.get(uuid)[15];
            case "primordial" -> skillBars.get(uuid)[16];
            case "hallowed" -> skillBars.get(uuid)[17];
            case "annulled" -> skillBars.get(uuid)[18];
            default -> null;
        };
    }
}
