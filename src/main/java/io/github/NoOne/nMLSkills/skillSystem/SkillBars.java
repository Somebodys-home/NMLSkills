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
                    BossBar cultivatingBar = Bukkit.createBossBar("Lvl. §b" + skills.getCultivatingLevel() + "§r Cultivating" , BarColor.WHITE, BarStyle.SOLID);
                    BossBar craftingBar = Bukkit.createBossBar("Lvl. §b" + skills.getCraftingLevel() + "§r Crafting" , BarColor.WHITE, BarStyle.SOLID);
                    BossBar cookingBar = Bukkit.createBossBar("Lvl. §b" + skills.getCookingLevel() + "§r Cooking" , BarColor.WHITE, BarStyle.SOLID);
                    BossBar acrobaticsBar = Bukkit.createBossBar("Lvl. §b" + skills.getAcrobaticsLevel() + "§r Acrobatics" , BarColor.WHITE, BarStyle.SOLID);
                    BossBar stealthBar = Bukkit.createBossBar("Lvl. §b" + skills.getStealthLevel() + "§r Stealth" , BarColor.WHITE, BarStyle.SOLID);

                    foragingBar.setProgress(getSkillBarProgress(player, "foraging"));
                    miningBar.setProgress(getSkillBarProgress(player, "mining"));
                    fishingBar.setProgress(getSkillBarProgress(player, "fishing"));
                    cultivatingBar.setProgress(getSkillBarProgress(player, "cultivating"));
                    craftingBar.setProgress(getSkillBarProgress(player, "crafting"));
                    cookingBar.setProgress(getSkillBarProgress(player, "cooking"));
                    acrobaticsBar.setProgress(getSkillBarProgress(player, "acrobatics"));
                    stealthBar.setProgress(getSkillBarProgress(player, "stealth"));
                    skillBars.put(uuid, new BossBar[]{foragingBar, miningBar, fishingBar, cultivatingBar, craftingBar, cookingBar, acrobaticsBar, stealthBar});
                } else {
                    if (player.hasMetadata("foraging bar")) {
                        skillBars.get(uuid)[0].addPlayer(player);
                    } else {
                        skillBars.get(uuid)[0].removePlayer(player);
                    }

                    if (player.hasMetadata("mining bar")) {
                        skillBars.get(uuid)[1].addPlayer(player);
                    } else {
                        skillBars.get(uuid)[1].removePlayer(player);
                    }

                    if (player.hasMetadata("fishing bar")) {
                        skillBars.get(uuid)[2].addPlayer(player);
                    } else {
                        skillBars.get(uuid)[2].removePlayer(player);
                    }

                    if (player.hasMetadata("cultivating bar")) {
                        skillBars.get(uuid)[3].addPlayer(player);
                    } else {
                        skillBars.get(uuid)[3].removePlayer(player);
                    }

                    if (player.hasMetadata("crafting bar")) {
                        skillBars.get(uuid)[4].addPlayer(player);
                    } else {
                        skillBars.get(uuid)[4].removePlayer(player);
                    }

                    if (player.hasMetadata("cooking bar")) {
                        skillBars.get(uuid)[5].addPlayer(player);
                    } else {
                        skillBars.get(uuid)[5].removePlayer(player);
                    }

                    if (player.hasMetadata("acrobatics bar")) {
                        skillBars.get(uuid)[6].addPlayer(player);
                    } else {
                        skillBars.get(uuid)[6].removePlayer(player);
                    }

                    if (player.hasMetadata("stealth bar")) {
                        skillBars.get(uuid)[7].addPlayer(player);
                    } else {
                        skillBars.get(uuid)[7].removePlayer(player);
                    }
                }

            }
        }, 0L, 1L);
    }

    public void stop() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.removeMetadata("foraging bar", nmlSkills);
            player.removeMetadata("mining bar", nmlSkills);
            player.removeMetadata("fishing bar", nmlSkills);
            player.removeMetadata("cultivating bar", nmlSkills);
            player.removeMetadata("crafting bar", nmlSkills);
            player.removeMetadata("cooking bar", nmlSkills);
            player.removeMetadata("acrobatics bar", nmlSkills);
            player.removeMetadata("stealth bar", nmlSkills);
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
            case "cultivating" -> {
                return skills.getCultivatingExp() / skills.getExp2LvlUpCultivating();
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
        Skills skills = nmlSkills.getSkillSetManager().getSkillSet(player.getUniqueId()).getSkills();

        switch (skill) {
            case "combatexp" -> player.setExp((float) (skills.getForagingExp() / skills.getExp2LvlUpForaging()));
            case "foragingexp" -> {
                BossBar foragingBar = skillBars.get(uuid)[0];
                foragingBar.setProgress(skills.getForagingExp() / skills.getExp2LvlUpForaging());
                player.setMetadata("foraging bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("foraging bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "miningexp" -> {
                BossBar miningBar = skillBars.get(uuid)[1];

                miningBar.setProgress(skills.getMiningExp() / skills.getExp2LvlUpMining());
                player.setMetadata("mining bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("mining bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "fishingexp" -> {
                BossBar fishingBar = skillBars.get(uuid)[2];

                fishingBar.setProgress(skills.getFishingExp() / skills.getExp2LvlUpFishing());
                player.setMetadata("fishing bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("fishing bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "cultivatingexp" -> {
                BossBar cultivatingBar = skillBars.get(uuid)[3];

                cultivatingBar.setProgress(skills.getCultivatingExp() / skills.getExp2LvlUpCultivating());
                player.setMetadata("cultivating bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("cultivating bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "craftingexp" -> {
                BossBar craftingBar = skillBars.get(uuid)[4];

                craftingBar.setProgress(skills.getCraftingExp() / skills.getExp2LvlUpCrafting());
                player.setMetadata("crafting bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("crafting bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "cookingexp" -> {
                BossBar cookingBar = skillBars.get(uuid)[5];

                cookingBar.setProgress(skills.getCookingExp() / skills.getExp2LvlUpCooking());
                player.setMetadata("cooking bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("cooking bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "acrobaticsexp" -> {
                BossBar acrobaticsBar = skillBars.get(uuid)[6];

                acrobaticsBar.setProgress(skills.getAcrobaticsExp() / skills.getExp2LvlUpAcrobatics());
                player.setMetadata("acrobatics bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("acrobatics bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "stealthexp" -> {
                BossBar stealthBar = skillBars.get(uuid)[7];

                stealthBar.setProgress(skills.getStealthExp() / skills.getExp2LvlUpStealth());
                player.setMetadata("stealth bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("stealth bar", nmlSkills);
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
                player.setMetadata("foraging bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("foraging bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "mining" -> {
                BossBar miningBar = skillBars.get(uuid)[1];

                miningBar.setTitle("Lvl. §b" + skills.getMiningLevel() + "§r Mining");
                player.setMetadata("mining bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("mining bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "fishing" -> {
                BossBar fishingBar = skillBars.get(uuid)[2];

                fishingBar.setTitle("Lvl. §b" + skills.getFishingLevel() + "§r Fishing");
                player.setMetadata("fishing bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("fishing bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "cultivating" -> {
                BossBar cultivatingBar = skillBars.get(uuid)[3];

                cultivatingBar.setTitle("Lvl. §b" + skills.getCultivatingLevel() + "§r Cultivating");
                player.setMetadata("cultivating bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("cultivating bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "crafting" -> {
                BossBar craftingBar = skillBars.get(uuid)[4];

                craftingBar.setTitle("Lvl. §b" + skills.getCraftingLevel() + "§r Crafting");
                player.setMetadata("crafting bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("crafting bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "cooking" -> {
                BossBar cookingBar = skillBars.get(uuid)[5];

                cookingBar.setTitle("Lvl. §b" + skills.getCookingLevel() + "§r Cooking");
                player.setMetadata("cooking bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("cooking bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "acrobatics" -> {
                BossBar acrobaticsBar = skillBars.get(uuid)[6];

                acrobaticsBar.setTitle("Lvl. §b" + skills.getAcrobaticsLevel() + "§r Acrobatics");
                player.setMetadata("acrobatics bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("acrobatics bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "stealth" -> {
                BossBar stealthBar = skillBars.get(uuid)[7];

                stealthBar.setTitle("Lvl. §b" + skills.getStealthLevel() + "§r Stealth");
                player.setMetadata("stealth bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("stealth bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
        }
    }
}
