package io.github.NoOne.nMLSkills.skillSystem;

import io.github.NoOne.nMLSkills.NMLSkills;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.UUID;

public class SkillBars {
    private static NMLSkills nmlSkills;
    private static final HashMap<UUID, BossBar[]> skillBars = new HashMap<>();
    private static final HashMap<UUID, HashMap<String, BukkitTask>> showSkillBarTasks = new HashMap<>();

    public SkillBars(NMLSkills nmlSkills) {
        this.nmlSkills = nmlSkills;
    }

    public void clearData() {
        skillBars.clear();
    }

    public static void createSkillBars(Player player) {
        UUID uuid = player.getUniqueId();
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
    }

    public static void updateSkillBarLevel(Player player, String skill) {
        Skills skills = nmlSkills.getSkillSetManager().getSkillSet(player.getUniqueId()).getSkills();
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

        if (title.isEmpty()) { // for the expertises
            title = skill.substring(0,1).toUpperCase() + skill.substring(1);
        }

        getSkillBar(player, skill).setTitle("Lvl. §b" + skills.getSkillLevel(skill) + " §r" + title);
        addShowSkillBarTask(player, skill);
    }

    public static void updateSkillBarProgress(Player player, String skill) {
        skill = skill.replace("exp", "");

        UUID uuid = player.getUniqueId();
        Skills skills = nmlSkills.getSkillSetManager().getSkillSet(uuid).getSkills();
        double barProgress = skills.getSkillExp(skill) / skills.getExpToLvlUpSkill(skill);
        boolean levelUp = false;
        int levelChange = 0;

        while (barProgress >= 1) { // for when to level up from exp
            levelUp = true;
            barProgress -= 1;
            levelChange++;
            skills.add2Skill(skill + "exp", -skills.getExpToLvlUpSkill(skill));
        }

        if (levelUp) { // bar would be shown to the player in the method that updates the skill bar level
            Bukkit.getPluginManager().callEvent(new SkillChangeEvent(player, skill, levelChange));
        }

        if (skill.equals("combat")) {
            player.setExp((float) barProgress);
        } else {
            getSkillBar(player, skill).setProgress(barProgress);
            addShowSkillBarTask(player, skill);
        }
    }

    public static void updateSkillBarProgressOverTime(Player player, String skill, double expChange, int ticks) {
        skill = skill.replace("exp", "");



        UUID uuid = player.getUniqueId();
        Skills skills = nmlSkills.getSkillSetManager().getSkillSet(uuid).getSkills();
        BossBar skillBar = getSkillBar(player, skill);
        double barProgress = skills.getSkillExp(skill) / skills.getExpToLvlUpSkill(skill);
        double finalBarProgress = (skills.getSkillExp(skill) + expChange) / skills.getExpToLvlUpSkill(skill);

        String finalSkill = skill;
        new BukkitRunnable() {
            int timer = 0;
            final double progressPerTick = barProgress / finalBarProgress;

            @Override
            public void run() {
                timer++;

                double newProgress = skillBar.getProgress() + progressPerTick;
                boolean levelUp = false;
                int levelChange = 0;

                while (newProgress >= 1) { // for when to level up from exp
                    levelUp = true;
                    newProgress -= 1;
                    levelChange++;
                    skills.add2Skill(finalSkill + "exp", -skills.getExpToLvlUpSkill(finalSkill));
                }

                if (levelUp) { // bar would be shown to the player in the method that updates the skill bar level
                    Bukkit.getPluginManager().callEvent(new SkillChangeEvent(player, finalSkill, levelChange));
                }

                if (timer == ticks) {
                    cancel();
                }
            }
        }.runTaskTimer(nmlSkills, 0L, 1L);

        addShowSkillBarTask(player, skill);
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

    private static void addShowSkillBarTask(Player player, String skill) {
        UUID uuid = player.getUniqueId();
        HashMap<String, BukkitTask> existingTasks = showSkillBarTasks.computeIfAbsent(uuid, k -> new HashMap<>());

        // logic for whether skill bar is already shown to the player
        if (!existingTasks.containsKey(skill)) { // if it isn't, show it
            getSkillBar(player, skill).addPlayer(player);
        } else { // if it is, cancel the task and clear the data
            existingTasks.remove(skill).cancel();
        }

        // adding showing bar task
        existingTasks.put(skill, new BukkitRunnable() {
            @Override
            public void run() {
                getSkillBar(player, skill).removePlayer(player);
                existingTasks.remove(skill);
            }
        }.runTaskLater(nmlSkills, 60L));
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

    public static HashMap<UUID, BossBar[]> getSkillBars() {
        return skillBars;
    }
}
