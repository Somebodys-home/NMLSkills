package io.github.NoOne.nMLSkills.skillSystem;

import io.github.NoOne.nMLSkills.NMLSkills;
import io.github.NoOne.nMLSkills.SaveSkillsManager;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SkillBars {
    private static NMLSkills nmlSkills = NMLSkills.getInstance();
    private static SaveSkillsManager saveSkillsManager = nmlSkills.getSaveSkillsManager();
    private static HashMap<UUID, HashMap<Skill, BossBar>> skillBars = new HashMap<>();
    // stores a hashmap of all the players, that holds a hashmap of every bar with it's associated skill
    private static HashMap<UUID, HashMap<Skill, Integer>> showSkillBarTimers = new HashMap<>(); // stores the time that each bar for the skill will be displayed
    private static HashMap<UUID, HashMap<Skill, Integer>> skillBarExp = new HashMap<>(); // stores the time that each bar for the skill will be displayed

    public static void startShowBarsTask() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (UUID uuid : showSkillBarTimers.keySet()) {
                    Player player = Bukkit.getPlayer(uuid);
                    HashMap<Skill, Integer> skillTimers = showSkillBarTimers.get(uuid);

                    // for every skill timer
                    for (Map.Entry<Skill, Integer> skillTimer : skillTimers.entrySet()) {
                        Skill skill = skillTimer.getKey();
                        int time = skillTimer.getValue();
                        BossBar bossBar = skillBars.get(uuid).get(skill);

                        if (time > 0) { // if theres time left, show the bar to the player if it isnt already
                            if (!bossBar.getPlayers().contains(player)) {
                                bossBar.addPlayer(player);
                            }
                        } else { // if theres no time left, hide the bar and remove the time from the players map
                            bossBar.removePlayer(player);
                            skillTimers.remove(skill);
                        }

                        skillTimer.setValue(time - 1);
                    }
                }
            }
        }.runTaskTimer(nmlSkills, 0, 1);
    }

    public static void createSkillBars(Player player) {
        UUID uuid = player.getUniqueId();
        HashMap<Skill, BossBar> playerSkillBars = new HashMap<>(){{
            for (Skill skill : Skill.values()) {
                if (skill != Skill.COMBAT) {
                    BossBar bar = makeSkillBar(player, skill);

                    bar.setProgress(getSkillBarProgress(player, skill));
                    put(skill, bar);
                }
            }
        }};

        skillBars.put(uuid, playerSkillBars);
    }

    public static void updateSkillBarLevel(Player player, Skill skill) {
        Skills skills = nmlSkills.getSaveSkillsManager().getSkills(player.getUniqueId());

        if (skill == Skill.COMBAT) {
            player.setLevel(skills.getSkillLevel(Skill.COMBAT));
        } else {
            getSkillBar(player, skill).setTitle(makeBarTitle(skills, skill));
            showSkillBar(player, skill);
        }
    }

    // todo: fix this
    public static void updateSkillBarProgress(Player player, Skill skill) {
        UUID uuid = player.getUniqueId();
        Skills skills = nmlSkills.getSaveSkillsManager().getSkills(uuid);
        double barProgress = (double) skills.getSkillExp(skill) / skills.calculateExpToLvlUpSkill(skill);
        int levelChange = 0;

        // if bar progress is over 100%, then for every 100%, level up the skill
        if (barProgress >= 1) {
            barProgress -= 1;
            levelChange++;
            skills.removeFromSkillExp(skill, skills.calculateExpToLvlUpSkill(skill));
        }

        if (levelChange != 0) { // bar would be shown to the player in the method that updates the skill bar level
            Bukkit.getPluginManager().callEvent(new SkillChangeEvent(player, skill, false, levelChange));
        }

        if (skill.equals(Skill.COMBAT)) {
            player.setExp((float) barProgress);
        } else {
            getSkillBar(player, skill).setProgress(barProgress);
            showSkillBar(player, skill);
        }
    }

    private static void showSkillBar(Player player, Skill skill) {
        HashMap<Skill, Integer> playerSkillBarTimers = showSkillBarTimers.getOrDefault(player.getUniqueId(), new HashMap<>());

        playerSkillBarTimers.put(skill, 60);
        showSkillBarTimers.put(player.getUniqueId(), playerSkillBarTimers);
    }

    public static BossBar getSkillBar(Player player, Skill skill) {
        return skillBars.get(player.getUniqueId()).get(skill);
    }

    public static HashMap<UUID, HashMap<Skill, BossBar>> getSkillBars() {
        return skillBars;
    }

    private static double getSkillBarProgress(Player player, Skill skill) {
        Skills skills = saveSkillsManager.getSkills(player.getUniqueId());

        return (double) skills.getSkillExp(skill) / skills.calculateExpToLvlUpSkill(skill);
    }

    private static String makeBarTitle(Skills skills, Skill skill) {
        return "Lvl. §b" + skills.getSkillLevel(skill) + "§r " + skill.toTitle();
    }

    private static BossBar makeSkillBar(Player player, Skill skill) {
        if (skill == Skill.COMBAT) {
            return null;
        } else {
            Skills skills = saveSkillsManager.getSkills(player.getUniqueId());
            BarColor barColor = switch (skill) {
                case FORAGING, FARMING, MARKSMAN, PRIMORDIAL -> BarColor.GREEN;
                case MINING, FISHING, COOKING, CAVALIER, SHIELD_HERO -> BarColor.BLUE;
                case CRAFTING -> BarColor.YELLOW;
                case ACROBATICS, STEALTH, ASSASSIN, HALLOWED -> BarColor.WHITE;
                case SOLDIER, MARAUDER, MARTIAL_ARTIST -> BarColor.RED;
                case SORCERER -> BarColor.PINK;
                case ANNULLED -> BarColor.PURPLE;
                default -> throw new IllegalStateException("Unexpected value: " + skill);
            };

            return Bukkit.createBossBar(makeBarTitle(skills, skill), barColor, BarStyle.SOLID);
        }
    }
}
