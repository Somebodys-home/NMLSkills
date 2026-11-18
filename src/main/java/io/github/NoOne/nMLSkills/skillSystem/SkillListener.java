package io.github.NoOne.nMLSkills.skillSystem;

import com.destroystokyo.paper.event.player.PlayerPickupExperienceEvent;
import io.github.NoOne.nMLSkills.NMLSkills;
import io.github.NoOne.nMLSkills.saveSkillsSystem.SaveSkillsManager;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class SkillListener implements Listener {
    private SaveSkillsManager saveSkillsManager;

    public SkillListener(NMLSkills nmlSkills) {
        saveSkillsManager = nmlSkills.getSaveSkillsManager();
    }

    @EventHandler
    public void onSkillChange(SkillChangeEvent event) {
        Player player = event.getPlayer();
        Skill skill = event.getSkill();
        Skills skills = saveSkillsManager.getSkills(player.getUniqueId());
        int ticks = event.getTicks();

        if (event.isExpChange()) {
            skills.addToSkillExp(skill, event.getChange());

            if (ticks > 0 && skill != Skill.COMBAT) {
                //SkillBars.updateSkillBarProgressOverTime(player, skill, event.getChange(), ticks);
            } else {
                SkillBars.updateSkillBarProgress(player, skill);
            }
        } else {
            SkillBars.updateSkillBarLevel(player, skill);
            skills.addToSkillLevel(skill, (int) event.getChange());
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (!saveSkillsManager.hasSavedSkills(player)) saveSkillsManager.createNewbieSkills(player);
        if (!SkillBars.getSkillBars().containsKey(player.getUniqueId())) SkillBars.createSkillBars(player);
    }

    @EventHandler
    public void dontPickupExperience(PlayerPickupExperienceEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void dontSpawnExperience(EntitySpawnEvent event) {
        if (event.getEntity() instanceof ExperienceOrb) {
            event.setCancelled(true);
        }
    }
}