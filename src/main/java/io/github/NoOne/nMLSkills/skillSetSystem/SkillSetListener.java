package io.github.NoOne.nMLSkills.skillProfileSystem;

import io.github.NoOne.nMLSkills.NMLSkills;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class SkillSetListener implements Listener {
    private SkillSetManager skillSetManager;

    public SkillSetListener(NMLSkills nmlSkills) {
        skillSetManager = nmlSkills.getSkillProfileManager();
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        SkillSet skillSet = skillSetManager.getPlayerProfile(player.getUniqueId());
        
        if (skillSet == null) {
            skillSetManager.createNewbieProfile(player);
        }
    }
}
