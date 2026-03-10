package io.github.NoOne.nMLSkills.skillSystem;

import io.github.NoOne.nMLSkills.NMLSkills;
import io.github.NoOne.nMLSkills.skillSetSystem.SkillSetManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class SkillListener implements Listener {
    private SkillSetManager skillSetManager;

    public SkillListener(NMLSkills nmlSkills) {
        skillSetManager = nmlSkills.getSkillSetManager();
    }

    @EventHandler
    public void onSkillChange(SkillChangeEvent event) {
        Player player = event.getPlayer();
        String skill = event.getSkill();
        int time = event.getTime();

        skillSetManager.getSkillSet(player.getUniqueId()).getSkills().add2Skill(skill, event.getChange());

        switch (skill) {
            case "combat", "foraging", "mining", "fishing", "farming", "crafting", "cooking", "acrobatics", "stealth", "soldier", "marauder", "assassin", "cavalier",
                 "martialartist", "shieldhero", "marksman", "sorcerer", "primordial", "hallowed", "annulled" ->

                    SkillBars.updateSkillBarLevel(player, skill);
            case "combatexp", "foragingexp", "miningexp", "fishingexp", "farmingexp", "craftingexp", "cookingexp", "acrobaticsexp", "stealthexp", "soldierexp",
                 "marauderexp", "assassinexp", "cavalierexp", "martialartistexp", "shieldheroexp", "marksmanexp", "sorcererexp", "primordialexp", "hallowedexp",
                 "annulledexp" -> {

                // todo: come back to this later
//                if (time > 0) {
//                    SkillBars.updateSkillBarProgressOverTime(player, skill, event.getChange(), time);
//                } else {
//                    SkillBars.updateSkillBarProgress(player, skill);
//                }

                SkillBars.updateSkillBarProgress(player, skill);
            }
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (!SkillBars.getSkillBars().containsKey(player.getUniqueId())) {
            SkillBars.createSkillBars(player);
        }
    }
}