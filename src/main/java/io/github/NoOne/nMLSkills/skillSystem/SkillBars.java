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
                    cultivatingBar.setProgress(getSkillBarProgress(player, "cultivating"));
                    craftingBar.setProgress(getSkillBarProgress(player, "crafting"));
                    cookingBar.setProgress(getSkillBarProgress(player, "cooking"));
                    acrobaticsBar.setProgress(getSkillBarProgress(player, "acrobatics"));
                    stealthBar.setProgress(getSkillBarProgress(player, "stealth"));
                    foragingBar.setProgress(getSkillBarProgress(player, "soldier"));
                    miningBar.setProgress(getSkillBarProgress(player, "marauder"));
                    fishingBar.setProgress(getSkillBarProgress(player, "assassin"));
                    cultivatingBar.setProgress(getSkillBarProgress(player, "cavalier"));
                    craftingBar.setProgress(getSkillBarProgress(player, "martialArtist"));
                    cookingBar.setProgress(getSkillBarProgress(player, "shieldHero"));
                    acrobaticsBar.setProgress(getSkillBarProgress(player, "marksman"));
                    stealthBar.setProgress(getSkillBarProgress(player, "sorcerer"));
                    cookingBar.setProgress(getSkillBarProgress(player, "primordial"));
                    acrobaticsBar.setProgress(getSkillBarProgress(player, "hallowed"));
                    stealthBar.setProgress(getSkillBarProgress(player, "annulled"));
                    skillBars.put(uuid, new BossBar[]{foragingBar, miningBar, fishingBar, cultivatingBar, craftingBar, cookingBar, acrobaticsBar, stealthBar,
                            soldierBar, marauderBar, assassinBar, cavalierBar, martialArtistBar, shieldHeroBar, marksmanBar, sorcererBar, primordialBar, hallowedBar, annulledBar});
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

                    if (player.hasMetadata("soldier bar")) {
                        skillBars.get(uuid)[8].addPlayer(player);
                    } else {
                        skillBars.get(uuid)[8].removePlayer(player);
                    }

                    if (player.hasMetadata("marauder bar")) {
                        skillBars.get(uuid)[9].addPlayer(player);
                    } else {
                        skillBars.get(uuid)[9].removePlayer(player);
                    }

                    if (player.hasMetadata("assassin bar")) {
                        skillBars.get(uuid)[10].addPlayer(player);
                    } else {
                        skillBars.get(uuid)[10].removePlayer(player);
                    }

                    if (player.hasMetadata("cavalier bar")) {
                        skillBars.get(uuid)[11].addPlayer(player);
                    } else {
                        skillBars.get(uuid)[11].removePlayer(player);
                    }

                    if (player.hasMetadata("martial artist bar")) {
                        skillBars.get(uuid)[12].addPlayer(player);
                    } else {
                        skillBars.get(uuid)[12].removePlayer(player);
                    }

                    if (player.hasMetadata("shield hero bar")) {
                        skillBars.get(uuid)[13].addPlayer(player);
                    } else {
                        skillBars.get(uuid)[13].removePlayer(player);
                    }

                    if (player.hasMetadata("marksman bar")) {
                        skillBars.get(uuid)[14].addPlayer(player);
                    } else {
                        skillBars.get(uuid)[14].removePlayer(player);
                    }

                    if (player.hasMetadata("sorcerer bar")) {
                        skillBars.get(uuid)[15].addPlayer(player);
                    } else {
                        skillBars.get(uuid)[15].removePlayer(player);
                    }

                    if (player.hasMetadata("primordial bar")) {
                        skillBars.get(uuid)[16].addPlayer(player);
                    } else {
                        skillBars.get(uuid)[16].removePlayer(player);
                    }

                    if (player.hasMetadata("hallowed bar")) {
                        skillBars.get(uuid)[17].addPlayer(player);
                    } else {
                        skillBars.get(uuid)[17].removePlayer(player);
                    }

                    if (player.hasMetadata("annulled bar")) {
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
            player.removeMetadata("foraging bar", nmlSkills);
            player.removeMetadata("mining bar", nmlSkills);
            player.removeMetadata("fishing bar", nmlSkills);
            player.removeMetadata("cultivating bar", nmlSkills);
            player.removeMetadata("crafting bar", nmlSkills);
            player.removeMetadata("cooking bar", nmlSkills);
            player.removeMetadata("acrobatics bar", nmlSkills);
            player.removeMetadata("stealth bar", nmlSkills);
            player.removeMetadata("soldier bar", nmlSkills);
            player.removeMetadata("marauder bar", nmlSkills);
            player.removeMetadata("assassin bar", nmlSkills);
            player.removeMetadata("cavalier bar", nmlSkills);
            player.removeMetadata("martial artist bar", nmlSkills);
            player.removeMetadata("shield hero bar", nmlSkills);
            player.removeMetadata("marksman bar", nmlSkills);
            player.removeMetadata("sorcerer bar", nmlSkills);
            player.removeMetadata("primordial bar", nmlSkills);
            player.removeMetadata("hallowed bar", nmlSkills);
            player.removeMetadata("annulled bar", nmlSkills);
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
            case "soldierexp" -> {
                BossBar soldierBar = skillBars.get(uuid)[8];

                soldierBar.setProgress(skills.getSoldierExp() / skills.getExp2LvlUpSoldier());
                player.setMetadata("soldier bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("soldier bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "marauderexp" -> {
                BossBar marauderBar = skillBars.get(uuid)[9];

                marauderBar.setProgress(skills.getMarauderExp() / skills.getExp2LvlUpMarauder());
                player.setMetadata("marauder bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("marauder bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "assassinexp" -> {
                BossBar assassinBar = skillBars.get(uuid)[10];

                assassinBar.setProgress(skills.getAssassinExp() / skills.getExp2LvlUpAssassin());
                player.setMetadata("assassin bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("assassin bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "cavalierexp" -> {
                BossBar cavalierBar = skillBars.get(uuid)[11];

                cavalierBar.setProgress(skills.getCavalierExp() / skills.getExp2LvlUpCavalier());
                player.setMetadata("cavalier bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("cavalier bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "martialartistexp" -> {
                BossBar maBar = skillBars.get(uuid)[12];

                maBar.setProgress(skills.getMartialArtistExp() / skills.getExp2LvlUpMartialArtist());
                player.setMetadata("martial artist bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("martial artist bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "shieldheroexp" -> {
                BossBar shBar = skillBars.get(uuid)[13];

                shBar.setProgress(skills.getShieldHeroExp() / skills.getExp2LvlUpShieldHero());
                player.setMetadata("shield hero bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("shield hero bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "marksmanexp" -> {
                BossBar marksmanBar = skillBars.get(uuid)[14];

                marksmanBar.setProgress(skills.getMarksmanExp() / skills.getExp2LvlUpMarksman());
                player.setMetadata("marksman bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("marksman bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "sorcererexp" -> {
                BossBar sorcererBar = skillBars.get(uuid)[15];

                sorcererBar.setProgress(skills.getSorcererExp() / skills.getExp2LvlUpSorcerer());
                player.setMetadata("sorcerer bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("sorcerer bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "hallowedexp" -> {
                BossBar hallowedBar = skillBars.get(uuid)[16];

                hallowedBar.setProgress(skills.getHallowedExp() / skills.getExp2LvlUpHallowed());
                player.setMetadata("hallowed bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("hallowed bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "annulledexp" -> {
                BossBar annulledBar = skillBars.get(uuid)[17];

                annulledBar.setProgress(skills.getAnnulledExp() / skills.getExp2LvlUpAnnulled());
                player.setMetadata("annulled bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("annulled bar", nmlSkills);
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
            case "soldier" -> {
                BossBar soldierBar = skillBars.get(uuid)[8];

                soldierBar.setTitle("Lvl. §b" + skills.getSoldierLevel() + "§r Soldier");
                player.setMetadata("soldier bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("soldier bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "marauder" -> {
                BossBar marauderBar = skillBars.get(uuid)[9];

                marauderBar.setTitle("Lvl. §b" + skills.getMarauderLevel() + "§r Marauder");
                player.setMetadata("marauder bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("marauder bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "assassin" -> {
                BossBar assassinBar = skillBars.get(uuid)[10];

                assassinBar.setTitle("Lvl. §b" + skills.getAssassinLevel() + "§r Assassin");
                player.setMetadata("assassin bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("assassin bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "cavalier" -> {
                BossBar cavalierBar = skillBars.get(uuid)[11];

                cavalierBar.setTitle("Lvl. §b" + skills.getCavalierLevel() + "§r Cavalier");
                player.setMetadata("cavalier bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("cavalier bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "martialartist" -> {
                BossBar maBar = skillBars.get(uuid)[12];

                maBar.setTitle("Lvl. §b" + skills.getMartialArtistLevel() + "§r Martial Artist");
                player.setMetadata("martial artist bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("martial artist bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "shieldhero" -> {
                BossBar shBar = skillBars.get(uuid)[13];

                shBar.setTitle("Lvl. §b" + skills.getShieldHeroLevel() + "§r Shield Hero");
                player.setMetadata("shield hero bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("shield hero bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "marksman" -> {
                BossBar marksmanBar = skillBars.get(uuid)[14];

                marksmanBar.setTitle("Lvl. §b" + skills.getMarksmanLevel() + "§r Marksman");
                player.setMetadata("marksman bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("marksman bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "sorcerer" -> {
                BossBar sorcererBar = skillBars.get(uuid)[15];

                sorcererBar.setTitle("Lvl. §b" + skills.getSorcererLevel() + "§r Sorcerer");
                player.setMetadata("sorcerer bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("sorcerer bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "hallowed" -> {
                BossBar hallowedBar = skillBars.get(uuid)[16];

                hallowedBar.setTitle("Lvl. §b" + skills.getHallowedLevel() + "§r Hallowed");
                player.setMetadata("hallowed bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("hallowed bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
            case "annulled" -> {
                BossBar annulledBar = skillBars.get(uuid)[17];

                annulledBar.setTitle("Lvl. §b" + skills.getAnnulledLevel() + "§r Annulled");
                player.setMetadata("annulled bar", new FixedMetadataValue(nmlSkills, true));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.removeMetadata("annulled bar", nmlSkills);
                    }
                }.runTaskLater(nmlSkills, 60);
            }
        }
    }
}
