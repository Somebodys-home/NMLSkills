package io.github.NoOne.nMLSkills.skillSystem;

import io.github.NoOne.nMLSkills.NMLSkills;
import io.github.NoOne.nMLSkills.skillSetSystem.SkillSetManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class SkillListener implements Listener {
    private SkillSetManager skillSetManager;

    public SkillListener(NMLSkills nmlSkills) {
        skillSetManager = nmlSkills.getSkillSetManager();
    }

    @EventHandler
    public void resetStats(ResetSkillsEvent event) {
        Player player = event.getPlayer();
        skillSetManager.saveASkillSetToConfig(player);
    }

    @EventHandler
    public void updateSkillBar(SkillChangeEvent event) {
        switch (event.getStat()) {
            case "combat", "foraging", "mining", "fishing", "cultivating", "crafting", "cooking", "acrobatics", "stealth", "soldier", "marauder", "assassin", "cavalier",
                 "martialartist", "shieldhero", "marksman", "sorcerer", "primordial", "hallowed", "annulled" ->
                    SkillBars.updateSkillBarLevel(event.getPlayer(), event.getStat());
            case "combatexp", "foragingexp", "miningexp", "fishingexp", "cultivatingexp", "craftingexp", "cookingexp", "acrobaticsexp", "stealthexp", "soldierexp",
                 "marauderexp", "assassinexp", "cavalierexp", "martialartistexp", "shieldheroexp", "marksmanexp", "sorcererexp", "primordialexp", "hallowedexp", "annulledexp" ->
                    SkillBars.updateSkillBarProgress(event.getPlayer(), event.getStat());
        }
    }
}